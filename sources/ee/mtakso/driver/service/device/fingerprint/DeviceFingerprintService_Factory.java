package ee.mtakso.driver.service.device.fingerprint;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DeviceFingerprintService_Factory implements Factory<DeviceFingerprintService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeviceFingerprintManager> f24301a;

    public DeviceFingerprintService_Factory(Provider<DeviceFingerprintManager> provider) {
        this.f24301a = provider;
    }

    public static DeviceFingerprintService_Factory a(Provider<DeviceFingerprintManager> provider) {
        return new DeviceFingerprintService_Factory(provider);
    }

    public static DeviceFingerprintService c(DeviceFingerprintManager deviceFingerprintManager) {
        return new DeviceFingerprintService(deviceFingerprintManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DeviceFingerprintService get() {
        return c(this.f24301a.get());
    }
}
