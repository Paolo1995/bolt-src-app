package ee.mtakso.driver.service.auth;

import android.content.Intent;
import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.platform.check.PlatformAvailabilityManager;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.utils.flow.Flow;
import ee.mtakso.driver.utils.flow.FlowStep;
import eu.bolt.driver.core.network.client.driver.DriverConfiguration;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullAuthFlow.kt */
/* loaded from: classes3.dex */
public final class FullAuthFlow extends Flow<AuthStepResult> {

    /* renamed from: d  reason: collision with root package name */
    private final DeepLinkManager f23708d;

    /* renamed from: e  reason: collision with root package name */
    private final AuthStepFactory f23709e;

    /* renamed from: f  reason: collision with root package name */
    private final AuthManager f23710f;

    /* renamed from: g  reason: collision with root package name */
    private final PlatformAvailabilityManager f23711g;

    /* renamed from: h  reason: collision with root package name */
    private final GeoLocationManager f23712h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f23713i;

    /* renamed from: j  reason: collision with root package name */
    private AuthStepResult f23714j;

    /* renamed from: k  reason: collision with root package name */
    private FlowState f23715k;

    /* compiled from: FullAuthFlow.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23716a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f23717b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f23718c;

        static {
            int[] iArr = new int[LoginWay.values().length];
            try {
                iArr[LoginWay.BY_MAGIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoginWay.BY_MAGIC_WITH_LOGOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoginWay.BY_PASSWORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LoginWay.BY_REFRESH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f23716a = iArr;
            int[] iArr2 = new int[AppVersionState.values().length];
            try {
                iArr2[AppVersionState.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            f23717b = iArr2;
            int[] iArr3 = new int[NextScreen.values().length];
            try {
                iArr3[NextScreen.CONTINUE_REGISTRATION_SIGNUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[NextScreen.CONTINUE_REGISTRATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[NextScreen.OPEN_LANDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            f23718c = iArr3;
        }
    }

    @Inject
    public FullAuthFlow(DeepLinkManager deepLinkManager, AuthStepFactory factory, AuthManager authManager, PlatformAvailabilityManager platformAvailabilityManager, GeoLocationManager locationManager) {
        Intrinsics.f(deepLinkManager, "deepLinkManager");
        Intrinsics.f(factory, "factory");
        Intrinsics.f(authManager, "authManager");
        Intrinsics.f(platformAvailabilityManager, "platformAvailabilityManager");
        Intrinsics.f(locationManager, "locationManager");
        this.f23708d = deepLinkManager;
        this.f23709e = factory;
        this.f23710f = authManager;
        this.f23711g = platformAvailabilityManager;
        this.f23712h = locationManager;
        this.f23715k = FlowState.IDLE;
    }

    private final FlowStep<AuthStepResult> A(AuthStepResult.RoutingAction routingAction) {
        int i8 = WhenMappings.f23718c[routingAction.a().ordinal()];
        if (i8 != 1 && i8 != 2 && i8 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return null;
    }

    private final FlowStep<AuthStepResult> B(AuthStepResult.TranslationUpdate translationUpdate) {
        if (translationUpdate.a()) {
            this.f23714j = translationUpdate;
        }
        AuthStepFactory authStepFactory = this.f23709e;
        DriverConfiguration i8 = this.f23710f.i();
        if (i8 != null) {
            return authStepFactory.c(i8.a());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final FlowStep<AuthStepResult> q(AuthStepResult.AuthConfiguration authConfiguration) {
        String a8 = authConfiguration.a().a();
        if (a8 != null) {
            return this.f23709e.t(a8);
        }
        return this.f23709e.i(null);
    }

    public static /* synthetic */ void s(FullAuthFlow fullAuthFlow, AuthStepResult authStepResult, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            authStepResult = null;
        }
        fullAuthFlow.r(authStepResult);
    }

    private final FlowStep<AuthStepResult> v(AuthStepResult.AppVersionCheck appVersionCheck) {
        AuthManager.LoginOption loginOption;
        if (WhenMappings.f23717b[appVersionCheck.a().ordinal()] == 1) {
            this.f23714j = appVersionCheck;
            if (this.f23713i) {
                loginOption = AuthManager.LoginOption.ByMagicLink.f23576a;
            } else {
                loginOption = AuthManager.LoginOption.ByRefreshToken.f23577a;
            }
            this.f23710f.v(loginOption);
            g(AuthStepResult.LoginFinished.f23686a);
            return null;
        }
        this.f23715k = FlowState.PAUSED;
        return null;
    }

    private final FlowStep<AuthStepResult> w(AuthStepResult.DriverConfigurationResult driverConfigurationResult) {
        this.f23714j = driverConfigurationResult;
        return this.f23709e.u(driverConfigurationResult.a().d().i());
    }

    private final FlowStep<AuthStepResult> x(AuthStepResult.LocationPermission locationPermission) {
        if (locationPermission.a().d() == PermissionManager.PermissionStatus.GRANTED) {
            this.f23714j = locationPermission;
            return this.f23709e.g();
        }
        this.f23715k = FlowState.PAUSED;
        return null;
    }

    private final FlowStep<AuthStepResult> y(AuthStepResult.LoginMethod loginMethod) {
        LoginWay a8 = loginMethod.a();
        int[] iArr = WhenMappings.f23716a;
        int i8 = iArr[a8.ordinal()];
        if (i8 == 1 || i8 == 2) {
            this.f23713i = true;
        }
        int i9 = iArr[loginMethod.a().ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 != 3) {
                    if (i9 == 4) {
                        return this.f23709e.h();
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return this.f23709e.r();
            }
            return this.f23709e.k();
        }
        return this.f23709e.l();
    }

    private final FlowStep<AuthStepResult> z(AuthStepResult.PlatformServicesCheckResult platformServicesCheckResult) {
        if (this.f23711g.c(platformServicesCheckResult.a())) {
            this.f23714j = platformServicesCheckResult;
            return this.f23709e.f();
        }
        this.f23715k = FlowState.PAUSED;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.utils.flow.Flow
    /* renamed from: C */
    public FlowStep<AuthStepResult> m(AuthStepResult result) {
        Intrinsics.f(result, "result");
        if (result instanceof AuthStepResult.PlatformServicesCheckResult) {
            return z((AuthStepResult.PlatformServicesCheckResult) result);
        }
        if (result instanceof AuthStepResult.LocationPermission) {
            return x((AuthStepResult.LocationPermission) result);
        }
        if (result instanceof AuthStepResult.TranslationUpdate) {
            return B((AuthStepResult.TranslationUpdate) result);
        }
        if (result instanceof AuthStepResult.LoginMethod) {
            return y((AuthStepResult.LoginMethod) result);
        }
        if (result instanceof AuthStepResult.DriverConfigurationResult) {
            return w((AuthStepResult.DriverConfigurationResult) result);
        }
        if (result instanceof AuthStepResult.AppVersionCheck) {
            return v((AuthStepResult.AppVersionCheck) result);
        }
        if (result instanceof AuthStepResult.PreLoginTargeting) {
            return this.f23709e.s(((AuthStepResult.PreLoginTargeting) result).a());
        }
        if (result instanceof AuthStepResult.Logout) {
            return this.f23709e.d();
        }
        if (result instanceof AuthStepResult.DriverCleared) {
            return this.f23709e.l();
        }
        if (result instanceof AuthStepResult.AuthConfiguration) {
            return q((AuthStepResult.AuthConfiguration) result);
        }
        if (result instanceof AuthStepResult.StoreIntegrityVerification) {
            return this.f23709e.i(((AuthStepResult.StoreIntegrityVerification) result).a());
        }
        if (result instanceof AuthStepResult.RoutingAction) {
            return A((AuthStepResult.RoutingAction) result);
        }
        if (result instanceof AuthStepResult.DeviceTargetingSaved) {
            return this.f23709e.j();
        }
        if (result instanceof AuthStepResult.LoginFinished) {
            this.f23715k = FlowState.FINISHED;
            return null;
        } else if (!(result instanceof AuthStepResult.Error)) {
            return null;
        } else {
            this.f23715k = FlowState.PAUSED;
            return null;
        }
    }

    public final void D(Intent intent) {
        Intrinsics.f(intent, "intent");
        this.f23713i = false;
        this.f23708d.e(intent);
        if (this.f23710f.l()) {
            l().onNext(AuthStepResult.AlreadyLoggedIn.f23674a);
            this.f23712h.k().E();
            return;
        }
        this.f23715k = FlowState.RUNNING;
        h(n(this.f23709e.q()));
    }

    public final void r(AuthStepResult authStepResult) {
        if (authStepResult == null) {
            authStepResult = this.f23714j;
        }
        if (authStepResult == null) {
            h(n(this.f23709e.q()));
            return;
        }
        FlowStep<AuthStepResult> m8 = m(authStepResult);
        if (m8 != null) {
            h(n(m8));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.utils.flow.Flow
    /* renamed from: t */
    public AuthStepResult.Error e(Throwable throwable) {
        Intrinsics.f(throwable, "throwable");
        return new AuthStepResult.Error(throwable);
    }

    public final FlowState u() {
        return this.f23715k;
    }
}
