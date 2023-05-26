package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class ReferralCampaignDetailsFragment_Factory implements Factory<ReferralCampaignDetailsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CampaignBonusMapper> f27526a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f27527b;

    public ReferralCampaignDetailsFragment_Factory(Provider<CampaignBonusMapper> provider, Provider<BaseUiDependencies> provider2) {
        this.f27526a = provider;
        this.f27527b = provider2;
    }

    public static ReferralCampaignDetailsFragment_Factory a(Provider<CampaignBonusMapper> provider, Provider<BaseUiDependencies> provider2) {
        return new ReferralCampaignDetailsFragment_Factory(provider, provider2);
    }

    public static ReferralCampaignDetailsFragment c(CampaignBonusMapper campaignBonusMapper, BaseUiDependencies baseUiDependencies) {
        return new ReferralCampaignDetailsFragment(campaignBonusMapper, baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ReferralCampaignDetailsFragment get() {
        return c(this.f27526a.get(), this.f27527b.get());
    }
}
