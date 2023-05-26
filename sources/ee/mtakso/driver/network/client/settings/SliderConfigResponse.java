package ee.mtakso.driver.network.client.settings;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPricing.kt */
/* loaded from: classes3.dex */
public final class SliderConfigResponse {
    @SerializedName("min")

    /* renamed from: a  reason: collision with root package name */
    private final BigDecimal f22831a;
    @SerializedName("max")

    /* renamed from: b  reason: collision with root package name */
    private final BigDecimal f22832b;
    @SerializedName("step")

    /* renamed from: c  reason: collision with root package name */
    private final BigDecimal f22833c;
    @SerializedName("unit")

    /* renamed from: d  reason: collision with root package name */
    private final String f22834d;
    @SerializedName("distance_unit")

    /* renamed from: e  reason: collision with root package name */
    private final String f22835e;
    @SerializedName("hints")

    /* renamed from: f  reason: collision with root package name */
    private final List<DriverPricingHint> f22836f;

    public final List<DriverPricingHint> a() {
        return this.f22836f;
    }

    public final BigDecimal b() {
        return this.f22832b;
    }

    public final BigDecimal c() {
        return this.f22831a;
    }

    public final BigDecimal d() {
        return this.f22833c;
    }

    public final String e() {
        return this.f22834d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SliderConfigResponse) {
            SliderConfigResponse sliderConfigResponse = (SliderConfigResponse) obj;
            return Intrinsics.a(this.f22831a, sliderConfigResponse.f22831a) && Intrinsics.a(this.f22832b, sliderConfigResponse.f22832b) && Intrinsics.a(this.f22833c, sliderConfigResponse.f22833c) && Intrinsics.a(this.f22834d, sliderConfigResponse.f22834d) && Intrinsics.a(this.f22835e, sliderConfigResponse.f22835e) && Intrinsics.a(this.f22836f, sliderConfigResponse.f22836f);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.f22831a.hashCode() * 31) + this.f22832b.hashCode()) * 31) + this.f22833c.hashCode()) * 31) + this.f22834d.hashCode()) * 31;
        String str = this.f22835e;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f22836f.hashCode();
    }

    public String toString() {
        BigDecimal bigDecimal = this.f22831a;
        BigDecimal bigDecimal2 = this.f22832b;
        BigDecimal bigDecimal3 = this.f22833c;
        String str = this.f22834d;
        String str2 = this.f22835e;
        List<DriverPricingHint> list = this.f22836f;
        return "SliderConfigResponse(min=" + bigDecimal + ", max=" + bigDecimal2 + ", step=" + bigDecimal3 + ", unit=" + str + ", distanceUnit=" + str2 + ", hints=" + list + ")";
    }
}
