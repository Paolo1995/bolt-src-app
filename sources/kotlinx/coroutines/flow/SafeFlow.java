package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.kt */
/* loaded from: classes5.dex */
public final class SafeFlow<T> extends AbstractFlow<T> {

    /* renamed from: f  reason: collision with root package name */
    private final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> f51617f;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeFlow(Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.f51617f = function2;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    public Object c(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object d8;
        Object s7 = this.f51617f.s(flowCollector, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (s7 == d8) {
            return s7;
        }
        return Unit.f50853a;
    }
}
