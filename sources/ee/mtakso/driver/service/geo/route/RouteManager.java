package ee.mtakso.driver.service.geo.route;

import ee.mtakso.driver.network.client.geo.Directions;
import ee.mtakso.driver.network.client.geo.Distance;
import ee.mtakso.driver.network.client.geo.GeoClient;
import ee.mtakso.driver.network.client.geo.GoogleDirections;
import ee.mtakso.driver.network.client.geo.Leg;
import ee.mtakso.driver.network.client.geo.PolyLine;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RouteManager.kt */
/* loaded from: classes3.dex */
public final class RouteManager {

    /* renamed from: a  reason: collision with root package name */
    private final GeoClient f24421a;

    @Inject
    public RouteManager(GeoClient apiClient) {
        Intrinsics.f(apiClient, "apiClient");
        this.f24421a = apiClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Route c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Route) tmp0.invoke(obj);
    }

    public final Single<Route> b(String str, GeoCoordinate... points) {
        Object F;
        Object U;
        Object[] k8;
        List<GeoCoordinate> f02;
        Intrinsics.f(points, "points");
        if (points.length < 2) {
            Single<Route> error = Single.error(new IllegalArgumentException("At least 2 points required to build route"));
            Intrinsics.e(error, "error(IllegalArgumentExc…equired to build route\"))");
            return error;
        }
        F = ArraysKt___ArraysKt.F(points);
        U = ArraysKt___ArraysKt.U(points);
        k8 = ArraysKt___ArraysJvmKt.k(points, 1, points.length - 1);
        GeoClient geoClient = this.f24421a;
        f02 = ArraysKt___ArraysKt.f0((GeoCoordinate[]) k8);
        Single<Directions> c8 = geoClient.c((GeoCoordinate) F, (GeoCoordinate) U, str, f02);
        final RouteManager$getRoute$1 routeManager$getRoute$1 = new Function1<Directions, Route>() { // from class: ee.mtakso.driver.service.geo.route.RouteManager$getRoute$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Route invoke(Directions it) {
                String str2;
                List<ee.mtakso.driver.network.client.geo.Route> a8;
                ee.mtakso.driver.network.client.geo.Route route;
                List<Leg> a9;
                Leg leg;
                Distance a10;
                List<ee.mtakso.driver.network.client.geo.Route> a11;
                ee.mtakso.driver.network.client.geo.Route route2;
                PolyLine b8;
                Intrinsics.f(it, "it");
                GoogleDirections a12 = it.a();
                String str3 = null;
                if (a12 != null && (a11 = a12.a()) != null && (route2 = a11.get(0)) != null && (b8 = route2.b()) != null) {
                    str2 = b8.a();
                } else {
                    str2 = null;
                }
                GoogleDirections a13 = it.a();
                if (a13 != null && (a8 = a13.a()) != null && (route = a8.get(0)) != null && (a9 = route.a()) != null && (leg = a9.get(0)) != null && (a10 = leg.a()) != null) {
                    str3 = a10.a();
                }
                return new Route(str2, str3);
            }
        };
        Single x7 = c8.x(new Function() { // from class: ee.mtakso.driver.service.geo.route.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Route c9;
                c9 = RouteManager.c(Function1.this, obj);
                return c9;
            }
        });
        Intrinsics.e(x7, "apiClient.getDrivingDire…nce?.text\n            ) }");
        return x7;
    }
}
