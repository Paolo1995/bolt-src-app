package ee.mtakso.driver.log;

import ee.mtakso.driver.log.StorageConsumer;
import ee.mtakso.driver.log.storage.LogSaver;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import eu.bolt.kalev.Kalevipoeg;
import eu.bolt.kalev.LogEntry;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorageConsumer.kt */
/* loaded from: classes3.dex */
public final class StorageConsumer implements Kalevipoeg {

    /* renamed from: a  reason: collision with root package name */
    private final LogSaver f21035a;

    /* renamed from: b  reason: collision with root package name */
    private final LogWorker f21036b;

    /* renamed from: c  reason: collision with root package name */
    private final LogFilter f21037c;

    /* renamed from: d  reason: collision with root package name */
    private final InternalLog f21038d;

    /* renamed from: e  reason: collision with root package name */
    private final DriverProvider f21039e;

    /* renamed from: f  reason: collision with root package name */
    private final LinkedBlockingQueue<LogEntry> f21040f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f21041g;

    @Inject
    public StorageConsumer(LogSaver logsStorage, LogWorker logWorker, LogFilter predicate, InternalLog internalLog, DriverProvider provider) {
        Intrinsics.f(logsStorage, "logsStorage");
        Intrinsics.f(logWorker, "logWorker");
        Intrinsics.f(predicate, "predicate");
        Intrinsics.f(internalLog, "internalLog");
        Intrinsics.f(provider, "provider");
        this.f21035a = logsStorage;
        this.f21036b = logWorker;
        this.f21037c = predicate;
        this.f21038d = internalLog;
        this.f21039e = provider;
        this.f21040f = new LinkedBlockingQueue<>();
    }

    private final void c() {
        ArrayList arrayList = new ArrayList();
        while (!this.f21040f.isEmpty()) {
            LogEntry poll = this.f21040f.poll();
            Intrinsics.e(poll, "logQueue.poll()");
            arrayList.add(poll);
        }
        this.f21035a.a(arrayList);
    }

    private final void d() {
        synchronized (this) {
            if (!this.f21041g) {
                this.f21041g = true;
                this.f21036b.b(new Runnable() { // from class: r1.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        StorageConsumer.e(StorageConsumer.this);
                    }
                }, 5L);
            }
            Unit unit = Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(StorageConsumer this$0) {
        Intrinsics.f(this$0, "this$0");
        try {
            this$0.c();
        } catch (Exception e8) {
            this$0.f21038d.c(e8);
        }
    }

    @Override // eu.bolt.kalev.Kalevipoeg
    public void a(LogEntry entry) {
        Long l8;
        Intrinsics.f(entry, "entry");
        if (!this.f21037c.a(entry)) {
            return;
        }
        d();
        DriverConfig d8 = this.f21039e.d();
        if (d8 != null) {
            l8 = Long.valueOf(d8.t());
        } else {
            l8 = null;
        }
        entry.n("driver_id", l8);
        this.f21040f.add(entry);
    }
}
