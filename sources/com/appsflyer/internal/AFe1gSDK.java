package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class AFe1gSDK extends AFd1pSDK<Void> {
    private final AFd1zSDK<String> AFLogger;
    private final AFc1ySDK afErrorLog;
    private final Throwable afInfoLog;

    public AFe1gSDK(AFd1aSDK aFd1aSDK, AFc1ySDK aFc1ySDK) {
        super(AFd1rSDK.GCDSDK, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, "GCD-CHECK");
        this.afInfoLog = aFd1aSDK.afInfoLog();
        this.AFLogger = aFd1aSDK.afErrorLog;
        this.afErrorLog = aFc1ySDK;
    }

    private Map<String, Object> AFLogger() {
        String values = this.afErrorLog.values("attributionId", null);
        if (values == null) {
            return null;
        }
        try {
            new AFc1eSDK();
            return AFc1eSDK.values(values);
        } catch (JSONException e8) {
            StringBuilder sb = new StringBuilder("[GCD] Failed to parse GCD response: ");
            sb.append(e8.getMessage());
            AFLogger.afErrorLog(sb.toString(), e8);
            return null;
        }
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    @NonNull
    public final AFd1tSDK AFInAppEventType() throws Exception {
        AFLogger.afDebugLog("[GCD-A01] Loading conversion data. Counter: ".concat(String.valueOf(this.afErrorLog.AFInAppEventType("appsFlyerCount", 0))));
        long AFInAppEventParameterName = this.afErrorLog.AFInAppEventParameterName("appsflyerConversionDataCacheExpiration", 0L);
        if (AFInAppEventParameterName != 0 && System.currentTimeMillis() - AFInAppEventParameterName > 5184000000L) {
            AFLogger.afDebugLog("[GCD-E02] Cached conversion data expired");
            this.afErrorLog.AFInAppEventType("sixtyDayConversionData", true);
            this.afErrorLog.valueOf("attributionId", null);
            this.afErrorLog.AFInAppEventType("appsflyerConversionDataCacheExpiration", 0L);
        }
        Map<String, Object> AFLogger = AFLogger();
        if (AFLogger != null) {
            try {
                if (!AFLogger.containsKey("is_first_launch")) {
                    AFLogger.put("is_first_launch", Boolean.FALSE);
                }
                AFe1oSDK.AFInAppEventParameterName(AFLogger);
            } catch (Exception e8) {
                StringBuilder sb = new StringBuilder("[GCD] Error executing conversion data callback: ");
                sb.append(e8.getLocalizedMessage());
                AFLogger.afErrorLog(sb.toString(), e8);
            }
            return AFd1tSDK.SUCCESS;
        }
        try {
        } catch (Exception e9) {
            StringBuilder sb2 = new StringBuilder("[GCD] Error executing conversion data callback: ");
            sb2.append(e9.getLocalizedMessage());
            AFLogger.afErrorLog(sb2.toString(), e9);
        }
        if (this.afInfoLog != null) {
            StringBuilder sb3 = new StringBuilder("Launch exception: ");
            sb3.append(this.afInfoLog.getMessage());
            AFe1oSDK.valueOf(sb3.toString());
            return AFd1tSDK.SUCCESS;
        }
        AFd1zSDK<String> aFd1zSDK = this.AFLogger;
        if (aFd1zSDK != null && !aFd1zSDK.isSuccessful()) {
            StringBuilder sb4 = new StringBuilder("Launch status code: ");
            sb4.append(this.AFLogger.getStatusCode());
            AFe1oSDK.valueOf(sb4.toString());
            return AFd1tSDK.SUCCESS;
        }
        return AFd1tSDK.FAILURE;
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    public final boolean AFKeystoreWrapper() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    public final long valueOf() {
        return 1000L;
    }
}
