package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ExecutorScheduler extends Scheduler {

    /* renamed from: e  reason: collision with root package name */
    static final Scheduler f49676e = Schedulers.d();

    /* renamed from: c  reason: collision with root package name */
    final boolean f49677c;

    /* renamed from: d  reason: collision with root package name */
    final Executor f49678d;

    /* loaded from: classes5.dex */
    final class DelayedDispose implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final DelayedRunnable f49679f;

        DelayedDispose(DelayedRunnable delayedRunnable) {
            this.f49679f = delayedRunnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            DelayedRunnable delayedRunnable = this.f49679f;
            delayedRunnable.f49682g.a(ExecutorScheduler.this.d(delayedRunnable));
        }
    }

    /* loaded from: classes5.dex */
    static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SequentialDisposable f49681f;

        /* renamed from: g  reason: collision with root package name */
        final SequentialDisposable f49682g;

        DelayedRunnable(Runnable runnable) {
            super(runnable);
            this.f49681f = new SequentialDisposable();
            this.f49682g = new SequentialDisposable();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(null) != null) {
                this.f49681f.dispose();
                this.f49682g.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == null) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet(null);
                    SequentialDisposable sequentialDisposable = this.f49681f;
                    DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                    sequentialDisposable.lazySet(disposableHelper);
                    this.f49682g.lazySet(disposableHelper);
                } catch (Throwable th) {
                    lazySet(null);
                    this.f49681f.lazySet(DisposableHelper.DISPOSED);
                    this.f49682g.lazySet(DisposableHelper.DISPOSED);
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        final boolean f49683f;

        /* renamed from: g  reason: collision with root package name */
        final Executor f49684g;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f49686i;

        /* renamed from: j  reason: collision with root package name */
        final AtomicInteger f49687j = new AtomicInteger();

        /* renamed from: k  reason: collision with root package name */
        final CompositeDisposable f49688k = new CompositeDisposable();

        /* renamed from: h  reason: collision with root package name */
        final MpscLinkedQueue<Runnable> f49685h = new MpscLinkedQueue<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class BooleanRunnable extends AtomicBoolean implements Runnable, Disposable {

            /* renamed from: f  reason: collision with root package name */
            final Runnable f49689f;

            BooleanRunnable(Runnable runnable) {
                this.f49689f = runnable;
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                lazySet(true);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.f49689f.run();
                } finally {
                    lazySet(true);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class InterruptibleRunnable extends AtomicInteger implements Runnable, Disposable {

            /* renamed from: f  reason: collision with root package name */
            final Runnable f49690f;

            /* renamed from: g  reason: collision with root package name */
            final DisposableContainer f49691g;

            /* renamed from: h  reason: collision with root package name */
            volatile Thread f49692h;

            InterruptibleRunnable(Runnable runnable, DisposableContainer disposableContainer) {
                this.f49690f = runnable;
                this.f49691g = disposableContainer;
            }

            void a() {
                DisposableContainer disposableContainer = this.f49691g;
                if (disposableContainer != null) {
                    disposableContainer.c(this);
                }
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                while (true) {
                    int i8 = get();
                    if (i8 < 2) {
                        if (i8 == 0) {
                            if (compareAndSet(0, 4)) {
                                a();
                                return;
                            }
                        } else if (compareAndSet(1, 3)) {
                            Thread thread = this.f49692h;
                            if (thread != null) {
                                thread.interrupt();
                                this.f49692h = null;
                            }
                            set(4);
                            a();
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                if (get() >= 2) {
                    return true;
                }
                return false;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.f49692h = Thread.currentThread();
                    if (compareAndSet(0, 1)) {
                        try {
                            this.f49690f.run();
                            this.f49692h = null;
                            if (compareAndSet(1, 2)) {
                                a();
                                return;
                            }
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                            return;
                        } catch (Throwable th) {
                            this.f49692h = null;
                            if (!compareAndSet(1, 2)) {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            } else {
                                a();
                            }
                            throw th;
                        }
                    }
                    this.f49692h = null;
                }
            }
        }

        /* loaded from: classes5.dex */
        final class SequentialDispose implements Runnable {

            /* renamed from: f  reason: collision with root package name */
            private final SequentialDisposable f49693f;

            /* renamed from: g  reason: collision with root package name */
            private final Runnable f49694g;

            SequentialDispose(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.f49693f = sequentialDisposable;
                this.f49694g = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f49693f.a(ExecutorWorker.this.b(this.f49694g));
            }
        }

        public ExecutorWorker(Executor executor, boolean z7) {
            this.f49684g = executor;
            this.f49683f = z7;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable b(Runnable runnable) {
            Disposable booleanRunnable;
            if (this.f49686i) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable u7 = RxJavaPlugins.u(runnable);
            if (this.f49683f) {
                booleanRunnable = new InterruptibleRunnable(u7, this.f49688k);
                this.f49688k.b(booleanRunnable);
            } else {
                booleanRunnable = new BooleanRunnable(u7);
            }
            this.f49685h.offer(booleanRunnable);
            if (this.f49687j.getAndIncrement() == 0) {
                try {
                    this.f49684g.execute(this);
                } catch (RejectedExecutionException e8) {
                    this.f49686i = true;
                    this.f49685h.clear();
                    RxJavaPlugins.s(e8);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return booleanRunnable;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable c(Runnable runnable, long j8, TimeUnit timeUnit) {
            if (j8 <= 0) {
                return b(runnable);
            }
            if (this.f49686i) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new SequentialDispose(sequentialDisposable2, RxJavaPlugins.u(runnable)), this.f49688k);
            this.f49688k.b(scheduledRunnable);
            Executor executor = this.f49684g;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.a(((ScheduledExecutorService) executor).schedule((Callable) scheduledRunnable, j8, timeUnit));
                } catch (RejectedExecutionException e8) {
                    this.f49686i = true;
                    RxJavaPlugins.s(e8);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.a(new DisposeOnCancel(ExecutorScheduler.f49676e.e(scheduledRunnable, j8, timeUnit)));
            }
            sequentialDisposable.a(scheduledRunnable);
            return sequentialDisposable2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f49686i) {
                this.f49686i = true;
                this.f49688k.dispose();
                if (this.f49687j.getAndIncrement() == 0) {
                    this.f49685h.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49686i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
            if (r3.f49686i == false) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
            r0.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
            r1 = r3.f49687j.addAndGet(-r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
            if (r1 != 0) goto L2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
                io.reactivex.internal.queue.MpscLinkedQueue<java.lang.Runnable> r0 = r3.f49685h
                r1 = 1
            L3:
                boolean r2 = r3.f49686i
                if (r2 == 0) goto Lb
                r0.clear()
                return
            Lb:
                java.lang.Object r2 = r0.poll()
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                if (r2 != 0) goto L25
                boolean r2 = r3.f49686i
                if (r2 == 0) goto L1b
                r0.clear()
                return
            L1b:
                java.util.concurrent.atomic.AtomicInteger r2 = r3.f49687j
                int r1 = -r1
                int r1 = r2.addAndGet(r1)
                if (r1 != 0) goto L3
                return
            L25:
                r2.run()
                boolean r2 = r3.f49686i
                if (r2 == 0) goto Lb
                r0.clear()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker.run():void");
        }
    }

    public ExecutorScheduler(Executor executor, boolean z7) {
        this.f49678d = executor;
        this.f49677c = z7;
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        return new ExecutorWorker(this.f49678d, this.f49677c);
    }

    @Override // io.reactivex.Scheduler
    public Disposable d(Runnable runnable) {
        Runnable u7 = RxJavaPlugins.u(runnable);
        try {
            if (this.f49678d instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(u7);
                scheduledDirectTask.a(((ExecutorService) this.f49678d).submit(scheduledDirectTask));
                return scheduledDirectTask;
            } else if (this.f49677c) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(u7, null);
                this.f49678d.execute(interruptibleRunnable);
                return interruptibleRunnable;
            } else {
                ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(u7);
                this.f49678d.execute(booleanRunnable);
                return booleanRunnable;
            }
        } catch (RejectedExecutionException e8) {
            RxJavaPlugins.s(e8);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    public Disposable e(Runnable runnable, long j8, TimeUnit timeUnit) {
        Runnable u7 = RxJavaPlugins.u(runnable);
        if (this.f49678d instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(u7);
                scheduledDirectTask.a(((ScheduledExecutorService) this.f49678d).schedule(scheduledDirectTask, j8, timeUnit));
                return scheduledDirectTask;
            } catch (RejectedExecutionException e8) {
                RxJavaPlugins.s(e8);
                return EmptyDisposable.INSTANCE;
            }
        }
        DelayedRunnable delayedRunnable = new DelayedRunnable(u7);
        delayedRunnable.f49681f.a(f49676e.e(new DelayedDispose(delayedRunnable), j8, timeUnit));
        return delayedRunnable;
    }

    @Override // io.reactivex.Scheduler
    public Disposable f(Runnable runnable, long j8, long j9, TimeUnit timeUnit) {
        if (this.f49678d instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(RxJavaPlugins.u(runnable));
                scheduledDirectPeriodicTask.a(((ScheduledExecutorService) this.f49678d).scheduleAtFixedRate(scheduledDirectPeriodicTask, j8, j9, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e8) {
                RxJavaPlugins.s(e8);
                return EmptyDisposable.INSTANCE;
            }
        }
        return super.f(runnable, j8, j9, timeUnit);
    }
}
