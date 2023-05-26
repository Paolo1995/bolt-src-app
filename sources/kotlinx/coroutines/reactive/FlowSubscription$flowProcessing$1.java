package kotlinx.coroutines.reactive;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReactiveFlow.kt */
@DebugMetadata(c = "kotlinx.coroutines.reactive.FlowSubscription", f = "ReactiveFlow.kt", l = {209}, m = "flowProcessing")
/* loaded from: classes5.dex */
public final class FlowSubscription$flowProcessing$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f51858f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f51859g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ FlowSubscription<T> f51860h;

    /* renamed from: i  reason: collision with root package name */
    int f51861i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowSubscription$flowProcessing$1(FlowSubscription<T> flowSubscription, Continuation<? super FlowSubscription$flowProcessing$1> continuation) {
        super(continuation);
        this.f51860h = flowSubscription;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object n12;
        this.f51859g = obj;
        this.f51861i |= Integer.MIN_VALUE;
        n12 = this.f51860h.n1(this);
        return n12;
    }
}
