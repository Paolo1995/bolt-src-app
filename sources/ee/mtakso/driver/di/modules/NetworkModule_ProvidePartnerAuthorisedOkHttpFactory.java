package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.ClientFactory;
import ee.mtakso.driver.network.interceptor.PartnerAccessTokenInterceptor;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.PartnerAuthorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvidePartnerAuthorisedOkHttpFactory implements Factory<OkHttpClient> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20804a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ClientFactory> f20805b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OkHttpClient> f20806c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PartnerAccessTokenInterceptor> f20807d;

    public NetworkModule_ProvidePartnerAuthorisedOkHttpFactory(NetworkModule networkModule, Provider<ClientFactory> provider, Provider<OkHttpClient> provider2, Provider<PartnerAccessTokenInterceptor> provider3) {
        this.f20804a = networkModule;
        this.f20805b = provider;
        this.f20806c = provider2;
        this.f20807d = provider3;
    }

    public static NetworkModule_ProvidePartnerAuthorisedOkHttpFactory a(NetworkModule networkModule, Provider<ClientFactory> provider, Provider<OkHttpClient> provider2, Provider<PartnerAccessTokenInterceptor> provider3) {
        return new NetworkModule_ProvidePartnerAuthorisedOkHttpFactory(networkModule, provider, provider2, provider3);
    }

    public static OkHttpClient c(NetworkModule networkModule, ClientFactory clientFactory, OkHttpClient okHttpClient, PartnerAccessTokenInterceptor partnerAccessTokenInterceptor) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(networkModule.n(clientFactory, okHttpClient, partnerAccessTokenInterceptor));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OkHttpClient get() {
        return c(this.f20804a, this.f20805b.get(), this.f20806c.get(), this.f20807d.get());
    }
}
