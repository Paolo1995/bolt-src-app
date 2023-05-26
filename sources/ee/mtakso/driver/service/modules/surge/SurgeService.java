package ee.mtakso.driver.service.modules.surge;

import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.surge.SurgeMap;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurgeService.kt */
/* loaded from: classes3.dex */
public final class SurgeService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final SurgeManager f25302b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverStatusProvider f25303c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverClient f25304d;

    /* renamed from: e  reason: collision with root package name */
    private final GeoLocationManager f25305e;

    @Inject
    public SurgeService(SurgeManager surgeManager, DriverStatusProvider driverStatusProvider, DriverClient driverApi, GeoLocationManager locationManager) {
        Intrinsics.f(surgeManager, "surgeManager");
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        Intrinsics.f(driverApi, "driverApi");
        Intrinsics.f(locationManager, "locationManager");
        this.f25302b = surgeManager;
        this.f25303c = driverStatusProvider;
        this.f25304d = driverApi;
        this.f25305e = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GeoLocation p(DriverStatus driverStatus, GeoLocation location) {
        Intrinsics.f(driverStatus, "<anonymous parameter 0>");
        Intrinsics.f(location, "location");
        return location;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Single<Optional<SurgeMap>> t(GeoLocation geoLocation) {
        Single<Optional<SurgeMap>> j8 = this.f25304d.j(geoLocation.e());
        final SurgeService$requestSurges$1 surgeService$requestSurges$1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.surge.SurgeService$requestSurges$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to request surges!");
            }
        };
        Single<Optional<SurgeMap>> C = j8.l(new Consumer() { // from class: ee.mtakso.driver.service.modules.surge.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SurgeService.u(Function1.this, obj);
            }
        }).C(new Function() { // from class: ee.mtakso.driver.service.modules.surge.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional v7;
                v7 = SurgeService.v((Throwable) obj);
                return v7;
            }
        });
        Intrinsics.e(C, "driverApi.getCurrentSurg…turn { Optional.empty() }");
        return C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional v(Throwable it) {
        Intrinsics.f(it, "it");
        return Optional.a();
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<DriverStatus> g8 = this.f25303c.g();
        final SurgeService$doStart$1 surgeService$doStart$1 = new Function1<DriverStatus, Boolean>() { // from class: ee.mtakso.driver.service.modules.surge.SurgeService$doStart$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(DriverStatus it) {
                boolean z7;
                Intrinsics.f(it, "it");
                if (it != DriverStatus.INACTIVE && it != DriverStatus.WAITING_ORDER) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<R> withLatestFrom = g8.filter(new Predicate() { // from class: ee.mtakso.driver.service.modules.surge.b
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean o8;
                o8 = SurgeService.o(Function1.this, obj);
                return o8;
            }
        }).throttleFirst(60L, TimeUnit.SECONDS).withLatestFrom(this.f25305e.u(1L), new BiFunction() { // from class: ee.mtakso.driver.service.modules.surge.c
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                GeoLocation p8;
                p8 = SurgeService.p((DriverStatus) obj, (GeoLocation) obj2);
                return p8;
            }
        });
        final Function1<GeoLocation, SingleSource<? extends Optional<SurgeMap>>> function1 = new Function1<GeoLocation, SingleSource<? extends Optional<SurgeMap>>>() { // from class: ee.mtakso.driver.service.modules.surge.SurgeService$doStart$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends Optional<SurgeMap>> invoke(GeoLocation it) {
                Single t7;
                Intrinsics.f(it, "it");
                t7 = SurgeService.this.t(it);
                return SingleExtKt.d(t7);
            }
        };
        Observable flatMapSingle = withLatestFrom.flatMapSingle(new Function() { // from class: ee.mtakso.driver.service.modules.surge.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource q8;
                q8 = SurgeService.q(Function1.this, obj);
                return q8;
            }
        });
        Intrinsics.e(flatMapSingle, "override fun doStart(): … SurgeService!\") })\n    }");
        Observable g9 = ObservableExtKt.g(flatMapSingle);
        final Function1<Optional<SurgeMap>, Unit> function12 = new Function1<Optional<SurgeMap>, Unit>() { // from class: ee.mtakso.driver.service.modules.surge.SurgeService$doStart$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<SurgeMap> it) {
                SurgeManager surgeManager;
                surgeManager = SurgeService.this.f25302b;
                Intrinsics.e(it, "it");
                surgeManager.f(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<SurgeMap> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.surge.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SurgeService.r(Function1.this, obj);
            }
        };
        final SurgeService$doStart$5 surgeService$doStart$5 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.surge.SurgeService$doStart$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Exception on SurgeService!");
            }
        };
        Disposable subscribe = g9.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.surge.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SurgeService.s(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): … SurgeService!\") })\n    }");
        return subscribe;
    }
}
