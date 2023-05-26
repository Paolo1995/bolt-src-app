package kotlinx.coroutines;

import kotlin.Unit;

/* compiled from: JobSupport.kt */
/* loaded from: classes5.dex */
public final class DisposeOnCompletion extends JobNode {

    /* renamed from: j  reason: collision with root package name */
    private final DisposableHandle f51268j;

    public DisposeOnCompletion(DisposableHandle disposableHandle) {
        this.f51268j = disposableHandle;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void V(Throwable th) {
        this.f51268j.dispose();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        V(th);
        return Unit.f50853a;
    }
}
