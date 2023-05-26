package ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmergencyAssistUIData.kt */
/* loaded from: classes3.dex */
public final class EmergencyAssistUIData {

    /* renamed from: a  reason: collision with root package name */
    private final EmergencyAssistType f32723a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32724b;

    /* renamed from: c  reason: collision with root package name */
    private final String f32725c;

    /* renamed from: d  reason: collision with root package name */
    private final SafetyToolkitVehicleInfo f32726d;

    /* renamed from: e  reason: collision with root package name */
    private final EmergencyAssistFooterData f32727e;

    public EmergencyAssistUIData(EmergencyAssistType type, String address, String emergencyNumber, SafetyToolkitVehicleInfo safetyToolkitVehicleInfo, EmergencyAssistFooterData emergencyAssistFooterData) {
        Intrinsics.f(type, "type");
        Intrinsics.f(address, "address");
        Intrinsics.f(emergencyNumber, "emergencyNumber");
        this.f32723a = type;
        this.f32724b = address;
        this.f32725c = emergencyNumber;
        this.f32726d = safetyToolkitVehicleInfo;
        this.f32727e = emergencyAssistFooterData;
    }

    public final String a() {
        return this.f32724b;
    }

    public final EmergencyAssistFooterData b() {
        return this.f32727e;
    }

    public final String c() {
        return this.f32725c;
    }

    public final EmergencyAssistType d() {
        return this.f32723a;
    }

    public final SafetyToolkitVehicleInfo e() {
        return this.f32726d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EmergencyAssistUIData) {
            EmergencyAssistUIData emergencyAssistUIData = (EmergencyAssistUIData) obj;
            return this.f32723a == emergencyAssistUIData.f32723a && Intrinsics.a(this.f32724b, emergencyAssistUIData.f32724b) && Intrinsics.a(this.f32725c, emergencyAssistUIData.f32725c) && Intrinsics.a(this.f32726d, emergencyAssistUIData.f32726d) && Intrinsics.a(this.f32727e, emergencyAssistUIData.f32727e);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f32723a.hashCode() * 31) + this.f32724b.hashCode()) * 31) + this.f32725c.hashCode()) * 31;
        SafetyToolkitVehicleInfo safetyToolkitVehicleInfo = this.f32726d;
        int hashCode2 = (hashCode + (safetyToolkitVehicleInfo == null ? 0 : safetyToolkitVehicleInfo.hashCode())) * 31;
        EmergencyAssistFooterData emergencyAssistFooterData = this.f32727e;
        return hashCode2 + (emergencyAssistFooterData != null ? emergencyAssistFooterData.hashCode() : 0);
    }

    public String toString() {
        EmergencyAssistType emergencyAssistType = this.f32723a;
        String str = this.f32724b;
        String str2 = this.f32725c;
        SafetyToolkitVehicleInfo safetyToolkitVehicleInfo = this.f32726d;
        EmergencyAssistFooterData emergencyAssistFooterData = this.f32727e;
        return "EmergencyAssistUIData(type=" + emergencyAssistType + ", address=" + str + ", emergencyNumber=" + str2 + ", vehicleInfo=" + safetyToolkitVehicleInfo + ", emergencyAssistFooterData=" + emergencyAssistFooterData + ")";
    }
}
