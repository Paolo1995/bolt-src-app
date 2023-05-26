package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient", f = "DefaultChatClient.kt", l = {243}, m = "observeIncomingMessages")
/* loaded from: classes5.dex */
public final class DefaultChatClient$observeIncomingMessages$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    /* synthetic */ Object f38773f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38774g;

    /* renamed from: h  reason: collision with root package name */
    int f38775h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$observeIncomingMessages$1(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$observeIncomingMessages$1> continuation) {
        super(continuation);
        this.f38774g = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c02;
        this.f38773f = obj;
        this.f38775h |= Integer.MIN_VALUE;
        c02 = this.f38774g.c0(this);
        return c02;
    }
}
