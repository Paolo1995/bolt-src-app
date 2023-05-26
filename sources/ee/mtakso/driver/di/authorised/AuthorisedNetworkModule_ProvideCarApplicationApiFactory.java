package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.vehicle.CarApplicationApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvideCarApplicationApiFactory implements Factory<CarApplicationApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20300a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20301b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20302c;

    public AuthorisedNetworkModule_ProvideCarApplicationApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20300a = authorisedNetworkModule;
        this.f20301b = provider;
        this.f20302c = provider2;
    }

    public static AuthorisedNetworkModule_ProvideCarApplicationApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvideCarApplicationApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static CarApplicationApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (CarApplicationApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.d(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CarApplicationApi get() {
        return c(this.f20300a, this.f20301b.get(), this.f20302c.get());
    }
}
