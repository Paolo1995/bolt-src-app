package eu.bolt.chat.client;

import eu.bolt.chat.data.message.MessageSender;
import eu.bolt.chat.data.message.MessageStatus;
import eu.bolt.chat.data.message.UserTextMessage;
import eu.bolt.chat.util.CoroutineRunner;
import eu.bolt.chat.util.DateTimeUtilsKt;
import eu.bolt.chat.util.UUID;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.datetime.LocalDateTime;

/* compiled from: ChatManagerImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl$sendMessage$2", f = "ChatManagerImpl.kt", l = {241}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class ChatManagerImpl$sendMessage$2 extends SuspendLambda implements Function2<CoroutineRunner, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38591g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl f38592h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ String f38593i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManagerImpl$sendMessage$2(ChatManagerImpl chatManagerImpl, String str, Continuation<? super ChatManagerImpl$sendMessage$2> continuation) {
        super(2, continuation);
        this.f38592h = chatManagerImpl;
        this.f38593i = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatManagerImpl$sendMessage$2(this.f38592h, this.f38593i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineRunner coroutineRunner, Continuation<? super Unit> continuation) {
        return ((ChatManagerImpl$sendMessage$2) create(coroutineRunner, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        String str;
        MessageSender J;
        Object P;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f38591g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            String a8 = UUID.f39707a.a();
            str = this.f38592h.f38532a;
            LocalDateTime a9 = DateTimeUtilsKt.a(LocalDateTime.Companion);
            MessageStatus messageStatus = MessageStatus.SENDING;
            String str2 = this.f38593i;
            J = this.f38592h.J();
            UserTextMessage userTextMessage = new UserTextMessage(a8, str, a9, messageStatus, str2, true, J, null, null);
            ChatManagerImpl chatManagerImpl = this.f38592h;
            this.f38591g = 1;
            P = chatManagerImpl.P(userTextMessage, this);
            if (P == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
