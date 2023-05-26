package ee.mtakso.driver.ui.interactor.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.map.HeatmapSettingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SetMapSettingsHeatmapInteractor_Factory implements Factory<SetMapSettingsHeatmapInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HeatmapSettingManager> f26655a;

    public SetMapSettingsHeatmapInteractor_Factory(Provider<HeatmapSettingManager> provider) {
        this.f26655a = provider;
    }

    public static SetMapSettingsHeatmapInteractor_Factory a(Provider<HeatmapSettingManager> provider) {
        return new SetMapSettingsHeatmapInteractor_Factory(provider);
    }

    public static SetMapSettingsHeatmapInteractor c(HeatmapSettingManager heatmapSettingManager) {
        return new SetMapSettingsHeatmapInteractor(heatmapSettingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SetMapSettingsHeatmapInteractor get() {
        return c(this.f26655a.get());
    }
}
