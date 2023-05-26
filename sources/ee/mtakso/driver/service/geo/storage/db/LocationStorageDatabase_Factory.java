package ee.mtakso.driver.service.geo.storage.db;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LocationStorageDatabase_Factory implements Factory<LocationStorageDatabase> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LocationDao> f24463a;

    public LocationStorageDatabase_Factory(Provider<LocationDao> provider) {
        this.f24463a = provider;
    }

    public static LocationStorageDatabase_Factory a(Provider<LocationDao> provider) {
        return new LocationStorageDatabase_Factory(provider);
    }

    public static LocationStorageDatabase c(LocationDao locationDao) {
        return new LocationStorageDatabase(locationDao);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LocationStorageDatabase get() {
        return c(this.f24463a.get());
    }
}
