package ee.mtakso.driver.identity.verification;

import android.app.Application;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.network.client.auth.anonymous.AccessToken;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.token.PartnerTokenManager;
import ee.mtakso.driver.utils.UrlFactory;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import eu.bolt.driver.verification.identity.IdentityVerificationSdk;
import eu.bolt.driver.verification.identity.VerificationAnalytics;
import eu.bolt.driver.verification.identity.config.DynamicVerificationConfig;
import eu.bolt.driver.verification.identity.config.DynamicVerificationConfigProvider;
import eu.bolt.driver.verification.identity.config.StaticVerificationConfig;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

/* compiled from: PartnerIdentityVerificationInitializer.kt */
/* loaded from: classes3.dex */
public final class PartnerIdentityVerificationInitializer {

    /* renamed from: a  reason: collision with root package name */
    private final UrlFactory f20985a;

    /* renamed from: b  reason: collision with root package name */
    private final Retrofit.Builder f20986b;

    /* renamed from: c  reason: collision with root package name */
    private final DeviceInfo f20987c;

    /* renamed from: d  reason: collision with root package name */
    private final LanguageManager f20988d;

    /* renamed from: e  reason: collision with root package name */
    private final PartnerTokenManager f20989e;

    /* renamed from: f  reason: collision with root package name */
    private final VerificationAnalytics f20990f;

    /* renamed from: g  reason: collision with root package name */
    private final DriverProvider f20991g;

    @Inject
    public PartnerIdentityVerificationInitializer(UrlFactory urlFactory, Retrofit.Builder retrofitBuilder, DeviceInfo deviceInfo, LanguageManager languageManager, PartnerTokenManager tokenManager, VerificationAnalytics verificationAnalytics, DriverProvider driverProvider) {
        Intrinsics.f(urlFactory, "urlFactory");
        Intrinsics.f(retrofitBuilder, "retrofitBuilder");
        Intrinsics.f(deviceInfo, "deviceInfo");
        Intrinsics.f(languageManager, "languageManager");
        Intrinsics.f(tokenManager, "tokenManager");
        Intrinsics.f(verificationAnalytics, "verificationAnalytics");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f20985a = urlFactory;
        this.f20986b = retrofitBuilder;
        this.f20987c = deviceInfo;
        this.f20988d = languageManager;
        this.f20989e = tokenManager;
        this.f20990f = verificationAnalytics;
        this.f20991g = driverProvider;
    }

    public final void d(Application application) {
        Intrinsics.f(application, "application");
        IdentityVerificationSdk.f41584a.b(application, new StaticVerificationConfig(this.f20986b, this.f20985a.j(), this.f20987c.d(), this.f20987c.c(), this.f20987c.a()), new DynamicVerificationConfigProvider() { // from class: ee.mtakso.driver.identity.verification.PartnerIdentityVerificationInitializer$init$1
            @Override // eu.bolt.driver.verification.identity.config.DynamicVerificationConfigProvider
            public DynamicVerificationConfig a() {
                LanguageManager languageManager;
                PartnerTokenManager partnerTokenManager;
                DriverProvider driverProvider;
                String str;
                languageManager = PartnerIdentityVerificationInitializer.this.f20988d;
                String e8 = languageManager.e();
                partnerTokenManager = PartnerIdentityVerificationInitializer.this.f20989e;
                AccessToken c8 = partnerTokenManager.q().c();
                String str2 = (c8 == null || (str2 = c8.a()) == null) ? "" : "";
                driverProvider = PartnerIdentityVerificationInitializer.this.f20991g;
                DriverConfig d8 = driverProvider.d();
                if (d8 != null) {
                    str = d8.j();
                } else {
                    str = null;
                }
                return new DynamicVerificationConfig(e8, str2, str);
            }
        }, this.f20990f);
    }
}
