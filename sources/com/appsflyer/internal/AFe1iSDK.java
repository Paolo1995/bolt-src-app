package com.appsflyer.internal;

import android.content.Context;
import android.os.Build;
import com.appsflyer.AFLogger;

/* loaded from: classes.dex */
public class AFe1iSDK {
    public static boolean valueOf(Context context) {
        boolean isInstantApp;
        if (Build.VERSION.SDK_INT >= 26) {
            isInstantApp = context.getPackageManager().isInstantApp();
            return isInstantApp;
        }
        try {
            context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
            return true;
        } catch (ClassNotFoundException e8) {
            AFLogger.afErrorLogForExcManagerOnly("InstantAppsRuntime not found", e8, true);
            return false;
        }
    }
}
