package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.kt */
/* loaded from: classes5.dex */
public class ChannelFlowBuilder<T> extends ChannelFlow<T> {

    /* renamed from: i  reason: collision with root package name */
    private final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> f51438i;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowBuilder(Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2, CoroutineContext coroutineContext, int i8, BufferOverflow bufferOverflow) {
        super(coroutineContext, i8, bufferOverflow);
        this.f51438i = function2;
    }

    static /* synthetic */ Object l(ChannelFlowBuilder channelFlowBuilder, ProducerScope producerScope, Continuation continuation) {
        Object d8;
        Object s7 = channelFlowBuilder.f51438i.s(producerScope, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (s7 == d8) {
            return s7;
        }
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object h(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return l(this, producerScope, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return "block[" + this.f51438i + "] -> " + super.toString();
    }
}
