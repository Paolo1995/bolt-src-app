package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ConstraintTrackingWorker extends ListenableWorker implements WorkConstraintsCallback {

    /* renamed from: p  reason: collision with root package name */
    private static final String f8774p = Logger.f("ConstraintTrkngWrkr");

    /* renamed from: k  reason: collision with root package name */
    private WorkerParameters f8775k;

    /* renamed from: l  reason: collision with root package name */
    final Object f8776l;

    /* renamed from: m  reason: collision with root package name */
    volatile boolean f8777m;

    /* renamed from: n  reason: collision with root package name */
    SettableFuture<ListenableWorker.Result> f8778n;

    /* renamed from: o  reason: collision with root package name */
    private ListenableWorker f8779o;

    public ConstraintTrackingWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f8775k = workerParameters;
        this.f8776l = new Object();
        this.f8777m = false;
        this.f8778n = SettableFuture.t();
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void b(@NonNull List<String> list) {
        Logger.c().a(f8774p, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.f8776l) {
            this.f8777m = true;
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void e(@NonNull List<String> list) {
    }

    @Override // androidx.work.ListenableWorker
    @NonNull
    public TaskExecutor h() {
        return WorkManagerImpl.k(a()).p();
    }

    @Override // androidx.work.ListenableWorker
    public boolean j() {
        ListenableWorker listenableWorker = this.f8779o;
        if (listenableWorker != null && listenableWorker.j()) {
            return true;
        }
        return false;
    }

    @Override // androidx.work.ListenableWorker
    public void m() {
        super.m();
        ListenableWorker listenableWorker = this.f8779o;
        if (listenableWorker != null && !listenableWorker.k()) {
            this.f8779o.q();
        }
    }

    @Override // androidx.work.ListenableWorker
    @NonNull
    public ListenableFuture<ListenableWorker.Result> p() {
        c().execute(new Runnable() { // from class: androidx.work.impl.workers.ConstraintTrackingWorker.1
            @Override // java.lang.Runnable
            public void run() {
                ConstraintTrackingWorker.this.u();
            }
        });
        return this.f8778n;
    }

    @NonNull
    public WorkDatabase r() {
        return WorkManagerImpl.k(a()).o();
    }

    void s() {
        this.f8778n.p(ListenableWorker.Result.a());
    }

    void t() {
        this.f8778n.p(ListenableWorker.Result.b());
    }

    void u() {
        String i8 = g().i("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty(i8)) {
            Logger.c().b(f8774p, "No worker to delegate to.", new Throwable[0]);
            s();
            return;
        }
        ListenableWorker b8 = i().b(a(), i8, this.f8775k);
        this.f8779o = b8;
        if (b8 == null) {
            Logger.c().a(f8774p, "No worker to delegate to.", new Throwable[0]);
            s();
            return;
        }
        WorkSpec h8 = r().P().h(f().toString());
        if (h8 == null) {
            s();
            return;
        }
        WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(a(), h(), this);
        workConstraintsTracker.d(Collections.singletonList(h8));
        if (workConstraintsTracker.c(f().toString())) {
            Logger.c().a(f8774p, String.format("Constraints met for delegate %s", i8), new Throwable[0]);
            try {
                final ListenableFuture<ListenableWorker.Result> p8 = this.f8779o.p();
                p8.f(new Runnable() { // from class: androidx.work.impl.workers.ConstraintTrackingWorker.2
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (ConstraintTrackingWorker.this.f8776l) {
                            if (ConstraintTrackingWorker.this.f8777m) {
                                ConstraintTrackingWorker.this.t();
                            } else {
                                ConstraintTrackingWorker.this.f8778n.r(p8);
                            }
                        }
                    }
                }, c());
                return;
            } catch (Throwable th) {
                Logger c8 = Logger.c();
                String str = f8774p;
                c8.a(str, String.format("Delegated worker %s threw exception in startWork.", i8), th);
                synchronized (this.f8776l) {
                    if (this.f8777m) {
                        Logger.c().a(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                        t();
                    } else {
                        s();
                    }
                    return;
                }
            }
        }
        Logger.c().a(f8774p, String.format("Constraints not met for delegate %s. Requesting retry.", i8), new Throwable[0]);
        t();
    }
}
