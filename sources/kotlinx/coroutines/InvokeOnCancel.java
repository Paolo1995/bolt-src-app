package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes5.dex */
final class InvokeOnCancel extends CancelHandler {

    /* renamed from: f  reason: collision with root package name */
    private final Function1<Throwable, Unit> f51292f;

    /* JADX WARN: Multi-variable type inference failed */
    public InvokeOnCancel(Function1<? super Throwable, Unit> function1) {
        this.f51292f = function1;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void b(Throwable th) {
        this.f51292f.invoke(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        b(th);
        return Unit.f50853a;
    }

    public String toString() {
        return "InvokeOnCancel[" + DebugStringsKt.a(this.f51292f) + '@' + DebugStringsKt.b(this) + ']';
    }
}
