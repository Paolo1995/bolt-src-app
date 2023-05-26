package ee.mtakso.driver.ui.screens.history.details;

import androidx.fragment.app.FragmentFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class OrderHistoryDetailsFragment_Factory implements Factory<OrderHistoryDetailsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f29452a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DateTimeConverter> f29453b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MapProvider> f29454c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<AppThemeManager> f29455d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<RoutingManager> f29456e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<DriverConfig> f29457f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<DriverProvider> f29458g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<HtmlEngine> f29459h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<FragmentFactory> f29460i;

    public OrderHistoryDetailsFragment_Factory(Provider<BaseUiDependencies> provider, Provider<DateTimeConverter> provider2, Provider<MapProvider> provider3, Provider<AppThemeManager> provider4, Provider<RoutingManager> provider5, Provider<DriverConfig> provider6, Provider<DriverProvider> provider7, Provider<HtmlEngine> provider8, Provider<FragmentFactory> provider9) {
        this.f29452a = provider;
        this.f29453b = provider2;
        this.f29454c = provider3;
        this.f29455d = provider4;
        this.f29456e = provider5;
        this.f29457f = provider6;
        this.f29458g = provider7;
        this.f29459h = provider8;
        this.f29460i = provider9;
    }

    public static OrderHistoryDetailsFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<DateTimeConverter> provider2, Provider<MapProvider> provider3, Provider<AppThemeManager> provider4, Provider<RoutingManager> provider5, Provider<DriverConfig> provider6, Provider<DriverProvider> provider7, Provider<HtmlEngine> provider8, Provider<FragmentFactory> provider9) {
        return new OrderHistoryDetailsFragment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static OrderHistoryDetailsFragment c(BaseUiDependencies baseUiDependencies, DateTimeConverter dateTimeConverter, MapProvider mapProvider, AppThemeManager appThemeManager, RoutingManager routingManager, DriverConfig driverConfig, DriverProvider driverProvider, HtmlEngine htmlEngine, FragmentFactory fragmentFactory) {
        return new OrderHistoryDetailsFragment(baseUiDependencies, dateTimeConverter, mapProvider, appThemeManager, routingManager, driverConfig, driverProvider, htmlEngine, fragmentFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderHistoryDetailsFragment get() {
        return c(this.f29452a.get(), this.f29453b.get(), this.f29454c.get(), this.f29455d.get(), this.f29456e.get(), this.f29457f.get(), this.f29458g.get(), this.f29459h.get(), this.f29460i.get());
    }
}
