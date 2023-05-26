package ee.mtakso.driver.ui.screens.campaigns.v2.optin;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class OptInCampaignFragment_Factory implements Factory<OptInCampaignFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f27609a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<HtmlEngine> f27610b;

    public OptInCampaignFragment_Factory(Provider<BaseUiDependencies> provider, Provider<HtmlEngine> provider2) {
        this.f27609a = provider;
        this.f27610b = provider2;
    }

    public static OptInCampaignFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<HtmlEngine> provider2) {
        return new OptInCampaignFragment_Factory(provider, provider2);
    }

    public static OptInCampaignFragment c(BaseUiDependencies baseUiDependencies, HtmlEngine htmlEngine) {
        return new OptInCampaignFragment(baseUiDependencies, htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OptInCampaignFragment get() {
        return c(this.f27609a.get(), this.f27610b.get());
    }
}
