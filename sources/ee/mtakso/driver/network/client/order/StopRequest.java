package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderDto.kt */
/* loaded from: classes3.dex */
public final class StopRequest {
    @SerializedName("order_handle")

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f22596a;
    @SerializedName("stop_id")

    /* renamed from: b  reason: collision with root package name */
    private final String f22597b;

    public StopRequest(OrderHandle orderHandle, String stopId) {
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(stopId, "stopId");
        this.f22596a = orderHandle;
        this.f22597b = stopId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StopRequest) {
            StopRequest stopRequest = (StopRequest) obj;
            return Intrinsics.a(this.f22596a, stopRequest.f22596a) && Intrinsics.a(this.f22597b, stopRequest.f22597b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22596a.hashCode() * 31) + this.f22597b.hashCode();
    }

    public String toString() {
        OrderHandle orderHandle = this.f22596a;
        String str = this.f22597b;
        return "StopRequest(orderHandle=" + orderHandle + ", stopId=" + str + ")";
    }
}
