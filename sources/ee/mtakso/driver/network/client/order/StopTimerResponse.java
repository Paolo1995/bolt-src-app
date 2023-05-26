package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;

/* compiled from: OrderDto.kt */
/* loaded from: classes3.dex */
public final class StopTimerResponse {
    @SerializedName("poll_interval_sec")

    /* renamed from: a  reason: collision with root package name */
    private final double f22601a;

    public final double a() {
        return this.f22601a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StopTimerResponse) && Double.compare(this.f22601a, ((StopTimerResponse) obj).f22601a) == 0;
    }

    public int hashCode() {
        return q1.a.a(this.f22601a);
    }

    public String toString() {
        double d8 = this.f22601a;
        return "StopTimerResponse(period=" + d8 + ")";
    }
}
