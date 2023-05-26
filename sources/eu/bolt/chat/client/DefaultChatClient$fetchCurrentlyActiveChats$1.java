package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient", f = "DefaultChatClient.kt", l = {320}, m = "fetchCurrentlyActiveChats")
/* loaded from: classes5.dex */
public final class DefaultChatClient$fetchCurrentlyActiveChats$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38726f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f38727g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38728h;

    /* renamed from: i  reason: collision with root package name */
    int f38729i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$fetchCurrentlyActiveChats$1(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$fetchCurrentlyActiveChats$1> continuation) {
        super(continuation);
        this.f38728h = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object J;
        this.f38727g = obj;
        this.f38729i |= Integer.MIN_VALUE;
        J = this.f38728h.J(this);
        return J;
    }
}
