package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient", f = "DefaultChatClient.kt", l = {175, 177}, m = "handleConnectionRestored")
/* loaded from: classes5.dex */
public final class DefaultChatClient$handleConnectionRestored$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38766f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f38767g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38768h;

    /* renamed from: i  reason: collision with root package name */
    int f38769i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$handleConnectionRestored$1(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$handleConnectionRestored$1> continuation) {
        super(continuation);
        this.f38768h = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object Z;
        this.f38767g = obj;
        this.f38769i |= Integer.MIN_VALUE;
        Z = this.f38768h.Z(this);
        return Z;
    }
}
