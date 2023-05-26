package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.work.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class WorkTimer {

    /* renamed from: f  reason: collision with root package name */
    private static final String f8731f = Logger.f("WorkTimer");

    /* renamed from: a  reason: collision with root package name */
    private final ThreadFactory f8732a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f8733b;

    /* renamed from: c  reason: collision with root package name */
    final Map<String, WorkTimerRunnable> f8734c;

    /* renamed from: d  reason: collision with root package name */
    final Map<String, TimeLimitExceededListener> f8735d;

    /* renamed from: e  reason: collision with root package name */
    final Object f8736e;

    /* loaded from: classes.dex */
    public interface TimeLimitExceededListener {
        void a(@NonNull String str);
    }

    /* loaded from: classes.dex */
    public static class WorkTimerRunnable implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final WorkTimer f8739f;

        /* renamed from: g  reason: collision with root package name */
        private final String f8740g;

        WorkTimerRunnable(@NonNull WorkTimer workTimer, @NonNull String str) {
            this.f8739f = workTimer;
            this.f8740g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f8739f.f8736e) {
                if (this.f8739f.f8734c.remove(this.f8740g) != null) {
                    TimeLimitExceededListener remove = this.f8739f.f8735d.remove(this.f8740g);
                    if (remove != null) {
                        remove.a(this.f8740g);
                    }
                } else {
                    Logger.c().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.f8740g), new Throwable[0]);
                }
            }
        }
    }

    public WorkTimer() {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: androidx.work.impl.utils.WorkTimer.1

            /* renamed from: f  reason: collision with root package name */
            private int f8737f = 0;

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                newThread.setName("WorkManager-WorkTimer-thread-" + this.f8737f);
                this.f8737f = this.f8737f + 1;
                return newThread;
            }
        };
        this.f8732a = threadFactory;
        this.f8734c = new HashMap();
        this.f8735d = new HashMap();
        this.f8736e = new Object();
        this.f8733b = Executors.newSingleThreadScheduledExecutor(threadFactory);
    }

    public void a() {
        if (!this.f8733b.isShutdown()) {
            this.f8733b.shutdownNow();
        }
    }

    public void b(@NonNull String str, long j8, @NonNull TimeLimitExceededListener timeLimitExceededListener) {
        synchronized (this.f8736e) {
            Logger.c().a(f8731f, String.format("Starting timer for %s", str), new Throwable[0]);
            c(str);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, str);
            this.f8734c.put(str, workTimerRunnable);
            this.f8735d.put(str, timeLimitExceededListener);
            this.f8733b.schedule(workTimerRunnable, j8, TimeUnit.MILLISECONDS);
        }
    }

    public void c(@NonNull String str) {
        synchronized (this.f8736e) {
            if (this.f8734c.remove(str) != null) {
                Logger.c().a(f8731f, String.format("Stopping timer for %s", str), new Throwable[0]);
                this.f8735d.remove(str);
            }
        }
    }
}
