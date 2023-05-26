package ee.mtakso.driver.log;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.log.storage.DatabaseManager;
import ee.mtakso.driver.log.strategy.memory.WebViewStrategy;
import ee.mtakso.driver.service.modules.reporters.WrongStateReporter;
import ee.mtakso.driver.utils.logs.PersistPoeg;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LogManager_Factory implements Factory<LogManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DatabaseManager> f21014a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<LogWorker> f21015b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<WrongStateReporter> f21016c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<CrashlyticsConsumer> f21017d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<WebViewStrategy> f21018e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<PersistPoeg> f21019f;

    public LogManager_Factory(Provider<DatabaseManager> provider, Provider<LogWorker> provider2, Provider<WrongStateReporter> provider3, Provider<CrashlyticsConsumer> provider4, Provider<WebViewStrategy> provider5, Provider<PersistPoeg> provider6) {
        this.f21014a = provider;
        this.f21015b = provider2;
        this.f21016c = provider3;
        this.f21017d = provider4;
        this.f21018e = provider5;
        this.f21019f = provider6;
    }

    public static LogManager_Factory a(Provider<DatabaseManager> provider, Provider<LogWorker> provider2, Provider<WrongStateReporter> provider3, Provider<CrashlyticsConsumer> provider4, Provider<WebViewStrategy> provider5, Provider<PersistPoeg> provider6) {
        return new LogManager_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static LogManager c(DatabaseManager databaseManager, LogWorker logWorker, WrongStateReporter wrongStateReporter, CrashlyticsConsumer crashlyticsConsumer, WebViewStrategy webViewStrategy, PersistPoeg persistPoeg) {
        return new LogManager(databaseManager, logWorker, wrongStateReporter, crashlyticsConsumer, webViewStrategy, persistPoeg);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LogManager get() {
        return c(this.f21014a.get(), this.f21015b.get(), this.f21016c.get(), this.f21017d.get(), this.f21018e.get(), this.f21019f.get());
    }
}
