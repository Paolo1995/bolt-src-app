package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportMode.kt */
/* loaded from: classes3.dex */
public final class EarningsReportScreenConfig {
    @SerializedName("modes")

    /* renamed from: a  reason: collision with root package name */
    private final List<EarningsReportPeriod> f22113a;
    @SerializedName("available_screens")

    /* renamed from: b  reason: collision with root package name */
    private final List<EarningsScreenType> f22114b;

    /* JADX WARN: Multi-variable type inference failed */
    public EarningsReportScreenConfig(List<EarningsReportPeriod> items, List<? extends EarningsScreenType> screenList) {
        Intrinsics.f(items, "items");
        Intrinsics.f(screenList, "screenList");
        this.f22113a = items;
        this.f22114b = screenList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EarningsReportScreenConfig b(EarningsReportScreenConfig earningsReportScreenConfig, List list, List list2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            list = earningsReportScreenConfig.f22113a;
        }
        if ((i8 & 2) != 0) {
            list2 = earningsReportScreenConfig.f22114b;
        }
        return earningsReportScreenConfig.a(list, list2);
    }

    public final EarningsReportScreenConfig a(List<EarningsReportPeriod> items, List<? extends EarningsScreenType> screenList) {
        Intrinsics.f(items, "items");
        Intrinsics.f(screenList, "screenList");
        return new EarningsReportScreenConfig(items, screenList);
    }

    public final List<EarningsReportPeriod> c() {
        return this.f22113a;
    }

    public final List<EarningsScreenType> d() {
        return this.f22114b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsReportScreenConfig) {
            EarningsReportScreenConfig earningsReportScreenConfig = (EarningsReportScreenConfig) obj;
            return Intrinsics.a(this.f22113a, earningsReportScreenConfig.f22113a) && Intrinsics.a(this.f22114b, earningsReportScreenConfig.f22114b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22113a.hashCode() * 31) + this.f22114b.hashCode();
    }

    public String toString() {
        List<EarningsReportPeriod> list = this.f22113a;
        List<EarningsScreenType> list2 = this.f22114b;
        return "EarningsReportScreenConfig(items=" + list + ", screenList=" + list2 + ")";
    }
}
