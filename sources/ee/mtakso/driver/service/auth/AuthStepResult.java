package ee.mtakso.driver.service.auth;

import ee.mtakso.driver.network.client.auth.anonymous.AuthConfigurationResponse;
import ee.mtakso.driver.network.client.auth.anonymous.AuthResult;
import ee.mtakso.driver.network.client.auth.anonymous.VerificationCode;
import ee.mtakso.driver.network.client.targeting.TargetingParameters;
import ee.mtakso.driver.platform.check.PlatformServicesState;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityVerificationResult;
import ee.mtakso.driver.service.auth.AuthManager;
import eu.bolt.driver.core.network.client.driver.DriverConfiguration;
import eu.bolt.driver.core.permission.PermissionManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthStepResult.kt */
/* loaded from: classes3.dex */
public abstract class AuthStepResult {

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class AlreadyLoggedIn extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        public static final AlreadyLoggedIn f23674a = new AlreadyLoggedIn();

        private AlreadyLoggedIn() {
            super(null);
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class AppVersionCheck extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final AppVersionState f23675a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppVersionCheck(AppVersionState state) {
            super(null);
            Intrinsics.f(state, "state");
            this.f23675a = state;
        }

        public final AppVersionState a() {
            return this.f23675a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AppVersionCheck) && this.f23675a == ((AppVersionCheck) obj).f23675a;
        }

        public int hashCode() {
            return this.f23675a.hashCode();
        }

        public String toString() {
            AppVersionState appVersionState = this.f23675a;
            return "AppVersionCheck(state=" + appVersionState + ")";
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class AuthConfiguration extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final AuthConfigurationResponse f23676a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuthConfiguration(AuthConfigurationResponse params) {
            super(null);
            Intrinsics.f(params, "params");
            this.f23676a = params;
        }

        public final AuthConfigurationResponse a() {
            return this.f23676a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AuthConfiguration) && Intrinsics.a(this.f23676a, ((AuthConfiguration) obj).f23676a);
        }

        public int hashCode() {
            return this.f23676a.hashCode();
        }

        public String toString() {
            AuthConfigurationResponse authConfigurationResponse = this.f23676a;
            return "AuthConfiguration(params=" + authConfigurationResponse + ")";
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class AuthenticationFinished extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final AuthManager.LoginOption f23677a;

        /* renamed from: b  reason: collision with root package name */
        private final DriverConfiguration f23678b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuthenticationFinished(AuthManager.LoginOption loginOption, DriverConfiguration driverConfig) {
            super(null);
            Intrinsics.f(loginOption, "loginOption");
            Intrinsics.f(driverConfig, "driverConfig");
            this.f23677a = loginOption;
            this.f23678b = driverConfig;
        }

        public final DriverConfiguration a() {
            return this.f23678b;
        }

        public final AuthManager.LoginOption b() {
            return this.f23677a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AuthenticationFinished) {
                AuthenticationFinished authenticationFinished = (AuthenticationFinished) obj;
                return Intrinsics.a(this.f23677a, authenticationFinished.f23677a) && Intrinsics.a(this.f23678b, authenticationFinished.f23678b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f23677a.hashCode() * 31) + this.f23678b.hashCode();
        }

        public String toString() {
            AuthManager.LoginOption loginOption = this.f23677a;
            DriverConfiguration driverConfiguration = this.f23678b;
            return "AuthenticationFinished(loginOption=" + loginOption + ", driverConfig=" + driverConfiguration + ")";
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class AuthenticationResult extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final AuthResult f23679a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuthenticationResult(AuthResult result) {
            super(null);
            Intrinsics.f(result, "result");
            this.f23679a = result;
        }

        public final AuthResult a() {
            return this.f23679a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AuthenticationResult) && Intrinsics.a(this.f23679a, ((AuthenticationResult) obj).f23679a);
        }

        public int hashCode() {
            return this.f23679a.hashCode();
        }

        public String toString() {
            AuthResult authResult = this.f23679a;
            return "AuthenticationResult(result=" + authResult + ")";
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class ConfirmationStarted extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        public static final ConfirmationStarted f23680a = new ConfirmationStarted();

        private ConfirmationStarted() {
            super(null);
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class DeviceTargetingSaved extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        public static final DeviceTargetingSaved f23681a = new DeviceTargetingSaved();

        private DeviceTargetingSaved() {
            super(null);
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class DriverCleared extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        public static final DriverCleared f23682a = new DriverCleared();

        private DriverCleared() {
            super(null);
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class DriverConfigurationResult extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final DriverConfiguration f23683a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DriverConfigurationResult(DriverConfiguration config) {
            super(null);
            Intrinsics.f(config, "config");
            this.f23683a = config;
        }

        public final DriverConfiguration a() {
            return this.f23683a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DriverConfigurationResult) && Intrinsics.a(this.f23683a, ((DriverConfigurationResult) obj).f23683a);
        }

        public int hashCode() {
            return this.f23683a.hashCode();
        }

        public String toString() {
            DriverConfiguration driverConfiguration = this.f23683a;
            return "DriverConfigurationResult(config=" + driverConfiguration + ")";
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class Error extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final Throwable f23684a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable throwable) {
            super(null);
            Intrinsics.f(throwable, "throwable");
            this.f23684a = throwable;
        }

        public final Throwable a() {
            return this.f23684a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.a(this.f23684a, ((Error) obj).f23684a);
        }

        public int hashCode() {
            return this.f23684a.hashCode();
        }

        public String toString() {
            Throwable th = this.f23684a;
            return "Error(throwable=" + th + ")";
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class LocationPermission extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final PermissionManager.PermissionInfo f23685a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LocationPermission(PermissionManager.PermissionInfo info) {
            super(null);
            Intrinsics.f(info, "info");
            this.f23685a = info;
        }

        public final PermissionManager.PermissionInfo a() {
            return this.f23685a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LocationPermission) && Intrinsics.a(this.f23685a, ((LocationPermission) obj).f23685a);
        }

        public int hashCode() {
            return this.f23685a.hashCode();
        }

        public String toString() {
            PermissionManager.PermissionInfo permissionInfo = this.f23685a;
            return "LocationPermission(info=" + permissionInfo + ")";
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class LoginFinished extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        public static final LoginFinished f23686a = new LoginFinished();

        private LoginFinished() {
            super(null);
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class LoginMethod extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final LoginWay f23687a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoginMethod(LoginWay way) {
            super(null);
            Intrinsics.f(way, "way");
            this.f23687a = way;
        }

        public final LoginWay a() {
            return this.f23687a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoginMethod) && this.f23687a == ((LoginMethod) obj).f23687a;
        }

        public int hashCode() {
            return this.f23687a.hashCode();
        }

        public String toString() {
            LoginWay loginWay = this.f23687a;
            return "LoginMethod(way=" + loginWay + ")";
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class LoginStarted extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        public static final LoginStarted f23688a = new LoginStarted();

        private LoginStarted() {
            super(null);
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class Logout extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        public static final Logout f23689a = new Logout();

        private Logout() {
            super(null);
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class Message extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final String f23690a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Message(String msg) {
            super(null);
            Intrinsics.f(msg, "msg");
            this.f23690a = msg;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Message) && Intrinsics.a(this.f23690a, ((Message) obj).f23690a);
        }

        public int hashCode() {
            return this.f23690a.hashCode();
        }

        public String toString() {
            String str = this.f23690a;
            return "Message(msg=" + str + ")";
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class PartnerPushTokenUpdateRequested extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        public static final PartnerPushTokenUpdateRequested f23691a = new PartnerPushTokenUpdateRequested();

        private PartnerPushTokenUpdateRequested() {
            super(null);
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class PhoneAuthentication extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final VerificationCode f23692a;

        /* renamed from: b  reason: collision with root package name */
        private final String f23693b;

        /* renamed from: c  reason: collision with root package name */
        private final String f23694c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PhoneAuthentication(VerificationCode verificationCode, String phonePrefix, String phone) {
            super(null);
            Intrinsics.f(verificationCode, "verificationCode");
            Intrinsics.f(phonePrefix, "phonePrefix");
            Intrinsics.f(phone, "phone");
            this.f23692a = verificationCode;
            this.f23693b = phonePrefix;
            this.f23694c = phone;
        }

        public final String a() {
            return this.f23694c;
        }

        public final String b() {
            return this.f23693b;
        }

        public final VerificationCode c() {
            return this.f23692a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PhoneAuthentication) {
                PhoneAuthentication phoneAuthentication = (PhoneAuthentication) obj;
                return Intrinsics.a(this.f23692a, phoneAuthentication.f23692a) && Intrinsics.a(this.f23693b, phoneAuthentication.f23693b) && Intrinsics.a(this.f23694c, phoneAuthentication.f23694c);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f23692a.hashCode() * 31) + this.f23693b.hashCode()) * 31) + this.f23694c.hashCode();
        }

        public String toString() {
            VerificationCode verificationCode = this.f23692a;
            String str = this.f23693b;
            String str2 = this.f23694c;
            return "PhoneAuthentication(verificationCode=" + verificationCode + ", phonePrefix=" + str + ", phone=" + str2 + ")";
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class PlatformServicesCheckResult extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final PlatformServicesState f23695a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlatformServicesCheckResult(PlatformServicesState state) {
            super(null);
            Intrinsics.f(state, "state");
            this.f23695a = state;
        }

        public final PlatformServicesState a() {
            return this.f23695a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PlatformServicesCheckResult) && Intrinsics.a(this.f23695a, ((PlatformServicesCheckResult) obj).f23695a);
        }

        public int hashCode() {
            return this.f23695a.hashCode();
        }

        public String toString() {
            PlatformServicesState platformServicesState = this.f23695a;
            return "PlatformServicesCheckResult(state=" + platformServicesState + ")";
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class PreLoginTargeting extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final TargetingParameters f23696a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PreLoginTargeting(TargetingParameters params) {
            super(null);
            Intrinsics.f(params, "params");
            this.f23696a = params;
        }

        public final TargetingParameters a() {
            return this.f23696a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PreLoginTargeting) && Intrinsics.a(this.f23696a, ((PreLoginTargeting) obj).f23696a);
        }

        public int hashCode() {
            return this.f23696a.hashCode();
        }

        public String toString() {
            TargetingParameters targetingParameters = this.f23696a;
            return "PreLoginTargeting(params=" + targetingParameters + ")";
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class RoutingAction extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final NextScreen f23697a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoutingAction(NextScreen nextScreen) {
            super(null);
            Intrinsics.f(nextScreen, "nextScreen");
            this.f23697a = nextScreen;
        }

        public final NextScreen a() {
            return this.f23697a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RoutingAction) && this.f23697a == ((RoutingAction) obj).f23697a;
        }

        public int hashCode() {
            return this.f23697a.hashCode();
        }

        public String toString() {
            NextScreen nextScreen = this.f23697a;
            return "RoutingAction(nextScreen=" + nextScreen + ")";
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class StoreIntegrityVerification extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final StoreIntegrityVerificationResult f23698a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StoreIntegrityVerification(StoreIntegrityVerificationResult param) {
            super(null);
            Intrinsics.f(param, "param");
            this.f23698a = param;
        }

        public final StoreIntegrityVerificationResult a() {
            return this.f23698a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StoreIntegrityVerification) && Intrinsics.a(this.f23698a, ((StoreIntegrityVerification) obj).f23698a);
        }

        public int hashCode() {
            return this.f23698a.hashCode();
        }

        public String toString() {
            StoreIntegrityVerificationResult storeIntegrityVerificationResult = this.f23698a;
            return "StoreIntegrityVerification(param=" + storeIntegrityVerificationResult + ")";
        }
    }

    /* compiled from: AuthStepResult.kt */
    /* loaded from: classes3.dex */
    public static final class TranslationUpdate extends AuthStepResult {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f23699a;

        public TranslationUpdate(boolean z7) {
            super(null);
            this.f23699a = z7;
        }

        public final boolean a() {
            return this.f23699a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TranslationUpdate) && this.f23699a == ((TranslationUpdate) obj).f23699a;
        }

        public int hashCode() {
            boolean z7 = this.f23699a;
            if (z7) {
                return 1;
            }
            return z7 ? 1 : 0;
        }

        public String toString() {
            boolean z7 = this.f23699a;
            return "TranslationUpdate(success=" + z7 + ")";
        }
    }

    private AuthStepResult() {
    }

    public /* synthetic */ AuthStepResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
