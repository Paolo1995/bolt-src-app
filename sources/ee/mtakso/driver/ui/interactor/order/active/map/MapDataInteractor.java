package ee.mtakso.driver.ui.interactor.order.active.map;

import ee.mtakso.driver.network.client.geo.Directions;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.interactor.order.active.map.MapDataInteractor;
import ee.mtakso.driver.ui.screens.order.v2.map.RouteProvider;
import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.android.maps.core.Locatable;
import eu.bolt.driver.core.util.Optional;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapDataInteractor.kt */
/* loaded from: classes3.dex */
public final class MapDataInteractor {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f26715e = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final GeoLocationManager f26716a;

    /* renamed from: b  reason: collision with root package name */
    private final OrderProvider f26717b;

    /* renamed from: c  reason: collision with root package name */
    private final RouteProvider f26718c;

    /* renamed from: d  reason: collision with root package name */
    private Disposable f26719d;

    /* compiled from: MapDataInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MapDataInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class DriverLocationAndOrder {

        /* renamed from: a  reason: collision with root package name */
        private final GeoLocation f26720a;

        /* renamed from: b  reason: collision with root package name */
        private final ActiveOrderDetails f26721b;

        public DriverLocationAndOrder(GeoLocation driverLocation, ActiveOrderDetails order) {
            Intrinsics.f(driverLocation, "driverLocation");
            Intrinsics.f(order, "order");
            this.f26720a = driverLocation;
            this.f26721b = order;
        }

        public final GeoLocation a() {
            return this.f26720a;
        }

        public final ActiveOrderDetails b() {
            return this.f26721b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DriverLocationAndOrder) {
                DriverLocationAndOrder driverLocationAndOrder = (DriverLocationAndOrder) obj;
                return Intrinsics.a(this.f26720a, driverLocationAndOrder.f26720a) && Intrinsics.a(this.f26721b, driverLocationAndOrder.f26721b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f26720a.hashCode() * 31) + this.f26721b.hashCode();
        }

        public String toString() {
            GeoLocation geoLocation = this.f26720a;
            ActiveOrderDetails activeOrderDetails = this.f26721b;
            return "DriverLocationAndOrder(driverLocation=" + geoLocation + ", order=" + activeOrderDetails + ")";
        }
    }

    @Inject
    public MapDataInteractor(GeoLocationManager locationManager, OrderProvider orderProvider, RouteProvider routeProvider) {
        Intrinsics.f(locationManager, "locationManager");
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(routeProvider, "routeProvider");
        this.f26716a = locationManager;
        this.f26717b = orderProvider;
        this.f26718c = routeProvider;
    }

    private final Observable<ActiveOrderDetails> h() {
        return ObservableExtKt.k(this.f26717b.a(), new Function1<List<? extends OrderDetails>, ActiveOrderDetails>() { // from class: ee.mtakso.driver.ui.interactor.order.active.map.MapDataInteractor$observeActiveOrder$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ActiveOrderDetails invoke(List<? extends OrderDetails> orders) {
                Intrinsics.f(orders, "orders");
                return OrderProviderUtils.j(orders);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MapData j(Function3 tmp0, Object obj, Object obj2, Object obj3) {
        Intrinsics.f(tmp0, "$tmp0");
        return (MapData) tmp0.l(obj, obj2, obj3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(MapDataInteractor this$0) {
        Intrinsics.f(this$0, "this$0");
        Disposable disposable = this$0.f26719d;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    private final Observable<Optional<Directions>> l() {
        Disposable disposable = this.f26719d;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<GeoLocation> u7 = this.f26716a.u(1L);
        Observable<ActiveOrderDetails> h8 = h();
        final MapDataInteractor$observeRoute$locationWithOrder$1 mapDataInteractor$observeRoute$locationWithOrder$1 = new Function2<GeoLocation, ActiveOrderDetails, DriverLocationAndOrder>() { // from class: ee.mtakso.driver.ui.interactor.order.active.map.MapDataInteractor$observeRoute$locationWithOrder$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final MapDataInteractor.DriverLocationAndOrder s(GeoLocation location, ActiveOrderDetails model) {
                Intrinsics.f(location, "location");
                Intrinsics.f(model, "model");
                return new MapDataInteractor.DriverLocationAndOrder(location, model);
            }
        };
        Observable combineLatest = Observable.combineLatest(u7, h8, new BiFunction() { // from class: ee.mtakso.driver.ui.interactor.order.active.map.c
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                MapDataInteractor.DriverLocationAndOrder m8;
                m8 = MapDataInteractor.m(Function2.this, obj, obj2);
                return m8;
            }
        });
        Intrinsics.e(combineLatest, "combineLatest(\n         …dOrder(location, model) }");
        final Function1<DriverLocationAndOrder, Unit> function1 = new Function1<DriverLocationAndOrder, Unit>() { // from class: ee.mtakso.driver.ui.interactor.order.active.map.MapDataInteractor$observeRoute$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(MapDataInteractor.DriverLocationAndOrder driverLocationAndOrder) {
                RouteProvider routeProvider;
                routeProvider = MapDataInteractor.this.f26718c;
                routeProvider.n(driverLocationAndOrder.a().e(), (Locatable) CollectionsKt___CollectionsKt.Y(driverLocationAndOrder.b().i().l()), driverLocationAndOrder.b().i().z());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MapDataInteractor.DriverLocationAndOrder driverLocationAndOrder) {
                b(driverLocationAndOrder);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.interactor.order.active.map.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MapDataInteractor.n(Function1.this, obj);
            }
        };
        final MapDataInteractor$observeRoute$2 mapDataInteractor$observeRoute$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.interactor.order.active.map.MapDataInteractor$observeRoute$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to observe route updates");
            }
        };
        this.f26719d = combineLatest.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.interactor.order.active.map.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MapDataInteractor.o(Function1.this, obj);
            }
        });
        Observable<Directions> m8 = this.f26718c.m();
        final MapDataInteractor$observeRoute$3 mapDataInteractor$observeRoute$3 = new Function1<Directions, Optional<Directions>>() { // from class: ee.mtakso.driver.ui.interactor.order.active.map.MapDataInteractor$observeRoute$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<Directions> invoke(Directions it) {
                Intrinsics.f(it, "it");
                return Optional.f41306b.b(it);
            }
        };
        Observable<Optional<Directions>> startWith = m8.map(new Function() { // from class: ee.mtakso.driver.ui.interactor.order.active.map.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional p8;
                p8 = MapDataInteractor.p(Function1.this, obj);
                return p8;
            }
        }).startWith((Observable<R>) Optional.f41306b.a());
        Intrinsics.e(startWith, "routeProvider.observeRou…artWith(Optional.empty())");
        return startWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverLocationAndOrder m(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverLocationAndOrder) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    public final Observable<MapData> i() {
        Observable<GeoLocation> t7 = this.f26716a.t();
        Observable<ActiveOrderDetails> h8 = h();
        Observable<Optional<Directions>> l8 = l();
        final MapDataInteractor$observeMapData$1 mapDataInteractor$observeMapData$1 = new Function3<GeoLocation, ActiveOrderDetails, Optional<Directions>, MapData>() { // from class: ee.mtakso.driver.ui.interactor.order.active.map.MapDataInteractor$observeMapData$1
            @Override // kotlin.jvm.functions.Function3
            /* renamed from: b */
            public final MapData l(GeoLocation location, ActiveOrderDetails order, Optional<Directions> routeOpt) {
                Intrinsics.f(location, "location");
                Intrinsics.f(order, "order");
                Intrinsics.f(routeOpt, "routeOpt");
                return new MapData(location, order.i().l(), routeOpt.b(), order.b(), order.k());
            }
        };
        Observable<MapData> doOnDispose = Observable.combineLatest(t7, h8, l8, new io.reactivex.functions.Function3() { // from class: ee.mtakso.driver.ui.interactor.order.active.map.a
            @Override // io.reactivex.functions.Function3
            public final Object a(Object obj, Object obj2, Object obj3) {
                MapData j8;
                j8 = MapDataInteractor.j(Function3.this, obj, obj2, obj3);
                return j8;
            }
        }).doOnDispose(new Action() { // from class: ee.mtakso.driver.ui.interactor.order.active.map.b
            @Override // io.reactivex.functions.Action
            public final void run() {
                MapDataInteractor.k(MapDataInteractor.this);
            }
        });
        Intrinsics.e(doOnDispose, "combineLatest(\n         …?.dispose()\n            }");
        return doOnDispose;
    }
}
