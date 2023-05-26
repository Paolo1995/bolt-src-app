package ee.mtakso.driver.di.modules;

import android.content.Context;
import androidx.room.Room;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.service.geo.storage.LocationStorage;
import ee.mtakso.driver.service.geo.storage.LocationStorageCleaner;
import ee.mtakso.driver.service.geo.storage.db.LocationDao;
import ee.mtakso.driver.service.geo.storage.db.LocationDatabase;
import ee.mtakso.driver.service.geo.storage.wrapper.LocationStorageWrapper;
import ee.mtakso.driver.service.restriction.EnvironmentDataProvider;
import ee.mtakso.driver.service.restriction.MockEnvironmentDataProvider;
import javax.inject.Singleton;

@Module
/* loaded from: classes3.dex */
public abstract class GeoModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static LocationDao d(LocationDatabase locationDatabase) {
        return locationDatabase.G();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public static LocationDatabase e(Context context) {
        return (LocationDatabase) Room.a(context, LocationDatabase.class, "ee.mtakso.driver.location").d();
    }

    @Binds
    abstract LocationStorage a(LocationStorageWrapper locationStorageWrapper);

    @Binds
    abstract LocationStorageCleaner b(LocationStorageWrapper locationStorageWrapper);

    @Binds
    abstract EnvironmentDataProvider c(MockEnvironmentDataProvider mockEnvironmentDataProvider);
}
