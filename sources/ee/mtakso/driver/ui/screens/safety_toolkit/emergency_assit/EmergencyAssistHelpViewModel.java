package ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.emergencyassist.help_provider.ExternalHelpProviderResponse;
import ee.mtakso.driver.network.client.emergencyassist.reverse_geocode.EmergencyAssistReverseGeocodeResponse;
import ee.mtakso.driver.network.client.emergencyassist.third_party_incident.RequestExternalHelpResponse;
import ee.mtakso.driver.network.client.vehicle.Car;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics;
import ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmergencyAssistHelpViewModel.kt */
/* loaded from: classes3.dex */
public final class EmergencyAssistHelpViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final EmergencyAssistManager f32699f;

    /* renamed from: g  reason: collision with root package name */
    private final EmergencyAssistDataMapper f32700g;

    /* renamed from: h  reason: collision with root package name */
    private final DriverSettings f32701h;

    /* renamed from: i  reason: collision with root package name */
    private final SafetyToolkitAnalytics f32702i;

    /* renamed from: j  reason: collision with root package name */
    private final MutableLiveData<EmergencyAssistUIData> f32703j;

    /* renamed from: k  reason: collision with root package name */
    private final MutableLiveData<ExternalHelpProviderResponse> f32704k;

    /* renamed from: l  reason: collision with root package name */
    private final MutableLiveData<Boolean> f32705l;

    /* renamed from: m  reason: collision with root package name */
    private Disposable f32706m;

    @Inject
    public EmergencyAssistHelpViewModel(EmergencyAssistManager emergencyAssistManager, EmergencyAssistDataMapper emergencyAssistDataMapper, DriverSettings driverSettings, SafetyToolkitAnalytics safetyToolkitAnalytics) {
        Intrinsics.f(emergencyAssistManager, "emergencyAssistManager");
        Intrinsics.f(emergencyAssistDataMapper, "emergencyAssistDataMapper");
        Intrinsics.f(driverSettings, "driverSettings");
        Intrinsics.f(safetyToolkitAnalytics, "safetyToolkitAnalytics");
        this.f32699f = emergencyAssistManager;
        this.f32700g = emergencyAssistDataMapper;
        this.f32701h = driverSettings;
        this.f32702i = safetyToolkitAnalytics;
        this.f32703j = new MutableLiveData<>();
        this.f32704k = new MutableLiveData<>();
        this.f32705l = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EmergencyAssistUIData U(Function3 tmp0, Object obj, Object obj2, Object obj3) {
        Intrinsics.f(tmp0, "$tmp0");
        return (EmergencyAssistUIData) tmp0.l(obj, obj2, obj3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean a0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Boolean) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean b0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Boolean) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        BehaviorSubject<ExternalHelpProviderResponse> z7 = this.f32699f.z();
        Observable<EmergencyAssistReverseGeocodeResponse> H = this.f32699f.H();
        Observable<Car> R = this.f32699f.u().R();
        final Function3<ExternalHelpProviderResponse, EmergencyAssistReverseGeocodeResponse, Car, EmergencyAssistUIData> function3 = new Function3<ExternalHelpProviderResponse, EmergencyAssistReverseGeocodeResponse, Car, EmergencyAssistUIData>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            /* renamed from: b */
            public final EmergencyAssistUIData l(ExternalHelpProviderResponse emergencyHelp, EmergencyAssistReverseGeocodeResponse geoCode, Car currentVehicle) {
                EmergencyAssistDataMapper emergencyAssistDataMapper;
                Intrinsics.f(emergencyHelp, "emergencyHelp");
                Intrinsics.f(geoCode, "geoCode");
                Intrinsics.f(currentVehicle, "currentVehicle");
                emergencyAssistDataMapper = EmergencyAssistHelpViewModel.this.f32700g;
                return emergencyAssistDataMapper.g(emergencyHelp, geoCode, currentVehicle);
            }
        };
        Observable combineLatest = Observable.combineLatest(z7, H, R, new io.reactivex.functions.Function3() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.j
            @Override // io.reactivex.functions.Function3
            public final Object a(Object obj, Object obj2, Object obj3) {
                EmergencyAssistUIData U;
                U = EmergencyAssistHelpViewModel.U(Function3.this, obj, obj2, obj3);
                return U;
            }
        });
        Intrinsics.e(combineLatest, "override fun onStart() {… = it\n            }\n    }");
        Observable g8 = ObservableExtKt.g(combineLatest);
        final Function1<EmergencyAssistUIData, Unit> function1 = new Function1<EmergencyAssistUIData, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpViewModel$onStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EmergencyAssistUIData emergencyAssistUIData) {
                MutableLiveData mutableLiveData;
                mutableLiveData = EmergencyAssistHelpViewModel.this.f32703j;
                mutableLiveData.o(emergencyAssistUIData);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmergencyAssistUIData emergencyAssistUIData) {
                b(emergencyAssistUIData);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EmergencyAssistHelpViewModel.V(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpViewModel$onStart$3
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
                EmergencyAssistHelpViewModel emergencyAssistHelpViewModel = EmergencyAssistHelpViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(emergencyAssistHelpViewModel, it, null, 2, null);
            }
        };
        Disposable subscribe = g8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EmergencyAssistHelpViewModel.W(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun onStart() {… = it\n            }\n    }");
        v(subscribe);
        BehaviorSubject<ExternalHelpProviderResponse> z8 = this.f32699f.z();
        final Function1<ExternalHelpProviderResponse, Unit> function13 = new Function1<ExternalHelpProviderResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpViewModel$onStart$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ExternalHelpProviderResponse externalHelpProviderResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = EmergencyAssistHelpViewModel.this.f32704k;
                mutableLiveData.o(externalHelpProviderResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExternalHelpProviderResponse externalHelpProviderResponse) {
                b(externalHelpProviderResponse);
                return Unit.f50853a;
            }
        };
        Disposable subscribe2 = z8.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EmergencyAssistHelpViewModel.X(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe2, "override fun onStart() {… = it\n            }\n    }");
        v(subscribe2);
        Observable g9 = ObservableExtKt.g(this.f32699f.y());
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpViewModel$onStart$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean bool) {
                MutableLiveData mutableLiveData;
                mutableLiveData = EmergencyAssistHelpViewModel.this.f32705l;
                mutableLiveData.o(bool);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        g9.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EmergencyAssistHelpViewModel.Y(Function1.this, obj);
            }
        });
    }

    public final void Q() {
        this.f32699f.Q(false);
        Disposable disposable = this.f32706m;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        this.f32706m = null;
    }

    public final LiveData<EmergencyAssistUIData> R() {
        MutableLiveData<EmergencyAssistUIData> mutableLiveData = this.f32703j;
        Intrinsics.d(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistUIData>");
        return mutableLiveData;
    }

    public final MutableLiveData<Boolean> S() {
        return this.f32705l;
    }

    public final LiveData<ExternalHelpProviderResponse> T() {
        MutableLiveData<ExternalHelpProviderResponse> mutableLiveData = this.f32704k;
        Intrinsics.d(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<ee.mtakso.driver.network.client.emergencyassist.help_provider.ExternalHelpProviderResponse>");
        return mutableLiveData;
    }

    public final Observable<Boolean> Z() {
        Observable<RequestExternalHelpResponse> D = this.f32699f.D();
        final Function1<RequestExternalHelpResponse, Boolean> function1 = new Function1<RequestExternalHelpResponse, Boolean>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpViewModel$requestExternalHelp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(RequestExternalHelpResponse incidentResponse) {
                DriverSettings driverSettings;
                EmergencyAssistManager emergencyAssistManager;
                Intrinsics.f(incidentResponse, "incidentResponse");
                long a8 = incidentResponse.a().a();
                Kalev.b("requestExternalHelp successful, id: " + a8);
                driverSettings = EmergencyAssistHelpViewModel.this.f32701h;
                driverSettings.V(incidentResponse.a().a());
                emergencyAssistManager = EmergencyAssistHelpViewModel.this.f32699f;
                emergencyAssistManager.Q(true);
                return Boolean.TRUE;
            }
        };
        Observable<R> map = D.map(new Function() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.o
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean a02;
                a02 = EmergencyAssistHelpViewModel.a0(Function1.this, obj);
                return a02;
            }
        });
        final Function1<Throwable, Boolean> function12 = new Function1<Throwable, Boolean>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpViewModel$requestExternalHelp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(Throwable error) {
                Intrinsics.f(error, "error");
                Kalev.e(error, "openIncident request failed");
                BaseViewModel.A(EmergencyAssistHelpViewModel.this, error, null, 2, null);
                return Boolean.FALSE;
            }
        };
        Observable<Boolean> onErrorReturn = map.onErrorReturn(new Function() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.p
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean b02;
                b02 = EmergencyAssistHelpViewModel.b0(Function1.this, obj);
                return b02;
            }
        });
        Intrinsics.e(onErrorReturn, "fun requestExternalHelp(…false\n            }\n    }");
        return onErrorReturn;
    }

    public final void c0() {
        this.f32702i.g0();
    }

    public final void d0(String property) {
        Intrinsics.f(property, "property");
        this.f32702i.C3(property);
    }

    public final void e0(String property) {
        Intrinsics.f(property, "property");
        this.f32702i.R2(property);
    }

    public final void f0(String property) {
        Intrinsics.f(property, "property");
        this.f32702i.T2(property);
    }

    public final void g0(String property, long j8) {
        Intrinsics.f(property, "property");
        this.f32702i.w2(property, j8);
    }
}
