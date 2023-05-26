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
public final class CampaignInfoBlockMapper_Factory implements Factory<CampaignInfoBlockMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HtmlEngine> f27478a;

    public CampaignInfoBlockMapper_Factory(Provider<HtmlEngine> provider) {
        this.f27478a = provider;
    }

    public static CampaignInfoBlockMapper_Factory a(Provider<HtmlEngine> provider) {
        return new CampaignInfoBlockMapper_Factory(provider);
    }

    public static CampaignInfoBlockMapper c(HtmlEngine htmlEngine) {
        return new CampaignInfoBlockMapper(htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CampaignInfoBlockMapper get() {
        return c(this.f27478a.get());
    }
}
