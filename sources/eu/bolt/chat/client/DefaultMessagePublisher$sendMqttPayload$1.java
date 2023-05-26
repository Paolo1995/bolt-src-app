package eu.bolt.chat.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessagePublisher.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultMessagePublisher", f = "MessagePublisher.kt", l = {56, 58, 60, 62}, m = "sendMqttPayload")
/* loaded from: classes5.dex */
public final class DefaultMessagePublisher$sendMqttPayload$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38890f;

    /* renamed from: g  reason: collision with root package name */
    Object f38891g;

    /* renamed from: h  reason: collision with root package name */
    Object f38892h;

    /* renamed from: i  reason: collision with root package name */
    Object f38893i;

    /* renamed from: j  reason: collision with root package name */
    Object f38894j;

    /* renamed from: k  reason: collision with root package name */
    boolean f38895k;

    /* renamed from: l  reason: collision with root package name */
    /* synthetic */ Object f38896l;

    /* renamed from: m  reason: collision with root package name */
    final /* synthetic */ DefaultMessagePublisher f38897m;

    /* renamed from: n  reason: collision with root package name */
    int f38898n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultMessagePublisher$sendMqttPayload$1(DefaultMessagePublisher defaultMessagePublisher, Continuation<? super DefaultMessagePublisher$sendMqttPayload$1> continuation) {
        super(continuation);
        this.f38897m = defaultMessagePublisher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object i8;
        this.f38896l = obj;
        this.f38898n |= Integer.MIN_VALUE;
        i8 = this.f38897m.i(null, null, null, this);
        return i8;
    }
}
