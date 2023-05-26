package ee.mtakso.driver.ui.screens.order.v2.order.ui;

import androidx.fragment.app.FragmentFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.order.v2.order.DriverAppStickyBannerMapper;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class OrderPanelFragment_Factory implements Factory<OrderPanelFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f32410a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<FragmentFactory> f32411b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<RoutingManager> f32412c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverProvider> f32413d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverAppStickyBannerMapper> f32414e;

    public OrderPanelFragment_Factory(Provider<BaseUiDependencies> provider, Provider<FragmentFactory> provider2, Provider<RoutingManager> provider3, Provider<DriverProvider> provider4, Provider<DriverAppStickyBannerMapper> provider5) {
        this.f32410a = provider;
        this.f32411b = provider2;
        this.f32412c = provider3;
        this.f32413d = provider4;
        this.f32414e = provider5;
    }

    public static OrderPanelFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<FragmentFactory> provider2, Provider<RoutingManager> provider3, Provider<DriverProvider> provider4, Provider<DriverAppStickyBannerMapper> provider5) {
        return new OrderPanelFragment_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static OrderPanelFragment c(BaseUiDependencies baseUiDependencies, FragmentFactory fragmentFactory, RoutingManager routingManager, DriverProvider driverProvider, DriverAppStickyBannerMapper driverAppStickyBannerMapper) {
        return new OrderPanelFragment(baseUiDependencies, fragmentFactory, routingManager, driverProvider, driverAppStickyBannerMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderPanelFragment get() {
        return c(this.f32410a.get(), this.f32411b.get(), this.f32412c.get(), this.f32413d.get(), this.f32414e.get());
    }
}
