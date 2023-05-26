package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.analytics.LeadAnalyticsApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Unauthorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvidesLeadEventApiFactory implements Factory<LeadAnalyticsApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20848a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20849b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20850c;

    public NetworkModule_ProvidesLeadEventApiFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20848a = networkModule;
        this.f20849b = provider;
        this.f20850c = provider2;
    }

    public static NetworkModule_ProvidesLeadEventApiFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvidesLeadEventApiFactory(networkModule, provider, provider2);
    }

    public static LeadAnalyticsApi c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (LeadAnalyticsApi) Preconditions.checkNotNullFromProvides(networkModule.D(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LeadAnalyticsApi get() {
        return c(this.f20848a, this.f20849b.get(), this.f20850c.get());
    }
}
