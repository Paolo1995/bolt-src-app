package ee.mtakso.driver.di.modules;

import android.content.pm.PackageInfo;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.utils.DeviceUuidManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ReleaseDeviceInfoModule_ProvidesDeviceInfoFactory implements Factory<DeviceInfo> {

    /* renamed from: a  reason: collision with root package name */
    private final ReleaseDeviceInfoModule f20866a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PackageInfo> f20867b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DeviceUuidManager> f20868c;

    public ReleaseDeviceInfoModule_ProvidesDeviceInfoFactory(ReleaseDeviceInfoModule releaseDeviceInfoModule, Provider<PackageInfo> provider, Provider<DeviceUuidManager> provider2) {
        this.f20866a = releaseDeviceInfoModule;
        this.f20867b = provider;
        this.f20868c = provider2;
    }

    public static ReleaseDeviceInfoModule_ProvidesDeviceInfoFactory a(ReleaseDeviceInfoModule releaseDeviceInfoModule, Provider<PackageInfo> provider, Provider<DeviceUuidManager> provider2) {
        return new ReleaseDeviceInfoModule_ProvidesDeviceInfoFactory(releaseDeviceInfoModule, provider, provider2);
    }

    public static DeviceInfo c(ReleaseDeviceInfoModule releaseDeviceInfoModule, PackageInfo packageInfo, DeviceUuidManager deviceUuidManager) {
        return (DeviceInfo) Preconditions.checkNotNullFromProvides(releaseDeviceInfoModule.a(packageInfo, deviceUuidManager));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DeviceInfo get() {
        return c(this.f20866a, this.f20867b.get(), this.f20868c.get());
    }
}
