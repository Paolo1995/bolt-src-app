package ee.mtakso.driver.service.modules.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class HeatmapOptionProvider_Factory implements Factory<HeatmapOptionProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HeatmapSettingManager> f24825a;

    public HeatmapOptionProvider_Factory(Provider<HeatmapSettingManager> provider) {
        this.f24825a = provider;
    }

    public static HeatmapOptionProvider_Factory a(Provider<HeatmapSettingManager> provider) {
        return new HeatmapOptionProvider_Factory(provider);
    }

    public static HeatmapOptionProvider c(HeatmapSettingManager heatmapSettingManager) {
        return new HeatmapOptionProvider(heatmapSettingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public HeatmapOptionProvider get() {
        return c(this.f24825a.get());
    }
}
