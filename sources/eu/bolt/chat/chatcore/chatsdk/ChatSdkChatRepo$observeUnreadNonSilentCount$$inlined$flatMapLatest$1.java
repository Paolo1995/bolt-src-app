package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.async.ObservableStateFlow;
import eu.bolt.chat.client.ChatClient;
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
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeUnreadNonSilentCount$$inlined$flatMapLatest$1", f = "ChatSdkChatRepo.kt", l = {190}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class ChatSdkChatRepo$observeUnreadNonSilentCount$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super Integer>, ChatClient, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f37990g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f37991h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f37992i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ String f37993j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSdkChatRepo$observeUnreadNonSilentCount$$inlined$flatMapLatest$1(Continuation continuation, String str) {
        super(3, continuation);
        this.f37993j = str;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(FlowCollector<? super Integer> flowCollector, ChatClient chatClient, Continuation<? super Unit> continuation) {
        ChatSdkChatRepo$observeUnreadNonSilentCount$$inlined$flatMapLatest$1 chatSdkChatRepo$observeUnreadNonSilentCount$$inlined$flatMapLatest$1 = new ChatSdkChatRepo$observeUnreadNonSilentCount$$inlined$flatMapLatest$1(continuation, this.f37993j);
        chatSdkChatRepo$observeUnreadNonSilentCount$$inlined$flatMapLatest$1.f37991h = flowCollector;
        chatSdkChatRepo$observeUnreadNonSilentCount$$inlined$flatMapLatest$1.f37992i = chatClient;
        return chatSdkChatRepo$observeUnreadNonSilentCount$$inlined$flatMapLatest$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f37990g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            ObservableStateFlow<Integer> f8 = ((ChatClient) this.f37992i).c(this.f37993j).f();
            this.f37990g = 1;
            if (FlowKt.l((FlowCollector) this.f37991h, f8, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
