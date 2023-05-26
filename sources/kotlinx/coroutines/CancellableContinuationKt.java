package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* compiled from: CancellableContinuation.kt */
/* loaded from: classes5.dex */
public final class CancellableContinuationKt {
    public static final void a(CancellableContinuation<?> cancellableContinuation, DisposableHandle disposableHandle) {
        cancellableContinuation.o(new DisposeOnCancel(disposableHandle));
    }

    public static final <T> CancellableContinuationImpl<T> b(Continuation<? super T> continuation) {
        if (!(continuation instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl<>(continuation, 1);
        }
        CancellableContinuationImpl<T> j8 = ((DispatchedContinuation) continuation).j();
        if (j8 != null) {
            if (!j8.J()) {
                j8 = null;
            }
            if (j8 != null) {
                return j8;
            }
        }
        return new CancellableContinuationImpl<>(continuation, 2);
    }

    public static final void c(CancellableContinuation<?> cancellableContinuation, LockFreeLinkedListNode lockFreeLinkedListNode) {
        cancellableContinuation.o(new RemoveOnCancel(lockFreeLinkedListNode));
    }
}
