package ee.mtakso.driver.network.client.emergencyassist.local_authority;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DidYouGetHelpRequest.kt */
/* loaded from: classes3.dex */
public final class DidYouGetHelpRequest {
    @SerializedName("order_handle")

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f22180a;

    public DidYouGetHelpRequest(OrderHandle orderHandle) {
        this.f22180a = orderHandle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DidYouGetHelpRequest) && Intrinsics.a(this.f22180a, ((DidYouGetHelpRequest) obj).f22180a);
    }

    public int hashCode() {
        OrderHandle orderHandle = this.f22180a;
        if (orderHandle == null) {
            return 0;
        }
        return orderHandle.hashCode();
    }

    public String toString() {
        OrderHandle orderHandle = this.f22180a;
        return "DidYouGetHelpRequest(orderHandle=" + orderHandle + ")";
    }
}
