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

/* compiled from: PartnerConvertAuthFlow.kt */
/* loaded from: classes3.dex */
public final class PartnerConvertAuthFlow extends Flow<AuthStepResult> {

    /* renamed from: d  reason: collision with root package name */
    private final AuthStepFactory f23776d;

    /* renamed from: e  reason: collision with root package name */
    private final DeviceSettings f23777e;

    /* renamed from: f  reason: collision with root package name */
    private final PartnerTokenManager f23778f;

    /* renamed from: g  reason: collision with root package name */
    private DriverConfiguration f23779g;

    /* compiled from: PartnerConvertAuthFlow.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23780a;

        static {
            int[] iArr = new int[AppVersionState.values().length];
            try {
                iArr[AppVersionState.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f23780a = iArr;
        }
    }

    @Inject
    public PartnerConvertAuthFlow(AuthStepFactory factory, DeviceSettings deviceSettings, PartnerTokenManager partnerTokenManager) {
        Intrinsics.f(factory, "factory");
        Intrinsics.f(deviceSettings, "deviceSettings");
        Intrinsics.f(partnerTokenManager, "partnerTokenManager");
        this.f23776d = factory;
        this.f23777e = deviceSettings;
        this.f23778f = partnerTokenManager;
    }

    private final FlowStep<AuthStepResult> q() {
        AuthStepFactory authStepFactory = this.f23776d;
        DriverConfiguration driverConfiguration = this.f23779g;
        if (driverConfiguration != null) {
            return authStepFactory.c(driverConfiguration.a());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final FlowStep<AuthStepResult> s(AuthStepResult.LocationPermission locationPermission) {
        if (locationPermission.a().d() == PermissionManager.PermissionStatus.GRANTED) {
            return this.f23776d.m();
        }
        return null;
    }

    private final FlowStep<AuthStepResult> v(AuthStepResult.AuthenticationResult authenticationResult) {
        AuthResult a8 = authenticationResult.a();
        boolean z7 = a8 instanceof AuthResult.PartnerSuccess;
        if (z7) {
            this.f23777e.s(((AuthResult.PartnerSuccess) authenticationResult.a()).a());
            this.f23778f.v();
            return this.f23776d.n();
        } else if (a8 instanceof AuthResult.Success) {
            this.f23777e.t(((AuthResult.Success) authenticationResult.a()).a());
            return this.f23776d.g();
        } else if (!z7) {
            return null;
        } else {
            this.f23777e.s(((AuthResult.PartnerSuccess) authenticationResult.a()).a());
            return null;
        }
    }

    private final FlowStep<AuthStepResult> w(AuthStepResult.AppVersionCheck appVersionCheck) {
        if (WhenMappings.f23780a[appVersionCheck.a().ordinal()] == 1) {
            AuthManager.LoginOption.PartnerTokenConvert partnerTokenConvert = AuthManager.LoginOption.PartnerTokenConvert.f23578a;
            DriverConfiguration driverConfiguration = this.f23779g;
            if (driverConfiguration != null) {
                return new SingleItemStep(new AuthStepResult.AuthenticationFinished(partnerTokenConvert, driverConfiguration));
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        return null;
    }

    private final FlowStep<AuthStepResult> x(AuthStepResult.DriverConfigurationResult driverConfigurationResult) {
        this.f23779g = driverConfigurationResult.a();
        return this.f23776d.u(driverConfigurationResult.a().d().i());
    }

    public final void A() {
        FlowStep<AuthStepResult> m8 = m(new AuthStepResult.AppVersionCheck(AppVersionState.OK));
        if (m8 != null) {
            h(n(m8));
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void r() {
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
            return this.f23776d.h();
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
        h(n(this.f23776d.h()));
    }
}
