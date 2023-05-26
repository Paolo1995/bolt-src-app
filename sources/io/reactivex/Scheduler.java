package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public abstract class Scheduler {

    /* renamed from: a  reason: collision with root package name */
    static boolean f47573a = Boolean.getBoolean("rx2.scheduler.use-nanotime");

    /* renamed from: b  reason: collision with root package name */
    static final long f47574b = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class DisposeTask implements Disposable, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final Runnable f47575f;

        /* renamed from: g  reason: collision with root package name */
        final Worker f47576g;

        /* renamed from: h  reason: collision with root package name */
        Thread f47577h;

        DisposeTask(Runnable runnable, Worker worker) {
            this.f47575f = runnable;
            this.f47576g = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f47577h == Thread.currentThread()) {
                Worker worker = this.f47576g;
                if (worker instanceof NewThreadWorker) {
                    ((NewThreadWorker) worker).h();
                    return;
                }
            }
            this.f47576g.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f47576g.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47577h = Thread.currentThread();
            try {
                this.f47575f.run();
            } finally {
                dispose();
                this.f47577h = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class PeriodicDirectTask implements Disposable, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final Runnable f47578f;

        /* renamed from: g  reason: collision with root package name */
        final Worker f47579g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f47580h;

        PeriodicDirectTask(Runnable runnable, Worker worker) {
            this.f47578f = runnable;
            this.f47579g = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f47580h = true;
            this.f47579g.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f47580h;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f47580h) {
                try {
                    this.f47578f.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f47579g.dispose();
                    throw ExceptionHelper.e(th);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class Worker implements Disposable {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public final class PeriodicTask implements Runnable {

            /* renamed from: f  reason: collision with root package name */
            final Runnable f47581f;

            /* renamed from: g  reason: collision with root package name */
            final SequentialDisposable f47582g;

            /* renamed from: h  reason: collision with root package name */
            final long f47583h;

            /* renamed from: i  reason: collision with root package name */
            long f47584i;

            /* renamed from: j  reason: collision with root package name */
            long f47585j;

            /* renamed from: k  reason: collision with root package name */
            long f47586k;

            PeriodicTask(long j8, Runnable runnable, long j9, SequentialDisposable sequentialDisposable, long j10) {
                this.f47581f = runnable;
                this.f47582g = sequentialDisposable;
                this.f47583h = j10;
                this.f47585j = j9;
                this.f47586k = j8;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j8;
                this.f47581f.run();
                if (!this.f47582g.isDisposed()) {
                    Worker worker = Worker.this;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long a8 = worker.a(timeUnit);
                    long j9 = Scheduler.f47574b;
                    long j10 = this.f47585j;
                    if (a8 + j9 >= j10) {
                        long j11 = this.f47583h;
                        if (a8 < j10 + j11 + j9) {
                            long j12 = this.f47586k;
                            long j13 = this.f47584i + 1;
                            this.f47584i = j13;
                            j8 = j12 + (j13 * j11);
                            this.f47585j = a8;
                            this.f47582g.a(Worker.this.c(this, j8 - a8, timeUnit));
                        }
                    }
                    long j14 = this.f47583h;
                    long j15 = a8 + j14;
                    long j16 = this.f47584i + 1;
                    this.f47584i = j16;
                    this.f47586k = j15 - (j14 * j16);
                    j8 = j15;
                    this.f47585j = a8;
                    this.f47582g.a(Worker.this.c(this, j8 - a8, timeUnit));
                }
            }
        }

        public long a(TimeUnit timeUnit) {
            return Scheduler.a(timeUnit);
        }

        public Disposable b(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract Disposable c(Runnable runnable, long j8, TimeUnit timeUnit);

        public Disposable d(Runnable runnable, long j8, long j9, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable u7 = RxJavaPlugins.u(runnable);
            long nanos = timeUnit.toNanos(j9);
            long a8 = a(TimeUnit.NANOSECONDS);
            Disposable c8 = c(new PeriodicTask(a8 + timeUnit.toNanos(j8), u7, a8, sequentialDisposable2, nanos), j8, timeUnit);
            if (c8 == EmptyDisposable.INSTANCE) {
                return c8;
            }
            sequentialDisposable.a(c8);
            return sequentialDisposable2;
        }
    }

    static long a(TimeUnit timeUnit) {
        if (!f47573a) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
        return timeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public abstract Worker b();

    public long c(TimeUnit timeUnit) {
        return a(timeUnit);
    }

    public Disposable d(Runnable runnable) {
        return e(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public Disposable e(Runnable runnable, long j8, TimeUnit timeUnit) {
        Worker b8 = b();
        DisposeTask disposeTask = new DisposeTask(RxJavaPlugins.u(runnable), b8);
        b8.c(disposeTask, j8, timeUnit);
        return disposeTask;
    }

    public Disposable f(Runnable runnable, long j8, long j9, TimeUnit timeUnit) {
        Worker b8 = b();
        PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(RxJavaPlugins.u(runnable), b8);
        Disposable d8 = b8.d(periodicDirectTask, j8, j9, timeUnit);
        if (d8 == EmptyDisposable.INSTANCE) {
            return d8;
        }
        return periodicDirectTask;
    }
}
