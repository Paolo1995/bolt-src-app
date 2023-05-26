package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderState;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tracking.kt */
/* loaded from: classes3.dex */
public final class DriverGpsLocation {
    @SerializedName("s")

    /* renamed from: a  reason: collision with root package name */
    private final OrderState f21915a;
    @SerializedName("lat")

    /* renamed from: b  reason: collision with root package name */
    private final double f21916b;
    @SerializedName("lng")

    /* renamed from: c  reason: collision with root package name */
    private final double f21917c;
    @SerializedName("alt")

    /* renamed from: d  reason: collision with root package name */
    private final double f21918d;
    @SerializedName("speed")

    /* renamed from: e  reason: collision with root package name */
    private final float f21919e;
    @SerializedName("t")

    /* renamed from: f  reason: collision with root package name */
    private final long f21920f;
    @SerializedName("is_fixed")

    /* renamed from: g  reason: collision with root package name */
    private final boolean f21921g;
    @SerializedName("bearing")

    /* renamed from: h  reason: collision with root package name */
    private final Float f21922h;
    @SerializedName("bearing_acc")

    /* renamed from: i  reason: collision with root package name */
    private final Float f21923i;

    public DriverGpsLocation(OrderState orderState, double d8, double d9, double d10, float f8, long j8, boolean z7, Float f9, Float f10) {
        Intrinsics.f(orderState, "orderState");
        this.f21915a = orderState;
        this.f21916b = d8;
        this.f21917c = d9;
        this.f21918d = d10;
        this.f21919e = f8;
        this.f21920f = j8;
        this.f21921g = z7;
        this.f21922h = f9;
        this.f21923i = f10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverGpsLocation) {
            DriverGpsLocation driverGpsLocation = (DriverGpsLocation) obj;
            return this.f21915a == driverGpsLocation.f21915a && Double.compare(this.f21916b, driverGpsLocation.f21916b) == 0 && Double.compare(this.f21917c, driverGpsLocation.f21917c) == 0 && Double.compare(this.f21918d, driverGpsLocation.f21918d) == 0 && Float.compare(this.f21919e, driverGpsLocation.f21919e) == 0 && this.f21920f == driverGpsLocation.f21920f && this.f21921g == driverGpsLocation.f21921g && Intrinsics.a(this.f21922h, driverGpsLocation.f21922h) && Intrinsics.a(this.f21923i, driverGpsLocation.f21923i);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.f21915a.hashCode() * 31) + q1.a.a(this.f21916b)) * 31) + q1.a.a(this.f21917c)) * 31) + q1.a.a(this.f21918d)) * 31) + Float.floatToIntBits(this.f21919e)) * 31) + i0.a.a(this.f21920f)) * 31;
        boolean z7 = this.f21921g;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        Float f8 = this.f21922h;
        int hashCode2 = (i9 + (f8 == null ? 0 : f8.hashCode())) * 31;
        Float f9 = this.f21923i;
        return hashCode2 + (f9 != null ? f9.hashCode() : 0);
    }

    public String toString() {
        OrderState orderState = this.f21915a;
        double d8 = this.f21916b;
        double d9 = this.f21917c;
        double d10 = this.f21918d;
        float f8 = this.f21919e;
        long j8 = this.f21920f;
        boolean z7 = this.f21921g;
        Float f9 = this.f21922h;
        Float f10 = this.f21923i;
        return "DriverGpsLocation(orderState=" + orderState + ", lat=" + d8 + ", lng=" + d9 + ", alt=" + d10 + ", speed=" + f8 + ", phoneTimestamp=" + j8 + ", fixed=" + z7 + ", bearing=" + f9 + ", bearingAccuracy=" + f10 + ")";
    }
}
