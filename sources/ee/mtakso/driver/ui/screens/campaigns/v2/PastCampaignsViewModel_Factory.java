package ee.mtakso.driver.ui.screens.campaigns.v2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.campaign.CampaignClient;
import ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PastCampaignsViewModel_Factory implements Factory<PastCampaignsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CampaignClient> f27365a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CampaignAnalytics> f27366b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CampaignFactory> f27367c;

    public PastCampaignsViewModel_Factory(Provider<CampaignClient> provider, Provider<CampaignAnalytics> provider2, Provider<CampaignFactory> provider3) {
        this.f27365a = provider;
        this.f27366b = provider2;
        this.f27367c = provider3;
    }

    public static PastCampaignsViewModel_Factory a(Provider<CampaignClient> provider, Provider<CampaignAnalytics> provider2, Provider<CampaignFactory> provider3) {
        return new PastCampaignsViewModel_Factory(provider, provider2, provider3);
    }

    public static PastCampaignsViewModel c(CampaignClient campaignClient, CampaignAnalytics campaignAnalytics, CampaignFactory campaignFactory) {
        return new PastCampaignsViewModel(campaignClient, campaignAnalytics, campaignFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PastCampaignsViewModel get() {
        return c(this.f27365a.get(), this.f27366b.get(), this.f27367c.get());
    }
}
