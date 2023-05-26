package kotlinx.coroutines.scheduling;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: WorkQueue.kt */
/* loaded from: classes5.dex */
public final class WorkQueue {

    /* renamed from: b  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f51971b = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f51972c = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f51973d = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");

    /* renamed from: e  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f51974e = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReferenceArray<Task> f51975a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ Task b(WorkQueue workQueue, Task task, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return workQueue.a(task, z7);
    }

    private final Task c(Task task) {
        boolean z7 = true;
        if (task.f51960g.b() != 1) {
            z7 = false;
        }
        if (z7) {
            f51974e.incrementAndGet(this);
        }
        if (e() == 127) {
            return task;
        }
        int i8 = this.producerIndex & 127;
        while (this.f51975a.get(i8) != null) {
            Thread.yield();
        }
        this.f51975a.lazySet(i8, task);
        f51972c.incrementAndGet(this);
        return null;
    }

    private final void d(Task task) {
        if (task != null) {
            boolean z7 = true;
            if (task.f51960g.b() != 1) {
                z7 = false;
            }
            if (z7) {
                f51974e.decrementAndGet(this);
            }
        }
    }

    private final Task i() {
        Task andSet;
        while (true) {
            int i8 = this.consumerIndex;
            if (i8 - this.producerIndex == 0) {
                return null;
            }
            int i9 = i8 & 127;
            if (f51973d.compareAndSet(this, i8, i8 + 1) && (andSet = this.f51975a.getAndSet(i9, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(GlobalQueue globalQueue) {
        Task i8 = i();
        if (i8 == null) {
            return false;
        }
        globalQueue.a(i8);
        return true;
    }

    private final long m(WorkQueue workQueue, boolean z7) {
        Task task;
        do {
            task = (Task) workQueue.lastScheduledTask;
            if (task == null) {
                return -2L;
            }
            if (z7) {
                boolean z8 = true;
                if (task.f51960g.b() != 1) {
                    z8 = false;
                }
                if (!z8) {
                    return -2L;
                }
            }
            long a8 = TasksKt.f51967e.a() - task.f51959f;
            long j8 = TasksKt.f51963a;
            if (a8 < j8) {
                return j8 - a8;
            }
        } while (!a.a(f51971b, workQueue, task, null));
        b(this, task, false, 2, null);
        return -1L;
    }

    public final Task a(Task task, boolean z7) {
        if (z7) {
            return c(task);
        }
        Task task2 = (Task) f51971b.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return c(task2);
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        if (this.lastScheduledTask != null) {
            return e() + 1;
        }
        return e();
    }

    public final void g(GlobalQueue globalQueue) {
        Task task = (Task) f51971b.getAndSet(this, null);
        if (task != null) {
            globalQueue.a(task);
        }
        do {
        } while (j(globalQueue));
    }

    public final Task h() {
        Task task = (Task) f51971b.getAndSet(this, null);
        if (task == null) {
            return i();
        }
        return task;
    }

    public final long k(WorkQueue workQueue) {
        int i8 = workQueue.consumerIndex;
        int i9 = workQueue.producerIndex;
        AtomicReferenceArray<Task> atomicReferenceArray = workQueue.f51975a;
        while (true) {
            boolean z7 = true;
            if (i8 == i9) {
                break;
            }
            int i10 = i8 & 127;
            if (workQueue.blockingTasksInBuffer == 0) {
                break;
            }
            Task task = atomicReferenceArray.get(i10);
            if (task != null) {
                if (task.f51960g.b() != 1) {
                    z7 = false;
                }
                if (z7 && io.ktor.utils.io.pool.a.a(atomicReferenceArray, i10, task, null)) {
                    f51974e.decrementAndGet(workQueue);
                    b(this, task, false, 2, null);
                    return -1L;
                }
            }
            i8++;
        }
        return m(workQueue, true);
    }

    public final long l(WorkQueue workQueue) {
        Task i8 = workQueue.i();
        if (i8 != null) {
            b(this, i8, false, 2, null);
            return -1L;
        }
        return m(workQueue, false);
    }
}
