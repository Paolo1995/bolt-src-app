package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderDto.kt */
/* loaded from: classes3.dex */
public final class SetDestinationRequest {
    @SerializedName("order_handle")

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f22592a;
    @SerializedName("address")

    /* renamed from: b  reason: collision with root package name */
    private final String f22593b;
    @SerializedName("lat")

    /* renamed from: c  reason: collision with root package name */
    private final double f22594c;
    @SerializedName("lng")

    /* renamed from: d  reason: collision with root package name */
    private final double f22595d;

    public SetDestinationRequest(OrderHandle orderHandle, String address, double d8, double d9) {
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(address, "address");
        this.f22592a = orderHandle;
        this.f22593b = address;
        this.f22594c = d8;
        this.f22595d = d9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SetDestinationRequest) {
            SetDestinationRequest setDestinationRequest = (SetDestinationRequest) obj;
            return Intrinsics.a(this.f22592a, setDestinationRequest.f22592a) && Intrinsics.a(this.f22593b, setDestinationRequest.f22593b) && Double.compare(this.f22594c, setDestinationRequest.f22594c) == 0 && Double.compare(this.f22595d, setDestinationRequest.f22595d) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f22592a.hashCode() * 31) + this.f22593b.hashCode()) * 31) + q1.a.a(this.f22594c)) * 31) + q1.a.a(this.f22595d);
    }

    public String toString() {
        OrderHandle orderHandle = this.f22592a;
        String str = this.f22593b;
        double d8 = this.f22594c;
        double d9 = this.f22595d;
        return "SetDestinationRequest(orderHandle=" + orderHandle + ", address=" + str + ", lat=" + d8 + ", lng=" + d9 + ")";
    }
}
