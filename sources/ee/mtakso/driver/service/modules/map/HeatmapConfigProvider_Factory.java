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
public final class HeatmapConfigProvider_Factory implements Factory<HeatmapConfigProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HeatmapSettingManager> f24819a;

    public HeatmapConfigProvider_Factory(Provider<HeatmapSettingManager> provider) {
        this.f24819a = provider;
    }

    public static HeatmapConfigProvider_Factory a(Provider<HeatmapSettingManager> provider) {
        return new HeatmapConfigProvider_Factory(provider);
    }

    public static HeatmapConfigProvider c(HeatmapSettingManager heatmapSettingManager) {
        return new HeatmapConfigProvider(heatmapSettingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public HeatmapConfigProvider get() {
        return c(this.f24819a.get());
    }
}
