package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatManagerImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl", f = "ChatManagerImpl.kt", l = {247, 248, 249, 251}, m = "sendMessage")
/* loaded from: classes5.dex */
public final class ChatManagerImpl$sendMessage$3 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38594f;

    /* renamed from: g  reason: collision with root package name */
    Object f38595g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38596h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl f38597i;

    /* renamed from: j  reason: collision with root package name */
    int f38598j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManagerImpl$sendMessage$3(ChatManagerImpl chatManagerImpl, Continuation<? super ChatManagerImpl$sendMessage$3> continuation) {
        super(continuation);
        this.f38597i = chatManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object P;
        this.f38596h = obj;
        this.f38598j |= Integer.MIN_VALUE;
        P = this.f38597i.P(null, this);
        return P;
    }
}
