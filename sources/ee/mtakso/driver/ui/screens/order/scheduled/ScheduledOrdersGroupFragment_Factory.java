package ee.mtakso.driver.ui.screens.order.scheduled;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.driver.core.theme.AppThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class ScheduledOrdersGroupFragment_Factory implements Factory<ScheduledOrdersGroupFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f31778a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MapProvider> f31779b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AppThemeManager> f31780c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<MarkerParamsFactory> f31781d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<HtmlEngine> f31782e;

    public ScheduledOrdersGroupFragment_Factory(Provider<BaseUiDependencies> provider, Provider<MapProvider> provider2, Provider<AppThemeManager> provider3, Provider<MarkerParamsFactory> provider4, Provider<HtmlEngine> provider5) {
        this.f31778a = provider;
        this.f31779b = provider2;
        this.f31780c = provider3;
        this.f31781d = provider4;
        this.f31782e = provider5;
    }

    public static ScheduledOrdersGroupFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<MapProvider> provider2, Provider<AppThemeManager> provider3, Provider<MarkerParamsFactory> provider4, Provider<HtmlEngine> provider5) {
        return new ScheduledOrdersGroupFragment_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ScheduledOrdersGroupFragment c(BaseUiDependencies baseUiDependencies, MapProvider mapProvider, AppThemeManager appThemeManager, MarkerParamsFactory markerParamsFactory, HtmlEngine htmlEngine) {
        return new ScheduledOrdersGroupFragment(baseUiDependencies, mapProvider, appThemeManager, markerParamsFactory, htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ScheduledOrdersGroupFragment get() {
        return c(this.f31778a.get(), this.f31779b.get(), this.f31780c.get(), this.f31781d.get(), this.f31782e.get());
    }
}
