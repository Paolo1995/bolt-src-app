package ee.mtakso.driver.ui.screens.order.scheduled;

import ee.mtakso.driver.network.client.order.OrderMapPoint;
import eu.bolt.android.maps.core.GeoUtils;
import eu.bolt.android.maps.core.Locatable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderMapPointsFactory.kt */
/* loaded from: classes3.dex */
public final class OrderMapPointsFactory {
    public final OrderMapPoints a(List<OrderMapPoint> points) {
        int v7;
        List n8;
        Intrinsics.f(points, "points");
        Locatable b8 = GeoUtils.f36938a.b(points);
        v7 = CollectionsKt__IterablesKt.v(points, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (OrderMapPoint orderMapPoint : points) {
            arrayList.add(new MapPointWithBearing(orderMapPoint, GeoUtils.f36938a.d(orderMapPoint, b8)));
        }
        GeoUtils geoUtils = GeoUtils.f36938a;
        double n9 = geoUtils.n(points, new Function1<Locatable, Double>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.OrderMapPointsFactory$map$maxLon$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Double invoke(Locatable it) {
                Intrinsics.f(it, "it");
                return Double.valueOf(it.b());
            }
        });
        double o8 = geoUtils.o(points, new Function1<Locatable, Double>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.OrderMapPointsFactory$map$minLon$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Double invoke(Locatable it) {
                Intrinsics.f(it, "it");
                return Double.valueOf(it.b());
            }
        });
        double n10 = geoUtils.n(points, new Function1<Locatable, Double>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.OrderMapPointsFactory$map$maxLat$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Double invoke(Locatable it) {
                Intrinsics.f(it, "it");
                return Double.valueOf(it.a());
            }
        });
        double o9 = geoUtils.o(points, new Function1<Locatable, Double>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.OrderMapPointsFactory$map$minLat$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Double invoke(Locatable it) {
                Intrinsics.f(it, "it");
                return Double.valueOf(it.a());
            }
        });
        double e8 = geoUtils.e(n10, n9, n10, o8);
        double e9 = geoUtils.e(n10, o8, o9, o8) * 0.6d;
        double d8 = 0.6d * e8;
        n8 = CollectionsKt__CollectionsKt.n(geoUtils.g(b8, e9, 0.0d), geoUtils.g(b8, d8, 90.0d), geoUtils.g(b8, e9, 180.0d), geoUtils.g(b8, d8, 270.0d));
        return new OrderMapPoints(n8, arrayList);
    }
}
