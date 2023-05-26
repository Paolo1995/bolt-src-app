package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.geo.storage.db.LocationDao;
import ee.mtakso.driver.service.geo.storage.db.LocationDatabase;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GeoModule_ProvideLocationDaoFactory implements Factory<LocationDao> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LocationDatabase> f20751a;

    public GeoModule_ProvideLocationDaoFactory(Provider<LocationDatabase> provider) {
        this.f20751a = provider;
    }

    public static GeoModule_ProvideLocationDaoFactory a(Provider<LocationDatabase> provider) {
        return new GeoModule_ProvideLocationDaoFactory(provider);
    }

    public static LocationDao c(LocationDatabase locationDatabase) {
        return (LocationDao) Preconditions.checkNotNullFromProvides(GeoModule.d(locationDatabase));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LocationDao get() {
        return c(this.f20751a.get());
    }
}
