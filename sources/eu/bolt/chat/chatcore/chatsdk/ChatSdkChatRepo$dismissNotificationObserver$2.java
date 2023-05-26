package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.chatcore.push.ChatPushDelegate;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatSdkChatRepo.kt */
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$dismissNotificationObserver$2", f = "ChatSdkChatRepo.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class ChatSdkChatRepo$dismissNotificationObserver$2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38018g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38019h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChatSdkChatRepo f38020i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSdkChatRepo$dismissNotificationObserver$2(ChatSdkChatRepo chatSdkChatRepo, Continuation<? super ChatSdkChatRepo$dismissNotificationObserver$2> continuation) {
        super(2, continuation);
        this.f38020i = chatSdkChatRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChatSdkChatRepo$dismissNotificationObserver$2 chatSdkChatRepo$dismissNotificationObserver$2 = new ChatSdkChatRepo$dismissNotificationObserver$2(this.f38020i, continuation);
        chatSdkChatRepo$dismissNotificationObserver$2.f38019h = obj;
        return chatSdkChatRepo$dismissNotificationObserver$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(String str, Continuation<? super Unit> continuation) {
        return ((ChatSdkChatRepo$dismissNotificationObserver$2) create(str, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ChatPushDelegate chatPushDelegate;
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f38018g == 0) {
            ResultKt.b(obj);
            chatPushDelegate = this.f38020i.f37902d;
            chatPushDelegate.a((String) this.f38019h);
            return Unit.f50853a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
