package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
/* loaded from: classes5.dex */
public final class ResumeOnCompletion extends JobNode {

    /* renamed from: j  reason: collision with root package name */
    private final Continuation<Unit> f51327j;

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeOnCompletion(Continuation<? super Unit> continuation) {
        this.f51327j = continuation;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void V(Throwable th) {
        Continuation<Unit> continuation = this.f51327j;
        Result.Companion companion = Result.f50818g;
        continuation.resumeWith(Result.b(Unit.f50853a));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        V(th);
        return Unit.f50853a;
    }
}
