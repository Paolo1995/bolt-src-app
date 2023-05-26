package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient", f = "DefaultChatClient.kt", l = {211, 218}, m = "refreshAvailableChatsList")
/* loaded from: classes5.dex */
public final class DefaultChatClient$refreshAvailableChatsList$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38794f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f38795g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38796h;

    /* renamed from: i  reason: collision with root package name */
    int f38797i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$refreshAvailableChatsList$1(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$refreshAvailableChatsList$1> continuation) {
        super(continuation);
        this.f38796h = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object j02;
        this.f38795g = obj;
        this.f38797i |= Integer.MIN_VALUE;
        j02 = this.f38796h.j0(this);
        return j02;
    }
}
