package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes5.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {

    /* renamed from: i  reason: collision with root package name */
    protected final Flow<S> f51692i;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(Flow<? extends S> flow, CoroutineContext coroutineContext, int i8, BufferOverflow bufferOverflow) {
        super(coroutineContext, i8, bufferOverflow);
        this.f51692i = flow;
    }

    static /* synthetic */ Object l(ChannelFlowOperator channelFlowOperator, FlowCollector flowCollector, Continuation continuation) {
        Object d8;
        Object d9;
        Object d10;
        if (channelFlowOperator.f51668g == -3) {
            CoroutineContext context = continuation.getContext();
            CoroutineContext s02 = context.s0(channelFlowOperator.f51667f);
            if (Intrinsics.a(s02, context)) {
                Object o8 = channelFlowOperator.o(flowCollector, continuation);
                d10 = IntrinsicsKt__IntrinsicsKt.d();
                if (o8 == d10) {
                    return o8;
                }
                return Unit.f50853a;
            }
            ContinuationInterceptor.Key key = ContinuationInterceptor.f50909b;
            if (Intrinsics.a(s02.g(key), context.g(key))) {
                Object n8 = channelFlowOperator.n(flowCollector, s02, continuation);
                d9 = IntrinsicsKt__IntrinsicsKt.d();
                if (n8 == d9) {
                    return n8;
                }
                return Unit.f50853a;
            }
        }
        Object a8 = super.a(flowCollector, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }

    static /* synthetic */ Object m(ChannelFlowOperator channelFlowOperator, ProducerScope producerScope, Continuation continuation) {
        Object d8;
        Object o8 = channelFlowOperator.o(new SendingCollector(producerScope), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (o8 == d8) {
            return o8;
        }
        return Unit.f50853a;
    }

    private final Object n(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
        Object d8;
        Object c8 = ChannelFlowKt.c(coroutineContext, ChannelFlowKt.a(flowCollector, continuation.getContext()), null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), continuation, 4, null);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (c8 == d8) {
            return c8;
        }
        return Unit.f50853a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return l(this, flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected Object h(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return m(this, producerScope, continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object o(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return this.f51692i + " -> " + super.toString();
    }
}
