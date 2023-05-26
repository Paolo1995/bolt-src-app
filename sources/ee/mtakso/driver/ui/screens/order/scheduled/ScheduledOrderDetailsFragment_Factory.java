package ee.mtakso.driver.ui.screens.order.scheduled;

import androidx.fragment.app.FragmentFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.driver.core.theme.AppThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class ScheduledOrderDetailsFragment_Factory implements Factory<ScheduledOrderDetailsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f31698a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MapProvider> f31699b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AppThemeManager> f31700c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<MarkerParamsFactory> f31701d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<CompositeUrlLauncher> f31702e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<FragmentFactory> f31703f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<ScheduledOrderButtonAppearanceMapper> f31704g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<HtmlEngine> f31705h;

    public ScheduledOrderDetailsFragment_Factory(Provider<BaseUiDependencies> provider, Provider<MapProvider> provider2, Provider<AppThemeManager> provider3, Provider<MarkerParamsFactory> provider4, Provider<CompositeUrlLauncher> provider5, Provider<FragmentFactory> provider6, Provider<ScheduledOrderButtonAppearanceMapper> provider7, Provider<HtmlEngine> provider8) {
        this.f31698a = provider;
        this.f31699b = provider2;
        this.f31700c = provider3;
        this.f31701d = provider4;
        this.f31702e = provider5;
        this.f31703f = provider6;
        this.f31704g = provider7;
        this.f31705h = provider8;
    }

    public static ScheduledOrderDetailsFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<MapProvider> provider2, Provider<AppThemeManager> provider3, Provider<MarkerParamsFactory> provider4, Provider<CompositeUrlLauncher> provider5, Provider<FragmentFactory> provider6, Provider<ScheduledOrderButtonAppearanceMapper> provider7, Provider<HtmlEngine> provider8) {
        return new ScheduledOrderDetailsFragment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ScheduledOrderDetailsFragment c(BaseUiDependencies baseUiDependencies, MapProvider mapProvider, AppThemeManager appThemeManager, MarkerParamsFactory markerParamsFactory, CompositeUrlLauncher compositeUrlLauncher, FragmentFactory fragmentFactory, ScheduledOrderButtonAppearanceMapper scheduledOrderButtonAppearanceMapper, HtmlEngine htmlEngine) {
        return new ScheduledOrderDetailsFragment(baseUiDependencies, mapProvider, appThemeManager, markerParamsFactory, compositeUrlLauncher, fragmentFactory, scheduledOrderButtonAppearanceMapper, htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ScheduledOrderDetailsFragment get() {
        return c(this.f31698a.get(), this.f31699b.get(), this.f31700c.get(), this.f31701d.get(), this.f31702e.get(), this.f31703f.get(), this.f31704g.get(), this.f31705h.get());
    }
}
