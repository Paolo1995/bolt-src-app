package ee.mtakso.driver.service.geo.storage.memory;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LocationStorageInMemory_Factory implements Factory<LocationStorageInMemory> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final LocationStorageInMemory_Factory f24466a = new LocationStorageInMemory_Factory();

        private InstanceHolder() {
        }
    }

    public static LocationStorageInMemory_Factory a() {
        return InstanceHolder.f24466a;
    }

    public static LocationStorageInMemory c() {
        return new LocationStorageInMemory();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LocationStorageInMemory get() {
        return c();
    }
}
