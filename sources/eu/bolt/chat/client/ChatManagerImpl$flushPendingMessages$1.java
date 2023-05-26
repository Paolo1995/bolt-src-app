package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatManagerImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl", f = "ChatManagerImpl.kt", l = {288, 293, 299, 304}, m = "flushPendingMessages")
/* loaded from: classes5.dex */
public final class ChatManagerImpl$flushPendingMessages$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38564f;

    /* renamed from: g  reason: collision with root package name */
    Object f38565g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38566h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl f38567i;

    /* renamed from: j  reason: collision with root package name */
    int f38568j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManagerImpl$flushPendingMessages$1(ChatManagerImpl chatManagerImpl, Continuation<? super ChatManagerImpl$flushPendingMessages$1> continuation) {
        super(continuation);
        this.f38567i = chatManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f38566h = obj;
        this.f38568j |= Integer.MIN_VALUE;
        return this.f38567i.e(this);
    }
}
