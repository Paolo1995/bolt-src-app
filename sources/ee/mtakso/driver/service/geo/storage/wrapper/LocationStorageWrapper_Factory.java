package ee.mtakso.driver.service.geo.storage.wrapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.service.geo.storage.db.LocationStorageDatabase;
import ee.mtakso.driver.service.geo.storage.memory.LocationStorageInMemory;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LocationStorageWrapper_Factory implements Factory<LocationStorageWrapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LocationStorageInMemory> f24470a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<LocationStorageDatabase> f24471b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Features> f24472c;

    public LocationStorageWrapper_Factory(Provider<LocationStorageInMemory> provider, Provider<LocationStorageDatabase> provider2, Provider<Features> provider3) {
        this.f24470a = provider;
        this.f24471b = provider2;
        this.f24472c = provider3;
    }

    public static LocationStorageWrapper_Factory a(Provider<LocationStorageInMemory> provider, Provider<LocationStorageDatabase> provider2, Provider<Features> provider3) {
        return new LocationStorageWrapper_Factory(provider, provider2, provider3);
    }

    public static LocationStorageWrapper c(LocationStorageInMemory locationStorageInMemory, LocationStorageDatabase locationStorageDatabase, Features features) {
        return new LocationStorageWrapper(locationStorageInMemory, locationStorageDatabase, features);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LocationStorageWrapper get() {
        return c(this.f24470a.get(), this.f24471b.get(), this.f24472c.get());
    }
}
