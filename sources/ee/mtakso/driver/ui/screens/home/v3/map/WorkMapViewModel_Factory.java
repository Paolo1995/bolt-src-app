package ee.mtakso.driver.ui.screens.home.v3.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.campaign.CampaignManager;
import ee.mtakso.driver.service.modules.fifo.FifoQueueManager;
import ee.mtakso.driver.ui.interactor.driver.DriverAreaInteractor;
import ee.mtakso.driver.ui.interactor.driver.DriverStateInteractor;
import ee.mtakso.driver.ui.interactor.driver.FifoQueueMapInteractor;
import ee.mtakso.driver.ui.interactor.driver.NearbyDriversInteractor;
import ee.mtakso.driver.ui.interactor.map.GetHeatmapInteractor;
import eu.bolt.driver.core.theme.AppThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class WorkMapViewModel_Factory implements Factory<WorkMapViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverAreaInteractor> f30150a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<NearbyDriversInteractor> f30151b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverStateInteractor> f30152c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<FifoQueueManager> f30153d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<FifoQueueMapInteractor> f30154e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<GetHeatmapInteractor> f30155f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<AppThemeManager> f30156g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<CampaignManager> f30157h;

    public WorkMapViewModel_Factory(Provider<DriverAreaInteractor> provider, Provider<NearbyDriversInteractor> provider2, Provider<DriverStateInteractor> provider3, Provider<FifoQueueManager> provider4, Provider<FifoQueueMapInteractor> provider5, Provider<GetHeatmapInteractor> provider6, Provider<AppThemeManager> provider7, Provider<CampaignManager> provider8) {
        this.f30150a = provider;
        this.f30151b = provider2;
        this.f30152c = provider3;
        this.f30153d = provider4;
        this.f30154e = provider5;
        this.f30155f = provider6;
        this.f30156g = provider7;
        this.f30157h = provider8;
    }

    public static WorkMapViewModel_Factory a(Provider<DriverAreaInteractor> provider, Provider<NearbyDriversInteractor> provider2, Provider<DriverStateInteractor> provider3, Provider<FifoQueueManager> provider4, Provider<FifoQueueMapInteractor> provider5, Provider<GetHeatmapInteractor> provider6, Provider<AppThemeManager> provider7, Provider<CampaignManager> provider8) {
        return new WorkMapViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static WorkMapViewModel c(DriverAreaInteractor driverAreaInteractor, NearbyDriversInteractor nearbyDriversInteractor, DriverStateInteractor driverStateInteractor, FifoQueueManager fifoQueueManager, FifoQueueMapInteractor fifoQueueMapInteractor, GetHeatmapInteractor getHeatmapInteractor, AppThemeManager appThemeManager, CampaignManager campaignManager) {
        return new WorkMapViewModel(driverAreaInteractor, nearbyDriversInteractor, driverStateInteractor, fifoQueueManager, fifoQueueMapInteractor, getHeatmapInteractor, appThemeManager, campaignManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WorkMapViewModel get() {
        return c(this.f30150a.get(), this.f30151b.get(), this.f30152c.get(), this.f30153d.get(), this.f30154e.get(), this.f30155f.get(), this.f30156g.get(), this.f30157h.get());
    }
}
