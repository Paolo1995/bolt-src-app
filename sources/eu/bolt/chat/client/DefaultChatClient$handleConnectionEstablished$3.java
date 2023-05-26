package eu.bolt.chat.client;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$3", f = "DefaultChatClient.kt", l = {162}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class DefaultChatClient$handleConnectionEstablished$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38754g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38755h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$handleConnectionEstablished$3(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$handleConnectionEstablished$3> continuation) {
        super(2, continuation);
        this.f38755h = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultChatClient$handleConnectionEstablished$3(this.f38755h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultChatClient$handleConnectionEstablished$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Object k02;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f38754g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            DefaultChatClient defaultChatClient = this.f38755h;
            this.f38754g = 1;
            k02 = defaultChatClient.k0(this);
            if (k02 == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
