package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.driver.DriverPricingConfigurationApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvideDriverPricingConfigurationApiFactory implements Factory<DriverPricingConfigurationApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20309a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20310b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20311c;

    public AuthorisedNetworkModule_ProvideDriverPricingConfigurationApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20309a = authorisedNetworkModule;
        this.f20310b = provider;
        this.f20311c = provider2;
    }

    public static AuthorisedNetworkModule_ProvideDriverPricingConfigurationApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvideDriverPricingConfigurationApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static DriverPricingConfigurationApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (DriverPricingConfigurationApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.g(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverPricingConfigurationApi get() {
        return c(this.f20309a, this.f20310b.get(), this.f20311c.get());
    }
}
