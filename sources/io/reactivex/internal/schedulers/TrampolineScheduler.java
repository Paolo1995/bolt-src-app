package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class TrampolineScheduler extends Scheduler {

    /* renamed from: c  reason: collision with root package name */
    private static final TrampolineScheduler f49745c = new TrampolineScheduler();

    /* loaded from: classes5.dex */
    static final class SleepingRunnable implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final Runnable f49746f;

        /* renamed from: g  reason: collision with root package name */
        private final TrampolineWorker f49747g;

        /* renamed from: h  reason: collision with root package name */
        private final long f49748h;

        SleepingRunnable(Runnable runnable, TrampolineWorker trampolineWorker, long j8) {
            this.f49746f = runnable;
            this.f49747g = trampolineWorker;
            this.f49748h = j8;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f49747g.f49756i) {
                long a8 = this.f49747g.a(TimeUnit.MILLISECONDS);
                long j8 = this.f49748h;
                if (j8 > a8) {
                    try {
                        Thread.sleep(j8 - a8);
                    } catch (InterruptedException e8) {
                        Thread.currentThread().interrupt();
                        RxJavaPlugins.s(e8);
                        return;
                    }
                }
                if (!this.f49747g.f49756i) {
                    this.f49746f.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class TimedRunnable implements Comparable<TimedRunnable> {

        /* renamed from: f  reason: collision with root package name */
        final Runnable f49749f;

        /* renamed from: g  reason: collision with root package name */
        final long f49750g;

        /* renamed from: h  reason: collision with root package name */
        final int f49751h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f49752i;

        TimedRunnable(Runnable runnable, Long l8, int i8) {
            this.f49749f = runnable;
            this.f49750g = l8.longValue();
            this.f49751h = i8;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(TimedRunnable timedRunnable) {
            int b8 = ObjectHelper.b(this.f49750g, timedRunnable.f49750g);
            if (b8 == 0) {
                return ObjectHelper.a(this.f49751h, timedRunnable.f49751h);
            }
            return b8;
        }
    }

    /* loaded from: classes5.dex */
    static final class TrampolineWorker extends Scheduler.Worker {

        /* renamed from: f  reason: collision with root package name */
        final PriorityBlockingQueue<TimedRunnable> f49753f = new PriorityBlockingQueue<>();

        /* renamed from: g  reason: collision with root package name */
        private final AtomicInteger f49754g = new AtomicInteger();

        /* renamed from: h  reason: collision with root package name */
        final AtomicInteger f49755h = new AtomicInteger();

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f49756i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public final class AppendToQueueTask implements Runnable {

            /* renamed from: f  reason: collision with root package name */
            final TimedRunnable f49757f;

            AppendToQueueTask(TimedRunnable timedRunnable) {
                this.f49757f = timedRunnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f49757f.f49752i = true;
                TrampolineWorker.this.f49753f.remove(this.f49757f);
            }
        }

        TrampolineWorker() {
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable b(Runnable runnable) {
            return e(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable c(Runnable runnable, long j8, TimeUnit timeUnit) {
            long a8 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j8);
            return e(new SleepingRunnable(runnable, this, a8), a8);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49756i = true;
        }

        Disposable e(Runnable runnable, long j8) {
            if (this.f49756i) {
                return EmptyDisposable.INSTANCE;
            }
            TimedRunnable timedRunnable = new TimedRunnable(runnable, Long.valueOf(j8), this.f49755h.incrementAndGet());
            this.f49753f.add(timedRunnable);
            if (this.f49754g.getAndIncrement() == 0) {
                int i8 = 1;
                while (!this.f49756i) {
                    TimedRunnable poll = this.f49753f.poll();
                    if (poll == null) {
                        i8 = this.f49754g.addAndGet(-i8);
                        if (i8 == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                    } else if (!poll.f49752i) {
                        poll.f49749f.run();
                    }
                }
                this.f49753f.clear();
                return EmptyDisposable.INSTANCE;
            }
            return Disposables.d(new AppendToQueueTask(timedRunnable));
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49756i;
        }
    }

    TrampolineScheduler() {
    }

    public static TrampolineScheduler g() {
        return f49745c;
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        return new TrampolineWorker();
    }

    @Override // io.reactivex.Scheduler
    public Disposable d(Runnable runnable) {
        RxJavaPlugins.u(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.Scheduler
    public Disposable e(Runnable runnable, long j8, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j8);
            RxJavaPlugins.u(runnable).run();
        } catch (InterruptedException e8) {
            Thread.currentThread().interrupt();
            RxJavaPlugins.s(e8);
        }
        return EmptyDisposable.INSTANCE;
    }
}
