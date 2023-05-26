package ee.mtakso.driver.ui.interactor.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.modules.map.HeatmapConfigProvider;
import ee.mtakso.driver.ui.interactor.driver.surge.SurgeInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GetHeatmapInteractor_Factory implements Factory<GetHeatmapInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverFeatures> f26612a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SurgeInteractor> f26613b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<HeatmapConfigProvider> f26614c;

    public GetHeatmapInteractor_Factory(Provider<DriverFeatures> provider, Provider<SurgeInteractor> provider2, Provider<HeatmapConfigProvider> provider3) {
        this.f26612a = provider;
        this.f26613b = provider2;
        this.f26614c = provider3;
    }

    public static GetHeatmapInteractor_Factory a(Provider<DriverFeatures> provider, Provider<SurgeInteractor> provider2, Provider<HeatmapConfigProvider> provider3) {
        return new GetHeatmapInteractor_Factory(provider, provider2, provider3);
    }

    public static GetHeatmapInteractor c(DriverFeatures driverFeatures, SurgeInteractor surgeInteractor, HeatmapConfigProvider heatmapConfigProvider) {
        return new GetHeatmapInteractor(driverFeatures, surgeInteractor, heatmapConfigProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GetHeatmapInteractor get() {
        return c(this.f26612a.get(), this.f26613b.get(), this.f26614c.get());
    }
}
