package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
public final class AFe1oSDK {
    public String AFKeystoreWrapper;
    public final WeakReference<Context> valueOf;

    public AFe1oSDK() {
    }

    public AFe1oSDK(Context context) {
        this.valueOf = new WeakReference<>(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void AFInAppEventParameterName(Map<String, Object> map) {
        if (AFb1xSDK.AFInAppEventType != null) {
            StringBuilder sb = new StringBuilder("[GCD-A02] Calling onConversionDataSuccess with:\n");
            sb.append(map.toString());
            AFLogger.afDebugLog(sb.toString());
            AFb1xSDK.AFInAppEventType.onConversionDataSuccess(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void valueOf(String str) {
        if (AFb1xSDK.AFInAppEventType != null) {
            AFLogger.afDebugLog("[GCD-A02] Calling onConversionFailure with:\n".concat(String.valueOf(str)));
            AFb1xSDK.AFInAppEventType.onConversionDataFail(str);
        }
    }
}
