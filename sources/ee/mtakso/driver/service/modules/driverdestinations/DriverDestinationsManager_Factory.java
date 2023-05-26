package ee.mtakso.driver.service.modules.driverdestinations;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.fleet.FleetClient;
import ee.mtakso.driver.network.client.settings.SettingsClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.modules.status.DriverStatusSender;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverDestinationsManager_Factory implements Factory<DriverDestinationsManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<FleetClient> f24648a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SettingsClient> f24649b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f24650c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f24651d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverStatusSender> f24652e;

    public DriverDestinationsManager_Factory(Provider<FleetClient> provider, Provider<SettingsClient> provider2, Provider<DriverProvider> provider3, Provider<DriverStatusProvider> provider4, Provider<DriverStatusSender> provider5) {
        this.f24648a = provider;
        this.f24649b = provider2;
        this.f24650c = provider3;
        this.f24651d = provider4;
        this.f24652e = provider5;
    }

    public static DriverDestinationsManager_Factory a(Provider<FleetClient> provider, Provider<SettingsClient> provider2, Provider<DriverProvider> provider3, Provider<DriverStatusProvider> provider4, Provider<DriverStatusSender> provider5) {
        return new DriverDestinationsManager_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DriverDestinationsManager c(FleetClient fleetClient, SettingsClient settingsClient, DriverProvider driverProvider, DriverStatusProvider driverStatusProvider, DriverStatusSender driverStatusSender) {
        return new DriverDestinationsManager(fleetClient, settingsClient, driverProvider, driverStatusProvider, driverStatusSender);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverDestinationsManager get() {
        return c(this.f24648a.get(), this.f24649b.get(), this.f24650c.get(), this.f24651d.get(), this.f24652e.get());
    }
}
