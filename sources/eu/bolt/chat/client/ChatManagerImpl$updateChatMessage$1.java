package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatManagerImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl", f = "ChatManagerImpl.kt", l = {108, 110, 111, 113, 116}, m = "updateChatMessage")
/* loaded from: classes5.dex */
public final class ChatManagerImpl$updateChatMessage$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38618f;

    /* renamed from: g  reason: collision with root package name */
    Object f38619g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38620h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl f38621i;

    /* renamed from: j  reason: collision with root package name */
    int f38622j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManagerImpl$updateChatMessage$1(ChatManagerImpl chatManagerImpl, Continuation<? super ChatManagerImpl$updateChatMessage$1> continuation) {
        super(continuation);
        this.f38621i = chatManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object R;
        this.f38620h = obj;
        this.f38622j |= Integer.MIN_VALUE;
        R = this.f38621i.R(null, this);
        return R;
    }
}
