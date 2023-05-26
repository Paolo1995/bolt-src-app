package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes5.dex */
public abstract class Send extends LockFreeLinkedListNode {
    public abstract void V();

    public abstract Object W();

    public abstract void X(Closed<?> closed);

    public abstract Symbol Y(LockFreeLinkedListNode.PrepareOp prepareOp);

    public void Z() {
    }
}
