package ee.mtakso.driver.ui.screens.campaigns.v2;

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
public final class CampaignFactory_Factory implements Factory<CampaignFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HtmlEngine> f27302a;

    public CampaignFactory_Factory(Provider<HtmlEngine> provider) {
        this.f27302a = provider;
    }

    public static CampaignFactory_Factory a(Provider<HtmlEngine> provider) {
        return new CampaignFactory_Factory(provider);
    }

    public static CampaignFactory c(HtmlEngine htmlEngine) {
        return new CampaignFactory(htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CampaignFactory get() {
        return c(this.f27302a.get());
    }
}
