package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class AFe1aSDK extends AFa1sSDK {
    public final AFd1rSDK getLevel;

    @Deprecated
    public AFe1aSDK() {
        this.getLevel = null;
    }

    @Override // com.appsflyer.internal.AFa1sSDK
    public final AFd1rSDK AFInAppEventType() {
        AFd1rSDK aFd1rSDK = this.getLevel;
        if (aFd1rSDK != null) {
            return aFd1rSDK;
        }
        return AFd1rSDK.CACHED_EVENT;
    }

    public AFe1aSDK(String str, byte[] bArr, String str2, AFd1rSDK aFd1rSDK) {
        super(null, str, Boolean.FALSE, null);
        this.afRDLog = str2;
        AFInAppEventType(bArr);
        this.getLevel = aFd1rSDK;
    }
}
