package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* compiled from: Select.kt */
/* loaded from: classes5.dex */
public interface SelectInstance<R> {
    boolean g();

    void k(DisposableHandle disposableHandle);

    Object m(LockFreeLinkedListNode.PrepareOp prepareOp);

    boolean n();

    Continuation<R> q();

    void u(Throwable th);

    Object v(AtomicDesc atomicDesc);
}
