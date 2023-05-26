package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;

/* compiled from: DisableNewOrderRequest.kt */
/* loaded from: classes3.dex */
public final class DisableNewOrderRequest {
    @SerializedName("city_id")

    /* renamed from: a  reason: collision with root package name */
    private final long f22328a;

    public DisableNewOrderRequest(long j8) {
        this.f22328a = j8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DisableNewOrderRequest) && this.f22328a == ((DisableNewOrderRequest) obj).f22328a;
    }

    public int hashCode() {
        return i0.a.a(this.f22328a);
    }

    public String toString() {
        long j8 = this.f22328a;
        return "DisableNewOrderRequest(cityId=" + j8 + ")";
    }
}
