package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.async.ObservableFlow;
import eu.bolt.chat.client.ChatNotificationManager;
import eu.bolt.chat.data.ChatPushMessage;
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
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$special$$inlined$flatMapLatest$2", f = "ChatSdkChatRepo.kt", l = {190}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class ChatSdkChatRepo$special$$inlined$flatMapLatest$2 extends SuspendLambda implements Function3<FlowCollector<? super ChatPushMessage>, ChatNotificationManager, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f37997g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f37998h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f37999i;

    public ChatSdkChatRepo$special$$inlined$flatMapLatest$2(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(FlowCollector<? super ChatPushMessage> flowCollector, ChatNotificationManager chatNotificationManager, Continuation<? super Unit> continuation) {
        ChatSdkChatRepo$special$$inlined$flatMapLatest$2 chatSdkChatRepo$special$$inlined$flatMapLatest$2 = new ChatSdkChatRepo$special$$inlined$flatMapLatest$2(continuation);
        chatSdkChatRepo$special$$inlined$flatMapLatest$2.f37998h = flowCollector;
        chatSdkChatRepo$special$$inlined$flatMapLatest$2.f37999i = chatNotificationManager;
        return chatSdkChatRepo$special$$inlined$flatMapLatest$2.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f37997g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            ObservableFlow<ChatPushMessage> d9 = ((ChatNotificationManager) this.f37999i).d();
            this.f37997g = 1;
            if (FlowKt.l((FlowCollector) this.f37998h, d9, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
