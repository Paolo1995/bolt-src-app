package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.driver.WaybillApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvideWaybillApiFactory implements Factory<WaybillApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20324a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20325b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20326c;

    public AuthorisedNetworkModule_ProvideWaybillApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20324a = authorisedNetworkModule;
        this.f20325b = provider;
        this.f20326c = provider2;
    }

    public static AuthorisedNetworkModule_ProvideWaybillApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvideWaybillApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static WaybillApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (WaybillApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.l(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WaybillApi get() {
        return c(this.f20324a, this.f20325b.get(), this.f20326c.get());
    }
}
