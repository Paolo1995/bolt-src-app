package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient", f = "DefaultChatClient.kt", l = {118}, m = "onDisconnected")
/* loaded from: classes5.dex */
public final class DefaultChatClient$onDisconnected$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38790f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f38791g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38792h;

    /* renamed from: i  reason: collision with root package name */
    int f38793i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$onDisconnected$1(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$onDisconnected$1> continuation) {
        super(continuation);
        this.f38792h = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object h02;
        this.f38791g = obj;
        this.f38793i |= Integer.MIN_VALUE;
        h02 = this.f38792h.h0(this);
        return h02;
    }
}
