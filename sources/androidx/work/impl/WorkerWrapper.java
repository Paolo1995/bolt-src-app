package androidx.work.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public class WorkerWrapper implements Runnable {

    /* renamed from: y  reason: collision with root package name */
    static final String f8407y = Logger.f("WorkerWrapper");

    /* renamed from: f  reason: collision with root package name */
    Context f8408f;

    /* renamed from: g  reason: collision with root package name */
    private String f8409g;

    /* renamed from: h  reason: collision with root package name */
    private List<Scheduler> f8410h;

    /* renamed from: i  reason: collision with root package name */
    private WorkerParameters.RuntimeExtras f8411i;

    /* renamed from: j  reason: collision with root package name */
    WorkSpec f8412j;

    /* renamed from: k  reason: collision with root package name */
    ListenableWorker f8413k;

    /* renamed from: l  reason: collision with root package name */
    TaskExecutor f8414l;

    /* renamed from: n  reason: collision with root package name */
    private Configuration f8416n;

    /* renamed from: o  reason: collision with root package name */
    private ForegroundProcessor f8417o;

    /* renamed from: p  reason: collision with root package name */
    private WorkDatabase f8418p;

    /* renamed from: q  reason: collision with root package name */
    private WorkSpecDao f8419q;

    /* renamed from: r  reason: collision with root package name */
    private DependencyDao f8420r;

    /* renamed from: s  reason: collision with root package name */
    private WorkTagDao f8421s;

    /* renamed from: t  reason: collision with root package name */
    private List<String> f8422t;

    /* renamed from: u  reason: collision with root package name */
    private String f8423u;

    /* renamed from: x  reason: collision with root package name */
    private volatile boolean f8426x;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    ListenableWorker.Result f8415m = ListenableWorker.Result.a();
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    SettableFuture<Boolean> f8424v = SettableFuture.t();

    /* renamed from: w  reason: collision with root package name */
    ListenableFuture<ListenableWorker.Result> f8425w = null;

    /* loaded from: classes.dex */
    public static class Builder {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        Context f8433a;

        /* renamed from: b  reason: collision with root package name */
        ListenableWorker f8434b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        ForegroundProcessor f8435c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        TaskExecutor f8436d;
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        Configuration f8437e;
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        WorkDatabase f8438f;
        @NonNull

        /* renamed from: g  reason: collision with root package name */
        String f8439g;

        /* renamed from: h  reason: collision with root package name */
        List<Scheduler> f8440h;
        @NonNull

        /* renamed from: i  reason: collision with root package name */
        WorkerParameters.RuntimeExtras f8441i = new WorkerParameters.RuntimeExtras();

        public Builder(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull ForegroundProcessor foregroundProcessor, @NonNull WorkDatabase workDatabase, @NonNull String str) {
            this.f8433a = context.getApplicationContext();
            this.f8436d = taskExecutor;
            this.f8435c = foregroundProcessor;
            this.f8437e = configuration;
            this.f8438f = workDatabase;
            this.f8439g = str;
        }

        @NonNull
        public WorkerWrapper a() {
            return new WorkerWrapper(this);
        }

        @NonNull
        public Builder b(WorkerParameters.RuntimeExtras runtimeExtras) {
            if (runtimeExtras != null) {
                this.f8441i = runtimeExtras;
            }
            return this;
        }

        @NonNull
        public Builder c(@NonNull List<Scheduler> list) {
            this.f8440h = list;
            return this;
        }
    }

    WorkerWrapper(@NonNull Builder builder) {
        this.f8408f = builder.f8433a;
        this.f8414l = builder.f8436d;
        this.f8417o = builder.f8435c;
        this.f8409g = builder.f8439g;
        this.f8410h = builder.f8440h;
        this.f8411i = builder.f8441i;
        this.f8413k = builder.f8434b;
        this.f8416n = builder.f8437e;
        WorkDatabase workDatabase = builder.f8438f;
        this.f8418p = workDatabase;
        this.f8419q = workDatabase.P();
        this.f8420r = this.f8418p.H();
        this.f8421s = this.f8418p.Q();
    }

    private String a(List<String> list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.f8409g);
        sb.append(", tags={ ");
        boolean z7 = true;
        for (String str : list) {
            if (z7) {
                z7 = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    private void c(ListenableWorker.Result result) {
        if (result instanceof ListenableWorker.Result.Success) {
            Logger.c().d(f8407y, String.format("Worker result SUCCESS for %s", this.f8423u), new Throwable[0]);
            if (this.f8412j.d()) {
                h();
            } else {
                m();
            }
        } else if (result instanceof ListenableWorker.Result.Retry) {
            Logger.c().d(f8407y, String.format("Worker result RETRY for %s", this.f8423u), new Throwable[0]);
            g();
        } else {
            Logger.c().d(f8407y, String.format("Worker result FAILURE for %s", this.f8423u), new Throwable[0]);
            if (this.f8412j.d()) {
                h();
            } else {
                l();
            }
        }
    }

    private void e(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.f8419q.g(str2) != WorkInfo.State.CANCELLED) {
                this.f8419q.a(WorkInfo.State.FAILED, str2);
            }
            linkedList.addAll(this.f8420r.b(str2));
        }
    }

    private void g() {
        this.f8418p.e();
        try {
            this.f8419q.a(WorkInfo.State.ENQUEUED, this.f8409g);
            this.f8419q.u(this.f8409g, System.currentTimeMillis());
            this.f8419q.m(this.f8409g, -1L);
            this.f8418p.E();
        } finally {
            this.f8418p.i();
            i(true);
        }
    }

    private void h() {
        this.f8418p.e();
        try {
            this.f8419q.u(this.f8409g, System.currentTimeMillis());
            this.f8419q.a(WorkInfo.State.ENQUEUED, this.f8409g);
            this.f8419q.s(this.f8409g);
            this.f8419q.m(this.f8409g, -1L);
            this.f8418p.E();
        } finally {
            this.f8418p.i();
            i(false);
        }
    }

    private void i(boolean z7) {
        ListenableWorker listenableWorker;
        this.f8418p.e();
        try {
            if (!this.f8418p.P().r()) {
                PackageManagerHelper.a(this.f8408f, RescheduleReceiver.class, false);
            }
            if (z7) {
                this.f8419q.a(WorkInfo.State.ENQUEUED, this.f8409g);
                this.f8419q.m(this.f8409g, -1L);
            }
            if (this.f8412j != null && (listenableWorker = this.f8413k) != null && listenableWorker.j()) {
                this.f8417o.a(this.f8409g);
            }
            this.f8418p.E();
            this.f8418p.i();
            this.f8424v.p(Boolean.valueOf(z7));
        } catch (Throwable th) {
            this.f8418p.i();
            throw th;
        }
    }

    private void j() {
        WorkInfo.State g8 = this.f8419q.g(this.f8409g);
        if (g8 == WorkInfo.State.RUNNING) {
            Logger.c().a(f8407y, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.f8409g), new Throwable[0]);
            i(true);
            return;
        }
        Logger.c().a(f8407y, String.format("Status for %s is %s; not doing any work", this.f8409g, g8), new Throwable[0]);
        i(false);
    }

    private void k() {
        boolean z7;
        Data b8;
        if (n()) {
            return;
        }
        this.f8418p.e();
        try {
            WorkSpec h8 = this.f8419q.h(this.f8409g);
            this.f8412j = h8;
            if (h8 == null) {
                Logger.c().b(f8407y, String.format("Didn't find WorkSpec for id %s", this.f8409g), new Throwable[0]);
                i(false);
                this.f8418p.E();
            } else if (h8.f8619b != WorkInfo.State.ENQUEUED) {
                j();
                this.f8418p.E();
                Logger.c().a(f8407y, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.f8412j.f8620c), new Throwable[0]);
            } else {
                if (h8.d() || this.f8412j.c()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    WorkSpec workSpec = this.f8412j;
                    if (workSpec.f8631n == 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (!z7 && currentTimeMillis < workSpec.a()) {
                        Logger.c().a(f8407y, String.format("Delaying execution for %s because it is being executed before schedule.", this.f8412j.f8620c), new Throwable[0]);
                        i(true);
                        this.f8418p.E();
                        return;
                    }
                }
                this.f8418p.E();
                this.f8418p.i();
                if (this.f8412j.d()) {
                    b8 = this.f8412j.f8622e;
                } else {
                    InputMerger b9 = this.f8416n.e().b(this.f8412j.f8621d);
                    if (b9 == null) {
                        Logger.c().b(f8407y, String.format("Could not create Input Merger %s", this.f8412j.f8621d), new Throwable[0]);
                        l();
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f8412j.f8622e);
                    arrayList.addAll(this.f8419q.j(this.f8409g));
                    b8 = b9.b(arrayList);
                }
                WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.f8409g), b8, this.f8422t, this.f8411i, this.f8412j.f8628k, this.f8416n.d(), this.f8414l, this.f8416n.l(), new WorkProgressUpdater(this.f8418p, this.f8414l), new WorkForegroundUpdater(this.f8418p, this.f8417o, this.f8414l));
                if (this.f8413k == null) {
                    this.f8413k = this.f8416n.l().b(this.f8408f, this.f8412j.f8620c, workerParameters);
                }
                ListenableWorker listenableWorker = this.f8413k;
                if (listenableWorker == null) {
                    Logger.c().b(f8407y, String.format("Could not create Worker %s", this.f8412j.f8620c), new Throwable[0]);
                    l();
                } else if (listenableWorker.l()) {
                    Logger.c().b(f8407y, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.f8412j.f8620c), new Throwable[0]);
                    l();
                } else {
                    this.f8413k.o();
                    if (o()) {
                        if (n()) {
                            return;
                        }
                        final SettableFuture t7 = SettableFuture.t();
                        WorkForegroundRunnable workForegroundRunnable = new WorkForegroundRunnable(this.f8408f, this.f8412j, this.f8413k, workerParameters.b(), this.f8414l);
                        this.f8414l.a().execute(workForegroundRunnable);
                        final ListenableFuture<Void> a8 = workForegroundRunnable.a();
                        a8.f(new Runnable() { // from class: androidx.work.impl.WorkerWrapper.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    a8.get();
                                    Logger.c().a(WorkerWrapper.f8407y, String.format("Starting work for %s", WorkerWrapper.this.f8412j.f8620c), new Throwable[0]);
                                    WorkerWrapper workerWrapper = WorkerWrapper.this;
                                    workerWrapper.f8425w = workerWrapper.f8413k.p();
                                    t7.r(WorkerWrapper.this.f8425w);
                                } catch (Throwable th) {
                                    t7.q(th);
                                }
                            }
                        }, this.f8414l.a());
                        final String str = this.f8423u;
                        t7.f(new Runnable() { // from class: androidx.work.impl.WorkerWrapper.2
                            @Override // java.lang.Runnable
                            @SuppressLint({"SyntheticAccessor"})
                            public void run() {
                                try {
                                    try {
                                        ListenableWorker.Result result = (ListenableWorker.Result) t7.get();
                                        if (result == null) {
                                            Logger.c().b(WorkerWrapper.f8407y, String.format("%s returned a null result. Treating it as a failure.", WorkerWrapper.this.f8412j.f8620c), new Throwable[0]);
                                        } else {
                                            Logger.c().a(WorkerWrapper.f8407y, String.format("%s returned a %s result.", WorkerWrapper.this.f8412j.f8620c, result), new Throwable[0]);
                                            WorkerWrapper.this.f8415m = result;
                                        }
                                    } catch (InterruptedException e8) {
                                        e = e8;
                                        Logger.c().b(WorkerWrapper.f8407y, String.format("%s failed because it threw an exception/error", str), e);
                                    } catch (CancellationException e9) {
                                        Logger.c().d(WorkerWrapper.f8407y, String.format("%s was cancelled", str), e9);
                                    } catch (ExecutionException e10) {
                                        e = e10;
                                        Logger.c().b(WorkerWrapper.f8407y, String.format("%s failed because it threw an exception/error", str), e);
                                    }
                                } finally {
                                    WorkerWrapper.this.f();
                                }
                            }
                        }, this.f8414l.c());
                        return;
                    }
                    j();
                }
            }
        } finally {
            this.f8418p.i();
        }
    }

    private void m() {
        this.f8418p.e();
        try {
            this.f8419q.a(WorkInfo.State.SUCCEEDED, this.f8409g);
            this.f8419q.p(this.f8409g, ((ListenableWorker.Result.Success) this.f8415m).e());
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : this.f8420r.b(this.f8409g)) {
                if (this.f8419q.g(str) == WorkInfo.State.BLOCKED && this.f8420r.c(str)) {
                    Logger.c().d(f8407y, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                    this.f8419q.a(WorkInfo.State.ENQUEUED, str);
                    this.f8419q.u(str, currentTimeMillis);
                }
            }
            this.f8418p.E();
        } finally {
            this.f8418p.i();
            i(false);
        }
    }

    private boolean n() {
        if (!this.f8426x) {
            return false;
        }
        Logger.c().a(f8407y, String.format("Work interrupted for %s", this.f8423u), new Throwable[0]);
        WorkInfo.State g8 = this.f8419q.g(this.f8409g);
        if (g8 == null) {
            i(false);
        } else {
            i(!g8.a());
        }
        return true;
    }

    private boolean o() {
        this.f8418p.e();
        try {
            boolean z7 = true;
            if (this.f8419q.g(this.f8409g) == WorkInfo.State.ENQUEUED) {
                this.f8419q.a(WorkInfo.State.RUNNING, this.f8409g);
                this.f8419q.t(this.f8409g);
            } else {
                z7 = false;
            }
            this.f8418p.E();
            return z7;
        } finally {
            this.f8418p.i();
        }
    }

    @NonNull
    public ListenableFuture<Boolean> b() {
        return this.f8424v;
    }

    public void d() {
        boolean z7;
        this.f8426x = true;
        n();
        ListenableFuture<ListenableWorker.Result> listenableFuture = this.f8425w;
        if (listenableFuture != null) {
            z7 = listenableFuture.isDone();
            this.f8425w.cancel(true);
        } else {
            z7 = false;
        }
        ListenableWorker listenableWorker = this.f8413k;
        if (listenableWorker != null && !z7) {
            listenableWorker.q();
        } else {
            Logger.c().a(f8407y, String.format("WorkSpec %s is already done. Not interrupting.", this.f8412j), new Throwable[0]);
        }
    }

    void f() {
        if (!n()) {
            this.f8418p.e();
            try {
                WorkInfo.State g8 = this.f8419q.g(this.f8409g);
                this.f8418p.O().b(this.f8409g);
                if (g8 == null) {
                    i(false);
                } else if (g8 == WorkInfo.State.RUNNING) {
                    c(this.f8415m);
                } else if (!g8.a()) {
                    g();
                }
                this.f8418p.E();
            } finally {
                this.f8418p.i();
            }
        }
        List<Scheduler> list = this.f8410h;
        if (list != null) {
            for (Scheduler scheduler : list) {
                scheduler.cancel(this.f8409g);
            }
            Schedulers.b(this.f8416n, this.f8418p, this.f8410h);
        }
    }

    void l() {
        this.f8418p.e();
        try {
            e(this.f8409g);
            this.f8419q.p(this.f8409g, ((ListenableWorker.Result.Failure) this.f8415m).e());
            this.f8418p.E();
        } finally {
            this.f8418p.i();
            i(false);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        List<String> a8 = this.f8421s.a(this.f8409g);
        this.f8422t = a8;
        this.f8423u = a(a8);
        k();
    }
}
