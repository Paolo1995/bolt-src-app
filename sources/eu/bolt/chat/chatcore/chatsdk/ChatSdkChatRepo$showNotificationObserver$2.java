package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.chatcore.chatsdk.mapper.ChatMapper;
import eu.bolt.chat.chatcore.chatsdk.mapper.MessageMapper;
import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.push.ChatPushDelegate;
import eu.bolt.chat.data.Chat;
import eu.bolt.chat.data.ChatPushMessage;
import eu.bolt.chat.data.message.ChatMessage;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatSdkChatRepo.kt */
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$showNotificationObserver$2", f = "ChatSdkChatRepo.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class ChatSdkChatRepo$showNotificationObserver$2 extends SuspendLambda implements Function2<ChatPushMessage, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38044g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38045h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChatSdkChatRepo f38046i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSdkChatRepo$showNotificationObserver$2(ChatSdkChatRepo chatSdkChatRepo, Continuation<? super ChatSdkChatRepo$showNotificationObserver$2> continuation) {
        super(2, continuation);
        this.f38046i = chatSdkChatRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChatSdkChatRepo$showNotificationObserver$2 chatSdkChatRepo$showNotificationObserver$2 = new ChatSdkChatRepo$showNotificationObserver$2(this.f38046i, continuation);
        chatSdkChatRepo$showNotificationObserver$2.f38045h = obj;
        return chatSdkChatRepo$showNotificationObserver$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(ChatPushMessage chatPushMessage, Continuation<? super Unit> continuation) {
        return ((ChatSdkChatRepo$showNotificationObserver$2) create(chatPushMessage, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ChatPushDelegate chatPushDelegate;
        ChatMapper chatMapper;
        MessageMapper messageMapper;
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f38044g == 0) {
            ResultKt.b(obj);
            ChatPushMessage chatPushMessage = (ChatPushMessage) this.f38045h;
            Chat a8 = chatPushMessage.a();
            ChatMessage b8 = chatPushMessage.b();
            chatPushDelegate = this.f38046i.f37902d;
            chatMapper = this.f38046i.f37904f;
            ChatEntity a9 = chatMapper.a(a8);
            messageMapper = this.f38046i.f37906h;
            chatPushDelegate.b(a9, messageMapper.a(b8));
            return Unit.f50853a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
