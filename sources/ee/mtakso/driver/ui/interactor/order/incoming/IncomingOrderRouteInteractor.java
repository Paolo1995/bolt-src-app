package ee.mtakso.driver.ui.interactor.order.incoming;

import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.geo.route.Route;
import ee.mtakso.driver.service.geo.route.RouteManager;
import eu.bolt.driver.core.util.Optional;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncomingOrderRouteInteractor.kt */
/* loaded from: classes3.dex */
public final class IncomingOrderRouteInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final RouteManager f26742a;

    @Inject
    public IncomingOrderRouteInteractor(RouteManager routeManager) {
        Intrinsics.f(routeManager, "routeManager");
        this.f26742a = routeManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IncomingOrderRoute h(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (IncomingOrderRoute) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IncomingOrderRoute i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (IncomingOrderRoute) tmp0.invoke(obj);
    }

    public final Single<IncomingOrderRoute> e(String str, GeoCoordinate... points) {
        Object[] k8;
        Intrinsics.f(points, "points");
        Kalev.d("Loading route: " + str + " " + points);
        if (points.length > 2) {
            Single<Route> b8 = this.f26742a.b(str, points[0], points[1]);
            final IncomingOrderRouteInteractor$loadRoute$routeToPickupSingle$1 incomingOrderRouteInteractor$loadRoute$routeToPickupSingle$1 = new Function1<Route, Optional<Route>>() { // from class: ee.mtakso.driver.ui.interactor.order.incoming.IncomingOrderRouteInteractor$loadRoute$routeToPickupSingle$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final Optional<Route> invoke(Route it) {
                    Intrinsics.f(it, "it");
                    return Optional.f41306b.b(it);
                }
            };
            Single<R> x7 = b8.x(new Function() { // from class: ee.mtakso.driver.ui.interactor.order.incoming.a
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Optional f8;
                    f8 = IncomingOrderRouteInteractor.f(Function1.this, obj);
                    return f8;
                }
            });
            Optional.Companion companion = Optional.f41306b;
            Single D = x7.D(companion.a());
            Intrinsics.e(D, "routeManager.getRoute(me…urnItem(Optional.empty())");
            RouteManager routeManager = this.f26742a;
            k8 = ArraysKt___ArraysJvmKt.k(points, 1, points.length);
            GeoCoordinate[] geoCoordinateArr = (GeoCoordinate[]) k8;
            Single<Route> b9 = routeManager.b(str, (GeoCoordinate[]) Arrays.copyOf(geoCoordinateArr, geoCoordinateArr.length));
            final IncomingOrderRouteInteractor$loadRoute$routeToDestSingle$1 incomingOrderRouteInteractor$loadRoute$routeToDestSingle$1 = new Function1<Route, Optional<Route>>() { // from class: ee.mtakso.driver.ui.interactor.order.incoming.IncomingOrderRouteInteractor$loadRoute$routeToDestSingle$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final Optional<Route> invoke(Route it) {
                    Intrinsics.f(it, "it");
                    return Optional.f41306b.b(it);
                }
            };
            Single D2 = b9.x(new Function() { // from class: ee.mtakso.driver.ui.interactor.order.incoming.b
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Optional g8;
                    g8 = IncomingOrderRouteInteractor.g(Function1.this, obj);
                    return g8;
                }
            }).D(companion.a());
            Intrinsics.e(D2, "routeManager.getRoute(me…urnItem(Optional.empty())");
            final IncomingOrderRouteInteractor$loadRoute$1 incomingOrderRouteInteractor$loadRoute$1 = new Function2<Optional<Route>, Optional<Route>, IncomingOrderRoute>() { // from class: ee.mtakso.driver.ui.interactor.order.incoming.IncomingOrderRouteInteractor$loadRoute$1
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final IncomingOrderRoute s(Optional<Route> r12, Optional<Route> r22) {
                    Intrinsics.f(r12, "r1");
                    Intrinsics.f(r22, "r2");
                    return new IncomingOrderRoute(r12.b(), r22.b());
                }
            };
            Single<IncomingOrderRoute> V = Single.V(D, D2, new BiFunction() { // from class: ee.mtakso.driver.ui.interactor.order.incoming.c
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    IncomingOrderRoute h8;
                    h8 = IncomingOrderRouteInteractor.h(Function2.this, obj, obj2);
                    return h8;
                }
            });
            Intrinsics.e(V, "{\n            val routeT…alueOrNull()) }\n        }");
            return V;
        }
        Single<Route> b10 = this.f26742a.b(str, (GeoCoordinate[]) Arrays.copyOf(points, points.length));
        final IncomingOrderRouteInteractor$loadRoute$2 incomingOrderRouteInteractor$loadRoute$2 = new Function1<Route, IncomingOrderRoute>() { // from class: ee.mtakso.driver.ui.interactor.order.incoming.IncomingOrderRouteInteractor$loadRoute$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final IncomingOrderRoute invoke(Route it) {
                Intrinsics.f(it, "it");
                return new IncomingOrderRoute(it, null);
            }
        };
        Single x8 = b10.x(new Function() { // from class: ee.mtakso.driver.ui.interactor.order.incoming.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                IncomingOrderRoute i8;
                i8 = IncomingOrderRouteInteractor.i(Function1.this, obj);
                return i8;
            }
        });
        Intrinsics.e(x8, "{\n            routeManag…ation = null) }\n        }");
        return x8;
    }
}
