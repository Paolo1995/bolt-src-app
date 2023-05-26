package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AFb1qSDK {
    public final int AFInAppEventParameterName;
    public final int AFInAppEventType;
    public final long valueOf;
    public final String values;

    public AFb1qSDK() {
    }

    public AFb1qSDK(String str, int i8, int i9, long j8) {
        this.values = str;
        this.AFInAppEventParameterName = i8;
        this.AFInAppEventType = i9;
        this.valueOf = j8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject values(String str) {
        JSONObject AFInAppEventParameterName = AFa1oSDK.AFInAppEventParameterName(str);
        if (AFInAppEventParameterName != null) {
            try {
                boolean z7 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
                boolean optBoolean = AFInAppEventParameterName.optBoolean("monitor", false);
                AFb1sSDK afErrorLogForExcManagerOnly = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly();
                if (optBoolean && !z7) {
                    afErrorLogForExcManagerOnly.AFInAppEventParameterName();
                } else {
                    afErrorLogForExcManagerOnly.AFInAppEventType();
                    afErrorLogForExcManagerOnly.values();
                }
                if (AFInAppEventParameterName.has("ol_id")) {
                    String optString = AFInAppEventParameterName.optString("ol_scheme", null);
                    String optString2 = AFInAppEventParameterName.optString("ol_domain", null);
                    String optString3 = AFInAppEventParameterName.optString("ol_ver", null);
                    if (optString != null) {
                        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_SCHEME, optString);
                    }
                    if (optString2 != null) {
                        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_DOMAIN, optString2);
                    }
                    if (optString3 != null) {
                        AppsFlyerProperties.getInstance().set("onelinkVersion", optString3);
                    }
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("Error in handleResponse: ");
                sb.append(th.getMessage());
                AFLogger.afErrorLogForExcManagerOnly(sb.toString(), th);
                AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType();
                AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly().values();
            }
        }
        return AFInAppEventParameterName;
    }

    public final String AFInAppEventType() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_ver", this.values);
            jSONObject.put("min", this.AFInAppEventParameterName);
            jSONObject.put("expire", this.AFInAppEventType);
            jSONObject.put("ttl", this.valueOf);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public final int hashCode() {
        int i8;
        String str = this.values;
        if (str != null) {
            i8 = str.hashCode();
        } else {
            i8 = 0;
        }
        return (((((i8 * 31) + this.AFInAppEventParameterName) * 31) + this.AFInAppEventType) * 31) + ((int) this.valueOf);
    }
}
