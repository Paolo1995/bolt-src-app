package ee.mtakso.driver.param;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.storage.BoltPrefsStorageMigration;
import eu.bolt.driver.core.storage.StorageFactory;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DeviceSettings_Factory implements Factory<DeviceSettings> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f23109a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BoltPrefsStorageMigration> f23110b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<StorageFactory> f23111c;

    public DeviceSettings_Factory(Provider<Context> provider, Provider<BoltPrefsStorageMigration> provider2, Provider<StorageFactory> provider3) {
        this.f23109a = provider;
        this.f23110b = provider2;
        this.f23111c = provider3;
    }

    public static DeviceSettings_Factory a(Provider<Context> provider, Provider<BoltPrefsStorageMigration> provider2, Provider<StorageFactory> provider3) {
        return new DeviceSettings_Factory(provider, provider2, provider3);
    }

    public static DeviceSettings c(Context context, BoltPrefsStorageMigration boltPrefsStorageMigration, StorageFactory storageFactory) {
        return new DeviceSettings(context, boltPrefsStorageMigration, storageFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DeviceSettings get() {
        return c(this.f23109a.get(), this.f23110b.get(), this.f23111c.get());
    }
}
