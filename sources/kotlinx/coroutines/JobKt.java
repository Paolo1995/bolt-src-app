package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes5.dex */
public final class JobKt {
    public static final CompletableJob a(Job job) {
        return JobKt__JobKt.a(job);
    }

    public static /* synthetic */ CompletableJob b(Job job, int i8, Object obj) {
        return JobKt__JobKt.b(job, i8, obj);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        JobKt__JobKt.c(coroutineContext, cancellationException);
    }

    public static final void d(Job job, String str, Throwable th) {
        JobKt__JobKt.d(job, str, th);
    }

    public static final void f(CoroutineContext coroutineContext, CancellationException cancellationException) {
        JobKt__JobKt.f(coroutineContext, cancellationException);
    }

    public static final void g(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        JobKt__FutureKt.a(cancellableContinuation, future);
    }

    public static final DisposableHandle h(Job job, DisposableHandle disposableHandle) {
        return JobKt__JobKt.g(job, disposableHandle);
    }

    public static final void i(CoroutineContext coroutineContext) {
        JobKt__JobKt.h(coroutineContext);
    }

    public static final void j(Job job) {
        JobKt__JobKt.i(job);
    }

    public static final Job k(CoroutineContext coroutineContext) {
        return JobKt__JobKt.j(coroutineContext);
    }

    public static final boolean l(CoroutineContext coroutineContext) {
        return JobKt__JobKt.k(coroutineContext);
    }
}
