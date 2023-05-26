package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.partner.PartnerApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.PartnerAuthorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvidesApiPartnerAuthenticationFactory implements Factory<PartnerApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20819a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ApiFactory> f20820b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OkHttpClient> f20821c;

    public NetworkModule_ProvidesApiPartnerAuthenticationFactory(NetworkModule networkModule, Provider<ApiFactory> provider, Provider<OkHttpClient> provider2) {
        this.f20819a = networkModule;
        this.f20820b = provider;
        this.f20821c = provider2;
    }

    public static NetworkModule_ProvidesApiPartnerAuthenticationFactory a(NetworkModule networkModule, Provider<ApiFactory> provider, Provider<OkHttpClient> provider2) {
        return new NetworkModule_ProvidesApiPartnerAuthenticationFactory(networkModule, provider, provider2);
    }

    public static PartnerApi c(NetworkModule networkModule, ApiFactory apiFactory, OkHttpClient okHttpClient) {
        return (PartnerApi) Preconditions.checkNotNullFromProvides(networkModule.t(apiFactory, okHttpClient));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PartnerApi get() {
        return c(this.f20819a, this.f20820b.get(), this.f20821c.get());
    }
}
