package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;

/* compiled from: Merge.kt */
/* loaded from: classes5.dex */
public final class ChannelLimitedFlowMerge<T> extends ChannelFlow<T> {

    /* renamed from: i  reason: collision with root package name */
    private final Iterable<Flow<T>> f51715i;

    public /* synthetic */ ChannelLimitedFlowMerge(Iterable iterable, CoroutineContext coroutineContext, int i8, BufferOverflow bufferOverflow, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(iterable, (i9 & 2) != 0 ? EmptyCoroutineContext.f50912f : coroutineContext, (i9 & 4) != 0 ? -2 : i8, (i9 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object h(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        SendingCollector sendingCollector = new SendingCollector(producerScope);
        for (Flow<T> flow : this.f51715i) {
            BuildersKt__Builders_commonKt.d(producerScope, null, null, new ChannelLimitedFlowMerge$collectTo$2$1(flow, sendingCollector, null), 3, null);
        }
        return Unit.f50853a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ReceiveChannel<T> k(CoroutineScope coroutineScope) {
        return ProduceKt.b(coroutineScope, this.f51667f, this.f51668g, i());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelLimitedFlowMerge(Iterable<? extends Flow<? extends T>> iterable, CoroutineContext coroutineContext, int i8, BufferOverflow bufferOverflow) {
        super(coroutineContext, i8, bufferOverflow);
        this.f51715i = iterable;
    }
}
