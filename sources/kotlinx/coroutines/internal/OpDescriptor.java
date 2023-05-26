package kotlinx.coroutines.internal;

import kotlinx.coroutines.DebugStringsKt;

/* compiled from: Atomic.kt */
/* loaded from: classes5.dex */
public abstract class OpDescriptor {
    public abstract AtomicOp<?> a();

    public final boolean b(OpDescriptor opDescriptor) {
        AtomicOp<?> a8;
        AtomicOp<?> a9 = a();
        if (a9 == null || (a8 = opDescriptor.a()) == null || a9.g() >= a8.g()) {
            return false;
        }
        return true;
    }

    public abstract Object c(Object obj);

    public String toString() {
        return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this);
    }
}
