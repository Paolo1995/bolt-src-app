package ee.mtakso.driver.service.device.fingerprint;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.device.DeviceInfoClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DeviceFingerprintManager_Factory implements Factory<DeviceFingerprintManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeviceFingerprintCollector> f24296a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DeviceInfoClient> f24297b;

    public DeviceFingerprintManager_Factory(Provider<DeviceFingerprintCollector> provider, Provider<DeviceInfoClient> provider2) {
        this.f24296a = provider;
        this.f24297b = provider2;
    }

    public static DeviceFingerprintManager_Factory a(Provider<DeviceFingerprintCollector> provider, Provider<DeviceInfoClient> provider2) {
        return new DeviceFingerprintManager_Factory(provider, provider2);
    }

    public static DeviceFingerprintManager c(DeviceFingerprintCollector deviceFingerprintCollector, DeviceInfoClient deviceInfoClient) {
        return new DeviceFingerprintManager(deviceFingerprintCollector, deviceInfoClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DeviceFingerprintManager get() {
        return c(this.f24296a.get(), this.f24297b.get());
    }
}
