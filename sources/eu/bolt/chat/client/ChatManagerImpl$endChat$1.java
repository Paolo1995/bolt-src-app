package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatManagerImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl", f = "ChatManagerImpl.kt", l = {148, 151, 157, 158, 159, 160, 161}, m = "endChat")
/* loaded from: classes5.dex */
public final class ChatManagerImpl$endChat$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38558f;

    /* renamed from: g  reason: collision with root package name */
    Object f38559g;

    /* renamed from: h  reason: collision with root package name */
    Object f38560h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f38561i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl f38562j;

    /* renamed from: k  reason: collision with root package name */
    int f38563k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManagerImpl$endChat$1(ChatManagerImpl chatManagerImpl, Continuation<? super ChatManagerImpl$endChat$1> continuation) {
        super(continuation);
        this.f38562j = chatManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f38561i = obj;
        this.f38563k |= Integer.MIN_VALUE;
        return this.f38562j.d(null, this);
    }
}
