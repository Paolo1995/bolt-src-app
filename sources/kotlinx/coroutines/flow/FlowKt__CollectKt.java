package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.flow.internal.NopCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collect.kt */
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__CollectKt {
    public static final Object a(Flow<?> flow, Continuation<? super Unit> continuation) {
        Object d8;
        Object a8 = flow.a(NopCollector.f51748f, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }

    public static final <T> Object b(FlowCollector<? super T> flowCollector, Flow<? extends T> flow, Continuation<? super Unit> continuation) {
        Object d8;
        FlowKt.n(flowCollector);
        Object a8 = flow.a(flowCollector, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }
}
