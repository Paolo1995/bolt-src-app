package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.work_time.DriverWorkTimeApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvideDriverWorkTimeApiFactory implements Factory<DriverWorkTimeApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20789a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20790b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20791c;

    public NetworkModule_ProvideDriverWorkTimeApiFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20789a = networkModule;
        this.f20790b = provider;
        this.f20791c = provider2;
    }

    public static NetworkModule_ProvideDriverWorkTimeApiFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvideDriverWorkTimeApiFactory(networkModule, provider, provider2);
    }

    public static DriverWorkTimeApi c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (DriverWorkTimeApi) Preconditions.checkNotNullFromProvides(networkModule.h(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverWorkTimeApi get() {
        return c(this.f20789a, this.f20790b.get(), this.f20791c.get());
    }
}
