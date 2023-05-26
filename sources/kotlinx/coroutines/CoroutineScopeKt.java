package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* compiled from: CoroutineScope.kt */
/* loaded from: classes5.dex */
public final class CoroutineScopeKt {
    public static final CoroutineScope a(CoroutineContext coroutineContext) {
        if (coroutineContext.g(Job.f51296d) == null) {
            coroutineContext = coroutineContext.s0(JobKt.b(null, 1, null));
        }
        return new ContextScope(coroutineContext);
    }

    public static final void b(CoroutineScope coroutineScope, String str, Throwable th) {
        c(coroutineScope, ExceptionsKt.a(str, th));
    }

    public static final void c(CoroutineScope coroutineScope, CancellationException cancellationException) {
        Job job = (Job) coroutineScope.j().g(Job.f51296d);
        if (job != null) {
            job.e(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + coroutineScope).toString());
    }

    public static /* synthetic */ void d(CoroutineScope coroutineScope, CancellationException cancellationException, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            cancellationException = null;
        }
        c(coroutineScope, cancellationException);
    }

    public static final <R> Object e(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        ScopeCoroutine scopeCoroutine = new ScopeCoroutine(continuation.getContext(), continuation);
        Object d8 = UndispatchedKt.d(scopeCoroutine, scopeCoroutine, function2);
        if (d8 == IntrinsicsKt.d()) {
            DebugProbesKt.c(continuation);
        }
        return d8;
    }

    public static final boolean f(CoroutineScope coroutineScope) {
        Job job = (Job) coroutineScope.j().g(Job.f51296d);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }

    public static final CoroutineScope g(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        return new ContextScope(coroutineScope.j().s0(coroutineContext));
    }
}
