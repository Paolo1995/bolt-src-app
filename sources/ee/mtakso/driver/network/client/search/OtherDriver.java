package ee.mtakso.driver.network.client.search;

import com.google.gson.annotations.SerializedName;
import eu.bolt.android.maps.core.Locatable;
import i0.a;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: Search.kt */
/* loaded from: classes3.dex */
public final class OtherDriver implements Locatable {
    @SerializedName(Name.MARK)

    /* renamed from: f  reason: collision with root package name */
    private final long f22771f;
    @SerializedName("max_client_distance")

    /* renamed from: g  reason: collision with root package name */
    private final double f22772g;
    @SerializedName("lat")

    /* renamed from: h  reason: collision with root package name */
    private final double f22773h;
    @SerializedName("lng")

    /* renamed from: i  reason: collision with root package name */
    private final double f22774i;
    @SerializedName("bearing")

    /* renamed from: j  reason: collision with root package name */
    private final double f22775j;
    @SerializedName("state")

    /* renamed from: k  reason: collision with root package name */
    private final String f22776k;
    @SerializedName("company_id")

    /* renamed from: l  reason: collision with root package name */
    private final Long f22777l;

    @Override // eu.bolt.android.maps.core.Locatable
    public double a() {
        return this.f22773h;
    }

    @Override // eu.bolt.android.maps.core.Locatable
    public double b() {
        return this.f22774i;
    }

    public final double c() {
        return this.f22775j;
    }

    public final Long d() {
        return this.f22777l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OtherDriver) {
            OtherDriver otherDriver = (OtherDriver) obj;
            return this.f22771f == otherDriver.f22771f && Double.compare(this.f22772g, otherDriver.f22772g) == 0 && Double.compare(a(), otherDriver.a()) == 0 && Double.compare(b(), otherDriver.b()) == 0 && Double.compare(this.f22775j, otherDriver.f22775j) == 0 && Intrinsics.a(this.f22776k, otherDriver.f22776k) && Intrinsics.a(this.f22777l, otherDriver.f22777l);
        }
        return false;
    }

    public int hashCode() {
        int a8 = ((((((((((a.a(this.f22771f) * 31) + q1.a.a(this.f22772g)) * 31) + q1.a.a(a())) * 31) + q1.a.a(b())) * 31) + q1.a.a(this.f22775j)) * 31) + this.f22776k.hashCode()) * 31;
        Long l8 = this.f22777l;
        return a8 + (l8 == null ? 0 : l8.hashCode());
    }

    public String toString() {
        long j8 = this.f22771f;
        double d8 = this.f22772g;
        double a8 = a();
        double b8 = b();
        double d9 = this.f22775j;
        String str = this.f22776k;
        Long l8 = this.f22777l;
        return "OtherDriver(id=" + j8 + ", maxClientDistance=" + d8 + ", latitude=" + a8 + ", longitude=" + b8 + ", bearing=" + d9 + ", state=" + str + ", companyId=" + l8 + ")";
    }
}
