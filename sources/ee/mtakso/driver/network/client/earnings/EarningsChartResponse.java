package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsChartResponse.kt */
/* loaded from: classes3.dex */
public final class EarningsChartResponse {
    @SerializedName("currency")

    /* renamed from: a  reason: collision with root package name */
    private final String f22098a;
    @SerializedName("intervals")

    /* renamed from: b  reason: collision with root package name */
    private final List<EarningsInterval> f22099b;

    public final String a() {
        return this.f22098a;
    }

    public final List<EarningsInterval> b() {
        return this.f22099b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsChartResponse) {
            EarningsChartResponse earningsChartResponse = (EarningsChartResponse) obj;
            return Intrinsics.a(this.f22098a, earningsChartResponse.f22098a) && Intrinsics.a(this.f22099b, earningsChartResponse.f22099b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22098a.hashCode() * 31;
        List<EarningsInterval> list = this.f22099b;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        String str = this.f22098a;
        List<EarningsInterval> list = this.f22099b;
        return "EarningsChartResponse(currency=" + str + ", intervalList=" + list + ")";
    }
}
