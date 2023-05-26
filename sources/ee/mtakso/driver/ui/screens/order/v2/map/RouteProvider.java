package ee.mtakso.driver.ui.screens.order.v2.map;

import ee.mtakso.driver.network.client.geo.Directions;
import ee.mtakso.driver.network.client.geo.GeoClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.ui.screens.order.v2.map.RouteProvider;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.RetryWithDelaySingle;
import eu.bolt.android.maps.core.Locatable;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RouteProvider.kt */
/* loaded from: classes3.dex */
public final class RouteProvider {

    /* renamed from: a  reason: collision with root package name */
    private final TrueTimeProvider f32147a;

    /* renamed from: b  reason: collision with root package name */
    private final GeoClient f32148b;

    /* renamed from: c  reason: collision with root package name */
    private final long f32149c;

    /* renamed from: d  reason: collision with root package name */
    private Locatable f32150d;

    /* renamed from: e  reason: collision with root package name */
    private long f32151e;

    /* renamed from: f  reason: collision with root package name */
    private Disposable f32152f;

    /* renamed from: g  reason: collision with root package name */
    private final PublishSubject<Directions> f32153g;

    @Inject
    public RouteProvider(DriverProvider driverProvider, TrueTimeProvider trueTimeProvider, GeoClient apiClient) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(trueTimeProvider, "trueTimeProvider");
        Intrinsics.f(apiClient, "apiClient");
        this.f32147a = trueTimeProvider;
        this.f32148b = apiClient;
        this.f32149c = g(driverProvider.m().G());
        PublishSubject<Directions> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<Directions>()");
        this.f32153g = e8;
    }

    private final long g(long j8) {
        if (j8 >= 3) {
            return j8;
        }
        return 86400L;
    }

    private final void h(GeoCoordinate geoCoordinate, Locatable locatable, String str) {
        Single F = GeoClient.d(this.f32148b, geoCoordinate, locatable, str, null, 8, null).F(new RetryWithDelaySingle(3, TimeUnit.MILLISECONDS.convert(2L, TimeUnit.MINUTES)));
        final Function1<Directions, Unit> function1 = new Function1<Directions, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.map.RouteProvider$fetchRoute$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Directions directions) {
                PublishSubject publishSubject;
                TrueTimeProvider trueTimeProvider;
                RouteProvider.this.f32152f = null;
                publishSubject = RouteProvider.this.f32153g;
                publishSubject.onNext(directions);
                RouteProvider routeProvider = RouteProvider.this;
                trueTimeProvider = routeProvider.f32147a;
                routeProvider.f32151e = trueTimeProvider.a();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Directions directions) {
                b(directions);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: y4.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RouteProvider.i(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.map.RouteProvider$fetchRoute$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                TrueTimeProvider trueTimeProvider;
                RouteProvider routeProvider = RouteProvider.this;
                trueTimeProvider = routeProvider.f32147a;
                routeProvider.f32151e = trueTimeProvider.a();
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to fetch route");
            }
        };
        this.f32152f = F.I(consumer, new Consumer() { // from class: y4.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RouteProvider.j(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean k(Locatable locatable) {
        if (Intrinsics.a(this.f32150d, locatable) && !DisposableExtKt.b(this.f32152f)) {
            return true;
        }
        return false;
    }

    private final boolean l(Locatable locatable) {
        if (Intrinsics.a(this.f32150d, locatable) && this.f32147a.a() - this.f32151e < this.f32149c) {
            return true;
        }
        return false;
    }

    public final Observable<Directions> m() {
        return this.f32153g;
    }

    public final void n(GeoCoordinate from, Locatable locatable, String str) {
        Intrinsics.f(from, "from");
        if (locatable != null && !l(locatable) && !k(locatable)) {
            Disposable disposable = this.f32152f;
            if (disposable != null) {
                disposable.dispose();
            }
            this.f32150d = locatable;
            h(from, locatable, str);
        }
    }
}
