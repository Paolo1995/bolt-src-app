package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.applog.DriverAppLogAnonymousApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Applog"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvideDriverAppLogAnonymousApiFactory implements Factory<DriverAppLogAnonymousApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20780a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20781b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20782c;

    public NetworkModule_ProvideDriverAppLogAnonymousApiFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20780a = networkModule;
        this.f20781b = provider;
        this.f20782c = provider2;
    }

    public static NetworkModule_ProvideDriverAppLogAnonymousApiFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvideDriverAppLogAnonymousApiFactory(networkModule, provider, provider2);
    }

    public static DriverAppLogAnonymousApi c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (DriverAppLogAnonymousApi) Preconditions.checkNotNullFromProvides(networkModule.e(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverAppLogAnonymousApi get() {
        return c(this.f20780a, this.f20781b.get(), this.f20782c.get());
    }
}
