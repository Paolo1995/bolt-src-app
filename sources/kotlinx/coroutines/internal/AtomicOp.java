package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: Atomic.kt */
/* loaded from: classes5.dex */
public abstract class AtomicOp<T> extends OpDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f51776a = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = AtomicKt.f51774a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    public AtomicOp<?> a() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    public final Object c(Object obj) {
        Object obj2 = this._consensus;
        if (obj2 == AtomicKt.f51774a) {
            obj2 = e(i(obj));
        }
        d(obj, obj2);
        return obj2;
    }

    public abstract void d(T t7, Object obj);

    public final Object e(Object obj) {
        Object obj2 = this._consensus;
        Object obj3 = AtomicKt.f51774a;
        if (obj2 != obj3) {
            return obj2;
        }
        if (a.a(f51776a, this, obj3, obj)) {
            return obj;
        }
        return this._consensus;
    }

    public final Object f() {
        return this._consensus;
    }

    public long g() {
        return 0L;
    }

    public final boolean h() {
        if (this._consensus != AtomicKt.f51774a) {
            return true;
        }
        return false;
    }

    public abstract Object i(T t7);
}
