package androidx.work.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.R$bool;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class WorkManagerImpl extends WorkManager {

    /* renamed from: j  reason: collision with root package name */
    private static final String f8394j = Logger.f("WorkManagerImpl");

    /* renamed from: k  reason: collision with root package name */
    private static WorkManagerImpl f8395k = null;

    /* renamed from: l  reason: collision with root package name */
    private static WorkManagerImpl f8396l = null;

    /* renamed from: m  reason: collision with root package name */
    private static final Object f8397m = new Object();

    /* renamed from: a  reason: collision with root package name */
    private Context f8398a;

    /* renamed from: b  reason: collision with root package name */
    private Configuration f8399b;

    /* renamed from: c  reason: collision with root package name */
    private WorkDatabase f8400c;

    /* renamed from: d  reason: collision with root package name */
    private TaskExecutor f8401d;

    /* renamed from: e  reason: collision with root package name */
    private List<Scheduler> f8402e;

    /* renamed from: f  reason: collision with root package name */
    private Processor f8403f;

    /* renamed from: g  reason: collision with root package name */
    private PreferenceUtils f8404g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8405h;

    /* renamed from: i  reason: collision with root package name */
    private BroadcastReceiver.PendingResult f8406i;

    public WorkManagerImpl(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor) {
        this(context, configuration, taskExecutor, context.getResources().getBoolean(R$bool.workmanager_test_configuration));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0016, code lost:
        r4 = r4.getApplicationContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (androidx.work.impl.WorkManagerImpl.f8396l != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
        androidx.work.impl.WorkManagerImpl.f8396l = new androidx.work.impl.WorkManagerImpl(r4, r5, new androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor(r5.k()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
        androidx.work.impl.WorkManagerImpl.f8395k = androidx.work.impl.WorkManagerImpl.f8396l;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void e(@androidx.annotation.NonNull android.content.Context r4, @androidx.annotation.NonNull androidx.work.Configuration r5) {
        /*
            java.lang.Object r0 = androidx.work.impl.WorkManagerImpl.f8397m
            monitor-enter(r0)
            androidx.work.impl.WorkManagerImpl r1 = androidx.work.impl.WorkManagerImpl.f8395k     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L14
            androidx.work.impl.WorkManagerImpl r2 = androidx.work.impl.WorkManagerImpl.f8396l     // Catch: java.lang.Throwable -> L34
            if (r2 != 0) goto Lc
            goto L14
        Lc:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = "WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information."
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L34
            throw r4     // Catch: java.lang.Throwable -> L34
        L14:
            if (r1 != 0) goto L32
            android.content.Context r4 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> L34
            androidx.work.impl.WorkManagerImpl r1 = androidx.work.impl.WorkManagerImpl.f8396l     // Catch: java.lang.Throwable -> L34
            if (r1 != 0) goto L2e
            androidx.work.impl.WorkManagerImpl r1 = new androidx.work.impl.WorkManagerImpl     // Catch: java.lang.Throwable -> L34
            androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor r2 = new androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor     // Catch: java.lang.Throwable -> L34
            java.util.concurrent.Executor r3 = r5.k()     // Catch: java.lang.Throwable -> L34
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L34
            r1.<init>(r4, r5, r2)     // Catch: java.lang.Throwable -> L34
            androidx.work.impl.WorkManagerImpl.f8396l = r1     // Catch: java.lang.Throwable -> L34
        L2e:
            androidx.work.impl.WorkManagerImpl r4 = androidx.work.impl.WorkManagerImpl.f8396l     // Catch: java.lang.Throwable -> L34
            androidx.work.impl.WorkManagerImpl.f8395k = r4     // Catch: java.lang.Throwable -> L34
        L32:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            return
        L34:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkManagerImpl.e(android.content.Context, androidx.work.Configuration):void");
    }

    @Deprecated
    public static WorkManagerImpl j() {
        synchronized (f8397m) {
            WorkManagerImpl workManagerImpl = f8395k;
            if (workManagerImpl != null) {
                return workManagerImpl;
            }
            return f8396l;
        }
    }

    @NonNull
    public static WorkManagerImpl k(@NonNull Context context) {
        WorkManagerImpl j8;
        synchronized (f8397m) {
            j8 = j();
            if (j8 == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof Configuration.Provider) {
                    e(applicationContext, ((Configuration.Provider) applicationContext).a());
                    j8 = k(applicationContext);
                } else {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            }
        }
        return j8;
    }

    private void q(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkDatabase workDatabase, @NonNull List<Scheduler> list, @NonNull Processor processor) {
        boolean isDeviceProtectedStorage;
        Context applicationContext = context.getApplicationContext();
        this.f8398a = applicationContext;
        this.f8399b = configuration;
        this.f8401d = taskExecutor;
        this.f8400c = workDatabase;
        this.f8402e = list;
        this.f8403f = processor;
        this.f8404g = new PreferenceUtils(workDatabase);
        this.f8405h = false;
        if (Build.VERSION.SDK_INT >= 24) {
            isDeviceProtectedStorage = applicationContext.isDeviceProtectedStorage();
            if (isDeviceProtectedStorage) {
                throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
            }
        }
        this.f8401d.b(new ForceStopRunnable(applicationContext, this));
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation a(@NonNull String str) {
        CancelWorkRunnable d8 = CancelWorkRunnable.d(str, this);
        this.f8401d.b(d8);
        return d8.e();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation c(@NonNull List<? extends WorkRequest> list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, list).a();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    @NonNull
    public Operation f(@NonNull UUID uuid) {
        CancelWorkRunnable b8 = CancelWorkRunnable.b(uuid, this);
        this.f8401d.b(b8);
        return b8.e();
    }

    @NonNull
    public List<Scheduler> g(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor) {
        return Arrays.asList(Schedulers.a(context, this), new GreedyScheduler(context, configuration, taskExecutor, this));
    }

    @NonNull
    public Context h() {
        return this.f8398a;
    }

    @NonNull
    public Configuration i() {
        return this.f8399b;
    }

    @NonNull
    public PreferenceUtils l() {
        return this.f8404g;
    }

    @NonNull
    public Processor m() {
        return this.f8403f;
    }

    @NonNull
    public List<Scheduler> n() {
        return this.f8402e;
    }

    @NonNull
    public WorkDatabase o() {
        return this.f8400c;
    }

    @NonNull
    public TaskExecutor p() {
        return this.f8401d;
    }

    public void r() {
        synchronized (f8397m) {
            this.f8405h = true;
            BroadcastReceiver.PendingResult pendingResult = this.f8406i;
            if (pendingResult != null) {
                pendingResult.finish();
                this.f8406i = null;
            }
        }
    }

    public void s() {
        if (Build.VERSION.SDK_INT >= 23) {
            SystemJobScheduler.b(h());
        }
        o().P().l();
        Schedulers.b(i(), o(), n());
    }

    public void t(@NonNull BroadcastReceiver.PendingResult pendingResult) {
        synchronized (f8397m) {
            this.f8406i = pendingResult;
            if (this.f8405h) {
                pendingResult.finish();
                this.f8406i = null;
            }
        }
    }

    public void u(@NonNull String str) {
        v(str, null);
    }

    public void v(@NonNull String str, WorkerParameters.RuntimeExtras runtimeExtras) {
        this.f8401d.b(new StartWorkRunnable(this, str, runtimeExtras));
    }

    public void w(@NonNull String str) {
        this.f8401d.b(new StopWorkRunnable(this, str, true));
    }

    public void x(@NonNull String str) {
        this.f8401d.b(new StopWorkRunnable(this, str, false));
    }

    public WorkManagerImpl(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, boolean z7) {
        this(context, configuration, taskExecutor, WorkDatabase.G(context.getApplicationContext(), taskExecutor.c(), z7));
    }

    public WorkManagerImpl(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkDatabase workDatabase) {
        Context applicationContext = context.getApplicationContext();
        Logger.e(new Logger.LogcatLogger(configuration.i()));
        List<Scheduler> g8 = g(applicationContext, configuration, taskExecutor);
        q(context, configuration, taskExecutor, workDatabase, g8, new Processor(context, configuration, taskExecutor, workDatabase, g8));
    }
}
