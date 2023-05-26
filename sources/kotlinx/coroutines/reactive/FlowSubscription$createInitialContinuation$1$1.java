package kotlinx.coroutines.reactive;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: ReactiveFlow.kt */
/* loaded from: classes5.dex */
/* synthetic */ class FlowSubscription$createInitialContinuation$1$1 extends FunctionReferenceImpl implements Function1<Continuation<? super Unit>, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowSubscription$createInitialContinuation$1$1(Object obj) {
        super(1, obj, FlowSubscription.class, "flowProcessing", "flowProcessing(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: j */
    public final Object invoke(Continuation<? super Unit> continuation) {
        Object n12;
        n12 = ((FlowSubscription) this.f50989g).n1(continuation);
        return n12;
    }
}
