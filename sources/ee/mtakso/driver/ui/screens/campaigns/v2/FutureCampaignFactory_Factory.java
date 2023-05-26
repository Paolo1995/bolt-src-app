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
public final class FutureCampaignFactory_Factory implements Factory<FutureCampaignFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HtmlEngine> f27330a;

    public FutureCampaignFactory_Factory(Provider<HtmlEngine> provider) {
        this.f27330a = provider;
    }

    public static FutureCampaignFactory_Factory a(Provider<HtmlEngine> provider) {
        return new FutureCampaignFactory_Factory(provider);
    }

    public static FutureCampaignFactory c(HtmlEngine htmlEngine) {
        return new FutureCampaignFactory(htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FutureCampaignFactory get() {
        return c(this.f27330a.get());
    }
}
