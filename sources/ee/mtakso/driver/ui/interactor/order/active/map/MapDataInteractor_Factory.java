package ee.mtakso.driver.ui.interactor.order.active.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.screens.order.v2.map.RouteProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class MapDataInteractor_Factory implements Factory<MapDataInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GeoLocationManager> f26728a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderProvider> f26729b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<RouteProvider> f26730c;

    public MapDataInteractor_Factory(Provider<GeoLocationManager> provider, Provider<OrderProvider> provider2, Provider<RouteProvider> provider3) {
        this.f26728a = provider;
        this.f26729b = provider2;
        this.f26730c = provider3;
    }

    public static MapDataInteractor_Factory a(Provider<GeoLocationManager> provider, Provider<OrderProvider> provider2, Provider<RouteProvider> provider3) {
        return new MapDataInteractor_Factory(provider, provider2, provider3);
    }

    public static MapDataInteractor c(GeoLocationManager geoLocationManager, OrderProvider orderProvider, RouteProvider routeProvider) {
        return new MapDataInteractor(geoLocationManager, orderProvider, routeProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MapDataInteractor get() {
        return c(this.f26728a.get(), this.f26729b.get(), this.f26730c.get());
    }
}
