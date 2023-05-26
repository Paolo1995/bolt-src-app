package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* compiled from: Delay.kt */
/* loaded from: classes5.dex */
public final class DelayKt {
    public static final Object a(long j8, Continuation<? super Unit> continuation) {
        Continuation c8;
        Object d8;
        Object d9;
        if (j8 <= 0) {
            return Unit.f50853a;
        }
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c8, 1);
        cancellableContinuationImpl.y();
        if (j8 < Long.MAX_VALUE) {
            b(cancellableContinuationImpl.getContext()).j(j8, cancellableContinuationImpl);
        }
        Object v7 = cancellableContinuationImpl.v();
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (v7 == d8) {
            DebugProbesKt.c(continuation);
        }
        d9 = IntrinsicsKt__IntrinsicsKt.d();
        if (v7 == d9) {
            return v7;
        }
        return Unit.f50853a;
    }

    public static final Delay b(CoroutineContext coroutineContext) {
        Delay delay;
        CoroutineContext.Element g8 = coroutineContext.g(ContinuationInterceptor.f50909b);
        if (g8 instanceof Delay) {
            delay = (Delay) g8;
        } else {
            delay = null;
        }
        if (delay == null) {
            return DefaultExecutorKt.a();
        }
        return delay;
    }
}
