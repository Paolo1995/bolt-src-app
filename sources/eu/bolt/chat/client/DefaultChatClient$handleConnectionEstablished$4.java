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
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$4", f = "DefaultChatClient.kt", l = {163}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class DefaultChatClient$handleConnectionEstablished$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38756g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38757h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$handleConnectionEstablished$4(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$handleConnectionEstablished$4> continuation) {
        super(2, continuation);
        this.f38757h = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultChatClient$handleConnectionEstablished$4(this.f38757h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultChatClient$handleConnectionEstablished$4) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Object d02;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f38756g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            DefaultChatClient defaultChatClient = this.f38757h;
            this.f38756g = 1;
            d02 = defaultChatClient.d0(this);
            if (d02 == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
