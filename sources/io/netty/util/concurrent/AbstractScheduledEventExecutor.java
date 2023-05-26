package io.netty.util.concurrent;

import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PriorityQueue;
import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public abstract class AbstractScheduledEventExecutor extends AbstractEventExecutor {
    private static final Comparator<ScheduledFutureTask<?>> SCHEDULED_FUTURE_TASK_COMPARATOR = new Comparator<ScheduledFutureTask<?>>() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.1
        @Override // java.util.Comparator
        public int compare(ScheduledFutureTask<?> scheduledFutureTask, ScheduledFutureTask<?> scheduledFutureTask2) {
            return scheduledFutureTask.compareTo((Delayed) scheduledFutureTask2);
        }
    };
    static final Runnable WAKEUP_TASK = new Runnable() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.2
        @Override // java.lang.Runnable
        public void run() {
        }
    };
    long nextTaskId;
    PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractScheduledEventExecutor() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long deadlineToDelayNanos(long j8) {
        return ScheduledFutureTask.deadlineToDelayNanos(j8);
    }

    private static boolean isNullOrEmpty(Queue<ScheduledFutureTask<?>> queue) {
        if (queue != null && !queue.isEmpty()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long nanoTime() {
        return ScheduledFutureTask.nanoTime();
    }

    private void validateScheduled0(long j8, TimeUnit timeUnit) {
        validateScheduled(j8, timeUnit);
    }

    protected boolean afterScheduledTaskSubmitted(long j8) {
        return true;
    }

    protected boolean beforeScheduledTaskSubmitted(long j8) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cancelScheduledTasks() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        if (isNullOrEmpty(priorityQueue)) {
            return;
        }
        for (ScheduledFutureTask scheduledFutureTask : (ScheduledFutureTask[]) priorityQueue.toArray(new ScheduledFutureTask[0])) {
            scheduledFutureTask.cancelWithoutRemove(false);
        }
        priorityQueue.clearIgnoringIndexes();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long nextScheduledTaskDeadlineNanos() {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        if (peekScheduledTask != null) {
            return peekScheduledTask.deadlineNanos();
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long nextScheduledTaskNano() {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        if (peekScheduledTask != null) {
            return peekScheduledTask.delayNanos();
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ScheduledFutureTask<?> peekScheduledTask() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        if (priorityQueue != null) {
            return priorityQueue.peek();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Runnable pollScheduledTask(long j8) {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        if (peekScheduledTask != null && peekScheduledTask.deadlineNanos() - j8 <= 0) {
            this.scheduledTaskQueue.remove();
            peekScheduledTask.setConsumed();
            return peekScheduledTask;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void removeScheduled(ScheduledFutureTask<?> scheduledFutureTask) {
        if (inEventLoop()) {
            scheduledTaskQueue().removeTyped(scheduledFutureTask);
        } else {
            lazyExecute(scheduledFutureTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void scheduleFromEventLoop(ScheduledFutureTask<?> scheduledFutureTask) {
        PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue = scheduledTaskQueue();
        long j8 = this.nextTaskId + 1;
        this.nextTaskId = j8;
        scheduledTaskQueue.add(scheduledFutureTask.setId(j8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue() {
        if (this.scheduledTaskQueue == null) {
            this.scheduledTaskQueue = new DefaultPriorityQueue(SCHEDULED_FUTURE_TASK_COMPARATOR, 11);
        }
        return this.scheduledTaskQueue;
    }

    @Deprecated
    protected void validateScheduled(long j8, TimeUnit timeUnit) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractScheduledEventExecutor(EventExecutorGroup eventExecutorGroup) {
        super(eventExecutorGroup);
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j8, long j9, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j8 >= 0) {
            if (j9 > 0) {
                validateScheduled0(j8, timeUnit);
                validateScheduled0(j9, timeUnit);
                return schedule(new ScheduledFutureTask(this, runnable, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j8)), timeUnit.toNanos(j9)));
            }
            throw new IllegalArgumentException(String.format("period: %d (expected: > 0)", Long.valueOf(j9)));
        }
        throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(j8)));
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j8, long j9, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j8 >= 0) {
            if (j9 > 0) {
                validateScheduled0(j8, timeUnit);
                validateScheduled0(j9, timeUnit);
                return schedule(new ScheduledFutureTask(this, runnable, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j8)), -timeUnit.toNanos(j9)));
            }
            throw new IllegalArgumentException(String.format("delay: %d (expected: > 0)", Long.valueOf(j9)));
        }
        throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(j8)));
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j8, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j8 < 0) {
            j8 = 0;
        }
        validateScheduled0(j8, timeUnit);
        return schedule(new ScheduledFutureTask(this, runnable, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j8))));
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j8, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(callable, "callable");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j8 < 0) {
            j8 = 0;
        }
        validateScheduled0(j8, timeUnit);
        return schedule(new ScheduledFutureTask<>(this, callable, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j8))));
    }

    private <V> ScheduledFuture<V> schedule(ScheduledFutureTask<V> scheduledFutureTask) {
        if (inEventLoop()) {
            scheduleFromEventLoop(scheduledFutureTask);
        } else {
            long deadlineNanos = scheduledFutureTask.deadlineNanos();
            if (beforeScheduledTaskSubmitted(deadlineNanos)) {
                execute(scheduledFutureTask);
            } else {
                lazyExecute(scheduledFutureTask);
                if (afterScheduledTaskSubmitted(deadlineNanos)) {
                    execute(WAKEUP_TASK);
                }
            }
        }
        return scheduledFutureTask;
    }
}
