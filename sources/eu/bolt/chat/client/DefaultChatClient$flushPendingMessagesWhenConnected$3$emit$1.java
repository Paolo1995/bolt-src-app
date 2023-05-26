package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$flushPendingMessagesWhenConnected$3", f = "DefaultChatClient.kt", l = {192}, m = "emit")
/* loaded from: classes5.dex */
public final class DefaultChatClient$flushPendingMessagesWhenConnected$3$emit$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38731f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f38732g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient$flushPendingMessagesWhenConnected$3<T> f38733h;

    /* renamed from: i  reason: collision with root package name */
    int f38734i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DefaultChatClient$flushPendingMessagesWhenConnected$3$emit$1(DefaultChatClient$flushPendingMessagesWhenConnected$3<? super T> defaultChatClient$flushPendingMessagesWhenConnected$3, Continuation<? super DefaultChatClient$flushPendingMessagesWhenConnected$3$emit$1> continuation) {
        super(continuation);
        this.f38733h = defaultChatClient$flushPendingMessagesWhenConnected$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f38732g = obj;
        this.f38734i |= Integer.MIN_VALUE;
        return this.f38733h.b(null, this);
    }
}
