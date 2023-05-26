package ee.mtakso.driver.ui.interactor.driver;

import ee.mtakso.driver.network.client.settings.DriverDestination;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.WorkDistanceDelegate;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.modules.fifo.FifoQueueManager;
import ee.mtakso.driver.service.modules.fifo.FifoQueueState;
import ee.mtakso.driver.utils.Optional;
import eu.bolt.driver.core.network.client.driver.DriverAppConfig;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverAreaInteractor.kt */
/* loaded from: classes3.dex */
public final class DriverAreaInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f26451a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverDestinationsManager f26452b;

    /* renamed from: c  reason: collision with root package name */
    private final WorkDistanceDelegate f26453c;

    /* renamed from: d  reason: collision with root package name */
    private final FifoQueueManager f26454d;

    /* renamed from: e  reason: collision with root package name */
    private final GeoLocationManager f26455e;

    @Inject
    public DriverAreaInteractor(DriverProvider driverProvider, DriverDestinationsManager destinationsManager, WorkDistanceDelegate workDistanceDelegate, FifoQueueManager fifoQueueManager, GeoLocationManager locationManager) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(destinationsManager, "destinationsManager");
        Intrinsics.f(workDistanceDelegate, "workDistanceDelegate");
        Intrinsics.f(fifoQueueManager, "fifoQueueManager");
        Intrinsics.f(locationManager, "locationManager");
        this.f26451a = driverProvider;
        this.f26452b = destinationsManager;
        this.f26453c = workDistanceDelegate;
        this.f26454d = fifoQueueManager;
        this.f26455e = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DriverArea d(GeoLocation geoLocation, DriverDestination driverDestination, Integer num, FifoQueueState fifoQueueState) {
        Integer num2;
        GeoCoordinate geoCoordinate = null;
        if (driverDestination != null) {
            if (driverDestination.c() != null && driverDestination.d() != null) {
                geoCoordinate = new GeoCoordinate(driverDestination.c().doubleValue(), driverDestination.d().doubleValue());
            }
            return new DriverArea(geoLocation.e(), geoLocation.a(), null, geoCoordinate);
        }
        if (this.f26451a.m().R() && !(fifoQueueState instanceof FifoQueueState.InQueue)) {
            num2 = num;
        } else {
            num2 = null;
        }
        return new DriverArea(geoLocation.e(), geoLocation.a(), num2, null);
    }

    private final Observable<Optional<DriverDestination>> e() {
        return this.f26452b.F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverArea g(Function4 tmp0, Object obj, Object obj2, Object obj3, Object obj4) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverArea) tmp0.f(obj, obj2, obj3, obj4);
    }

    private final Observable<FifoQueueState> h() {
        return this.f26454d.q();
    }

    private final Observable<GeoLocation> i() {
        return this.f26455e.u(1L);
    }

    private final Observable<Optional<Integer>> j() {
        Observable<DriverAppConfig.MaxClientDistance> u7 = this.f26453c.u();
        final DriverAreaInteractor$observeRadius$1 driverAreaInteractor$observeRadius$1 = new Function1<DriverAppConfig.MaxClientDistance, Optional<Integer>>() { // from class: ee.mtakso.driver.ui.interactor.driver.DriverAreaInteractor$observeRadius$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<Integer> invoke(DriverAppConfig.MaxClientDistance it) {
                Intrinsics.f(it, "it");
                return Optional.f(Integer.valueOf(it.a()));
            }
        };
        Observable<Optional<Integer>> startWith = u7.map(new Function() { // from class: ee.mtakso.driver.ui.interactor.driver.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional k8;
                k8 = DriverAreaInteractor.k(Function1.this, obj);
                return k8;
            }
        }).startWith((Observable<R>) Optional.a());
        Intrinsics.e(startWith, "workDistanceDelegate.obs…artWith(Optional.empty())");
        return startWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    public final Observable<DriverArea> f() {
        Observable<GeoLocation> i8 = i();
        Observable<Optional<DriverDestination>> e8 = e();
        Observable<Optional<Integer>> j8 = j();
        Observable<FifoQueueState> h8 = h();
        final Function4<GeoLocation, Optional<DriverDestination>, Optional<Integer>, FifoQueueState, DriverArea> function4 = new Function4<GeoLocation, Optional<DriverDestination>, Optional<Integer>, FifoQueueState, DriverArea>() { // from class: ee.mtakso.driver.ui.interactor.driver.DriverAreaInteractor$observeDriverArea$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            /* renamed from: b */
            public final DriverArea f(GeoLocation location, Optional<DriverDestination> destination, Optional<Integer> radius, FifoQueueState fifoQueueState) {
                DriverArea d8;
                Intrinsics.f(location, "location");
                Intrinsics.f(destination, "destination");
                Intrinsics.f(radius, "radius");
                Intrinsics.f(fifoQueueState, "fifoQueueState");
                d8 = DriverAreaInteractor.this.d(location, destination.c(), radius.c(), fifoQueueState);
                return d8;
            }
        };
        Observable<DriverArea> combineLatest = Observable.combineLatest(i8, e8, j8, h8, new io.reactivex.functions.Function4() { // from class: ee.mtakso.driver.ui.interactor.driver.a
            @Override // io.reactivex.functions.Function4
            public final Object a(Object obj, Object obj2, Object obj3, Object obj4) {
                DriverArea g8;
                g8 = DriverAreaInteractor.g(Function4.this, obj, obj2, obj3, obj4);
                return g8;
            }
        });
        Intrinsics.e(combineLatest, "fun observeDriverArea():…tate)\n            }\n    }");
        return combineLatest;
    }
}
