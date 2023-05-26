package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverStatisticsSummary.kt */
/* loaded from: classes3.dex */
public final class DriverStatisticsSummary {
    @SerializedName("earned_today")

    /* renamed from: a  reason: collision with root package name */
    private final double f22342a;
    @SerializedName("earned_today_str")

    /* renamed from: b  reason: collision with root package name */
    private final String f22343b;
    @SerializedName("activity_score")

    /* renamed from: c  reason: collision with root package name */
    private final double f22344c;
    @SerializedName("avg_rating")

    /* renamed from: d  reason: collision with root package name */
    private final double f22345d;
    @SerializedName("acceptance_rate")

    /* renamed from: e  reason: collision with root package name */
    private final Double f22346e;

    public final Double a() {
        return this.f22346e;
    }

    public final double b() {
        return this.f22344c;
    }

    public final double c() {
        return this.f22345d;
    }

    public final String d() {
        return this.f22343b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverStatisticsSummary) {
            DriverStatisticsSummary driverStatisticsSummary = (DriverStatisticsSummary) obj;
            return Double.compare(this.f22342a, driverStatisticsSummary.f22342a) == 0 && Intrinsics.a(this.f22343b, driverStatisticsSummary.f22343b) && Double.compare(this.f22344c, driverStatisticsSummary.f22344c) == 0 && Double.compare(this.f22345d, driverStatisticsSummary.f22345d) == 0 && Intrinsics.a(this.f22346e, driverStatisticsSummary.f22346e);
        }
        return false;
    }

    public int hashCode() {
        int a8 = ((((((q1.a.a(this.f22342a) * 31) + this.f22343b.hashCode()) * 31) + q1.a.a(this.f22344c)) * 31) + q1.a.a(this.f22345d)) * 31;
        Double d8 = this.f22346e;
        return a8 + (d8 == null ? 0 : d8.hashCode());
    }

    public String toString() {
        double d8 = this.f22342a;
        String str = this.f22343b;
        double d9 = this.f22344c;
        double d10 = this.f22345d;
        Double d11 = this.f22346e;
        return "DriverStatisticsSummary(earnedToday=" + d8 + ", earnedTodayString=" + str + ", activityScore=" + d9 + ", averageRating=" + d10 + ", acceptanceRate=" + d11 + ")";
    }
}
