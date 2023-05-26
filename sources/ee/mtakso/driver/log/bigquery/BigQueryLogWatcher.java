package ee.mtakso.driver.log.bigquery;

import ee.mtakso.driver.log.InternalLog;
import ee.mtakso.driver.log.LogWorker;
import ee.mtakso.driver.log.bigquery.BigQueryLogWatcher;
import ee.mtakso.driver.log.storage.BigQuerySync;
import ee.mtakso.driver.log.storage.DatabaseManager;
import ee.mtakso.driver.log.storage.LogDao;
import ee.mtakso.driver.log.storage.LogEntity;
import ee.mtakso.driver.service.BaseService;
import ee.mtakso.driver.utils.AssertUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BigQueryLogWatcher.kt */
@Singleton
/* loaded from: classes3.dex */
public final class BigQueryLogWatcher implements BaseService {

    /* renamed from: a  reason: collision with root package name */
    private final DatabaseManager f21071a;

    /* renamed from: b  reason: collision with root package name */
    private final InternalLog f21072b;

    /* renamed from: c  reason: collision with root package name */
    private final BigQueryUploader f21073c;

    /* renamed from: d  reason: collision with root package name */
    private final LogWorker f21074d;

    /* renamed from: e  reason: collision with root package name */
    private ScheduledFuture<?> f21075e;

    @Inject
    public BigQueryLogWatcher(DatabaseManager logDatabaseManager, InternalLog logger, BigQueryUploader firebaseUploader, LogWorker logWorker) {
        Intrinsics.f(logDatabaseManager, "logDatabaseManager");
        Intrinsics.f(logger, "logger");
        Intrinsics.f(firebaseUploader, "firebaseUploader");
        Intrinsics.f(logWorker, "logWorker");
        this.f21071a = logDatabaseManager;
        this.f21072b = logger;
        this.f21073c = firebaseUploader;
        this.f21074d = logWorker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(BigQueryLogWatcher this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.g();
    }

    private final void g() {
        int v7;
        List<LogEntity> e8 = this.f21071a.d().G().e();
        InternalLog internalLog = this.f21072b;
        int size = e8.size();
        internalLog.b("Uploading: " + size + " entries");
        this.f21073c.e(e8);
        LogDao G = this.f21071a.d().G();
        v7 = CollectionsKt__IterablesKt.v(e8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (LogEntity logEntity : e8) {
            arrayList.add(new BigQuerySync(logEntity.f(), true));
        }
        G.j(arrayList);
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        if (this.f21075e != null) {
            AssertUtils.a("Already running");
            return false;
        }
        this.f21075e = this.f21074d.b(new Runnable() { // from class: t1.a
            @Override // java.lang.Runnable
            public final void run() {
                BigQueryLogWatcher.f(BigQueryLogWatcher.this);
            }
        }, 60L);
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        ScheduledFuture<?> scheduledFuture = this.f21075e;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f21075e = null;
    }
}
