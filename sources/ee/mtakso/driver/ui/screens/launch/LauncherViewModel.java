package ee.mtakso.driver.ui.screens.launch;

import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.auth.anonymous.AuthResult;
import ee.mtakso.driver.platform.check.PlatformServicesState;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityVerificationResult;
import ee.mtakso.driver.service.analytics.event.facade.AppPerformanceAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ChatAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.DeviceAnalytics;
import ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing;
import ee.mtakso.driver.service.auth.AppVersionState;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.auth.FlowState;
import ee.mtakso.driver.service.auth.FullAuthFlow;
import ee.mtakso.driver.service.auth.NextScreen;
import ee.mtakso.driver.service.connectivity.NetworkConnectionStatus;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData;
import ee.mtakso.driver.ui.common.internet.InternetDataDelegate;
import ee.mtakso.driver.ui.interactor.warnings.UnauthorizedWarningInteractor;
import ee.mtakso.driver.ui.interactor.warnings.WarningMessage;
import ee.mtakso.driver.ui.screens.launch.LauncherViewModel;
import ee.mtakso.driver.ui.screens.launch.NavigationState;
import ee.mtakso.driver.ui.screens.signup.SignUpActivity;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LauncherViewModel.kt */
/* loaded from: classes3.dex */
public final class LauncherViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final FullAuthFlow f30405f;

    /* renamed from: g  reason: collision with root package name */
    private final InternetDataDelegate f30406g;

    /* renamed from: h  reason: collision with root package name */
    private final UnauthorizedWarningInteractor f30407h;

    /* renamed from: i  reason: collision with root package name */
    private final StartUpTracing f30408i;

    /* renamed from: j  reason: collision with root package name */
    private final RoutingManager f30409j;

    /* renamed from: k  reason: collision with root package name */
    private final AppPerformanceAnalytics f30410k;

    /* renamed from: l  reason: collision with root package name */
    private final ChatAnalytics f30411l;

    /* renamed from: m  reason: collision with root package name */
    private final DeviceAnalytics f30412m;

    /* renamed from: n  reason: collision with root package name */
    private final MutableLiveData<PlatformServicesState> f30413n;

    /* renamed from: o  reason: collision with root package name */
    private final LiveData<PlatformServicesState> f30414o;

    /* renamed from: p  reason: collision with root package name */
    private final MutableLiveData<PermissionManager.PermissionInfo> f30415p;

    /* renamed from: q  reason: collision with root package name */
    private final LiveData<PermissionManager.PermissionInfo> f30416q;

    /* renamed from: r  reason: collision with root package name */
    private final MutableLiveData<AppVersionState> f30417r;

    /* renamed from: s  reason: collision with root package name */
    private final LiveData<AppVersionState> f30418s;

    /* renamed from: t  reason: collision with root package name */
    private final MutableLiveData<NavigationState> f30419t;

    /* renamed from: u  reason: collision with root package name */
    private final LiveData<NavigationState> f30420u;

    /* renamed from: v  reason: collision with root package name */
    private final ObservableLiveData<WarningMessage> f30421v;

    /* renamed from: w  reason: collision with root package name */
    private Disposable f30422w;

    /* compiled from: LauncherViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30423a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f30424b;

        static {
            int[] iArr = new int[PermissionManager.DenyInitiator.values().length];
            try {
                iArr[PermissionManager.DenyInitiator.DENIED_BY_USER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PermissionManager.DenyInitiator.AUTOMATIC_DENY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f30423a = iArr;
            int[] iArr2 = new int[NextScreen.values().length];
            try {
                iArr2[NextScreen.CONTINUE_REGISTRATION_SIGNUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[NextScreen.CONTINUE_REGISTRATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[NextScreen.OPEN_LANDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f30424b = iArr2;
        }
    }

    @Inject
    public LauncherViewModel(FullAuthFlow authFlow, InternetDataDelegate internetDataDelegate, UnauthorizedWarningInteractor warningInteractor, StartUpTracing startUpTracing, RoutingManager routingManager, AppPerformanceAnalytics appPerformanceAnalytics, ChatAnalytics chatAnalytics, DeviceAnalytics deviceAnalytics) {
        Intrinsics.f(authFlow, "authFlow");
        Intrinsics.f(internetDataDelegate, "internetDataDelegate");
        Intrinsics.f(warningInteractor, "warningInteractor");
        Intrinsics.f(startUpTracing, "startUpTracing");
        Intrinsics.f(routingManager, "routingManager");
        Intrinsics.f(appPerformanceAnalytics, "appPerformanceAnalytics");
        Intrinsics.f(chatAnalytics, "chatAnalytics");
        Intrinsics.f(deviceAnalytics, "deviceAnalytics");
        this.f30405f = authFlow;
        this.f30406g = internetDataDelegate;
        this.f30407h = warningInteractor;
        this.f30408i = startUpTracing;
        this.f30409j = routingManager;
        this.f30410k = appPerformanceAnalytics;
        this.f30411l = chatAnalytics;
        this.f30412m = deviceAnalytics;
        MutableLiveData<PlatformServicesState> mutableLiveData = new MutableLiveData<>();
        this.f30413n = mutableLiveData;
        this.f30414o = mutableLiveData;
        MutableLiveData<PermissionManager.PermissionInfo> mutableLiveData2 = new MutableLiveData<>();
        this.f30415p = mutableLiveData2;
        this.f30416q = mutableLiveData2;
        MutableLiveData<AppVersionState> mutableLiveData3 = new MutableLiveData<>();
        this.f30417r = mutableLiveData3;
        this.f30418s = mutableLiveData3;
        MutableLiveData<NavigationState> mutableLiveData4 = new MutableLiveData<>(NavigationState.Splash.f30438a);
        this.f30419t = mutableLiveData4;
        this.f30420u = mutableLiveData4;
        this.f30421v = new ObservableLiveData<>();
    }

    private final void H(AppVersionState appVersionState) {
        if (appVersionState != AppVersionState.OK) {
            this.f30417r.o(appVersionState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(AuthStepResult authStepResult) {
        if (authStepResult instanceof AuthStepResult.PlatformServicesCheckResult) {
            K(((AuthStepResult.PlatformServicesCheckResult) authStepResult).a());
        } else if (authStepResult instanceof AuthStepResult.LocationPermission) {
            J(((AuthStepResult.LocationPermission) authStepResult).a());
        } else if (authStepResult instanceof AuthStepResult.RoutingAction) {
            Y(((AuthStepResult.RoutingAction) authStepResult).a());
        } else if (authStepResult instanceof AuthStepResult.AppVersionCheck) {
            H(((AuthStepResult.AppVersionCheck) authStepResult).a());
        } else if (authStepResult instanceof AuthStepResult.AuthenticationResult) {
            S(((AuthStepResult.AuthenticationResult) authStepResult).a());
        } else if (authStepResult instanceof AuthStepResult.Error) {
            Q(((AuthStepResult.Error) authStepResult).a());
        }
    }

    private final void J(PermissionManager.PermissionInfo permissionInfo) {
        PermissionManager.DenyInitiator a8;
        if (permissionInfo != null && (a8 = permissionInfo.a()) != null) {
            int i8 = WhenMappings.f30423a[a8.ordinal()];
            if (i8 != 1) {
                if (i8 == 2) {
                    this.f30415p.o(permissionInfo);
                    return;
                }
                return;
            }
            FullAuthFlow.s(this.f30405f, null, 1, null);
        }
    }

    private final void K(PlatformServicesState platformServicesState) {
        this.f30413n.o(platformServicesState);
    }

    private final void Q(Throwable th) {
        if (!(th instanceof StoreIntegrityVerificationResult.Error) && !ApiExceptionUtils.m(th, 5460)) {
            BaseViewModel.A(this, th, null, 2, null);
        } else {
            this.f30419t.o(new NavigationState.Landing(th));
        }
    }

    private final void S(AuthResult authResult) {
        if (authResult instanceof AuthResult.PartnerSuccess) {
            this.f30409j.c(SignUpActivity.Companion.b(SignUpActivity.f33328v, false, 1, null));
        }
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

    private final void Y(NextScreen nextScreen) {
        NavigationState navigationState;
        MutableLiveData<NavigationState> mutableLiveData = this.f30419t;
        int i8 = WhenMappings.f30424b[nextScreen.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    navigationState = new NavigationState.Landing(null, 1, null);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                navigationState = NavigationState.SignUp.f30437a;
            }
        } else {
            navigationState = NavigationState.SignUp.f30437a;
        }
        mutableLiveData.o(navigationState);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f30406g.f();
        Observable<AuthStepResult> k8 = this.f30405f.k();
        final Function1<AuthStepResult, Unit> function1 = new Function1<AuthStepResult, Unit>() { // from class: ee.mtakso.driver.ui.screens.launch.LauncherViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(AuthStepResult it) {
                Kalev.b("Auth event " + it);
                LauncherViewModel launcherViewModel = LauncherViewModel.this;
                Intrinsics.e(it, "it");
                launcherViewModel.I(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthStepResult authStepResult) {
                b(authStepResult);
                return Unit.f50853a;
            }
        };
        Consumer<? super AuthStepResult> consumer = new Consumer() { // from class: e4.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LauncherViewModel.U(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.launch.LauncherViewModel$onStart$2
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
                LauncherViewModel launcherViewModel = LauncherViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(launcherViewModel, it, null, 2, null);
            }
        };
        this.f30422w = k8.subscribe(consumer, new Consumer() { // from class: e4.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LauncherViewModel.V(Function1.this, obj);
            }
        });
        ObservableLiveData.t(this.f30421v, this.f30407h.n(), null, new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.launch.LauncherViewModel$onStart$3
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
                BaseViewModel.A(LauncherViewModel.this, it, null, 2, null);
            }
        }, 2, null);
    }

    public final void G() {
        FullAuthFlow.s(this.f30405f, null, 1, null);
    }

    public final LiveData<AppVersionState> L() {
        return this.f30418s;
    }

    public LiveData<NetworkConnectionStatus> M() {
        return this.f30406g.e();
    }

    public final LiveData<PermissionManager.PermissionInfo> N() {
        return this.f30416q;
    }

    public final LiveData<PlatformServicesState> O() {
        return this.f30414o;
    }

    public final LiveData<NavigationState> P() {
        return this.f30420u;
    }

    public final void R(Intent intent) {
        Intrinsics.f(intent, "intent");
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "Started login procedure", null, 2, null);
        }
        this.f30408i.c();
        this.f30405f.D(intent);
    }

    public final LiveData<WarningMessage> T() {
        return this.f30421v;
    }

    public final void W() {
        FullAuthFlow.s(this.f30405f, null, 1, null);
    }

    public final void X() {
        if (this.f30405f.u() == FlowState.PAUSED) {
            Kalev.b("Internet restored. Going to continue auth process...");
            FullAuthFlow.s(this.f30405f, null, 1, null);
        }
    }

    public final void Z() {
        this.f30405f.r(new AuthStepResult.AppVersionCheck(AppVersionState.OK));
    }

    public final void a0() {
        this.f30411l.l0();
    }

    public final void b0(boolean z7) {
        this.f30410k.i2(z7);
    }

    public final void c0(String availableInternalMemorySize) {
        Intrinsics.f(availableInternalMemorySize, "availableInternalMemorySize");
        this.f30412m.R(availableInternalMemorySize);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f30406g.d();
        Disposable disposable = this.f30422w;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
