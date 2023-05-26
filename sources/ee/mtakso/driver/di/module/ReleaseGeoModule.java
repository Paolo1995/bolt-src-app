package ee.mtakso.driver.di.module;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.di.modules.GeoModule;
import ee.mtakso.driver.platform.geo.GeoLocationSource;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.mock.ReleaseMockChecker;
import ee.mtakso.driver.service.geo.state.ReleaseLocationStateChecker;
import ee.mtakso.driver.service.restriction.EnvironmentDataProvider;
import ee.mtakso.driver.service.time.AnchoredTrueTimeProvider;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReleaseGeoModule.kt */
@Module(includes = {GeoModule.class})
/* loaded from: classes3.dex */
public final class ReleaseGeoModule {
    @Provides
    @Singleton
    public final GeoLocationManager a(GeoLocationSource source, Context context, AnchoredTrueTimeProvider timeProvider, ReleaseMockChecker mockChecker, PackageManager packageManager, PermissionManager permissionManager, EnvironmentDataProvider environmentDataProvider) {
        Intrinsics.f(source, "source");
        Intrinsics.f(context, "context");
        Intrinsics.f(timeProvider, "timeProvider");
        Intrinsics.f(mockChecker, "mockChecker");
        Intrinsics.f(packageManager, "packageManager");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(environmentDataProvider, "environmentDataProvider");
        Object systemService = context.getSystemService("location");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        return new GeoLocationManager(source, timeProvider, mockChecker, new ReleaseLocationStateChecker(context, (LocationManager) systemService, source, packageManager, permissionManager, false), environmentDataProvider);
    }
}
