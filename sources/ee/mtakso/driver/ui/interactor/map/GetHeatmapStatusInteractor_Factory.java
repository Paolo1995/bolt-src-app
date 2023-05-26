package ee.mtakso.driver.ui.interactor.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.modules.map.HeatmapOptionProvider;
import ee.mtakso.driver.service.modules.map.MapsConfigsService;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GetHeatmapStatusInteractor_Factory implements Factory<GetHeatmapStatusInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HeatmapOptionProvider> f26621a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MapsConfigsService> f26622b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverImageMapper> f26623c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverFeatures> f26624d;

    public GetHeatmapStatusInteractor_Factory(Provider<HeatmapOptionProvider> provider, Provider<MapsConfigsService> provider2, Provider<DriverImageMapper> provider3, Provider<DriverFeatures> provider4) {
        this.f26621a = provider;
        this.f26622b = provider2;
        this.f26623c = provider3;
        this.f26624d = provider4;
    }

    public static GetHeatmapStatusInteractor_Factory a(Provider<HeatmapOptionProvider> provider, Provider<MapsConfigsService> provider2, Provider<DriverImageMapper> provider3, Provider<DriverFeatures> provider4) {
        return new GetHeatmapStatusInteractor_Factory(provider, provider2, provider3, provider4);
    }

    public static GetHeatmapStatusInteractor c(HeatmapOptionProvider heatmapOptionProvider, MapsConfigsService mapsConfigsService, DriverImageMapper driverImageMapper, DriverFeatures driverFeatures) {
        return new GetHeatmapStatusInteractor(heatmapOptionProvider, mapsConfigsService, driverImageMapper, driverFeatures);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GetHeatmapStatusInteractor get() {
        return c(this.f26621a.get(), this.f26622b.get(), this.f26623c.get(), this.f26624d.get());
    }
}
