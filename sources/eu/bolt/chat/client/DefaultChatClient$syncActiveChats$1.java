package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient", f = "DefaultChatClient.kt", l = {129, 130, 138, 139, 146, 149, 150}, m = "syncActiveChats")
/* loaded from: classes5.dex */
public final class DefaultChatClient$syncActiveChats$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38814f;

    /* renamed from: g  reason: collision with root package name */
    Object f38815g;

    /* renamed from: h  reason: collision with root package name */
    Object f38816h;

    /* renamed from: i  reason: collision with root package name */
    Object f38817i;

    /* renamed from: j  reason: collision with root package name */
    Object f38818j;

    /* renamed from: k  reason: collision with root package name */
    /* synthetic */ Object f38819k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38820l;

    /* renamed from: m  reason: collision with root package name */
    int f38821m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$syncActiveChats$1(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$syncActiveChats$1> continuation) {
        super(continuation);
        this.f38820l = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m02;
        this.f38819k = obj;
        this.f38821m |= Integer.MIN_VALUE;
        m02 = this.f38820l.m0(this);
        return m02;
    }
}
