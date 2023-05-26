package ee.mtakso.driver.network.client.settings;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPricing.kt */
/* loaded from: classes3.dex */
public final class DriverPricingHint {
    @SerializedName("start")

    /* renamed from: a  reason: collision with root package name */
    private final BigDecimal f22795a;
    @SerializedName("end")

    /* renamed from: b  reason: collision with root package name */
    private final BigDecimal f22796b;
    @SerializedName("hint")

    /* renamed from: c  reason: collision with root package name */
    private final String f22797c;

    public final BigDecimal a() {
        return this.f22796b;
    }

    public final String b() {
        return this.f22797c;
    }

    public final BigDecimal c() {
        return this.f22795a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverPricingHint) {
            DriverPricingHint driverPricingHint = (DriverPricingHint) obj;
            return Intrinsics.a(this.f22795a, driverPricingHint.f22795a) && Intrinsics.a(this.f22796b, driverPricingHint.f22796b) && Intrinsics.a(this.f22797c, driverPricingHint.f22797c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f22795a.hashCode() * 31) + this.f22796b.hashCode()) * 31) + this.f22797c.hashCode();
    }

    public String toString() {
        BigDecimal bigDecimal = this.f22795a;
        BigDecimal bigDecimal2 = this.f22796b;
        String str = this.f22797c;
        return "DriverPricingHint(start=" + bigDecimal + ", end=" + bigDecimal2 + ", hint=" + str + ")";
    }
}
