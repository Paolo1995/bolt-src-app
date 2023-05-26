package kotlinx.coroutines.internal;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes5.dex */
public final class LockFreeLinkedListKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f51796a = new Symbol("CONDITION_FALSE");

    /* renamed from: b  reason: collision with root package name */
    private static final Object f51797b = new Symbol("LIST_EMPTY");

    public static final Object a() {
        return f51796a;
    }

    public static final Object b() {
        return f51797b;
    }

    public static final LockFreeLinkedListNode c(Object obj) {
        Removed removed;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        if (obj instanceof Removed) {
            removed = (Removed) obj;
        } else {
            removed = null;
        }
        if (removed == null || (lockFreeLinkedListNode = removed.f51829a) == null) {
            return (LockFreeLinkedListNode) obj;
        }
        return lockFreeLinkedListNode;
    }
}
