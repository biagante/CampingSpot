package com.android.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.DiskBasedCache;
import java.io.File;

public class Volley {
    private static final String DEFAULT_CACHE_DIR = "volley";

    public static RequestQueue newRequestQueue(Context context, BaseHttpStack baseHttpStack) {
        BasicNetwork basicNetwork;
        BasicNetwork basicNetwork2;
        String str;
        if (baseHttpStack != null) {
            basicNetwork2 = new BasicNetwork(baseHttpStack);
        } else if (Build.VERSION.SDK_INT >= 9) {
            basicNetwork = new BasicNetwork((BaseHttpStack) new HurlStack());
            return newRequestQueue(context, (Network) basicNetwork);
        } else {
            try {
                String packageName = context.getPackageName();
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                str = packageName + "/" + packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                str = "volley/0";
            }
            basicNetwork2 = new BasicNetwork((HttpStack) new HttpClientStack(AndroidHttpClient.newInstance(str)));
        }
        basicNetwork = basicNetwork2;
        return newRequestQueue(context, (Network) basicNetwork);
    }

    @Deprecated
    public static RequestQueue newRequestQueue(Context context, HttpStack httpStack) {
        if (httpStack == null) {
            return newRequestQueue(context, (BaseHttpStack) null);
        }
        return newRequestQueue(context, (Network) new BasicNetwork(httpStack));
    }

    private static RequestQueue newRequestQueue(Context context, Network network) {
        final Context applicationContext = context.getApplicationContext();
        RequestQueue requestQueue = new RequestQueue(new DiskBasedCache((DiskBasedCache.FileSupplier) new DiskBasedCache.FileSupplier() {
            private File cacheDir = null;

            public File get() {
                if (this.cacheDir == null) {
                    this.cacheDir = new File(applicationContext.getCacheDir(), Volley.DEFAULT_CACHE_DIR);
                }
                return this.cacheDir;
            }
        }), network);
        requestQueue.start();
        return requestQueue;
    }

    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, (BaseHttpStack) null);
    }
}
