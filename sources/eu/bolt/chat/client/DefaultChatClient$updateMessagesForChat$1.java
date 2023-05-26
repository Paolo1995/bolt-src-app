package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient", f = "DefaultChatClient.kt", l = {337, 340}, m = "updateMessagesForChat")
/* loaded from: classes5.dex */
public final class DefaultChatClient$updateMessagesForChat$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38825f;

    /* renamed from: g  reason: collision with root package name */
    Object f38826g;

    /* renamed from: h  reason: collision with root package name */
    Object f38827h;

    /* renamed from: i  reason: collision with root package name */
    Object f38828i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f38829j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38830k;

    /* renamed from: l  reason: collision with root package name */
    int f38831l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$updateMessagesForChat$1(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$updateMessagesForChat$1> continuation) {
        super(continuation);
        this.f38830k = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object p02;
        this.f38829j = obj;
        this.f38831l |= Integer.MIN_VALUE;
        p02 = this.f38830k.p0(null, null, this);
        return p02;
    }
}
