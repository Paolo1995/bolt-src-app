package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatManagerImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl", f = "ChatManagerImpl.kt", l = {361, 363, 363, 364}, m = "reloadMessagesState")
/* loaded from: classes5.dex */
public final class ChatManagerImpl$reloadMessagesState$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38585f;

    /* renamed from: g  reason: collision with root package name */
    Object f38586g;

    /* renamed from: h  reason: collision with root package name */
    Object f38587h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f38588i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl f38589j;

    /* renamed from: k  reason: collision with root package name */
    int f38590k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManagerImpl$reloadMessagesState$1(ChatManagerImpl chatManagerImpl, Continuation<? super ChatManagerImpl$reloadMessagesState$1> continuation) {
        super(continuation);
        this.f38589j = chatManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object O;
        this.f38588i = obj;
        this.f38590k |= Integer.MIN_VALUE;
        O = this.f38589j.O(this);
        return O;
    }
}
