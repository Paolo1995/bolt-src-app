package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import eu.bolt.driver.earnings.network.EarningsBalanceApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvideEarningsBalanceApiFactory implements Factory<EarningsBalanceApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20792a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20793b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20794c;

    public NetworkModule_ProvideEarningsBalanceApiFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20792a = networkModule;
        this.f20793b = provider;
        this.f20794c = provider2;
    }

    public static NetworkModule_ProvideEarningsBalanceApiFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvideEarningsBalanceApiFactory(networkModule, provider, provider2);
    }

    public static EarningsBalanceApi c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (EarningsBalanceApi) Preconditions.checkNotNullFromProvides(networkModule.i(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsBalanceApi get() {
        return c(this.f20792a, this.f20793b.get(), this.f20794c.get());
    }
}
