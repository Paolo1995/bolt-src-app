package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.device.DeviceInfoApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvidesDeviceInfoApiFactory implements Factory<DeviceInfoApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20831a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20832b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20833c;

    public NetworkModule_ProvidesDeviceInfoApiFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20831a = networkModule;
        this.f20832b = provider;
        this.f20833c = provider2;
    }

    public static NetworkModule_ProvidesDeviceInfoApiFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvidesDeviceInfoApiFactory(networkModule, provider, provider2);
    }

    public static DeviceInfoApi c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (DeviceInfoApi) Preconditions.checkNotNullFromProvides(networkModule.x(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DeviceInfoApi get() {
        return c(this.f20831a, this.f20832b.get(), this.f20833c.get());
    }
}
