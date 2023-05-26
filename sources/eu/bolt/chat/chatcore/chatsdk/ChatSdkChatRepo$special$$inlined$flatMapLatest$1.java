package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.async.ObservableStateFlow;
import eu.bolt.chat.client.ChatClient;
import eu.bolt.chat.data.ClientStatus;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: Merge.kt */
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$special$$inlined$flatMapLatest$1", f = "ChatSdkChatRepo.kt", l = {190}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class ChatSdkChatRepo$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super ClientStatus>, ChatClient, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f37994g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f37995h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f37996i;

    public ChatSdkChatRepo$special$$inlined$flatMapLatest$1(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(FlowCollector<? super ClientStatus> flowCollector, ChatClient chatClient, Continuation<? super Unit> continuation) {
        ChatSdkChatRepo$special$$inlined$flatMapLatest$1 chatSdkChatRepo$special$$inlined$flatMapLatest$1 = new ChatSdkChatRepo$special$$inlined$flatMapLatest$1(continuation);
        chatSdkChatRepo$special$$inlined$flatMapLatest$1.f37995h = flowCollector;
        chatSdkChatRepo$special$$inlined$flatMapLatest$1.f37996i = chatClient;
        return chatSdkChatRepo$special$$inlined$flatMapLatest$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f37994g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            ObservableStateFlow<ClientStatus> d9 = ((ChatClient) this.f37996i).d();
            this.f37994g = 1;
            if (FlowKt.l((FlowCollector) this.f37995h, d9, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
