package ee.mtakso.driver.service.modules.emergencyassist;

import ee.mtakso.driver.Config;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.emergencyassist.EmergencyAssistClient;
import ee.mtakso.driver.network.client.emergencyassist.help_provider.ExternalHelpProviderResponse;
import ee.mtakso.driver.network.client.emergencyassist.reverse_geocode.EmergencyAssistReverseGeocodeResponse;
import ee.mtakso.driver.network.client.emergencyassist.third_party_incident.RequestExternalHelpResponse;
import ee.mtakso.driver.network.client.vehicle.Car;
import ee.mtakso.driver.network.client.vehicle.CarApplicationClient;
import ee.mtakso.driver.network.client.vehicle.VehiclesAndApplications;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpType;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.driver.core.network.response.EmptyServerResponse;
import eu.bolt.driver.core.util.Optional;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmergencyAssistManager.kt */
/* loaded from: classes3.dex */
public final class EmergencyAssistManager {

    /* renamed from: a  reason: collision with root package name */
    private final EmergencyAssistClient f24679a;

    /* renamed from: b  reason: collision with root package name */
    private final CarApplicationClient f24680b;

    /* renamed from: c  reason: collision with root package name */
    private final GeoLocationManager f24681c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverProvider f24682d;

    /* renamed from: e  reason: collision with root package name */
    private final OrderProvider f24683e;

    /* renamed from: f  reason: collision with root package name */
    private final DriverSettings f24684f;

    /* renamed from: g  reason: collision with root package name */
    private CompositeDisposable f24685g;

    /* renamed from: h  reason: collision with root package name */
    private Disposable f24686h;

    /* renamed from: i  reason: collision with root package name */
    private final BehaviorSubject<ExternalHelpProviderResponse> f24687i;

    /* renamed from: j  reason: collision with root package name */
    private final PublishSubject<DidYouGetHelpType> f24688j;

    /* renamed from: k  reason: collision with root package name */
    private final BehaviorSubject<Boolean> f24689k;

    @Inject
    public EmergencyAssistManager(EmergencyAssistClient emergencyAssistClient, CarApplicationClient carApplicationClient, GeoLocationManager geoLocationManager, DriverProvider driverProvider, OrderProvider orderProvider, DriverSettings driverSettings) {
        boolean z7;
        Intrinsics.f(emergencyAssistClient, "emergencyAssistClient");
        Intrinsics.f(carApplicationClient, "carApplicationClient");
        Intrinsics.f(geoLocationManager, "geoLocationManager");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(driverSettings, "driverSettings");
        this.f24679a = emergencyAssistClient;
        this.f24680b = carApplicationClient;
        this.f24681c = geoLocationManager;
        this.f24682d = driverProvider;
        this.f24683e = orderProvider;
        this.f24684f = driverSettings;
        this.f24685g = new CompositeDisposable();
        BehaviorSubject<ExternalHelpProviderResponse> e8 = BehaviorSubject.e();
        Intrinsics.e(e8, "create<ExternalHelpProviderResponse>()");
        this.f24687i = e8;
        PublishSubject<DidYouGetHelpType> e9 = PublishSubject.e();
        Intrinsics.e(e9, "create<DidYouGetHelpType>()");
        this.f24688j = e9;
        if (driverSettings.b() != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        BehaviorSubject<Boolean> f8 = BehaviorSubject.f(Boolean.valueOf(z7));
        Intrinsics.e(f8, "createDefault(driverSett…s.activeIncidentId != 0L)");
        this.f24689k = f8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource B(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional E(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair F(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Pair) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource G(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource M(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        this.f24684f.V(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Car v(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Car) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<GeoLocation> w() {
        Observable<GeoLocation> take = this.f24681c.t().take(1L);
        Intrinsics.e(take, "geoLocationManager.obser…LocationUpdates().take(1)");
        return take;
    }

    public final void A() {
        CompositeDisposable compositeDisposable = this.f24685g;
        Observable<GeoLocation> w7 = w();
        final Function1<GeoLocation, SingleSource<? extends ExternalHelpProviderResponse>> function1 = new Function1<GeoLocation, SingleSource<? extends ExternalHelpProviderResponse>>() { // from class: ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager$onLocalityChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends ExternalHelpProviderResponse> invoke(GeoLocation it) {
                EmergencyAssistClient emergencyAssistClient;
                Intrinsics.f(it, "it");
                emergencyAssistClient = EmergencyAssistManager.this.f24679a;
                return emergencyAssistClient.d(it.e().a(), it.e().b());
            }
        };
        Observable<R> flatMapSingle = w7.flatMapSingle(new Function() { // from class: ee.mtakso.driver.service.modules.emergencyassist.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource B;
                B = EmergencyAssistManager.B(Function1.this, obj);
                return B;
            }
        });
        Intrinsics.e(flatMapSingle, "fun onLocalityChanged() …(it)\n            })\n    }");
        Observable g8 = ObservableExtKt.g(flatMapSingle);
        final Function1<ExternalHelpProviderResponse, Unit> function12 = new Function1<ExternalHelpProviderResponse, Unit>() { // from class: ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager$onLocalityChanged$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ExternalHelpProviderResponse externalHelpProviderResponse) {
                BehaviorSubject behaviorSubject;
                behaviorSubject = EmergencyAssistManager.this.f24687i;
                behaviorSubject.onNext(externalHelpProviderResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExternalHelpProviderResponse externalHelpProviderResponse) {
                b(externalHelpProviderResponse);
                return Unit.f50853a;
            }
        };
        compositeDisposable.b(g8.subscribe(new Consumer() { // from class: ee.mtakso.driver.service.modules.emergencyassist.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EmergencyAssistManager.C(Function1.this, obj);
            }
        }));
    }

    public final Observable<RequestExternalHelpResponse> D() {
        List<OrderDetails> k8;
        Observable<GeoLocation> w7 = w();
        Observable<List<OrderDetails>> a8 = this.f24683e.a();
        k8 = CollectionsKt__CollectionsKt.k();
        Single<List<OrderDetails>> first = a8.first(k8);
        final EmergencyAssistManager$requestExternalHelp$1 emergencyAssistManager$requestExternalHelp$1 = new Function1<List<? extends OrderDetails>, Optional<OrderHandle>>() { // from class: ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager$requestExternalHelp$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<OrderHandle> invoke(List<? extends OrderDetails> it) {
                OrderHandle orderHandle;
                Intrinsics.f(it, "it");
                Optional.Companion companion = Optional.f41306b;
                ActiveOrderDetails j8 = OrderProviderUtils.j(it);
                if (j8 != null) {
                    orderHandle = j8.a();
                } else {
                    orderHandle = null;
                }
                return companion.b(orderHandle);
            }
        };
        Observable R = first.x(new Function() { // from class: ee.mtakso.driver.service.modules.emergencyassist.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional E;
                E = EmergencyAssistManager.E(Function1.this, obj);
                return E;
            }
        }).R();
        final EmergencyAssistManager$requestExternalHelp$2 emergencyAssistManager$requestExternalHelp$2 = new Function2<GeoLocation, Optional<OrderHandle>, Pair<? extends GeoLocation, ? extends Optional<OrderHandle>>>() { // from class: ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager$requestExternalHelp$2
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final Pair<GeoLocation, Optional<OrderHandle>> s(GeoLocation location, Optional<OrderHandle> orderHandle) {
                Intrinsics.f(location, "location");
                Intrinsics.f(orderHandle, "orderHandle");
                return new Pair<>(location, orderHandle);
            }
        };
        Observable combineLatest = Observable.combineLatest(w7, R, new BiFunction() { // from class: ee.mtakso.driver.service.modules.emergencyassist.j
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Pair F;
                F = EmergencyAssistManager.F(Function2.this, obj, obj2);
                return F;
            }
        });
        final Function1<Pair<? extends GeoLocation, ? extends Optional<OrderHandle>>, SingleSource<? extends RequestExternalHelpResponse>> function1 = new Function1<Pair<? extends GeoLocation, ? extends Optional<OrderHandle>>, SingleSource<? extends RequestExternalHelpResponse>>() { // from class: ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager$requestExternalHelp$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends RequestExternalHelpResponse> invoke(Pair<GeoLocation, Optional<OrderHandle>> it) {
                EmergencyAssistClient emergencyAssistClient;
                Intrinsics.f(it, "it");
                emergencyAssistClient = EmergencyAssistManager.this.f24679a;
                return SingleExtKt.d(emergencyAssistClient.g(it.d().e(), it.e().b()));
            }
        };
        Observable<RequestExternalHelpResponse> flatMapSingle = combineLatest.flatMapSingle(new Function() { // from class: ee.mtakso.driver.service.modules.emergencyassist.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource G;
                G = EmergencyAssistManager.G(Function1.this, obj);
                return G;
            }
        });
        Intrinsics.e(flatMapSingle, "fun requestExternalHelp(…edulers()\n        }\n    }");
        return flatMapSingle;
    }

    public final Observable<EmergencyAssistReverseGeocodeResponse> H() {
        Observable<GeoLocation> w7 = w();
        final Function1<GeoLocation, SingleSource<? extends EmergencyAssistReverseGeocodeResponse>> function1 = new Function1<GeoLocation, SingleSource<? extends EmergencyAssistReverseGeocodeResponse>>() { // from class: ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager$reverseGeoCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends EmergencyAssistReverseGeocodeResponse> invoke(GeoLocation it) {
                EmergencyAssistClient emergencyAssistClient;
                Intrinsics.f(it, "it");
                emergencyAssistClient = EmergencyAssistManager.this.f24679a;
                return SingleExtKt.d(emergencyAssistClient.k(it.e().a(), it.e().b()));
            }
        };
        Observable flatMapSingle = w7.flatMapSingle(new Function() { // from class: ee.mtakso.driver.service.modules.emergencyassist.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource I;
                I = EmergencyAssistManager.I(Function1.this, obj);
                return I;
            }
        });
        Intrinsics.e(flatMapSingle, "fun reverseGeoCode(): Ob…ers()\n            }\n    }");
        return flatMapSingle;
    }

    public final void J(final long j8) {
        long j9 = Config.f19824b;
        Observable<Long> interval = Observable.interval(j9, j9, TimeUnit.SECONDS, Schedulers.a());
        final Function1<Long, ObservableSource<? extends GeoLocation>> function1 = new Function1<Long, ObservableSource<? extends GeoLocation>>() { // from class: ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager$startIncidentUpdater$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends GeoLocation> invoke(Long it) {
                Observable w7;
                Intrinsics.f(it, "it");
                w7 = EmergencyAssistManager.this.w();
                return w7;
            }
        };
        Observable<R> flatMap = interval.flatMap(new Function() { // from class: ee.mtakso.driver.service.modules.emergencyassist.l
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource M;
                M = EmergencyAssistManager.M(Function1.this, obj);
                return M;
            }
        });
        final Function1<GeoLocation, ObservableSource<? extends EmptyServerResponse>> function12 = new Function1<GeoLocation, ObservableSource<? extends EmptyServerResponse>>() { // from class: ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager$startIncidentUpdater$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends EmptyServerResponse> invoke(GeoLocation cachedLocation) {
                EmergencyAssistClient emergencyAssistClient;
                Intrinsics.f(cachedLocation, "cachedLocation");
                emergencyAssistClient = EmergencyAssistManager.this.f24679a;
                return SingleExtKt.d(emergencyAssistClient.i(cachedLocation.e(), j8)).R();
            }
        };
        Observable switchMap = flatMap.switchMap(new Function() { // from class: ee.mtakso.driver.service.modules.emergencyassist.m
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource N;
                N = EmergencyAssistManager.N(Function1.this, obj);
                return N;
            }
        });
        final EmergencyAssistManager$startIncidentUpdater$3 emergencyAssistManager$startIncidentUpdater$3 = new EmergencyAssistManager$startIncidentUpdater$3(j8);
        Observable retryWhen = switchMap.retryWhen(new Function() { // from class: ee.mtakso.driver.service.modules.emergencyassist.n
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource O;
                O = EmergencyAssistManager.O(Function1.this, obj);
                return O;
            }
        });
        final Function1<EmptyServerResponse, Unit> function13 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager$startIncidentUpdater$4
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
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.emergencyassist.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EmergencyAssistManager.K(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function14 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager$startIncidentUpdater$5
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
                EmergencyAssistManager.this.s();
                EmergencyAssistManager.this.r();
                EmergencyAssistManager.this.Q(false);
            }
        };
        this.f24686h = retryWhen.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.emergencyassist.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EmergencyAssistManager.L(Function1.this, obj);
            }
        });
    }

    public final void P() {
        DisposableExtKt.a(this.f24685g);
    }

    public final void Q(boolean z7) {
        this.f24689k.onNext(Boolean.valueOf(z7));
    }

    public final void r() {
        Kalev.b("Cancelling request external help update");
        Disposable disposable = this.f24686h;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        this.f24686h = null;
    }

    public final void t(DidYouGetHelpType didYouGetHelpType) {
        Intrinsics.f(didYouGetHelpType, "didYouGetHelpType");
        this.f24688j.onNext(didYouGetHelpType);
    }

    public final Single<Car> u() {
        Single d8 = SingleExtKt.d(this.f24680b.b());
        final Function1<VehiclesAndApplications, Car> function1 = new Function1<VehiclesAndApplications, Car>() { // from class: ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager$getCurrentVehicleDetails$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Car invoke(VehiclesAndApplications vehiclesAndApplications) {
                Object obj;
                DriverProvider driverProvider;
                boolean z7;
                Intrinsics.f(vehiclesAndApplications, "vehiclesAndApplications");
                List<Car> b8 = vehiclesAndApplications.b();
                EmergencyAssistManager emergencyAssistManager = EmergencyAssistManager.this;
                Iterator<T> it = b8.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        long a8 = ((Car) obj).a();
                        driverProvider = emergencyAssistManager.f24682d;
                        if (a8 == driverProvider.n().k()) {
                            z7 = true;
                            continue;
                        } else {
                            z7 = false;
                            continue;
                        }
                        if (z7) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                return (Car) obj;
            }
        };
        Single<Car> x7 = d8.x(new Function() { // from class: ee.mtakso.driver.service.modules.emergencyassist.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Car v7;
                v7 = EmergencyAssistManager.v(Function1.this, obj);
                return v7;
            }
        });
        Intrinsics.e(x7, "fun getCurrentVehicleDet…rId }\n            }\n    }");
        return x7;
    }

    public final PublishSubject<DidYouGetHelpType> x() {
        return this.f24688j;
    }

    public final BehaviorSubject<Boolean> y() {
        return this.f24689k;
    }

    public final BehaviorSubject<ExternalHelpProviderResponse> z() {
        return this.f24687i;
    }
}
