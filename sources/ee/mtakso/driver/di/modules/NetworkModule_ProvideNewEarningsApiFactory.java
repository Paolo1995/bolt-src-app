package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import eu.bolt.driver.earnings.network.EarningsApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvideNewEarningsApiFactory implements Factory<EarningsApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20801a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20802b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20803c;

    public NetworkModule_ProvideNewEarningsApiFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20801a = networkModule;
        this.f20802b = provider;
        this.f20803c = provider2;
    }

    public static NetworkModule_ProvideNewEarningsApiFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvideNewEarningsApiFactory(networkModule, provider, provider2);
    }

    public static EarningsApi c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (EarningsApi) Preconditions.checkNotNullFromProvides(networkModule.m(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsApi get() {
        return c(this.f20801a, this.f20802b.get(), this.f20803c.get());
    }
}
