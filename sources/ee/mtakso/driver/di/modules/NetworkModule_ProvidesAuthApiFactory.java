package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvidesAuthApiFactory implements Factory<AuthenticatedAuthApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20825a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20826b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20827c;

    public NetworkModule_ProvidesAuthApiFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20825a = networkModule;
        this.f20826b = provider;
        this.f20827c = provider2;
    }

    public static NetworkModule_ProvidesAuthApiFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvidesAuthApiFactory(networkModule, provider, provider2);
    }

    public static AuthenticatedAuthApi c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (AuthenticatedAuthApi) Preconditions.checkNotNullFromProvides(networkModule.v(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AuthenticatedAuthApi get() {
        return c(this.f20825a, this.f20826b.get(), this.f20827c.get());
    }
}
