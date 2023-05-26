package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class AFc1aSDK {
    final String AFInAppEventParameterName;
    final String valueOf;

    public AFc1aSDK(String str, String str2) {
        Intrinsics.f(str, "");
        Intrinsics.f(str2, "");
        this.AFInAppEventParameterName = str;
        this.valueOf = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AFc1aSDK) {
            AFc1aSDK aFc1aSDK = (AFc1aSDK) obj;
            return Intrinsics.a(this.AFInAppEventParameterName, aFc1aSDK.AFInAppEventParameterName) && Intrinsics.a(this.valueOf, aFc1aSDK.valueOf);
        }
        return false;
    }

    public final int hashCode() {
        return (this.AFInAppEventParameterName.hashCode() * 31) + this.valueOf.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HostConfig(prefix=");
        sb.append(this.AFInAppEventParameterName);
        sb.append(", host=");
        sb.append(this.valueOf);
        sb.append(')');
        return sb.toString();
    }
}
