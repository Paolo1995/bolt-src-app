package eu.bolt.chat.network.endpoint;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatApiServiceImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.network.endpoint.ChatApiServiceImpl", f = "ChatApiServiceImpl.kt", l = {53, 57}, m = "getActiveChats")
/* loaded from: classes5.dex */
public final class ChatApiServiceImpl$getActiveChats$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    /* synthetic */ Object f39354f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ ChatApiServiceImpl f39355g;

    /* renamed from: h  reason: collision with root package name */
    int f39356h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatApiServiceImpl$getActiveChats$1(ChatApiServiceImpl chatApiServiceImpl, Continuation<? super ChatApiServiceImpl$getActiveChats$1> continuation) {
        super(continuation);
        this.f39355g = chatApiServiceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39354f = obj;
        this.f39356h |= Integer.MIN_VALUE;
        return this.f39355g.b(this);
    }
}
