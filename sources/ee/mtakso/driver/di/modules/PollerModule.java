package ee.mtakso.driver.di.modules;

import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.modules.polling.Poller;
import ee.mtakso.driver.service.pollerv2.DynamicPollingService;
import ee.mtakso.driver.service.pollerv2.FixedPollingService;
import ee.mtakso.driver.service.pollerv2.PollerService;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PollerModule.kt */
@Module(includes = {PollerBindings.class})
/* loaded from: classes3.dex */
public final class PollerModule {
    @Provides
    public final PollerSource a(DriverFeatures driverFeatures, Poller poller, DynamicPollingService dynamicPollingService, FixedPollingService fixedPollingService) {
        Intrinsics.f(driverFeatures, "driverFeatures");
        Intrinsics.f(poller, "poller");
        Intrinsics.f(dynamicPollingService, "dynamicPollingService");
        Intrinsics.f(fixedPollingService, "fixedPollingService");
        if (driverFeatures.I()) {
            if (!driverFeatures.s()) {
                return fixedPollingService;
            }
            return dynamicPollingService;
        }
        return poller;
    }

    @Provides
    public final PollerService b(DriverProvider driverProvider, DynamicPollingService dynamicPollingService, FixedPollingService fixedPollingService) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(dynamicPollingService, "dynamicPollingService");
        Intrinsics.f(fixedPollingService, "fixedPollingService");
        if (!driverProvider.q().s()) {
            return fixedPollingService;
        }
        return dynamicPollingService;
    }
}
