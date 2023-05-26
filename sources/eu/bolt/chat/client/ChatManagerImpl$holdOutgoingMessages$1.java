package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatManagerImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl", f = "ChatManagerImpl.kt", l = {378, 383}, m = "holdOutgoingMessages")
/* loaded from: classes5.dex */
public final class ChatManagerImpl$holdOutgoingMessages$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38573f;

    /* renamed from: g  reason: collision with root package name */
    Object f38574g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38575h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl f38576i;

    /* renamed from: j  reason: collision with root package name */
    int f38577j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManagerImpl$holdOutgoingMessages$1(ChatManagerImpl chatManagerImpl, Continuation<? super ChatManagerImpl$holdOutgoingMessages$1> continuation) {
        super(continuation);
        this.f38576i = chatManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object L;
        this.f38575h = obj;
        this.f38577j |= Integer.MIN_VALUE;
        L = this.f38576i.L(this);
        return L;
    }
}
