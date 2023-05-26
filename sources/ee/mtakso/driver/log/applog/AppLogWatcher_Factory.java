package ee.mtakso.driver.log.applog;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.log.InternalLog;
import ee.mtakso.driver.log.LogWorker;
import ee.mtakso.driver.log.storage.DatabaseManager;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AppLogWatcher_Factory implements Factory<AppLogWatcher> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DatabaseManager> f21052a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<InternalLog> f21053b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApplogUploader> f21054c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<LogWorker> f21055d;

    public AppLogWatcher_Factory(Provider<DatabaseManager> provider, Provider<InternalLog> provider2, Provider<ApplogUploader> provider3, Provider<LogWorker> provider4) {
        this.f21052a = provider;
        this.f21053b = provider2;
        this.f21054c = provider3;
        this.f21055d = provider4;
    }

    public static AppLogWatcher_Factory a(Provider<DatabaseManager> provider, Provider<InternalLog> provider2, Provider<ApplogUploader> provider3, Provider<LogWorker> provider4) {
        return new AppLogWatcher_Factory(provider, provider2, provider3, provider4);
    }

    public static AppLogWatcher c(DatabaseManager databaseManager, InternalLog internalLog, ApplogUploader applogUploader, LogWorker logWorker) {
        return new AppLogWatcher(databaseManager, internalLog, applogUploader, logWorker);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AppLogWatcher get() {
        return c(this.f21052a.get(), this.f21053b.get(), this.f21054c.get(), this.f21055d.get());
    }
}
