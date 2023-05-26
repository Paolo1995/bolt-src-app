package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Statistics.kt */
/* loaded from: classes3.dex */
public final class DriverHours {
    @SerializedName("number_of_months")

    /* renamed from: a  reason: collision with root package name */
    private final int f21926a;
    @SerializedName("periods")

    /* renamed from: b  reason: collision with root package name */
    private final List<HoursPeriodData> f21927b;

    public final int a() {
        return this.f21926a;
    }

    public final List<HoursPeriodData> b() {
        return this.f21927b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverHours) {
            DriverHours driverHours = (DriverHours) obj;
            return this.f21926a == driverHours.f21926a && Intrinsics.a(this.f21927b, driverHours.f21927b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f21926a * 31) + this.f21927b.hashCode();
    }

    public String toString() {
        int i8 = this.f21926a;
        List<HoursPeriodData> list = this.f21927b;
        return "DriverHours(numberOfMonths=" + i8 + ", weeklyDataList=" + list + ")";
    }
}
