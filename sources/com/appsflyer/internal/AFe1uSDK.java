package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class AFe1uSDK extends AFd1iSDK<String> {
    private final Map<String, Object> afRDLog;

    public AFe1uSDK(@NonNull Map<String, Object> map, @NonNull AFc1vSDK aFc1vSDK) {
        super(AFd1rSDK.MONITORSDK, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, aFc1vSDK, String.valueOf(map.hashCode()));
        this.afRDLog = new HashMap(map);
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final AFc1jSDK<String> AFInAppEventType(@NonNull String str) {
        return ((AFd1iSDK) this).AFLogger.valueOf(this.afRDLog);
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final boolean afRDLog() {
        return true;
    }
}
