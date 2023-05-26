package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.analytics.AnalyticsApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvidesEventApiFactory implements Factory<AnalyticsApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20837a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20838b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20839c;

    public NetworkModule_ProvidesEventApiFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20837a = networkModule;
        this.f20838b = provider;
        this.f20839c = provider2;
    }

    public static NetworkModule_ProvidesEventApiFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvidesEventApiFactory(networkModule, provider, provider2);
    }

    public static AnalyticsApi c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (AnalyticsApi) Preconditions.checkNotNullFromProvides(networkModule.z(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AnalyticsApi get() {
        return c(this.f20837a, this.f20838b.get(), this.f20839c.get());
    }
}
