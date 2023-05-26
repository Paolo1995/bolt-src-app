package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Unauthorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvidesApiWithoutAuthenticationFactory implements Factory<AnonymousAuthApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20822a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ApiFactory> f20823b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OkHttpClient> f20824c;

    public NetworkModule_ProvidesApiWithoutAuthenticationFactory(NetworkModule networkModule, Provider<ApiFactory> provider, Provider<OkHttpClient> provider2) {
        this.f20822a = networkModule;
        this.f20823b = provider;
        this.f20824c = provider2;
    }

    public static NetworkModule_ProvidesApiWithoutAuthenticationFactory a(NetworkModule networkModule, Provider<ApiFactory> provider, Provider<OkHttpClient> provider2) {
        return new NetworkModule_ProvidesApiWithoutAuthenticationFactory(networkModule, provider, provider2);
    }

    public static AnonymousAuthApi c(NetworkModule networkModule, ApiFactory apiFactory, OkHttpClient okHttpClient) {
        return (AnonymousAuthApi) Preconditions.checkNotNullFromProvides(networkModule.u(apiFactory, okHttpClient));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AnonymousAuthApi get() {
        return c(this.f20822a, this.f20823b.get(), this.f20824c.get());
    }
}
