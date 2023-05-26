package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CampaignDynamicItemsMapper_Factory implements Factory<CampaignDynamicItemsMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CampaignInfoBlockMapper> f27469a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<HtmlEngine> f27470b;

    public CampaignDynamicItemsMapper_Factory(Provider<CampaignInfoBlockMapper> provider, Provider<HtmlEngine> provider2) {
        this.f27469a = provider;
        this.f27470b = provider2;
    }

    public static CampaignDynamicItemsMapper_Factory a(Provider<CampaignInfoBlockMapper> provider, Provider<HtmlEngine> provider2) {
        return new CampaignDynamicItemsMapper_Factory(provider, provider2);
    }

    public static CampaignDynamicItemsMapper c(CampaignInfoBlockMapper campaignInfoBlockMapper, HtmlEngine htmlEngine) {
        return new CampaignDynamicItemsMapper(campaignInfoBlockMapper, htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CampaignDynamicItemsMapper get() {
        return c(this.f27469a.get(), this.f27470b.get());
    }
}
