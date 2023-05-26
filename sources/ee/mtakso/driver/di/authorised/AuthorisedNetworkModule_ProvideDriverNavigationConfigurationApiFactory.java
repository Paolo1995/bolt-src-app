package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.driver.navigation.DriverNavigationConfigurationApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvideDriverNavigationConfigurationApiFactory implements Factory<DriverNavigationConfigurationApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20303a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20304b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20305c;

    public AuthorisedNetworkModule_ProvideDriverNavigationConfigurationApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20303a = authorisedNetworkModule;
        this.f20304b = provider;
        this.f20305c = provider2;
    }

    public static AuthorisedNetworkModule_ProvideDriverNavigationConfigurationApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvideDriverNavigationConfigurationApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static DriverNavigationConfigurationApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (DriverNavigationConfigurationApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.e(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverNavigationConfigurationApi get() {
        return c(this.f20303a, this.f20304b.get(), this.f20305c.get());
    }
}
