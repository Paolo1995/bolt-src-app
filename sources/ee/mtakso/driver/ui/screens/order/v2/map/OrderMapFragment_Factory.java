package ee.mtakso.driver.ui.screens.order.v2.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import eu.bolt.android.maps.core.MapProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class OrderMapFragment_Factory implements Factory<OrderMapFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f32143a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MapProvider> f32144b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MarkerParamsFactory> f32145c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverProvider> f32146d;

    public OrderMapFragment_Factory(Provider<BaseUiDependencies> provider, Provider<MapProvider> provider2, Provider<MarkerParamsFactory> provider3, Provider<DriverProvider> provider4) {
        this.f32143a = provider;
        this.f32144b = provider2;
        this.f32145c = provider3;
        this.f32146d = provider4;
    }

    public static OrderMapFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<MapProvider> provider2, Provider<MarkerParamsFactory> provider3, Provider<DriverProvider> provider4) {
        return new OrderMapFragment_Factory(provider, provider2, provider3, provider4);
    }

    public static OrderMapFragment c(BaseUiDependencies baseUiDependencies, MapProvider mapProvider, MarkerParamsFactory markerParamsFactory, DriverProvider driverProvider) {
        return new OrderMapFragment(baseUiDependencies, mapProvider, markerParamsFactory, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderMapFragment get() {
        return c(this.f32143a.get(), this.f32144b.get(), this.f32145c.get(), this.f32146d.get());
    }
}
