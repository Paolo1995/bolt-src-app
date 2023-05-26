package ee.mtakso.driver.service.geo.storage;

import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoutePoint.kt */
/* loaded from: classes3.dex */
public final class RoutePoint {

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f24447a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationEntity f24448b;

    public RoutePoint(OrderHandle orderHandle, LocationEntity point) {
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(point, "point");
        this.f24447a = orderHandle;
        this.f24448b = point;
    }

    public final LocationEntity a() {
        return this.f24448b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RoutePoint) {
            RoutePoint routePoint = (RoutePoint) obj;
            return Intrinsics.a(this.f24447a, routePoint.f24447a) && Intrinsics.a(this.f24448b, routePoint.f24448b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f24447a.hashCode() * 31) + this.f24448b.hashCode();
    }

    public String toString() {
        OrderHandle orderHandle = this.f24447a;
        LocationEntity locationEntity = this.f24448b;
        return "RoutePoint(orderHandle=" + orderHandle + ", point=" + locationEntity + ")";
    }
}
