package ee.mtakso.driver.ui.interactor.network_usage;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.usage.NetworkUsageManager;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.AppPerformanceAnalytics;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NetworkUsageUploadInteractor_Factory implements Factory<NetworkUsageUploadInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f26687a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DeviceSettings> f26688b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AppPerformanceAnalytics> f26689c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<NetworkUsageManager> f26690d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<TrueTimeProvider> f26691e;

    public NetworkUsageUploadInteractor_Factory(Provider<DriverProvider> provider, Provider<DeviceSettings> provider2, Provider<AppPerformanceAnalytics> provider3, Provider<NetworkUsageManager> provider4, Provider<TrueTimeProvider> provider5) {
        this.f26687a = provider;
        this.f26688b = provider2;
        this.f26689c = provider3;
        this.f26690d = provider4;
        this.f26691e = provider5;
    }

    public static NetworkUsageUploadInteractor_Factory a(Provider<DriverProvider> provider, Provider<DeviceSettings> provider2, Provider<AppPerformanceAnalytics> provider3, Provider<NetworkUsageManager> provider4, Provider<TrueTimeProvider> provider5) {
        return new NetworkUsageUploadInteractor_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static NetworkUsageUploadInteractor c(DriverProvider driverProvider, DeviceSettings deviceSettings, AppPerformanceAnalytics appPerformanceAnalytics, NetworkUsageManager networkUsageManager, TrueTimeProvider trueTimeProvider) {
        return new NetworkUsageUploadInteractor(driverProvider, deviceSettings, appPerformanceAnalytics, networkUsageManager, trueTimeProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NetworkUsageUploadInteractor get() {
        return c(this.f26687a.get(), this.f26688b.get(), this.f26689c.get(), this.f26690d.get(), this.f26691e.get());
    }
}
