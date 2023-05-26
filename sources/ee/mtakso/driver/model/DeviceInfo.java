package ee.mtakso.driver.model;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceInfo.kt */
/* loaded from: classes3.dex */
public final class DeviceInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f21187a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21188b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21189c;

    /* renamed from: d  reason: collision with root package name */
    private final String f21190d;

    public DeviceInfo(String appVersion, String osVersion, String deviceUUID, String deviceName) {
        Intrinsics.f(appVersion, "appVersion");
        Intrinsics.f(osVersion, "osVersion");
        Intrinsics.f(deviceUUID, "deviceUUID");
        Intrinsics.f(deviceName, "deviceName");
        this.f21187a = appVersion;
        this.f21188b = osVersion;
        this.f21189c = deviceUUID;
        this.f21190d = deviceName;
    }

    public final String a() {
        return this.f21187a;
    }

    public final String b() {
        return this.f21190d;
    }

    public final String c() {
        return this.f21189c;
    }

    public final String d() {
        return this.f21188b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeviceInfo) {
            DeviceInfo deviceInfo = (DeviceInfo) obj;
            return Intrinsics.a(this.f21187a, deviceInfo.f21187a) && Intrinsics.a(this.f21188b, deviceInfo.f21188b) && Intrinsics.a(this.f21189c, deviceInfo.f21189c) && Intrinsics.a(this.f21190d, deviceInfo.f21190d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f21187a.hashCode() * 31) + this.f21188b.hashCode()) * 31) + this.f21189c.hashCode()) * 31) + this.f21190d.hashCode();
    }

    public String toString() {
        String str = this.f21187a;
        String str2 = this.f21188b;
        String str3 = this.f21189c;
        String str4 = this.f21190d;
        return "DeviceInfo(appVersion=" + str + ", osVersion=" + str2 + ", deviceUUID=" + str3 + ", deviceName=" + str4 + ")";
    }
}
