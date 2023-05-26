package ee.mtakso.driver.log.storage;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DatabaseManager_Factory implements Factory<DatabaseManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f21093a;

    public DatabaseManager_Factory(Provider<Context> provider) {
        this.f21093a = provider;
    }

    public static DatabaseManager_Factory a(Provider<Context> provider) {
        return new DatabaseManager_Factory(provider);
    }

    public static DatabaseManager c(Context context) {
        return new DatabaseManager(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DatabaseManager get() {
        return c(this.f21093a.get());
    }
}
