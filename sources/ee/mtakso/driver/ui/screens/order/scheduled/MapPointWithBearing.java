package ee.mtakso.driver.ui.screens.order.scheduled;

import ee.mtakso.driver.network.client.order.OrderMapPoint;
import eu.bolt.android.maps.core.Locatable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapPointWithBearing.kt */
/* loaded from: classes3.dex */
public final class MapPointWithBearing implements Locatable {

    /* renamed from: f  reason: collision with root package name */
    private final OrderMapPoint f31593f;

    /* renamed from: g  reason: collision with root package name */
    private final double f31594g;

    public MapPointWithBearing(OrderMapPoint point, double d8) {
        Intrinsics.f(point, "point");
        this.f31593f = point;
        this.f31594g = d8;
    }

    @Override // eu.bolt.android.maps.core.Locatable
    public double a() {
        return this.f31593f.a();
    }

    @Override // eu.bolt.android.maps.core.Locatable
    public double b() {
        return this.f31593f.b();
    }

    public final double c() {
        return this.f31594g;
    }

    public final OrderMapPoint d() {
        return this.f31593f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapPointWithBearing) {
            MapPointWithBearing mapPointWithBearing = (MapPointWithBearing) obj;
            return Intrinsics.a(this.f31593f, mapPointWithBearing.f31593f) && Double.compare(this.f31594g, mapPointWithBearing.f31594g) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (this.f31593f.hashCode() * 31) + q1.a.a(this.f31594g);
    }

    public String toString() {
        OrderMapPoint orderMapPoint = this.f31593f;
        double d8 = this.f31594g;
        return "MapPointWithBearing(point=" + orderMapPoint + ", bearing=" + d8 + ")";
    }
}
