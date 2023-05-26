package ee.mtakso.driver.ui.screens.order.v2.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.geo.GeoClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class RouteProvider_Factory implements Factory<RouteProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f32156a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TrueTimeProvider> f32157b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<GeoClient> f32158c;

    public RouteProvider_Factory(Provider<DriverProvider> provider, Provider<TrueTimeProvider> provider2, Provider<GeoClient> provider3) {
        this.f32156a = provider;
        this.f32157b = provider2;
        this.f32158c = provider3;
    }

    public static RouteProvider_Factory a(Provider<DriverProvider> provider, Provider<TrueTimeProvider> provider2, Provider<GeoClient> provider3) {
        return new RouteProvider_Factory(provider, provider2, provider3);
    }

    public static RouteProvider c(DriverProvider driverProvider, TrueTimeProvider trueTimeProvider, GeoClient geoClient) {
        return new RouteProvider(driverProvider, trueTimeProvider, geoClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RouteProvider get() {
        return c(this.f32156a.get(), this.f32157b.get(), this.f32158c.get());
    }
}
