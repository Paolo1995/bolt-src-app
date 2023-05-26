package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlinx.coroutines.DebugStringsKt;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes5.dex */
public class LockFreeLinkedListNode {

    /* renamed from: f  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f51798f = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");

    /* renamed from: g  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f51799g = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");

    /* renamed from: h  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f51800h = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes5.dex */
    public static abstract class AbstractAtomicDesc extends AtomicDesc {
        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final void a(AtomicOp<?> atomicOp, Object obj) {
            boolean z7;
            LockFreeLinkedListNode i8;
            Object obj2;
            if (obj == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            LockFreeLinkedListNode h8 = h();
            if (h8 == null || (i8 = i()) == null) {
                return;
            }
            if (z7) {
                obj2 = n(h8, i8);
            } else {
                obj2 = i8;
            }
            if (a.a(LockFreeLinkedListNode.f51798f, h8, atomicOp, obj2) && z7) {
                f(h8, i8);
            }
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final Object c(AtomicOp<?> atomicOp) {
            while (true) {
                LockFreeLinkedListNode m8 = m(atomicOp);
                if (m8 == null) {
                    return AtomicKt.f51775b;
                }
                Object obj = m8._next;
                if (obj == atomicOp || atomicOp.h()) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    OpDescriptor opDescriptor = (OpDescriptor) obj;
                    if (atomicOp.b(opDescriptor)) {
                        return AtomicKt.f51775b;
                    }
                    opDescriptor.c(m8);
                } else {
                    Object e8 = e(m8);
                    if (e8 != null) {
                        return e8;
                    }
                    if (l(m8, obj)) {
                        continue;
                    } else {
                        PrepareOp prepareOp = new PrepareOp(m8, (LockFreeLinkedListNode) obj, this);
                        if (a.a(LockFreeLinkedListNode.f51798f, m8, obj, prepareOp)) {
                            try {
                                if (prepareOp.c(m8) != LockFreeLinkedList_commonKt.f51809a) {
                                    return null;
                                }
                            } catch (Throwable th) {
                                a.a(LockFreeLinkedListNode.f51798f, m8, prepareOp, obj);
                                throw th;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        protected Object e(LockFreeLinkedListNode lockFreeLinkedListNode) {
            return null;
        }

        protected abstract void f(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2);

        public abstract void g(PrepareOp prepareOp);

        protected abstract LockFreeLinkedListNode h();

        protected abstract LockFreeLinkedListNode i();

        public Object j(PrepareOp prepareOp) {
            g(prepareOp);
            return null;
        }

        public void k(LockFreeLinkedListNode lockFreeLinkedListNode) {
        }

        protected boolean l(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            return false;
        }

        protected LockFreeLinkedListNode m(OpDescriptor opDescriptor) {
            LockFreeLinkedListNode h8 = h();
            Intrinsics.c(h8);
            return h8;
        }

        public abstract Object n(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2);
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes5.dex */
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {

        /* renamed from: b  reason: collision with root package name */
        public final LockFreeLinkedListNode f51801b;

        /* renamed from: c  reason: collision with root package name */
        public LockFreeLinkedListNode f51802c;

        public CondAddOp(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.f51801b = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        /* renamed from: j */
        public void d(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            boolean z7;
            LockFreeLinkedListNode lockFreeLinkedListNode2;
            if (obj == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                lockFreeLinkedListNode2 = this.f51801b;
            } else {
                lockFreeLinkedListNode2 = this.f51802c;
            }
            if (lockFreeLinkedListNode2 != null && a.a(LockFreeLinkedListNode.f51798f, lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z7) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.f51801b;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.f51802c;
                Intrinsics.c(lockFreeLinkedListNode4);
                lockFreeLinkedListNode3.J(lockFreeLinkedListNode4);
            }
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes5.dex */
    public static final class PrepareOp extends OpDescriptor {

        /* renamed from: a  reason: collision with root package name */
        public final LockFreeLinkedListNode f51803a;

        /* renamed from: b  reason: collision with root package name */
        public final LockFreeLinkedListNode f51804b;

        /* renamed from: c  reason: collision with root package name */
        public final AbstractAtomicDesc f51805c;

        public PrepareOp(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, AbstractAtomicDesc abstractAtomicDesc) {
            this.f51803a = lockFreeLinkedListNode;
            this.f51804b = lockFreeLinkedListNode2;
            this.f51805c = abstractAtomicDesc;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public AtomicOp<?> a() {
            return this.f51805c.b();
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public Object c(Object obj) {
            Object f8;
            Object obj2;
            if (obj != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                Object j8 = this.f51805c.j(this);
                Object obj3 = LockFreeLinkedList_commonKt.f51809a;
                if (j8 == obj3) {
                    LockFreeLinkedListNode lockFreeLinkedListNode2 = this.f51804b;
                    if (a.a(LockFreeLinkedListNode.f51798f, lockFreeLinkedListNode, this, lockFreeLinkedListNode2.T())) {
                        this.f51805c.k(lockFreeLinkedListNode);
                        lockFreeLinkedListNode2.H(null);
                    }
                    return obj3;
                }
                if (j8 != null) {
                    f8 = a().e(j8);
                } else {
                    f8 = a().f();
                }
                if (f8 == AtomicKt.f51774a) {
                    obj2 = a();
                } else if (f8 == null) {
                    obj2 = this.f51805c.n(lockFreeLinkedListNode, this.f51804b);
                } else {
                    obj2 = this.f51804b;
                }
                a.a(LockFreeLinkedListNode.f51798f, lockFreeLinkedListNode, this, obj2);
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        }

        public final void d() {
            this.f51805c.g(this);
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public String toString() {
            return "PrepareOp(op=" + a() + ')';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes5.dex */
    public static class RemoveFirstDesc<T> extends AbstractAtomicDesc {

        /* renamed from: c  reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f51806c = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_affectedNode");

        /* renamed from: d  reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f51807d = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_originalNext");
        private volatile /* synthetic */ Object _affectedNode = null;
        private volatile /* synthetic */ Object _originalNext = null;

        /* renamed from: b  reason: collision with root package name */
        public final LockFreeLinkedListNode f51808b;

        public RemoveFirstDesc(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.f51808b = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object e(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode == this.f51808b) {
                return LockFreeLinkedListKt.b();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final void f(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            lockFreeLinkedListNode2.H(null);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void g(PrepareOp prepareOp) {
            a.a(f51806c, this, null, prepareOp.f51803a);
            a.a(f51807d, this, null, prepareOp.f51804b);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode h() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode i() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final boolean l(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            if (!(obj instanceof Removed)) {
                return false;
            }
            ((Removed) obj).f51829a.O();
            return true;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode m(OpDescriptor opDescriptor) {
            LockFreeLinkedListNode lockFreeLinkedListNode = this.f51808b;
            while (true) {
                Object obj = lockFreeLinkedListNode._next;
                if (obj instanceof OpDescriptor) {
                    OpDescriptor opDescriptor2 = (OpDescriptor) obj;
                    if (opDescriptor.b(opDescriptor2)) {
                        return null;
                    }
                    opDescriptor2.c(this.f51808b);
                } else {
                    return (LockFreeLinkedListNode) obj;
                }
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object n(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            return lockFreeLinkedListNode2.T();
        }

        public final T o() {
            T t7 = (T) h();
            Intrinsics.c(t7);
            return t7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
        if (androidx.concurrent.futures.a.a(kotlinx.coroutines.internal.LockFreeLinkedListNode.f51798f, r3, r2, ((kotlinx.coroutines.internal.Removed) r4).f51829a) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode H(kotlinx.coroutines.internal.OpDescriptor r8) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f51799g
            boolean r0 = androidx.concurrent.futures.a.a(r1, r7, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r7.P()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r8) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.OpDescriptor
            if (r5 == 0) goto L38
            if (r8 == 0) goto L32
            r0 = r4
            kotlinx.coroutines.internal.OpDescriptor r0 = (kotlinx.coroutines.internal.OpDescriptor) r0
            boolean r0 = r8.b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            kotlinx.coroutines.internal.OpDescriptor r4 = (kotlinx.coroutines.internal.OpDescriptor) r4
            r4.c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.Removed
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f51798f
            kotlinx.coroutines.internal.Removed r4 = (kotlinx.coroutines.internal.Removed) r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = r4.f51829a
            boolean r2 = androidx.concurrent.futures.a.a(r5, r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto L7
        L52:
            r3 = r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.H(kotlinx.coroutines.internal.OpDescriptor):kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    private final LockFreeLinkedListNode I(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.P()) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListNode._prev;
        }
        return lockFreeLinkedListNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) lockFreeLinkedListNode._prev;
            if (K() != lockFreeLinkedListNode) {
                return;
            }
        } while (!a.a(f51799g, lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (P()) {
            lockFreeLinkedListNode.H(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Removed T() {
        Removed removed = (Removed) this._removedRef;
        if (removed == null) {
            Removed removed2 = new Removed(this);
            f51800h.lazySet(this, removed2);
            return removed2;
        }
        return removed;
    }

    public final void D(LockFreeLinkedListNode lockFreeLinkedListNode) {
        do {
        } while (!M().E(lockFreeLinkedListNode, this));
    }

    public final boolean E(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        f51799g.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51798f;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        if (!a.a(atomicReferenceFieldUpdater, this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
            return false;
        }
        lockFreeLinkedListNode.J(lockFreeLinkedListNode2);
        return true;
    }

    public final boolean F(LockFreeLinkedListNode lockFreeLinkedListNode) {
        f51799g.lazySet(lockFreeLinkedListNode, this);
        f51798f.lazySet(lockFreeLinkedListNode, this);
        while (K() == this) {
            if (a.a(f51798f, this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.J(this);
                return true;
            }
        }
        return false;
    }

    public final Object K() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).c(this);
        }
    }

    public final LockFreeLinkedListNode L() {
        return LockFreeLinkedListKt.c(K());
    }

    public final LockFreeLinkedListNode M() {
        LockFreeLinkedListNode H = H(null);
        if (H == null) {
            return I((LockFreeLinkedListNode) this._prev);
        }
        return H;
    }

    public final void N() {
        ((Removed) K()).f51829a.O();
    }

    public final void O() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        while (true) {
            Object K = lockFreeLinkedListNode.K();
            if (K instanceof Removed) {
                lockFreeLinkedListNode = ((Removed) K).f51829a;
            } else {
                lockFreeLinkedListNode.H(null);
                return;
            }
        }
    }

    public boolean P() {
        return K() instanceof Removed;
    }

    public boolean Q() {
        if (S() == null) {
            return true;
        }
        return false;
    }

    public final LockFreeLinkedListNode R() {
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) K();
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            if (lockFreeLinkedListNode.Q()) {
                return lockFreeLinkedListNode;
            }
            lockFreeLinkedListNode.N();
        }
    }

    public final LockFreeLinkedListNode S() {
        Object K;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            K = K();
            if (K instanceof Removed) {
                return ((Removed) K).f51829a;
            }
            if (K == this) {
                return (LockFreeLinkedListNode) K;
            }
            lockFreeLinkedListNode = (LockFreeLinkedListNode) K;
        } while (!a.a(f51798f, this, K, lockFreeLinkedListNode.T()));
        lockFreeLinkedListNode.H(null);
        return null;
    }

    public final int U(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, CondAddOp condAddOp) {
        f51799g.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51798f;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        condAddOp.f51802c = lockFreeLinkedListNode2;
        if (!a.a(atomicReferenceFieldUpdater, this, lockFreeLinkedListNode2, condAddOp)) {
            return 0;
        }
        if (condAddOp.c(this) == null) {
            return 1;
        }
        return 2;
    }

    public String toString() {
        return new PropertyReference0Impl(this) { // from class: kotlinx.coroutines.internal.LockFreeLinkedListNode$toString$1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return DebugStringsKt.a(this.f50989g);
            }
        } + '@' + DebugStringsKt.b(this);
    }
}
