package ee.mtakso.driver.network.client.settings;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPricing.kt */
/* loaded from: classes3.dex */
public final class DriverPricingSetup {
    @SerializedName("default_distance_rate")

    /* renamed from: a  reason: collision with root package name */
    private final BigDecimal f22798a;
    @SerializedName("current_state")

    /* renamed from: b  reason: collision with root package name */
    private final DriverPricingState f22799b;
    @SerializedName("current_distance_rate")

    /* renamed from: c  reason: collision with root package name */
    private final BigDecimal f22800c;
    @SerializedName("confirmation_text")

    /* renamed from: d  reason: collision with root package name */
    private final String f22801d;
    @SerializedName("slider_config")

    /* renamed from: e  reason: collision with root package name */
    private final SliderConfigResponse f22802e;

    public final BigDecimal a() {
        return this.f22800c;
    }

    public final DriverPricingState b() {
        return this.f22799b;
    }

    public final BigDecimal c() {
        return this.f22798a;
    }

    public final SliderConfigResponse d() {
        return this.f22802e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverPricingSetup) {
            DriverPricingSetup driverPricingSetup = (DriverPricingSetup) obj;
            return Intrinsics.a(this.f22798a, driverPricingSetup.f22798a) && this.f22799b == driverPricingSetup.f22799b && Intrinsics.a(this.f22800c, driverPricingSetup.f22800c) && Intrinsics.a(this.f22801d, driverPricingSetup.f22801d) && Intrinsics.a(this.f22802e, driverPricingSetup.f22802e);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f22798a.hashCode() * 31) + this.f22799b.hashCode()) * 31;
        BigDecimal bigDecimal = this.f22800c;
        return ((((hashCode + (bigDecimal == null ? 0 : bigDecimal.hashCode())) * 31) + this.f22801d.hashCode()) * 31) + this.f22802e.hashCode();
    }

    public String toString() {
        BigDecimal bigDecimal = this.f22798a;
        DriverPricingState driverPricingState = this.f22799b;
        BigDecimal bigDecimal2 = this.f22800c;
        String str = this.f22801d;
        SliderConfigResponse sliderConfigResponse = this.f22802e;
        return "DriverPricingSetup(defaultDistanceRate=" + bigDecimal + ", currentState=" + driverPricingState + ", currentDistanceRate=" + bigDecimal2 + ", confirmationText=" + str + ", sliderConfig=" + sliderConfigResponse + ")";
    }
}
