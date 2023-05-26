package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes5.dex */
public class LockFreeTaskQueue<E> {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f51810a = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public LockFreeTaskQueue(boolean z7) {
        this._cur = new LockFreeTaskQueueCore(8, z7);
    }

    public final boolean a(E e8) {
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._cur;
            int a8 = lockFreeTaskQueueCore.a(e8);
            if (a8 == 0) {
                return true;
            }
            if (a8 != 1) {
                if (a8 == 2) {
                    return false;
                }
            } else {
                a.a(f51810a, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.i());
            }
        }
    }

    public final void b() {
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._cur;
            if (lockFreeTaskQueueCore.d()) {
                return;
            }
            a.a(f51810a, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.i());
        }
    }

    public final int c() {
        return ((LockFreeTaskQueueCore) this._cur).f();
    }

    public final E d() {
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._cur;
            E e8 = (E) lockFreeTaskQueueCore.j();
            if (e8 != LockFreeTaskQueueCore.f51814h) {
                return e8;
            }
            a.a(f51810a, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.i());
        }
    }
}
