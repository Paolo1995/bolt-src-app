package ee.mtakso.driver.log.applog;

import ee.mtakso.driver.log.InternalLog;
import ee.mtakso.driver.log.LogWorker;
import ee.mtakso.driver.log.applog.AppLogWatcher;
import ee.mtakso.driver.log.storage.ApplogSync;
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

/* compiled from: AppLogWatcher.kt */
@Singleton
/* loaded from: classes3.dex */
public final class AppLogWatcher implements BaseService {

    /* renamed from: a  reason: collision with root package name */
    private final DatabaseManager f21047a;

    /* renamed from: b  reason: collision with root package name */
    private final InternalLog f21048b;

    /* renamed from: c  reason: collision with root package name */
    private final ApplogUploader f21049c;

    /* renamed from: d  reason: collision with root package name */
    private final LogWorker f21050d;

    /* renamed from: e  reason: collision with root package name */
    private ScheduledFuture<?> f21051e;

    @Inject
    public AppLogWatcher(DatabaseManager logDatabaseManager, InternalLog logger, ApplogUploader applogUploader, LogWorker logWorker) {
        Intrinsics.f(logDatabaseManager, "logDatabaseManager");
        Intrinsics.f(logger, "logger");
        Intrinsics.f(applogUploader, "applogUploader");
        Intrinsics.f(logWorker, "logWorker");
        this.f21047a = logDatabaseManager;
        this.f21048b = logger;
        this.f21049c = applogUploader;
        this.f21050d = logWorker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AppLogWatcher this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.g();
    }

    private final void g() {
        int v7;
        List<LogEntity> k8 = this.f21047a.d().G().k();
        if (k8.isEmpty()) {
            return;
        }
        InternalLog internalLog = this.f21048b;
        int size = k8.size();
        internalLog.b("Uploading: " + size + " entries");
        if (this.f21049c.b(k8)) {
            LogDao G = this.f21047a.d().G();
            v7 = CollectionsKt__IterablesKt.v(k8, 10);
            ArrayList arrayList = new ArrayList(v7);
            for (LogEntity logEntity : k8) {
                arrayList.add(new ApplogSync(logEntity.f(), true));
            }
            G.m(arrayList);
        }
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        if (this.f21051e != null) {
            AssertUtils.a("Already running");
            return false;
        }
        this.f21051e = this.f21050d.b(new Runnable() { // from class: s1.a
            @Override // java.lang.Runnable
            public final void run() {
                AppLogWatcher.f(AppLogWatcher.this);
            }
        }, 60L);
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        ScheduledFuture<?> scheduledFuture = this.f21051e;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f21051e = null;
    }
}
