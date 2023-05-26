package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StartWorkingRequest.kt */
/* loaded from: classes3.dex */
public final class StartWorkingRequest {
    @SerializedName("max_client_distance")

    /* renamed from: a  reason: collision with root package name */
    private final double f22013a;
    @SerializedName("driver_destination_id")

    /* renamed from: b  reason: collision with root package name */
    private final Long f22014b;
    @SerializedName("accept_order_handle")

    /* renamed from: c  reason: collision with root package name */
    private final OrderHandle f22015c;

    public StartWorkingRequest(double d8, Long l8, OrderHandle orderHandle) {
        this.f22013a = d8;
        this.f22014b = l8;
        this.f22015c = orderHandle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StartWorkingRequest) {
            StartWorkingRequest startWorkingRequest = (StartWorkingRequest) obj;
            return Double.compare(this.f22013a, startWorkingRequest.f22013a) == 0 && Intrinsics.a(this.f22014b, startWorkingRequest.f22014b) && Intrinsics.a(this.f22015c, startWorkingRequest.f22015c);
        }
        return false;
    }

    public int hashCode() {
        int a8 = q1.a.a(this.f22013a) * 31;
        Long l8 = this.f22014b;
        int hashCode = (a8 + (l8 == null ? 0 : l8.hashCode())) * 31;
        OrderHandle orderHandle = this.f22015c;
        return hashCode + (orderHandle != null ? orderHandle.hashCode() : 0);
    }

    public String toString() {
        double d8 = this.f22013a;
        Long l8 = this.f22014b;
        OrderHandle orderHandle = this.f22015c;
        return "StartWorkingRequest(maxClientDistance=" + d8 + ", destinationId=" + l8 + ", acceptOrderHandle=" + orderHandle + ")";
    }
}
