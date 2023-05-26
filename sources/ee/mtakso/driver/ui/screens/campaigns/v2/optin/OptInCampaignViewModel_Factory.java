package ee.mtakso.driver.ui.screens.campaigns.v2.optin;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics;
import ee.mtakso.driver.service.campaign.CampaignManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OptInCampaignViewModel_Factory implements Factory<OptInCampaignViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CampaignManager> f27628a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OptInCampaignAnalytics> f27629b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DateTimeConverter> f27630c;

    public OptInCampaignViewModel_Factory(Provider<CampaignManager> provider, Provider<OptInCampaignAnalytics> provider2, Provider<DateTimeConverter> provider3) {
        this.f27628a = provider;
        this.f27629b = provider2;
        this.f27630c = provider3;
    }

    public static OptInCampaignViewModel_Factory a(Provider<CampaignManager> provider, Provider<OptInCampaignAnalytics> provider2, Provider<DateTimeConverter> provider3) {
        return new OptInCampaignViewModel_Factory(provider, provider2, provider3);
    }

    public static OptInCampaignViewModel c(CampaignManager campaignManager, OptInCampaignAnalytics optInCampaignAnalytics, DateTimeConverter dateTimeConverter) {
        return new OptInCampaignViewModel(campaignManager, optInCampaignAnalytics, dateTimeConverter);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OptInCampaignViewModel get() {
        return c(this.f27628a.get(), this.f27629b.get(), this.f27630c.get());
    }
}
