package kotlinx.coroutines;

import kotlin.Unit;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* compiled from: CancellableContinuation.kt */
/* loaded from: classes5.dex */
final class RemoveOnCancel extends BeforeResumeCancelHandler {

    /* renamed from: f  reason: collision with root package name */
    private final LockFreeLinkedListNode f51325f;

    public RemoveOnCancel(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.f51325f = lockFreeLinkedListNode;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void b(Throwable th) {
        this.f51325f.Q();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        b(th);
        return Unit.f50853a;
    }

    public String toString() {
        return "RemoveOnCancel[" + this.f51325f + ']';
    }
}
