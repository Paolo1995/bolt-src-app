package ee.mtakso.driver.log.bigquery;

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
public final class BigQueryLogWatcher_Factory implements Factory<BigQueryLogWatcher> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DatabaseManager> f21076a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<InternalLog> f21077b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<BigQueryUploader> f21078c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<LogWorker> f21079d;

    public BigQueryLogWatcher_Factory(Provider<DatabaseManager> provider, Provider<InternalLog> provider2, Provider<BigQueryUploader> provider3, Provider<LogWorker> provider4) {
        this.f21076a = provider;
        this.f21077b = provider2;
        this.f21078c = provider3;
        this.f21079d = provider4;
    }

    public static BigQueryLogWatcher_Factory a(Provider<DatabaseManager> provider, Provider<InternalLog> provider2, Provider<BigQueryUploader> provider3, Provider<LogWorker> provider4) {
        return new BigQueryLogWatcher_Factory(provider, provider2, provider3, provider4);
    }

    public static BigQueryLogWatcher c(DatabaseManager databaseManager, InternalLog internalLog, BigQueryUploader bigQueryUploader, LogWorker logWorker) {
        return new BigQueryLogWatcher(databaseManager, internalLog, bigQueryUploader, logWorker);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public BigQueryLogWatcher get() {
        return c(this.f21076a.get(), this.f21077b.get(), this.f21078c.get(), this.f21079d.get());
    }
}
