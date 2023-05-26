package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLinkResult;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AFe1jSDK {
    public final Map<String, Object> AFInAppEventParameterName;
    public final Map<String, Object> AFInAppEventType;
    public long AFKeystoreWrapper;
    public long AFLogger;
    public long AFLogger$LogLevel;
    public long afDebugLog;
    public final long[] afErrorLog;
    public long afErrorLogForExcManagerOnly;
    public final long[] afInfoLog;
    public final long[] afRDLog;
    public final Map<String, Object> valueOf;
    public final AFc1ySDK values;

    public AFe1jSDK(AFc1ySDK aFc1ySDK) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.valueOf = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        this.AFInAppEventParameterName = concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
        this.AFInAppEventType = concurrentHashMap3;
        this.AFKeystoreWrapper = 0L;
        this.AFLogger = 0L;
        this.afErrorLog = new long[2];
        this.afRDLog = new long[2];
        this.afInfoLog = new long[2];
        this.afDebugLog = 0L;
        this.AFLogger$LogLevel = 0L;
        this.values = aFc1ySDK;
        concurrentHashMap.putAll(valueOf("first_launch"));
        concurrentHashMap2.putAll(valueOf("ddl"));
        concurrentHashMap3.putAll(valueOf("gcd"));
        this.afErrorLogForExcManagerOnly = aFc1ySDK.AFInAppEventParameterName("prev_session_dur", 0L);
    }

    private Map<String, Object> valueOf(String str) {
        Map<String, Object> emptyMap = Collections.emptyMap();
        String values = this.values.values(str, null);
        if (values != null) {
            try {
                return AFa1oSDK.AFInAppEventType(new JSONObject(values));
            } catch (Exception e8) {
                AFLogger.afErrorLog("Error while parsing cached json data", e8, true);
                return emptyMap;
            }
        }
        return emptyMap;
    }

    public final void AFInAppEventParameterName(AFe1fSDK aFe1fSDK) {
        if (AFInAppEventParameterName()) {
            this.valueOf.put("start_with", aFe1fSDK.toString());
            this.values.valueOf("first_launch", new JSONObject(this.valueOf).toString());
        }
    }

    public final void AFInAppEventType(int i8) {
        long currentTimeMillis = System.currentTimeMillis();
        this.afDebugLog = currentTimeMillis;
        if (i8 == 1) {
            long j8 = this.AFLogger;
            if (j8 != 0) {
                this.valueOf.put("from_fg", Long.valueOf(currentTimeMillis - j8));
                this.values.valueOf("first_launch", new JSONObject(this.valueOf).toString());
                return;
            }
            AFLogger.afInfoLog("Metrics: fg ts is missing");
        }
    }

    public final void AFKeystoreWrapper() {
        this.AFLogger = System.currentTimeMillis();
        if (AFInAppEventParameterName()) {
            long j8 = this.AFKeystoreWrapper;
            if (j8 != 0) {
                this.valueOf.put("init_to_fg", Long.valueOf(this.AFLogger - j8));
                this.values.valueOf("first_launch", new JSONObject(this.valueOf).toString());
                return;
            }
            AFLogger.afInfoLog("Metrics: init ts is missing");
        }
    }

    public final void values(DeepLinkResult deepLinkResult, long j8) {
        this.AFInAppEventParameterName.put("status", deepLinkResult.getStatus().toString());
        this.AFInAppEventParameterName.put("timeout_value", Long.valueOf(j8));
        this.values.valueOf("ddl", new JSONObject(this.AFInAppEventParameterName).toString());
    }

    public final void AFInAppEventParameterName(int i8) {
        long currentTimeMillis = System.currentTimeMillis();
        long j8 = this.AFLogger$LogLevel;
        if (j8 != 0) {
            this.AFInAppEventType.put("net", Long.valueOf(currentTimeMillis - j8));
        } else {
            AFLogger.afInfoLog("Metrics: gcdStart ts is missing");
        }
        this.AFInAppEventType.put("retries", Integer.valueOf(i8));
        this.values.valueOf("gcd", new JSONObject(this.AFInAppEventType).toString());
    }

    public final boolean AFInAppEventParameterName() {
        return this.values.AFInAppEventType("appsFlyerCount", 0) == 0;
    }
}
