package ee.mtakso.driver.network.client.settings;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPricing.kt */
/* loaded from: classes3.dex */
public final class SetDriverPricingStateRequest {
    @SerializedName("state")

    /* renamed from: a  reason: collision with root package name */
    private final DriverPricingState f22810a;
    @SerializedName("distance_rate")

    /* renamed from: b  reason: collision with root package name */
    private final BigDecimal f22811b;

    public SetDriverPricingStateRequest(DriverPricingState state, BigDecimal bigDecimal) {
        Intrinsics.f(state, "state");
        this.f22810a = state;
        this.f22811b = bigDecimal;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SetDriverPricingStateRequest) {
            SetDriverPricingStateRequest setDriverPricingStateRequest = (SetDriverPricingStateRequest) obj;
            return this.f22810a == setDriverPricingStateRequest.f22810a && Intrinsics.a(this.f22811b, setDriverPricingStateRequest.f22811b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22810a.hashCode() * 31;
        BigDecimal bigDecimal = this.f22811b;
        return hashCode + (bigDecimal == null ? 0 : bigDecimal.hashCode());
    }

    public String toString() {
        DriverPricingState driverPricingState = this.f22810a;
        BigDecimal bigDecimal = this.f22811b;
        return "SetDriverPricingStateRequest(state=" + driverPricingState + ", distanceRate=" + bigDecimal + ")";
    }
}
