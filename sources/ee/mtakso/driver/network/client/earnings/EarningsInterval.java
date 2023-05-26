package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsInterval.kt */
/* loaded from: classes3.dex */
public final class EarningsInterval {
    @SerializedName("key")

    /* renamed from: a  reason: collision with root package name */
    private final String f22104a;
    @SerializedName("title")

    /* renamed from: b  reason: collision with root package name */
    private final EarningsIntervalTitle f22105b;
    @SerializedName("bars")

    /* renamed from: c  reason: collision with root package name */
    private final List<EarningsBar> f22106c;

    public final List<EarningsBar> a() {
        return this.f22106c;
    }

    public final String b() {
        return this.f22104a;
    }

    public final EarningsIntervalTitle c() {
        return this.f22105b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsInterval) {
            EarningsInterval earningsInterval = (EarningsInterval) obj;
            return Intrinsics.a(this.f22104a, earningsInterval.f22104a) && Intrinsics.a(this.f22105b, earningsInterval.f22105b) && Intrinsics.a(this.f22106c, earningsInterval.f22106c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f22104a.hashCode() * 31) + this.f22105b.hashCode()) * 31) + this.f22106c.hashCode();
    }

    public String toString() {
        String str = this.f22104a;
        EarningsIntervalTitle earningsIntervalTitle = this.f22105b;
        List<EarningsBar> list = this.f22106c;
        return "EarningsInterval(key=" + str + ", title=" + earningsIntervalTitle + ", barList=" + list + ")";
    }
}
