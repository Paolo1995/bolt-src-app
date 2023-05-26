package kotlinx.coroutines.sync;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: Mutex.kt */
/* loaded from: classes5.dex */
public final class MutexImpl implements Mutex {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f51998a = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    volatile /* synthetic */ Object _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    /* loaded from: classes5.dex */
    public final class LockCont extends LockWaiter {

        /* renamed from: l  reason: collision with root package name */
        private final CancellableContinuation<Unit> f51999l;

        /* JADX WARN: Multi-variable type inference failed */
        public LockCont(Object obj, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(obj);
            this.f51999l = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public void V() {
            this.f51999l.G(CancellableContinuationImplKt.f51224a);
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public boolean X() {
            if (!W()) {
                return false;
            }
            CancellableContinuation<Unit> cancellableContinuation = this.f51999l;
            Unit unit = Unit.f50853a;
            final MutexImpl mutexImpl = MutexImpl.this;
            if (cancellableContinuation.B(unit, null, new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$LockCont$tryResumeLockWaiter$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    MutexImpl.this.b(this.f52004i);
                }
            }) == null) {
                return false;
            }
            return true;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockCont[" + this.f52004i + ", " + this.f51999l + "] for " + MutexImpl.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    /* loaded from: classes5.dex */
    public abstract class LockWaiter extends LockFreeLinkedListNode implements DisposableHandle {

        /* renamed from: k  reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f52003k = AtomicIntegerFieldUpdater.newUpdater(LockWaiter.class, "isTaken");

        /* renamed from: i  reason: collision with root package name */
        public final Object f52004i;
        private volatile /* synthetic */ int isTaken = 0;

        public LockWaiter(Object obj) {
            this.f52004i = obj;
        }

        public abstract void V();

        public final boolean W() {
            return f52003k.compareAndSet(this, 0, 1);
        }

        public abstract boolean X();

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    /* loaded from: classes5.dex */
    public static final class LockedQueue extends LockFreeLinkedListHead {
        public volatile Object owner;

        public LockedQueue(Object obj) {
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockedQueue[" + this.owner + ']';
        }
    }

    /* compiled from: Mutex.kt */
    /* loaded from: classes5.dex */
    private static final class UnlockOp extends AtomicOp<MutexImpl> {

        /* renamed from: b  reason: collision with root package name */
        public final LockedQueue f52006b;

        public UnlockOp(LockedQueue lockedQueue) {
            this.f52006b = lockedQueue;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        /* renamed from: j */
        public void d(MutexImpl mutexImpl, Object obj) {
            Object obj2;
            if (obj == null) {
                obj2 = MutexKt.f52014f;
            } else {
                obj2 = this.f52006b;
            }
            a.a(MutexImpl.f51998a, mutexImpl, this, obj2);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        /* renamed from: k */
        public Object i(MutexImpl mutexImpl) {
            Symbol symbol;
            if (!this.f52006b.V()) {
                symbol = MutexKt.f52010b;
                return symbol;
            }
            return null;
        }
    }

    public MutexImpl(boolean z7) {
        this._state = z7 ? MutexKt.f52013e : MutexKt.f52014f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
        kotlinx.coroutines.CancellableContinuationKt.c(r0, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object c(final java.lang.Object r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r8)
            kotlinx.coroutines.CancellableContinuationImpl r0 = kotlinx.coroutines.CancellableContinuationKt.b(r0)
            kotlinx.coroutines.sync.MutexImpl$LockCont r1 = new kotlinx.coroutines.sync.MutexImpl$LockCont
            r1.<init>(r7, r0)
        Ld:
            java.lang.Object r2 = r6._state
            boolean r3 = r2 instanceof kotlinx.coroutines.sync.Empty
            if (r3 == 0) goto L4a
            r3 = r2
            kotlinx.coroutines.sync.Empty r3 = (kotlinx.coroutines.sync.Empty) r3
            java.lang.Object r4 = r3.f51997a
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.sync.MutexKt.f()
            if (r4 == r5) goto L2b
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.sync.MutexImpl.f51998a
            kotlinx.coroutines.sync.MutexImpl$LockedQueue r5 = new kotlinx.coroutines.sync.MutexImpl$LockedQueue
            java.lang.Object r3 = r3.f51997a
            r5.<init>(r3)
            androidx.concurrent.futures.a.a(r4, r6, r2, r5)
            goto Ld
        L2b:
            if (r7 != 0) goto L32
            kotlinx.coroutines.sync.Empty r3 = kotlinx.coroutines.sync.MutexKt.c()
            goto L37
        L32:
            kotlinx.coroutines.sync.Empty r3 = new kotlinx.coroutines.sync.Empty
            r3.<init>(r7)
        L37:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.sync.MutexImpl.f51998a
            boolean r2 = androidx.concurrent.futures.a.a(r4, r6, r2, r3)
            if (r2 == 0) goto Ld
            kotlin.Unit r1 = kotlin.Unit.f50853a
            kotlinx.coroutines.sync.MutexImpl$lockSuspend$2$1$1 r2 = new kotlinx.coroutines.sync.MutexImpl$lockSuspend$2$1$1
            r2.<init>()
            r0.r(r1, r2)
            goto L71
        L4a:
            boolean r3 = r2 instanceof kotlinx.coroutines.sync.MutexImpl.LockedQueue
            if (r3 == 0) goto La3
            r3 = r2
            kotlinx.coroutines.sync.MutexImpl$LockedQueue r3 = (kotlinx.coroutines.sync.MutexImpl.LockedQueue) r3
            java.lang.Object r4 = r3.owner
            if (r4 == r7) goto L57
            r4 = 1
            goto L58
        L57:
            r4 = 0
        L58:
            if (r4 == 0) goto L88
            r3.D(r1)
            java.lang.Object r3 = r6._state
            if (r3 == r2) goto L6e
            boolean r2 = r1.W()
            if (r2 != 0) goto L68
            goto L6e
        L68:
            kotlinx.coroutines.sync.MutexImpl$LockCont r1 = new kotlinx.coroutines.sync.MutexImpl$LockCont
            r1.<init>(r7, r0)
            goto Ld
        L6e:
            kotlinx.coroutines.CancellableContinuationKt.c(r0, r1)
        L71:
            java.lang.Object r7 = r0.v()
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            if (r7 != r0) goto L7e
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r8)
        L7e:
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            if (r7 != r8) goto L85
            return r7
        L85:
            kotlin.Unit r7 = kotlin.Unit.f50853a
            return r7
        L88:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Already locked by "
            r8.append(r0)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        La3:
            boolean r3 = r2 instanceof kotlinx.coroutines.internal.OpDescriptor
            if (r3 == 0) goto Lae
            kotlinx.coroutines.internal.OpDescriptor r2 = (kotlinx.coroutines.internal.OpDescriptor) r2
            r2.c(r6)
            goto Ld
        Lae:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Illegal state "
            r8.append(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexImpl.c(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public Object a(Object obj, Continuation<? super Unit> continuation) {
        Object d8;
        if (d(obj)) {
            return Unit.f50853a;
        }
        Object c8 = c(obj, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (c8 == d8) {
            return c8;
        }
        return Unit.f50853a;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void b(Object obj) {
        Empty empty;
        Symbol symbol;
        while (true) {
            Object obj2 = this._state;
            boolean z7 = true;
            if (obj2 instanceof Empty) {
                if (obj == null) {
                    Object obj3 = ((Empty) obj2).f51997a;
                    symbol = MutexKt.f52012d;
                    if (obj3 == symbol) {
                        z7 = false;
                    }
                    if (!z7) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    Empty empty2 = (Empty) obj2;
                    if (empty2.f51997a != obj) {
                        z7 = false;
                    }
                    if (!z7) {
                        throw new IllegalStateException(("Mutex is locked by " + empty2.f51997a + " but expected " + obj).toString());
                    }
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51998a;
                empty = MutexKt.f52014f;
                if (a.a(atomicReferenceFieldUpdater, this, obj2, empty)) {
                    return;
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).c(this);
            } else if (obj2 instanceof LockedQueue) {
                if (obj != null) {
                    LockedQueue lockedQueue = (LockedQueue) obj2;
                    if (lockedQueue.owner != obj) {
                        z7 = false;
                    }
                    if (!z7) {
                        throw new IllegalStateException(("Mutex is locked by " + lockedQueue.owner + " but expected " + obj).toString());
                    }
                }
                LockedQueue lockedQueue2 = (LockedQueue) obj2;
                LockFreeLinkedListNode R = lockedQueue2.R();
                if (R == null) {
                    UnlockOp unlockOp = new UnlockOp(lockedQueue2);
                    if (a.a(f51998a, this, obj2, unlockOp) && unlockOp.c(this) == null) {
                        return;
                    }
                } else {
                    LockWaiter lockWaiter = (LockWaiter) R;
                    if (lockWaiter.X()) {
                        Object obj4 = lockWaiter.f52004i;
                        if (obj4 == null) {
                            obj4 = MutexKt.f52011c;
                        }
                        lockedQueue2.owner = obj4;
                        lockWaiter.V();
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }

    public boolean d(Object obj) {
        Symbol symbol;
        Empty empty;
        while (true) {
            Object obj2 = this._state;
            boolean z7 = true;
            if (obj2 instanceof Empty) {
                Object obj3 = ((Empty) obj2).f51997a;
                symbol = MutexKt.f52012d;
                if (obj3 != symbol) {
                    return false;
                }
                if (obj == null) {
                    empty = MutexKt.f52013e;
                } else {
                    empty = new Empty(obj);
                }
                if (a.a(f51998a, this, obj2, empty)) {
                    return true;
                }
            } else if (obj2 instanceof LockedQueue) {
                if (((LockedQueue) obj2).owner == obj) {
                    z7 = false;
                }
                if (z7) {
                    return false;
                }
                throw new IllegalStateException(("Already locked by " + obj).toString());
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).c(this);
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }

    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                return "Mutex[" + ((Empty) obj).f51997a + ']';
            } else if (obj instanceof OpDescriptor) {
                ((OpDescriptor) obj).c(this);
            } else if (obj instanceof LockedQueue) {
                return "Mutex[" + ((LockedQueue) obj).owner + ']';
            } else {
                throw new IllegalStateException(("Illegal state " + obj).toString());
            }
        }
    }
}
