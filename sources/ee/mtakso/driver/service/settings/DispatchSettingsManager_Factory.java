package ee.mtakso.driver.service.settings;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.settings.SettingsClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DispatchSettingsManager_Factory implements Factory<DispatchSettingsManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<SettingsClient> f25968a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f25969b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SettingsAnalytics> f25970c;

    public DispatchSettingsManager_Factory(Provider<SettingsClient> provider, Provider<DriverProvider> provider2, Provider<SettingsAnalytics> provider3) {
        this.f25968a = provider;
        this.f25969b = provider2;
        this.f25970c = provider3;
    }

    public static DispatchSettingsManager_Factory a(Provider<SettingsClient> provider, Provider<DriverProvider> provider2, Provider<SettingsAnalytics> provider3) {
        return new DispatchSettingsManager_Factory(provider, provider2, provider3);
    }

    public static DispatchSettingsManager c(SettingsClient settingsClient, DriverProvider driverProvider, SettingsAnalytics settingsAnalytics) {
        return new DispatchSettingsManager(settingsClient, driverProvider, settingsAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DispatchSettingsManager get() {
        return c(this.f25968a.get(), this.f25969b.get(), this.f25970c.get());
    }
}
