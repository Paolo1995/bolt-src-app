package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient", f = "DefaultChatClient.kt", l = {159}, m = "handleConnectionEstablished")
/* loaded from: classes5.dex */
public final class DefaultChatClient$handleConnectionEstablished$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38748f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f38749g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38750h;

    /* renamed from: i  reason: collision with root package name */
    int f38751i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$handleConnectionEstablished$1(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$handleConnectionEstablished$1> continuation) {
        super(continuation);
        this.f38750h = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object Y;
        this.f38749g = obj;
        this.f38751i |= Integer.MIN_VALUE;
        Y = this.f38750h.Y(this);
        return Y;
    }
}
