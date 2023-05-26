package ee.mtakso.driver.service.campaign;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ActiveCampaignInfoRefreshService_Factory implements Factory<ActiveCampaignInfoRefreshService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CampaignManager> f23954a;

    public ActiveCampaignInfoRefreshService_Factory(Provider<CampaignManager> provider) {
        this.f23954a = provider;
    }

    public static ActiveCampaignInfoRefreshService_Factory a(Provider<CampaignManager> provider) {
        return new ActiveCampaignInfoRefreshService_Factory(provider);
    }

    public static ActiveCampaignInfoRefreshService c(CampaignManager campaignManager) {
        return new ActiveCampaignInfoRefreshService(campaignManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ActiveCampaignInfoRefreshService get() {
        return c(this.f23954a.get());
    }
}
