package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes5.dex */
public abstract class ChannelFlow<T> implements Flow {

    /* renamed from: f  reason: collision with root package name */
    public final CoroutineContext f51667f;

    /* renamed from: g  reason: collision with root package name */
    public final int f51668g;

    /* renamed from: h  reason: collision with root package name */
    public final BufferOverflow f51669h;

    public ChannelFlow(CoroutineContext coroutineContext, int i8, BufferOverflow bufferOverflow) {
        this.f51667f = coroutineContext;
        this.f51668g = i8;
        this.f51669h = bufferOverflow;
    }

    static /* synthetic */ Object f(ChannelFlow channelFlow, FlowCollector flowCollector, Continuation continuation) {
        Object d8;
        Object e8 = CoroutineScopeKt.e(new ChannelFlow$collect$2(flowCollector, channelFlow, null), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (e8 == d8) {
            return e8;
        }
        return Unit.f50853a;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return f(this, flowCollector, continuation);
    }

    protected String c() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object h(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation);

    public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> i() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    public final int j() {
        int i8 = this.f51668g;
        if (i8 == -3) {
            return -2;
        }
        return i8;
    }

    public ReceiveChannel<T> k(CoroutineScope coroutineScope) {
        return ProduceKt.e(coroutineScope, this.f51667f, j(), this.f51669h, CoroutineStart.ATOMIC, null, i(), 16, null);
    }

    public String toString() {
        String f02;
        ArrayList arrayList = new ArrayList(4);
        String c8 = c();
        if (c8 != null) {
            arrayList.add(c8);
        }
        if (this.f51667f != EmptyCoroutineContext.f50912f) {
            arrayList.add("context=" + this.f51667f);
        }
        if (this.f51668g != -3) {
            arrayList.add("capacity=" + this.f51668g);
        }
        if (this.f51669h != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f51669h);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(DebugStringsKt.a(this));
        sb.append('[');
        f02 = CollectionsKt___CollectionsKt.f0(arrayList, ", ", null, null, 0, null, null, 62, null);
        sb.append(f02);
        sb.append(']');
        return sb.toString();
    }
}
