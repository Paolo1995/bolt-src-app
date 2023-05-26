package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.async.ObservableFlow;
import eu.bolt.chat.client.ChatNotificationManager;
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
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$special$$inlined$flatMapLatest$3", f = "ChatSdkChatRepo.kt", l = {190}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class ChatSdkChatRepo$special$$inlined$flatMapLatest$3 extends SuspendLambda implements Function3<FlowCollector<? super String>, ChatNotificationManager, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38000g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f38001h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f38002i;

    public ChatSdkChatRepo$special$$inlined$flatMapLatest$3(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(FlowCollector<? super String> flowCollector, ChatNotificationManager chatNotificationManager, Continuation<? super Unit> continuation) {
        ChatSdkChatRepo$special$$inlined$flatMapLatest$3 chatSdkChatRepo$special$$inlined$flatMapLatest$3 = new ChatSdkChatRepo$special$$inlined$flatMapLatest$3(continuation);
        chatSdkChatRepo$special$$inlined$flatMapLatest$3.f38001h = flowCollector;
        chatSdkChatRepo$special$$inlined$flatMapLatest$3.f38002i = chatNotificationManager;
        return chatSdkChatRepo$special$$inlined$flatMapLatest$3.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f38000g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            ObservableFlow<String> a8 = ((ChatNotificationManager) this.f38002i).a();
            this.f38000g = 1;
            if (FlowKt.l((FlowCollector) this.f38001h, a8, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
