package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessagePublisher.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultMessagePublisher", f = "MessagePublisher.kt", l = {78, 79, 83, 85}, m = "sendPendingMessagesFor")
/* loaded from: classes5.dex */
public final class DefaultMessagePublisher$sendPendingMessagesFor$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38899f;

    /* renamed from: g  reason: collision with root package name */
    Object f38900g;

    /* renamed from: h  reason: collision with root package name */
    Object f38901h;

    /* renamed from: i  reason: collision with root package name */
    Object f38902i;

    /* renamed from: j  reason: collision with root package name */
    Object f38903j;

    /* renamed from: k  reason: collision with root package name */
    /* synthetic */ Object f38904k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ DefaultMessagePublisher f38905l;

    /* renamed from: m  reason: collision with root package name */
    int f38906m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultMessagePublisher$sendPendingMessagesFor$1(DefaultMessagePublisher defaultMessagePublisher, Continuation<? super DefaultMessagePublisher$sendPendingMessagesFor$1> continuation) {
        super(continuation);
        this.f38905l = defaultMessagePublisher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f38904k = obj;
        this.f38906m |= Integer.MIN_VALUE;
        return this.f38905l.f(null, null, this);
    }
}
