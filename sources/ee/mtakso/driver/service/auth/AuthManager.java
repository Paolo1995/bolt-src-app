package ee.mtakso.driver.service.auth;

import android.content.Context;
import ee.mtakso.App;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.di.authorised.AuthorisedComponent;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.identity.verification.IdentityVerificationManager;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthClient;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.targeting.TargetingParameters;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.LoginType;
import ee.mtakso.driver.service.routing.AppRoutingManager;
import ee.mtakso.driver.service.time.AnchoredTrueTimeProvider;
import eu.bolt.driver.core.network.client.driver.DriverConfiguration;
import eu.bolt.driver.core.time.AnchoredTimeSource;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class AuthManager {

    /* renamed from: a  reason: collision with root package name */
    private final Context f23563a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverProvider f23564b;

    /* renamed from: c  reason: collision with root package name */
    private final Features f23565c;

    /* renamed from: d  reason: collision with root package name */
    private final DeviceSettings f23566d;

    /* renamed from: e  reason: collision with root package name */
    private final AnchoredTrueTimeProvider f23567e;

    /* renamed from: f  reason: collision with root package name */
    private final DriverClient f23568f;

    /* renamed from: g  reason: collision with root package name */
    private final LanguageManager f23569g;

    /* renamed from: h  reason: collision with root package name */
    private final IdentityVerificationManager f23570h;

    /* renamed from: i  reason: collision with root package name */
    private final AuthenticatedAuthClient f23571i;

    /* renamed from: j  reason: collision with root package name */
    private final LoginAnalytics f23572j;

    /* renamed from: k  reason: collision with root package name */
    private DriverConfiguration f23573k;

    /* renamed from: l  reason: collision with root package name */
    private AuthState f23574l;

    /* renamed from: m  reason: collision with root package name */
    private final PublishSubject<AuthState> f23575m;

    /* compiled from: AuthManager.kt */
    /* loaded from: classes3.dex */
    public static abstract class LoginOption {

        /* compiled from: AuthManager.kt */
        /* loaded from: classes3.dex */
        public static final class ByMagicLink extends LoginOption {

            /* renamed from: a  reason: collision with root package name */
            public static final ByMagicLink f23576a = new ByMagicLink();

            private ByMagicLink() {
                super(null);
            }
        }

        /* compiled from: AuthManager.kt */
        /* loaded from: classes3.dex */
        public static final class ByRefreshToken extends LoginOption {

            /* renamed from: a  reason: collision with root package name */
            public static final ByRefreshToken f23577a = new ByRefreshToken();

            private ByRefreshToken() {
                super(null);
            }
        }

        /* compiled from: AuthManager.kt */
        /* loaded from: classes3.dex */
        public static final class PartnerTokenConvert extends LoginOption {

            /* renamed from: a  reason: collision with root package name */
            public static final PartnerTokenConvert f23578a = new PartnerTokenConvert();

            private PartnerTokenConvert() {
                super(null);
            }
        }

        /* compiled from: AuthManager.kt */
        /* loaded from: classes3.dex */
        public static final class Phone extends LoginOption {

            /* renamed from: a  reason: collision with root package name */
            private final String f23579a;

            /* renamed from: b  reason: collision with root package name */
            private final String f23580b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Phone(String prefix, String phone) {
                super(null);
                Intrinsics.f(prefix, "prefix");
                Intrinsics.f(phone, "phone");
                this.f23579a = prefix;
                this.f23580b = phone;
            }

            public final String a() {
                return this.f23580b;
            }

            public final String b() {
                return this.f23579a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Phone) {
                    Phone phone = (Phone) obj;
                    return Intrinsics.a(this.f23579a, phone.f23579a) && Intrinsics.a(this.f23580b, phone.f23580b);
                }
                return false;
            }

            public int hashCode() {
                return (this.f23579a.hashCode() * 31) + this.f23580b.hashCode();
            }

            public String toString() {
                String str = this.f23579a;
                String str2 = this.f23580b;
                return "Phone(prefix=" + str + ", phone=" + str2 + ")";
            }
        }

        /* compiled from: AuthManager.kt */
        /* loaded from: classes3.dex */
        public static final class Username extends LoginOption {

            /* renamed from: a  reason: collision with root package name */
            private final String f23581a;

            public Username(String str) {
                super(null);
                this.f23581a = str;
            }

            public final String a() {
                return this.f23581a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Username) && Intrinsics.a(this.f23581a, ((Username) obj).f23581a);
            }

            public int hashCode() {
                String str = this.f23581a;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                String str = this.f23581a;
                return "Username(login=" + str + ")";
            }
        }

        private LoginOption() {
        }

        public /* synthetic */ LoginOption(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public AuthManager(Context context, DriverProvider driverProvider, Features features, DeviceSettings deviceSettings, AnchoredTrueTimeProvider timeProvider, DriverClient driverClient, LanguageManager languageManager, IdentityVerificationManager identityVerificationManager, AuthenticatedAuthClient authenticatedAuthClient, LoginAnalytics loginAnalytics) {
        Intrinsics.f(context, "context");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(features, "features");
        Intrinsics.f(deviceSettings, "deviceSettings");
        Intrinsics.f(timeProvider, "timeProvider");
        Intrinsics.f(driverClient, "driverClient");
        Intrinsics.f(languageManager, "languageManager");
        Intrinsics.f(identityVerificationManager, "identityVerificationManager");
        Intrinsics.f(authenticatedAuthClient, "authenticatedAuthClient");
        Intrinsics.f(loginAnalytics, "loginAnalytics");
        this.f23563a = context;
        this.f23564b = driverProvider;
        this.f23565c = features;
        this.f23566d = deviceSettings;
        this.f23567e = timeProvider;
        this.f23568f = driverClient;
        this.f23569g = languageManager;
        this.f23570h = identityVerificationManager;
        this.f23571i = authenticatedAuthClient;
        this.f23572j = loginAnalytics;
        this.f23574l = AuthState.UNKNOWN;
        PublishSubject<AuthState> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<AuthState>()");
        this.f23575m = e8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(AuthState authState) {
        this.f23574l = authState;
        this.f23575m.onNext(authState);
    }

    private final void B() {
        Injector.f20166d.b().Y1().F().start();
    }

    private final void C() {
        AuthorisedServicesRunner F;
        AuthorisedComponent Z1 = Injector.f20166d.b().Z1();
        if (Z1 != null && (F = Z1.F()) != null) {
            F.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(AuthManager this$0) {
        Intrinsics.f(this$0, "this$0");
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.c(g8, "Refresh token disposed.", null, 2, null);
        }
        this$0.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final LoginType s(LoginOption loginOption) {
        if (loginOption instanceof LoginOption.Username) {
            return LoginType.USERNAME;
        }
        if (loginOption instanceof LoginOption.Phone) {
            return LoginType.PHONE;
        }
        if (loginOption instanceof LoginOption.ByMagicLink) {
            return LoginType.MAGIC_LINK;
        }
        if (loginOption instanceof LoginOption.ByRefreshToken) {
            return LoginType.SAVED_CREDENTIALS;
        }
        if (loginOption instanceof LoginOption.PartnerTokenConvert) {
            return LoginType.PARTNER_UPGRADE;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x() {
        Kalev.d("Language synced");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void g() {
        j();
    }

    public final AuthState h() {
        return this.f23574l;
    }

    public final DriverConfiguration i() {
        return this.f23573k;
    }

    public final void j() {
        AuthState authState = this.f23574l;
        if (authState != AuthState.UNKNOWN && authState != AuthState.LOGGED_OUT && authState != AuthState.PARTNER_LOGGED_IN) {
            AuthState authState2 = this.f23574l;
            throw new IllegalStateException("Anonymous zone can be initialised only from UNKNOWN or LOGGED_OUT state. Current state: " + authState2);
        }
        AuthState authState3 = AuthState.LOGGED_OUT;
        if (authState == authState3) {
            FastLog g8 = Kalev.f41674e.g();
            if (g8 != null) {
                FastLog.DefaultImpls.b(g8, "Anonymous mode enabled already", null, 2, null);
                return;
            }
            return;
        }
        Kalev kalev = Kalev.f41674e;
        FastLog g9 = kalev.g();
        if (g9 != null) {
            FastLog.DefaultImpls.c(g9, "-----Preparing anonymous mode-----", null, 2, null);
        }
        FastLog g10 = kalev.g();
        if (g10 != null) {
            FastLog.DefaultImpls.c(g10, "Building anon graph....", null, 2, null);
        }
        Injector.f20166d.b().a2();
        FastLog g11 = kalev.g();
        if (g11 != null) {
            FastLog.DefaultImpls.c(g11, "Anon graph is built.", null, 2, null);
        }
        A(authState3);
    }

    public final void k() {
        AuthState authState = this.f23574l;
        if (authState != AuthState.UNKNOWN && authState != AuthState.LOGGED_OUT && authState != AuthState.PARTNER_LOGGED_IN) {
            AuthState authState2 = this.f23574l;
            throw new IllegalStateException("Partner zone can be initialised only from UNKNOWN or LOGGED_OUT state. Current state: " + authState2);
        }
        AuthState authState3 = AuthState.PARTNER_LOGGED_IN;
        if (authState == authState3) {
            FastLog g8 = Kalev.f41674e.g();
            if (g8 != null) {
                FastLog.DefaultImpls.b(g8, "Partner mode enabled already", null, 2, null);
                return;
            }
            return;
        }
        Kalev kalev = Kalev.f41674e;
        FastLog g9 = kalev.g();
        if (g9 != null) {
            FastLog.DefaultImpls.c(g9, "-----Preparing anonymous mode (for partner)-----", null, 2, null);
        }
        FastLog g10 = kalev.g();
        if (g10 != null) {
            FastLog.DefaultImpls.c(g10, "Building anon graph....", null, 2, null);
        }
        Injector.f20166d.b().a2();
        FastLog g11 = kalev.g();
        if (g11 != null) {
            FastLog.DefaultImpls.c(g11, "Anon graph is built.", null, 2, null);
        }
        A(authState3);
        IdentityVerificationManager identityVerificationManager = this.f23570h;
        App app = App.getInstance();
        Intrinsics.e(app, "getInstance()");
        identityVerificationManager.c(app);
    }

    public final boolean l() {
        if (this.f23574l == AuthState.LOGGED_IN) {
            return true;
        }
        return false;
    }

    public final Completable m() {
        Completable z7 = this.f23571i.b().v().z(Schedulers.c());
        final AuthManager$logoutByButton$1 authManager$logoutByButton$1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.auth.AuthManager$logoutByButton$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to dispose refresh token");
            }
        };
        Completable n8 = z7.p(new Consumer() { // from class: ee.mtakso.driver.service.auth.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AuthManager.n(Function1.this, obj);
            }
        }).A().n(new Action() { // from class: ee.mtakso.driver.service.auth.e
            @Override // io.reactivex.functions.Action
            public final void run() {
                AuthManager.o(AuthManager.this);
            }
        });
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.service.auth.AuthManager$logoutByButton$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                FastLog g8 = Kalev.f41674e.g();
                if (g8 != null) {
                    FastLog.DefaultImpls.c(g8, "-----Logout due button tap detected-----", null, 2, null);
                }
                AuthManager.this.A(AuthState.PENDING);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Completable r7 = n8.r(new Consumer() { // from class: ee.mtakso.driver.service.auth.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AuthManager.p(Function1.this, obj);
            }
        });
        Intrinsics.e(r7, "fun logoutByButton(): Co…NDING\n            }\n    }");
        return r7;
    }

    public final void q() {
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.c(g8, "-----Logout due to driver block detected-----", null, 2, null);
        }
        A(AuthState.PENDING);
        z();
    }

    public final void r() {
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.c(g8, "-----Logout due to invalid refresh token detected-----", null, 2, null);
        }
        A(AuthState.PENDING);
        this.f23566d.k().b(true);
        z();
    }

    public final Observable<AuthState> t() {
        Observable<AuthState> startWith = this.f23575m.startWith((PublishSubject<AuthState>) this.f23574l);
        Intrinsics.e(startWith, "stateSubject.startWith(authState)");
        return startWith;
    }

    public final void u(DriverConfiguration config) {
        Intrinsics.f(config, "config");
        this.f23573k = config;
    }

    public final void v(LoginOption loginOption) {
        Intrinsics.f(loginOption, "loginOption");
        if (this.f23574l == AuthState.LOGGED_IN) {
            Kalev.e(new IllegalStateException("AuthManager: driver is already logged in"), "AuthManager: driver is already logged in");
            return;
        }
        DriverConfiguration driverConfiguration = this.f23573k;
        if (driverConfiguration != null) {
            w(loginOption, driverConfiguration);
            this.f23573k = null;
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void w(LoginOption loginOption, DriverConfiguration config) {
        boolean z7;
        Intrinsics.f(loginOption, "loginOption");
        Intrinsics.f(config, "config");
        Kalev kalev = Kalev.f41674e;
        FastLog g8 = kalev.g();
        if (g8 != null) {
            FastLog.DefaultImpls.c(g8, "-----Login detected-----", null, 2, null);
        }
        A(AuthState.PENDING);
        FastLog g9 = kalev.g();
        if (g9 != null) {
            FastLog.DefaultImpls.c(g9, "Saving to storage...", null, 2, null);
        }
        this.f23564b.j(config.d().i());
        this.f23564b.g().Q(config);
        this.f23564b.l(new TargetingParameters(config.c().j()));
        this.f23565c.d(new TargetingParameters(config.c().j()));
        if (loginOption instanceof LoginOption.Username) {
            this.f23566d.i().b(((LoginOption.Username) loginOption).a());
            this.f23566d.p("");
            this.f23566d.q("");
        } else if (loginOption instanceof LoginOption.Phone) {
            this.f23566d.i().b(null);
            LoginOption.Phone phone = (LoginOption.Phone) loginOption;
            this.f23566d.p(phone.a());
            this.f23566d.q(phone.b());
        }
        this.f23566d.h().c(config.d().i());
        this.f23566d.m().b(null);
        this.f23566d.s("");
        long j8 = config.a().j();
        if (j8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            this.f23567e.c(j8);
            String b8 = this.f23569g.f().b();
            if (Intrinsics.a(b8, config.d().f())) {
                Kalev.d("Language is up to date");
            } else {
                Completable v7 = this.f23568f.E(b8).v();
                Action action = new Action() { // from class: ee.mtakso.driver.service.auth.b
                    @Override // io.reactivex.functions.Action
                    public final void run() {
                        AuthManager.x();
                    }
                };
                final AuthManager$onLogin$3 authManager$onLogin$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.auth.AuthManager$onLogin$3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.f50853a;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it) {
                        Intrinsics.e(it, "it");
                        Kalev.e(it, "Failed to sync language");
                    }
                };
                v7.G(action, new Consumer() { // from class: ee.mtakso.driver.service.auth.c
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        AuthManager.y(Function1.this, obj);
                    }
                });
            }
            FastLog g10 = kalev.g();
            if (g10 != null) {
                FastLog.DefaultImpls.c(g10, "Building auth graph...", null, 2, null);
            }
            Injector.Companion companion = Injector.f20166d;
            companion.b().b2(this.f23564b.n(), this.f23564b.v(), this.f23564b.q(), new AnchoredTimeSource(config.a().j()));
            companion.b().c2();
            FastLog g11 = kalev.g();
            if (g11 != null) {
                FastLog.DefaultImpls.c(g11, "Auth graph is built. Services are raising...", null, 2, null);
            }
            B();
            FastLog g12 = kalev.g();
            if (g12 != null) {
                FastLog.DefaultImpls.c(g12, "Auth services are up.", null, 2, null);
            }
            FastLog g13 = kalev.g();
            if (g13 != null) {
                FastLog.DefaultImpls.c(g13, "-----Login finished-----", null, 2, null);
            }
            A(AuthState.LOGGED_IN);
            this.f23572j.Z0(s(loginOption));
            IdentityVerificationManager identityVerificationManager = this.f23570h;
            App app = App.getInstance();
            Intrinsics.e(app, "getInstance()");
            identityVerificationManager.b(app);
            return;
        }
        throw new IllegalStateException("Driver settings from backend is missing utc_time".toString());
    }

    public final void z() {
        this.f23572j.p1();
        Kalev kalev = Kalev.f41674e;
        FastLog g8 = kalev.g();
        if (g8 != null) {
            FastLog.DefaultImpls.c(g8, "Local logout started...", null, 2, null);
        }
        FastLog g9 = kalev.g();
        if (g9 != null) {
            FastLog.DefaultImpls.c(g9, "Dropping services...", null, 2, null);
        }
        C();
        FastLog g10 = kalev.g();
        if (g10 != null) {
            FastLog.DefaultImpls.c(g10, "Services are down. Building anon graph....", null, 2, null);
        }
        Injector.Companion companion = Injector.f20166d;
        companion.b().a2();
        companion.b().d2();
        FastLog g11 = kalev.g();
        if (g11 != null) {
            FastLog.DefaultImpls.c(g11, "Anon graph is built.", null, 2, null);
        }
        FastLog g12 = kalev.g();
        if (g12 != null) {
            FastLog.DefaultImpls.c(g12, "Closing storage...", null, 2, null);
        }
        this.f23564b.k();
        this.f23566d.n();
        FastLog g13 = kalev.g();
        if (g13 != null) {
            FastLog.DefaultImpls.c(g13, "-----Logout finished. Restarting APP-----", null, 2, null);
        }
        A(AuthState.LOGGED_OUT);
        AppRoutingManager.f25869b.c(this.f23563a);
    }
}
