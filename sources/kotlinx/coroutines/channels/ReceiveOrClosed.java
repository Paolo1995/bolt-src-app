package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes5.dex */
public interface ReceiveOrClosed<E> {
    Object b();

    void j(E e8);

    Symbol w(E e8, LockFreeLinkedListNode.PrepareOp prepareOp);
}
