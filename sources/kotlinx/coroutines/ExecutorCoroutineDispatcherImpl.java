package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ConcurrentKt;

/* compiled from: Executors.kt */
/* loaded from: classes5.dex */
public final class ExecutorCoroutineDispatcherImpl extends ExecutorCoroutineDispatcher implements Delay {

    /* renamed from: i  reason: collision with root package name */
    private final Executor f51285i;

    public ExecutorCoroutineDispatcherImpl(Executor executor) {
        this.f51285i = executor;
        ConcurrentKt.a(S0());
    }

    private final void R0(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        JobKt.c(coroutineContext, ExceptionsKt.a("The task was rejected", rejectedExecutionException));
    }

    private final ScheduledFuture<?> U0(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j8) {
        try {
            return scheduledExecutorService.schedule(runnable, j8, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e8) {
            R0(coroutineContext, e8);
            return null;
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void G0(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnable2;
        try {
            Executor S0 = S0();
            AbstractTimeSource a8 = AbstractTimeSourceKt.a();
            if (a8 == null || (runnable2 = a8.h(runnable)) == null) {
                runnable2 = runnable;
            }
            S0.execute(runnable2);
        } catch (RejectedExecutionException e8) {
            AbstractTimeSource a9 = AbstractTimeSourceKt.a();
            if (a9 != null) {
                a9.e();
            }
            R0(coroutineContext, e8);
            Dispatchers.b().G0(coroutineContext, runnable);
        }
    }

    public Executor S0() {
        return this.f51285i;
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle Y(long j8, Runnable runnable, CoroutineContext coroutineContext) {
        ScheduledExecutorService scheduledExecutorService;
        Executor S0 = S0();
        ScheduledFuture<?> scheduledFuture = null;
        if (S0 instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) S0;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            scheduledFuture = U0(scheduledExecutorService, runnable, coroutineContext, j8);
        }
        if (scheduledFuture != null) {
            return new DisposableFutureHandle(scheduledFuture);
        }
        return DefaultExecutor.f51254m.Y(j8, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ExecutorService executorService;
        Executor S0 = S0();
        if (S0 instanceof ExecutorService) {
            executorService = (ExecutorService) S0;
        } else {
            executorService = null;
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ExecutorCoroutineDispatcherImpl) && ((ExecutorCoroutineDispatcherImpl) obj).S0() == S0()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(S0());
    }

    @Override // kotlinx.coroutines.Delay
    public void j(long j8, CancellableContinuation<? super Unit> cancellableContinuation) {
        ScheduledExecutorService scheduledExecutorService;
        Executor S0 = S0();
        ScheduledFuture<?> scheduledFuture = null;
        if (S0 instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) S0;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            scheduledFuture = U0(scheduledExecutorService, new ResumeUndispatchedRunnable(this, cancellableContinuation), cancellableContinuation.getContext(), j8);
        }
        if (scheduledFuture != null) {
            JobKt.g(cancellableContinuation, scheduledFuture);
        } else {
            DefaultExecutor.f51254m.j(j8, cancellableContinuation);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return S0().toString();
    }
}
