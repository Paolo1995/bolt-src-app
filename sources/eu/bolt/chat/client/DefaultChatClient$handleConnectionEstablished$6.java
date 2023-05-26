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
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$6", f = "DefaultChatClient.kt", l = {165}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class DefaultChatClient$handleConnectionEstablished$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38760g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38761h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$handleConnectionEstablished$6(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$handleConnectionEstablished$6> continuation) {
        super(2, continuation);
        this.f38761h = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultChatClient$handleConnectionEstablished$6(this.f38761h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultChatClient$handleConnectionEstablished$6) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Object e02;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f38760g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            DefaultChatClient defaultChatClient = this.f38761h;
            this.f38760g = 1;
            e02 = defaultChatClient.e0(this);
            if (e02 == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
