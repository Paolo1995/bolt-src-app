package kotlinx.coroutines;

import kotlin.Unit;

/* compiled from: CancellableContinuation.kt */
/* loaded from: classes5.dex */
final class DisposeOnCancel extends CancelHandler {

    /* renamed from: f  reason: collision with root package name */
    private final DisposableHandle f51267f;

    public DisposeOnCancel(DisposableHandle disposableHandle) {
        this.f51267f = disposableHandle;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void b(Throwable th) {
        this.f51267f.dispose();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        b(th);
        return Unit.f50853a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f51267f + ']';
    }
}
