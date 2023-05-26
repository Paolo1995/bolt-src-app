package ee.mtakso.driver.ui.screens.launch;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.param.DeviceFeatures;
import ee.mtakso.driver.platform.check.PlatformAvailabilityManager;
import ee.mtakso.driver.ui.helper.ErrorHandler;
import ee.mtakso.driver.utils.AppResolver;
import eu.bolt.driver.core.ui.routing.RoutingManager;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LauncherActivity_MembersInjector implements MembersInjector<LauncherActivity> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.launch.LauncherActivity.appResolver")
    public static void a(LauncherActivity launcherActivity, AppResolver appResolver) {
        launcherActivity.f30390q = appResolver;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.launch.LauncherActivity.deviceFeatures")
    public static void b(LauncherActivity launcherActivity, DeviceFeatures deviceFeatures) {
        launcherActivity.f30392s = deviceFeatures;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.launch.LauncherActivity.errorHandler")
    public static void c(LauncherActivity launcherActivity, ErrorHandler errorHandler) {
        launcherActivity.f30389p = errorHandler;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.launch.LauncherActivity.platformAvailabilityManager")
    public static void d(LauncherActivity launcherActivity, PlatformAvailabilityManager platformAvailabilityManager) {
        launcherActivity.f30391r = platformAvailabilityManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.launch.LauncherActivity.routingManager")
    public static void e(LauncherActivity launcherActivity, RoutingManager routingManager) {
        launcherActivity.f30393t = routingManager;
    }
}
