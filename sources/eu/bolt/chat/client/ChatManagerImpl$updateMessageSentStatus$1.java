package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatManagerImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl", f = "ChatManagerImpl.kt", l = {312, 324}, m = "updateMessageSentStatus")
/* loaded from: classes5.dex */
public final class ChatManagerImpl$updateMessageSentStatus$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38629f;

    /* renamed from: g  reason: collision with root package name */
    boolean f38630g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38631h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl f38632i;

    /* renamed from: j  reason: collision with root package name */
    int f38633j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManagerImpl$updateMessageSentStatus$1(ChatManagerImpl chatManagerImpl, Continuation<? super ChatManagerImpl$updateMessageSentStatus$1> continuation) {
        super(continuation);
        this.f38632i = chatManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object S;
        this.f38631h = obj;
        this.f38633j |= Integer.MIN_VALUE;
        S = this.f38632i.S(false, null, this);
        return S;
    }
}
