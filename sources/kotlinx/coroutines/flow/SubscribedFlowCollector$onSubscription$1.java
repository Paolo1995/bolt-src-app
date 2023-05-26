package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Share.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {419, 423}, m = "onSubscription")
/* loaded from: classes5.dex */
public final class SubscribedFlowCollector$onSubscription$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f51655f;

    /* renamed from: g  reason: collision with root package name */
    Object f51656g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f51657h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ SubscribedFlowCollector<T> f51658i;

    /* renamed from: j  reason: collision with root package name */
    int f51659j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscribedFlowCollector$onSubscription$1(SubscribedFlowCollector<T> subscribedFlowCollector, Continuation<? super SubscribedFlowCollector$onSubscription$1> continuation) {
        super(continuation);
        this.f51658i = subscribedFlowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51657h = obj;
        this.f51659j |= Integer.MIN_VALUE;
        return this.f51658i.a(this);
    }
}
