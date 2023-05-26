package ee.mtakso.driver.service.modules.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class HeatmapSettingService_Factory implements Factory<HeatmapSettingService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchSettingsManager> f24843a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MapsConfigsService> f24844b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<HeatmapSettingManager> f24845c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverFeatures> f24846d;

    public HeatmapSettingService_Factory(Provider<DispatchSettingsManager> provider, Provider<MapsConfigsService> provider2, Provider<HeatmapSettingManager> provider3, Provider<DriverFeatures> provider4) {
        this.f24843a = provider;
        this.f24844b = provider2;
        this.f24845c = provider3;
        this.f24846d = provider4;
    }

    public static HeatmapSettingService_Factory a(Provider<DispatchSettingsManager> provider, Provider<MapsConfigsService> provider2, Provider<HeatmapSettingManager> provider3, Provider<DriverFeatures> provider4) {
        return new HeatmapSettingService_Factory(provider, provider2, provider3, provider4);
    }

    public static HeatmapSettingService c(DispatchSettingsManager dispatchSettingsManager, MapsConfigsService mapsConfigsService, HeatmapSettingManager heatmapSettingManager, DriverFeatures driverFeatures) {
        return new HeatmapSettingService(dispatchSettingsManager, mapsConfigsService, heatmapSettingManager, driverFeatures);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public HeatmapSettingService get() {
        return c(this.f24843a.get(), this.f24844b.get(), this.f24845c.get(), this.f24846d.get());
    }
}
