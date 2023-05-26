package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;

/* compiled from: ConcurrentLinkedList.kt */
/* loaded from: classes5.dex */
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f51779a = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_next");

    /* renamed from: b  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f51780b = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_prev");
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ Object _prev;

    public ConcurrentLinkedListNode(N n8) {
        this._prev = n8;
    }

    private final N c() {
        N f8 = f();
        while (f8 != null && f8.g()) {
            f8 = (N) f8._prev;
        }
        return f8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e() {
        return this._next;
    }

    private final N h() {
        N d8 = d();
        Intrinsics.c(d8);
        while (d8.g()) {
            d8 = (N) d8.d();
            Intrinsics.c(d8);
        }
        return d8;
    }

    public final void b() {
        f51780b.lazySet(this, null);
    }

    public final N d() {
        Symbol symbol;
        Object e8 = e();
        symbol = ConcurrentLinkedListKt.f51778a;
        if (e8 == symbol) {
            return null;
        }
        return (N) e8;
    }

    public final N f() {
        return (N) this._prev;
    }

    public abstract boolean g();

    public final boolean i() {
        if (d() == null) {
            return true;
        }
        return false;
    }

    public final void j() {
        while (true) {
            N c8 = c();
            N h8 = h();
            h8._prev = c8;
            if (c8 != null) {
                c8._next = h8;
            }
            if (!h8.g() && (c8 == null || !c8.g())) {
                return;
            }
        }
    }

    public final boolean k(N n8) {
        return a.a(f51779a, this, null, n8);
    }
}
