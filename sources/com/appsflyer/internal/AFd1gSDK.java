package com.appsflyer.internal;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFd1sSDK;
import com.sinch.android.rtc.internal.client.calling.DefaultCallController;

/* loaded from: classes.dex */
public final class AFd1gSDK extends AFd1pSDK<Boolean> {
    private static volatile boolean afRDLog = false;
    private final AFd1sSDK AFLogger;
    private final AFc1vSDK afDebugLog;
    private Boolean afErrorLog;
    private final AFb1zSDK afInfoLog;

    public AFd1gSDK(@NonNull AFc1vSDK aFc1vSDK) {
        super(AFd1rSDK.LOAD_CACHE, new AFd1rSDK[0], "LoadCachedRequests");
        this.afInfoLog = aFc1vSDK.afWarnLog();
        this.AFLogger = aFc1vSDK.afDebugLog();
        this.afDebugLog = aFc1vSDK;
    }

    public static boolean AFLogger() {
        return afRDLog;
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    @NonNull
    public final AFd1tSDK AFInAppEventType() throws Exception {
        for (AFa1oSDK aFa1oSDK : this.afInfoLog.AFKeystoreWrapper()) {
            StringBuilder sb = new StringBuilder("CACHE: resending request: ");
            sb.append(aFa1oSDK.values);
            AFLogger.afInfoLog(sb.toString());
            try {
                AFe1aSDK aFe1aSDK = new AFe1aSDK(AFInAppEventType(aFa1oSDK), aFa1oSDK.valueOf(), aFa1oSDK.AFInAppEventType, aFa1oSDK.valueOf);
                AFd1sSDK aFd1sSDK = this.AFLogger;
                aFd1sSDK.AFInAppEventType.execute(new AFd1sSDK.AnonymousClass3(new AFd1bSDK(aFe1aSDK, this.afDebugLog)));
            } catch (Exception e8) {
                AFLogger.afErrorLog("QUEUE: Failed to resend cached request", e8);
            }
        }
        this.afErrorLog = Boolean.TRUE;
        afRDLog = true;
        return AFd1tSDK.SUCCESS;
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    public final boolean AFKeystoreWrapper() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    public final long valueOf() {
        return DefaultCallController.ICE_SERVERS_VALID_WINDOW_MS;
    }

    private static String AFInAppEventType(AFa1oSDK aFa1oSDK) {
        long currentTimeMillis = System.currentTimeMillis();
        long parseLong = Long.parseLong(aFa1oSDK.AFInAppEventType, 10);
        String str = aFa1oSDK.values;
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("isCachedRequest", "true").appendQueryParameter("timeincache", String.valueOf((currentTimeMillis - parseLong) / 1000)).toString();
        } catch (Exception e8) {
            AFLogger.afErrorLogForExcManagerOnly("Couldn't parse the uri", e8);
            return str;
        }
    }
}
