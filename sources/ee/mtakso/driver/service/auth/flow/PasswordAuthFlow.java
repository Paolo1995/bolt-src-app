package ee.mtakso.driver.service.auth.flow;

import ee.mtakso.driver.network.client.auth.anonymous.AuthResult;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.service.auth.AppVersionState;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.AuthStepFactory;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.auth.step.StoreVerificationStep;
import ee.mtakso.driver.service.token.PartnerTokenManager;
import ee.mtakso.driver.utils.flow.Flow;
import ee.mtakso.driver.utils.flow.FlowStep;
import ee.mtakso.driver.utils.flow.SingleItemStep;
import eu.bolt.driver.core.network.client.driver.DriverConfiguration;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PasswordAuthFlow.kt */
/* loaded from: classes3.dex */
public final class PasswordAuthFlow extends Flow<AuthStepResult> {

    /* renamed from: d  reason: collision with root package name */
    private final AuthStepFactory f23784d;

    /* renamed from: e  reason: collision with root package name */
    private final DeviceSettings f23785e;

    /* renamed from: f  reason: collision with root package name */
    private final PartnerTokenManager f23786f;

    /* renamed from: g  reason: collision with root package name */
    private String f23787g;

    /* renamed from: h  reason: collision with root package name */
    private String f23788h;

    /* renamed from: i  reason: collision with root package name */
    private String f23789i;

    /* renamed from: j  reason: collision with root package name */
    private DriverConfiguration f23790j;

    /* compiled from: PasswordAuthFlow.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23791a;

        static {
            int[] iArr = new int[AppVersionState.values().length];
            try {
                iArr[AppVersionState.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f23791a = iArr;
        }
    }

    @Inject
    public PasswordAuthFlow(AuthStepFactory factory, DeviceSettings deviceSettings, PartnerTokenManager partnerTokenManager) {
        Intrinsics.f(factory, "factory");
        Intrinsics.f(deviceSettings, "deviceSettings");
        Intrinsics.f(partnerTokenManager, "partnerTokenManager");
        this.f23784d = factory;
        this.f23785e = deviceSettings;
        this.f23786f = partnerTokenManager;
        this.f23787g = "";
        this.f23788h = "";
    }

    private final FlowStep<AuthStepResult> C(String str) {
        StoreVerificationStep t7;
        if (str == null || (t7 = this.f23784d.t(str)) == null) {
            return this.f23784d.b(this.f23787g, this.f23788h, null);
        }
        return t7;
    }

    private final FlowStep<AuthStepResult> D(AuthStepResult.LocationPermission locationPermission) {
        if (locationPermission.a().d() == PermissionManager.PermissionStatus.GRANTED) {
            return this.f23784d.v();
        }
        return null;
    }

    private final FlowStep<AuthStepResult> q() {
        AuthStepFactory authStepFactory = this.f23784d;
        DriverConfiguration driverConfiguration = this.f23790j;
        if (driverConfiguration != null) {
            return authStepFactory.c(driverConfiguration.a());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final FlowStep<AuthStepResult> v(AuthStepResult.AuthenticationResult authenticationResult) {
        AuthResult a8 = authenticationResult.a();
        if (a8 instanceof AuthResult.PartnerSuccess) {
            this.f23785e.s(((AuthResult.PartnerSuccess) authenticationResult.a()).a());
            this.f23786f.v();
            return this.f23784d.n();
        } else if (a8 instanceof AuthResult.Success) {
            this.f23789i = ((AuthResult.Success) authenticationResult.a()).a();
            this.f23785e.t(((AuthResult.Success) authenticationResult.a()).a());
            return this.f23784d.g();
        } else {
            return null;
        }
    }

    private final FlowStep<AuthStepResult> w(AuthStepResult.AppVersionCheck appVersionCheck) {
        if (WhenMappings.f23791a[appVersionCheck.a().ordinal()] == 1) {
            AuthManager.LoginOption.Username username = new AuthManager.LoginOption.Username(this.f23787g);
            DriverConfiguration driverConfiguration = this.f23790j;
            if (driverConfiguration != null) {
                return new SingleItemStep(new AuthStepResult.AuthenticationFinished(username, driverConfiguration));
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        return null;
    }

    private final FlowStep<AuthStepResult> x(AuthStepResult.DriverConfigurationResult driverConfigurationResult) {
        this.f23790j = driverConfigurationResult.a();
        return this.f23784d.u(driverConfigurationResult.a().d().i());
    }

    public final void A() {
        h(n(this.f23784d.h()));
    }

    public final void B() {
        FlowStep<AuthStepResult> m8 = m(new AuthStepResult.AppVersionCheck(AppVersionState.OK));
        if (m8 != null) {
            h(n(m8));
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void r(String login, String password) {
        Intrinsics.f(login, "login");
        Intrinsics.f(password, "password");
        this.f23787g = login;
        this.f23788h = password;
        h(n(new SingleItemStep(AuthStepResult.LoginStarted.f23688a)));
    }

    public final void s() {
        f();
        h(n(new SingleItemStep(new AuthStepResult.AuthenticationResult(AuthResult.VerificationCanceled.f21468f))));
    }

    public final void t(String code, String token) {
        Intrinsics.f(code, "code");
        Intrinsics.f(token, "token");
        h(n(this.f23784d.e(token, code)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.utils.flow.Flow
    /* renamed from: u */
    public AuthStepResult e(Throwable throwable) {
        Intrinsics.f(throwable, "throwable");
        return new AuthStepResult.Error(throwable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.utils.flow.Flow
    /* renamed from: y */
    public FlowStep<AuthStepResult> m(AuthStepResult result) {
        Intrinsics.f(result, "result");
        if (result instanceof AuthStepResult.LoginStarted) {
            return this.f23784d.h();
        }
        if (result instanceof AuthStepResult.LocationPermission) {
            return D((AuthStepResult.LocationPermission) result);
        }
        if (result instanceof AuthStepResult.AuthConfiguration) {
            return C(((AuthStepResult.AuthConfiguration) result).a().a());
        }
        if (result instanceof AuthStepResult.StoreIntegrityVerification) {
            return this.f23784d.b(this.f23787g, this.f23788h, ((AuthStepResult.StoreIntegrityVerification) result).a());
        }
        if (result instanceof AuthStepResult.AuthenticationResult) {
            return v((AuthStepResult.AuthenticationResult) result);
        }
        if (result instanceof AuthStepResult.DriverConfigurationResult) {
            return x((AuthStepResult.DriverConfigurationResult) result);
        }
        if (result instanceof AuthStepResult.TranslationUpdate) {
            return q();
        }
        if (result instanceof AuthStepResult.AppVersionCheck) {
            return w((AuthStepResult.AppVersionCheck) result);
        }
        return null;
    }

    public final void z() {
        f();
        h(n(this.f23784d.h()));
    }
}
