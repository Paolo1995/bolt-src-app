package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient", f = "DefaultChatClient.kt", l = {124}, m = "onConnectionFailure")
/* loaded from: classes5.dex */
public final class DefaultChatClient$onConnectionFailure$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38786f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f38787g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38788h;

    /* renamed from: i  reason: collision with root package name */
    int f38789i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$onConnectionFailure$1(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$onConnectionFailure$1> continuation) {
        super(continuation);
        this.f38788h = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object g02;
        this.f38787g = obj;
        this.f38789i |= Integer.MIN_VALUE;
        g02 = this.f38788h.g0(null, this);
        return g02;
    }
}
