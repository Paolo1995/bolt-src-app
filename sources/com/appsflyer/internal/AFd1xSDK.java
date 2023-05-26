package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class AFd1xSDK {
    public final AFd1vSDK AFInAppEventParameterName;
    public final String valueOf;
    public final String values;

    public AFd1xSDK(String str, String str2, AFd1vSDK aFd1vSDK) {
        Intrinsics.f(str, "");
        Intrinsics.f(aFd1vSDK, "");
        this.valueOf = str;
        this.values = str2;
        this.AFInAppEventParameterName = aFd1vSDK;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AFd1xSDK) {
            AFd1xSDK aFd1xSDK = (AFd1xSDK) obj;
            return Intrinsics.a(this.valueOf, aFd1xSDK.valueOf) && Intrinsics.a(this.values, aFd1xSDK.values) && this.AFInAppEventParameterName == aFd1xSDK.AFInAppEventParameterName;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.valueOf.hashCode() * 31;
        String str = this.values;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.AFInAppEventParameterName.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AFd1xSDK(AFInAppEventType=");
        sb.append(this.valueOf);
        sb.append(", values=");
        sb.append(this.values);
        sb.append(", AFKeystoreWrapper=");
        sb.append(this.AFInAppEventParameterName);
        sb.append(')');
        return sb.toString();
    }
}
