package kotlinx.coroutines.scheduling;

import com.google.android.gms.common.api.Api;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: CoroutineScheduler.kt */
/* loaded from: classes5.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;
    volatile /* synthetic */ long controlState;

    /* renamed from: f  reason: collision with root package name */
    public final int f51928f;

    /* renamed from: g  reason: collision with root package name */
    public final int f51929g;

    /* renamed from: h  reason: collision with root package name */
    public final long f51930h;

    /* renamed from: i  reason: collision with root package name */
    public final String f51931i;

    /* renamed from: j  reason: collision with root package name */
    public final GlobalQueue f51932j;

    /* renamed from: k  reason: collision with root package name */
    public final GlobalQueue f51933k;

    /* renamed from: l  reason: collision with root package name */
    public final ResizableAtomicArray<Worker> f51934l;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* renamed from: m  reason: collision with root package name */
    public static final Companion f51923m = new Companion(null);

    /* renamed from: q  reason: collision with root package name */
    public static final Symbol f51927q = new Symbol("NOT_IN_STACK");

    /* renamed from: n  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f51924n = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* renamed from: o  reason: collision with root package name */
    static final /* synthetic */ AtomicLongFieldUpdater f51925o = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* renamed from: p  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f51926p = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51935a;

        static {
            int[] iArr = new int[WorkerState.values().length];
            iArr[WorkerState.PARKING.ordinal()] = 1;
            iArr[WorkerState.BLOCKING.ordinal()] = 2;
            iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            iArr[WorkerState.DORMANT.ordinal()] = 4;
            iArr[WorkerState.TERMINATED.ordinal()] = 5;
            f51935a = iArr;
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes5.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public CoroutineScheduler(int i8, int i9, long j8, String str) {
        boolean z7;
        boolean z8;
        boolean z9;
        this.f51928f = i8;
        this.f51929g = i9;
        this.f51930h = j8;
        this.f51931i = str;
        if (i8 >= 1) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i9 >= i8) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                if (i9 <= 2097150) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (z9) {
                    if (j8 > 0) {
                        this.f51932j = new GlobalQueue();
                        this.f51933k = new GlobalQueue();
                        this.parkedWorkersStack = 0L;
                        this.f51934l = new ResizableAtomicArray<>(i8 + 1);
                        this.controlState = i8 << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j8 + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + i9 + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + i9 + " should be greater than or equals to core pool size " + i8).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + i8 + " should be at least 1").toString());
    }

    private final Task I(Worker worker, Task task, boolean z7) {
        if (worker == null) {
            return task;
        }
        if (worker.f51938g == WorkerState.TERMINATED) {
            return task;
        }
        if (task.f51960g.b() == 0 && worker.f51938g == WorkerState.BLOCKING) {
            return task;
        }
        worker.f51942k = true;
        return worker.f51937f.a(task, z7);
    }

    private final boolean N(long j8) {
        int d8;
        d8 = RangesKt___RangesKt.d(((int) (2097151 & j8)) - ((int) ((j8 & 4398044413952L) >> 21)), 0);
        if (d8 < this.f51928f) {
            int c8 = c();
            if (c8 == 1 && this.f51928f > 1) {
                c();
            }
            if (c8 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean O(CoroutineScheduler coroutineScheduler, long j8, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            j8 = coroutineScheduler.controlState;
        }
        return coroutineScheduler.N(j8);
    }

    private final boolean X() {
        Worker l8;
        do {
            l8 = l();
            if (l8 == null) {
                return false;
            }
        } while (!Worker.f51936m.compareAndSet(l8, -1, 0));
        LockSupport.unpark(l8);
        return true;
    }

    private final boolean a(Task task) {
        boolean z7 = true;
        if (task.f51960g.b() != 1) {
            z7 = false;
        }
        if (z7) {
            return this.f51933k.a(task);
        }
        return this.f51932j.a(task);
    }

    private final int c() {
        int d8;
        boolean z7;
        synchronized (this.f51934l) {
            if (isTerminated()) {
                return -1;
            }
            long j8 = this.controlState;
            int i8 = (int) (j8 & 2097151);
            boolean z8 = false;
            d8 = RangesKt___RangesKt.d(i8 - ((int) ((j8 & 4398044413952L) >> 21)), 0);
            if (d8 >= this.f51928f) {
                return 0;
            }
            if (i8 >= this.f51929g) {
                return 0;
            }
            int i9 = ((int) (this.controlState & 2097151)) + 1;
            if (i9 > 0 && this.f51934l.b(i9) == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                Worker worker = new Worker(this, i9);
                this.f51934l.c(i9, worker);
                if (i9 == ((int) (2097151 & f51925o.incrementAndGet(this)))) {
                    z8 = true;
                }
                if (z8) {
                    worker.start();
                    return d8 + 1;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final Worker g() {
        Worker worker;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof Worker) {
            worker = (Worker) currentThread;
        } else {
            worker = null;
        }
        if (worker == null || !Intrinsics.a(CoroutineScheduler.this, this)) {
            return null;
        }
        return worker;
    }

    public static /* synthetic */ void j(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            taskContext = TasksKt.f51968f;
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        coroutineScheduler.h(runnable, taskContext, z7);
    }

    private final int k(Worker worker) {
        Object h8 = worker.h();
        while (h8 != f51927q) {
            if (h8 == null) {
                return 0;
            }
            Worker worker2 = (Worker) h8;
            int g8 = worker2.g();
            if (g8 != 0) {
                return g8;
            }
            h8 = worker2.h();
        }
        return -1;
    }

    private final Worker l() {
        while (true) {
            long j8 = this.parkedWorkersStack;
            Worker b8 = this.f51934l.b((int) (2097151 & j8));
            if (b8 == null) {
                return null;
            }
            long j9 = (2097152 + j8) & (-2097152);
            int k8 = k(b8);
            if (k8 >= 0 && f51924n.compareAndSet(this, j8, k8 | j9)) {
                b8.p(f51927q);
                return b8;
            }
        }
    }

    private final void y(boolean z7) {
        long addAndGet = f51925o.addAndGet(this, 2097152L);
        if (z7 || X() || N(addAndGet)) {
            return;
        }
        X();
    }

    public final void F() {
        if (X() || O(this, 0L, 1, null)) {
            return;
        }
        X();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        w(10000L);
    }

    public final Task e(Runnable runnable, TaskContext taskContext) {
        long a8 = TasksKt.f51967e.a();
        if (runnable instanceof Task) {
            Task task = (Task) runnable;
            task.f51959f = a8;
            task.f51960g = taskContext;
            return task;
        }
        return new TaskImpl(runnable, a8, taskContext);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        j(this, runnable, null, false, 6, null);
    }

    public final void h(Runnable runnable, TaskContext taskContext, boolean z7) {
        boolean z8;
        AbstractTimeSource a8 = AbstractTimeSourceKt.a();
        if (a8 != null) {
            a8.d();
        }
        Task e8 = e(runnable, taskContext);
        Worker g8 = g();
        Task I = I(g8, e8, z7);
        if (I != null && !a(I)) {
            throw new RejectedExecutionException(this.f51931i + " was terminated");
        }
        if (z7 && g8 != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (e8.f51960g.b() == 0) {
            if (z8) {
                return;
            }
            F();
            return;
        }
        y(z8);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final boolean m(Worker worker) {
        long j8;
        int g8;
        if (worker.h() != f51927q) {
            return false;
        }
        do {
            j8 = this.parkedWorkersStack;
            g8 = worker.g();
            worker.p(this.f51934l.b((int) (2097151 & j8)));
        } while (!f51924n.compareAndSet(this, j8, ((2097152 + j8) & (-2097152)) | g8));
        return true;
    }

    public final void q(Worker worker, int i8, int i9) {
        while (true) {
            long j8 = this.parkedWorkersStack;
            int i10 = (int) (2097151 & j8);
            long j9 = (2097152 + j8) & (-2097152);
            if (i10 == i8) {
                if (i9 == 0) {
                    i10 = k(worker);
                } else {
                    i10 = i9;
                }
            }
            if (i10 >= 0 && f51924n.compareAndSet(this, j8, j9 | i10)) {
                return;
            }
        }
    }

    public final void t(Task task) {
        try {
            task.run();
        } catch (Throwable th) {
            try {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
                AbstractTimeSource a8 = AbstractTimeSourceKt.a();
                if (a8 == null) {
                }
            } finally {
                AbstractTimeSource a9 = AbstractTimeSourceKt.a();
                if (a9 != null) {
                    a9.e();
                }
            }
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int a8 = this.f51934l.a();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 1; i13 < a8; i13++) {
            Worker b8 = this.f51934l.b(i13);
            if (b8 != null) {
                int f8 = b8.f51937f.f();
                int i14 = WhenMappings.f51935a[b8.f51938g.ordinal()];
                if (i14 != 1) {
                    if (i14 != 2) {
                        if (i14 != 3) {
                            if (i14 != 4) {
                                if (i14 == 5) {
                                    i12++;
                                }
                            } else {
                                i11++;
                                if (f8 > 0) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(f8);
                                    sb.append('d');
                                    arrayList.add(sb.toString());
                                }
                            }
                        } else {
                            i8++;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(f8);
                            sb2.append('c');
                            arrayList.add(sb2.toString());
                        }
                    } else {
                        i9++;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(f8);
                        sb3.append('b');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    i10++;
                }
            }
        }
        long j8 = this.controlState;
        return this.f51931i + '@' + DebugStringsKt.b(this) + "[Pool Size {core = " + this.f51928f + ", max = " + this.f51929g + "}, Worker States {CPU = " + i8 + ", blocking = " + i9 + ", parked = " + i10 + ", dormant = " + i11 + ", terminated = " + i12 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f51932j.c() + ", global blocking queue size = " + this.f51933k.c() + ", Control State {created workers= " + ((int) (2097151 & j8)) + ", blocking tasks = " + ((int) ((4398044413952L & j8) >> 21)) + ", CPUs acquired = " + (this.f51928f - ((int) ((9223367638808264704L & j8) >> 42))) + "}]";
    }

    public final void w(long j8) {
        int i8;
        Task d8;
        if (!f51926p.compareAndSet(this, 0, 1)) {
            return;
        }
        Worker g8 = g();
        synchronized (this.f51934l) {
            i8 = (int) (this.controlState & 2097151);
        }
        if (1 <= i8) {
            int i9 = 1;
            while (true) {
                Worker b8 = this.f51934l.b(i9);
                Intrinsics.c(b8);
                Worker worker = b8;
                if (worker != g8) {
                    while (worker.isAlive()) {
                        LockSupport.unpark(worker);
                        worker.join(j8);
                    }
                    worker.f51937f.g(this.f51933k);
                }
                if (i9 == i8) {
                    break;
                }
                i9++;
            }
        }
        this.f51933k.b();
        this.f51932j.b();
        while (true) {
            if (g8 != null) {
                d8 = g8.f(true);
                if (d8 != null) {
                    continue;
                    t(d8);
                }
            }
            d8 = this.f51932j.d();
            if (d8 == null && (d8 = this.f51933k.d()) == null) {
                break;
            }
            t(d8);
        }
        if (g8 != null) {
            g8.s(WorkerState.TERMINATED);
        }
        this.parkedWorkersStack = 0L;
        this.controlState = 0L;
    }

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes5.dex */
    public final class Worker extends Thread {

        /* renamed from: m  reason: collision with root package name */
        static final /* synthetic */ AtomicIntegerFieldUpdater f51936m = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");

        /* renamed from: f  reason: collision with root package name */
        public final WorkQueue f51937f;

        /* renamed from: g  reason: collision with root package name */
        public WorkerState f51938g;

        /* renamed from: h  reason: collision with root package name */
        private long f51939h;

        /* renamed from: i  reason: collision with root package name */
        private long f51940i;
        private volatile int indexInArray;

        /* renamed from: j  reason: collision with root package name */
        private int f51941j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f51942k;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        private Worker() {
            setDaemon(true);
            this.f51937f = new WorkQueue();
            this.f51938g = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.f51927q;
            this.f51941j = Random.f51030f.d();
        }

        private final void b(int i8) {
            if (i8 == 0) {
                return;
            }
            CoroutineScheduler.f51925o.addAndGet(CoroutineScheduler.this, -2097152L);
            if (this.f51938g != WorkerState.TERMINATED) {
                this.f51938g = WorkerState.DORMANT;
            }
        }

        private final void c(int i8) {
            if (i8 != 0 && s(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.F();
            }
        }

        private final void d(Task task) {
            int b8 = task.f51960g.b();
            i(b8);
            c(b8);
            CoroutineScheduler.this.t(task);
            b(b8);
        }

        private final Task e(boolean z7) {
            boolean z8;
            Task m8;
            Task m9;
            if (z7) {
                if (k(CoroutineScheduler.this.f51928f * 2) == 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z8 && (m9 = m()) != null) {
                    return m9;
                }
                Task h8 = this.f51937f.h();
                if (h8 != null) {
                    return h8;
                }
                if (!z8 && (m8 = m()) != null) {
                    return m8;
                }
            } else {
                Task m10 = m();
                if (m10 != null) {
                    return m10;
                }
            }
            return t(false);
        }

        private final void i(int i8) {
            this.f51939h = 0L;
            if (this.f51938g == WorkerState.PARKING) {
                this.f51938g = WorkerState.BLOCKING;
            }
        }

        private final boolean j() {
            if (this.nextParkedWorker != CoroutineScheduler.f51927q) {
                return true;
            }
            return false;
        }

        private final void l() {
            if (this.f51939h == 0) {
                this.f51939h = System.nanoTime() + CoroutineScheduler.this.f51930h;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f51930h);
            if (System.nanoTime() - this.f51939h >= 0) {
                this.f51939h = 0L;
                u();
            }
        }

        private final Task m() {
            if (k(2) == 0) {
                Task d8 = CoroutineScheduler.this.f51932j.d();
                if (d8 != null) {
                    return d8;
                }
                return CoroutineScheduler.this.f51933k.d();
            }
            Task d9 = CoroutineScheduler.this.f51933k.d();
            if (d9 != null) {
                return d9;
            }
            return CoroutineScheduler.this.f51932j.d();
        }

        private final void n() {
            loop0: while (true) {
                boolean z7 = false;
                while (!CoroutineScheduler.this.isTerminated() && this.f51938g != WorkerState.TERMINATED) {
                    Task f8 = f(this.f51942k);
                    if (f8 != null) {
                        this.f51940i = 0L;
                        d(f8);
                    } else {
                        this.f51942k = false;
                        if (this.f51940i != 0) {
                            if (!z7) {
                                z7 = true;
                            } else {
                                s(WorkerState.PARKING);
                                Thread.interrupted();
                                LockSupport.parkNanos(this.f51940i);
                                this.f51940i = 0L;
                            }
                        } else {
                            r();
                        }
                    }
                }
            }
            s(WorkerState.TERMINATED);
        }

        private final boolean q() {
            boolean z7;
            if (this.f51938g != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j8 = coroutineScheduler.controlState;
                    if (((int) ((9223367638808264704L & j8) >> 42)) == 0) {
                        z7 = false;
                        break;
                    }
                    if (CoroutineScheduler.f51925o.compareAndSet(coroutineScheduler, j8, j8 - 4398046511104L)) {
                        z7 = true;
                        break;
                    }
                }
                if (!z7) {
                    return false;
                }
                this.f51938g = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        private final void r() {
            if (!j()) {
                CoroutineScheduler.this.m(this);
                return;
            }
            this.workerCtl = -1;
            while (j() && this.workerCtl == -1 && !CoroutineScheduler.this.isTerminated() && this.f51938g != WorkerState.TERMINATED) {
                s(WorkerState.PARKING);
                Thread.interrupted();
                l();
            }
        }

        private final Task t(boolean z7) {
            long l8;
            int i8 = (int) (CoroutineScheduler.this.controlState & 2097151);
            if (i8 < 2) {
                return null;
            }
            int k8 = k(i8);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j8 = Long.MAX_VALUE;
            for (int i9 = 0; i9 < i8; i9++) {
                k8++;
                if (k8 > i8) {
                    k8 = 1;
                }
                Worker b8 = coroutineScheduler.f51934l.b(k8);
                if (b8 != null && b8 != this) {
                    if (z7) {
                        l8 = this.f51937f.k(b8.f51937f);
                    } else {
                        l8 = this.f51937f.l(b8.f51937f);
                    }
                    if (l8 == -1) {
                        return this.f51937f.h();
                    }
                    if (l8 > 0) {
                        j8 = Math.min(j8, l8);
                    }
                }
            }
            if (j8 == Long.MAX_VALUE) {
                j8 = 0;
            }
            this.f51940i = j8;
            return null;
        }

        private final void u() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.f51934l) {
                if (coroutineScheduler.isTerminated()) {
                    return;
                }
                if (((int) (coroutineScheduler.controlState & 2097151)) <= coroutineScheduler.f51928f) {
                    return;
                }
                if (!f51936m.compareAndSet(this, -1, 1)) {
                    return;
                }
                int i8 = this.indexInArray;
                o(0);
                coroutineScheduler.q(this, i8, 0);
                int andDecrement = (int) (CoroutineScheduler.f51925o.getAndDecrement(coroutineScheduler) & 2097151);
                if (andDecrement != i8) {
                    Worker b8 = coroutineScheduler.f51934l.b(andDecrement);
                    Intrinsics.c(b8);
                    Worker worker = b8;
                    coroutineScheduler.f51934l.c(i8, worker);
                    worker.o(i8);
                    coroutineScheduler.q(worker, andDecrement, i8);
                }
                coroutineScheduler.f51934l.c(andDecrement, null);
                Unit unit = Unit.f50853a;
                this.f51938g = WorkerState.TERMINATED;
            }
        }

        public final Task f(boolean z7) {
            Task d8;
            if (q()) {
                return e(z7);
            }
            if (z7) {
                d8 = this.f51937f.h();
                if (d8 == null) {
                    d8 = CoroutineScheduler.this.f51933k.d();
                }
            } else {
                d8 = CoroutineScheduler.this.f51933k.d();
            }
            if (d8 == null) {
                return t(true);
            }
            return d8;
        }

        public final int g() {
            return this.indexInArray;
        }

        public final Object h() {
            return this.nextParkedWorker;
        }

        public final int k(int i8) {
            int i9 = this.f51941j;
            int i10 = i9 ^ (i9 << 13);
            int i11 = i10 ^ (i10 >> 17);
            int i12 = i11 ^ (i11 << 5);
            this.f51941j = i12;
            int i13 = i8 - 1;
            if ((i13 & i8) == 0) {
                return i12 & i13;
            }
            return (i12 & Api.BaseClientBuilder.API_PRIORITY_OTHER) % i8;
        }

        public final void o(int i8) {
            String valueOf;
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.f51931i);
            sb.append("-worker-");
            if (i8 == 0) {
                valueOf = "TERMINATED";
            } else {
                valueOf = String.valueOf(i8);
            }
            sb.append(valueOf);
            setName(sb.toString());
            this.indexInArray = i8;
        }

        public final void p(Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            n();
        }

        public final boolean s(WorkerState workerState) {
            boolean z7;
            WorkerState workerState2 = this.f51938g;
            if (workerState2 == WorkerState.CPU_ACQUIRED) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                CoroutineScheduler.f51925o.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f51938g = workerState;
            }
            return z7;
        }

        public Worker(CoroutineScheduler coroutineScheduler, int i8) {
            this();
            o(i8);
        }
    }
}
