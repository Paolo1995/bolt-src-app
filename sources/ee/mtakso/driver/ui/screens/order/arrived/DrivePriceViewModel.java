package ee.mtakso.driver.ui.screens.order.arrived;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.order.PriceReviewInfo;
import ee.mtakso.driver.network.client.order.RateClientInfo;
import ee.mtakso.driver.network.client.price.PriceReviewReason;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics;
import ee.mtakso.driver.service.connectivity.NetworkConnectionStatus;
import ee.mtakso.driver.service.modules.order.v2.OrderStateManager;
import ee.mtakso.driver.service.modules.order.v2.OrderTracker;
import ee.mtakso.driver.service.order.details.OrderManager;
import ee.mtakso.driver.service.order.details.OrderTryAgainManager;
import ee.mtakso.driver.service.rating.app.AppRatingManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData;
import ee.mtakso.driver.ui.common.internet.InternetDataDelegate;
import ee.mtakso.driver.ui.interactor.warnings.AuthorizedWarningInteractor;
import ee.mtakso.driver.ui.interactor.warnings.WarningMessage;
import ee.mtakso.driver.ui.screens.order.arrived.PriceScreenState;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.PriceReviewResult;
import ee.mtakso.driver.ui.screens.order.arrived.raterider.RiderRatingInfo;
import ee.mtakso.driver.ui.screens.order.finish.RightButtonState;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpInteractor;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpType;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistInteractor;
import ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyFABButtonType;
import ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyUIUtils;
import ee.mtakso.driver.utils.AssertUtils;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.android.audio_recording_engine.engine.RecorderState;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import j$.util.Spliterator;
import java.math.BigDecimal;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrivePriceViewModel.kt */
/* loaded from: classes3.dex */
public final class DrivePriceViewModel extends BaseViewModel {
    private Disposable A;
    private Disposable B;
    private final MutableLiveData<PriceScreenState> C;
    private final ObservableLiveData<WarningMessage> D;
    private final MutableLiveData<Boolean> E;
    private Disposable F;
    private final LiveEvent<Unit> G;
    private final LiveData<Boolean> H;

    /* renamed from: f  reason: collision with root package name */
    private final DrivePriceInteractor f31015f;

    /* renamed from: g  reason: collision with root package name */
    private final DriverProvider f31016g;

    /* renamed from: h  reason: collision with root package name */
    private final OrderStateManager f31017h;

    /* renamed from: i  reason: collision with root package name */
    private final OrderTracker f31018i;

    /* renamed from: j  reason: collision with root package name */
    private final AppRatingManager f31019j;

    /* renamed from: k  reason: collision with root package name */
    private final InternetDataDelegate f31020k;

    /* renamed from: l  reason: collision with root package name */
    private final AuthorizedWarningInteractor f31021l;

    /* renamed from: m  reason: collision with root package name */
    private final SafetyToolkitAnalytics f31022m;

    /* renamed from: n  reason: collision with root package name */
    private final EmergencyAssistInteractor f31023n;

    /* renamed from: o  reason: collision with root package name */
    private final DidYouGetHelpInteractor f31024o;

    /* renamed from: p  reason: collision with root package name */
    private final DriverSettings f31025p;

    /* renamed from: q  reason: collision with root package name */
    private final AudioRecordingManager f31026q;

    /* renamed from: r  reason: collision with root package name */
    private final OrderTryAgainManager f31027r;

    /* renamed from: s  reason: collision with root package name */
    private final OrderManager f31028s;

    /* renamed from: t  reason: collision with root package name */
    private BigDecimal f31029t;

    /* renamed from: u  reason: collision with root package name */
    private PriceReviewInfo f31030u;

    /* renamed from: v  reason: collision with root package name */
    private final MutableLiveData<RightButtonState> f31031v;

    /* renamed from: w  reason: collision with root package name */
    private final MutableLiveData<SafetyFABButtonType> f31032w;

    /* renamed from: x  reason: collision with root package name */
    private final LiveEvent<DidYouGetHelpType> f31033x;

    /* renamed from: y  reason: collision with root package name */
    private final MutableLiveData<Boolean> f31034y;

    /* renamed from: z  reason: collision with root package name */
    private final MutableLiveData<DrivePriceScreenData> f31035z;

    @Inject
    public DrivePriceViewModel(DrivePriceInteractor drivePriceInteractor, DriverProvider driverProvider, OrderStateManager orderStateManager, OrderTracker orderTracker, AppRatingManager appRatingManager, InternetDataDelegate internetDelegate, AuthorizedWarningInteractor warningInteractor, SafetyToolkitAnalytics safetyToolkitAnalytics, EmergencyAssistInteractor emergencyAssistInteractor, DidYouGetHelpInteractor didYouGetHelpInteractor, DriverSettings driverSettings, AudioRecordingManager audioRecordingManager, OrderTryAgainManager orderTryAgainManager, OrderManager orderManager) {
        Intrinsics.f(drivePriceInteractor, "drivePriceInteractor");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(orderStateManager, "orderStateManager");
        Intrinsics.f(orderTracker, "orderTracker");
        Intrinsics.f(appRatingManager, "appRatingManager");
        Intrinsics.f(internetDelegate, "internetDelegate");
        Intrinsics.f(warningInteractor, "warningInteractor");
        Intrinsics.f(safetyToolkitAnalytics, "safetyToolkitAnalytics");
        Intrinsics.f(emergencyAssistInteractor, "emergencyAssistInteractor");
        Intrinsics.f(didYouGetHelpInteractor, "didYouGetHelpInteractor");
        Intrinsics.f(driverSettings, "driverSettings");
        Intrinsics.f(audioRecordingManager, "audioRecordingManager");
        Intrinsics.f(orderTryAgainManager, "orderTryAgainManager");
        Intrinsics.f(orderManager, "orderManager");
        this.f31015f = drivePriceInteractor;
        this.f31016g = driverProvider;
        this.f31017h = orderStateManager;
        this.f31018i = orderTracker;
        this.f31019j = appRatingManager;
        this.f31020k = internetDelegate;
        this.f31021l = warningInteractor;
        this.f31022m = safetyToolkitAnalytics;
        this.f31023n = emergencyAssistInteractor;
        this.f31024o = didYouGetHelpInteractor;
        this.f31025p = driverSettings;
        this.f31026q = audioRecordingManager;
        this.f31027r = orderTryAgainManager;
        this.f31028s = orderManager;
        BigDecimal ZERO = BigDecimal.ZERO;
        Intrinsics.e(ZERO, "ZERO");
        this.f31029t = ZERO;
        this.f31031v = new MutableLiveData<>(new RightButtonState(false, false, 3, null));
        this.f31032w = new MutableLiveData<>();
        this.f31033x = new LiveEvent<>();
        this.f31034y = new MutableLiveData<>();
        this.f31035z = new MutableLiveData<>();
        this.C = new MutableLiveData<>(PriceScreenState.Initial.f31069a);
        this.D = new ObservableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.E = mutableLiveData;
        this.G = new LiveEvent<>();
        this.H = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void D0() {
        if (G0()) {
            this.C.o(PriceScreenState.RateRider.f31073a);
        } else {
            X(null);
        }
    }

    private final boolean G0() {
        return this.f31016g.m().h();
    }

    private final void H0() {
        this.f31034y.m(Boolean.valueOf(this.f31025p.N().a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0(DrivePriceScreenData drivePriceScreenData) {
        PriceScreenState priceScreenState;
        MutableLiveData<PriceScreenState> mutableLiveData = this.C;
        if (drivePriceScreenData.j() != PriceModificationMethod.DISABLED) {
            priceScreenState = PriceScreenState.SetPriceScreen.f31074a;
        } else {
            priceScreenState = PriceScreenState.PricePreviewScreen.f31070a;
        }
        mutableLiveData.o(priceScreenState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PriceReviewInfo S0(long j8, BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return new PriceReviewInfo(j8, bigDecimal, bigDecimal2, false, null, null, null, 120, null);
    }

    private final void X(final RiderRatingInfo riderRatingInfo) {
        RateClientInfo rateClientInfo;
        PriceReviewInfo a8;
        this.f31018i.H();
        PriceReviewInfo priceReviewInfo = this.f31030u;
        if (priceReviewInfo == null) {
            AssertUtils.a("PriceReviewInfo cannot be null. It should contain calculation id at least");
            return;
        }
        if (riderRatingInfo == null) {
            rateClientInfo = null;
        } else {
            rateClientInfo = new RateClientInfo(riderRatingInfo.c(), riderRatingInfo.b(), riderRatingInfo.a());
        }
        y().o(Boolean.TRUE);
        OrderStateManager orderStateManager = this.f31017h;
        BigDecimal c8 = ((DrivePriceScreenData) LiveDataExtKt.b(this.f31035z)).c();
        if (c8 == null) {
            c8 = this.f31029t;
        }
        a8 = priceReviewInfo.a((r18 & 1) != 0 ? priceReviewInfo.f22478a : 0L, (r18 & 2) != 0 ? priceReviewInfo.f22479b : c8, (r18 & 4) != 0 ? priceReviewInfo.f22480c : null, (r18 & 8) != 0 ? priceReviewInfo.f22481d : false, (r18 & 16) != 0 ? priceReviewInfo.f22482e : null, (r18 & 32) != 0 ? priceReviewInfo.f22483f : null, (r18 & 64) != 0 ? priceReviewInfo.f22484g : null);
        Single f8 = orderStateManager.o0(a8, rateClientInfo).f(Single.u(new Callable() { // from class: ee.mtakso.driver.ui.screens.order.arrived.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit Y;
                Y = DrivePriceViewModel.Y(DrivePriceViewModel.this, riderRatingInfo);
                return Y;
            }
        }));
        Intrinsics.e(f8, "orderStateManager.finali…o?.rating)\n            })");
        Single j8 = SingleExtKt.d(f8).j(new Action() { // from class: ee.mtakso.driver.ui.screens.order.arrived.f
            @Override // io.reactivex.functions.Action
            public final void run() {
                DrivePriceViewModel.Z(DrivePriceViewModel.this);
            }
        });
        final DrivePriceViewModel$finalizeOrder$3 drivePriceViewModel$finalizeOrder$3 = new Function1<Unit, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.DrivePriceViewModel$finalizeOrder$3
            public final void b(Unit unit) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                b(unit);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.arrived.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DrivePriceViewModel.a0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.DrivePriceViewModel$finalizeOrder$4
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
                DrivePriceViewModel drivePriceViewModel = DrivePriceViewModel.this;
                Intrinsics.e(error, "error");
                BaseViewModel.A(drivePriceViewModel, error, null, 2, null);
            }
        };
        this.B = j8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.arrived.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DrivePriceViewModel.b0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(DrivePriceViewModel this$0, RiderRatingInfo riderRatingInfo) {
        Integer num;
        Intrinsics.f(this$0, "this$0");
        AppRatingManager appRatingManager = this$0.f31019j;
        if (riderRatingInfo != null) {
            num = Integer.valueOf(riderRatingInfo.c());
        } else {
            num = null;
        }
        appRatingManager.n(num);
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(DrivePriceViewModel this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.y().o(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean f0() {
        return this.f31016g.q().J();
    }

    private final void g0() {
        y().o(Boolean.TRUE);
        Single d8 = SingleExtKt.d(this.f31015f.r());
        final Function1<DrivePriceScreenData, Unit> function1 = new Function1<DrivePriceScreenData, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.DrivePriceViewModel$loadScreenData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DrivePriceScreenData priceInfo) {
                MutableLiveData y7;
                MutableLiveData mutableLiveData;
                PriceReviewInfo S0;
                y7 = DrivePriceViewModel.this.y();
                y7.o(Boolean.FALSE);
                mutableLiveData = DrivePriceViewModel.this.f31035z;
                mutableLiveData.o(priceInfo);
                DrivePriceViewModel.this.f31029t = priceInfo.h();
                DrivePriceViewModel drivePriceViewModel = DrivePriceViewModel.this;
                long d9 = priceInfo.d();
                BigDecimal h8 = priceInfo.h();
                BigDecimal l8 = priceInfo.l();
                if (l8 == null) {
                    l8 = BigDecimal.ZERO;
                }
                Intrinsics.e(l8, "priceInfo.promoPrice ?: BigDecimal.ZERO");
                S0 = drivePriceViewModel.S0(d9, h8, l8);
                drivePriceViewModel.f31030u = S0;
                DrivePriceViewModel drivePriceViewModel2 = DrivePriceViewModel.this;
                Intrinsics.e(priceInfo, "priceInfo");
                drivePriceViewModel2.Q0(priceInfo);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrivePriceScreenData drivePriceScreenData) {
                b(drivePriceScreenData);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.arrived.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DrivePriceViewModel.h0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.DrivePriceViewModel$loadScreenData$2
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
                MutableLiveData y7;
                y7 = DrivePriceViewModel.this.y();
                y7.o(Boolean.FALSE);
                DrivePriceViewModel drivePriceViewModel = DrivePriceViewModel.this;
                Intrinsics.e(error, "error");
                BaseViewModel.A(drivePriceViewModel, error, null, 2, null);
            }
        };
        this.A = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.arrived.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DrivePriceViewModel.i0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void j0() {
        PublishSubject<DidYouGetHelpType> a8 = this.f31024o.a();
        final Function1<DidYouGetHelpType, Unit> function1 = new Function1<DidYouGetHelpType, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.DrivePriceViewModel$observeDidYouGetHelpSignal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DidYouGetHelpType didYouGetHelpType) {
                LiveEvent liveEvent;
                liveEvent = DrivePriceViewModel.this.f31033x;
                liveEvent.o(didYouGetHelpType);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DidYouGetHelpType didYouGetHelpType) {
                b(didYouGetHelpType);
                return Unit.f50853a;
            }
        };
        Disposable subscribe = a8.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.arrived.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DrivePriceViewModel.k0(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observeDidYo…    }.autoDispose()\n    }");
        v(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void q0() {
        BehaviorSubject<Boolean> a8 = this.f31023n.a();
        Observable<RecorderState> f8 = this.f31026q.f();
        final DrivePriceViewModel$observeSafetyFABState$1 drivePriceViewModel$observeSafetyFABState$1 = new Function2<Boolean, RecorderState, SafetyFABButtonType>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.DrivePriceViewModel$observeSafetyFABState$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final SafetyFABButtonType s(Boolean hasActiveIncident, RecorderState recorderState) {
                Intrinsics.f(hasActiveIncident, "hasActiveIncident");
                Intrinsics.f(recorderState, "recorderState");
                return SafetyUIUtils.f32878a.a(hasActiveIncident.booleanValue(), recorderState);
            }
        };
        Observable combineLatest = Observable.combineLatest(a8, f8, new BiFunction() { // from class: ee.mtakso.driver.ui.screens.order.arrived.k
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                SafetyFABButtonType r02;
                r02 = DrivePriceViewModel.r0(Function2.this, obj, obj2);
                return r02;
            }
        });
        Intrinsics.e(combineLatest, "combineLatest(\n         … recorderState)\n        }");
        Observable g8 = ObservableExtKt.g(combineLatest);
        final Function1<SafetyFABButtonType, Unit> function1 = new Function1<SafetyFABButtonType, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.DrivePriceViewModel$observeSafetyFABState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(SafetyFABButtonType safetyFABButtonType) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DrivePriceViewModel.this.f31032w;
                mutableLiveData.o(safetyFABButtonType);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SafetyFABButtonType safetyFABButtonType) {
                b(safetyFABButtonType);
                return Unit.f50853a;
            }
        };
        Disposable subscribe = g8.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.arrived.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DrivePriceViewModel.s0(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observeSafet…    }.autoDispose()\n    }");
        v(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SafetyFABButtonType r0(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SafetyFABButtonType) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void A0(RiderRatingInfo ratingInfo) {
        Intrinsics.f(ratingInfo, "ratingInfo");
        this.f31018i.W(ratingInfo.b());
        X(ratingInfo);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        boolean z7;
        this.f31018i.Q();
        MutableLiveData<RightButtonState> mutableLiveData = this.f31031v;
        if (!f0() && this.f31016g.m().I()) {
            z7 = true;
        } else {
            z7 = false;
        }
        mutableLiveData.o(new RightButtonState(z7, f0()));
        q0();
        j0();
        H0();
        g0();
        this.f31020k.f();
        ObservableLiveData.t(this.D, this.f31021l.e(), null, new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.DrivePriceViewModel$onStart$1
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
                Intrinsics.f(it, "it");
                BaseViewModel.A(DrivePriceViewModel.this, it, null, 2, null);
            }
        }, 2, null);
        Observable<Boolean> observeOn = this.f31027r.c().observeOn(AndroidSchedulers.a());
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.DrivePriceViewModel$onStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean bool) {
                MutableLiveData mutableLiveData2;
                mutableLiveData2 = DrivePriceViewModel.this.E;
                mutableLiveData2.o(bool);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        this.F = observeOn.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.arrived.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DrivePriceViewModel.C0(Function1.this, obj);
            }
        });
    }

    public final void B0() {
        this.f31018i.V();
        this.G.m(Unit.f50853a);
    }

    public final void E0() {
        this.E.o(Boolean.FALSE);
        this.f31028s.t();
    }

    public final void F0() {
        DrivePriceScreenData a8;
        DrivePriceScreenData a9;
        DrivePriceScreenData data = (DrivePriceScreenData) LiveDataExtKt.b(this.f31035z);
        if (data.c() == null) {
            MutableLiveData<DrivePriceScreenData> mutableLiveData = this.f31035z;
            Intrinsics.e(data, "data");
            a9 = data.a((r38 & 1) != 0 ? data.f30997a : 0L, (r38 & 2) != 0 ? data.f30998b : null, (r38 & 4) != 0 ? data.f30999c : false, (r38 & 8) != 0 ? data.f31000d : null, (r38 & 16) != 0 ? data.f31001e : 0.0d, (r38 & 32) != 0 ? data.f31002f : null, (r38 & 64) != 0 ? data.f31003g : null, (r38 & 128) != 0 ? data.f31004h : 0, (r38 & Spliterator.NONNULL) != 0 ? data.f31005i : null, (r38 & 512) != 0 ? data.f31006j : null, (r38 & Spliterator.IMMUTABLE) != 0 ? data.f31007k : null, (r38 & 2048) != 0 ? data.f31008l : null, (r38 & 4096) != 0 ? data.f31009m : false, (r38 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? data.f31010n : null, (r38 & 16384) != 0 ? data.f31011o : true, (r38 & 32768) != 0 ? data.f31012p : null, (r38 & 65536) != 0 ? data.f31013q : null, (r38 & 131072) != 0 ? data.f31014r : false);
            mutableLiveData.o(a9);
            return;
        }
        MutableLiveData<DrivePriceScreenData> mutableLiveData2 = this.f31035z;
        Intrinsics.e(data, "data");
        a8 = data.a((r38 & 1) != 0 ? data.f30997a : 0L, (r38 & 2) != 0 ? data.f30998b : null, (r38 & 4) != 0 ? data.f30999c : false, (r38 & 8) != 0 ? data.f31000d : null, (r38 & 16) != 0 ? data.f31001e : 0.0d, (r38 & 32) != 0 ? data.f31002f : null, (r38 & 64) != 0 ? data.f31003g : null, (r38 & 128) != 0 ? data.f31004h : 0, (r38 & Spliterator.NONNULL) != 0 ? data.f31005i : null, (r38 & 512) != 0 ? data.f31006j : null, (r38 & Spliterator.IMMUTABLE) != 0 ? data.f31007k : null, (r38 & 2048) != 0 ? data.f31008l : data.c(), (r38 & 4096) != 0 ? data.f31009m : false, (r38 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? data.f31010n : null, (r38 & 16384) != 0 ? data.f31011o : false, (r38 & 32768) != 0 ? data.f31012p : null, (r38 & 65536) != 0 ? data.f31013q : null, (r38 & 131072) != 0 ? data.f31014r : false);
        mutableLiveData2.o(a8);
        this.C.o(PriceScreenState.PricePreviewScreen.f31070a);
    }

    public final void I0() {
        this.f31018i.D();
    }

    public final void J0() {
        this.f31018i.R();
    }

    public final void K0() {
        this.f31018i.T();
    }

    public final void L0() {
        this.f31018i.U();
    }

    public final void M0() {
        this.f31022m.M0();
    }

    public final void N0() {
        this.f31018i.b0();
    }

    public final void O0() {
        this.f31018i.c0();
    }

    public final void P0() {
        this.C.o(PriceScreenState.SetPriceScreen.f31074a);
    }

    public final void R0() {
        this.f31034y.m(Boolean.TRUE);
        this.f31025p.N().b(true);
    }

    public final boolean W() {
        DrivePriceScreenData a8;
        DrivePriceScreenData data = (DrivePriceScreenData) LiveDataExtKt.b(this.f31035z);
        if (data.c() != null && data.c().signum() != 0) {
            return true;
        }
        MutableLiveData<DrivePriceScreenData> mutableLiveData = this.f31035z;
        Intrinsics.e(data, "data");
        a8 = data.a((r38 & 1) != 0 ? data.f30997a : 0L, (r38 & 2) != 0 ? data.f30998b : null, (r38 & 4) != 0 ? data.f30999c : false, (r38 & 8) != 0 ? data.f31000d : null, (r38 & 16) != 0 ? data.f31001e : 0.0d, (r38 & 32) != 0 ? data.f31002f : null, (r38 & 64) != 0 ? data.f31003g : null, (r38 & 128) != 0 ? data.f31004h : 0, (r38 & Spliterator.NONNULL) != 0 ? data.f31005i : null, (r38 & 512) != 0 ? data.f31006j : null, (r38 & Spliterator.IMMUTABLE) != 0 ? data.f31007k : null, (r38 & 2048) != 0 ? data.f31008l : null, (r38 & 4096) != 0 ? data.f31009m : false, (r38 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? data.f31010n : null, (r38 & 16384) != 0 ? data.f31011o : true, (r38 & 32768) != 0 ? data.f31012p : null, (r38 & 65536) != 0 ? data.f31013q : null, (r38 & 131072) != 0 ? data.f31014r : false);
        mutableLiveData.o(a8);
        return false;
    }

    public LiveData<NetworkConnectionStatus> c0() {
        return this.f31020k.e();
    }

    public final LiveData<Boolean> d0() {
        return this.H;
    }

    public final ObservableLiveData<WarningMessage> e0() {
        return this.D;
    }

    public final LiveEvent<DidYouGetHelpType> l0() {
        return this.f31033x;
    }

    public final LiveData<DrivePriceScreenData> m0() {
        return this.f31035z;
    }

    public final LiveData<PriceScreenState> n0() {
        return this.C;
    }

    public final LiveData<RightButtonState> o0() {
        MutableLiveData<RightButtonState> mutableLiveData = this.f31031v;
        Intrinsics.d(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<ee.mtakso.driver.ui.screens.order.finish.RightButtonState>");
        return mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.A;
        if (disposable != null) {
            disposable.dispose();
        }
        this.A = null;
        Disposable disposable2 = this.B;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.B = null;
        this.f31020k.d();
        DisposableExtKt.a(this.D);
        Disposable disposable3 = this.F;
        if (disposable3 != null) {
            DisposableExtKt.a(disposable3);
        }
    }

    public final LiveData<SafetyFABButtonType> p0() {
        MutableLiveData<SafetyFABButtonType> mutableLiveData = this.f31032w;
        Intrinsics.d(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyFABButtonType>");
        return mutableLiveData;
    }

    public final LiveData<Boolean> t0() {
        MutableLiveData<Boolean> mutableLiveData = this.f31034y;
        Intrinsics.d(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        return mutableLiveData;
    }

    public final LiveEvent<Unit> u0() {
        return this.G;
    }

    public final void v0(BigDecimal bigDecimal) {
        DrivePriceScreenData a8;
        DrivePriceScreenData data = (DrivePriceScreenData) LiveDataExtKt.b(this.f31035z);
        MutableLiveData<DrivePriceScreenData> mutableLiveData = this.f31035z;
        Intrinsics.e(data, "data");
        a8 = data.a((r38 & 1) != 0 ? data.f30997a : 0L, (r38 & 2) != 0 ? data.f30998b : null, (r38 & 4) != 0 ? data.f30999c : false, (r38 & 8) != 0 ? data.f31000d : null, (r38 & 16) != 0 ? data.f31001e : 0.0d, (r38 & 32) != 0 ? data.f31002f : null, (r38 & 64) != 0 ? data.f31003g : null, (r38 & 128) != 0 ? data.f31004h : 0, (r38 & Spliterator.NONNULL) != 0 ? data.f31005i : null, (r38 & 512) != 0 ? data.f31006j : null, (r38 & Spliterator.IMMUTABLE) != 0 ? data.f31007k : null, (r38 & 2048) != 0 ? data.f31008l : bigDecimal, (r38 & 4096) != 0 ? data.f31009m : false, (r38 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? data.f31010n : null, (r38 & 16384) != 0 ? data.f31011o : false, (r38 & 32768) != 0 ? data.f31012p : null, (r38 & 65536) != 0 ? data.f31013q : null, (r38 & 131072) != 0 ? data.f31014r : false);
        mutableLiveData.o(a8);
    }

    public final void w0() {
        DrivePriceScreenData a8;
        DrivePriceScreenData a9;
        this.f31018i.S();
        DrivePriceScreenData data = (DrivePriceScreenData) LiveDataExtKt.b(this.f31035z);
        if (data.c() == null) {
            MutableLiveData<DrivePriceScreenData> mutableLiveData = this.f31035z;
            Intrinsics.e(data, "data");
            a9 = data.a((r38 & 1) != 0 ? data.f30997a : 0L, (r38 & 2) != 0 ? data.f30998b : null, (r38 & 4) != 0 ? data.f30999c : false, (r38 & 8) != 0 ? data.f31000d : null, (r38 & 16) != 0 ? data.f31001e : 0.0d, (r38 & 32) != 0 ? data.f31002f : null, (r38 & 64) != 0 ? data.f31003g : null, (r38 & 128) != 0 ? data.f31004h : 0, (r38 & Spliterator.NONNULL) != 0 ? data.f31005i : null, (r38 & 512) != 0 ? data.f31006j : null, (r38 & Spliterator.IMMUTABLE) != 0 ? data.f31007k : null, (r38 & 2048) != 0 ? data.f31008l : null, (r38 & 4096) != 0 ? data.f31009m : false, (r38 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? data.f31010n : null, (r38 & 16384) != 0 ? data.f31011o : true, (r38 & 32768) != 0 ? data.f31012p : null, (r38 & 65536) != 0 ? data.f31013q : null, (r38 & 131072) != 0 ? data.f31014r : false);
            mutableLiveData.o(a9);
            return;
        }
        MutableLiveData<DrivePriceScreenData> mutableLiveData2 = this.f31035z;
        Intrinsics.e(data, "data");
        a8 = data.a((r38 & 1) != 0 ? data.f30997a : 0L, (r38 & 2) != 0 ? data.f30998b : null, (r38 & 4) != 0 ? data.f30999c : false, (r38 & 8) != 0 ? data.f31000d : null, (r38 & 16) != 0 ? data.f31001e : 0.0d, (r38 & 32) != 0 ? data.f31002f : null, (r38 & 64) != 0 ? data.f31003g : null, (r38 & 128) != 0 ? data.f31004h : 0, (r38 & Spliterator.NONNULL) != 0 ? data.f31005i : null, (r38 & 512) != 0 ? data.f31006j : null, (r38 & Spliterator.IMMUTABLE) != 0 ? data.f31007k : null, (r38 & 2048) != 0 ? data.f31008l : data.c(), (r38 & 4096) != 0 ? data.f31009m : false, (r38 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? data.f31010n : null, (r38 & 16384) != 0 ? data.f31011o : false, (r38 & 32768) != 0 ? data.f31012p : null, (r38 & 65536) != 0 ? data.f31013q : null, (r38 & 131072) != 0 ? data.f31014r : false);
        mutableLiveData2.o(a8);
        D0();
    }

    public final void x0(PriceReviewReason priceReviewReason) {
        Intrinsics.f(priceReviewReason, "priceReviewReason");
        DrivePriceScreenData drivePriceScreenData = (DrivePriceScreenData) LiveDataExtKt.b(this.f31035z);
        MutableLiveData<PriceScreenState> mutableLiveData = this.C;
        Intrinsics.e(drivePriceScreenData, "drivePriceScreenData");
        mutableLiveData.o(new PriceScreenState.ProblemWithPrice(priceReviewReason, drivePriceScreenData));
    }

    public final void y0(BigDecimal price, BigDecimal delta) {
        DrivePriceScreenData a8;
        Intrinsics.f(price, "price");
        Intrinsics.f(delta, "delta");
        DrivePriceScreenData data = (DrivePriceScreenData) LiveDataExtKt.b(this.f31035z);
        BigDecimal add = price.add(delta);
        Intrinsics.e(add, "this.add(other)");
        MutableLiveData<DrivePriceScreenData> mutableLiveData = this.f31035z;
        Intrinsics.e(data, "data");
        a8 = data.a((r38 & 1) != 0 ? data.f30997a : 0L, (r38 & 2) != 0 ? data.f30998b : null, (r38 & 4) != 0 ? data.f30999c : false, (r38 & 8) != 0 ? data.f31000d : null, (r38 & 16) != 0 ? data.f31001e : 0.0d, (r38 & 32) != 0 ? data.f31002f : null, (r38 & 64) != 0 ? data.f31003g : null, (r38 & 128) != 0 ? data.f31004h : 0, (r38 & Spliterator.NONNULL) != 0 ? data.f31005i : null, (r38 & 512) != 0 ? data.f31006j : null, (r38 & Spliterator.IMMUTABLE) != 0 ? data.f31007k : null, (r38 & 2048) != 0 ? data.f31008l : add, (r38 & 4096) != 0 ? data.f31009m : false, (r38 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? data.f31010n : null, (r38 & 16384) != 0 ? data.f31011o : false, (r38 & 32768) != 0 ? data.f31012p : null, (r38 & 65536) != 0 ? data.f31013q : null, (r38 & 131072) != 0 ? data.f31014r : false);
        mutableLiveData.o(a8);
    }

    public final void z0(PriceReviewResult priceReviewResult) {
        PriceReviewInfo a8;
        Intrinsics.f(priceReviewResult, "priceReviewResult");
        PriceReviewInfo priceReviewInfo = this.f31030u;
        if (priceReviewInfo == null) {
            AssertUtils.a("priceReviewInfo cannot be null");
            return;
        }
        a8 = priceReviewInfo.a((r18 & 1) != 0 ? priceReviewInfo.f22478a : 0L, (r18 & 2) != 0 ? priceReviewInfo.f22479b : priceReviewInfo.g(), (r18 & 4) != 0 ? priceReviewInfo.f22480c : null, (r18 & 8) != 0 ? priceReviewInfo.f22481d : true, (r18 & 16) != 0 ? priceReviewInfo.f22482e : priceReviewResult.a(), (r18 & 32) != 0 ? priceReviewInfo.f22483f : priceReviewResult.c(), (r18 & 64) != 0 ? priceReviewInfo.f22484g : priceReviewResult.b());
        this.f31030u = a8;
        D0();
    }
}
