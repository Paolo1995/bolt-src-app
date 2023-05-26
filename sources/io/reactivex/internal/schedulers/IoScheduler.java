package io.reactivex.internal.schedulers;

import androidx.camera.view.e;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class IoScheduler extends Scheduler {

    /* renamed from: e  reason: collision with root package name */
    static final RxThreadFactory f49702e;

    /* renamed from: f  reason: collision with root package name */
    static final RxThreadFactory f49703f;

    /* renamed from: i  reason: collision with root package name */
    static final ThreadWorker f49706i;

    /* renamed from: j  reason: collision with root package name */
    static boolean f49707j;

    /* renamed from: k  reason: collision with root package name */
    static final CachedWorkerPool f49708k;

    /* renamed from: c  reason: collision with root package name */
    final ThreadFactory f49709c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<CachedWorkerPool> f49710d;

    /* renamed from: h  reason: collision with root package name */
    private static final TimeUnit f49705h = TimeUnit.SECONDS;

    /* renamed from: g  reason: collision with root package name */
    private static final long f49704g = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class CachedWorkerPool implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final long f49711f;

        /* renamed from: g  reason: collision with root package name */
        private final ConcurrentLinkedQueue<ThreadWorker> f49712g;

        /* renamed from: h  reason: collision with root package name */
        final CompositeDisposable f49713h;

        /* renamed from: i  reason: collision with root package name */
        private final ScheduledExecutorService f49714i;

        /* renamed from: j  reason: collision with root package name */
        private final Future<?> f49715j;

        /* renamed from: k  reason: collision with root package name */
        private final ThreadFactory f49716k;

        CachedWorkerPool(long j8, TimeUnit timeUnit, ThreadFactory threadFactory) {
            long j9;
            ScheduledFuture<?> scheduledFuture;
            if (timeUnit != null) {
                j9 = timeUnit.toNanos(j8);
            } else {
                j9 = 0;
            }
            long j10 = j9;
            this.f49711f = j10;
            this.f49712g = new ConcurrentLinkedQueue<>();
            this.f49713h = new CompositeDisposable();
            this.f49716k = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.f49703f);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j10, j10, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f49714i = scheduledExecutorService;
            this.f49715j = scheduledFuture;
        }

        void a() {
            if (!this.f49712g.isEmpty()) {
                long c8 = c();
                Iterator<ThreadWorker> it = this.f49712g.iterator();
                while (it.hasNext()) {
                    ThreadWorker next = it.next();
                    if (next.i() <= c8) {
                        if (this.f49712g.remove(next)) {
                            this.f49713h.a(next);
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        ThreadWorker b() {
            if (this.f49713h.isDisposed()) {
                return IoScheduler.f49706i;
            }
            while (!this.f49712g.isEmpty()) {
                ThreadWorker poll = this.f49712g.poll();
                if (poll != null) {
                    return poll;
                }
            }
            ThreadWorker threadWorker = new ThreadWorker(this.f49716k);
            this.f49713h.b(threadWorker);
            return threadWorker;
        }

        long c() {
            return System.nanoTime();
        }

        void d(ThreadWorker threadWorker) {
            threadWorker.j(c() + this.f49711f);
            this.f49712g.offer(threadWorker);
        }

        void e() {
            this.f49713h.dispose();
            Future<?> future = this.f49715j;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f49714i;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    /* loaded from: classes5.dex */
    static final class EventLoopWorker extends Scheduler.Worker implements Runnable {

        /* renamed from: g  reason: collision with root package name */
        private final CachedWorkerPool f49718g;

        /* renamed from: h  reason: collision with root package name */
        private final ThreadWorker f49719h;

        /* renamed from: i  reason: collision with root package name */
        final AtomicBoolean f49720i = new AtomicBoolean();

        /* renamed from: f  reason: collision with root package name */
        private final CompositeDisposable f49717f = new CompositeDisposable();

        EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            this.f49718g = cachedWorkerPool;
            this.f49719h = cachedWorkerPool.b();
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable c(Runnable runnable, long j8, TimeUnit timeUnit) {
            if (this.f49717f.isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f49719h.e(runnable, j8, timeUnit, this.f49717f);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f49720i.compareAndSet(false, true)) {
                this.f49717f.dispose();
                if (IoScheduler.f49707j) {
                    this.f49719h.e(this, 0L, TimeUnit.NANOSECONDS, null);
                } else {
                    this.f49718g.d(this.f49719h);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49720i.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f49718g.d(this.f49719h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ThreadWorker extends NewThreadWorker {

        /* renamed from: h  reason: collision with root package name */
        private long f49721h;

        ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f49721h = 0L;
        }

        public long i() {
            return this.f49721h;
        }

        public void j(long j8) {
            this.f49721h = j8;
        }
    }

    static {
        ThreadWorker threadWorker = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f49706i = threadWorker;
        threadWorker.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", max);
        f49702e = rxThreadFactory;
        f49703f = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        f49707j = Boolean.getBoolean("rx2.io-scheduled-release");
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(0L, null, rxThreadFactory);
        f49708k = cachedWorkerPool;
        cachedWorkerPool.e();
    }

    public IoScheduler() {
        this(f49702e);
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        return new EventLoopWorker(this.f49710d.get());
    }

    public void g() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(f49704g, f49705h, this.f49709c);
        if (!e.a(this.f49710d, f49708k, cachedWorkerPool)) {
            cachedWorkerPool.e();
        }
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.f49709c = threadFactory;
        this.f49710d = new AtomicReference<>(f49708k);
        g();
    }
}
