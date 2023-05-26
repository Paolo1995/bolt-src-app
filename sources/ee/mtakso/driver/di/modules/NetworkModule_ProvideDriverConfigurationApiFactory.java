package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.driver.DriverConfigurationApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvideDriverConfigurationApiFactory implements Factory<DriverConfigurationApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20786a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20787b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20788c;

    public NetworkModule_ProvideDriverConfigurationApiFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20786a = networkModule;
        this.f20787b = provider;
        this.f20788c = provider2;
    }

    public static NetworkModule_ProvideDriverConfigurationApiFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvideDriverConfigurationApiFactory(networkModule, provider, provider2);
    }

    public static DriverConfigurationApi c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (DriverConfigurationApi) Preconditions.checkNotNullFromProvides(networkModule.g(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverConfigurationApi get() {
        return c(this.f20786a, this.f20787b.get(), this.f20788c.get());
    }
}
