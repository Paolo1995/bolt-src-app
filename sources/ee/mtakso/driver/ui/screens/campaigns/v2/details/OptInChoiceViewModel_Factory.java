package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics;
import ee.mtakso.driver.service.campaign.CampaignManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OptInChoiceViewModel_Factory implements Factory<OptInChoiceViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CampaignManager> f27516a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CampaignAnalytics> f27517b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OptInCampaignAnalytics> f27518c;

    public OptInChoiceViewModel_Factory(Provider<CampaignManager> provider, Provider<CampaignAnalytics> provider2, Provider<OptInCampaignAnalytics> provider3) {
        this.f27516a = provider;
        this.f27517b = provider2;
        this.f27518c = provider3;
    }

    public static OptInChoiceViewModel_Factory a(Provider<CampaignManager> provider, Provider<CampaignAnalytics> provider2, Provider<OptInCampaignAnalytics> provider3) {
        return new OptInChoiceViewModel_Factory(provider, provider2, provider3);
    }

    public static OptInChoiceViewModel c(CampaignManager campaignManager, CampaignAnalytics campaignAnalytics, OptInCampaignAnalytics optInCampaignAnalytics) {
        return new OptInChoiceViewModel(campaignManager, campaignAnalytics, optInCampaignAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OptInChoiceViewModel get() {
        return c(this.f27516a.get(), this.f27517b.get(), this.f27518c.get());
    }
}
