package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class Periods {
    @SerializedName("periods")

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f21726a;
    @SerializedName("end_date_hint")

    /* renamed from: b  reason: collision with root package name */
    private final String f21727b;

    public final String a() {
        return this.f21727b;
    }

    public final List<String> b() {
        return this.f21726a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Periods) {
            Periods periods = (Periods) obj;
            return Intrinsics.a(this.f21726a, periods.f21726a) && Intrinsics.a(this.f21727b, periods.f21727b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f21726a.hashCode() * 31) + this.f21727b.hashCode();
    }

    public String toString() {
        List<String> list = this.f21726a;
        String str = this.f21727b;
        return "Periods(periods=" + list + ", endDateHint=" + str + ")";
    }
}
