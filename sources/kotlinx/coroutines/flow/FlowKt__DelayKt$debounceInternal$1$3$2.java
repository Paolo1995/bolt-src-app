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
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* compiled from: Delay.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", l = {243}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f51472g;

    /* renamed from: h  reason: collision with root package name */
    int f51473h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f51474i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Ref$ObjectRef<Object> f51475j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ FlowCollector<T> f51476k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1$3$2(Ref$ObjectRef<Object> ref$ObjectRef, FlowCollector<? super T> flowCollector, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$2> continuation) {
        super(2, continuation);
        this.f51475j = ref$ObjectRef;
        this.f51476k = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.f51475j, this.f51476k, continuation);
        flowKt__DelayKt$debounceInternal$1$3$2.f51474i = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    public final Object h(Object obj, Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(ChannelResult.b(obj), continuation)).invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6, types: [kotlinx.coroutines.internal.Symbol, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Ref$ObjectRef<Object> ref$ObjectRef;
        Ref$ObjectRef<Object> ref$ObjectRef2;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f51473h;
        if (i8 != 0) {
            if (i8 == 1) {
                ref$ObjectRef2 = (Ref$ObjectRef) this.f51472g;
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            ?? l8 = ((ChannelResult) this.f51474i).l();
            ref$ObjectRef = this.f51475j;
            boolean z7 = l8 instanceof ChannelResult.Failed;
            if (!z7) {
                ref$ObjectRef.f51016f = l8;
            }
            FlowCollector<T> flowCollector = this.f51476k;
            if (z7) {
                Throwable e8 = ChannelResult.e(l8);
                if (e8 == null) {
                    Object obj2 = ref$ObjectRef.f51016f;
                    if (obj2 != null) {
                        if (obj2 == NullSurrogateKt.f51749a) {
                            obj2 = null;
                        }
                        this.f51474i = l8;
                        this.f51472g = ref$ObjectRef;
                        this.f51473h = 1;
                        if (flowCollector.b(obj2, this) == d8) {
                            return d8;
                        }
                        ref$ObjectRef2 = ref$ObjectRef;
                    }
                    ref$ObjectRef.f51016f = NullSurrogateKt.f51751c;
                } else {
                    throw e8;
                }
            }
            return Unit.f50853a;
        }
        ref$ObjectRef = ref$ObjectRef2;
        ref$ObjectRef.f51016f = NullSurrogateKt.f51751c;
        return Unit.f50853a;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object s(ChannelResult<? extends Object> channelResult, Continuation<? super Unit> continuation) {
        return h(channelResult.l(), continuation);
    }
}
