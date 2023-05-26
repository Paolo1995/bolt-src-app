package ee.mtakso.driver.network.client.driver;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Statistics.kt */
/* loaded from: classes3.dex */
public final class DriverActivityData {

    /* renamed from: a  reason: collision with root package name */
    private final DriverHours f21890a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverRides f21891b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverCancels f21892c;

    public DriverActivityData(DriverHours driverHours, DriverRides driverRides, DriverCancels driverCancels) {
        Intrinsics.f(driverHours, "driverHours");
        Intrinsics.f(driverRides, "driverRides");
        Intrinsics.f(driverCancels, "driverCancels");
        this.f21890a = driverHours;
        this.f21891b = driverRides;
        this.f21892c = driverCancels;
    }

    public final DriverCancels a() {
        return this.f21892c;
    }

    public final DriverHours b() {
        return this.f21890a;
    }

    public final DriverRides c() {
        return this.f21891b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverActivityData) {
            DriverActivityData driverActivityData = (DriverActivityData) obj;
            return Intrinsics.a(this.f21890a, driverActivityData.f21890a) && Intrinsics.a(this.f21891b, driverActivityData.f21891b) && Intrinsics.a(this.f21892c, driverActivityData.f21892c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f21890a.hashCode() * 31) + this.f21891b.hashCode()) * 31) + this.f21892c.hashCode();
    }

    public String toString() {
        DriverHours driverHours = this.f21890a;
        DriverRides driverRides = this.f21891b;
        DriverCancels driverCancels = this.f21892c;
        return "DriverActivityData(driverHours=" + driverHours + ", driverRides=" + driverRides + ", driverCancels=" + driverCancels + ")";
    }
}
