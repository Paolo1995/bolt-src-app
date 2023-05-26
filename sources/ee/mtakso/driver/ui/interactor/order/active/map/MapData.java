package ee.mtakso.driver.ui.interactor.order.active.map;

import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.geo.Directions;
import ee.mtakso.driver.network.client.order.OrderMapPoint;
import ee.mtakso.driver.service.geo.GeoLocation;
import eu.bolt.android.maps.core.Locatable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapData.kt */
/* loaded from: classes3.dex */
public final class MapData {

    /* renamed from: a  reason: collision with root package name */
    private final GeoLocation f26710a;

    /* renamed from: b  reason: collision with root package name */
    private final List<OrderMapPoint> f26711b;

    /* renamed from: c  reason: collision with root package name */
    private final Directions f26712c;

    /* renamed from: d  reason: collision with root package name */
    private final OrderState f26713d;

    /* renamed from: e  reason: collision with root package name */
    private final Locatable f26714e;

    public MapData(GeoLocation driverLocation, List<OrderMapPoint> points, Directions directions, OrderState orderState, Locatable locatable) {
        Intrinsics.f(driverLocation, "driverLocation");
        Intrinsics.f(points, "points");
        Intrinsics.f(orderState, "orderState");
        this.f26710a = driverLocation;
        this.f26711b = points;
        this.f26712c = directions;
        this.f26713d = orderState;
        this.f26714e = locatable;
    }

    public final GeoLocation a() {
        return this.f26710a;
    }

    public final List<OrderMapPoint> b() {
        return this.f26711b;
    }

    public final Locatable c() {
        return this.f26714e;
    }

    public final Directions d() {
        return this.f26712c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapData) {
            MapData mapData = (MapData) obj;
            return Intrinsics.a(this.f26710a, mapData.f26710a) && Intrinsics.a(this.f26711b, mapData.f26711b) && Intrinsics.a(this.f26712c, mapData.f26712c) && this.f26713d == mapData.f26713d && Intrinsics.a(this.f26714e, mapData.f26714e);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f26710a.hashCode() * 31) + this.f26711b.hashCode()) * 31;
        Directions directions = this.f26712c;
        int hashCode2 = (((hashCode + (directions == null ? 0 : directions.hashCode())) * 31) + this.f26713d.hashCode()) * 31;
        Locatable locatable = this.f26714e;
        return hashCode2 + (locatable != null ? locatable.hashCode() : 0);
    }

    public String toString() {
        GeoLocation geoLocation = this.f26710a;
        List<OrderMapPoint> list = this.f26711b;
        Directions directions = this.f26712c;
        OrderState orderState = this.f26713d;
        Locatable locatable = this.f26714e;
        return "MapData(driverLocation=" + geoLocation + ", points=" + list + ", route=" + directions + ", orderState=" + orderState + ", riderLocation=" + locatable + ")";
    }
}
