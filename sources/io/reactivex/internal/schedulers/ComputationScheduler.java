package io.reactivex.internal.schedulers;

import androidx.camera.view.e;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ComputationScheduler extends Scheduler {

    /* renamed from: e  reason: collision with root package name */
    static final FixedSchedulerPool f49661e;

    /* renamed from: f  reason: collision with root package name */
    static final RxThreadFactory f49662f;

    /* renamed from: g  reason: collision with root package name */
    static final int f49663g = g(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: h  reason: collision with root package name */
    static final PoolWorker f49664h;

    /* renamed from: c  reason: collision with root package name */
    final ThreadFactory f49665c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<FixedSchedulerPool> f49666d;

    /* loaded from: classes5.dex */
    static final class EventLoopWorker extends Scheduler.Worker {

        /* renamed from: f  reason: collision with root package name */
        private final ListCompositeDisposable f49667f;

        /* renamed from: g  reason: collision with root package name */
        private final CompositeDisposable f49668g;

        /* renamed from: h  reason: collision with root package name */
        private final ListCompositeDisposable f49669h;

        /* renamed from: i  reason: collision with root package name */
        private final PoolWorker f49670i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f49671j;

        EventLoopWorker(PoolWorker poolWorker) {
            this.f49670i = poolWorker;
            ListCompositeDisposable listCompositeDisposable = new ListCompositeDisposable();
            this.f49667f = listCompositeDisposable;
            CompositeDisposable compositeDisposable = new CompositeDisposable();
            this.f49668g = compositeDisposable;
            ListCompositeDisposable listCompositeDisposable2 = new ListCompositeDisposable();
            this.f49669h = listCompositeDisposable2;
            listCompositeDisposable2.b(listCompositeDisposable);
            listCompositeDisposable2.b(compositeDisposable);
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable b(Runnable runnable) {
            if (this.f49671j) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f49670i.e(runnable, 0L, TimeUnit.MILLISECONDS, this.f49667f);
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable c(Runnable runnable, long j8, TimeUnit timeUnit) {
            if (this.f49671j) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f49670i.e(runnable, j8, timeUnit, this.f49668g);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f49671j) {
                this.f49671j = true;
                this.f49669h.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49671j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class FixedSchedulerPool {

        /* renamed from: a  reason: collision with root package name */
        final int f49672a;

        /* renamed from: b  reason: collision with root package name */
        final PoolWorker[] f49673b;

        /* renamed from: c  reason: collision with root package name */
        long f49674c;

        FixedSchedulerPool(int i8, ThreadFactory threadFactory) {
            this.f49672a = i8;
            this.f49673b = new PoolWorker[i8];
            for (int i9 = 0; i9 < i8; i9++) {
                this.f49673b[i9] = new PoolWorker(threadFactory);
            }
        }

        public PoolWorker a() {
            int i8 = this.f49672a;
            if (i8 == 0) {
                return ComputationScheduler.f49664h;
            }
            PoolWorker[] poolWorkerArr = this.f49673b;
            long j8 = this.f49674c;
            this.f49674c = 1 + j8;
            return poolWorkerArr[(int) (j8 % i8)];
        }

        public void b() {
            for (PoolWorker poolWorker : this.f49673b) {
                poolWorker.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        PoolWorker poolWorker = new PoolWorker(new RxThreadFactory("RxComputationShutdown"));
        f49664h = poolWorker;
        poolWorker.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f49662f = rxThreadFactory;
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(0, rxThreadFactory);
        f49661e = fixedSchedulerPool;
        fixedSchedulerPool.b();
    }

    public ComputationScheduler() {
        this(f49662f);
    }

    static int g(int i8, int i9) {
        return (i9 <= 0 || i9 > i8) ? i8 : i9;
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        return new EventLoopWorker(this.f49666d.get().a());
    }

    @Override // io.reactivex.Scheduler
    public Disposable e(Runnable runnable, long j8, TimeUnit timeUnit) {
        return this.f49666d.get().a().f(runnable, j8, timeUnit);
    }

    @Override // io.reactivex.Scheduler
    public Disposable f(Runnable runnable, long j8, long j9, TimeUnit timeUnit) {
        return this.f49666d.get().a().g(runnable, j8, j9, timeUnit);
    }

    public void h() {
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(f49663g, this.f49665c);
        if (!e.a(this.f49666d, f49661e, fixedSchedulerPool)) {
            fixedSchedulerPool.b();
        }
    }

    public ComputationScheduler(ThreadFactory threadFactory) {
        this.f49665c = threadFactory;
        this.f49666d = new AtomicReference<>(f49661e);
        h();
    }
}
