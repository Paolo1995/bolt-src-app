package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatSubscriber.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatSubscriber", f = "DefaultChatSubscriber.kt", l = {81, 82, 84}, m = "resubscribe")
/* loaded from: classes5.dex */
public final class DefaultChatSubscriber$resubscribe$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38872f;

    /* renamed from: g  reason: collision with root package name */
    Object f38873g;

    /* renamed from: h  reason: collision with root package name */
    Object f38874h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f38875i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ DefaultChatSubscriber f38876j;

    /* renamed from: k  reason: collision with root package name */
    int f38877k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatSubscriber$resubscribe$1(DefaultChatSubscriber defaultChatSubscriber, Continuation<? super DefaultChatSubscriber$resubscribe$1> continuation) {
        super(continuation);
        this.f38876j = defaultChatSubscriber;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object h8;
        this.f38875i = obj;
        this.f38877k |= Integer.MIN_VALUE;
        h8 = this.f38876j.h(this);
        return h8;
    }
}
