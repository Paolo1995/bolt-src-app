package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class AFf1xSDK extends AFa1sSDK {
    @Override // com.appsflyer.internal.AFa1sSDK
    public final AFd1rSDK AFInAppEventType() {
        if (this.afInfoLog == 1) {
            return AFd1rSDK.CONVERSION;
        }
        return AFd1rSDK.LAUNCH;
    }

    @Override // com.appsflyer.internal.AFa1sSDK
    public final boolean afRDLog() {
        return true;
    }
}
