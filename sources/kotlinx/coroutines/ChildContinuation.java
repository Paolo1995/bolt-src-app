package kotlinx.coroutines;

import kotlin.Unit;

/* compiled from: JobSupport.kt */
/* loaded from: classes5.dex */
public final class ChildContinuation extends JobCancellingNode {

    /* renamed from: j  reason: collision with root package name */
    public final CancellableContinuationImpl<?> f51226j;

    public ChildContinuation(CancellableContinuationImpl<?> cancellableContinuationImpl) {
        this.f51226j = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void V(Throwable th) {
        CancellableContinuationImpl<?> cancellableContinuationImpl = this.f51226j;
        cancellableContinuationImpl.H(cancellableContinuationImpl.u(W()));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        V(th);
        return Unit.f50853a;
    }
}
