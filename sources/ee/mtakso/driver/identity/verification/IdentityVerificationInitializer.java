package ee.mtakso.driver.identity.verification;

import android.app.Application;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.network.client.auth.anonymous.AccessToken;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.token.TokenManager;
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

/* compiled from: IdentityVerificationInitializer.kt */
/* loaded from: classes3.dex */
public final class IdentityVerificationInitializer {

    /* renamed from: a  reason: collision with root package name */
    private final UrlFactory f20972a;

    /* renamed from: b  reason: collision with root package name */
    private final Retrofit.Builder f20973b;

    /* renamed from: c  reason: collision with root package name */
    private final DeviceInfo f20974c;

    /* renamed from: d  reason: collision with root package name */
    private final LanguageManager f20975d;

    /* renamed from: e  reason: collision with root package name */
    private final TokenManager f20976e;

    /* renamed from: f  reason: collision with root package name */
    private final VerificationAnalytics f20977f;

    /* renamed from: g  reason: collision with root package name */
    private final DriverProvider f20978g;

    @Inject
    public IdentityVerificationInitializer(UrlFactory urlFactory, Retrofit.Builder retrofitBuilder, DeviceInfo deviceInfo, LanguageManager languageManager, TokenManager tokenManager, VerificationAnalytics verificationAnalytics, DriverProvider driverProvider) {
        Intrinsics.f(urlFactory, "urlFactory");
        Intrinsics.f(retrofitBuilder, "retrofitBuilder");
        Intrinsics.f(deviceInfo, "deviceInfo");
        Intrinsics.f(languageManager, "languageManager");
        Intrinsics.f(tokenManager, "tokenManager");
        Intrinsics.f(verificationAnalytics, "verificationAnalytics");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f20972a = urlFactory;
        this.f20973b = retrofitBuilder;
        this.f20974c = deviceInfo;
        this.f20975d = languageManager;
        this.f20976e = tokenManager;
        this.f20977f = verificationAnalytics;
        this.f20978g = driverProvider;
    }

    public final void d(Application application) {
        Intrinsics.f(application, "application");
        IdentityVerificationSdk.f41584a.b(application, new StaticVerificationConfig(this.f20973b, this.f20972a.q(), this.f20974c.d(), this.f20974c.c(), this.f20974c.a()), new DynamicVerificationConfigProvider() { // from class: ee.mtakso.driver.identity.verification.IdentityVerificationInitializer$init$1
            @Override // eu.bolt.driver.verification.identity.config.DynamicVerificationConfigProvider
            public DynamicVerificationConfig a() {
                LanguageManager languageManager;
                TokenManager tokenManager;
                DriverProvider driverProvider;
                String str;
                languageManager = IdentityVerificationInitializer.this.f20975d;
                String e8 = languageManager.e();
                tokenManager = IdentityVerificationInitializer.this.f20976e;
                AccessToken c8 = tokenManager.q().c();
                String str2 = (c8 == null || (str2 = c8.a()) == null) ? "" : "";
                driverProvider = IdentityVerificationInitializer.this.f20978g;
                DriverConfig d8 = driverProvider.d();
                if (d8 != null) {
                    str = d8.j();
                } else {
                    str = null;
                }
                return new DynamicVerificationConfig(e8, str2, str);
            }
        }, this.f20977f);
    }
}
