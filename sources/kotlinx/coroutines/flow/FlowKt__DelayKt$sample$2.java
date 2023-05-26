package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectBuilderImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Delay.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", l = {352}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class FlowKt__DelayKt$sample$2<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f51488g;

    /* renamed from: h  reason: collision with root package name */
    Object f51489h;

    /* renamed from: i  reason: collision with root package name */
    int f51490i;

    /* renamed from: j  reason: collision with root package name */
    private /* synthetic */ Object f51491j;

    /* renamed from: k  reason: collision with root package name */
    /* synthetic */ Object f51492k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ long f51493l;

    /* renamed from: m  reason: collision with root package name */
    final /* synthetic */ Flow<T> f51494m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$sample$2(long j8, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$sample$2> continuation) {
        super(3, continuation);
        this.f51493l = j8;
        this.f51494m = flow;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2 = new FlowKt__DelayKt$sample$2(this.f51493l, this.f51494m, continuation);
        flowKt__DelayKt$sample$2.f51491j = coroutineScope;
        flowKt__DelayKt$sample$2.f51492k = flowCollector;
        return flowKt__DelayKt$sample$2.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        ReceiveChannel d9;
        FlowCollector flowCollector;
        ReceiveChannel receiveChannel;
        Ref$ObjectRef ref$ObjectRef;
        ReceiveChannel receiveChannel2;
        Object d10;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f51490i;
        if (i8 != 0) {
            if (i8 == 1) {
                receiveChannel2 = (ReceiveChannel) this.f51489h;
                ref$ObjectRef = (Ref$ObjectRef) this.f51488g;
                receiveChannel = (ReceiveChannel) this.f51492k;
                flowCollector = (FlowCollector) this.f51491j;
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f51491j;
            ReceiveChannel d11 = ProduceKt.d(coroutineScope, null, -1, new FlowKt__DelayKt$sample$2$values$1(this.f51494m, null), 1, null);
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            d9 = FlowKt__DelayKt.d(coroutineScope, this.f51493l, 0L, 2, null);
            flowCollector = (FlowCollector) this.f51492k;
            receiveChannel = d11;
            ref$ObjectRef = ref$ObjectRef2;
            receiveChannel2 = d9;
        }
        while (ref$ObjectRef.f51016f != NullSurrogateKt.f51751c) {
            this.f51491j = flowCollector;
            this.f51492k = receiveChannel;
            this.f51488g = ref$ObjectRef;
            this.f51489h = receiveChannel2;
            this.f51490i = 1;
            SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(this);
            try {
                selectBuilderImpl.x(receiveChannel.x(), new FlowKt__DelayKt$sample$2$1$1(ref$ObjectRef, receiveChannel2, null));
                selectBuilderImpl.x(receiveChannel2.v(), new FlowKt__DelayKt$sample$2$1$2(ref$ObjectRef, flowCollector, null));
            } catch (Throwable th) {
                selectBuilderImpl.b0(th);
            }
            Object a02 = selectBuilderImpl.a0();
            d10 = IntrinsicsKt__IntrinsicsKt.d();
            if (a02 == d10) {
                DebugProbesKt.c(this);
                continue;
            }
            if (a02 == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
