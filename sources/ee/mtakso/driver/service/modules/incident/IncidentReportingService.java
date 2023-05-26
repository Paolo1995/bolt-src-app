package ee.mtakso.driver.service.modules.incident;

import ee.mtakso.driver.Config;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.incident.IncidentReportingClient;
import ee.mtakso.driver.network.client.incident.OpenIncidentResult;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.SosSentEvent;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.incident.IncidentReportingService;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.RxUtils;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.SingleSubject;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncidentReportingService.kt */
@Singleton
/* loaded from: classes3.dex */
public final class IncidentReportingService {

    /* renamed from: a  reason: collision with root package name */
    private final OrderProvider f24770a;

    /* renamed from: b  reason: collision with root package name */
    private final IncidentReportingClient f24771b;

    /* renamed from: c  reason: collision with root package name */
    private final TrueTimeProvider f24772c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverProvider f24773d;

    /* renamed from: e  reason: collision with root package name */
    private final GeoLocationManager f24774e;

    /* renamed from: f  reason: collision with root package name */
    private Disposable f24775f;

    /* renamed from: g  reason: collision with root package name */
    private Disposable f24776g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IncidentReportingService.kt */
    /* loaded from: classes3.dex */
    public static final class LocationWithOrderHandle {

        /* renamed from: a  reason: collision with root package name */
        private final GeoLocation f24777a;

        /* renamed from: b  reason: collision with root package name */
        private final Optional<OrderHandle> f24778b;

        public LocationWithOrderHandle(GeoLocation location, Optional<OrderHandle> orderHandle) {
            Intrinsics.f(location, "location");
            Intrinsics.f(orderHandle, "orderHandle");
            this.f24777a = location;
            this.f24778b = orderHandle;
        }

        public final GeoLocation a() {
            return this.f24777a;
        }

        public final Optional<OrderHandle> b() {
            return this.f24778b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LocationWithOrderHandle) {
                LocationWithOrderHandle locationWithOrderHandle = (LocationWithOrderHandle) obj;
                return Intrinsics.a(this.f24777a, locationWithOrderHandle.f24777a) && Intrinsics.a(this.f24778b, locationWithOrderHandle.f24778b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f24777a.hashCode() * 31) + this.f24778b.hashCode();
        }

        public String toString() {
            GeoLocation geoLocation = this.f24777a;
            Optional<OrderHandle> optional = this.f24778b;
            return "LocationWithOrderHandle(location=" + geoLocation + ", orderHandle=" + optional + ")";
        }
    }

    @Inject
    public IncidentReportingService(OrderProvider orderProvider, IncidentReportingClient incidentClient, TrueTimeProvider trueTimeProvider, DriverProvider driverProvider, GeoLocationManager locationManager) {
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(incidentClient, "incidentClient");
        Intrinsics.f(trueTimeProvider, "trueTimeProvider");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(locationManager, "locationManager");
        this.f24770a = orderProvider;
        this.f24771b = incidentClient;
        this.f24772c = trueTimeProvider;
        this.f24773d = driverProvider;
        this.f24774e = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        List<SosSentEvent> J0;
        J0 = CollectionsKt___CollectionsKt.J0(this.f24773d.t().z());
        J0.add(new SosSentEvent(this.f24772c.b()));
        this.f24773d.t().U(J0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional C(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocationWithOrderHandle D(GeoLocation loc, Optional id) {
        Intrinsics.f(loc, "loc");
        Intrinsics.f(id, "id");
        return new LocationWithOrderHandle(loc, id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocationWithOrderHandle E(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (LocationWithOrderHandle) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource F(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource G(Function1 tmp0, Single p02) {
        Intrinsics.f(tmp0, "$tmp0");
        Intrinsics.f(p02, "p0");
        return (SingleSource) tmp0.invoke(p02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(final long j8) {
        long j9 = Config.f19824b;
        Observable<Long> interval = Observable.interval(j9, j9, TimeUnit.SECONDS, Schedulers.a());
        final Function1<Long, ObservableSource<? extends GeoLocation>> function1 = new Function1<Long, ObservableSource<? extends GeoLocation>>() { // from class: ee.mtakso.driver.service.modules.incident.IncidentReportingService$startIncidentUpdater$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends GeoLocation> invoke(Long tick) {
                GeoLocationManager geoLocationManager;
                Intrinsics.f(tick, "tick");
                geoLocationManager = IncidentReportingService.this.f24774e;
                return geoLocationManager.t().take(1L);
            }
        };
        Observable<R> flatMap = interval.flatMap(new Function() { // from class: ee.mtakso.driver.service.modules.incident.o
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource P;
                P = IncidentReportingService.P(Function1.this, obj);
                return P;
            }
        });
        final Function1<GeoLocation, ObservableSource<? extends EmptyServerResponse>> function12 = new Function1<GeoLocation, ObservableSource<? extends EmptyServerResponse>>() { // from class: ee.mtakso.driver.service.modules.incident.IncidentReportingService$startIncidentUpdater$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends EmptyServerResponse> invoke(GeoLocation cachedLocation) {
                IncidentReportingClient incidentReportingClient;
                Intrinsics.f(cachedLocation, "cachedLocation");
                incidentReportingClient = IncidentReportingService.this.f24771b;
                return incidentReportingClient.b(j8, cachedLocation.e().a(), cachedLocation.e().b()).R();
            }
        };
        Observable switchMap = flatMap.switchMap(new Function() { // from class: ee.mtakso.driver.service.modules.incident.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource K;
                K = IncidentReportingService.K(Function1.this, obj);
                return K;
            }
        });
        final IncidentReportingService$startIncidentUpdater$3 incidentReportingService$startIncidentUpdater$3 = new IncidentReportingService$startIncidentUpdater$3(j8);
        Observable retryWhen = switchMap.retryWhen(new Function() { // from class: ee.mtakso.driver.service.modules.incident.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource L;
                L = IncidentReportingService.L(Function1.this, obj);
                return L;
            }
        });
        final IncidentReportingService$startIncidentUpdater$4 incidentReportingService$startIncidentUpdater$4 = new Function1<Observable<EmptyServerResponse>, ObservableSource<EmptyServerResponse>>() { // from class: ee.mtakso.driver.service.modules.incident.IncidentReportingService$startIncidentUpdater$4
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<EmptyServerResponse> invoke(Observable<EmptyServerResponse> it) {
                Intrinsics.f(it, "it");
                return RxUtils.b(it);
            }
        };
        Observable compose = retryWhen.compose(new ObservableTransformer() { // from class: ee.mtakso.driver.service.modules.incident.d
            @Override // io.reactivex.ObservableTransformer
            public final ObservableSource a(Observable observable) {
                ObservableSource M;
                M = IncidentReportingService.M(Function1.this, observable);
                return M;
            }
        });
        final Function1<EmptyServerResponse, Unit> function13 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.service.modules.incident.IncidentReportingService$startIncidentUpdater$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(EmptyServerResponse emptyServerResponse) {
                long j10 = j8;
                Kalev.b("successfully updated the incident with id " + j10);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.incident.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                IncidentReportingService.N(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function14 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.incident.IncidentReportingService$startIncidentUpdater$6
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
            public final void invoke2(Throwable error) {
                Intrinsics.e(error, "error");
                Kalev.e(error, "Exception on incident updater!");
                IncidentReportingService.this.v();
            }
        };
        this.f24775f = compose.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.incident.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                IncidentReportingService.O(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource K(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource L(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource M(Function1 tmp0, Observable p02) {
        Intrinsics.f(tmp0, "$tmp0");
        Intrinsics.f(p02, "p0");
        return (ObservableSource) tmp0.invoke(p02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        Kalev.b("IncidentReportingService - cancelIncidentReporting()");
        RxUtils.d(this.f24775f, this.f24776g);
        this.f24775f = null;
        this.f24776g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Single<Boolean> x(LocationWithOrderHandle locationWithOrderHandle) {
        Single<OpenIncidentResult> a8 = this.f24771b.a(locationWithOrderHandle.a().e(), locationWithOrderHandle.b().c());
        final Function1<OpenIncidentResult, Boolean> function1 = new Function1<OpenIncidentResult, Boolean>() { // from class: ee.mtakso.driver.service.modules.incident.IncidentReportingService$openIncident$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(OpenIncidentResult incidentResponse) {
                Intrinsics.f(incidentResponse, "incidentResponse");
                long a9 = incidentResponse.a();
                Kalev.b("openIncident successful, id: " + a9);
                IncidentReportingService.this.J(incidentResponse.a());
                return Boolean.TRUE;
            }
        };
        Single<Boolean> K = a8.x(new Function() { // from class: ee.mtakso.driver.service.modules.incident.m
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean y7;
                y7 = IncidentReportingService.y(Function1.this, obj);
                return y7;
            }
        }).C(new Function() { // from class: ee.mtakso.driver.service.modules.incident.n
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean z7;
                z7 = IncidentReportingService.z((Throwable) obj);
                return z7;
            }
        }).K(Schedulers.c());
        Intrinsics.e(K, "private fun openIncident…On(Schedulers.io())\n    }");
        return K;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Boolean) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean z(Throwable error) {
        Intrinsics.f(error, "error");
        Kalev.e(error, "openIncident request failed");
        return Boolean.FALSE;
    }

    public final Single<Boolean> B() {
        List<OrderDetails> k8;
        final SingleSubject Z = SingleSubject.Z();
        Intrinsics.e(Z, "create<Boolean>()");
        Single<GeoLocation> firstOrError = this.f24774e.t().firstOrError();
        Observable<List<OrderDetails>> a8 = this.f24770a.a();
        k8 = CollectionsKt__CollectionsKt.k();
        Single<List<OrderDetails>> first = a8.first(k8);
        final IncidentReportingService$sendIncidentReport$1 incidentReportingService$sendIncidentReport$1 = new Function1<List<? extends OrderDetails>, Optional<OrderHandle>>() { // from class: ee.mtakso.driver.service.modules.incident.IncidentReportingService$sendIncidentReport$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<OrderHandle> invoke(List<? extends OrderDetails> it) {
                OrderHandle orderHandle;
                Intrinsics.f(it, "it");
                ActiveOrderDetails j8 = OrderProviderUtils.j(it);
                if (j8 != null) {
                    orderHandle = j8.a();
                } else {
                    orderHandle = null;
                }
                return Optional.f(orderHandle);
            }
        };
        Single<R> X = firstOrError.X(first.x(new Function() { // from class: ee.mtakso.driver.service.modules.incident.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional C;
                C = IncidentReportingService.C(Function1.this, obj);
                return C;
            }
        }), new BiFunction() { // from class: ee.mtakso.driver.service.modules.incident.g
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                IncidentReportingService.LocationWithOrderHandle D;
                D = IncidentReportingService.D((GeoLocation) obj, (Optional) obj2);
                return D;
            }
        });
        final Function1<LocationWithOrderHandle, LocationWithOrderHandle> function1 = new Function1<LocationWithOrderHandle, LocationWithOrderHandle>() { // from class: ee.mtakso.driver.service.modules.incident.IncidentReportingService$sendIncidentReport$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final IncidentReportingService.LocationWithOrderHandle invoke(IncidentReportingService.LocationWithOrderHandle driverLocationWithOrderId) {
                Intrinsics.f(driverLocationWithOrderId, "driverLocationWithOrderId");
                IncidentReportingService.this.A();
                return driverLocationWithOrderId;
            }
        };
        Single x7 = X.x(new Function() { // from class: ee.mtakso.driver.service.modules.incident.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                IncidentReportingService.LocationWithOrderHandle E;
                E = IncidentReportingService.E(Function1.this, obj);
                return E;
            }
        });
        final Function1<LocationWithOrderHandle, SingleSource<? extends Boolean>> function12 = new Function1<LocationWithOrderHandle, SingleSource<? extends Boolean>>() { // from class: ee.mtakso.driver.service.modules.incident.IncidentReportingService$sendIncidentReport$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends Boolean> invoke(IncidentReportingService.LocationWithOrderHandle driverLocationWithOrderId) {
                Single x8;
                Intrinsics.f(driverLocationWithOrderId, "driverLocationWithOrderId");
                x8 = IncidentReportingService.this.x(driverLocationWithOrderId);
                return x8;
            }
        };
        Single r7 = x7.r(new Function() { // from class: ee.mtakso.driver.service.modules.incident.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource F;
                F = IncidentReportingService.F(Function1.this, obj);
                return F;
            }
        });
        final IncidentReportingService$sendIncidentReport$5 incidentReportingService$sendIncidentReport$5 = new Function1<Single<Boolean>, SingleSource<Boolean>>() { // from class: ee.mtakso.driver.service.modules.incident.IncidentReportingService$sendIncidentReport$5
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<Boolean> invoke(Single<Boolean> it) {
                Intrinsics.f(it, "it");
                return RxUtils.c(it);
            }
        };
        Single e8 = r7.e(new SingleTransformer() { // from class: ee.mtakso.driver.service.modules.incident.j
            @Override // io.reactivex.SingleTransformer
            public final SingleSource a(Single single) {
                SingleSource G;
                G = IncidentReportingService.G(Function1.this, single);
                return G;
            }
        });
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.service.modules.incident.IncidentReportingService$sendIncidentReport$6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Boolean bool) {
                Z.onSuccess(bool);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.incident.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                IncidentReportingService.H(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function14 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.incident.IncidentReportingService$sendIncidentReport$7
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Z.onError(th);
            }
        };
        this.f24776g = e8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.incident.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                IncidentReportingService.I(Function1.this, obj);
            }
        });
        return Z;
    }

    public final boolean w() {
        if (this.f24776g != null) {
            return true;
        }
        return false;
    }
}
