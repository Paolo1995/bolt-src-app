package ee.mtakso.driver.ui.screens.login.v3.verification;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.network.client.auth.anonymous.AuthResult;
import ee.mtakso.driver.network.client.auth.anonymous.VerificationChannel;
import ee.mtakso.driver.network.client.auth.anonymous.VerificationCode;
import ee.mtakso.driver.platform.autofill.ConfirmationCodeRetriever;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.auth.AppVersionState;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.auth.flow.OTPAuthFlow;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.service.geo.GeoService;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.login.common.VerificationConfig;
import ee.mtakso.driver.ui.screens.login.v3.emailverification.EmailVerificationConfig;
import ee.mtakso.driver.ui.screens.login.v3.emailverification.EmailVerificationFragment;
import ee.mtakso.driver.ui.screens.signup.SignUpActivity;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.time.SystemUptimeSource;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerificationV3ViewModel.kt */
/* loaded from: classes3.dex */
public final class VerificationV3ViewModel extends BaseViewModel {
    private final MutableLiveData<AppVersionState> A;
    private final LiveData<AppVersionState> B;
    private final MutableLiveData<GeoLocationManagerState> C;
    private final LiveData<GeoLocationManagerState> D;
    private String E;
    private String F;
    private boolean G;
    private boolean H;

    /* renamed from: f  reason: collision with root package name */
    private final OTPAuthFlow f30801f;

    /* renamed from: g  reason: collision with root package name */
    private final SystemUptimeSource f30802g;

    /* renamed from: h  reason: collision with root package name */
    private final AnonymousAuthClient f30803h;

    /* renamed from: i  reason: collision with root package name */
    private final LoginAnalytics f30804i;

    /* renamed from: j  reason: collision with root package name */
    private final AuthManager f30805j;

    /* renamed from: k  reason: collision with root package name */
    private final GeoLocationManager f30806k;

    /* renamed from: l  reason: collision with root package name */
    private final RoutingManager f30807l;

    /* renamed from: m  reason: collision with root package name */
    private final ConfirmationCodeRetriever f30808m;

    /* renamed from: n  reason: collision with root package name */
    private final GeoService f30809n;

    /* renamed from: o  reason: collision with root package name */
    private Disposable f30810o;

    /* renamed from: p  reason: collision with root package name */
    private Disposable f30811p;

    /* renamed from: q  reason: collision with root package name */
    private final MutableLiveData<CoolDownData> f30812q;

    /* renamed from: r  reason: collision with root package name */
    private Disposable f30813r;

    /* renamed from: s  reason: collision with root package name */
    private final MutableLiveData<VerificationConfig> f30814s;

    /* renamed from: t  reason: collision with root package name */
    private final LiveEvent<VerificationChannel> f30815t;

    /* renamed from: u  reason: collision with root package name */
    private final LiveEvent<String> f30816u;

    /* renamed from: v  reason: collision with root package name */
    private final LiveEvent<Object> f30817v;

    /* renamed from: w  reason: collision with root package name */
    private final LiveEvent<Object> f30818w;

    /* renamed from: x  reason: collision with root package name */
    private final MutableLiveData<PermissionManager.PermissionInfo> f30819x;

    /* renamed from: y  reason: collision with root package name */
    private final LiveData<PermissionManager.PermissionInfo> f30820y;

    /* renamed from: z  reason: collision with root package name */
    private Disposable f30821z;

    /* compiled from: VerificationV3ViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30825a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f30826b;

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
            f30825a = iArr;
            int[] iArr2 = new int[GeoLocationManagerState.values().length];
            try {
                iArr2[GeoLocationManagerState.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[GeoLocationManagerState.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            f30826b = iArr2;
        }
    }

    @Inject
    public VerificationV3ViewModel(OTPAuthFlow flow, SystemUptimeSource timeSource, AnonymousAuthClient client, LoginAnalytics loginAnalytics, AuthManager authManager, GeoLocationManager geoLocationManager, RoutingManager routingManager, ConfirmationCodeRetriever confirmationCodeRetriever, GeoService geoService) {
        Intrinsics.f(flow, "flow");
        Intrinsics.f(timeSource, "timeSource");
        Intrinsics.f(client, "client");
        Intrinsics.f(loginAnalytics, "loginAnalytics");
        Intrinsics.f(authManager, "authManager");
        Intrinsics.f(geoLocationManager, "geoLocationManager");
        Intrinsics.f(routingManager, "routingManager");
        Intrinsics.f(confirmationCodeRetriever, "confirmationCodeRetriever");
        Intrinsics.f(geoService, "geoService");
        this.f30801f = flow;
        this.f30802g = timeSource;
        this.f30803h = client;
        this.f30804i = loginAnalytics;
        this.f30805j = authManager;
        this.f30806k = geoLocationManager;
        this.f30807l = routingManager;
        this.f30808m = confirmationCodeRetriever;
        this.f30809n = geoService;
        this.f30812q = new MutableLiveData<>();
        this.f30814s = new MutableLiveData<>();
        this.f30815t = new LiveEvent<>();
        this.f30816u = new LiveEvent<>();
        this.f30817v = new LiveEvent<>();
        this.f30818w = new LiveEvent<>();
        MutableLiveData<PermissionManager.PermissionInfo> mutableLiveData = new MutableLiveData<>();
        this.f30819x = mutableLiveData;
        this.f30820y = mutableLiveData;
        MutableLiveData<AppVersionState> mutableLiveData2 = new MutableLiveData<>();
        this.A = mutableLiveData2;
        this.B = mutableLiveData2;
        MutableLiveData<GeoLocationManagerState> mutableLiveData3 = new MutableLiveData<>();
        this.C = mutableLiveData3;
        this.D = mutableLiveData3;
        this.E = "";
        this.F = "";
    }

    private final void A0() {
        int i8;
        GeoLocationManagerState f8 = this.C.f();
        if (f8 == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f30826b[f8.ordinal()];
        }
        if (i8 != -1 && i8 != 1 && i8 != 2) {
            this.f30809n.l();
            Observable e8 = this.f30806k.k().e(this.f30806k.v());
            final Function1<GeoLocationManagerState, Unit> function1 = new Function1<GeoLocationManagerState, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3ViewModel$restartGpsIfDisabled$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(GeoLocationManagerState geoLocationManagerState) {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = VerificationV3ViewModel.this.C;
                    mutableLiveData.m(geoLocationManagerState);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GeoLocationManagerState geoLocationManagerState) {
                    b(geoLocationManagerState);
                    return Unit.f50853a;
                }
            };
            Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.w
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    VerificationV3ViewModel.C0(Function1.this, obj);
                }
            };
            final VerificationV3ViewModel$restartGpsIfDisabled$2 verificationV3ViewModel$restartGpsIfDisabled$2 = new VerificationV3ViewModel$restartGpsIfDisabled$2(this);
            Disposable subscribe = e8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.x
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    VerificationV3ViewModel.B0(Function1.this, obj);
                }
            });
            Intrinsics.e(subscribe, "private fun restartGpsIf…        }\n        }\n    }");
            v(subscribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void G0(EmailVerificationConfig emailVerificationConfig) {
        this.f30817v.o(new Object());
        this.f30807l.b(EmailVerificationFragment.f30661o.a(emailVerificationConfig), true);
    }

    private final void I0() {
        this.f30807l.c(SignUpActivity.Companion.b(SignUpActivity.f33328v, false, 1, null));
    }

    public static /* synthetic */ void K0(VerificationV3ViewModel verificationV3ViewModel, Integer num, Boolean bool, Boolean bool2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            num = null;
        }
        if ((i8 & 2) != 0) {
            bool = null;
        }
        if ((i8 & 4) != 0) {
            bool2 = null;
        }
        verificationV3ViewModel.J0(num, bool, bool2);
    }

    private final void a0(AppVersionState appVersionState) {
        if (appVersionState != AppVersionState.OK) {
            this.A.o(appVersionState);
        }
    }

    private final void b0(PermissionManager.PermissionInfo permissionInfo) {
        PermissionManager.DenyInitiator a8;
        if (permissionInfo != null && (a8 = permissionInfo.a()) != null) {
            int i8 = WhenMappings.f30825a[a8.ordinal()];
            if (i8 != 1) {
                if (i8 == 2) {
                    this.f30819x.o(permissionInfo);
                    return;
                }
                return;
            }
            this.f30801f.A();
        }
    }

    private final void f0(AuthStepResult.Error error) {
        Throwable a8 = error.a();
        Kalev.d("Authentication failed: " + a8);
        y().o(Boolean.FALSE);
        if (ApiExceptionUtils.m(error.a(), 293)) {
            Boolean bool = Boolean.TRUE;
            K0(this, null, bool, bool, 1, null);
        }
        BaseViewModel.A(this, error.a(), null, 2, null);
    }

    private final void g0(AuthStepResult.AuthenticationResult authenticationResult) {
        AuthResult a8 = authenticationResult.a();
        if (a8 instanceof AuthResult.PartnerSuccess) {
            I0();
        } else if (a8 instanceof AuthResult.PartnerEmailVerification) {
            G0(new EmailVerificationConfig(((AuthResult.PartnerEmailVerification) authenticationResult.a()).c(), ((AuthResult.PartnerEmailVerification) authenticationResult.a()).a(), ((AuthResult.PartnerEmailVerification) authenticationResult.a()).b()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(AuthStepResult authStepResult) {
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "Auth event " + authStepResult, null, 2, null);
        }
        if (authStepResult instanceof AuthStepResult.LoginStarted) {
            y().o(Boolean.TRUE);
        } else if (authStepResult instanceof AuthStepResult.Error) {
            f0((AuthStepResult.Error) authStepResult);
        } else if (authStepResult instanceof AuthStepResult.AuthenticationFinished) {
            i0((AuthStepResult.AuthenticationFinished) authStepResult);
        } else if (authStepResult instanceof AuthStepResult.AppVersionCheck) {
            a0(((AuthStepResult.AppVersionCheck) authStepResult).a());
        } else if (authStepResult instanceof AuthStepResult.LocationPermission) {
            b0(((AuthStepResult.LocationPermission) authStepResult).a());
        } else if (authStepResult instanceof AuthStepResult.AuthenticationResult) {
            g0((AuthStepResult.AuthenticationResult) authStepResult);
        }
    }

    private final void i0(AuthStepResult.AuthenticationFinished authenticationFinished) {
        AuthManager.LoginOption.Phone phone = new AuthManager.LoginOption.Phone(this.E, this.F);
        this.f30804i.s2();
        this.f30805j.w(phone, authenticationFinished.a());
        Disposable disposable = this.f30821z;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<GeoLocationManagerState> v7 = this.f30806k.v();
        final Function1<GeoLocationManagerState, Unit> function1 = new Function1<GeoLocationManagerState, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3ViewModel$handleAuthFinished$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(GeoLocationManagerState geoLocationManagerState) {
                MutableLiveData mutableLiveData;
                mutableLiveData = VerificationV3ViewModel.this.C;
                mutableLiveData.m(geoLocationManagerState);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GeoLocationManagerState geoLocationManagerState) {
                b(geoLocationManagerState);
                return Unit.f50853a;
            }
        };
        this.f30821z = v7.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationV3ViewModel.j0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        Observable<AuthStepResult> k8 = this.f30801f.k();
        final Function1<AuthStepResult, Unit> function1 = new Function1<AuthStepResult, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3ViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(AuthStepResult it) {
                Kalev.b("event: " + it);
                VerificationV3ViewModel verificationV3ViewModel = VerificationV3ViewModel.this;
                Intrinsics.e(it, "it");
                verificationV3ViewModel.h0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthStepResult authStepResult) {
                b(authStepResult);
                return Unit.f50853a;
            }
        };
        Consumer<? super AuthStepResult> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.u
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationV3ViewModel.u0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3ViewModel$onStart$2
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
                VerificationV3ViewModel verificationV3ViewModel = VerificationV3ViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(verificationV3ViewModel, it, null, 2, null);
            }
        };
        this.f30810o = k8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.v
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationV3ViewModel.v0(Function1.this, obj);
            }
        });
    }

    public final void D0(final long j8, final int i8) {
        if (!DisposableExtKt.b(this.f30813r)) {
            Kalev.l("Cool down already counting");
            return;
        }
        Observable<Long> observeOn = Observable.interval(1L, 1L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.a());
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3ViewModel$setupCoolDown$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Long l8) {
                SystemUptimeSource systemUptimeSource;
                Disposable disposable;
                systemUptimeSource = VerificationV3ViewModel.this.f30802g;
                int b8 = i8 - ((int) (systemUptimeSource.b() - j8));
                VerificationV3ViewModel.K0(VerificationV3ViewModel.this, Integer.valueOf(b8), null, null, 6, null);
                if (b8 < 0) {
                    VerificationV3ViewModel.this.G = true;
                    VerificationV3ViewModel verificationV3ViewModel = VerificationV3ViewModel.this;
                    Boolean bool = Boolean.TRUE;
                    VerificationV3ViewModel.K0(verificationV3ViewModel, null, bool, bool, 1, null);
                    disposable = VerificationV3ViewModel.this.f30813r;
                    if (disposable != null) {
                        DisposableExtKt.a(disposable);
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                b(l8);
                return Unit.f50853a;
            }
        };
        Consumer<? super Long> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationV3ViewModel.E0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3ViewModel$setupCoolDown$2
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
                VerificationV3ViewModel.this.G = true;
                VerificationV3ViewModel verificationV3ViewModel = VerificationV3ViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(verificationV3ViewModel, it, null, 2, null);
            }
        };
        this.f30813r = observeOn.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationV3ViewModel.F0(Function1.this, obj);
            }
        });
    }

    public final void H0() {
        this.f30801f.B();
    }

    public final void J0(Integer num, Boolean bool, Boolean bool2) {
        int d8;
        boolean b8;
        boolean c8;
        CoolDownData f8 = this.f30812q.f();
        if (f8 == null) {
            f8 = new CoolDownData(0, false, false, 7, null);
        }
        MutableLiveData<CoolDownData> mutableLiveData = this.f30812q;
        if (num != null) {
            d8 = num.intValue();
        } else {
            d8 = f8.d();
        }
        if (bool != null) {
            b8 = bool.booleanValue();
        } else {
            b8 = f8.b();
        }
        if (bool2 != null) {
            c8 = bool2.booleanValue();
        } else {
            c8 = f8.c();
        }
        mutableLiveData.o(f8.a(d8, b8, c8));
    }

    public final void X() {
        this.f30801f.t();
    }

    public final void Y(String code, String token) {
        Intrinsics.f(code, "code");
        Intrinsics.f(token, "token");
        this.f30801f.r(token, code, new AuthManager.LoginOption.Phone(this.E, this.F));
    }

    public final void Z() {
        Boolean bool = Boolean.TRUE;
        K0(this, null, bool, bool, 1, null);
    }

    public final LiveData<AppVersionState> c0() {
        return this.B;
    }

    public final LiveData<PermissionManager.PermissionInfo> d0() {
        return this.f30820y;
    }

    public final LiveData<GeoLocationManagerState> e0() {
        return this.D;
    }

    public final void k0(VerificationConfig verificationConfig, String phonePrefix, String phone) {
        int i8;
        Intrinsics.f(phonePrefix, "phonePrefix");
        Intrinsics.f(phone, "phone");
        this.f30814s.o(verificationConfig);
        this.E = phonePrefix;
        this.F = phone;
        ConfirmationCodeRetriever confirmationCodeRetriever = this.f30808m;
        if (verificationConfig != null) {
            i8 = verificationConfig.d();
        } else {
            i8 = 0;
        }
        Single<String> f8 = confirmationCodeRetriever.f(i8);
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3ViewModel$initAuthData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                LiveEvent liveEvent;
                liveEvent = VerificationV3ViewModel.this.f30816u;
                liveEvent.o(str);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        Consumer<? super String> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationV3ViewModel.l0(Function1.this, obj);
            }
        };
        final VerificationV3ViewModel$initAuthData$2 verificationV3ViewModel$initAuthData$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3ViewModel$initAuthData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to retrieve confirmation code");
            }
        };
        Disposable I = f8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.r
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationV3ViewModel.m0(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "fun initAuthData(data: V…     .autoDispose()\n    }");
        v(I);
    }

    public final LiveData<VerificationConfig> n0() {
        return this.f30814s;
    }

    public final LiveEvent<Object> o0() {
        return this.f30817v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f30810o;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f30821z;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }

    public final LiveEvent<String> p0() {
        return this.f30816u;
    }

    public final LiveData<CoolDownData> q0() {
        return this.f30812q;
    }

    public final LiveData<VerificationChannel> r0() {
        return this.f30815t;
    }

    public final LiveEvent<Object> s0() {
        return this.f30818w;
    }

    public final void t0() {
        this.H = true;
    }

    public final void w0() {
        if (this.H) {
            this.f30801f.z();
        }
        this.H = false;
        A0();
    }

    public final void x0(final VerificationChannel channel) {
        boolean z7;
        Intrinsics.f(channel, "channel");
        Disposable disposable = this.f30811p;
        if (disposable != null && !disposable.isDisposed()) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7 || !this.G) {
            return;
        }
        this.G = false;
        Single d8 = SingleExtKt.d(this.f30803h.I(this.E, this.F, ((VerificationConfig) LiveDataExtKt.b(this.f30814s)).h(), channel));
        final Function1<VerificationCode, Unit> function1 = new Function1<VerificationCode, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3ViewModel$requestNewCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(VerificationCode verificationCode) {
                LiveEvent liveEvent;
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                VerificationConfig a8;
                LiveEvent liveEvent2;
                SystemUptimeSource systemUptimeSource;
                liveEvent = VerificationV3ViewModel.this.f30815t;
                liveEvent.o(channel);
                mutableLiveData = VerificationV3ViewModel.this.f30814s;
                VerificationConfig old = (VerificationConfig) LiveDataExtKt.b(mutableLiveData);
                mutableLiveData2 = VerificationV3ViewModel.this.f30814s;
                Intrinsics.e(old, "old");
                String d9 = verificationCode.d();
                VerificationChannel e8 = verificationCode.e();
                String f8 = verificationCode.f();
                List<VerificationChannel> a9 = verificationCode.a();
                if (a9 == null) {
                    a9 = old.c();
                }
                a8 = old.a((r18 & 1) != 0 ? old.f30439f : d9, (r18 & 2) != 0 ? old.f30440g : e8, (r18 & 4) != 0 ? old.f30441h : f8, (r18 & 8) != 0 ? old.f30442i : 0, (r18 & 16) != 0 ? old.f30443j : 0, (r18 & 32) != 0 ? old.f30444k : a9, (r18 & 64) != 0 ? old.f30445l : 0L);
                mutableLiveData2.o(a8);
                liveEvent2 = VerificationV3ViewModel.this.f30818w;
                liveEvent2.o(new Object());
                VerificationV3ViewModel verificationV3ViewModel = VerificationV3ViewModel.this;
                systemUptimeSource = verificationV3ViewModel.f30802g;
                verificationV3ViewModel.D0(systemUptimeSource.b(), old.e());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VerificationCode verificationCode) {
                b(verificationCode);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationV3ViewModel.y0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3ViewModel$requestNewCode$2
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
                VerificationV3ViewModel.this.G = true;
                VerificationV3ViewModel verificationV3ViewModel = VerificationV3ViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(verificationV3ViewModel, it, null, 2, null);
            }
        };
        this.f30811p = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.t
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationV3ViewModel.z0(Function1.this, obj);
            }
        });
    }

    /* compiled from: VerificationV3ViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class CoolDownData {

        /* renamed from: a  reason: collision with root package name */
        private final int f30822a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f30823b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f30824c;

        public CoolDownData() {
            this(0, false, false, 7, null);
        }

        public CoolDownData(int i8, boolean z7, boolean z8) {
            this.f30822a = i8;
            this.f30823b = z7;
            this.f30824c = z8;
        }

        public final CoolDownData a(int i8, boolean z7, boolean z8) {
            return new CoolDownData(i8, z7, z8);
        }

        public final boolean b() {
            return this.f30823b;
        }

        public final boolean c() {
            return this.f30824c;
        }

        public final int d() {
            return this.f30822a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CoolDownData) {
                CoolDownData coolDownData = (CoolDownData) obj;
                return this.f30822a == coolDownData.f30822a && this.f30823b == coolDownData.f30823b && this.f30824c == coolDownData.f30824c;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i8 = this.f30822a * 31;
            boolean z7 = this.f30823b;
            int i9 = z7;
            if (z7 != 0) {
                i9 = 1;
            }
            int i10 = (i8 + i9) * 31;
            boolean z8 = this.f30824c;
            return i10 + (z8 ? 1 : z8 ? 1 : 0);
        }

        public String toString() {
            int i8 = this.f30822a;
            boolean z7 = this.f30823b;
            boolean z8 = this.f30824c;
            return "CoolDownData(timer=" + i8 + ", infoBlockVisible=" + z7 + ", resendCodeVisible=" + z8 + ")";
        }

        public /* synthetic */ CoolDownData(int i8, boolean z7, boolean z8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this((i9 & 1) != 0 ? 0 : i8, (i9 & 2) != 0 ? false : z7, (i9 & 4) != 0 ? false : z8);
        }
    }
}
