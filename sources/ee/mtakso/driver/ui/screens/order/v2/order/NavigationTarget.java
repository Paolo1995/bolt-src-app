package ee.mtakso.driver.ui.screens.order.v2.order;

import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationTargetInteractor.kt */
/* loaded from: classes3.dex */
public final class NavigationTarget {

    /* renamed from: a  reason: collision with root package name */
    private final GeoCoordinate f32209a;

    /* renamed from: b  reason: collision with root package name */
    private final OrderState f32210b;

    public NavigationTarget(GeoCoordinate point, OrderState orderState) {
        Intrinsics.f(point, "point");
        Intrinsics.f(orderState, "orderState");
        this.f32209a = point;
        this.f32210b = orderState;
    }

    public final GeoCoordinate a() {
        return this.f32209a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NavigationTarget) {
            NavigationTarget navigationTarget = (NavigationTarget) obj;
            return Intrinsics.a(this.f32209a, navigationTarget.f32209a) && this.f32210b == navigationTarget.f32210b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f32209a.hashCode() * 31) + this.f32210b.hashCode();
    }

    public String toString() {
        GeoCoordinate geoCoordinate = this.f32209a;
        OrderState orderState = this.f32210b;
        return "NavigationTarget(point=" + geoCoordinate + ", orderState=" + orderState + ")";
    }
}
