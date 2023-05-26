package ee.mtakso.driver.service.geo.transmitter;

import ee.mtakso.driver.network.client.OrderStateKt;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.utils.AssertUtils;
import ee.mtakso.driver.utils.DisposableExtKt;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TransmissionService.kt */
/* loaded from: classes3.dex */
public final class TransmissionService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final DriverStatusProvider f24487b;

    /* renamed from: c  reason: collision with root package name */
    private final GeoLocationManager f24488c;

    /* renamed from: d  reason: collision with root package name */
    private final OrderProvider f24489d;

    /* renamed from: e  reason: collision with root package name */
    private final LocationTransmitter f24490e;

    /* renamed from: f  reason: collision with root package name */
    private final DriverConfig f24491f;

    /* renamed from: g  reason: collision with root package name */
    private Disposable f24492g;

    /* renamed from: h  reason: collision with root package name */
    private Disposable f24493h;

    @Inject
    public TransmissionService(DriverStatusProvider driverStatusProvider, GeoLocationManager locationManager, OrderProvider orderProvider, LocationTransmitter transmitter, DriverConfig driverConfig) {
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        Intrinsics.f(locationManager, "locationManager");
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(transmitter, "transmitter");
        Intrinsics.f(driverConfig, "driverConfig");
        this.f24487b = driverStatusProvider;
        this.f24488c = locationManager;
        this.f24489d = orderProvider;
        this.f24490e = transmitter;
        this.f24491f = driverConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        J();
        long w7 = this.f24491f.w();
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "Starting location observer. Location throttle: " + w7, null, 2, null);
        }
        Observable<GeoLocation> doOnDispose = this.f24488c.u(w7).doOnDispose(new Action() { // from class: ee.mtakso.driver.service.geo.transmitter.k
            @Override // io.reactivex.functions.Action
            public final void run() {
                TransmissionService.B();
            }
        });
        final Function1<GeoLocation, Unit> function1 = new Function1<GeoLocation, Unit>() { // from class: ee.mtakso.driver.service.geo.transmitter.TransmissionService$startLocationCollection$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(GeoLocation location) {
                DriverStatusProvider driverStatusProvider;
                boolean z7;
                OrderProvider orderProvider;
                LocationTransmitter locationTransmitter;
                GeoLocationManager geoLocationManager;
                driverStatusProvider = TransmissionService.this.f24487b;
                if (driverStatusProvider.n() == DriverStatus.ACTIVE_ORDER) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                AssertUtils.g(z7, null, 2, null);
                FastLog g9 = Kalev.f41674e.g();
                if (g9 != null) {
                    FastLog.DefaultImpls.a(g9, "Location storing...", null, 2, null);
                }
                orderProvider = TransmissionService.this.f24489d;
                List<OrderDetails> f8 = orderProvider.f();
                ArrayList arrayList = new ArrayList();
                for (Object obj : f8) {
                    if (!OrderStateKt.b(((OrderDetails) obj).b())) {
                        arrayList.add(obj);
                    }
                }
                locationTransmitter = TransmissionService.this.f24490e;
                Intrinsics.e(location, "location");
                LocationWithOrders locationWithOrders = new LocationWithOrders(location, arrayList);
                geoLocationManager = TransmissionService.this.f24488c;
                locationTransmitter.j(locationWithOrders, geoLocationManager.s());
                FastLog g10 = Kalev.f41674e.g();
                if (g10 != null) {
                    FastLog.DefaultImpls.a(g10, "Location stored", null, 2, null);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GeoLocation geoLocation) {
                b(geoLocation);
                return Unit.f50853a;
            }
        };
        Consumer<? super GeoLocation> consumer = new Consumer() { // from class: ee.mtakso.driver.service.geo.transmitter.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransmissionService.C(Function1.this, obj);
            }
        };
        final TransmissionService$startLocationCollection$3 transmissionService$startLocationCollection$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.geo.transmitter.TransmissionService$startLocationCollection$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Location observing failure");
            }
        };
        this.f24492g = doOnDispose.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.geo.transmitter.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransmissionService.D(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B() {
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "Stopping location observer", null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        K();
        long u7 = this.f24491f.u();
        int v7 = this.f24491f.v();
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "Starting location transmitter. Interval: " + u7 + ". Batch size: " + v7, null, 2, null);
        }
        Observable<Long> interval = Observable.interval(u7, u7, TimeUnit.SECONDS, Schedulers.a());
        final TransmissionService$startLocationTransmission$1 transmissionService$startLocationTransmission$1 = new TransmissionService$startLocationTransmission$1(this, v7);
        Completable o8 = interval.flatMapCompletable(new Function() { // from class: ee.mtakso.driver.service.geo.transmitter.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource F;
                F = TransmissionService.F(Function1.this, obj);
                return F;
            }
        }).o(new Action() { // from class: ee.mtakso.driver.service.geo.transmitter.h
            @Override // io.reactivex.functions.Action
            public final void run() {
                TransmissionService.G();
            }
        });
        Action action = new Action() { // from class: ee.mtakso.driver.service.geo.transmitter.i
            @Override // io.reactivex.functions.Action
            public final void run() {
                TransmissionService.H();
            }
        };
        final TransmissionService$startLocationTransmission$4 transmissionService$startLocationTransmission$4 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.geo.transmitter.TransmissionService$startLocationTransmission$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to push location batch");
            }
        };
        this.f24493h = o8.G(action, new Consumer() { // from class: ee.mtakso.driver.service.geo.transmitter.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransmissionService.I(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource F(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G() {
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "Stopping location transmission", null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        Disposable disposable = this.f24492g;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        Disposable disposable = this.f24493h;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(TransmissionService this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<DriverStatus> doOnTerminate = this.f24487b.g().distinctUntilChanged().doOnTerminate(new Action() { // from class: ee.mtakso.driver.service.geo.transmitter.d
            @Override // io.reactivex.functions.Action
            public final void run() {
                TransmissionService.x(TransmissionService.this);
            }
        });
        final Function1<DriverStatus, Unit> function1 = new Function1<DriverStatus, Unit>() { // from class: ee.mtakso.driver.service.geo.transmitter.TransmissionService$doStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverStatus driverStatus) {
                if (driverStatus == DriverStatus.ACTIVE_ORDER) {
                    TransmissionService.this.A();
                    TransmissionService.this.E();
                    return;
                }
                TransmissionService.this.J();
                TransmissionService.this.K();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverStatus driverStatus) {
                b(driverStatus);
                return Unit.f50853a;
            }
        };
        Consumer<? super DriverStatus> consumer = new Consumer() { // from class: ee.mtakso.driver.service.geo.transmitter.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransmissionService.y(Function1.this, obj);
            }
        };
        final TransmissionService$doStart$3 transmissionService$doStart$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.geo.transmitter.TransmissionService$doStart$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Transmission service, location state");
            }
        };
        Disposable subscribe = doOnTerminate.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.geo.transmitter.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransmissionService.z(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …te\")\n            })\n    }");
        return subscribe;
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl, ee.mtakso.driver.service.BaseService
    public void stop() {
        super.stop();
        J();
        K();
    }
}
