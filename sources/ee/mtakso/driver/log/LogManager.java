package ee.mtakso.driver.log;

import ee.mtakso.driver.log.LogManager;
import ee.mtakso.driver.log.storage.DatabaseManager;
import ee.mtakso.driver.log.strategy.memory.WebViewStrategy;
import ee.mtakso.driver.service.modules.reporters.WrongStateReporter;
import ee.mtakso.driver.utils.logs.PersistPoeg;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.Kalevipoeg;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class LogManager {

    /* renamed from: a  reason: collision with root package name */
    private final DatabaseManager f21007a;

    /* renamed from: b  reason: collision with root package name */
    private final LogWorker f21008b;

    /* renamed from: c  reason: collision with root package name */
    private final WrongStateReporter f21009c;

    /* renamed from: d  reason: collision with root package name */
    private final CrashlyticsConsumer f21010d;

    /* renamed from: e  reason: collision with root package name */
    private final WebViewStrategy f21011e;

    /* renamed from: f  reason: collision with root package name */
    private final PersistPoeg f21012f;

    /* renamed from: g  reason: collision with root package name */
    private final CompositePoeg f21013g;

    @Inject
    public LogManager(DatabaseManager storageCleaner, LogWorker logWorker, WrongStateReporter wrongStateReporter, CrashlyticsConsumer crashlyticsConsumer, WebViewStrategy webViewStrategy, PersistPoeg persistPoeg) {
        Intrinsics.f(storageCleaner, "storageCleaner");
        Intrinsics.f(logWorker, "logWorker");
        Intrinsics.f(wrongStateReporter, "wrongStateReporter");
        Intrinsics.f(crashlyticsConsumer, "crashlyticsConsumer");
        Intrinsics.f(webViewStrategy, "webViewStrategy");
        Intrinsics.f(persistPoeg, "persistPoeg");
        this.f21007a = storageCleaner;
        this.f21008b = logWorker;
        this.f21009c = wrongStateReporter;
        this.f21010d = crashlyticsConsumer;
        this.f21011e = webViewStrategy;
        this.f21012f = persistPoeg;
        this.f21013g = new CompositePoeg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LogManager this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f21007a.a();
    }

    public final void b(Kalevipoeg consumer) {
        Intrinsics.f(consumer, "consumer");
        this.f21013g.b(consumer);
    }

    public final void c() {
        this.f21013g.c();
    }

    public final void d() {
        this.f21008b.a(new Runnable() { // from class: r1.a
            @Override // java.lang.Runnable
            public final void run() {
                LogManager.e(LogManager.this);
            }
        });
        Kalev.a(this.f21010d);
        Kalev.a(new StateConsumer(this.f21009c));
        Kalev.a(this.f21013g);
        Kalev.a(this.f21011e);
        Kalev.a(this.f21012f);
    }
}
