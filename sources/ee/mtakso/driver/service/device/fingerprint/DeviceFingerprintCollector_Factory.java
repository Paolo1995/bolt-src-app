package ee.mtakso.driver.service.device.fingerprint;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.platform.installation.InstallationIdProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DeviceFingerprintCollector_Factory implements Factory<DeviceFingerprintCollector> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f24291a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<InstallationIdProvider> f24292b;

    public DeviceFingerprintCollector_Factory(Provider<Context> provider, Provider<InstallationIdProvider> provider2) {
        this.f24291a = provider;
        this.f24292b = provider2;
    }

    public static DeviceFingerprintCollector_Factory a(Provider<Context> provider, Provider<InstallationIdProvider> provider2) {
        return new DeviceFingerprintCollector_Factory(provider, provider2);
    }

    public static DeviceFingerprintCollector c(Context context, InstallationIdProvider installationIdProvider) {
        return new DeviceFingerprintCollector(context, installationIdProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DeviceFingerprintCollector get() {
        return c(this.f24291a.get(), this.f24292b.get());
    }
}
