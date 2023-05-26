package ee.mtakso.driver.ui.screens.campaigns.v2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.campaign.CampaignClient;
import ee.mtakso.driver.network.client.campaign.CircleKClient;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverReferralCampaignManager;
import ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics;
import ee.mtakso.driver.service.campaign.CampaignManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ActiveCampaignsViewModel_Factory implements Factory<ActiveCampaignsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CircleKClient> f27252a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CampaignClient> f27253b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CampaignManager> f27254c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverReferralCampaignManager> f27255d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverConfig> f27256e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<CampaignAnalytics> f27257f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<OptInCampaignAnalytics> f27258g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<CampaignFactory> f27259h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<FutureCampaignFactory> f27260i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<ReferralCampaignsAnalytics> f27261j;

    public ActiveCampaignsViewModel_Factory(Provider<CircleKClient> provider, Provider<CampaignClient> provider2, Provider<CampaignManager> provider3, Provider<DriverReferralCampaignManager> provider4, Provider<DriverConfig> provider5, Provider<CampaignAnalytics> provider6, Provider<OptInCampaignAnalytics> provider7, Provider<CampaignFactory> provider8, Provider<FutureCampaignFactory> provider9, Provider<ReferralCampaignsAnalytics> provider10) {
        this.f27252a = provider;
        this.f27253b = provider2;
        this.f27254c = provider3;
        this.f27255d = provider4;
        this.f27256e = provider5;
        this.f27257f = provider6;
        this.f27258g = provider7;
        this.f27259h = provider8;
        this.f27260i = provider9;
        this.f27261j = provider10;
    }

    public static ActiveCampaignsViewModel_Factory a(Provider<CircleKClient> provider, Provider<CampaignClient> provider2, Provider<CampaignManager> provider3, Provider<DriverReferralCampaignManager> provider4, Provider<DriverConfig> provider5, Provider<CampaignAnalytics> provider6, Provider<OptInCampaignAnalytics> provider7, Provider<CampaignFactory> provider8, Provider<FutureCampaignFactory> provider9, Provider<ReferralCampaignsAnalytics> provider10) {
        return new ActiveCampaignsViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static ActiveCampaignsViewModel c(CircleKClient circleKClient, CampaignClient campaignClient, CampaignManager campaignManager, DriverReferralCampaignManager driverReferralCampaignManager, DriverConfig driverConfig, CampaignAnalytics campaignAnalytics, OptInCampaignAnalytics optInCampaignAnalytics, CampaignFactory campaignFactory, FutureCampaignFactory futureCampaignFactory, ReferralCampaignsAnalytics referralCampaignsAnalytics) {
        return new ActiveCampaignsViewModel(circleKClient, campaignClient, campaignManager, driverReferralCampaignManager, driverConfig, campaignAnalytics, optInCampaignAnalytics, campaignFactory, futureCampaignFactory, referralCampaignsAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ActiveCampaignsViewModel get() {
        return c(this.f27252a.get(), this.f27253b.get(), this.f27254c.get(), this.f27255d.get(), this.f27256e.get(), this.f27257f.get(), this.f27258g.get(), this.f27259h.get(), this.f27260i.get(), this.f27261j.get());
    }
}
