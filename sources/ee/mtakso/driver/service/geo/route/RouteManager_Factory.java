package ee.mtakso.driver.service.geo.route;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.geo.GeoClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class RouteManager_Factory implements Factory<RouteManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GeoClient> f24423a;

    public RouteManager_Factory(Provider<GeoClient> provider) {
        this.f24423a = provider;
    }

    public static RouteManager_Factory a(Provider<GeoClient> provider) {
        return new RouteManager_Factory(provider);
    }

    public static RouteManager c(GeoClient geoClient) {
        return new RouteManager(geoClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RouteManager get() {
        return c(this.f24423a.get());
    }
}
