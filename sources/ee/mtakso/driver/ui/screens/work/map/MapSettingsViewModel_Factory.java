package ee.mtakso.driver.ui.screens.work.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.HeatmapAnalytics;
import ee.mtakso.driver.ui.interactor.map.GetMapSettingsInteractor;
import ee.mtakso.driver.ui.interactor.map.SetMapSettingsCategoryInteractor;
import ee.mtakso.driver.ui.interactor.map.SetMapSettingsHeatmapInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class MapSettingsViewModel_Factory implements Factory<MapSettingsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GetMapSettingsInteractor> f34178a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SetMapSettingsHeatmapInteractor> f34179b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SetMapSettingsCategoryInteractor> f34180c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<HeatmapAnalytics> f34181d;

    public MapSettingsViewModel_Factory(Provider<GetMapSettingsInteractor> provider, Provider<SetMapSettingsHeatmapInteractor> provider2, Provider<SetMapSettingsCategoryInteractor> provider3, Provider<HeatmapAnalytics> provider4) {
        this.f34178a = provider;
        this.f34179b = provider2;
        this.f34180c = provider3;
        this.f34181d = provider4;
    }

    public static MapSettingsViewModel_Factory a(Provider<GetMapSettingsInteractor> provider, Provider<SetMapSettingsHeatmapInteractor> provider2, Provider<SetMapSettingsCategoryInteractor> provider3, Provider<HeatmapAnalytics> provider4) {
        return new MapSettingsViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static MapSettingsViewModel c(GetMapSettingsInteractor getMapSettingsInteractor, SetMapSettingsHeatmapInteractor setMapSettingsHeatmapInteractor, SetMapSettingsCategoryInteractor setMapSettingsCategoryInteractor, HeatmapAnalytics heatmapAnalytics) {
        return new MapSettingsViewModel(getMapSettingsInteractor, setMapSettingsHeatmapInteractor, setMapSettingsCategoryInteractor, heatmapAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MapSettingsViewModel get() {
        return c(this.f34178a.get(), this.f34179b.get(), this.f34180c.get(), this.f34181d.get());
    }
}
