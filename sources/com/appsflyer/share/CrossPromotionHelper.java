package com.appsflyer.share;

import android.content.Context;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFb1xSDK;
import com.appsflyer.internal.AFc1vSDK;
import com.appsflyer.internal.AFd1lSDK;
import com.appsflyer.internal.AFd1sSDK;
import com.appsflyer.internal.AFe1oSDK;
import com.appsflyer.internal.AFf1bSDK;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class CrossPromotionHelper {
    private static String values = "https://%simpression.%s";

    @NonNull
    private static LinkGenerator AFInAppEventType(@NonNull Context context, String str, String str2, Map<String, String> map, String str3) {
        LinkGenerator linkGenerator = new LinkGenerator("af_cross_promotion");
        linkGenerator.AFInAppEventParameterName = str3;
        linkGenerator.valueOf = str;
        linkGenerator.addParameter("af_siteid", context.getPackageName());
        if (str2 != null) {
            linkGenerator.setCampaign(str2);
        }
        if (map != null) {
            linkGenerator.addParameters(map);
        }
        String string = AppsFlyerProperties.getInstance().getString("advertiserId");
        if (string != null) {
            linkGenerator.addParameter("advertising_id", string);
        }
        return linkGenerator;
    }

    public static void logAndOpenStore(@NonNull Context context, String str, String str2) {
        logAndOpenStore(context, str, str2, null);
    }

    public static void logCrossPromoteImpression(@NonNull Context context, String str, String str2) {
        logCrossPromoteImpression(context, str, str2, null);
    }

    public static void setUrl(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();
            char c8 = 65535;
            int hashCode = key.hashCode();
            if (hashCode != 96801) {
                if (hashCode == 120623625 && key.equals("impression")) {
                    c8 = 1;
                }
            } else if (key.equals("app")) {
                c8 = 0;
            }
            if (c8 != 0) {
                if (c8 == 1) {
                    values = value;
                }
            } else {
                AFf1bSDK.valueOf = value;
            }
        }
    }

    private static void values(@NonNull String str, @NonNull Context context, AFe1oSDK aFe1oSDK) {
        AFb1xSDK AFInAppEventType = AFb1xSDK.AFInAppEventType();
        AFInAppEventType.values(context);
        AFc1vSDK AFKeystoreWrapper = AFInAppEventType.AFKeystoreWrapper();
        AFd1lSDK aFd1lSDK = new AFd1lSDK(AFKeystoreWrapper, str, aFe1oSDK);
        AFd1sSDK afDebugLog = AFKeystoreWrapper.afDebugLog();
        afDebugLog.AFInAppEventType.execute(new AFd1sSDK.AnonymousClass3(aFd1lSDK));
    }

    public static void logAndOpenStore(@NonNull Context context, String str, String str2, Map<String, String> map) {
        LinkGenerator AFInAppEventType = AFInAppEventType(context, str, str2, map, String.format(AFf1bSDK.valueOf, AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()));
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, track And Open Store is disabled", true);
        } else if (AppsFlyerLib.getInstance().isStopped()) {
            AFLogger.afInfoLog("SDK is stopped, track And Open Store is disabled", true);
        } else {
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("af_campaign", str2);
            AppsFlyerLib.getInstance().logEvent(context, "af_cross_promotion", map);
            values(AFInAppEventType.generateLink(), context, new AFe1oSDK(context));
        }
    }

    public static void logCrossPromoteImpression(@NonNull Context context, String str, String str2, Map<String, String> map) {
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, Promote Impression is disabled", true);
        } else if (AppsFlyerLib.getInstance().isStopped()) {
            AFLogger.afInfoLog("SDK is stopped, Promote Impression is disabled", true);
        } else {
            values(AFInAppEventType(context, str, str2, map, String.format(values, AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName())).generateLink(), context, null);
        }
    }
}
