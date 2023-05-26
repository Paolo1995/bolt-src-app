package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.incident.IncidentReportingApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvidesIncidentReportingApiFactory implements Factory<IncidentReportingApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20845a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20846b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20847c;

    public NetworkModule_ProvidesIncidentReportingApiFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20845a = networkModule;
        this.f20846b = provider;
        this.f20847c = provider2;
    }

    public static NetworkModule_ProvidesIncidentReportingApiFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvidesIncidentReportingApiFactory(networkModule, provider, provider2);
    }

    public static IncidentReportingApi c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (IncidentReportingApi) Preconditions.checkNotNullFromProvides(networkModule.C(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public IncidentReportingApi get() {
        return c(this.f20845a, this.f20846b.get(), this.f20847c.get());
    }
}
