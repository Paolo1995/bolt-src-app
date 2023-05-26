package ee.mtakso.driver.ui.screens.campaigns.v2.details;

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
public final class CampaignDetailsViewModel_Factory implements Factory<CampaignDetailsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CampaignClient> f27461a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CampaignAnalytics> f27462b;

    public CampaignDetailsViewModel_Factory(Provider<CampaignClient> provider, Provider<CampaignAnalytics> provider2) {
        this.f27461a = provider;
        this.f27462b = provider2;
    }

    public static CampaignDetailsViewModel_Factory a(Provider<CampaignClient> provider, Provider<CampaignAnalytics> provider2) {
        return new CampaignDetailsViewModel_Factory(provider, provider2);
    }

    public static CampaignDetailsViewModel c(CampaignClient campaignClient, CampaignAnalytics campaignAnalytics) {
        return new CampaignDetailsViewModel(campaignClient, campaignAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CampaignDetailsViewModel get() {
        return c(this.f27461a.get(), this.f27462b.get());
    }
}
