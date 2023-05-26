package ee.mtakso.driver.service.geo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GeoService_Factory implements Factory<GeoService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GeoLocationManager> f24409a;

    public GeoService_Factory(Provider<GeoLocationManager> provider) {
        this.f24409a = provider;
    }

    public static GeoService_Factory a(Provider<GeoLocationManager> provider) {
        return new GeoService_Factory(provider);
    }

    public static GeoService c(GeoLocationManager geoLocationManager) {
        return new GeoService(geoLocationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GeoService get() {
        return c(this.f24409a.get());
    }
}
