package ee.mtakso.driver.utils;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DeviceSettings;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class DeviceUuidManager_Factory implements Factory<DeviceUuidManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeviceSettings> f36305a;

    public DeviceUuidManager_Factory(Provider<DeviceSettings> provider) {
        this.f36305a = provider;
    }

    public static DeviceUuidManager_Factory a(Provider<DeviceSettings> provider) {
        return new DeviceUuidManager_Factory(provider);
    }

    public static DeviceUuidManager c(DeviceSettings deviceSettings) {
        return new DeviceUuidManager(deviceSettings);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DeviceUuidManager get() {
        return c(this.f36305a.get());
    }
}
