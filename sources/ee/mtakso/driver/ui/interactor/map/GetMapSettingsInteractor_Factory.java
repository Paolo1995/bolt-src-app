package ee.mtakso.driver.ui.interactor.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.map.HeatmapOptionProvider;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GetMapSettingsInteractor_Factory implements Factory<GetMapSettingsInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HeatmapOptionProvider> f26632a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverImageMapper> f26633b;

    public GetMapSettingsInteractor_Factory(Provider<HeatmapOptionProvider> provider, Provider<DriverImageMapper> provider2) {
        this.f26632a = provider;
        this.f26633b = provider2;
    }

    public static GetMapSettingsInteractor_Factory a(Provider<HeatmapOptionProvider> provider, Provider<DriverImageMapper> provider2) {
        return new GetMapSettingsInteractor_Factory(provider, provider2);
    }

    public static GetMapSettingsInteractor c(HeatmapOptionProvider heatmapOptionProvider, DriverImageMapper driverImageMapper) {
        return new GetMapSettingsInteractor(heatmapOptionProvider, driverImageMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GetMapSettingsInteractor get() {
        return c(this.f26632a.get(), this.f26633b.get());
    }
}
