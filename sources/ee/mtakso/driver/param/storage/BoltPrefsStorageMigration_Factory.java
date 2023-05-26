package ee.mtakso.driver.param.storage;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class BoltPrefsStorageMigration_Factory implements Factory<BoltPrefsStorageMigration> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f23271a;

    public BoltPrefsStorageMigration_Factory(Provider<Context> provider) {
        this.f23271a = provider;
    }

    public static BoltPrefsStorageMigration_Factory a(Provider<Context> provider) {
        return new BoltPrefsStorageMigration_Factory(provider);
    }

    public static BoltPrefsStorageMigration c(Context context) {
        return new BoltPrefsStorageMigration(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public BoltPrefsStorageMigration get() {
        return c(this.f23271a.get());
    }
}
