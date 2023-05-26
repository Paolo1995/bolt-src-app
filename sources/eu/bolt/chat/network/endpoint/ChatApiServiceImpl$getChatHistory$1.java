package eu.bolt.chat.network.endpoint;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatApiServiceImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.network.endpoint.ChatApiServiceImpl", f = "ChatApiServiceImpl.kt", l = {53, 57}, m = "getChatHistory")
/* loaded from: classes5.dex */
public final class ChatApiServiceImpl$getChatHistory$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39358f;

    /* renamed from: g  reason: collision with root package name */
    Object f39359g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f39360h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChatApiServiceImpl f39361i;

    /* renamed from: j  reason: collision with root package name */
    int f39362j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatApiServiceImpl$getChatHistory$1(ChatApiServiceImpl chatApiServiceImpl, Continuation<? super ChatApiServiceImpl$getChatHistory$1> continuation) {
        super(continuation);
        this.f39361i = chatApiServiceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39360h = obj;
        this.f39362j |= Integer.MIN_VALUE;
        return this.f39361i.a(null, this);
    }
}
