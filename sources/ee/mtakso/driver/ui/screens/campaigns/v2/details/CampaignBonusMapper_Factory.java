package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CampaignBonusMapper_Factory implements Factory<CampaignBonusMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CampaignImageMapper> f27415a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CampaignInfoBlockMapper> f27416b;

    public CampaignBonusMapper_Factory(Provider<CampaignImageMapper> provider, Provider<CampaignInfoBlockMapper> provider2) {
        this.f27415a = provider;
        this.f27416b = provider2;
    }

    public static CampaignBonusMapper_Factory a(Provider<CampaignImageMapper> provider, Provider<CampaignInfoBlockMapper> provider2) {
        return new CampaignBonusMapper_Factory(provider, provider2);
    }

    public static CampaignBonusMapper c(CampaignImageMapper campaignImageMapper, CampaignInfoBlockMapper campaignInfoBlockMapper) {
        return new CampaignBonusMapper(campaignImageMapper, campaignInfoBlockMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CampaignBonusMapper get() {
        return c(this.f27415a.get(), this.f27416b.get());
    }
}
