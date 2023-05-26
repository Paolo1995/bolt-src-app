package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkResult;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class AFb1nSDK {
    public final double values;

    public AFb1nSDK() {
    }

    public AFb1nSDK(double d8) {
        this.values = d8;
    }

    private static void AFInAppEventType(Map<String, String> map) {
        if (AFb1xSDK.AFInAppEventType != null) {
            try {
                StringBuilder sb = new StringBuilder("Calling onAppOpenAttribution with:\n");
                sb.append(map.toString());
                AFLogger.afDebugLog(sb.toString());
                AFb1xSDK.AFInAppEventType.onAppOpenAttribution(map);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    public static void AFKeystoreWrapper(Map<String, String> map) {
        DeepLinkResult deepLinkResult;
        if (AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().onInstallConversionDataLoadedNative().valueOf != null) {
            try {
                try {
                    DeepLink values = DeepLink.values(map);
                    values.values.put("is_deferred", false);
                    deepLinkResult = new DeepLinkResult(values, null);
                } catch (JSONException e8) {
                    AFLogger.afErrorLog("[DDL] Error occurred", e8, true);
                    deepLinkResult = new DeepLinkResult(null, DeepLinkResult.Error.UNEXPECTED);
                }
                AFInAppEventType(deepLinkResult);
                return;
            } catch (Throwable th) {
                AFInAppEventType(new DeepLinkResult(null, null));
                throw th;
            }
        }
        AFInAppEventType(map);
    }

    private static void AFInAppEventType(String str) {
        if (AFb1xSDK.AFInAppEventType != null) {
            try {
                AFLogger.afDebugLog("Calling onAppOpenAttributionFailure with: ".concat(String.valueOf(str)));
                AFb1xSDK.AFInAppEventType.onAttributionFailure(str);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    public static void AFInAppEventType(String str, DeepLinkResult.Error error) {
        if (AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().onInstallConversionDataLoadedNative().valueOf != null) {
            AFLogger.afDebugLog("[DDL] Error occurred: ".concat(String.valueOf(str)));
            AFInAppEventType(new DeepLinkResult(null, error));
            return;
        }
        AFInAppEventType(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void AFInAppEventType(DeepLinkResult deepLinkResult) {
        AFa1tSDK onInstallConversionDataLoadedNative = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().onInstallConversionDataLoadedNative();
        if (onInstallConversionDataLoadedNative.valueOf != null) {
            StringBuilder sb = new StringBuilder("[DDL] Calling onDeepLinking with:\n");
            sb.append(deepLinkResult.toString());
            AFLogger.afDebugLog(sb.toString());
            try {
                onInstallConversionDataLoadedNative.valueOf.onDeepLinking(deepLinkResult);
                return;
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
                return;
            }
        }
        AFLogger.afDebugLog("[DDL] skipping, no callback registered");
    }
}
