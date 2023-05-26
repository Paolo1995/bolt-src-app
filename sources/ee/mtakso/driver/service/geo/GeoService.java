package ee.mtakso.driver.service.geo;

import ee.mtakso.driver.service.BaseService;
import ee.mtakso.driver.utils.DisposableExtKt;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeoService.kt */
/* loaded from: classes3.dex */
public final class GeoService implements BaseService {

    /* renamed from: a  reason: collision with root package name */
    private final GeoLocationManager f24402a;

    /* renamed from: b  reason: collision with root package name */
    private Disposable f24403b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24404c;

    @Inject
    public GeoService(GeoLocationManager locationManager) {
        Intrinsics.f(locationManager, "locationManager");
        this.f24402a = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m() {
        Kalev.d("Started location updates");
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
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q() {
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.b(g8, "Stopped location updates", null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final Completable l() {
        if (this.f24404c) {
            Completable d8 = this.f24402a.x().d(this.f24402a.k());
            Intrinsics.e(d8, "{\n            locationMa…ationUpdates())\n        }");
            return d8;
        }
        Completable g8 = Completable.g();
        Intrinsics.e(g8, "{\n            Completable.complete()\n        }");
        return g8;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        this.f24404c = true;
        Completable k8 = this.f24402a.k();
        Action action = new Action() { // from class: ee.mtakso.driver.service.geo.j
            @Override // io.reactivex.functions.Action
            public final void run() {
                GeoService.m();
            }
        };
        final GeoService$start$2 geoService$start$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.geo.GeoService$start$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to start location updates");
            }
        };
        k8.G(action, new Consumer() { // from class: ee.mtakso.driver.service.geo.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GeoService.n(Function1.this, obj);
            }
        });
        Observable<Long> interval = Observable.interval(5L, TimeUnit.SECONDS);
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: ee.mtakso.driver.service.geo.GeoService$start$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Long l8) {
                GeoLocationManager geoLocationManager;
                try {
                    geoLocationManager = GeoService.this.f24402a;
                    geoLocationManager.n();
                } catch (Throwable th) {
                    Kalev.e(th, "Failed to calculate state");
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                b(l8);
                return Unit.f50853a;
            }
        };
        Consumer<? super Long> consumer = new Consumer() { // from class: ee.mtakso.driver.service.geo.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GeoService.o(Function1.this, obj);
            }
        };
        final GeoService$start$4 geoService$start$4 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.geo.GeoService$start$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to schedule location state updates");
            }
        };
        this.f24403b = interval.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.geo.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GeoService.p(Function1.this, obj);
            }
        });
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        this.f24404c = false;
        Disposable disposable = this.f24403b;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Completable x7 = this.f24402a.x();
        Action action = new Action() { // from class: ee.mtakso.driver.service.geo.h
            @Override // io.reactivex.functions.Action
            public final void run() {
                GeoService.q();
            }
        };
        final GeoService$stop$2 geoService$stop$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.geo.GeoService$stop$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to stop location updates");
            }
        };
        x7.G(action, new Consumer() { // from class: ee.mtakso.driver.service.geo.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GeoService.r(Function1.this, obj);
            }
        });
    }
}
