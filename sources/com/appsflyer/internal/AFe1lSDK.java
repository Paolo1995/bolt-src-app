package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.FirebaseMessagingServiceListener;
import com.appsflyer.internal.AFd1sSDK;

/* loaded from: classes.dex */
public final class AFe1lSDK {
    public static String values;
    public final AFc1ySDK valueOf;

    static {
        StringBuilder sb = new StringBuilder("https://%sregister.%s/api/v");
        sb.append(AFb1xSDK.AFInAppEventParameterName);
        values = sb.toString();
    }

    public AFe1lSDK(@NonNull Context context) {
        this.valueOf = AFb1xSDK.AFInAppEventType().AFInAppEventType(context);
    }

    public static boolean AFKeystoreWrapper(@NonNull SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean("sentRegisterRequestToAF", false);
    }

    public static boolean values(Context context) {
        if (AppsFlyerLib.getInstance().isStopped()) {
            return false;
        }
        try {
            Class.forName("com.google.firebase.messaging.FirebaseMessagingService");
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to verify manifest declarations: ", th);
        }
        if (!AFa1cSDK.values(context, new Intent("com.google.firebase.MESSAGING_EVENT", null, context, FirebaseMessagingServiceListener.class))) {
            return false;
        }
        return true;
    }

    public static void AFKeystoreWrapper(String str) {
        AFc1vSDK AFKeystoreWrapper = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper();
        AFd1dSDK aFd1dSDK = new AFd1dSDK(str, AFKeystoreWrapper);
        AFd1sSDK afDebugLog = AFKeystoreWrapper.afDebugLog();
        afDebugLog.AFInAppEventType.execute(new AFd1sSDK.AnonymousClass3(aFd1dSDK));
    }

    public final AFb1uSDK AFKeystoreWrapper() {
        String string;
        String string2;
        String values2 = this.valueOf.values("afUninstallToken", null);
        long AFInAppEventParameterName = this.valueOf.AFInAppEventParameterName("afUninstallToken_received_time", 0L);
        boolean AFKeystoreWrapper = this.valueOf.AFKeystoreWrapper("afUninstallToken_queued");
        this.valueOf.AFInAppEventType("afUninstallToken_queued", false);
        if (values2 == null && (string2 = AppsFlyerProperties.getInstance().getString("afUninstallToken")) != null) {
            String[] split = string2.split(",");
            values2 = split[split.length - 1];
        }
        if (AFInAppEventParameterName == 0 && (string = AppsFlyerProperties.getInstance().getString("afUninstallToken")) != null) {
            String[] split2 = string.split(",");
            if (split2.length >= 2) {
                try {
                    AFInAppEventParameterName = Long.parseLong(split2[split2.length - 2]);
                } catch (NumberFormatException unused) {
                }
            }
        }
        if (values2 != null) {
            return new AFb1uSDK(values2, AFInAppEventParameterName, AFKeystoreWrapper);
        }
        return null;
    }
}
