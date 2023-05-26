package ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.emergencyassist.help_provider.ExternalHelpProviderResponse;
import ee.mtakso.driver.network.client.route_sharing.RouteSharing;
import ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PermissionAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.modules.order.v2.OrderTracker;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.screens.order.v2.order.RouteSharingInteractor;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SafetyToolkitViewModel.kt */
/* loaded from: classes3.dex */
public final class SafetyToolkitViewModel extends BaseViewModel {

    /* renamed from: q  reason: collision with root package name */
    public static final Companion f32829q = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final SafetyToolkitInteractor f32830f;

    /* renamed from: g  reason: collision with root package name */
    private final OrderTracker f32831g;

    /* renamed from: h  reason: collision with root package name */
    private final OrderProvider f32832h;

    /* renamed from: i  reason: collision with root package name */
    private final RouteSharingInteractor f32833i;

    /* renamed from: j  reason: collision with root package name */
    private final AudioRecordingAnalytics f32834j;

    /* renamed from: k  reason: collision with root package name */
    private final PermissionAnalytics f32835k;

    /* renamed from: l  reason: collision with root package name */
    private final SafetyToolkitAnalytics f32836l;

    /* renamed from: m  reason: collision with root package name */
    private final MutableLiveData<List<SafetyFeature>> f32837m;

    /* renamed from: n  reason: collision with root package name */
    private final CompositeDisposable f32838n;

    /* renamed from: o  reason: collision with root package name */
    private final BehaviorSubject<OrderDetails> f32839o;

    /* renamed from: p  reason: collision with root package name */
    private final MutableLiveData<ExternalHelpProviderResponse> f32840p;

    /* compiled from: SafetyToolkitViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public SafetyToolkitViewModel(SafetyToolkitInteractor safetyToolkitInteractor, OrderTracker orderTracker, OrderProvider orderProvider, RouteSharingInteractor routeSharingInteractor, AudioRecordingAnalytics audioRecordingAnalytics, PermissionAnalytics permissionAnalytics, SafetyToolkitAnalytics safetyToolkitAnalytics) {
        Intrinsics.f(safetyToolkitInteractor, "safetyToolkitInteractor");
        Intrinsics.f(orderTracker, "orderTracker");
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(routeSharingInteractor, "routeSharingInteractor");
        Intrinsics.f(audioRecordingAnalytics, "audioRecordingAnalytics");
        Intrinsics.f(permissionAnalytics, "permissionAnalytics");
        Intrinsics.f(safetyToolkitAnalytics, "safetyToolkitAnalytics");
        this.f32830f = safetyToolkitInteractor;
        this.f32831g = orderTracker;
        this.f32832h = orderProvider;
        this.f32833i = routeSharingInteractor;
        this.f32834j = audioRecordingAnalytics;
        this.f32835k = permissionAnalytics;
        this.f32836l = safetyToolkitAnalytics;
        this.f32837m = new MutableLiveData<>();
        this.f32838n = new CompositeDisposable();
        BehaviorSubject<OrderDetails> e8 = BehaviorSubject.e();
        Intrinsics.e(e8, "create<OrderDetails>()");
        this.f32839o = e8;
        this.f32840p = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        CompositeDisposable compositeDisposable = this.f32838n;
        Observable distinctUntilChanged = ObservableExtKt.g(this.f32830f.y()).distinctUntilChanged();
        final Function1<List<? extends SafetyFeature>, Unit> function1 = new Function1<List<? extends SafetyFeature>, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<SafetyFeature> list) {
                MutableLiveData mutableLiveData;
                mutableLiveData = SafetyToolkitViewModel.this.f32837m;
                mutableLiveData.o(list);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends SafetyFeature> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        compositeDisposable.b(distinctUntilChanged.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SafetyToolkitViewModel.P(Function1.this, obj);
            }
        }));
        CompositeDisposable compositeDisposable2 = this.f32838n;
        Observable<List<OrderDetails>> a8 = this.f32832h.a();
        final Function1<List<? extends OrderDetails>, Unit> function12 = new Function1<List<? extends OrderDetails>, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitViewModel$onStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<? extends OrderDetails> orderDetails) {
                BehaviorSubject behaviorSubject;
                Intrinsics.e(orderDetails, "orderDetails");
                ActiveOrderDetails i8 = OrderProviderUtils.i(orderDetails);
                if (i8 != null) {
                    behaviorSubject = SafetyToolkitViewModel.this.f32839o;
                    behaviorSubject.onNext(i8);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends OrderDetails> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        compositeDisposable2.b(a8.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SafetyToolkitViewModel.Q(Function1.this, obj);
            }
        }));
        BehaviorSubject<ExternalHelpProviderResponse> w7 = this.f32830f.w();
        final Function1<ExternalHelpProviderResponse, Unit> function13 = new Function1<ExternalHelpProviderResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitViewModel$onStart$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ExternalHelpProviderResponse externalHelpProviderResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = SafetyToolkitViewModel.this.f32840p;
                mutableLiveData.o(externalHelpProviderResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExternalHelpProviderResponse externalHelpProviderResponse) {
                b(externalHelpProviderResponse);
                return Unit.f50853a;
            }
        };
        Disposable subscribe = w7.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SafetyToolkitViewModel.R(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun onStart() {…    }.autoDispose()\n    }");
        v(subscribe);
    }

    public final LiveData<ExternalHelpProviderResponse> M() {
        MutableLiveData<ExternalHelpProviderResponse> mutableLiveData = this.f32840p;
        Intrinsics.d(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<ee.mtakso.driver.network.client.emergencyassist.help_provider.ExternalHelpProviderResponse>");
        return mutableLiveData;
    }

    public final LiveData<List<SafetyFeature>> N() {
        return this.f32837m;
    }

    public final void O() {
        this.f32831g.e0();
    }

    public final void S() {
        this.f32830f.B();
    }

    public final void T() {
        OrderDetails g8 = this.f32839o.g();
        if (g8 != null) {
            OrderHandle a8 = g8.a();
            CompositeDisposable compositeDisposable = this.f32838n;
            Single l8 = l(SingleExtKt.d(this.f32833i.a(a8.a(), a8.b())));
            final Function1<RouteSharing, Unit> function1 = new Function1<RouteSharing, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitViewModel$shareTrip$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(RouteSharing routeSharing) {
                    RouteSharingInteractor routeSharingInteractor;
                    routeSharingInteractor = SafetyToolkitViewModel.this.f32833i;
                    routeSharingInteractor.b(routeSharing.a());
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(RouteSharing routeSharing) {
                    b(routeSharing);
                    return Unit.f50853a;
                }
            };
            Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.i
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    SafetyToolkitViewModel.U(Function1.this, obj);
                }
            };
            final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitViewModel$shareTrip$1$2
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
                public final void invoke2(Throwable throwable) {
                    SafetyToolkitViewModel safetyToolkitViewModel = SafetyToolkitViewModel.this;
                    Intrinsics.e(throwable, "throwable");
                    BaseViewModel.A(safetyToolkitViewModel, throwable, null, 2, null);
                }
            };
            compositeDisposable.b(l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.j
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    SafetyToolkitViewModel.V(Function1.this, obj);
                }
            }));
        }
    }

    public final void W(RecorderEventState recorderEventState) {
        Intrinsics.f(recorderEventState, "recorderEventState");
        this.f32834j.E(recorderEventState.a());
    }

    public final void X(String property) {
        Intrinsics.f(property, "property");
        this.f32836l.e0(property);
    }

    public final void Y() {
        this.f32835k.H0();
    }

    public final void Z() {
        this.f32835k.X();
    }

    public final void a0() {
        this.f32835k.u3("trip audio recording");
    }

    public final void b0() {
        this.f32830f.D();
    }

    public final void c0() {
        this.f32830f.E();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        DisposableExtKt.a(this.f32838n);
    }
}
