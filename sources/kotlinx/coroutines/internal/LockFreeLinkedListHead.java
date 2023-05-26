package kotlinx.coroutines.internal;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes5.dex */
public class LockFreeLinkedListHead extends LockFreeLinkedListNode {
    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public boolean P() {
        return false;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public /* bridge */ /* synthetic */ boolean Q() {
        return ((Boolean) W()).booleanValue();
    }

    public final boolean V() {
        if (K() == this) {
            return true;
        }
        return false;
    }

    public final Void W() {
        throw new IllegalStateException("head cannot be removed".toString());
    }
}
