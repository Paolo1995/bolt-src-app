package com.appsflyer.internal;

import android.content.pm.PackageItemInfo;
import android.os.Bundle;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;

/* loaded from: classes.dex */
public final class AFc1zSDK {
    private static String AFInAppEventParameterName = "233";
    public final AFc1sSDK AFKeystoreWrapper;
    public final AFc1ySDK valueOf;
    private Bundle values = null;

    public AFc1zSDK(AFc1sSDK aFc1sSDK, AFc1ySDK aFc1ySDK) {
        this.AFKeystoreWrapper = aFc1sSDK;
        this.valueOf = aFc1ySDK;
    }

    public static String values() {
        return AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
    }

    public final String AFInAppEventType(String str) {
        Object obj;
        try {
            if (this.values == null) {
                this.values = ((PackageItemInfo) this.AFKeystoreWrapper.AFKeystoreWrapper.getPackageManager().getApplicationInfo(this.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName(), 128)).metaData;
            }
            Bundle bundle = this.values;
            if (bundle == null || (obj = bundle.get(str)) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Could not load manifest metadata!");
            sb.append(th.getMessage());
            AFLogger.afErrorLog(sb.toString(), th);
            return null;
        }
    }

    public final boolean valueOf(String str) {
        String AFInAppEventType = AFInAppEventType(str);
        if (AFInAppEventType != null) {
            return Boolean.parseBoolean(AFInAppEventType);
        }
        return false;
    }

    public static String valueOf() {
        StringBuilder sb = new StringBuilder("version: 6.10.2 (build ");
        sb.append(AFInAppEventParameterName);
        sb.append(")");
        return sb.toString();
    }

    public final String AFInAppEventType() {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.CHANNEL);
        if (string == null) {
            string = AFInAppEventType("CHANNEL");
        }
        if (string == null || !string.equals("")) {
            return string;
        }
        return null;
    }
}
