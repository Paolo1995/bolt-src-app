package kotlinx.coroutines.channels;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Channels.kt */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", l = {39}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChannelResult<? extends Unit>>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f51410g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f51411h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ SendChannel<E> f51412i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ E f51413j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__ChannelsKt$trySendBlocking$2(SendChannel<? super E> sendChannel, E e8, Continuation<? super ChannelsKt__ChannelsKt$trySendBlocking$2> continuation) {
        super(2, continuation);
        this.f51412i = sendChannel;
        this.f51413j = e8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 channelsKt__ChannelsKt$trySendBlocking$2 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.f51412i, this.f51413j, continuation);
        channelsKt__ChannelsKt$trySendBlocking$2.f51411h = obj;
        return channelsKt__ChannelsKt$trySendBlocking$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super ChannelResult<Unit>> continuation) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Object b8;
        Object a8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f51410g;
        try {
            if (i8 != 0) {
                if (i8 == 1) {
                    ResultKt.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f51411h;
                SendChannel<E> sendChannel = this.f51412i;
                E e8 = this.f51413j;
                Result.Companion companion = Result.f50818g;
                this.f51410g = 1;
                if (sendChannel.D(e8, this) == d8) {
                    return d8;
                }
            }
            b8 = Result.b(Unit.f50853a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f50818g;
            b8 = Result.b(ResultKt.a(th));
        }
        if (Result.h(b8)) {
            a8 = ChannelResult.f51406b.c(Unit.f50853a);
        } else {
            a8 = ChannelResult.f51406b.a(Result.e(b8));
        }
        return ChannelResult.b(a8);
    }
}
