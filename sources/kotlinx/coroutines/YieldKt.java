package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

/* compiled from: Yield.kt */
/* loaded from: classes5.dex */
public final class YieldKt {
    public static final Object a(Continuation<? super Unit> continuation) {
        Continuation c8;
        DispatchedContinuation dispatchedContinuation;
        Object obj;
        Object d8;
        Object d9;
        CoroutineContext context = continuation.getContext();
        JobKt.i(context);
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        if (c8 instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) c8;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation == null) {
            obj = Unit.f50853a;
        } else {
            if (dispatchedContinuation.f51783i.K0(context)) {
                dispatchedContinuation.k(context, Unit.f50853a);
            } else {
                YieldContext yieldContext = new YieldContext();
                CoroutineContext s02 = context.s0(yieldContext);
                Unit unit = Unit.f50853a;
                dispatchedContinuation.k(s02, unit);
                if (yieldContext.f51349g) {
                    if (DispatchedContinuationKt.d(dispatchedContinuation)) {
                        obj = IntrinsicsKt__IntrinsicsKt.d();
                    } else {
                        obj = unit;
                    }
                }
            }
            obj = IntrinsicsKt__IntrinsicsKt.d();
        }
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (obj == d8) {
            DebugProbesKt.c(continuation);
        }
        d9 = IntrinsicsKt__IntrinsicsKt.d();
        if (obj == d9) {
            return obj;
        }
        return Unit.f50853a;
    }
}
