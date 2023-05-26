package ee.mtakso.driver.service.geo.transmitter;

import ee.mtakso.driver.features.Feature;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.storage.LocationEntity;
import ee.mtakso.driver.service.geo.storage.LocationStorage;
import ee.mtakso.driver.service.geo.storage.RoutePoint;
import ee.mtakso.driver.service.geo.storage.RoutePointList;
import ee.mtakso.driver.service.order.details.OrderDetails;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.internal.schedulers.RxThreadFactory;
import io.reactivex.internal.schedulers.SingleScheduler;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationTransmitter.kt */
@Singleton
/* loaded from: classes3.dex */
public final class LocationTransmitter {

    /* renamed from: a  reason: collision with root package name */
    private final LocationStorage f24473a;

    /* renamed from: b  reason: collision with root package name */
    private final Features f24474b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverClient f24475c;

    /* renamed from: d  reason: collision with root package name */
    private final Lazy f24476d;

    /* renamed from: e  reason: collision with root package name */
    private final Lazy f24477e;

    /* renamed from: f  reason: collision with root package name */
    private Disposable f24478f;

    @Inject
    public LocationTransmitter(LocationStorage locationStorage, Features features, DriverClient driverClient) {
        Lazy b8;
        Lazy b9;
        Intrinsics.f(locationStorage, "locationStorage");
        Intrinsics.f(features, "features");
        Intrinsics.f(driverClient, "driverClient");
        this.f24473a = locationStorage;
        this.f24474b = features;
        this.f24475c = driverClient;
        b8 = LazyKt__LazyJVMKt.b(new Function0<SingleScheduler>() { // from class: ee.mtakso.driver.service.geo.transmitter.LocationTransmitter$singleScheduler$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final SingleScheduler invoke() {
                return new SingleScheduler(new RxThreadFactory("Single-location-sender", 5));
            }
        });
        this.f24476d = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<Boolean>() { // from class: ee.mtakso.driver.service.geo.transmitter.LocationTransmitter$singleThreadUploadEnabled$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Boolean invoke() {
                Features features2;
                features2 = LocationTransmitter.this.f24474b;
                return Boolean.valueOf(features2.b(Feature.Type.LOCATION_SINGLE_THREAD_UPLOAD));
            }
        });
        this.f24477e = b9;
    }

    private final SingleScheduler f() {
        return (SingleScheduler) this.f24476d.getValue();
    }

    private final boolean g() {
        return ((Boolean) this.f24477e.getValue()).booleanValue();
    }

    private final Single<RoutePointList> h(final OrderHandle orderHandle, final int i8) {
        Single<RoutePointList> u7 = Single.u(new Callable() { // from class: ee.mtakso.driver.service.geo.transmitter.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                RoutePointList i9;
                i9 = LocationTransmitter.i(i8, this, orderHandle);
                return i9;
            }
        });
        Intrinsics.e(u7, "fromCallable {\n         …)\n            }\n        }");
        return u7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoutePointList i(int i8, LocationTransmitter this$0, OrderHandle order) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(order, "$order");
        if (i8 == -1) {
            return this$0.f24473a.c(order);
        }
        return this$0.f24473a.d(order, i8);
    }

    public static /* synthetic */ Completable l(LocationTransmitter locationTransmitter, OrderHandle orderHandle, boolean z7, int i8, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            i8 = -1;
        }
        return locationTransmitter.k(orderHandle, z7, i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Completable n(final RoutePointList routePointList) {
        if (routePointList.b().isEmpty()) {
            Completable g8 = Completable.g();
            Intrinsics.e(g8, "{\n            Completable.complete()\n        }");
            return g8;
        }
        Completable n8 = this.f24475c.B(routePointList.a(), routePointList.b()).v().n(new Action() { // from class: ee.mtakso.driver.service.geo.transmitter.b
            @Override // io.reactivex.functions.Action
            public final void run() {
                LocationTransmitter.o(LocationTransmitter.this, routePointList);
            }
        });
        Intrinsics.e(n8, "{\n            driverClie…              }\n        }");
        return n8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(LocationTransmitter this$0, RoutePointList routePoints) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(routePoints, "$routePoints");
        Kalev kalev = Kalev.f41674e;
        FastLog g8 = kalev.g();
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "Location batch sent. Removing from local storage...", null, 2, null);
        }
        this$0.f24473a.e(routePoints);
        FastLog g9 = kalev.g();
        if (g9 != null) {
            FastLog.DefaultImpls.a(g9, "Local storage updated", null, 2, null);
        }
    }

    public final void j(LocationWithOrders bundle, boolean z7) {
        Float f8;
        Intrinsics.f(bundle, "bundle");
        GeoLocation a8 = bundle.a();
        for (OrderDetails orderDetails : bundle.b()) {
            OrderHandle a9 = orderDetails.a();
            String name = orderDetails.b().name();
            double a10 = a8.e().a();
            double b8 = a8.e().b();
            double b9 = a8.b();
            Float g8 = a8.g();
            long i8 = a8.i();
            Double c8 = a8.c();
            if (c8 != null) {
                f8 = Float.valueOf((float) c8.doubleValue());
            } else {
                f8 = null;
            }
            LocationEntity locationEntity = new LocationEntity(a9, name, a10, b8, b9, g8, i8, z7, f8, a8.d());
            this.f24473a.b(new RoutePoint(locationEntity.g(), locationEntity));
        }
    }

    public final Completable k(OrderHandle order, boolean z7, int i8) {
        Single<RoutePointList> h8;
        Disposable disposable;
        Intrinsics.f(order, "order");
        if (z7 && !g() && (disposable = this.f24478f) != null) {
            disposable.dispose();
        }
        if (g()) {
            h8 = h(order, i8).K(f());
            Intrinsics.e(h8, "{\n            readBatch(…ingleScheduler)\n        }");
        } else {
            h8 = h(order, i8);
        }
        final Function1<RoutePointList, CompletableSource> function1 = new Function1<RoutePointList, CompletableSource>() { // from class: ee.mtakso.driver.service.geo.transmitter.LocationTransmitter$transmitBatch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CompletableSource invoke(RoutePointList it) {
                Completable n8;
                Intrinsics.f(it, "it");
                n8 = LocationTransmitter.this.n(it);
                return n8;
            }
        };
        Completable s7 = h8.s(new Function() { // from class: ee.mtakso.driver.service.geo.transmitter.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource m8;
                m8 = LocationTransmitter.m(Function1.this, obj);
                return m8;
            }
        });
        Intrinsics.e(s7, "fun transmitBatch(order:…able { upload(it) }\n    }");
        return s7;
    }
}
