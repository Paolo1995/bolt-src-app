package ee.mtakso.driver.service.thirdparty_incident;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ThirdPartyIncidentService_Factory implements Factory<ThirdPartyIncidentService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EmergencyAssistManager> f26015a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverSettings> f26016b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f26017c;

    public ThirdPartyIncidentService_Factory(Provider<EmergencyAssistManager> provider, Provider<DriverSettings> provider2, Provider<DriverProvider> provider3) {
        this.f26015a = provider;
        this.f26016b = provider2;
        this.f26017c = provider3;
    }

    public static ThirdPartyIncidentService_Factory a(Provider<EmergencyAssistManager> provider, Provider<DriverSettings> provider2, Provider<DriverProvider> provider3) {
        return new ThirdPartyIncidentService_Factory(provider, provider2, provider3);
    }

    public static ThirdPartyIncidentService c(EmergencyAssistManager emergencyAssistManager, DriverSettings driverSettings, DriverProvider driverProvider) {
        return new ThirdPartyIncidentService(emergencyAssistManager, driverSettings, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ThirdPartyIncidentService get() {
        return c(this.f26015a.get(), this.f26016b.get(), this.f26017c.get());
    }
}
