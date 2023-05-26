package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: Campaign.kt */
/* loaded from: classes3.dex */
public final class OptInGroupSummary {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final long f21717a;
    @SerializedName("name")

    /* renamed from: b  reason: collision with root package name */
    private final String f21718b;
    @SerializedName("choose_before")

    /* renamed from: c  reason: collision with root package name */
    private final long f21719c;

    public final long a() {
        return this.f21719c;
    }

    public final long b() {
        return this.f21717a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OptInGroupSummary) {
            OptInGroupSummary optInGroupSummary = (OptInGroupSummary) obj;
            return this.f21717a == optInGroupSummary.f21717a && Intrinsics.a(this.f21718b, optInGroupSummary.f21718b) && this.f21719c == optInGroupSummary.f21719c;
        }
        return false;
    }

    public int hashCode() {
        return (((i0.a.a(this.f21717a) * 31) + this.f21718b.hashCode()) * 31) + i0.a.a(this.f21719c);
    }

    public String toString() {
        long j8 = this.f21717a;
        String str = this.f21718b;
        long j9 = this.f21719c;
        return "OptInGroupSummary(id=" + j8 + ", name=" + str + ", choose_before=" + j9 + ")";
    }
}
