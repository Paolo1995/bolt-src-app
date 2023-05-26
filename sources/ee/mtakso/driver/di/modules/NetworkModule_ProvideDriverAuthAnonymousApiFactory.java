package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.auth.anonymous.DriverAuthAnonymousApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Unauthorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvideDriverAuthAnonymousApiFactory implements Factory<DriverAuthAnonymousApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20783a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ApiFactory> f20784b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OkHttpClient> f20785c;

    public NetworkModule_ProvideDriverAuthAnonymousApiFactory(NetworkModule networkModule, Provider<ApiFactory> provider, Provider<OkHttpClient> provider2) {
        this.f20783a = networkModule;
        this.f20784b = provider;
        this.f20785c = provider2;
    }

    public static NetworkModule_ProvideDriverAuthAnonymousApiFactory a(NetworkModule networkModule, Provider<ApiFactory> provider, Provider<OkHttpClient> provider2) {
        return new NetworkModule_ProvideDriverAuthAnonymousApiFactory(networkModule, provider, provider2);
    }

    public static DriverAuthAnonymousApi c(NetworkModule networkModule, ApiFactory apiFactory, OkHttpClient okHttpClient) {
        return (DriverAuthAnonymousApi) Preconditions.checkNotNullFromProvides(networkModule.f(apiFactory, okHttpClient));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverAuthAnonymousApi get() {
        return c(this.f20783a, this.f20784b.get(), this.f20785c.get());
    }
}
