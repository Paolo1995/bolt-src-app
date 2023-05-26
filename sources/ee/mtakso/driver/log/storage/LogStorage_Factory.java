package ee.mtakso.driver.log.storage;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LogStorage_Factory implements Factory<LogStorage> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DatabaseManager> f21118a;

    public LogStorage_Factory(Provider<DatabaseManager> provider) {
        this.f21118a = provider;
    }

    public static LogStorage_Factory a(Provider<DatabaseManager> provider) {
        return new LogStorage_Factory(provider);
    }

    public static LogStorage c(DatabaseManager databaseManager) {
        return new LogStorage(databaseManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LogStorage get() {
        return c(this.f21118a.get());
    }
}
