package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class SingleScheduler extends Scheduler {

    /* renamed from: e  reason: collision with root package name */
    static final RxThreadFactory f49738e;

    /* renamed from: f  reason: collision with root package name */
    static final ScheduledExecutorService f49739f;

    /* renamed from: c  reason: collision with root package name */
    final ThreadFactory f49740c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f49741d;

    /* loaded from: classes5.dex */
    static final class ScheduledWorker extends Scheduler.Worker {

        /* renamed from: f  reason: collision with root package name */
        final ScheduledExecutorService f49742f;

        /* renamed from: g  reason: collision with root package name */
        final CompositeDisposable f49743g = new CompositeDisposable();

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f49744h;

        ScheduledWorker(ScheduledExecutorService scheduledExecutorService) {
            this.f49742f = scheduledExecutorService;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable c(Runnable runnable, long j8, TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.f49744h) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.u(runnable), this.f49743g);
            this.f49743g.b(scheduledRunnable);
            try {
                if (j8 <= 0) {
                    schedule = this.f49742f.submit((Callable) scheduledRunnable);
                } else {
                    schedule = this.f49742f.schedule((Callable) scheduledRunnable, j8, timeUnit);
                }
                scheduledRunnable.a(schedule);
                return scheduledRunnable;
            } catch (RejectedExecutionException e8) {
                dispose();
                RxJavaPlugins.s(e8);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f49744h) {
                this.f49744h = true;
                this.f49743g.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49744h;
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f49739f = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        f49738e = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public SingleScheduler() {
        this(f49738e);
    }

    static ScheduledExecutorService g(ThreadFactory threadFactory) {
        return SchedulerPoolFactory.a(threadFactory);
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        return new ScheduledWorker(this.f49741d.get());
    }

    @Override // io.reactivex.Scheduler
    public Disposable e(Runnable runnable, long j8, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.u(runnable));
        try {
            if (j8 <= 0) {
                schedule = this.f49741d.get().submit(scheduledDirectTask);
            } else {
                schedule = this.f49741d.get().schedule(scheduledDirectTask, j8, timeUnit);
            }
            scheduledDirectTask.a(schedule);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e8) {
            RxJavaPlugins.s(e8);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    public Disposable f(Runnable runnable, long j8, long j9, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable u7 = RxJavaPlugins.u(runnable);
        if (j9 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f49741d.get();
            InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(u7, scheduledExecutorService);
            try {
                if (j8 <= 0) {
                    schedule = scheduledExecutorService.submit(instantPeriodicTask);
                } else {
                    schedule = scheduledExecutorService.schedule(instantPeriodicTask, j8, timeUnit);
                }
                instantPeriodicTask.b(schedule);
                return instantPeriodicTask;
            } catch (RejectedExecutionException e8) {
                RxJavaPlugins.s(e8);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(u7);
        try {
            scheduledDirectPeriodicTask.a(this.f49741d.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j8, j9, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e9) {
            RxJavaPlugins.s(e9);
            return EmptyDisposable.INSTANCE;
        }
    }

    public SingleScheduler(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f49741d = atomicReference;
        this.f49740c = threadFactory;
        atomicReference.lazySet(g(threadFactory));
    }
}
