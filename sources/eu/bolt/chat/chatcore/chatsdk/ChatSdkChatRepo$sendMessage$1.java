package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.client.ChatClient;
import eu.bolt.chat.client.ChatManager;
import eu.bolt.chat.tools.logger.Logger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ChatSdkChatRepo.kt */
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$sendMessage$1", f = "ChatSdkChatRepo.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class ChatSdkChatRepo$sendMessage$1 extends SuspendLambda implements Function2<ChatClient, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38040g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f38041h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChatMessageEntity f38042i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ ChatSdkChatRepo f38043j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSdkChatRepo$sendMessage$1(ChatMessageEntity chatMessageEntity, ChatSdkChatRepo chatSdkChatRepo, Continuation<? super ChatSdkChatRepo$sendMessage$1> continuation) {
        super(2, continuation);
        this.f38042i = chatMessageEntity;
        this.f38043j = chatSdkChatRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChatSdkChatRepo$sendMessage$1 chatSdkChatRepo$sendMessage$1 = new ChatSdkChatRepo$sendMessage$1(this.f38042i, this.f38043j, continuation);
        chatSdkChatRepo$sendMessage$1.f38041h = obj;
        return chatSdkChatRepo$sendMessage$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(ChatClient chatClient, Continuation<? super Unit> continuation) {
        return ((ChatSdkChatRepo$sendMessage$1) create(chatClient, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Logger logger;
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f38040g == 0) {
            ResultKt.b(obj);
            ChatManager c8 = ((ChatClient) this.f38041h).c(this.f38042i.b());
            if (this.f38042i.e() != null) {
                c8.k(this.f38042i.e());
            } else if (this.f38042i.j() == null) {
                logger = this.f38043j.f37907i;
                logger.d("Message " + this.f38042i + " is not supported to send");
            } else {
                c8.o(this.f38042i.j());
            }
            return Unit.f50853a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
