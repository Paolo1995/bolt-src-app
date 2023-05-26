package ee.mtakso.driver.service.geo.storage;

import ee.mtakso.driver.network.client.OrderHandle;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoutePointList.kt */
/* loaded from: classes3.dex */
public final class RoutePointList {

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f24449a;

    /* renamed from: b  reason: collision with root package name */
    private final List<LocationEntity> f24450b;

    public RoutePointList(OrderHandle orderHandle, List<LocationEntity> points) {
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(points, "points");
        this.f24449a = orderHandle;
        this.f24450b = points;
    }

    public final OrderHandle a() {
        return this.f24449a;
    }

    public final List<LocationEntity> b() {
        return this.f24450b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RoutePointList) {
            RoutePointList routePointList = (RoutePointList) obj;
            return Intrinsics.a(this.f24449a, routePointList.f24449a) && Intrinsics.a(this.f24450b, routePointList.f24450b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f24449a.hashCode() * 31) + this.f24450b.hashCode();
    }

    public String toString() {
        OrderHandle orderHandle = this.f24449a;
        List<LocationEntity> list = this.f24450b;
        return "RoutePointList(orderHandle=" + orderHandle + ", points=" + list + ")";
    }
}
