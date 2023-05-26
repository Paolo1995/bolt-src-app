package ee.mtakso.driver.service.auth.flow;

import ee.mtakso.driver.network.client.auth.anonymous.AuthResult;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.service.auth.AppVersionState;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.AuthStepFactory;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.token.PartnerTokenManager;
import ee.mtakso.driver.utils.flow.Flow;
import ee.mtakso.driver.utils.flow.FlowStep;
import ee.mtakso.driver.utils.flow.SingleItemStep;
import eu.bolt.driver.core.network.client.driver.DriverConfiguration;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OTPAuthFlow.kt */
/* loaded from: classes3.dex */
public final class OTPAuthFlow extends Flow<AuthStepResult> {

    /* renamed from: d  reason: collision with root package name */
    private final AuthStepFactory f23765d;

    /* renamed from: e  reason: collision with root package name */
    private final DeviceSettings f23766e;

    /* renamed from: f  reason: collision with root package name */
    private final PartnerTokenManager f23767f;

    /* renamed from: g  reason: collision with root package name */
    private String f23768g;

    /* renamed from: h  reason: collision with root package name */
    private String f23769h;

    /* renamed from: i  reason: collision with root package name */
    private AuthManager.LoginOption f23770i;

    /* renamed from: j  reason: collision with root package name */
    private DriverConfiguration f23771j;

    /* compiled from: OTPAuthFlow.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23772a;

        static {
            int[] iArr = new int[AppVersionState.values().length];
            try {
                iArr[AppVersionState.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f23772a = iArr;
        }
    }

    @Inject
    public OTPAuthFlow(AuthStepFactory factory, DeviceSettings deviceSettings, PartnerTokenManager partnerTokenManager) {
        Intrinsics.f(factory, "factory");
        Intrinsics.f(deviceSettings, "deviceSettings");
        Intrinsics.f(partnerTokenManager, "partnerTokenManager");
        this.f23765d = factory;
        this.f23766e = deviceSettings;
        this.f23767f = partnerTokenManager;
    }

    private final FlowStep<AuthStepResult> q() {
        AuthStepFactory authStepFactory = this.f23765d;
        DriverConfiguration driverConfiguration = this.f23771j;
        if (driverConfiguration != null) {
            return authStepFactory.c(driverConfiguration.a());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final FlowStep<AuthStepResult> s(AuthStepResult.LocationPermission locationPermission) {
        String str = null;
        if (locationPermission.a().d() != PermissionManager.PermissionStatus.GRANTED) {
            return null;
        }
        AuthStepFactory authStepFactory = this.f23765d;
        String str2 = this.f23768g;
        if (str2 == null) {
            Intrinsics.w("token");
            str2 = null;
        }
        String str3 = this.f23769h;
        if (str3 == null) {
            Intrinsics.w("code");
        } else {
            str = str3;
        }
        return authStepFactory.a(str2, str);
    }

    private final FlowStep<AuthStepResult> v(AuthStepResult.AuthenticationResult authenticationResult) {
        AuthResult a8 = authenticationResult.a();
        boolean z7 = a8 instanceof AuthResult.PartnerSuccess;
        if (z7) {
            this.f23766e.s(((AuthResult.PartnerSuccess) authenticationResult.a()).a());
            this.f23767f.v();
            return this.f23765d.n();
        } else if (a8 instanceof AuthResult.Success) {
            this.f23766e.t(((AuthResult.Success) authenticationResult.a()).a());
            return this.f23765d.g();
        } else if (!z7) {
            return null;
        } else {
            this.f23766e.s(((AuthResult.PartnerSuccess) authenticationResult.a()).a());
            return null;
        }
    }

    private final FlowStep<AuthStepResult> w(AuthStepResult.AppVersionCheck appVersionCheck) {
        AuthManager.LoginOption loginOption = null;
        if (WhenMappings.f23772a[appVersionCheck.a().ordinal()] != 1) {
            return null;
        }
        AuthManager.LoginOption loginOption2 = this.f23770i;
        if (loginOption2 == null) {
            Intrinsics.w("loginOption");
        } else {
            loginOption = loginOption2;
        }
        DriverConfiguration driverConfiguration = this.f23771j;
        if (driverConfiguration != null) {
            return new SingleItemStep(new AuthStepResult.AuthenticationFinished(loginOption, driverConfiguration));
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final FlowStep<AuthStepResult> x(AuthStepResult.DriverConfigurationResult driverConfigurationResult) {
        this.f23771j = driverConfigurationResult.a();
        return this.f23765d.u(driverConfigurationResult.a().d().i());
    }

    public final void A() {
        h(n(this.f23765d.h()));
    }

    public final void B() {
        FlowStep<AuthStepResult> m8 = m(new AuthStepResult.AppVersionCheck(AppVersionState.OK));
        if (m8 != null) {
            h(n(m8));
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void r(String token, String code, AuthManager.LoginOption loginOption) {
        Intrinsics.f(token, "token");
        Intrinsics.f(code, "code");
        Intrinsics.f(loginOption, "loginOption");
        this.f23768g = token;
        this.f23769h = code;
        this.f23770i = loginOption;
        h(n(new SingleItemStep(AuthStepResult.LoginStarted.f23688a)));
    }

    public final void t() {
        f();
        h(n(new SingleItemStep(new AuthStepResult.AuthenticationResult(AuthResult.VerificationCanceled.f21468f))));
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
            return this.f23765d.h();
        }
        if (result instanceof AuthStepResult.LocationPermission) {
            return s((AuthStepResult.LocationPermission) result);
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
        h(n(this.f23765d.h()));
    }
}
