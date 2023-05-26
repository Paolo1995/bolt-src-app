package ee.mtakso.driver.di.modules;

import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.log.InternalLog;
import ee.mtakso.driver.log.applog.ApplogFactory;
import ee.mtakso.driver.log.applog.ApplogUploader;
import ee.mtakso.driver.network.client.applog.AppLogClient;
import ee.mtakso.driver.param.DeviceFeatures;
import ee.mtakso.driver.param.DriverProvider;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogsModule.kt */
@Module(includes = {LogsBindings.class})
/* loaded from: classes3.dex */
public final class LogsModule {
    @Provides
    @Singleton
    public final ApplogUploader a(AppLogClient appLogClient, DriverProvider driverProvider, ApplogFactory factory, InternalLog internalLog, DeviceFeatures deviceFeatures) {
        Intrinsics.f(appLogClient, "appLogClient");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(factory, "factory");
        Intrinsics.f(internalLog, "internalLog");
        Intrinsics.f(deviceFeatures, "deviceFeatures");
        return factory.a(appLogClient, driverProvider, internalLog, deviceFeatures);
    }
}
