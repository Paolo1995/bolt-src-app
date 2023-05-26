package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderDto.kt */
/* loaded from: classes3.dex */
public final class RejectOrderRequest {
    @SerializedName("order_handle")

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f22528a;
    @SerializedName("reason")

    /* renamed from: b  reason: collision with root package name */
    private final RejectReasonInfo f22529b;

    public RejectOrderRequest(OrderHandle orderHandle, RejectReasonInfo rejectReasonInfo) {
        Intrinsics.f(orderHandle, "orderHandle");
        this.f22528a = orderHandle;
        this.f22529b = rejectReasonInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RejectOrderRequest) {
            RejectOrderRequest rejectOrderRequest = (RejectOrderRequest) obj;
            return Intrinsics.a(this.f22528a, rejectOrderRequest.f22528a) && Intrinsics.a(this.f22529b, rejectOrderRequest.f22529b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22528a.hashCode() * 31;
        RejectReasonInfo rejectReasonInfo = this.f22529b;
        return hashCode + (rejectReasonInfo == null ? 0 : rejectReasonInfo.hashCode());
    }

    public String toString() {
        OrderHandle orderHandle = this.f22528a;
        RejectReasonInfo rejectReasonInfo = this.f22529b;
        return "RejectOrderRequest(orderHandle=" + orderHandle + ", reason=" + rejectReasonInfo + ")";
    }
}
