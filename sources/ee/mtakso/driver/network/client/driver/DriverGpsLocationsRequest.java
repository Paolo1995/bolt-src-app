package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tracking.kt */
/* loaded from: classes3.dex */
public final class DriverGpsLocationsRequest {
    @SerializedName("order_handle")

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f21924a;
    @SerializedName("locations")

    /* renamed from: b  reason: collision with root package name */
    private final List<DriverGpsLocation> f21925b;

    public DriverGpsLocationsRequest(OrderHandle orderHandle, List<DriverGpsLocation> locations) {
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(locations, "locations");
        this.f21924a = orderHandle;
        this.f21925b = locations;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverGpsLocationsRequest) {
            DriverGpsLocationsRequest driverGpsLocationsRequest = (DriverGpsLocationsRequest) obj;
            return Intrinsics.a(this.f21924a, driverGpsLocationsRequest.f21924a) && Intrinsics.a(this.f21925b, driverGpsLocationsRequest.f21925b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f21924a.hashCode() * 31) + this.f21925b.hashCode();
    }

    public String toString() {
        OrderHandle orderHandle = this.f21924a;
        List<DriverGpsLocation> list = this.f21925b;
        return "DriverGpsLocationsRequest(orderHandle=" + orderHandle + ", locations=" + list + ")";
    }
}
