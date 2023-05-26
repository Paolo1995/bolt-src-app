package ee.mtakso.driver.service;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.service.auth.LightAuthFlow;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import ee.mtakso.driver.utils.BackgroundManager;
import ee.mtakso.driver.utils.power.WakeLockManager;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AwakeService_MembersInjector implements MembersInjector<AwakeService> {
    @InjectedFieldSignature("ee.mtakso.driver.service.AwakeService.authFlow")
    public static void a(AwakeService awakeService, LightAuthFlow lightAuthFlow) {
        awakeService.f23372f = lightAuthFlow;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.AwakeService.backgroundManager")
    public static void b(AwakeService awakeService, BackgroundManager backgroundManager) {
        awakeService.f23376j = backgroundManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.AwakeService.driverProvider")
    public static void c(AwakeService awakeService, DriverProvider driverProvider) {
        awakeService.f23377k = driverProvider;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.AwakeService.driverStatusProvider")
    public static void d(AwakeService awakeService, DriverStatusProvider driverStatusProvider) {
        awakeService.f23374h = driverStatusProvider;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.AwakeService.platformManager")
    public static void e(AwakeService awakeService, PlatformManager platformManager) {
        awakeService.f23379m = platformManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.AwakeService.trueTimeProvider")
    public static void f(AwakeService awakeService, TrueTimeProvider trueTimeProvider) {
        awakeService.f23373g = trueTimeProvider;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.AwakeService.uiNotificationManager")
    public static void g(AwakeService awakeService, UiNotificationManager uiNotificationManager) {
        awakeService.f23375i = uiNotificationManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.AwakeService.wakeLockManager")
    public static void h(AwakeService awakeService, WakeLockManager wakeLockManager) {
        awakeService.f23378l = wakeLockManager;
    }
}
