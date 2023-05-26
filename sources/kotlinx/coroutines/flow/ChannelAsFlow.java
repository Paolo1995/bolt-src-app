package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Channels.kt */
/* loaded from: classes5.dex */
public final class ChannelAsFlow<T> extends ChannelFlow<T> {

    /* renamed from: k  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f51435k = AtomicIntegerFieldUpdater.newUpdater(ChannelAsFlow.class, "consumed");
    private volatile /* synthetic */ int consumed;

    /* renamed from: i  reason: collision with root package name */
    private final ReceiveChannel<T> f51436i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f51437j;

    public /* synthetic */ ChannelAsFlow(ReceiveChannel receiveChannel, boolean z7, CoroutineContext coroutineContext, int i8, BufferOverflow bufferOverflow, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(receiveChannel, z7, (i9 & 4) != 0 ? EmptyCoroutineContext.f50912f : coroutineContext, (i9 & 8) != 0 ? -3 : i8, (i9 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    private final void l() {
        if (this.f51437j) {
            boolean z7 = true;
            if (f51435k.getAndSet(this, 1) != 0) {
                z7 = false;
            }
            if (!z7) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object d8;
        Object c8;
        Object d9;
        if (this.f51668g == -3) {
            l();
            c8 = FlowKt__ChannelsKt.c(flowCollector, this.f51436i, this.f51437j, continuation);
            d9 = IntrinsicsKt__IntrinsicsKt.d();
            if (c8 == d9) {
                return c8;
            }
            return Unit.f50853a;
        }
        Object a8 = super.a(flowCollector, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected String c() {
        return "channel=" + this.f51436i;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected Object h(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        Object c8;
        Object d8;
        c8 = FlowKt__ChannelsKt.c(new SendingCollector(producerScope), this.f51436i, this.f51437j, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (c8 == d8) {
            return c8;
        }
        return Unit.f50853a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ReceiveChannel<T> k(CoroutineScope coroutineScope) {
        l();
        if (this.f51668g == -3) {
            return this.f51436i;
        }
        return super.k(coroutineScope);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelAsFlow(ReceiveChannel<? extends T> receiveChannel, boolean z7, CoroutineContext coroutineContext, int i8, BufferOverflow bufferOverflow) {
        super(coroutineContext, i8, bufferOverflow);
        this.f51436i = receiveChannel;
        this.f51437j = z7;
        this.consumed = 0;
    }
}
