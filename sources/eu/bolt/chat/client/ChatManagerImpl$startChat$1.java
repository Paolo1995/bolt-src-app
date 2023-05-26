package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatManagerImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl", f = "ChatManagerImpl.kt", l = {137, 143, 144}, m = "startChat")
/* loaded from: classes5.dex */
public final class ChatManagerImpl$startChat$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38608f;

    /* renamed from: g  reason: collision with root package name */
    Object f38609g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38610h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl f38611i;

    /* renamed from: j  reason: collision with root package name */
    int f38612j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManagerImpl$startChat$1(ChatManagerImpl chatManagerImpl, Continuation<? super ChatManagerImpl$startChat$1> continuation) {
        super(continuation);
        this.f38611i = chatManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f38610h = obj;
        this.f38612j |= Integer.MIN_VALUE;
        return this.f38611i.h(null, this);
    }
}
