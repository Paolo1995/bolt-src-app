package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatManagerImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl", f = "ChatManagerImpl.kt", l = {397, 399, 401, 409}, m = "updateMessageHistory")
/* loaded from: classes5.dex */
public final class ChatManagerImpl$updateMessageHistory$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38623f;

    /* renamed from: g  reason: collision with root package name */
    Object f38624g;

    /* renamed from: h  reason: collision with root package name */
    Object f38625h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f38626i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl f38627j;

    /* renamed from: k  reason: collision with root package name */
    int f38628k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManagerImpl$updateMessageHistory$1(ChatManagerImpl chatManagerImpl, Continuation<? super ChatManagerImpl$updateMessageHistory$1> continuation) {
        super(continuation);
        this.f38627j = chatManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f38626i = obj;
        this.f38628k |= Integer.MIN_VALUE;
        return this.f38627j.b(null, null, this);
    }
}
