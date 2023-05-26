package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class NewThreadWorker extends Scheduler.Worker {

    /* renamed from: f  reason: collision with root package name */
    private final ScheduledExecutorService f49724f;

    /* renamed from: g  reason: collision with root package name */
    volatile boolean f49725g;

    public NewThreadWorker(ThreadFactory threadFactory) {
        this.f49724f = SchedulerPoolFactory.a(threadFactory);
    }

    @Override // io.reactivex.Scheduler.Worker
    public Disposable b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // io.reactivex.Scheduler.Worker
    public Disposable c(Runnable runnable, long j8, TimeUnit timeUnit) {
        if (this.f49725g) {
            return EmptyDisposable.INSTANCE;
        }
        return e(runnable, j8, timeUnit, null);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (!this.f49725g) {
            this.f49725g = true;
            this.f49724f.shutdownNow();
        }
    }

    public ScheduledRunnable e(Runnable runnable, long j8, TimeUnit timeUnit, DisposableContainer disposableContainer) {
        Future<?> schedule;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.u(runnable), disposableContainer);
        if (disposableContainer != null && !disposableContainer.b(scheduledRunnable)) {
            return scheduledRunnable;
        }
        try {
            if (j8 <= 0) {
                schedule = this.f49724f.submit((Callable) scheduledRunnable);
            } else {
                schedule = this.f49724f.schedule((Callable) scheduledRunnable, j8, timeUnit);
            }
            scheduledRunnable.a(schedule);
        } catch (RejectedExecutionException e8) {
            if (disposableContainer != null) {
                disposableContainer.a(scheduledRunnable);
            }
            RxJavaPlugins.s(e8);
        }
        return scheduledRunnable;
    }

    public Disposable f(Runnable runnable, long j8, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.u(runnable));
        try {
            if (j8 <= 0) {
                schedule = this.f49724f.submit(scheduledDirectTask);
            } else {
                schedule = this.f49724f.schedule(scheduledDirectTask, j8, timeUnit);
            }
            scheduledDirectTask.a(schedule);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e8) {
            RxJavaPlugins.s(e8);
            return EmptyDisposable.INSTANCE;
        }
    }

    public Disposable g(Runnable runnable, long j8, long j9, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable u7 = RxJavaPlugins.u(runnable);
        if (j9 <= 0) {
            InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(u7, this.f49724f);
            try {
                if (j8 <= 0) {
                    schedule = this.f49724f.submit(instantPeriodicTask);
                } else {
                    schedule = this.f49724f.schedule(instantPeriodicTask, j8, timeUnit);
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
            scheduledDirectPeriodicTask.a(this.f49724f.scheduleAtFixedRate(scheduledDirectPeriodicTask, j8, j9, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e9) {
            RxJavaPlugins.s(e9);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void h() {
        if (!this.f49725g) {
            this.f49725g = true;
            this.f49724f.shutdown();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f49725g;
    }
}
