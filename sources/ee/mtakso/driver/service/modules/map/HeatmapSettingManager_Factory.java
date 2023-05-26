package ee.mtakso.driver.service.modules.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverSettings;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class HeatmapSettingManager_Factory implements Factory<HeatmapSettingManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverSettings> f24834a;

    public HeatmapSettingManager_Factory(Provider<DriverSettings> provider) {
        this.f24834a = provider;
    }

    public static HeatmapSettingManager_Factory a(Provider<DriverSettings> provider) {
        return new HeatmapSettingManager_Factory(provider);
    }

    public static HeatmapSettingManager c(DriverSettings driverSettings) {
        return new HeatmapSettingManager(driverSettings);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public HeatmapSettingManager get() {
        return c(this.f24834a.get());
    }
}
