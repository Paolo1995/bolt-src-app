package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.order.DriverOrderApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvideDriverOrderApiFactory implements Factory<DriverOrderApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20306a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20307b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20308c;

    public AuthorisedNetworkModule_ProvideDriverOrderApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20306a = authorisedNetworkModule;
        this.f20307b = provider;
        this.f20308c = provider2;
    }

    public static AuthorisedNetworkModule_ProvideDriverOrderApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvideDriverOrderApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static DriverOrderApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (DriverOrderApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.f(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverOrderApi get() {
        return c(this.f20306a, this.f20307b.get(), this.f20308c.get());
    }
}
