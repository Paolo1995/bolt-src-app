package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Distinct.kt */
/* loaded from: classes5.dex */
public final class DistinctFlowImpl<T> implements Flow<T> {

    /* renamed from: f  reason: collision with root package name */
    private final Flow<T> f51439f;

    /* renamed from: g  reason: collision with root package name */
    public final Function1<T, Object> f51440g;

    /* renamed from: h  reason: collision with root package name */
    public final Function2<Object, Object, Boolean> f51441h;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(Flow<? extends T> flow, Function1<? super T, ? extends Object> function1, Function2<Object, Object, Boolean> function2) {
        this.f51439f = flow;
        this.f51440g = function1;
        this.f51441h = function2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object d8;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f51016f = (T) NullSurrogateKt.f51749a;
        Object a8 = this.f51439f.a(new DistinctFlowImpl$collect$2(this, ref$ObjectRef, flowCollector), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }
}
