package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.SemaphoreKt;

/* compiled from: Merge.kt */
/* loaded from: classes5.dex */
public final class ChannelFlowMerge<T> extends ChannelFlow<T> {

    /* renamed from: i  reason: collision with root package name */
    private final Flow<Flow<T>> f51677i;

    /* renamed from: j  reason: collision with root package name */
    private final int f51678j;

    public /* synthetic */ ChannelFlowMerge(Flow flow, int i8, CoroutineContext coroutineContext, int i9, BufferOverflow bufferOverflow, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(flow, i8, (i10 & 4) != 0 ? EmptyCoroutineContext.f50912f : coroutineContext, (i10 & 8) != 0 ? -2 : i9, (i10 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected String c() {
        return "concurrency=" + this.f51678j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object h(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        Object d8;
        Object a8 = this.f51677i.a(new ChannelFlowMerge$collectTo$2((Job) continuation.getContext().g(Job.f51296d), SemaphoreKt.b(this.f51678j, 0, 2, null), producerScope, new SendingCollector(producerScope)), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ReceiveChannel<T> k(CoroutineScope coroutineScope) {
        return ProduceKt.b(coroutineScope, this.f51667f, this.f51668g, i());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge(Flow<? extends Flow<? extends T>> flow, int i8, CoroutineContext coroutineContext, int i9, BufferOverflow bufferOverflow) {
        super(coroutineContext, i9, bufferOverflow);
        this.f51677i = flow;
        this.f51678j = i8;
    }
}
