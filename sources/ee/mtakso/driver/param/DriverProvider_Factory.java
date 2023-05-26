package ee.mtakso.driver.param;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.storage.BoltPrefsStorageMigration;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverProvider_Factory implements Factory<DriverProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f23154a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BoltPrefsStorageMigration> f23155b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DeviceSettings> f23156c;

    public DriverProvider_Factory(Provider<Context> provider, Provider<BoltPrefsStorageMigration> provider2, Provider<DeviceSettings> provider3) {
        this.f23154a = provider;
        this.f23155b = provider2;
        this.f23156c = provider3;
    }

    public static DriverProvider_Factory a(Provider<Context> provider, Provider<BoltPrefsStorageMigration> provider2, Provider<DeviceSettings> provider3) {
        return new DriverProvider_Factory(provider, provider2, provider3);
    }

    public static DriverProvider c(Context context, BoltPrefsStorageMigration boltPrefsStorageMigration, DeviceSettings deviceSettings) {
        return new DriverProvider(context, boltPrefsStorageMigration, deviceSettings);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverProvider get() {
        return c(this.f23154a.get(), this.f23155b.get(), this.f23156c.get());
    }
}
