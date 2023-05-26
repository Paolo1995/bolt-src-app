package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* compiled from: FlowCoroutine.kt */
/* loaded from: classes5.dex */
public final class FlowCoroutineKt {
    public static final <R> Object a(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        Object d8;
        FlowCoroutine flowCoroutine = new FlowCoroutine(continuation.getContext(), continuation);
        Object d9 = UndispatchedKt.d(flowCoroutine, flowCoroutine, function2);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (d9 == d8) {
            DebugProbesKt.c(continuation);
        }
        return d9;
    }

    public static final <R> Flow<R> b(final Function3<? super CoroutineScope, ? super FlowCollector<? super R>, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new Flow<R>() { // from class: kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
                Object d8;
                Object a8 = FlowCoroutineKt.a(new FlowCoroutineKt$scopedFlow$1$1(Function3.this, flowCollector, null), continuation);
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                if (a8 == d8) {
                    return a8;
                }
                return Unit.f50853a;
            }
        };
    }
}
