package ee.mtakso.driver.ui.screens.login.v3.password;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import ee.mtakso.driver.network.client.auth.anonymous.AuthResult;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.auth.AppVersionState;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.auth.flow.PasswordAuthFlow;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3ViewModel;
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

/* compiled from: PasswordLoginV3ViewModel.kt */
/* loaded from: classes3.dex */
public final class PasswordLoginV3ViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final PasswordAuthFlow f30752f;

    /* renamed from: g  reason: collision with root package name */
    private final UrlFactory f30753g;

    /* renamed from: h  reason: collision with root package name */
    private final SystemUrlLauncher f30754h;

    /* renamed from: i  reason: collision with root package name */
    private final LoginAnalytics f30755i;

    /* renamed from: j  reason: collision with root package name */
    private final AuthManager f30756j;

    /* renamed from: k  reason: collision with root package name */
    private final GeoLocationManager f30757k;

    /* renamed from: l  reason: collision with root package name */
    private final MutableLiveData<GeoLocationManagerState> f30758l;

    /* renamed from: m  reason: collision with root package name */
    private final LiveData<GeoLocationManagerState> f30759m;

    /* renamed from: n  reason: collision with root package name */
    private final MutableLiveData<String> f30760n;

    /* renamed from: o  reason: collision with root package name */
    private final MutableLiveData<String> f30761o;

    /* renamed from: p  reason: collision with root package name */
    private final MediatorLiveData<Boolean> f30762p;

    /* renamed from: q  reason: collision with root package name */
    private final LiveData<Boolean> f30763q;

    /* renamed from: r  reason: collision with root package name */
    private final LiveEvent<PermissionManager.PermissionInfo> f30764r;

    /* renamed from: s  reason: collision with root package name */
    private final LiveEvent<PermissionManager.PermissionInfo> f30765s;

    /* renamed from: t  reason: collision with root package name */
    private final MutableLiveData<AppVersionState> f30766t;

    /* renamed from: u  reason: collision with root package name */
    private final LiveData<AppVersionState> f30767u;

    /* renamed from: v  reason: collision with root package name */
    private final MutableLiveData<AuthStepResult> f30768v;

    /* renamed from: w  reason: collision with root package name */
    private Disposable f30769w;

    /* renamed from: x  reason: collision with root package name */
    private Disposable f30770x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f30771y;

    /* compiled from: PasswordLoginV3ViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30772a;

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
            f30772a = iArr;
        }
    }

    @Inject
    public PasswordLoginV3ViewModel(PasswordAuthFlow twoFactorAuth, UrlFactory urlFactory, SystemUrlLauncher urlLauncher, LoginAnalytics loginAnalytics, AuthManager authManager, GeoLocationManager geoLocationManager) {
        Intrinsics.f(twoFactorAuth, "twoFactorAuth");
        Intrinsics.f(urlFactory, "urlFactory");
        Intrinsics.f(urlLauncher, "urlLauncher");
        Intrinsics.f(loginAnalytics, "loginAnalytics");
        Intrinsics.f(authManager, "authManager");
        Intrinsics.f(geoLocationManager, "geoLocationManager");
        this.f30752f = twoFactorAuth;
        this.f30753g = urlFactory;
        this.f30754h = urlLauncher;
        this.f30755i = loginAnalytics;
        this.f30756j = authManager;
        this.f30757k = geoLocationManager;
        MutableLiveData<GeoLocationManagerState> mutableLiveData = new MutableLiveData<>();
        this.f30758l = mutableLiveData;
        this.f30759m = mutableLiveData;
        this.f30760n = new MutableLiveData<>("");
        this.f30761o = new MutableLiveData<>("");
        MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        this.f30762p = mediatorLiveData;
        this.f30763q = mediatorLiveData;
        LiveEvent<PermissionManager.PermissionInfo> liveEvent = new LiveEvent<>();
        this.f30764r = liveEvent;
        this.f30765s = liveEvent;
        MutableLiveData<AppVersionState> mutableLiveData2 = new MutableLiveData<>();
        this.f30766t = mutableLiveData2;
        this.f30767u = mutableLiveData2;
        this.f30768v = new MutableLiveData<>();
    }

    private final void M(AppVersionState appVersionState) {
        if (appVersionState != AppVersionState.OK) {
            this.f30766t.o(appVersionState);
        }
    }

    private final void N(PermissionManager.PermissionInfo permissionInfo) {
        PermissionManager.DenyInitiator a8;
        if (permissionInfo != null && (a8 = permissionInfo.a()) != null) {
            int i8 = WhenMappings.f30772a[a8.ordinal()];
            if (i8 != 1) {
                if (i8 == 2) {
                    this.f30764r.o(permissionInfo);
                    return;
                }
                return;
            }
            this.f30752f.A();
        }
    }

    private final void U(AuthStepResult.Error error) {
        Throwable a8 = error.a();
        Kalev.d("Authentication failed: " + a8);
        this.f30755i.y1();
        BaseViewModel.A(this, error.a(), null, 2, null);
        y().o(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(AuthStepResult authStepResult) {
        boolean z7;
        Kalev.b("Auth event " + authStepResult);
        if (authStepResult instanceof AuthStepResult.LoginStarted) {
            y().o(Boolean.TRUE);
            this.f30755i.T3();
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
            new AuthManager.LoginOption.Username((String) LiveDataExtKt.b(this.f30760n));
            this.f30755i.s2();
            AuthStepResult.AuthenticationFinished authenticationFinished = (AuthStepResult.AuthenticationFinished) authStepResult;
            this.f30756j.w(authenticationFinished.b(), authenticationFinished.a());
            Disposable disposable = this.f30770x;
            if (disposable != null) {
                disposable.dispose();
            }
            Observable<GeoLocationManagerState> v7 = this.f30757k.v();
            final Function1<GeoLocationManagerState, Unit> function1 = new Function1<GeoLocationManagerState, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3ViewModel$handleAuthEvent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(GeoLocationManagerState geoLocationManagerState) {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = PasswordLoginV3ViewModel.this.f30758l;
                    mutableLiveData.m(geoLocationManagerState);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GeoLocationManagerState geoLocationManagerState) {
                    b(geoLocationManagerState);
                    return Unit.f50853a;
                }
            };
            this.f30770x = v7.subscribe(new Consumer() { // from class: l4.n
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    PasswordLoginV3ViewModel.W(Function1.this, obj);
                }
            });
        } else if (authStepResult instanceof AuthStepResult.Error) {
            U((AuthStepResult.Error) authStepResult);
        } else if (authStepResult instanceof AuthStepResult.AppVersionCheck) {
            M(((AuthStepResult.AppVersionCheck) authStepResult).a());
        } else if (authStepResult instanceof AuthStepResult.LocationPermission) {
            N(((AuthStepResult.LocationPermission) authStepResult).a());
        }
        this.f30768v.o(authStepResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function1 tmp0, Object obj) {
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
    public static final void d0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        boolean z7;
        boolean z8;
        MediatorLiveData<Boolean> mediatorLiveData = this.f30762p;
        String f8 = this.f30760n.f();
        boolean z9 = false;
        if (f8 != null && f8.length() != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (!z7) {
            String f9 = this.f30761o.f();
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
        this.f30755i.C();
        Observable<AuthStepResult> k8 = this.f30752f.k();
        final Function1<AuthStepResult, Unit> function1 = new Function1<AuthStepResult, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3ViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(AuthStepResult it) {
                PasswordLoginV3ViewModel passwordLoginV3ViewModel = PasswordLoginV3ViewModel.this;
                Intrinsics.e(it, "it");
                passwordLoginV3ViewModel.V(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthStepResult authStepResult) {
                b(authStepResult);
                return Unit.f50853a;
            }
        };
        Consumer<? super AuthStepResult> consumer = new Consumer() { // from class: l4.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PasswordLoginV3ViewModel.a0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3ViewModel$onStart$2
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
                PasswordLoginV3ViewModel passwordLoginV3ViewModel = PasswordLoginV3ViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(passwordLoginV3ViewModel, it, null, 2, null);
            }
        };
        this.f30769w = k8.subscribe(consumer, new Consumer() { // from class: l4.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PasswordLoginV3ViewModel.b0(Function1.this, obj);
            }
        });
        MediatorLiveData<Boolean> mediatorLiveData = this.f30762p;
        MutableLiveData<String> mutableLiveData = this.f30760n;
        final Function1<String, Unit> function13 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3ViewModel$onStart$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                PasswordLoginV3ViewModel.this.h0();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        mediatorLiveData.p(mutableLiveData, new Observer() { // from class: l4.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PasswordLoginV3ViewModel.c0(Function1.this, obj);
            }
        });
        MediatorLiveData<Boolean> mediatorLiveData2 = this.f30762p;
        MutableLiveData<String> mutableLiveData2 = this.f30761o;
        final Function1<String, Unit> function14 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3ViewModel$onStart$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                PasswordLoginV3ViewModel.this.h0();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        mediatorLiveData2.p(mutableLiveData2, new Observer() { // from class: l4.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PasswordLoginV3ViewModel.d0(Function1.this, obj);
            }
        });
    }

    public final void L() {
        this.f30752f.s();
    }

    public final LiveData<AppVersionState> O() {
        return this.f30767u;
    }

    public final LiveEvent<PermissionManager.PermissionInfo> P() {
        return this.f30765s;
    }

    public final LiveData<GeoLocationManagerState> Q() {
        return this.f30759m;
    }

    public final MutableLiveData<String> R() {
        return this.f30760n;
    }

    public final MutableLiveData<String> S() {
        return this.f30761o;
    }

    public final LiveData<Boolean> T() {
        return this.f30763q;
    }

    public final void X() {
        this.f30755i.F1();
        PasswordAuthFlow passwordAuthFlow = this.f30752f;
        Object b8 = LiveDataExtKt.b(this.f30760n);
        Intrinsics.e(b8, "login.requireValue()");
        Object b9 = LiveDataExtKt.b(this.f30761o);
        Intrinsics.e(b9, "password.requireValue()");
        passwordAuthFlow.r((String) b8, (String) b9);
    }

    public final LiveData<AuthStepResult> Y() {
        return this.f30768v;
    }

    public final void Z() {
        this.f30771y = true;
    }

    public final void e0() {
        if (this.f30771y) {
            this.f30752f.z();
        }
        this.f30771y = false;
    }

    public final void f0() {
        this.f30755i.z1();
        this.f30754h.a(this.f30753g.k());
    }

    public final void g0() {
        this.f30752f.B();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f30769w;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.f30770x;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }
}
