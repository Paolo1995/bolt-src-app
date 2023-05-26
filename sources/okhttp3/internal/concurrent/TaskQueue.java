package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* compiled from: TaskQueue.kt */
/* loaded from: classes5.dex */
public final class TaskQueue {
    private Task activeTask;
    private boolean cancelActiveTask;
    private final List<Task> futureTasks;
    private final String name;
    private boolean shutdown;
    private final TaskRunner taskRunner;

    /* compiled from: TaskQueue.kt */
    /* loaded from: classes5.dex */
    private static final class AwaitIdleTask extends Task {
        private final CountDownLatch latch;

        public AwaitIdleTask() {
            super(Intrinsics.n(Util.okHttpName, " awaitIdle"), false);
            this.latch = new CountDownLatch(1);
        }

        public final CountDownLatch getLatch() {
            return this.latch;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.latch.countDown();
            return -1L;
        }
    }

    public TaskQueue(TaskRunner taskRunner, String name) {
        Intrinsics.f(taskRunner, "taskRunner");
        Intrinsics.f(name, "name");
        this.taskRunner = taskRunner;
        this.name = name;
        this.futureTasks = new ArrayList();
    }

    public static /* synthetic */ void execute$default(TaskQueue taskQueue, String name, long j8, boolean z7, Function0 block, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            j8 = 0;
        }
        if ((i8 & 4) != 0) {
            z7 = true;
        }
        Intrinsics.f(name, "name");
        Intrinsics.f(block, "block");
        taskQueue.schedule(new TaskQueue$execute$1(name, z7, block), j8);
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, Task task, long j8, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            j8 = 0;
        }
        taskQueue.schedule(task, j8);
    }

    public final void cancelAll() {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this.taskRunner) {
            if (cancelAllAndDecide$okhttp()) {
                getTaskRunner$okhttp().kickCoordinator$okhttp(this);
            }
            Unit unit = Unit.f50853a;
        }
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null) {
            Intrinsics.c(task);
            if (task.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        boolean z7 = false;
        int size = this.futureTasks.size() - 1;
        if (size >= 0) {
            while (true) {
                int i8 = size - 1;
                if (this.futureTasks.get(size).getCancelable()) {
                    Task task2 = this.futureTasks.get(size);
                    if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                        TaskLoggerKt.access$log(task2, this, "canceled");
                    }
                    this.futureTasks.remove(size);
                    z7 = true;
                }
                if (i8 < 0) {
                    break;
                }
                size = i8;
            }
        }
        return z7;
    }

    public final void execute(String name, long j8, boolean z7, Function0<Unit> block) {
        Intrinsics.f(name, "name");
        Intrinsics.f(block, "block");
        schedule(new TaskQueue$execute$1(name, z7, block), j8);
    }

    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    public final String getName$okhttp() {
        return this.name;
    }

    public final List<Task> getScheduledTasks() {
        List<Task> H0;
        synchronized (this.taskRunner) {
            H0 = CollectionsKt___CollectionsKt.H0(getFutureTasks$okhttp());
        }
        return H0;
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    public final CountDownLatch idleLatch() {
        synchronized (this.taskRunner) {
            if (getActiveTask$okhttp() == null && getFutureTasks$okhttp().isEmpty()) {
                return new CountDownLatch(0);
            }
            Task activeTask$okhttp = getActiveTask$okhttp();
            if (activeTask$okhttp instanceof AwaitIdleTask) {
                return ((AwaitIdleTask) activeTask$okhttp).getLatch();
            }
            for (Task task : getFutureTasks$okhttp()) {
                if (task instanceof AwaitIdleTask) {
                    return ((AwaitIdleTask) task).getLatch();
                }
            }
            AwaitIdleTask awaitIdleTask = new AwaitIdleTask();
            if (scheduleAndDecide$okhttp(awaitIdleTask, 0L, false)) {
                getTaskRunner$okhttp().kickCoordinator$okhttp(this);
            }
            return awaitIdleTask.getLatch();
        }
    }

    public final void schedule(Task task, long j8) {
        Intrinsics.f(task, "task");
        synchronized (this.taskRunner) {
            if (getShutdown$okhttp()) {
                if (task.getCancelable()) {
                    if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                        TaskLoggerKt.access$log(task, this, "schedule canceled (queue is shutdown)");
                    }
                    return;
                }
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
            if (scheduleAndDecide$okhttp(task, j8, false)) {
                getTaskRunner$okhttp().kickCoordinator$okhttp(this);
            }
            Unit unit = Unit.f50853a;
        }
    }

    public final boolean scheduleAndDecide$okhttp(Task task, long j8, boolean z7) {
        boolean z8;
        String n8;
        Intrinsics.f(task, "task");
        task.initQueue$okhttp(this);
        long nanoTime = this.taskRunner.getBackend().nanoTime();
        long j9 = nanoTime + j8;
        int indexOf = this.futureTasks.indexOf(task);
        if (indexOf != -1) {
            if (task.getNextExecuteNanoTime$okhttp() <= j9) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log(task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(indexOf);
        }
        task.setNextExecuteNanoTime$okhttp(j9);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            if (z7) {
                n8 = Intrinsics.n("run again after ", TaskLoggerKt.formatDuration(j9 - nanoTime));
            } else {
                n8 = Intrinsics.n("scheduled after ", TaskLoggerKt.formatDuration(j9 - nanoTime));
            }
            TaskLoggerKt.access$log(task, this, n8);
        }
        Iterator<Task> it = this.futureTasks.iterator();
        int i8 = 0;
        while (true) {
            if (it.hasNext()) {
                if (it.next().getNextExecuteNanoTime$okhttp() - nanoTime > j8) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z8) {
                    break;
                }
                i8++;
            } else {
                i8 = -1;
                break;
            }
        }
        if (i8 == -1) {
            i8 = this.futureTasks.size();
        }
        this.futureTasks.add(i8, task);
        if (i8 != 0) {
            return false;
        }
        return true;
    }

    public final void setActiveTask$okhttp(Task task) {
        this.activeTask = task;
    }

    public final void setCancelActiveTask$okhttp(boolean z7) {
        this.cancelActiveTask = z7;
    }

    public final void setShutdown$okhttp(boolean z7) {
        this.shutdown = z7;
    }

    public final void shutdown() {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this.taskRunner) {
            setShutdown$okhttp(true);
            if (cancelAllAndDecide$okhttp()) {
                getTaskRunner$okhttp().kickCoordinator$okhttp(this);
            }
            Unit unit = Unit.f50853a;
        }
    }

    public String toString() {
        return this.name;
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, String name, long j8, Function0 block, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            j8 = 0;
        }
        Intrinsics.f(name, "name");
        Intrinsics.f(block, "block");
        taskQueue.schedule(new TaskQueue$schedule$2(name, block), j8);
    }

    public final void schedule(String name, long j8, Function0<Long> block) {
        Intrinsics.f(name, "name");
        Intrinsics.f(block, "block");
        schedule(new TaskQueue$schedule$2(name, block), j8);
    }
}
