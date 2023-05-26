package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChannelFlow.kt */
/* loaded from: classes5.dex */
public final class UndispatchedContextCollector<T> implements FlowCollector<T> {

    /* renamed from: f  reason: collision with root package name */
    private final CoroutineContext f51764f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f51765g;

    /* renamed from: h  reason: collision with root package name */
    private final Function2<T, Continuation<? super Unit>, Object> f51766h;

    public UndispatchedContextCollector(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        this.f51764f = coroutineContext;
        this.f51765g = ThreadContextKt.b(coroutineContext);
        this.f51766h = new UndispatchedContextCollector$emitRef$1(flowCollector, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object b(T t7, Continuation<? super Unit> continuation) {
        Object d8;
        Object b8 = ChannelFlowKt.b(this.f51764f, t7, this.f51765g, this.f51766h, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (b8 == d8) {
            return b8;
        }
        return Unit.f50853a;
    }
}
