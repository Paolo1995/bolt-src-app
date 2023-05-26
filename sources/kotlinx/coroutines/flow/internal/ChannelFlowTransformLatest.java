package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: Merge.kt */
/* loaded from: classes5.dex */
public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {

    /* renamed from: j  reason: collision with root package name */
    private final Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> f51696j;

    public /* synthetic */ ChannelFlowTransformLatest(Function3 function3, Flow flow, CoroutineContext coroutineContext, int i8, BufferOverflow bufferOverflow, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(function3, flow, (i9 & 4) != 0 ? EmptyCoroutineContext.f50912f : coroutineContext, (i9 & 8) != 0 ? -2 : i8, (i9 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    public Object o(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        Object d8;
        Object e8 = CoroutineScopeKt.e(new ChannelFlowTransformLatest$flowCollect$3(this, flowCollector, null), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (e8 == d8) {
            return e8;
        }
        return Unit.f50853a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest(Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, Flow<? extends T> flow, CoroutineContext coroutineContext, int i8, BufferOverflow bufferOverflow) {
        super(flow, coroutineContext, i8, bufferOverflow);
        this.f51696j = function3;
    }
}
