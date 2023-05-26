package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.client.ChatClient;
import eu.bolt.chat.data.Chat;
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
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeActiveChat$1", f = "ChatSdkChatRepo.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class ChatSdkChatRepo$observeActiveChat$1 extends SuspendLambda implements Function2<ChatClient, Continuation<? super Flow<? extends List<? extends Chat>>>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38032g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38033h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatSdkChatRepo$observeActiveChat$1(Continuation<? super ChatSdkChatRepo$observeActiveChat$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChatSdkChatRepo$observeActiveChat$1 chatSdkChatRepo$observeActiveChat$1 = new ChatSdkChatRepo$observeActiveChat$1(continuation);
        chatSdkChatRepo$observeActiveChat$1.f38033h = obj;
        return chatSdkChatRepo$observeActiveChat$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(ChatClient chatClient, Continuation<? super Flow<? extends List<Chat>>> continuation) {
        return ((ChatSdkChatRepo$observeActiveChat$1) create(chatClient, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f38032g == 0) {
            ResultKt.b(obj);
            return ((ChatClient) this.f38033h).b();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
