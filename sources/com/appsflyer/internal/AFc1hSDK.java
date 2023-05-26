package com.appsflyer.internal;

/* loaded from: classes.dex */
public class AFc1hSDK {
    public final long AFInAppEventType;

    public AFc1hSDK(long j8) {
        this.AFInAppEventType = j8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.AFInAppEventType == ((AFc1hSDK) obj).AFInAppEventType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j8 = this.AFInAppEventType;
        return (int) (j8 ^ (j8 >>> 32));
    }
}
