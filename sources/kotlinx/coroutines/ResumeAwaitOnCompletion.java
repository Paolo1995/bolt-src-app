package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
/* loaded from: classes5.dex */
public final class ResumeAwaitOnCompletion<T> extends JobNode {

    /* renamed from: j  reason: collision with root package name */
    private final CancellableContinuationImpl<T> f51326j;

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeAwaitOnCompletion(CancellableContinuationImpl<? super T> cancellableContinuationImpl) {
        this.f51326j = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void V(Throwable th) {
        Object r02 = W().r0();
        if (r02 instanceof CompletedExceptionally) {
            CancellableContinuationImpl<T> cancellableContinuationImpl = this.f51326j;
            Result.Companion companion = Result.f50818g;
            cancellableContinuationImpl.resumeWith(Result.b(ResultKt.a(((CompletedExceptionally) r02).f51234a)));
            return;
        }
        CancellableContinuationImpl<T> cancellableContinuationImpl2 = this.f51326j;
        Result.Companion companion2 = Result.f50818g;
        cancellableContinuationImpl2.resumeWith(Result.b(JobSupportKt.h(r02)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        V(th);
        return Unit.f50853a;
    }
}
