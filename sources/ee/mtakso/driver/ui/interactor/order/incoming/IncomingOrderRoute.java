package ee.mtakso.driver.ui.interactor.order.incoming;

import ee.mtakso.driver.service.geo.route.Route;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncomingOrderRoute.kt */
/* loaded from: classes3.dex */
public final class IncomingOrderRoute {

    /* renamed from: a  reason: collision with root package name */
    private final Route f26740a;

    /* renamed from: b  reason: collision with root package name */
    private final Route f26741b;

    public IncomingOrderRoute(Route route, Route route2) {
        this.f26740a = route;
        this.f26741b = route2;
    }

    public final Route a() {
        return this.f26741b;
    }

    public final Route b() {
        return this.f26740a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IncomingOrderRoute) {
            IncomingOrderRoute incomingOrderRoute = (IncomingOrderRoute) obj;
            return Intrinsics.a(this.f26740a, incomingOrderRoute.f26740a) && Intrinsics.a(this.f26741b, incomingOrderRoute.f26741b);
        }
        return false;
    }

    public int hashCode() {
        Route route = this.f26740a;
        int hashCode = (route == null ? 0 : route.hashCode()) * 31;
        Route route2 = this.f26741b;
        return hashCode + (route2 != null ? route2.hashCode() : 0);
    }

    public String toString() {
        Route route = this.f26740a;
        Route route2 = this.f26741b;
        return "IncomingOrderRoute(routeToPickup=" + route + ", routeToDestination=" + route2 + ")";
    }
}
