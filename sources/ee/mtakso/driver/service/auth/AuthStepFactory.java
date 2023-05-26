package ee.mtakso.driver.service.auth;

import android.content.Context;
import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.network.client.auth.anonymous.AuthenticationConfigurationAuthMethod;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthClient;
import ee.mtakso.driver.network.client.driver.DriverConfigurationClient;
import ee.mtakso.driver.network.client.partner.PartnerClient;
import ee.mtakso.driver.network.client.registration.DriverRegistrationClient;
import ee.mtakso.driver.network.client.targeting.TargetingParameters;
import ee.mtakso.driver.param.DeviceFeatures;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.platform.check.PlatformAvailabilityManager;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityCheck;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityVerificationResult;
import ee.mtakso.driver.service.auth.step.AuthConfigurationStep;
import ee.mtakso.driver.service.auth.step.AuthConfirmationStep;
import ee.mtakso.driver.service.auth.step.AuthenticateStep;
import ee.mtakso.driver.service.auth.step.CheckAppVersionStep;
import ee.mtakso.driver.service.auth.step.ClearStorageStep;
import ee.mtakso.driver.service.auth.step.DeviceCheckStep;
import ee.mtakso.driver.service.auth.step.DriverConfigStep;
import ee.mtakso.driver.service.auth.step.LoadTranslationsStep;
import ee.mtakso.driver.service.auth.step.LocationStep;
import ee.mtakso.driver.service.auth.step.LoginByMagicStep;
import ee.mtakso.driver.service.auth.step.LoginMethodStep;
import ee.mtakso.driver.service.auth.step.LogoutStep;
import ee.mtakso.driver.service.auth.step.OTPAuthenticateStep;
import ee.mtakso.driver.service.auth.step.PartnerConvertAuthenticateStep;
import ee.mtakso.driver.service.auth.step.PartnerDeviceTokenUpdateStep;
import ee.mtakso.driver.service.auth.step.PhoneAuthenticationStep;
import ee.mtakso.driver.service.auth.step.PreLoginTargetingStep;
import ee.mtakso.driver.service.auth.step.RegistrationStatusStep;
import ee.mtakso.driver.service.auth.step.SaveDeviceTargetingStep;
import ee.mtakso.driver.service.auth.step.StoreVerificationStep;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.push.PushManagerImpl;
import eu.bolt.driver.core.network.client.driver.DriverAppConfig;
import eu.bolt.driver.core.ui.translation.TranslationManager;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthStepFactory.kt */
/* loaded from: classes3.dex */
public final class AuthStepFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Context f23632a;

    /* renamed from: b  reason: collision with root package name */
    private final DeepLinkManager f23633b;

    /* renamed from: c  reason: collision with root package name */
    private final AnonymousAuthClient f23634c;

    /* renamed from: d  reason: collision with root package name */
    private final PartnerClient f23635d;

    /* renamed from: e  reason: collision with root package name */
    private final AuthenticatedAuthClient f23636e;

    /* renamed from: f  reason: collision with root package name */
    private final DriverRegistrationClient f23637f;

    /* renamed from: g  reason: collision with root package name */
    private final TranslationManager f23638g;

    /* renamed from: h  reason: collision with root package name */
    private final AuthManager f23639h;

    /* renamed from: i  reason: collision with root package name */
    private final PushManagerImpl f23640i;

    /* renamed from: j  reason: collision with root package name */
    private final DriverProvider f23641j;

    /* renamed from: k  reason: collision with root package name */
    private final DeviceSettings f23642k;

    /* renamed from: l  reason: collision with root package name */
    private final LanguageManager f23643l;

    /* renamed from: m  reason: collision with root package name */
    private final PlatformAvailabilityManager f23644m;

    /* renamed from: n  reason: collision with root package name */
    private final DeviceFeatures f23645n;

    /* renamed from: o  reason: collision with root package name */
    private final GeoLocationManager f23646o;

    /* renamed from: p  reason: collision with root package name */
    private final DriverConfigurationClient f23647p;

    /* renamed from: q  reason: collision with root package name */
    private final TempDriverConfigHolder f23648q;

    /* renamed from: r  reason: collision with root package name */
    private final StoreIntegrityCheck f23649r;

    /* renamed from: s  reason: collision with root package name */
    private final StoreVerificationBackoffStrategy f23650s;

    /* renamed from: t  reason: collision with root package name */
    private final AuthConfigurationBackoffStrategy f23651t;

    /* renamed from: u  reason: collision with root package name */
    private final PlatformManager f23652u;

    @Inject
    public AuthStepFactory(Context applicationContext, DeepLinkManager deepLinkManager, AnonymousAuthClient anonymousAuthClient, PartnerClient partnerClient, AuthenticatedAuthClient authenticatedAuthClient, DriverRegistrationClient driverRegistrationClient, TranslationManager translationManager, AuthManager authManager, PushManagerImpl pushManager, DriverProvider driverProvider, DeviceSettings deviceSettings, LanguageManager languageManager, PlatformAvailabilityManager platformAvailabilityManager, DeviceFeatures deviceFeatures, GeoLocationManager locationManager, DriverConfigurationClient driverConfigurationClient, TempDriverConfigHolder tempDriverConfigHolder, StoreIntegrityCheck integrityCheck, StoreVerificationBackoffStrategy storeVerificationBackoffStrategy, AuthConfigurationBackoffStrategy authConfigurationBackoffStrategy, PlatformManager platformManager) {
        Intrinsics.f(applicationContext, "applicationContext");
        Intrinsics.f(deepLinkManager, "deepLinkManager");
        Intrinsics.f(anonymousAuthClient, "anonymousAuthClient");
        Intrinsics.f(partnerClient, "partnerClient");
        Intrinsics.f(authenticatedAuthClient, "authenticatedAuthClient");
        Intrinsics.f(driverRegistrationClient, "driverRegistrationClient");
        Intrinsics.f(translationManager, "translationManager");
        Intrinsics.f(authManager, "authManager");
        Intrinsics.f(pushManager, "pushManager");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(deviceSettings, "deviceSettings");
        Intrinsics.f(languageManager, "languageManager");
        Intrinsics.f(platformAvailabilityManager, "platformAvailabilityManager");
        Intrinsics.f(deviceFeatures, "deviceFeatures");
        Intrinsics.f(locationManager, "locationManager");
        Intrinsics.f(driverConfigurationClient, "driverConfigurationClient");
        Intrinsics.f(tempDriverConfigHolder, "tempDriverConfigHolder");
        Intrinsics.f(integrityCheck, "integrityCheck");
        Intrinsics.f(storeVerificationBackoffStrategy, "storeVerificationBackoffStrategy");
        Intrinsics.f(authConfigurationBackoffStrategy, "authConfigurationBackoffStrategy");
        Intrinsics.f(platformManager, "platformManager");
        this.f23632a = applicationContext;
        this.f23633b = deepLinkManager;
        this.f23634c = anonymousAuthClient;
        this.f23635d = partnerClient;
        this.f23636e = authenticatedAuthClient;
        this.f23637f = driverRegistrationClient;
        this.f23638g = translationManager;
        this.f23639h = authManager;
        this.f23640i = pushManager;
        this.f23641j = driverProvider;
        this.f23642k = deviceSettings;
        this.f23643l = languageManager;
        this.f23644m = platformAvailabilityManager;
        this.f23645n = deviceFeatures;
        this.f23646o = locationManager;
        this.f23647p = driverConfigurationClient;
        this.f23648q = tempDriverConfigHolder;
        this.f23649r = integrityCheck;
        this.f23650s = storeVerificationBackoffStrategy;
        this.f23651t = authConfigurationBackoffStrategy;
        this.f23652u = platformManager;
    }

    public final OTPAuthenticateStep a(String verificationToken, String verificationCode) {
        Intrinsics.f(verificationToken, "verificationToken");
        Intrinsics.f(verificationCode, "verificationCode");
        return new OTPAuthenticateStep(this.f23634c, verificationToken, verificationCode);
    }

    public final AuthenticateStep b(String login, String password, StoreIntegrityVerificationResult storeIntegrityVerificationResult) {
        Intrinsics.f(login, "login");
        Intrinsics.f(password, "password");
        return new AuthenticateStep(this.f23634c, login, password, this.f23645n, storeIntegrityVerificationResult);
    }

    public final CheckAppVersionStep c(DriverAppConfig driverConfig) {
        Intrinsics.f(driverConfig, "driverConfig");
        return new CheckAppVersionStep(driverConfig);
    }

    public final ClearStorageStep d() {
        return new ClearStorageStep(this.f23641j, this.f23642k);
    }

    public final AuthConfirmationStep e(String token, String code) {
        Intrinsics.f(token, "token");
        Intrinsics.f(code, "code");
        return new AuthConfirmationStep(token, code, this.f23634c);
    }

    public final PreLoginTargetingStep f() {
        return new PreLoginTargetingStep(this.f23634c, this.f23642k);
    }

    public final DriverConfigStep g() {
        return new DriverConfigStep(this.f23647p, this.f23648q, this.f23641j, this.f23639h);
    }

    public final LocationStep h() {
        return new LocationStep(this.f23646o);
    }

    public final LoginByMagicStep i(StoreIntegrityVerificationResult storeIntegrityVerificationResult) {
        return new LoginByMagicStep(this.f23634c, this.f23633b, this.f23642k, storeIntegrityVerificationResult);
    }

    public final LoginMethodStep j() {
        return new LoginMethodStep(this.f23642k, this.f23633b);
    }

    public final LogoutStep k() {
        return new LogoutStep(this.f23636e);
    }

    public final AuthConfigurationStep l() {
        return new AuthConfigurationStep(this.f23634c, this.f23651t, AuthenticationConfigurationAuthMethod.MAGIC_LINK, this.f23652u.getType());
    }

    public final PartnerConvertAuthenticateStep m() {
        return new PartnerConvertAuthenticateStep(this.f23635d);
    }

    public final PartnerDeviceTokenUpdateStep n() {
        return new PartnerDeviceTokenUpdateStep(this.f23640i, this.f23639h);
    }

    public final AuthConfigurationStep o() {
        return new AuthConfigurationStep(this.f23634c, this.f23651t, AuthenticationConfigurationAuthMethod.PHONE, this.f23652u.getType());
    }

    public final PhoneAuthenticationStep p(String phonePrefix, String phone, StoreIntegrityVerificationResult storeIntegrityVerificationResult) {
        Intrinsics.f(phonePrefix, "phonePrefix");
        Intrinsics.f(phone, "phone");
        return new PhoneAuthenticationStep(this.f23634c, phonePrefix, phone, this.f23645n.d(), storeIntegrityVerificationResult);
    }

    public final DeviceCheckStep q() {
        return new DeviceCheckStep(this.f23644m);
    }

    public final RegistrationStatusStep r() {
        return new RegistrationStatusStep(this.f23642k, this.f23637f, this.f23634c, this.f23640i, this.f23639h);
    }

    public final SaveDeviceTargetingStep s(TargetingParameters targetingParameters) {
        Intrinsics.f(targetingParameters, "targetingParameters");
        return new SaveDeviceTargetingStep(targetingParameters, this.f23645n);
    }

    public final StoreVerificationStep t(String nonce) {
        Intrinsics.f(nonce, "nonce");
        return new StoreVerificationStep(this.f23632a, this.f23649r, nonce, this.f23650s);
    }

    public final LoadTranslationsStep u(long j8) {
        return new LoadTranslationsStep(j8, this.f23641j, this.f23638g, this.f23643l);
    }

    public final AuthConfigurationStep v() {
        return new AuthConfigurationStep(this.f23634c, this.f23651t, AuthenticationConfigurationAuthMethod.USERNAME_PASSWORD, this.f23652u.getType());
    }
}
