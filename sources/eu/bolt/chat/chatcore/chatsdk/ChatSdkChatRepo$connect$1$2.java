package eu.bolt.chat.chatcore.chatsdk;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatSdkChatRepo.kt */
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$connect$1$2", f = "ChatSdkChatRepo.kt", l = {125}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class ChatSdkChatRepo$connect$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38008g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ ChatSdkChatRepo f38009h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSdkChatRepo$connect$1$2(ChatSdkChatRepo chatSdkChatRepo, Continuation<? super ChatSdkChatRepo$connect$1$2> continuation) {
        super(2, continuation);
        this.f38009h = chatSdkChatRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatSdkChatRepo$connect$1$2(this.f38009h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChatSdkChatRepo$connect$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Flow flow;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f38008g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            flow = this.f38009h.f37913o;
            this.f38008g = 1;
            if (FlowKt.g(flow, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
