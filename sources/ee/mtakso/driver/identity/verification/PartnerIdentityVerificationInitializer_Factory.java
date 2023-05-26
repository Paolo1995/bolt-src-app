package ee.mtakso.driver.identity.verification;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.token.PartnerTokenManager;
import ee.mtakso.driver.utils.UrlFactory;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import eu.bolt.driver.verification.identity.VerificationAnalytics;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.PartnerAuthorized"})
/* loaded from: classes3.dex */
public final class PartnerIdentityVerificationInitializer_Factory implements Factory<PartnerIdentityVerificationInitializer> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<UrlFactory> f20993a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Retrofit.Builder> f20994b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DeviceInfo> f20995c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<LanguageManager> f20996d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<PartnerTokenManager> f20997e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<VerificationAnalytics> f20998f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<DriverProvider> f20999g;

    public PartnerIdentityVerificationInitializer_Factory(Provider<UrlFactory> provider, Provider<Retrofit.Builder> provider2, Provider<DeviceInfo> provider3, Provider<LanguageManager> provider4, Provider<PartnerTokenManager> provider5, Provider<VerificationAnalytics> provider6, Provider<DriverProvider> provider7) {
        this.f20993a = provider;
        this.f20994b = provider2;
        this.f20995c = provider3;
        this.f20996d = provider4;
        this.f20997e = provider5;
        this.f20998f = provider6;
        this.f20999g = provider7;
    }

    public static PartnerIdentityVerificationInitializer_Factory a(Provider<UrlFactory> provider, Provider<Retrofit.Builder> provider2, Provider<DeviceInfo> provider3, Provider<LanguageManager> provider4, Provider<PartnerTokenManager> provider5, Provider<VerificationAnalytics> provider6, Provider<DriverProvider> provider7) {
        return new PartnerIdentityVerificationInitializer_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static PartnerIdentityVerificationInitializer c(UrlFactory urlFactory, Retrofit.Builder builder, DeviceInfo deviceInfo, LanguageManager languageManager, PartnerTokenManager partnerTokenManager, VerificationAnalytics verificationAnalytics, DriverProvider driverProvider) {
        return new PartnerIdentityVerificationInitializer(urlFactory, builder, deviceInfo, languageManager, partnerTokenManager, verificationAnalytics, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PartnerIdentityVerificationInitializer get() {
        return c(this.f20993a.get(), this.f20994b.get(), this.f20995c.get(), this.f20996d.get(), this.f20997e.get(), this.f20998f.get(), this.f20999g.get());
    }
}
