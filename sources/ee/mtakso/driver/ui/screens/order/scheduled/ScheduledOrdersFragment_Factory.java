package ee.mtakso.driver.ui.screens.order.scheduled;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.driver.core.theme.AppThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class ScheduledOrdersFragment_Factory implements Factory<ScheduledOrdersFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f31768a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MapProvider> f31769b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AppThemeManager> f31770c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<MarkerParamsFactory> f31771d;

    public ScheduledOrdersFragment_Factory(Provider<BaseUiDependencies> provider, Provider<MapProvider> provider2, Provider<AppThemeManager> provider3, Provider<MarkerParamsFactory> provider4) {
        this.f31768a = provider;
        this.f31769b = provider2;
        this.f31770c = provider3;
        this.f31771d = provider4;
    }

    public static ScheduledOrdersFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<MapProvider> provider2, Provider<AppThemeManager> provider3, Provider<MarkerParamsFactory> provider4) {
        return new ScheduledOrdersFragment_Factory(provider, provider2, provider3, provider4);
    }

    public static ScheduledOrdersFragment c(BaseUiDependencies baseUiDependencies, MapProvider mapProvider, AppThemeManager appThemeManager, MarkerParamsFactory markerParamsFactory) {
        return new ScheduledOrdersFragment(baseUiDependencies, mapProvider, appThemeManager, markerParamsFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ScheduledOrdersFragment get() {
        return c(this.f31768a.get(), this.f31769b.get(), this.f31770c.get(), this.f31771d.get());
    }
}
