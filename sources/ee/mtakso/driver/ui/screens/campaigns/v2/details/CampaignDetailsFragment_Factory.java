package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.driver.core.theme.AppThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class CampaignDetailsFragment_Factory implements Factory<CampaignDetailsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MapProvider> f27446a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AppThemeManager> f27447b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<HtmlEngine> f27448c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<CampaignBonusMapper> f27449d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<CampaignInfoBlockMapper> f27450e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<CampaignDynamicItemsMapper> f27451f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f27452g;

    public CampaignDetailsFragment_Factory(Provider<MapProvider> provider, Provider<AppThemeManager> provider2, Provider<HtmlEngine> provider3, Provider<CampaignBonusMapper> provider4, Provider<CampaignInfoBlockMapper> provider5, Provider<CampaignDynamicItemsMapper> provider6, Provider<BaseUiDependencies> provider7) {
        this.f27446a = provider;
        this.f27447b = provider2;
        this.f27448c = provider3;
        this.f27449d = provider4;
        this.f27450e = provider5;
        this.f27451f = provider6;
        this.f27452g = provider7;
    }

    public static CampaignDetailsFragment_Factory a(Provider<MapProvider> provider, Provider<AppThemeManager> provider2, Provider<HtmlEngine> provider3, Provider<CampaignBonusMapper> provider4, Provider<CampaignInfoBlockMapper> provider5, Provider<CampaignDynamicItemsMapper> provider6, Provider<BaseUiDependencies> provider7) {
        return new CampaignDetailsFragment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static CampaignDetailsFragment c(MapProvider mapProvider, AppThemeManager appThemeManager, HtmlEngine htmlEngine, CampaignBonusMapper campaignBonusMapper, CampaignInfoBlockMapper campaignInfoBlockMapper, CampaignDynamicItemsMapper campaignDynamicItemsMapper, BaseUiDependencies baseUiDependencies) {
        return new CampaignDetailsFragment(mapProvider, appThemeManager, htmlEngine, campaignBonusMapper, campaignInfoBlockMapper, campaignDynamicItemsMapper, baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CampaignDetailsFragment get() {
        return c(this.f27446a.get(), this.f27447b.get(), this.f27448c.get(), this.f27449d.get(), this.f27450e.get(), this.f27451f.get(), this.f27452g.get());
    }
}
