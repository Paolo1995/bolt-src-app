package ee.mtakso.driver.network.client.incident;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.Intrinsics;
import q1.a;

/* compiled from: OpenIncidentRequest.kt */
/* loaded from: classes3.dex */
public final class OpenIncidentRequest {
    @SerializedName("lat")

    /* renamed from: a  reason: collision with root package name */
    private final double f22271a;
    @SerializedName("lng")

    /* renamed from: b  reason: collision with root package name */
    private final double f22272b;
    @SerializedName("order_handle")

    /* renamed from: c  reason: collision with root package name */
    private final OrderHandle f22273c;

    public OpenIncidentRequest(double d8, double d9, OrderHandle orderHandle) {
        this.f22271a = d8;
        this.f22272b = d9;
        this.f22273c = orderHandle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OpenIncidentRequest) {
            OpenIncidentRequest openIncidentRequest = (OpenIncidentRequest) obj;
            return Double.compare(this.f22271a, openIncidentRequest.f22271a) == 0 && Double.compare(this.f22272b, openIncidentRequest.f22272b) == 0 && Intrinsics.a(this.f22273c, openIncidentRequest.f22273c);
        }
        return false;
    }

    public int hashCode() {
        int a8 = ((a.a(this.f22271a) * 31) + a.a(this.f22272b)) * 31;
        OrderHandle orderHandle = this.f22273c;
        return a8 + (orderHandle == null ? 0 : orderHandle.hashCode());
    }

    public String toString() {
        double d8 = this.f22271a;
        double d9 = this.f22272b;
        OrderHandle orderHandle = this.f22273c;
        return "OpenIncidentRequest(lat=" + d8 + ", lng=" + d9 + ", orderHandle=" + orderHandle + ")";
    }
}
