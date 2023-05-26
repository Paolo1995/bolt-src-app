package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.data.ClientStatus;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatSdkChatRepo.kt */
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$connectionStatus$2", f = "ChatSdkChatRepo.kt", l = {85}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class ChatSdkChatRepo$connectionStatus$2 extends SuspendLambda implements Function2<ClientStatus, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38015g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38016h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChatSdkChatRepo f38017i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSdkChatRepo$connectionStatus$2(ChatSdkChatRepo chatSdkChatRepo, Continuation<? super ChatSdkChatRepo$connectionStatus$2> continuation) {
        super(2, continuation);
        this.f38017i = chatSdkChatRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChatSdkChatRepo$connectionStatus$2 chatSdkChatRepo$connectionStatus$2 = new ChatSdkChatRepo$connectionStatus$2(this.f38017i, continuation);
        chatSdkChatRepo$connectionStatus$2.f38016h = obj;
        return chatSdkChatRepo$connectionStatus$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(ClientStatus clientStatus, Continuation<? super Unit> continuation) {
        return ((ChatSdkChatRepo$connectionStatus$2) create(clientStatus, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Object H;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f38015g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            ChatSdkChatRepo chatSdkChatRepo = this.f38017i;
            this.f38015g = 1;
            H = chatSdkChatRepo.H((ClientStatus) this.f38016h, this);
            if (H == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
