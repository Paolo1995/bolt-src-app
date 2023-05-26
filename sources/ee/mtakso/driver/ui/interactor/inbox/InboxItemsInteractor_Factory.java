package ee.mtakso.driver.ui.interactor.inbox;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.service.campaign.CampaignManager;
import ee.mtakso.driver.service.integration.clevertap.CleverTapManager;
import eu.bolt.driver.stories.network.StoriesClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class InboxItemsInteractor_Factory implements Factory<InboxItemsInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CampaignManager> f26570a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverConfig> f26571b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CleverTapManager> f26572c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<StoriesClient> f26573d;

    public InboxItemsInteractor_Factory(Provider<CampaignManager> provider, Provider<DriverConfig> provider2, Provider<CleverTapManager> provider3, Provider<StoriesClient> provider4) {
        this.f26570a = provider;
        this.f26571b = provider2;
        this.f26572c = provider3;
        this.f26573d = provider4;
    }

    public static InboxItemsInteractor_Factory a(Provider<CampaignManager> provider, Provider<DriverConfig> provider2, Provider<CleverTapManager> provider3, Provider<StoriesClient> provider4) {
        return new InboxItemsInteractor_Factory(provider, provider2, provider3, provider4);
    }

    public static InboxItemsInteractor c(CampaignManager campaignManager, DriverConfig driverConfig, CleverTapManager cleverTapManager, StoriesClient storiesClient) {
        return new InboxItemsInteractor(campaignManager, driverConfig, cleverTapManager, storiesClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public InboxItemsInteractor get() {
        return c(this.f26570a.get(), this.f26571b.get(), this.f26572c.get(), this.f26573d.get());
    }
}
