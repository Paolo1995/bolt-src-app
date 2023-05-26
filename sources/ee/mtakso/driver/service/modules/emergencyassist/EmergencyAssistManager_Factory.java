package ee.mtakso.driver.service.modules.emergencyassist;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.emergencyassist.EmergencyAssistClient;
import ee.mtakso.driver.network.client.vehicle.CarApplicationClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.order.details.OrderProvider;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EmergencyAssistManager_Factory implements Factory<EmergencyAssistManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EmergencyAssistClient> f24704a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CarApplicationClient> f24705b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<GeoLocationManager> f24706c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverProvider> f24707d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<OrderProvider> f24708e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<DriverSettings> f24709f;

    public EmergencyAssistManager_Factory(Provider<EmergencyAssistClient> provider, Provider<CarApplicationClient> provider2, Provider<GeoLocationManager> provider3, Provider<DriverProvider> provider4, Provider<OrderProvider> provider5, Provider<DriverSettings> provider6) {
        this.f24704a = provider;
        this.f24705b = provider2;
        this.f24706c = provider3;
        this.f24707d = provider4;
        this.f24708e = provider5;
        this.f24709f = provider6;
    }

    public static EmergencyAssistManager_Factory a(Provider<EmergencyAssistClient> provider, Provider<CarApplicationClient> provider2, Provider<GeoLocationManager> provider3, Provider<DriverProvider> provider4, Provider<OrderProvider> provider5, Provider<DriverSettings> provider6) {
        return new EmergencyAssistManager_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static EmergencyAssistManager c(EmergencyAssistClient emergencyAssistClient, CarApplicationClient carApplicationClient, GeoLocationManager geoLocationManager, DriverProvider driverProvider, OrderProvider orderProvider, DriverSettings driverSettings) {
        return new EmergencyAssistManager(emergencyAssistClient, carApplicationClient, geoLocationManager, driverProvider, orderProvider, driverSettings);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EmergencyAssistManager get() {
        return c(this.f24704a.get(), this.f24705b.get(), this.f24706c.get(), this.f24707d.get(), this.f24708e.get(), this.f24709f.get());
    }
}
