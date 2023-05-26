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
public final class SetMapSettingsCategoryInteractor_Factory implements Factory<SetMapSettingsCategoryInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HeatmapSettingManager> f26653a;

    public SetMapSettingsCategoryInteractor_Factory(Provider<HeatmapSettingManager> provider) {
        this.f26653a = provider;
    }

    public static SetMapSettingsCategoryInteractor_Factory a(Provider<HeatmapSettingManager> provider) {
        return new SetMapSettingsCategoryInteractor_Factory(provider);
    }

    public static SetMapSettingsCategoryInteractor c(HeatmapSettingManager heatmapSettingManager) {
        return new SetMapSettingsCategoryInteractor(heatmapSettingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SetMapSettingsCategoryInteractor get() {
        return c(this.f26653a.get());
    }
}
