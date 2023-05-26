package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StateFlow.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {386, 398, 403}, m = "collect")
/* loaded from: classes5.dex */
public final class StateFlowImpl$collect$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f51642f;

    /* renamed from: g  reason: collision with root package name */
    Object f51643g;

    /* renamed from: h  reason: collision with root package name */
    Object f51644h;

    /* renamed from: i  reason: collision with root package name */
    Object f51645i;

    /* renamed from: j  reason: collision with root package name */
    Object f51646j;

    /* renamed from: k  reason: collision with root package name */
    /* synthetic */ Object f51647k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ StateFlowImpl<T> f51648l;

    /* renamed from: m  reason: collision with root package name */
    int f51649m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateFlowImpl$collect$1(StateFlowImpl<T> stateFlowImpl, Continuation<? super StateFlowImpl$collect$1> continuation) {
        super(continuation);
        this.f51648l = stateFlowImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51647k = obj;
        this.f51649m |= Integer.MIN_VALUE;
        return this.f51648l.a(null, this);
    }
}
