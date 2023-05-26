package ee.mtakso.driver.log.applog;

import ee.mtakso.driver.log.InternalLog;
import ee.mtakso.driver.network.client.applog.AppLogClient;
import ee.mtakso.driver.param.DeviceFeatures;
import ee.mtakso.driver.param.DriverProvider;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApplogFactory.kt */
/* loaded from: classes3.dex */
public final class ApplogFactory {
    public final ApplogUploader a(AppLogClient appLogClient, DriverProvider driverProvider, InternalLog internalLog, DeviceFeatures deviceFeatures) {
        Intrinsics.f(appLogClient, "appLogClient");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(internalLog, "internalLog");
        Intrinsics.f(deviceFeatures, "deviceFeatures");
        return new ApplogUploader(appLogClient, internalLog, driverProvider, deviceFeatures);
    }
}
