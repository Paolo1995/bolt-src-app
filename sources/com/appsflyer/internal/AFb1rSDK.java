package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFd1sSDK;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class AFb1rSDK implements AFd1uSDK {
    public final AFe1qSDK AFInAppEventParameterName;
    private final AFe1ySDK AFInAppEventType;
    private final AFc1zSDK AFKeystoreWrapper;
    private final AFc1kSDK AFLogger;
    private AFe1vSDK afDebugLog;
    private AFb1cSDK afErrorLog;
    private final AFe1sSDK afInfoLog;
    private final AFd1sSDK afRDLog;
    private final Object valueOf;
    private final AFe1nSDK values;

    public AFb1rSDK() {
    }

    public AFb1rSDK(AFe1ySDK aFe1ySDK, AFc1zSDK aFc1zSDK, AFe1nSDK aFe1nSDK, AFe1qSDK aFe1qSDK, AFc1kSDK aFc1kSDK, AFe1sSDK aFe1sSDK, AFd1sSDK aFd1sSDK) {
        this.valueOf = new Object();
        this.AFInAppEventType = aFe1ySDK;
        this.AFKeystoreWrapper = aFc1zSDK;
        this.values = aFe1nSDK;
        this.AFInAppEventParameterName = aFe1qSDK;
        this.AFLogger = aFc1kSDK;
        this.afInfoLog = aFe1sSDK;
        this.afRDLog = aFd1sSDK;
        aFd1sSDK.values.add(this);
    }

    public static Map<String, String> AFInAppEventParameterName(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                hashMap.put(URLEncoder.encode(entry.getKey(), "utf-8"), URLEncoder.encode(entry.getValue(), "utf-8"));
            } catch (UnsupportedEncodingException e8) {
                AFLogger.afErrorLogForExcManagerOnly("failed to encode map", e8);
            }
        }
        return hashMap;
    }

    private void AFKeystoreWrapper(AFe1vSDK aFe1vSDK, AFe1xSDK aFe1xSDK) {
        synchronized (this.valueOf) {
            this.afDebugLog = aFe1vSDK;
        }
        if (aFe1xSDK != null) {
            aFe1xSDK.onRemoteConfigUpdateFinished(aFe1vSDK);
        }
    }

    public final AFb1cSDK AFInAppEventType() {
        AFb1cSDK aFb1cSDK;
        synchronized (this.valueOf) {
            aFb1cSDK = this.afErrorLog;
            this.afErrorLog = null;
        }
        return aFb1cSDK;
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final void AFKeystoreWrapper(AFd1pSDK<?> aFd1pSDK) {
    }

    public final void values(AFe1xSDK aFe1xSDK) {
        AFe1wSDK aFe1wSDK = new AFe1wSDK(this.AFInAppEventType, this.AFKeystoreWrapper, this.values, this.AFInAppEventParameterName, this.AFLogger, this.afInfoLog, "v1", aFe1xSDK);
        AFd1sSDK aFd1sSDK = this.afRDLog;
        aFd1sSDK.AFInAppEventType.execute(new AFd1sSDK.AnonymousClass3(aFe1wSDK));
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final void AFKeystoreWrapper(AFd1pSDK<?> aFd1pSDK, AFd1tSDK aFd1tSDK) {
        if (aFd1pSDK instanceof AFe1wSDK) {
            AFe1wSDK aFe1wSDK = (AFe1wSDK) aFd1pSDK;
            AFe1vSDK aFe1vSDK = aFe1wSDK.afRDLog;
            if (aFe1vSDK == null) {
                AFLogger.afWarnLog("CFG: update RC returned null result, something went wrong!");
                aFe1vSDK = AFe1vSDK.FAILURE;
            }
            if (aFe1vSDK != AFe1vSDK.USE_CACHED) {
                AFb1cSDK aFb1cSDK = aFe1wSDK.AFLogger;
                synchronized (this.valueOf) {
                    this.afErrorLog = aFb1cSDK;
                }
            }
            AFKeystoreWrapper(aFe1vSDK, aFe1wSDK.afErrorLog);
        }
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final void AFInAppEventParameterName(AFd1pSDK<?> aFd1pSDK) {
        if (aFd1pSDK instanceof AFe1wSDK) {
            AFe1wSDK aFe1wSDK = (AFe1wSDK) aFd1pSDK;
            synchronized (this.valueOf) {
                this.afErrorLog = null;
            }
            AFKeystoreWrapper(AFe1vSDK.FAILURE, aFe1wSDK.afErrorLog);
        }
    }
}
