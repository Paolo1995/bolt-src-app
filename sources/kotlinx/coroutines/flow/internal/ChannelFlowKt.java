package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes5.dex */
public final class ChannelFlowKt {
    public static final <T, V> Object b(CoroutineContext coroutineContext, V v7, Object obj, Function2<? super V, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        Object d8;
        Object c8 = ThreadContextKt.c(coroutineContext, obj);
        try {
            Object s7 = ((Function2) TypeIntrinsics.e(function2, 2)).s(v7, new StackFrameContinuation(continuation, coroutineContext));
            ThreadContextKt.a(coroutineContext, c8);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            if (s7 == d8) {
                DebugProbesKt.c(continuation);
            }
            return s7;
        } catch (Throwable th) {
            ThreadContextKt.a(coroutineContext, c8);
            throw th;
        }
    }

    public static /* synthetic */ Object c(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, Continuation continuation, int i8, Object obj3) {
        if ((i8 & 4) != 0) {
            obj2 = ThreadContextKt.b(coroutineContext);
        }
        return b(coroutineContext, obj, obj2, function2, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> FlowCollector<T> d(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        boolean z7;
        if (flowCollector instanceof SendingCollector) {
            z7 = true;
        } else {
            z7 = flowCollector instanceof NopCollector;
        }
        if (!z7) {
            return new UndispatchedContextCollector(flowCollector, coroutineContext);
        }
        return flowCollector;
    }
}
