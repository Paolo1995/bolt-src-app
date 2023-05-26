package kotlinx.coroutines.internal;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Atomic.kt */
/* loaded from: classes5.dex */
public abstract class AtomicDesc {

    /* renamed from: a  reason: collision with root package name */
    public AtomicOp<?> f51773a;

    public abstract void a(AtomicOp<?> atomicOp, Object obj);

    public final AtomicOp<?> b() {
        AtomicOp<?> atomicOp = this.f51773a;
        if (atomicOp != null) {
            return atomicOp;
        }
        Intrinsics.w("atomicOp");
        return null;
    }

    public abstract Object c(AtomicOp<?> atomicOp);

    public final void d(AtomicOp<?> atomicOp) {
        this.f51773a = atomicOp;
    }
}
