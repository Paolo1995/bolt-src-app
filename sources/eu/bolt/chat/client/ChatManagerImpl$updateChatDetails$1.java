package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatManagerImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl", f = "ChatManagerImpl.kt", l = {388, 389}, m = "updateChatDetails")
/* loaded from: classes5.dex */
public final class ChatManagerImpl$updateChatDetails$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38613f;

    /* renamed from: g  reason: collision with root package name */
    Object f38614g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38615h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl f38616i;

    /* renamed from: j  reason: collision with root package name */
    int f38617j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManagerImpl$updateChatDetails$1(ChatManagerImpl chatManagerImpl, Continuation<? super ChatManagerImpl$updateChatDetails$1> continuation) {
        super(continuation);
        this.f38616i = chatManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f38615h = obj;
        this.f38617j |= Integer.MIN_VALUE;
        return this.f38616i.a(null, this);
    }
}
