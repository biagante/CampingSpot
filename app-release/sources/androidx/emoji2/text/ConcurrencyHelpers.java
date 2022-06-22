package androidx.emoji2.text;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ConcurrencyHelpers {
    private static final int FONT_LOAD_TIMEOUT_SECONDS = 15;

    private ConcurrencyHelpers() {
    }

    static ThreadPoolExecutor createBackgroundPriorityExecutor(String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactory(str) {
            public final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Thread newThread(Runnable runnable) {
                return ConcurrencyHelpers.lambda$createBackgroundPriorityExecutor$0(this.f$0, runnable);
            }
        });
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static /* synthetic */ Thread lambda$createBackgroundPriorityExecutor$0(String str, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setPriority(10);
        return thread;
    }

    static Handler mainHandlerAsync() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler28Impl.createAsync(Looper.getMainLooper());
        }
        return new Handler(Looper.getMainLooper());
    }

    @Deprecated
    static Executor convertHandlerToExecutor(Handler handler) {
        Objects.requireNonNull(handler);
        return new Executor(handler) {
            public final /* synthetic */ Handler f$0;

            {
                this.f$0 = r1;
            }

            public final void execute(Runnable runnable) {
                this.f$0.post(runnable);
            }
        };
    }

    static class Handler28Impl {
        private Handler28Impl() {
        }

        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }
}
