package ee.mtakso.driver.ui.screens.login.v2.pswrd;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import ee.mtakso.driver.network.client.auth.anonymous.AuthResult;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.auth.AppVersionState;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.auth.flow.PasswordAuthFlow;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginViewModel;
import ee.mtakso.driver.utils.SystemUrlLauncher;
import ee.mtakso.driver.utils.UrlFactory;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PasswordLoginViewModel.kt */
/* loaded from: classes3.dex */
public final class PasswordLoginViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final PasswordAuthFlow f30523f;

    /* renamed from: g  reason: collision with root package name */
    private final UrlFactory f30524g;

    /* renamed from: h  reason: collision with root package name */
    private final SystemUrlLauncher f30525h;

    /* renamed from: i  reason: collision with root package name */
    private final LoginAnalytics f30526i;

    /* renamed from: j  reason: collision with root package name */
    private final AuthManager f30527j;

    /* renamed from: k  reason: collision with root package name */
    private final GeoLocationManager f30528k;

    /* renamed from: l  reason: collision with root package name */
    private final String f30529l;

    /* renamed from: m  reason: collision with root package name */
    private final MutableLiveData<GeoLocationManagerState> f30530m;

    /* renamed from: n  reason: collision with root package name */
    private final LiveData<GeoLocationManagerState> f30531n;

    /* renamed from: o  reason: collision with root package name */
    private final MutableLiveData<String> f30532o;

    /* renamed from: p  reason: collision with root package name */
    private final MutableLiveData<String> f30533p;

    /* renamed from: q  reason: collision with root package name */
    private final MediatorLiveData<Boolean> f30534q;

    /* renamed from: r  reason: collision with root package name */
    private final LiveData<Boolean> f30535r;

    /* renamed from: s  reason: collision with root package name */
    private final MutableLiveData<PermissionManager.PermissionInfo> f30536s;

    /* renamed from: t  reason: collision with root package name */
    private final LiveData<PermissionManager.PermissionInfo> f30537t;

    /* renamed from: u  reason: collision with root package name */
    private final MutableLiveData<AppVersionState> f30538u;

    /* renamed from: v  reason: collision with root package name */
    private final LiveData<AppVersionState> f30539v;

    /* renamed from: w  reason: collision with root package name */
    private final MutableLiveData<AuthStepResult> f30540w;

    /* renamed from: x  reason: collision with root package name */
    private Disposable f30541x;

    /* renamed from: y  reason: collision with root package name */
    private Disposable f30542y;

    /* compiled from: PasswordLoginViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30543a;

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
            f30543a = iArr;
        }
    }

    @Inject
    public PasswordLoginViewModel(PasswordAuthFlow twoFactorAuth, UrlFactory urlFactory, SystemUrlLauncher urlLauncher, LoginAnalytics loginAnalytics, AuthManager authManager, GeoLocationManager geoLocationManager, DeviceSettings deviceSettings) {
        Intrinsics.f(twoFactorAuth, "twoFactorAuth");
        Intrinsics.f(urlFactory, "urlFactory");
        Intrinsics.f(urlLauncher, "urlLauncher");
        Intrinsics.f(loginAnalytics, "loginAnalytics");
        Intrinsics.f(authManager, "authManager");
        Intrinsics.f(geoLocationManager, "geoLocationManager");
        Intrinsics.f(deviceSettings, "deviceSettings");
        this.f30523f = twoFactorAuth;
        this.f30524g = urlFactory;
        this.f30525h = urlLauncher;
        this.f30526i = loginAnalytics;
        this.f30527j = authManager;
        this.f30528k = geoLocationManager;
        String a8 = deviceSettings.i().a();
        this.f30529l = a8 == null ? "" : a8;
        MutableLiveData<GeoLocationManagerState> mutableLiveData = new MutableLiveData<>();
        this.f30530m = mutableLiveData;
        this.f30531n = mutableLiveData;
        this.f30532o = new MutableLiveData<>("");
        this.f30533p = new MutableLiveData<>("");
        MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        this.f30534q = mediatorLiveData;
        this.f30535r = mediatorLiveData;
        MutableLiveData<PermissionManager.PermissionInfo> mutableLiveData2 = new MutableLiveData<>();
        this.f30536s = mutableLiveData2;
        this.f30537t = mutableLiveData2;
        MutableLiveData<AppVersionState> mutableLiveData3 = new MutableLiveData<>();
        this.f30538u = mutableLiveData3;
        this.f30539v = mutableLiveData3;
        this.f30540w = new MutableLiveData<>();
    }

    private final void L(AppVersionState appVersionState) {
        if (appVersionState != AppVersionState.OK) {
            this.f30538u.o(appVersionState);
        }
    }

    private final void M(PermissionManager.PermissionInfo permissionInfo) {
        PermissionManager.DenyInitiator a8;
        if (permissionInfo != null && (a8 = permissionInfo.a()) != null) {
            int i8 = WhenMappings.f30543a[a8.ordinal()];
            if (i8 != 1) {
                if (i8 == 2) {
                    this.f30536s.o(permissionInfo);
                    return;
                }
                return;
            }
            this.f30523f.A();
        }
    }

    private final void U(AuthStepResult.Error error) {
        Throwable a8 = error.a();
        Kalev.d("Authentication failed: " + a8);
        this.f30526i.y1();
        BaseViewModel.A(this, error.a(), null, 2, null);
        y().o(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(AuthStepResult authStepResult) {
        boolean z7;
        Kalev.b("Auth event " + authStepResult);
        if (authStepResult instanceof AuthStepResult.LoginStarted) {
            y().o(Boolean.TRUE);
            this.f30526i.T3();
        } else if (authStepResult instanceof AuthStepResult.AuthenticationResult) {
            AuthResult a8 = ((AuthStepResult.AuthenticationResult) authStepResult).a();
            if (a8 instanceof AuthResult.Verification) {
                z7 = true;
            } else {
                z7 = a8 instanceof AuthResult.VerificationCanceled;
            }
            if (z7) {
                y().o(Boolean.FALSE);
            }
        } else if (authStepResult instanceof AuthStepResult.AuthenticationFinished) {
            this.f30526i.s2();
            AuthStepResult.AuthenticationFinished authenticationFinished = (AuthStepResult.AuthenticationFinished) authStepResult;
            this.f30527j.w(authenticationFinished.b(), authenticationFinished.a());
            Disposable disposable = this.f30542y;
            if (disposable != null) {
                disposable.dispose();
            }
            Observable<GeoLocationManagerState> v7 = this.f30528k.v();
            final Function1<GeoLocationManagerState, Unit> function1 = new Function1<GeoLocationManagerState, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginViewModel$handleAuthEvent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(GeoLocationManagerState geoLocationManagerState) {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = PasswordLoginViewModel.this.f30530m;
                    mutableLiveData.m(geoLocationManagerState);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GeoLocationManagerState geoLocationManagerState) {
                    b(geoLocationManagerState);
                    return Unit.f50853a;
                }
            };
            this.f30542y = v7.subscribe(new Consumer() { // from class: h4.m
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    PasswordLoginViewModel.W(Function1.this, obj);
                }
            });
        } else if (authStepResult instanceof AuthStepResult.Error) {
            U((AuthStepResult.Error) authStepResult);
        } else if (authStepResult instanceof AuthStepResult.AppVersionCheck) {
            L(((AuthStepResult.AppVersionCheck) authStepResult).a());
        } else if (authStepResult instanceof AuthStepResult.LocationPermission) {
            M(((AuthStepResult.LocationPermission) authStepResult).a());
        }
        this.f30540w.o(authStepResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        boolean z7;
        boolean z8;
        MediatorLiveData<Boolean> mediatorLiveData = this.f30534q;
        String f8 = this.f30532o.f();
        boolean z9 = false;
        if (f8 != null && f8.length() != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (!z7) {
            String f9 = this.f30533p.f();
            if (f9 != null && f9.length() != 0) {
                z8 = false;
            } else {
                z8 = true;
            }
            if (!z8) {
                z9 = true;
            }
        }
        mediatorLiveData.o(Boolean.valueOf(z9));
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f30526i.C();
        Observable<AuthStepResult> k8 = this.f30523f.k();
        final Function1<AuthStepResult, Unit> function1 = new Function1<AuthStepResult, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(AuthStepResult it) {
                PasswordLoginViewModel passwordLoginViewModel = PasswordLoginViewModel.this;
                Intrinsics.e(it, "it");
                passwordLoginViewModel.V(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthStepResult authStepResult) {
                b(authStepResult);
                return Unit.f50853a;
            }
        };
        Consumer<? super AuthStepResult> consumer = new Consumer() { // from class: h4.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PasswordLoginViewModel.Z(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginViewModel$onStart$2
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
                PasswordLoginViewModel passwordLoginViewModel = PasswordLoginViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(passwordLoginViewModel, it, null, 2, null);
            }
        };
        this.f30541x = k8.subscribe(consumer, new Consumer() { // from class: h4.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PasswordLoginViewModel.a0(Function1.this, obj);
            }
        });
        MediatorLiveData<Boolean> mediatorLiveData = this.f30534q;
        MutableLiveData<String> mutableLiveData = this.f30532o;
        final Function1<String, Unit> function13 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginViewModel$onStart$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                PasswordLoginViewModel.this.f0();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        mediatorLiveData.p(mutableLiveData, new Observer() { // from class: h4.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PasswordLoginViewModel.b0(Function1.this, obj);
            }
        });
        MediatorLiveData<Boolean> mediatorLiveData2 = this.f30534q;
        MutableLiveData<String> mutableLiveData2 = this.f30533p;
        final Function1<String, Unit> function14 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginViewModel$onStart$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                PasswordLoginViewModel.this.f0();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        mediatorLiveData2.p(mutableLiveData2, new Observer() { // from class: h4.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PasswordLoginViewModel.c0(Function1.this, obj);
            }
        });
    }

    public final LiveData<AppVersionState> N() {
        return this.f30539v;
    }

    public final String O() {
        return this.f30529l;
    }

    public final LiveData<PermissionManager.PermissionInfo> P() {
        return this.f30537t;
    }

    public final LiveData<GeoLocationManagerState> Q() {
        return this.f30531n;
    }

    public final MutableLiveData<String> R() {
        return this.f30532o;
    }

    public final MutableLiveData<String> S() {
        return this.f30533p;
    }

    public final LiveData<Boolean> T() {
        return this.f30535r;
    }

    public final void X() {
        this.f30526i.F1();
        PasswordAuthFlow passwordAuthFlow = this.f30523f;
        Object b8 = LiveDataExtKt.b(this.f30532o);
        Intrinsics.e(b8, "login.requireValue()");
        Object b9 = LiveDataExtKt.b(this.f30533p);
        Intrinsics.e(b9, "password.requireValue()");
        passwordAuthFlow.r((String) b8, (String) b9);
    }

    public final LiveData<AuthStepResult> Y() {
        return this.f30540w;
    }

    public final void d0() {
        this.f30526i.z1();
        this.f30525h.a(this.f30524g.k());
    }

    public final void e0() {
        this.f30523f.B();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f30541x;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.f30542y;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }
}
