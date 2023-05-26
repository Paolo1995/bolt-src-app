package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$observePushMessages$2", f = "DefaultChatClient.kt", l = {234, 236, 237}, m = "emit")
/* loaded from: classes5.dex */
public final class DefaultChatClient$observePushMessages$2$emit$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38778f;

    /* renamed from: g  reason: collision with root package name */
    Object f38779g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38780h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient$observePushMessages$2<T> f38781i;

    /* renamed from: j  reason: collision with root package name */
    int f38782j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DefaultChatClient$observePushMessages$2$emit$1(DefaultChatClient$observePushMessages$2<? super T> defaultChatClient$observePushMessages$2, Continuation<? super DefaultChatClient$observePushMessages$2$emit$1> continuation) {
        super(continuation);
        this.f38781i = defaultChatClient$observePushMessages$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f38780h = obj;
        this.f38782j |= Integer.MIN_VALUE;
        return this.f38781i.b(null, this);
    }
}
