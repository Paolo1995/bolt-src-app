package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient", f = "DefaultChatClient.kt", l = {261, 262, 263, 266, 267, 269, 271}, m = "handleChatLifeCycleEvent")
/* loaded from: classes5.dex */
public final class DefaultChatClient$handleChatLifeCycleEvent$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38735f;

    /* renamed from: g  reason: collision with root package name */
    Object f38736g;

    /* renamed from: h  reason: collision with root package name */
    Object f38737h;

    /* renamed from: i  reason: collision with root package name */
    Object f38738i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f38739j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38740k;

    /* renamed from: l  reason: collision with root package name */
    int f38741l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$handleChatLifeCycleEvent$1(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$handleChatLifeCycleEvent$1> continuation) {
        super(continuation);
        this.f38740k = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object X;
        this.f38739j = obj;
        this.f38741l |= Integer.MIN_VALUE;
        X = this.f38740k.X(null, null, null, this);
        return X;
    }
}
