package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* compiled from: Delay.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f51495g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f51496h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Ref$ObjectRef<Object> f51497i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ ReceiveChannel<Unit> f51498j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$1$1(Ref$ObjectRef<Object> ref$ObjectRef, ReceiveChannel<Unit> receiveChannel, Continuation<? super FlowKt__DelayKt$sample$2$1$1> continuation) {
        super(2, continuation);
        this.f51497i = ref$ObjectRef;
        this.f51498j = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt__DelayKt$sample$2$1$1 flowKt__DelayKt$sample$2$1$1 = new FlowKt__DelayKt$sample$2$1$1(this.f51497i, this.f51498j, continuation);
        flowKt__DelayKt$sample$2$1$1.f51496h = obj;
        return flowKt__DelayKt$sample$2$1$1;
    }

    public final Object h(Object obj, Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$sample$2$1$1) create(ChannelResult.b(obj), continuation)).invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [kotlinx.coroutines.internal.Symbol, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f51495g == 0) {
            ResultKt.b(obj);
            ?? l8 = ((ChannelResult) this.f51496h).l();
            Ref$ObjectRef<Object> ref$ObjectRef = this.f51497i;
            boolean z7 = l8 instanceof ChannelResult.Failed;
            if (!z7) {
                ref$ObjectRef.f51016f = l8;
            }
            ReceiveChannel<Unit> receiveChannel = this.f51498j;
            if (z7) {
                Throwable e8 = ChannelResult.e(l8);
                if (e8 == null) {
                    receiveChannel.e(new ChildCancelledException());
                    ref$ObjectRef.f51016f = NullSurrogateKt.f51751c;
                } else {
                    throw e8;
                }
            }
            return Unit.f50853a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object s(ChannelResult<? extends Object> channelResult, Continuation<? super Unit> continuation) {
        return h(channelResult.l(), continuation);
    }
}
