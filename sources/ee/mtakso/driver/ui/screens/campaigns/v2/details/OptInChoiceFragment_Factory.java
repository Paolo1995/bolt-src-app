package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.driver.core.theme.AppThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class OptInChoiceFragment_Factory implements Factory<OptInChoiceFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MapProvider> f27502a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AppThemeManager> f27503b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CampaignBonusMapper> f27504c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<CampaignInfoBlockMapper> f27505d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<CampaignDynamicItemsMapper> f27506e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f27507f;

    public OptInChoiceFragment_Factory(Provider<MapProvider> provider, Provider<AppThemeManager> provider2, Provider<CampaignBonusMapper> provider3, Provider<CampaignInfoBlockMapper> provider4, Provider<CampaignDynamicItemsMapper> provider5, Provider<BaseUiDependencies> provider6) {
        this.f27502a = provider;
        this.f27503b = provider2;
        this.f27504c = provider3;
        this.f27505d = provider4;
        this.f27506e = provider5;
        this.f27507f = provider6;
    }

    public static OptInChoiceFragment_Factory a(Provider<MapProvider> provider, Provider<AppThemeManager> provider2, Provider<CampaignBonusMapper> provider3, Provider<CampaignInfoBlockMapper> provider4, Provider<CampaignDynamicItemsMapper> provider5, Provider<BaseUiDependencies> provider6) {
        return new OptInChoiceFragment_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static OptInChoiceFragment c(MapProvider mapProvider, AppThemeManager appThemeManager, CampaignBonusMapper campaignBonusMapper, CampaignInfoBlockMapper campaignInfoBlockMapper, CampaignDynamicItemsMapper campaignDynamicItemsMapper, BaseUiDependencies baseUiDependencies) {
        return new OptInChoiceFragment(mapProvider, appThemeManager, campaignBonusMapper, campaignInfoBlockMapper, campaignDynamicItemsMapper, baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OptInChoiceFragment get() {
        return c(this.f27502a.get(), this.f27503b.get(), this.f27504c.get(), this.f27505d.get(), this.f27506e.get(), this.f27507f.get());
    }
}
