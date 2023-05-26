package ee.mtakso.driver.di.modules;

import android.content.pm.PackageInfo;
import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.utils.DeviceUuidManager;
import ee.mtakso.driver.utils.Utils;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReleaseDeviceInfoModule.kt */
@Module
/* loaded from: classes3.dex */
public final class ReleaseDeviceInfoModule {
    @Provides
    public final DeviceInfo a(PackageInfo packageInfo, DeviceUuidManager deviceUuidManager) {
        Intrinsics.f(packageInfo, "packageInfo");
        Intrinsics.f(deviceUuidManager, "deviceUuidManager");
        String str = packageInfo.versionName;
        Intrinsics.e(str, "packageInfo.versionName");
        String d8 = Utils.d();
        Intrinsics.e(d8, "getAndroidVersion()");
        String b8 = deviceUuidManager.b();
        String e8 = Utils.e();
        Intrinsics.e(e8, "getDeviceName()");
        return new DeviceInfo(str, d8, b8, e8);
    }
}
