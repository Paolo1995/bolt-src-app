package ee.mtakso.driver.log.storage;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.log.InternalLog;
import ee.mtakso.driver.log.strategy.CompositeWatcher;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LogSaver_Factory implements Factory<LogSaver> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DatabaseManager> f21114a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<InternalLog> f21115b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CompositeWatcher> f21116c;

    public LogSaver_Factory(Provider<DatabaseManager> provider, Provider<InternalLog> provider2, Provider<CompositeWatcher> provider3) {
        this.f21114a = provider;
        this.f21115b = provider2;
        this.f21116c = provider3;
    }

    public static LogSaver_Factory a(Provider<DatabaseManager> provider, Provider<InternalLog> provider2, Provider<CompositeWatcher> provider3) {
        return new LogSaver_Factory(provider, provider2, provider3);
    }

    public static LogSaver c(DatabaseManager databaseManager, InternalLog internalLog, CompositeWatcher compositeWatcher) {
        return new LogSaver(databaseManager, internalLog, compositeWatcher);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LogSaver get() {
        return c(this.f21114a.get(), this.f21115b.get(), this.f21116c.get());
    }
}
