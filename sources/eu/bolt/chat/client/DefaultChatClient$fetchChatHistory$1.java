package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient", f = "DefaultChatClient.kt", l = {310, 313, 315}, m = "fetchChatHistory")
/* loaded from: classes5.dex */
public final class DefaultChatClient$fetchChatHistory$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38721f;

    /* renamed from: g  reason: collision with root package name */
    Object f38722g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38723h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38724i;

    /* renamed from: j  reason: collision with root package name */
    int f38725j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$fetchChatHistory$1(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$fetchChatHistory$1> continuation) {
        super(continuation);
        this.f38724i = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object I;
        this.f38723h = obj;
        this.f38725j |= Integer.MIN_VALUE;
        I = this.f38724i.I(null, this);
        return I;
    }
}
