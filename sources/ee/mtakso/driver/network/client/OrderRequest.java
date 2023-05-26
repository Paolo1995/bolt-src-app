package ee.mtakso.driver.network.client;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderRequest.kt */
/* loaded from: classes3.dex */
public final class OrderRequest {
    @SerializedName("order_handle")

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f21323a;

    public OrderRequest(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        this.f21323a = orderHandle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OrderRequest) && Intrinsics.a(this.f21323a, ((OrderRequest) obj).f21323a);
    }

    public int hashCode() {
        return this.f21323a.hashCode();
    }

    public String toString() {
        OrderHandle orderHandle = this.f21323a;
        return "OrderRequest(orderHandle=" + orderHandle + ")";
    }
}
