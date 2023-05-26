package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.ProcessUtils;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class GreedyScheduler implements Scheduler, WorkConstraintsCallback, ExecutionListener {

    /* renamed from: n  reason: collision with root package name */
    private static final String f8448n = Logger.f("GreedyScheduler");

    /* renamed from: f  reason: collision with root package name */
    private final Context f8449f;

    /* renamed from: g  reason: collision with root package name */
    private final WorkManagerImpl f8450g;

    /* renamed from: h  reason: collision with root package name */
    private final WorkConstraintsTracker f8451h;

    /* renamed from: j  reason: collision with root package name */
    private DelayedWorkTracker f8453j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8454k;

    /* renamed from: m  reason: collision with root package name */
    Boolean f8456m;

    /* renamed from: i  reason: collision with root package name */
    private final Set<WorkSpec> f8452i = new HashSet();

    /* renamed from: l  reason: collision with root package name */
    private final Object f8455l = new Object();

    public GreedyScheduler(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkManagerImpl workManagerImpl) {
        this.f8449f = context;
        this.f8450g = workManagerImpl;
        this.f8451h = new WorkConstraintsTracker(context, taskExecutor, this);
        this.f8453j = new DelayedWorkTracker(this, configuration.j());
    }

    private void f() {
        this.f8456m = Boolean.valueOf(ProcessUtils.b(this.f8449f, this.f8450g.i()));
    }

    private void g() {
        if (!this.f8454k) {
            this.f8450g.m().c(this);
            this.f8454k = true;
        }
    }

    private void h(@NonNull String str) {
        synchronized (this.f8455l) {
            Iterator<WorkSpec> it = this.f8452i.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WorkSpec next = it.next();
                if (next.f8618a.equals(str)) {
                    Logger.c().a(f8448n, String.format("Stopping tracking for %s", str), new Throwable[0]);
                    this.f8452i.remove(next);
                    this.f8451h.d(this.f8452i);
                    break;
                }
            }
        }
    }

    @Override // androidx.work.impl.Scheduler
    public void a(@NonNull WorkSpec... workSpecArr) {
        if (this.f8456m == null) {
            f();
        }
        if (!this.f8456m.booleanValue()) {
            Logger.c().d(f8448n, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        g();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (WorkSpec workSpec : workSpecArr) {
            long a8 = workSpec.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (workSpec.f8619b == WorkInfo.State.ENQUEUED) {
                if (currentTimeMillis < a8) {
                    DelayedWorkTracker delayedWorkTracker = this.f8453j;
                    if (delayedWorkTracker != null) {
                        delayedWorkTracker.a(workSpec);
                    }
                } else if (workSpec.b()) {
                    int i8 = Build.VERSION.SDK_INT;
                    if (i8 >= 23 && workSpec.f8627j.h()) {
                        Logger.c().a(f8448n, String.format("Ignoring WorkSpec %s, Requires device idle.", workSpec), new Throwable[0]);
                    } else if (i8 >= 24 && workSpec.f8627j.e()) {
                        Logger.c().a(f8448n, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", workSpec), new Throwable[0]);
                    } else {
                        hashSet.add(workSpec);
                        hashSet2.add(workSpec.f8618a);
                    }
                } else {
                    Logger.c().a(f8448n, String.format("Starting work for %s", workSpec.f8618a), new Throwable[0]);
                    this.f8450g.u(workSpec.f8618a);
                }
            }
        }
        synchronized (this.f8455l) {
            if (!hashSet.isEmpty()) {
                Logger.c().a(f8448n, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                this.f8452i.addAll(hashSet);
                this.f8451h.d(this.f8452i);
            }
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void b(@NonNull List<String> list) {
        for (String str : list) {
            Logger.c().a(f8448n, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.f8450g.x(str);
        }
    }

    @Override // androidx.work.impl.Scheduler
    public boolean c() {
        return false;
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(@NonNull String str) {
        if (this.f8456m == null) {
            f();
        }
        if (!this.f8456m.booleanValue()) {
            Logger.c().d(f8448n, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        g();
        Logger.c().a(f8448n, String.format("Cancelling work ID %s", str), new Throwable[0]);
        DelayedWorkTracker delayedWorkTracker = this.f8453j;
        if (delayedWorkTracker != null) {
            delayedWorkTracker.b(str);
        }
        this.f8450g.x(str);
    }

    @Override // androidx.work.impl.ExecutionListener
    public void d(@NonNull String str, boolean z7) {
        h(str);
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void e(@NonNull List<String> list) {
        for (String str : list) {
            Logger.c().a(f8448n, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            this.f8450g.u(str);
        }
    }
}
