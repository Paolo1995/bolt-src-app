package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import eu.bolt.driver.earnings.network.EarningsGoalApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvideEarningsGoalApiFactory implements Factory<EarningsGoalApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20795a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20796b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20797c;

    public NetworkModule_ProvideEarningsGoalApiFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20795a = networkModule;
        this.f20796b = provider;
        this.f20797c = provider2;
    }

    public static NetworkModule_ProvideEarningsGoalApiFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvideEarningsGoalApiFactory(networkModule, provider, provider2);
    }

    public static EarningsGoalApi c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (EarningsGoalApi) Preconditions.checkNotNullFromProvides(networkModule.j(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsGoalApi get() {
        return c(this.f20795a, this.f20796b.get(), this.f20797c.get());
    }
}
