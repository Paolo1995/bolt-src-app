package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatManagerImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl", f = "ChatManagerImpl.kt", l = {120, 125}, m = "showNotification")
/* loaded from: classes5.dex */
public final class ChatManagerImpl$showNotification$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38603f;

    /* renamed from: g  reason: collision with root package name */
    Object f38604g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38605h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl f38606i;

    /* renamed from: j  reason: collision with root package name */
    int f38607j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManagerImpl$showNotification$1(ChatManagerImpl chatManagerImpl, Continuation<? super ChatManagerImpl$showNotification$1> continuation) {
        super(continuation);
        this.f38606i = chatManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object Q;
        this.f38605h = obj;
        this.f38607j |= Integer.MIN_VALUE;
        Q = this.f38606i.Q(null, this);
        return Q;
    }
}
