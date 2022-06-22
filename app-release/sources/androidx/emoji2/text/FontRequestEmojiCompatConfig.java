package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {
    private static final FontProviderHelper DEFAULT_FONTS_CONTRACT = new FontProviderHelper();

    public static abstract class RetryPolicy {
        public abstract long getRetryDelay();
    }

    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {
        private long mRetryOrigin;
        private final long mTotalMs;

        public ExponentialBackoffRetryPolicy(long j) {
            this.mTotalMs = j;
        }

        public long getRetryDelay() {
            if (this.mRetryOrigin == 0) {
                this.mRetryOrigin = SystemClock.uptimeMillis();
                return 0;
            }
            long uptimeMillis = SystemClock.uptimeMillis() - this.mRetryOrigin;
            if (uptimeMillis > this.mTotalMs) {
                return -1;
            }
            return Math.min(Math.max(uptimeMillis, 1000), this.mTotalMs - uptimeMillis);
        }
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest) {
        super(new FontRequestMetadataLoader(context, fontRequest, DEFAULT_FONTS_CONTRACT));
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
        super(new FontRequestMetadataLoader(context, fontRequest, fontProviderHelper));
    }

    public FontRequestEmojiCompatConfig setLoadingExecutor(Executor executor) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setExecutor(executor);
        return this;
    }

    @Deprecated
    public FontRequestEmojiCompatConfig setHandler(Handler handler) {
        if (handler == null) {
            return this;
        }
        setLoadingExecutor(ConcurrencyHelpers.convertHandlerToExecutor(handler));
        return this;
    }

    public FontRequestEmojiCompatConfig setRetryPolicy(RetryPolicy retryPolicy) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setRetryPolicy(retryPolicy);
        return this;
    }

    private static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        private static final String S_TRACE_BUILD_TYPEFACE = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface";
        EmojiCompat.MetadataRepoLoaderCallback mCallback;
        private final Context mContext;
        private Executor mExecutor;
        private final FontProviderHelper mFontProviderHelper;
        private final Object mLock = new Object();
        private Handler mMainHandler;
        private Runnable mMainHandlerLoadCallback;
        private ThreadPoolExecutor mMyThreadPoolExecutor;
        private ContentObserver mObserver;
        private final FontRequest mRequest;
        private RetryPolicy mRetryPolicy;

        FontRequestMetadataLoader(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
            Preconditions.checkNotNull(context, "Context cannot be null");
            Preconditions.checkNotNull(fontRequest, "FontRequest cannot be null");
            this.mContext = context.getApplicationContext();
            this.mRequest = fontRequest;
            this.mFontProviderHelper = fontProviderHelper;
        }

        public void setExecutor(Executor executor) {
            synchronized (this.mLock) {
                this.mExecutor = executor;
            }
        }

        public void setRetryPolicy(RetryPolicy retryPolicy) {
            synchronized (this.mLock) {
                this.mRetryPolicy = retryPolicy;
            }
        }

        public void load(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.checkNotNull(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            synchronized (this.mLock) {
                this.mCallback = metadataRepoLoaderCallback;
            }
            loadInternal();
        }

        /* access modifiers changed from: package-private */
        public void loadInternal() {
            synchronized (this.mLock) {
                if (this.mCallback != null) {
                    if (this.mExecutor == null) {
                        ThreadPoolExecutor createBackgroundPriorityExecutor = ConcurrencyHelpers.createBackgroundPriorityExecutor("emojiCompat");
                        this.mMyThreadPoolExecutor = createBackgroundPriorityExecutor;
                        this.mExecutor = createBackgroundPriorityExecutor;
                    }
                    this.mExecutor.execute(new Runnable() {
                        public final void run() {
                            FontRequestEmojiCompatConfig.FontRequestMetadataLoader.this.createMetadata();
                        }
                    });
                }
            }
        }

        private FontsContractCompat.FontInfo retrieveFontInfo() {
            try {
                FontsContractCompat.FontFamilyResult fetchFonts = this.mFontProviderHelper.fetchFonts(this.mContext, this.mRequest);
                if (fetchFonts.getStatusCode() == 0) {
                    FontsContractCompat.FontInfo[] fonts = fetchFonts.getFonts();
                    if (fonts != null && fonts.length != 0) {
                        return fonts[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                throw new RuntimeException("fetchFonts failed (" + fetchFonts.getStatusCode() + ")");
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }

        private void scheduleRetry(Uri uri, long j) {
            synchronized (this.mLock) {
                Handler handler = this.mMainHandler;
                if (handler == null) {
                    handler = ConcurrencyHelpers.mainHandlerAsync();
                    this.mMainHandler = handler;
                }
                if (this.mObserver == null) {
                    C02731 r2 = new ContentObserver(handler) {
                        public void onChange(boolean z, Uri uri) {
                            FontRequestMetadataLoader.this.loadInternal();
                        }
                    };
                    this.mObserver = r2;
                    this.mFontProviderHelper.registerObserver(this.mContext, uri, r2);
                }
                if (this.mMainHandlerLoadCallback == null) {
                    this.mMainHandlerLoadCallback = new Runnable() {
                        public final void run() {
                            FontRequestEmojiCompatConfig.FontRequestMetadataLoader.this.loadInternal();
                        }
                    };
                }
                handler.postDelayed(this.mMainHandlerLoadCallback, j);
            }
        }

        private void cleanUp() {
            synchronized (this.mLock) {
                this.mCallback = null;
                if (this.mObserver != null) {
                    this.mFontProviderHelper.unregisterObserver(this.mContext, this.mObserver);
                    this.mObserver = null;
                }
                if (this.mMainHandler != null) {
                    this.mMainHandler.removeCallbacks(this.mMainHandlerLoadCallback);
                }
                this.mMainHandler = null;
                if (this.mMyThreadPoolExecutor != null) {
                    this.mMyThreadPoolExecutor.shutdown();
                }
                this.mExecutor = null;
                this.mMyThreadPoolExecutor = null;
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
            if (r1 != 2) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
            r2 = r8.mLock;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001a, code lost:
            if (r8.mRetryPolicy == null) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001c, code lost:
            r3 = r8.mRetryPolicy.getRetryDelay();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
            if (r3 < 0) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
            scheduleRetry(r0.getUri(), r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0036, code lost:
            if (r1 != 0) goto L_0x007c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            androidx.core.p003os.TraceCompat.beginSection(S_TRACE_BUILD_TYPEFACE);
            r1 = r8.mFontProviderHelper.buildTypeface(r8.mContext, r0);
            r0 = androidx.core.graphics.TypefaceCompatUtil.mmap(r8.mContext, (android.os.CancellationSignal) null, r0.getUri());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0050, code lost:
            if (r0 == null) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0052, code lost:
            if (r1 == null) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0054, code lost:
            r0 = androidx.emoji2.text.MetadataRepo.create(r1, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            androidx.core.p003os.TraceCompat.endSection();
            r1 = r8.mLock;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x005d, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0060, code lost:
            if (r8.mCallback == null) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0062, code lost:
            r8.mCallback.onLoaded(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0067, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            cleanUp();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0076, code lost:
            throw new java.lang.RuntimeException("Unable to open file.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0077, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            androidx.core.p003os.TraceCompat.endSection();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x007b, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0097, code lost:
            throw new java.lang.RuntimeException("fetchFonts result is not OK. (" + r1 + ")");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0098, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x009b, code lost:
            monitor-enter(r8.mLock);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x009e, code lost:
            if (r8.mCallback != null) goto L_0x00a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00a0, code lost:
            r8.mCallback.onFailed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00a6, code lost:
            cleanUp();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            r0 = retrieveFontInfo();
            r1 = r0.getResultCode();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void createMetadata() {
            /*
                r8 = this;
                java.lang.Object r0 = r8.mLock
                monitor-enter(r0)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r1 = r8.mCallback     // Catch:{ all -> 0x00ad }
                if (r1 != 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x00ad }
                return
            L_0x0009:
                monitor-exit(r0)     // Catch:{ all -> 0x00ad }
                androidx.core.provider.FontsContractCompat$FontInfo r0 = r8.retrieveFontInfo()     // Catch:{ all -> 0x0098 }
                int r1 = r0.getResultCode()     // Catch:{ all -> 0x0098 }
                r2 = 2
                if (r1 != r2) goto L_0x0036
                java.lang.Object r2 = r8.mLock     // Catch:{ all -> 0x0098 }
                monitor-enter(r2)     // Catch:{ all -> 0x0098 }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$RetryPolicy r3 = r8.mRetryPolicy     // Catch:{ all -> 0x0033 }
                if (r3 == 0) goto L_0x0031
                androidx.emoji2.text.FontRequestEmojiCompatConfig$RetryPolicy r3 = r8.mRetryPolicy     // Catch:{ all -> 0x0033 }
                long r3 = r3.getRetryDelay()     // Catch:{ all -> 0x0033 }
                r5 = 0
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 < 0) goto L_0x0031
                android.net.Uri r0 = r0.getUri()     // Catch:{ all -> 0x0033 }
                r8.scheduleRetry(r0, r3)     // Catch:{ all -> 0x0033 }
                monitor-exit(r2)     // Catch:{ all -> 0x0033 }
                return
            L_0x0031:
                monitor-exit(r2)     // Catch:{ all -> 0x0033 }
                goto L_0x0036
            L_0x0033:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0033 }
                throw r0     // Catch:{ all -> 0x0098 }
            L_0x0036:
                if (r1 != 0) goto L_0x007c
                java.lang.String r1 = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface"
                androidx.core.p003os.TraceCompat.beginSection(r1)     // Catch:{ all -> 0x0077 }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$FontProviderHelper r1 = r8.mFontProviderHelper     // Catch:{ all -> 0x0077 }
                android.content.Context r2 = r8.mContext     // Catch:{ all -> 0x0077 }
                android.graphics.Typeface r1 = r1.buildTypeface(r2, r0)     // Catch:{ all -> 0x0077 }
                android.content.Context r2 = r8.mContext     // Catch:{ all -> 0x0077 }
                r3 = 0
                android.net.Uri r0 = r0.getUri()     // Catch:{ all -> 0x0077 }
                java.nio.ByteBuffer r0 = androidx.core.graphics.TypefaceCompatUtil.mmap(r2, r3, r0)     // Catch:{ all -> 0x0077 }
                if (r0 == 0) goto L_0x006f
                if (r1 == 0) goto L_0x006f
                androidx.emoji2.text.MetadataRepo r0 = androidx.emoji2.text.MetadataRepo.create((android.graphics.Typeface) r1, (java.nio.ByteBuffer) r0)     // Catch:{ all -> 0x0077 }
                androidx.core.p003os.TraceCompat.endSection()     // Catch:{ all -> 0x0098 }
                java.lang.Object r1 = r8.mLock     // Catch:{ all -> 0x0098 }
                monitor-enter(r1)     // Catch:{ all -> 0x0098 }
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r8.mCallback     // Catch:{ all -> 0x006c }
                if (r2 == 0) goto L_0x0067
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r8.mCallback     // Catch:{ all -> 0x006c }
                r2.onLoaded(r0)     // Catch:{ all -> 0x006c }
            L_0x0067:
                monitor-exit(r1)     // Catch:{ all -> 0x006c }
                r8.cleanUp()     // Catch:{ all -> 0x0098 }
                goto L_0x00a9
            L_0x006c:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x006c }
                throw r0     // Catch:{ all -> 0x0098 }
            L_0x006f:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0077 }
                java.lang.String r1 = "Unable to open file."
                r0.<init>(r1)     // Catch:{ all -> 0x0077 }
                throw r0     // Catch:{ all -> 0x0077 }
            L_0x0077:
                r0 = move-exception
                androidx.core.p003os.TraceCompat.endSection()     // Catch:{ all -> 0x0098 }
                throw r0     // Catch:{ all -> 0x0098 }
            L_0x007c:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0098 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
                r2.<init>()     // Catch:{ all -> 0x0098 }
                java.lang.String r3 = "fetchFonts result is not OK. ("
                r2.append(r3)     // Catch:{ all -> 0x0098 }
                r2.append(r1)     // Catch:{ all -> 0x0098 }
                java.lang.String r1 = ")"
                r2.append(r1)     // Catch:{ all -> 0x0098 }
                java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0098 }
                r0.<init>(r1)     // Catch:{ all -> 0x0098 }
                throw r0     // Catch:{ all -> 0x0098 }
            L_0x0098:
                r0 = move-exception
                java.lang.Object r1 = r8.mLock
                monitor-enter(r1)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r8.mCallback     // Catch:{ all -> 0x00aa }
                if (r2 == 0) goto L_0x00a5
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r8.mCallback     // Catch:{ all -> 0x00aa }
                r2.onFailed(r0)     // Catch:{ all -> 0x00aa }
            L_0x00a5:
                monitor-exit(r1)     // Catch:{ all -> 0x00aa }
                r8.cleanUp()
            L_0x00a9:
                return
            L_0x00aa:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00aa }
                throw r0
            L_0x00ad:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00ad }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.createMetadata():void");
        }
    }

    public static class FontProviderHelper {
        public FontsContractCompat.FontFamilyResult fetchFonts(Context context, FontRequest fontRequest) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.fetchFonts(context, (CancellationSignal) null, fontRequest);
        }

        public Typeface buildTypeface(Context context, FontsContractCompat.FontInfo fontInfo) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.buildTypeface(context, (CancellationSignal) null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        public void registerObserver(Context context, Uri uri, ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void unregisterObserver(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }
}
