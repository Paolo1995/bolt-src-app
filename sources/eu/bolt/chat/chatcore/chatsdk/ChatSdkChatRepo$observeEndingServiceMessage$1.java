package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.client.ChatClient;
import eu.bolt.chat.data.message.ChatMessage;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ChatSdkChatRepo.kt */
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeEndingServiceMessage$1", f = "ChatSdkChatRepo.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class ChatSdkChatRepo$observeEndingServiceMessage$1 extends SuspendLambda implements Function2<ChatClient, Continuation<? super Flow<? extends List<? extends ChatMessage>>>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38034g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38035h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ String f38036i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSdkChatRepo$observeEndingServiceMessage$1(String str, Continuation<? super ChatSdkChatRepo$observeEndingServiceMessage$1> continuation) {
        super(2, continuation);
        this.f38036i = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChatSdkChatRepo$observeEndingServiceMessage$1 chatSdkChatRepo$observeEndingServiceMessage$1 = new ChatSdkChatRepo$observeEndingServiceMessage$1(this.f38036i, continuation);
        chatSdkChatRepo$observeEndingServiceMessage$1.f38035h = obj;
        return chatSdkChatRepo$observeEndingServiceMessage$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(ChatClient chatClient, Continuation<? super Flow<? extends List<? extends ChatMessage>>> continuation) {
        return ((ChatSdkChatRepo$observeEndingServiceMessage$1) create(chatClient, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f38034g == 0) {
            ResultKt.b(obj);
            return ((ChatClient) this.f38035h).c(this.f38036i).j();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
