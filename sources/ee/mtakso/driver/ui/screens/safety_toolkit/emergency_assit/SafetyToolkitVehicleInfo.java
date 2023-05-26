package ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: SafetyToolkitVehicleInfo.kt */
/* loaded from: classes3.dex */
public final class SafetyToolkitVehicleInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f32731a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32732b;

    /* renamed from: c  reason: collision with root package name */
    private final String f32733c;

    public SafetyToolkitVehicleInfo(String licencePlate, String carName, String carColor) {
        Intrinsics.f(licencePlate, "licencePlate");
        Intrinsics.f(carName, "carName");
        Intrinsics.f(carColor, "carColor");
        this.f32731a = licencePlate;
        this.f32732b = carName;
        this.f32733c = carColor;
    }

    public final String a() {
        return this.f32733c;
    }

    public final String b() {
        return this.f32732b;
    }

    public final String c() {
        return this.f32731a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SafetyToolkitVehicleInfo) {
            SafetyToolkitVehicleInfo safetyToolkitVehicleInfo = (SafetyToolkitVehicleInfo) obj;
            return Intrinsics.a(this.f32731a, safetyToolkitVehicleInfo.f32731a) && Intrinsics.a(this.f32732b, safetyToolkitVehicleInfo.f32732b) && Intrinsics.a(this.f32733c, safetyToolkitVehicleInfo.f32733c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f32731a.hashCode() * 31) + this.f32732b.hashCode()) * 31) + this.f32733c.hashCode();
    }

    public String toString() {
        String str = this.f32731a;
        String str2 = this.f32732b;
        String str3 = this.f32733c;
        return "SafetyToolkitVehicleInfo(licencePlate=" + str + ", carName=" + str2 + ", carColor=" + str3 + ")";
    }
}
