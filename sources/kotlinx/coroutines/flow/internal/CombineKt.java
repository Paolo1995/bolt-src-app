package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: Combine.kt */
/* loaded from: classes5.dex */
public final class CombineKt {
    public static final <R, T> Object a(FlowCollector<? super R> flowCollector, Flow<? extends T>[] flowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object d8;
        Object a8 = FlowCoroutineKt.a(new CombineKt$combineInternal$2(flowArr, function0, function3, flowCollector, null), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }
}
