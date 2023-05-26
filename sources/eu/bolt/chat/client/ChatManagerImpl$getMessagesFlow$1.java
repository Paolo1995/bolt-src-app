package eu.bolt.chat.client;

import eu.bolt.chat.util.CoroutineRunner;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ChatManagerImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl$getMessagesFlow$1", f = "ChatManagerImpl.kt", l = {188}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class ChatManagerImpl$getMessagesFlow$1 extends SuspendLambda implements Function2<CoroutineRunner, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38571g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl f38572h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManagerImpl$getMessagesFlow$1(ChatManagerImpl chatManagerImpl, Continuation<? super ChatManagerImpl$getMessagesFlow$1> continuation) {
        super(2, continuation);
        this.f38572h = chatManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatManagerImpl$getMessagesFlow$1(this.f38572h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineRunner coroutineRunner, Continuation<? super Unit> continuation) {
        return ((ChatManagerImpl$getMessagesFlow$1) create(coroutineRunner, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Object O;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f38571g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            ChatManagerImpl chatManagerImpl = this.f38572h;
            this.f38571g = 1;
            O = chatManagerImpl.O(this);
            if (O == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
