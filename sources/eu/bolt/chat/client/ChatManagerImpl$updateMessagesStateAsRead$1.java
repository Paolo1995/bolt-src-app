package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatManagerImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl", f = "ChatManagerImpl.kt", l = {167, 172, 174, 177}, m = "updateMessagesStateAsRead")
/* loaded from: classes5.dex */
public final class ChatManagerImpl$updateMessagesStateAsRead$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38634f;

    /* renamed from: g  reason: collision with root package name */
    Object f38635g;

    /* renamed from: h  reason: collision with root package name */
    Object f38636h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f38637i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl f38638j;

    /* renamed from: k  reason: collision with root package name */
    int f38639k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManagerImpl$updateMessagesStateAsRead$1(ChatManagerImpl chatManagerImpl, Continuation<? super ChatManagerImpl$updateMessagesStateAsRead$1> continuation) {
        super(continuation);
        this.f38638j = chatManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f38637i = obj;
        this.f38639k |= Integer.MIN_VALUE;
        return this.f38638j.l(null, this);
    }
}
