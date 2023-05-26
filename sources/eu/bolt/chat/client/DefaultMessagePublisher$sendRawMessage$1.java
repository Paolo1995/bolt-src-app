package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessagePublisher.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultMessagePublisher", f = "MessagePublisher.kt", l = {100}, m = "sendRawMessage")
/* loaded from: classes5.dex */
public final class DefaultMessagePublisher$sendRawMessage$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38907f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f38908g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DefaultMessagePublisher f38909h;

    /* renamed from: i  reason: collision with root package name */
    int f38910i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultMessagePublisher$sendRawMessage$1(DefaultMessagePublisher defaultMessagePublisher, Continuation<? super DefaultMessagePublisher$sendRawMessage$1> continuation) {
        super(continuation);
        this.f38909h = defaultMessagePublisher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object j8;
        this.f38908g = obj;
        this.f38910i |= Integer.MIN_VALUE;
        j8 = this.f38909h.j(null, this);
        return j8;
    }
}
