package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatManagerImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl$accumulateAndPublishSeenEvents$2", f = "ChatManagerImpl.kt", l = {71, 78}, m = "emit")
/* loaded from: classes5.dex */
public final class ChatManagerImpl$accumulateAndPublishSeenEvents$2$emit$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38552f;

    /* renamed from: g  reason: collision with root package name */
    Object f38553g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38554h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl$accumulateAndPublishSeenEvents$2<T> f38555i;

    /* renamed from: j  reason: collision with root package name */
    int f38556j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChatManagerImpl$accumulateAndPublishSeenEvents$2$emit$1(ChatManagerImpl$accumulateAndPublishSeenEvents$2<? super T> chatManagerImpl$accumulateAndPublishSeenEvents$2, Continuation<? super ChatManagerImpl$accumulateAndPublishSeenEvents$2$emit$1> continuation) {
        super(continuation);
        this.f38555i = chatManagerImpl$accumulateAndPublishSeenEvents$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f38554h = obj;
        this.f38556j |= Integer.MIN_VALUE;
        return this.f38555i.b(null, this);
    }
}
