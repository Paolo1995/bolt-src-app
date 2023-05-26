package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Statistics.kt */
/* loaded from: classes3.dex */
public final class DriverRides {
    @SerializedName("number_of_months")

    /* renamed from: a  reason: collision with root package name */
    private final int f21956a;
    @SerializedName("periods")

    /* renamed from: b  reason: collision with root package name */
    private final List<RidesPeriodData> f21957b;

    public final List<RidesPeriodData> a() {
        return this.f21957b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverRides) {
            DriverRides driverRides = (DriverRides) obj;
            return this.f21956a == driverRides.f21956a && Intrinsics.a(this.f21957b, driverRides.f21957b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f21956a * 31) + this.f21957b.hashCode();
    }

    public String toString() {
        int i8 = this.f21956a;
        List<RidesPeriodData> list = this.f21957b;
        return "DriverRides(numberOfMonths=" + i8 + ", weeklyDataList=" + list + ")";
    }
}
