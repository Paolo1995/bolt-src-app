package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.campaign.CampaignClient;
import ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ReferralCampaignDetailsViewModel_Factory implements Factory<ReferralCampaignDetailsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CampaignClient> f27534a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ReferralCampaignsAnalytics> f27535b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ReferralCampaignMapper> f27536c;

    public ReferralCampaignDetailsViewModel_Factory(Provider<CampaignClient> provider, Provider<ReferralCampaignsAnalytics> provider2, Provider<ReferralCampaignMapper> provider3) {
        this.f27534a = provider;
        this.f27535b = provider2;
        this.f27536c = provider3;
    }

    public static ReferralCampaignDetailsViewModel_Factory a(Provider<CampaignClient> provider, Provider<ReferralCampaignsAnalytics> provider2, Provider<ReferralCampaignMapper> provider3) {
        return new ReferralCampaignDetailsViewModel_Factory(provider, provider2, provider3);
    }

    public static ReferralCampaignDetailsViewModel c(CampaignClient campaignClient, ReferralCampaignsAnalytics referralCampaignsAnalytics, ReferralCampaignMapper referralCampaignMapper) {
        return new ReferralCampaignDetailsViewModel(campaignClient, referralCampaignsAnalytics, referralCampaignMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ReferralCampaignDetailsViewModel get() {
        return c(this.f27534a.get(), this.f27535b.get(), this.f27536c.get());
    }
}
