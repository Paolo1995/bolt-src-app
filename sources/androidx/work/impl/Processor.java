package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public class Processor implements ExecutionListener, ForegroundProcessor {

    /* renamed from: q  reason: collision with root package name */
    private static final String f8347q = Logger.f("Processor");

    /* renamed from: g  reason: collision with root package name */
    private Context f8349g;

    /* renamed from: h  reason: collision with root package name */
    private Configuration f8350h;

    /* renamed from: i  reason: collision with root package name */
    private TaskExecutor f8351i;

    /* renamed from: j  reason: collision with root package name */
    private WorkDatabase f8352j;

    /* renamed from: m  reason: collision with root package name */
    private List<Scheduler> f8355m;

    /* renamed from: l  reason: collision with root package name */
    private Map<String, WorkerWrapper> f8354l = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private Map<String, WorkerWrapper> f8353k = new HashMap();

    /* renamed from: n  reason: collision with root package name */
    private Set<String> f8356n = new HashSet();

    /* renamed from: o  reason: collision with root package name */
    private final List<ExecutionListener> f8357o = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private PowerManager.WakeLock f8348f = null;

    /* renamed from: p  reason: collision with root package name */
    private final Object f8358p = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class FutureListener implements Runnable {
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        private ExecutionListener f8359f;
        @NonNull

        /* renamed from: g  reason: collision with root package name */
        private String f8360g;
        @NonNull

        /* renamed from: h  reason: collision with root package name */
        private ListenableFuture<Boolean> f8361h;

        FutureListener(@NonNull ExecutionListener executionListener, @NonNull String str, @NonNull ListenableFuture<Boolean> listenableFuture) {
            this.f8359f = executionListener;
            this.f8360g = str;
            this.f8361h = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z7;
            try {
                z7 = this.f8361h.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z7 = true;
            }
            this.f8359f.d(this.f8360g, z7);
        }
    }

    public Processor(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkDatabase workDatabase, @NonNull List<Scheduler> list) {
        this.f8349g = context;
        this.f8350h = configuration;
        this.f8351i = taskExecutor;
        this.f8352j = workDatabase;
        this.f8355m = list;
    }

    private static boolean e(@NonNull String str, WorkerWrapper workerWrapper) {
        if (workerWrapper != null) {
            workerWrapper.d();
            Logger.c().a(f8347q, String.format("WorkerWrapper interrupted for %s", str), new Throwable[0]);
            return true;
        }
        Logger.c().a(f8347q, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
        return false;
    }

    private void m() {
        synchronized (this.f8358p) {
            if (!(!this.f8353k.isEmpty())) {
                this.f8349g.startService(SystemForegroundDispatcher.f(this.f8349g));
                PowerManager.WakeLock wakeLock = this.f8348f;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.f8348f = null;
                }
            }
        }
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void a(@NonNull String str) {
        synchronized (this.f8358p) {
            this.f8353k.remove(str);
            m();
        }
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void b(@NonNull String str, @NonNull ForegroundInfo foregroundInfo) {
        synchronized (this.f8358p) {
            Logger.c().d(f8347q, String.format("Moving WorkSpec (%s) to the foreground", str), new Throwable[0]);
            WorkerWrapper remove = this.f8354l.remove(str);
            if (remove != null) {
                if (this.f8348f == null) {
                    PowerManager.WakeLock b8 = WakeLocks.b(this.f8349g, "ProcessorForegroundLck");
                    this.f8348f = b8;
                    b8.acquire();
                }
                this.f8353k.put(str, remove);
                ContextCompat.startForegroundService(this.f8349g, SystemForegroundDispatcher.c(this.f8349g, str, foregroundInfo));
            }
        }
    }

    public void c(@NonNull ExecutionListener executionListener) {
        synchronized (this.f8358p) {
            this.f8357o.add(executionListener);
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public void d(@NonNull String str, boolean z7) {
        synchronized (this.f8358p) {
            this.f8354l.remove(str);
            Logger.c().a(f8347q, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), str, Boolean.valueOf(z7)), new Throwable[0]);
            for (ExecutionListener executionListener : this.f8357o) {
                executionListener.d(str, z7);
            }
        }
    }

    public boolean f(@NonNull String str) {
        boolean contains;
        synchronized (this.f8358p) {
            contains = this.f8356n.contains(str);
        }
        return contains;
    }

    public boolean g(@NonNull String str) {
        boolean z7;
        synchronized (this.f8358p) {
            if (!this.f8354l.containsKey(str) && !this.f8353k.containsKey(str)) {
                z7 = false;
            }
            z7 = true;
        }
        return z7;
    }

    public boolean h(@NonNull String str) {
        boolean containsKey;
        synchronized (this.f8358p) {
            containsKey = this.f8353k.containsKey(str);
        }
        return containsKey;
    }

    public void i(@NonNull ExecutionListener executionListener) {
        synchronized (this.f8358p) {
            this.f8357o.remove(executionListener);
        }
    }

    public boolean j(@NonNull String str) {
        return k(str, null);
    }

    public boolean k(@NonNull String str, WorkerParameters.RuntimeExtras runtimeExtras) {
        synchronized (this.f8358p) {
            if (g(str)) {
                Logger.c().a(f8347q, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                return false;
            }
            WorkerWrapper a8 = new WorkerWrapper.Builder(this.f8349g, this.f8350h, this.f8351i, this, this.f8352j, str).c(this.f8355m).b(runtimeExtras).a();
            ListenableFuture<Boolean> b8 = a8.b();
            b8.f(new FutureListener(this, str, b8), this.f8351i.a());
            this.f8354l.put(str, a8);
            this.f8351i.c().execute(a8);
            Logger.c().a(f8347q, String.format("%s: processing %s", getClass().getSimpleName(), str), new Throwable[0]);
            return true;
        }
    }

    public boolean l(@NonNull String str) {
        boolean e8;
        synchronized (this.f8358p) {
            boolean z7 = true;
            Logger.c().a(f8347q, String.format("Processor cancelling %s", str), new Throwable[0]);
            this.f8356n.add(str);
            WorkerWrapper remove = this.f8353k.remove(str);
            if (remove == null) {
                z7 = false;
            }
            if (remove == null) {
                remove = this.f8354l.remove(str);
            }
            e8 = e(str, remove);
            if (z7) {
                m();
            }
        }
        return e8;
    }

    public boolean n(@NonNull String str) {
        boolean e8;
        synchronized (this.f8358p) {
            Logger.c().a(f8347q, String.format("Processor stopping foreground work %s", str), new Throwable[0]);
            e8 = e(str, this.f8353k.remove(str));
        }
        return e8;
    }

    public boolean o(@NonNull String str) {
        boolean e8;
        synchronized (this.f8358p) {
            Logger.c().a(f8347q, String.format("Processor stopping background work %s", str), new Throwable[0]);
            e8 = e(str, this.f8354l.remove(str));
        }
        return e8;
    }
}
