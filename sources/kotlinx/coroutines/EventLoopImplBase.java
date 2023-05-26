package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes5.dex */
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {

    /* renamed from: k  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f51273k = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");

    /* renamed from: l  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f51274l = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes5.dex */
    public final class DelayedResumeTask extends DelayedTask {

        /* renamed from: h  reason: collision with root package name */
        private final CancellableContinuation<Unit> f51275h;

        /* JADX WARN: Multi-variable type inference failed */
        public DelayedResumeTask(long j8, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(j8);
            this.f51275h = cancellableContinuation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f51275h.C(EventLoopImplBase.this, Unit.f50853a);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public String toString() {
            return super.toString() + this.f51275h;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes5.dex */
    public static final class DelayedRunnableTask extends DelayedTask {

        /* renamed from: h  reason: collision with root package name */
        private final Runnable f51277h;

        public DelayedRunnableTask(long j8, Runnable runnable) {
            super(j8);
            this.f51277h = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f51277h.run();
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public String toString() {
            return super.toString() + this.f51277h;
        }
    }

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes5.dex */
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        private volatile Object _heap;

        /* renamed from: f  reason: collision with root package name */
        public long f51278f;

        /* renamed from: g  reason: collision with root package name */
        private int f51279g = -1;

        public DelayedTask(long j8) {
            this.f51278f = j8;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void a(ThreadSafeHeap<?> threadSafeHeap) {
            Symbol symbol;
            boolean z7;
            Object obj = this._heap;
            symbol = EventLoop_commonKt.f51281a;
            if (obj != symbol) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                this._heap = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public ThreadSafeHeap<?> c() {
            Object obj = this._heap;
            if (obj instanceof ThreadSafeHeap) {
                return (ThreadSafeHeap) obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final synchronized void dispose() {
            Symbol symbol;
            DelayedTaskQueue delayedTaskQueue;
            Symbol symbol2;
            Object obj = this._heap;
            symbol = EventLoop_commonKt.f51281a;
            if (obj == symbol) {
                return;
            }
            if (obj instanceof DelayedTaskQueue) {
                delayedTaskQueue = (DelayedTaskQueue) obj;
            } else {
                delayedTaskQueue = null;
            }
            if (delayedTaskQueue != null) {
                delayedTaskQueue.g(this);
            }
            symbol2 = EventLoop_commonKt.f51281a;
            this._heap = symbol2;
        }

        @Override // java.lang.Comparable
        /* renamed from: f */
        public int compareTo(DelayedTask delayedTask) {
            int i8 = ((this.f51278f - delayedTask.f51278f) > 0L ? 1 : ((this.f51278f - delayedTask.f51278f) == 0L ? 0 : -1));
            if (i8 > 0) {
                return 1;
            }
            if (i8 < 0) {
                return -1;
            }
            return 0;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public int getIndex() {
            return this.f51279g;
        }

        public final synchronized int h(long j8, DelayedTaskQueue delayedTaskQueue, EventLoopImplBase eventLoopImplBase) {
            Symbol symbol;
            Object obj = this._heap;
            symbol = EventLoop_commonKt.f51281a;
            if (obj == symbol) {
                return 2;
            }
            synchronized (delayedTaskQueue) {
                DelayedTask b8 = delayedTaskQueue.b();
                if (eventLoopImplBase.c()) {
                    return 1;
                }
                if (b8 == null) {
                    delayedTaskQueue.f51280b = j8;
                } else {
                    long j9 = b8.f51278f;
                    if (j9 - j8 < 0) {
                        j8 = j9;
                    }
                    if (j8 - delayedTaskQueue.f51280b > 0) {
                        delayedTaskQueue.f51280b = j8;
                    }
                }
                long j10 = this.f51278f;
                long j11 = delayedTaskQueue.f51280b;
                if (j10 - j11 < 0) {
                    this.f51278f = j11;
                }
                delayedTaskQueue.a(this);
                return 0;
            }
        }

        public final boolean j(long j8) {
            if (j8 - this.f51278f >= 0) {
                return true;
            }
            return false;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setIndex(int i8) {
            this.f51279g = i8;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f51278f + ']';
        }
    }

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes5.dex */
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {

        /* renamed from: b  reason: collision with root package name */
        public long f51280b;

        public DelayedTaskQueue(long j8) {
            this.f51280b = j8;
        }
    }

    private final int A1(long j8, DelayedTask delayedTask) {
        if (c()) {
            return 1;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue == null) {
            androidx.concurrent.futures.a.a(f51274l, this, null, new DelayedTaskQueue(j8));
            Object obj = this._delayed;
            Intrinsics.c(obj);
            delayedTaskQueue = (DelayedTaskQueue) obj;
        }
        return delayedTask.h(j8, delayedTaskQueue, this);
    }

    private final void C1(boolean z7) {
        this._isCompleted = z7 ? 1 : 0;
    }

    private final boolean D1(DelayedTask delayedTask) {
        DelayedTask delayedTask2;
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue != null) {
            delayedTask2 = delayedTaskQueue.e();
        } else {
            delayedTask2 = null;
        }
        if (delayedTask2 == delayedTask) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    public final boolean c() {
        return this._isCompleted;
    }

    private final void s1() {
        Symbol symbol;
        Symbol symbol2;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51273k;
                symbol = EventLoop_commonKt.f51282b;
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, null, symbol)) {
                    return;
                }
            } else if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol2 = EventLoop_commonKt.f51282b;
                if (obj == symbol2) {
                    return;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore.a((Runnable) obj);
                if (androidx.concurrent.futures.a.a(f51273k, this, obj, lockFreeTaskQueueCore)) {
                    return;
                }
            } else {
                ((LockFreeTaskQueueCore) obj).d();
                return;
            }
        }
    }

    private final Runnable t1() {
        Symbol symbol;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoop_commonKt.f51282b;
                if (obj == symbol) {
                    return null;
                }
                if (androidx.concurrent.futures.a.a(f51273k, this, obj, null)) {
                    return (Runnable) obj;
                }
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                Object j8 = lockFreeTaskQueueCore.j();
                if (j8 != LockFreeTaskQueueCore.f51814h) {
                    return (Runnable) j8;
                }
                androidx.concurrent.futures.a.a(f51273k, this, obj, lockFreeTaskQueueCore.i());
            }
        }
    }

    private final boolean v1(Runnable runnable) {
        Symbol symbol;
        while (true) {
            Object obj = this._queue;
            if (c()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f51273k, this, null, runnable)) {
                    return true;
                }
            } else if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoop_commonKt.f51282b;
                if (obj == symbol) {
                    return false;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore.a((Runnable) obj);
                lockFreeTaskQueueCore.a(runnable);
                if (androidx.concurrent.futures.a.a(f51273k, this, obj, lockFreeTaskQueueCore)) {
                    return true;
                }
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = (LockFreeTaskQueueCore) obj;
                int a8 = lockFreeTaskQueueCore2.a(runnable);
                if (a8 == 0) {
                    return true;
                }
                if (a8 != 1) {
                    if (a8 == 2) {
                        return false;
                    }
                } else {
                    androidx.concurrent.futures.a.a(f51273k, this, obj, lockFreeTaskQueueCore2.i());
                }
            }
        }
    }

    private final void x1() {
        long nanoTime;
        DelayedTask i8;
        AbstractTimeSource a8 = AbstractTimeSourceKt.a();
        if (a8 != null) {
            nanoTime = a8.a();
        } else {
            nanoTime = System.nanoTime();
        }
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
            if (delayedTaskQueue != null && (i8 = delayedTaskQueue.i()) != null) {
                p1(nanoTime, i8);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DisposableHandle B1(long j8, Runnable runnable) {
        long nanoTime;
        long c8 = EventLoop_commonKt.c(j8);
        if (c8 < 4611686018427387903L) {
            AbstractTimeSource a8 = AbstractTimeSourceKt.a();
            if (a8 != null) {
                nanoTime = a8.a();
            } else {
                nanoTime = System.nanoTime();
            }
            DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(c8 + nanoTime, runnable);
            z1(nanoTime, delayedRunnableTask);
            return delayedRunnableTask;
        }
        return NonDisposableHandle.f51324f;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void G0(CoroutineContext coroutineContext, Runnable runnable) {
        u1(runnable);
    }

    public DisposableHandle Y(long j8, Runnable runnable, CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.a(this, j8, runnable, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.EventLoop
    public long Z0() {
        DelayedTask e8;
        long nanoTime;
        long e9;
        Symbol symbol;
        if (super.Z0() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoop_commonKt.f51282b;
                if (obj != symbol) {
                    return 0L;
                }
                return Long.MAX_VALUE;
            } else if (!((LockFreeTaskQueueCore) obj).g()) {
                return 0L;
            }
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue == null || (e8 = delayedTaskQueue.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j8 = e8.f51278f;
        AbstractTimeSource a8 = AbstractTimeSourceKt.a();
        if (a8 != null) {
            nanoTime = a8.a();
        } else {
            nanoTime = System.nanoTime();
        }
        e9 = RangesKt___RangesKt.e(j8 - nanoTime, 0L);
        return e9;
    }

    @Override // kotlinx.coroutines.Delay
    public void j(long j8, CancellableContinuation<? super Unit> cancellableContinuation) {
        long nanoTime;
        long c8 = EventLoop_commonKt.c(j8);
        if (c8 < 4611686018427387903L) {
            AbstractTimeSource a8 = AbstractTimeSourceKt.a();
            if (a8 != null) {
                nanoTime = a8.a();
            } else {
                nanoTime = System.nanoTime();
            }
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(c8 + nanoTime, cancellableContinuation);
            z1(nanoTime, delayedResumeTask);
            CancellableContinuationKt.a(cancellableContinuation, delayedResumeTask);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0057  */
    @Override // kotlinx.coroutines.EventLoop
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long l1() {
        /*
            r9 = this;
            boolean r0 = r9.m1()
            r1 = 0
            if (r0 == 0) goto L9
            return r1
        L9:
            java.lang.Object r0 = r9._delayed
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
            if (r0 == 0) goto L4d
            boolean r3 = r0.d()
            if (r3 != 0) goto L4d
            kotlinx.coroutines.AbstractTimeSource r3 = kotlinx.coroutines.AbstractTimeSourceKt.a()
            if (r3 == 0) goto L20
            long r3 = r3.a()
            goto L24
        L20:
            long r3 = java.lang.System.nanoTime()
        L24:
            monitor-enter(r0)
            kotlinx.coroutines.internal.ThreadSafeHeapNode r5 = r0.b()     // Catch: java.lang.Throwable -> L4a
            r6 = 0
            if (r5 != 0) goto L2e
            monitor-exit(r0)
            goto L45
        L2e:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r5 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r5     // Catch: java.lang.Throwable -> L4a
            boolean r7 = r5.j(r3)     // Catch: java.lang.Throwable -> L4a
            r8 = 0
            if (r7 == 0) goto L3c
            boolean r5 = r9.v1(r5)     // Catch: java.lang.Throwable -> L4a
            goto L3d
        L3c:
            r5 = 0
        L3d:
            if (r5 == 0) goto L44
            kotlinx.coroutines.internal.ThreadSafeHeapNode r5 = r0.h(r8)     // Catch: java.lang.Throwable -> L4a
            r6 = r5
        L44:
            monitor-exit(r0)
        L45:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r6 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r6
            if (r6 != 0) goto L24
            goto L4d
        L4a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L4d:
            java.lang.Runnable r0 = r9.t1()
            if (r0 == 0) goto L57
            r0.run()
            return r1
        L57:
            long r0 = r9.Z0()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.l1():long");
    }

    @Override // kotlinx.coroutines.EventLoop
    public void shutdown() {
        ThreadLocalEventLoop.f51332a.c();
        C1(true);
        s1();
        do {
        } while (l1() <= 0);
        x1();
    }

    public void u1(Runnable runnable) {
        if (v1(runnable)) {
            q1();
        } else {
            DefaultExecutor.f51254m.u1(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w1() {
        Symbol symbol;
        if (!h1()) {
            return false;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue != null && !delayedTaskQueue.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoop_commonKt.f51282b;
                if (obj != symbol) {
                    return false;
                }
            } else {
                return ((LockFreeTaskQueueCore) obj).g();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void y1() {
        this._queue = null;
        this._delayed = null;
    }

    public final void z1(long j8, DelayedTask delayedTask) {
        int A1 = A1(j8, delayedTask);
        if (A1 != 0) {
            if (A1 != 1) {
                if (A1 != 2) {
                    throw new IllegalStateException("unexpected result".toString());
                }
                return;
            }
            p1(j8, delayedTask);
        } else if (D1(delayedTask)) {
            q1();
        }
    }
}
