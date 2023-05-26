package ee.mtakso.driver.service.geo.transmitter;

import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.order.details.OrderDetails;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationWithOrders.kt */
/* loaded from: classes3.dex */
public final class LocationWithOrders {

    /* renamed from: a  reason: collision with root package name */
    private final GeoLocation f24485a;

    /* renamed from: b  reason: collision with root package name */
    private final List<OrderDetails> f24486b;

    /* JADX WARN: Multi-variable type inference failed */
    public LocationWithOrders(GeoLocation location, List<? extends OrderDetails> orders) {
        Intrinsics.f(location, "location");
        Intrinsics.f(orders, "orders");
        this.f24485a = location;
        this.f24486b = orders;
    }

    public final GeoLocation a() {
        return this.f24485a;
    }

    public final List<OrderDetails> b() {
        return this.f24486b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocationWithOrders) {
            LocationWithOrders locationWithOrders = (LocationWithOrders) obj;
            return Intrinsics.a(this.f24485a, locationWithOrders.f24485a) && Intrinsics.a(this.f24486b, locationWithOrders.f24486b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f24485a.hashCode() * 31) + this.f24486b.hashCode();
    }

    public String toString() {
        GeoLocation geoLocation = this.f24485a;
        List<OrderDetails> list = this.f24486b;
        return "LocationWithOrders(location=" + geoLocation + ", orders=" + list + ")";
    }
}
