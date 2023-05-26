package ee.mtakso.driver.service.campaign;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.campaign.CampaignClient;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CampaignManager_Factory implements Factory<CampaignManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CampaignClient> f23974a;

    public CampaignManager_Factory(Provider<CampaignClient> provider) {
        this.f23974a = provider;
    }

    public static CampaignManager_Factory a(Provider<CampaignClient> provider) {
        return new CampaignManager_Factory(provider);
    }

    public static CampaignManager c(CampaignClient campaignClient) {
        return new CampaignManager(campaignClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CampaignManager get() {
        return c(this.f23974a.get());
    }
}
