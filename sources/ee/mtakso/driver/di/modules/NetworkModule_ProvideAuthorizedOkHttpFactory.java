package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.ClientFactory;
import ee.mtakso.driver.network.interceptor.AccessTokenInterceptor;
import ee.mtakso.driver.network.interceptor.LocationInterceptor;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvideAuthorizedOkHttpFactory implements Factory<OkHttpClient> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20772a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ClientFactory> f20773b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OkHttpClient> f20774c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<LocationInterceptor> f20775d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<AccessTokenInterceptor> f20776e;

    public NetworkModule_ProvideAuthorizedOkHttpFactory(NetworkModule networkModule, Provider<ClientFactory> provider, Provider<OkHttpClient> provider2, Provider<LocationInterceptor> provider3, Provider<AccessTokenInterceptor> provider4) {
        this.f20772a = networkModule;
        this.f20773b = provider;
        this.f20774c = provider2;
        this.f20775d = provider3;
        this.f20776e = provider4;
    }

    public static NetworkModule_ProvideAuthorizedOkHttpFactory a(NetworkModule networkModule, Provider<ClientFactory> provider, Provider<OkHttpClient> provider2, Provider<LocationInterceptor> provider3, Provider<AccessTokenInterceptor> provider4) {
        return new NetworkModule_ProvideAuthorizedOkHttpFactory(networkModule, provider, provider2, provider3, provider4);
    }

    public static OkHttpClient c(NetworkModule networkModule, ClientFactory clientFactory, OkHttpClient okHttpClient, LocationInterceptor locationInterceptor, AccessTokenInterceptor accessTokenInterceptor) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(networkModule.c(clientFactory, okHttpClient, locationInterceptor, accessTokenInterceptor));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OkHttpClient get() {
        return c(this.f20772a, this.f20773b.get(), this.f20774c.get(), this.f20775d.get(), this.f20776e.get());
    }
}
