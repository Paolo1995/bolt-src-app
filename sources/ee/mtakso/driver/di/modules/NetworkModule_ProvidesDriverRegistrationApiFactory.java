package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.registration.DriverRegistrationApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Unauthorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvidesDriverRegistrationApiFactory implements Factory<DriverRegistrationApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20834a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20835b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20836c;

    public NetworkModule_ProvidesDriverRegistrationApiFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20834a = networkModule;
        this.f20835b = provider;
        this.f20836c = provider2;
    }

    public static NetworkModule_ProvidesDriverRegistrationApiFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvidesDriverRegistrationApiFactory(networkModule, provider, provider2);
    }

    public static DriverRegistrationApi c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (DriverRegistrationApi) Preconditions.checkNotNullFromProvides(networkModule.y(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverRegistrationApi get() {
        return c(this.f20834a, this.f20835b.get(), this.f20836c.get());
    }
}
