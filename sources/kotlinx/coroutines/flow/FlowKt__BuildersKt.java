package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.kt */
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__BuildersKt {
    public static final <T> Flow<T> a(Iterable<? extends T> iterable) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3(iterable);
    }

    public static final <T> Flow<T> b(Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new CallbackFlowBuilder(function2, null, 0, null, 14, null);
    }

    public static final <T> Flow<T> c() {
        return EmptyFlow.f51448f;
    }

    public static final <T> Flow<T> d(Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new SafeFlow(function2);
    }

    public static final <T> Flow<T> e(final T t7) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2
            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
                Object d8;
                Object b8 = flowCollector.b((Object) t7, continuation);
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                if (b8 == d8) {
                    return b8;
                }
                return Unit.f50853a;
            }
        };
    }
}
