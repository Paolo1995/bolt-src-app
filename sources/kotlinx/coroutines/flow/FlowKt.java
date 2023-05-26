package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* loaded from: classes5.dex */
public final class FlowKt {
    public static final <T> Flow<T> A(T t7) {
        return FlowKt__BuildersKt.e(t7);
    }

    public static final <T, R> Flow<R> B(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__MergeKt.f(flow, function2);
    }

    public static final <T> Flow<T> C(Iterable<? extends Flow<? extends T>> iterable) {
        return FlowKt__MergeKt.g(iterable);
    }

    public static final <T> Flow<T> D(Flow<? extends T>... flowArr) {
        return FlowKt__MergeKt.h(flowArr);
    }

    public static final <T> Flow<T> E(Flow<? extends T> flow, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__EmittersKt.d(flow, function3);
    }

    public static final <T> Flow<T> F(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__TransformKt.b(flow, function2);
    }

    public static final <T> Flow<T> G(ReceiveChannel<? extends T> receiveChannel) {
        return FlowKt__ChannelsKt.d(receiveChannel);
    }

    public static final <T> Flow<T> H(Flow<? extends T> flow, long j8) {
        return FlowKt__DelayKt.e(flow, j8);
    }

    public static final <T, R> Flow<R> I(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__MergeKt.i(flow, function3);
    }

    public static final <T, R> Flow<R> J(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        return FlowKt__LimitKt.a(flow, function3);
    }

    public static final <T> Flow<T> a(Iterable<? extends T> iterable) {
        return FlowKt__BuildersKt.a(iterable);
    }

    public static final <T> SharedFlow<T> b(MutableSharedFlow<T> mutableSharedFlow) {
        return FlowKt__ShareKt.a(mutableSharedFlow);
    }

    public static final <T> StateFlow<T> c(MutableStateFlow<T> mutableStateFlow) {
        return FlowKt__ShareKt.b(mutableStateFlow);
    }

    public static final <T> Flow<T> d(Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__BuildersKt.b(function2);
    }

    public static final <T> Flow<T> e(Flow<? extends T> flow, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__ErrorsKt.a(flow, function3);
    }

    public static final <T> Object f(Flow<? extends T> flow, FlowCollector<? super T> flowCollector, Continuation<? super Throwable> continuation) {
        return FlowKt__ErrorsKt.b(flow, flowCollector, continuation);
    }

    public static final Object g(Flow<?> flow, Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.a(flow, continuation);
    }

    public static final <T1, T2, R> Flow<R> h(Flow<? extends T1> flow, Flow<? extends T2> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.b(flow, flow2, function3);
    }

    public static final <T> Flow<T> i(Flow<? extends T> flow, long j8) {
        return FlowKt__DelayKt.a(flow, j8);
    }

    public static final <T> Flow<T> j(Flow<? extends T> flow) {
        return FlowKt__DistinctKt.a(flow);
    }

    public static final <T> Object k(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, Continuation<? super Unit> continuation) {
        return FlowKt__ChannelsKt.b(flowCollector, receiveChannel, continuation);
    }

    public static final <T> Object l(FlowCollector<? super T> flowCollector, Flow<? extends T> flow, Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.b(flowCollector, flow, continuation);
    }

    public static final <T> Flow<T> m() {
        return FlowKt__BuildersKt.c();
    }

    public static final void n(FlowCollector<?> flowCollector) {
        FlowKt__EmittersKt.b(flowCollector);
    }

    public static final <T> Flow<T> o(Flow<? extends T> flow) {
        return FlowKt__TransformKt.a(flow);
    }

    public static final <T> Object p(Flow<? extends T> flow, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.a(flow, continuation);
    }

    public static final <T> Object q(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.b(flow, function2, continuation);
    }

    public static final ReceiveChannel<Unit> r(CoroutineScope coroutineScope, long j8, long j9) {
        return FlowKt__DelayKt.c(coroutineScope, j8, j9);
    }

    public static final <T, R> Flow<R> t(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MergeKt.a(flow, function2);
    }

    public static final <T, R> Flow<R> u(Flow<? extends T> flow, int i8, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MergeKt.b(flow, i8, function2);
    }

    public static final <T> Flow<T> w(Flow<? extends Flow<? extends T>> flow) {
        return FlowKt__MergeKt.d(flow);
    }

    public static final <T> Flow<T> x(Flow<? extends Flow<? extends T>> flow, int i8) {
        return FlowKt__MergeKt.e(flow, i8);
    }

    public static final <T> Flow<T> y(Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__BuildersKt.d(function2);
    }

    public static final <T1, T2, R> Flow<R> z(Flow<? extends T1> flow, Flow<? extends T2> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.c(flow, flow2, function3);
    }
}
