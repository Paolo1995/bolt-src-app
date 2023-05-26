package ee.mtakso.driver.network.client.applog;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.param.DriverProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ApplogParamsInterceptor_Factory implements Factory<ApplogParamsInterceptor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeviceInfo> f21365a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f21366b;

    public ApplogParamsInterceptor_Factory(Provider<DeviceInfo> provider, Provider<DriverProvider> provider2) {
        this.f21365a = provider;
        this.f21366b = provider2;
    }

    public static ApplogParamsInterceptor_Factory a(Provider<DeviceInfo> provider, Provider<DriverProvider> provider2) {
        return new ApplogParamsInterceptor_Factory(provider, provider2);
    }

    public static ApplogParamsInterceptor c(DeviceInfo deviceInfo, DriverProvider driverProvider) {
        return new ApplogParamsInterceptor(deviceInfo, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ApplogParamsInterceptor get() {
        return c(this.f21365a.get(), this.f21366b.get());
    }
}
