package kotlinx.coroutines.selects;

import androidx.concurrent.futures.a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellingNode;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* compiled from: Select.kt */
/* loaded from: classes5.dex */
public final class SelectBuilderImpl<R> extends LockFreeLinkedListHead implements SelectBuilder<R>, SelectInstance<R>, Continuation<R>, CoroutineStackFrame {

    /* renamed from: j  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f51976j = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_state");

    /* renamed from: k  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f51977k = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_result");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _result;
    volatile /* synthetic */ Object _state = SelectKt.e();

    /* renamed from: i  reason: collision with root package name */
    private final Continuation<R> f51978i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Select.kt */
    /* loaded from: classes5.dex */
    public static final class AtomicSelectOp extends AtomicOp<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final SelectBuilderImpl<?> f51981b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicDesc f51982c;

        /* renamed from: d  reason: collision with root package name */
        private final long f51983d;

        public AtomicSelectOp(SelectBuilderImpl<?> selectBuilderImpl, AtomicDesc atomicDesc) {
            SeqNumber seqNumber;
            this.f51981b = selectBuilderImpl;
            this.f51982c = atomicDesc;
            seqNumber = SelectKt.f51991e;
            this.f51983d = seqNumber.a();
            atomicDesc.d(this);
        }

        private final void j(Object obj) {
            boolean z7;
            Object e8;
            if (obj == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                e8 = null;
            } else {
                e8 = SelectKt.e();
            }
            if (a.a(SelectBuilderImpl.f51976j, this.f51981b, this, e8) && z7) {
                this.f51981b.Y();
            }
        }

        private final Object k() {
            SelectBuilderImpl<?> selectBuilderImpl = this.f51981b;
            while (true) {
                Object obj = selectBuilderImpl._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).c(this.f51981b);
                } else if (obj == SelectKt.e()) {
                    if (a.a(SelectBuilderImpl.f51976j, this.f51981b, SelectKt.e(), this)) {
                        return null;
                    }
                } else {
                    return SelectKt.d();
                }
            }
        }

        private final void l() {
            a.a(SelectBuilderImpl.f51976j, this.f51981b, this, SelectKt.e());
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void d(Object obj, Object obj2) {
            j(obj2);
            this.f51982c.a(this, obj2);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public long g() {
            return this.f51983d;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public Object i(Object obj) {
            Object k8;
            if (obj == null && (k8 = k()) != null) {
                return k8;
            }
            try {
                return this.f51982c.c(this);
            } catch (Throwable th) {
                if (obj == null) {
                    l();
                }
                throw th;
            }
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public String toString() {
            return "AtomicSelectOp(sequence=" + g() + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Select.kt */
    /* loaded from: classes5.dex */
    public static final class DisposeNode extends LockFreeLinkedListNode {

        /* renamed from: i  reason: collision with root package name */
        public final DisposableHandle f51984i;

        public DisposeNode(DisposableHandle disposableHandle) {
            this.f51984i = disposableHandle;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Select.kt */
    /* loaded from: classes5.dex */
    public static final class PairSelectOp extends OpDescriptor {

        /* renamed from: a  reason: collision with root package name */
        public final LockFreeLinkedListNode.PrepareOp f51985a;

        public PairSelectOp(LockFreeLinkedListNode.PrepareOp prepareOp) {
            this.f51985a = prepareOp;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public AtomicOp<?> a() {
            return this.f51985a.a();
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public Object c(Object obj) {
            Object e8;
            if (obj != null) {
                SelectBuilderImpl selectBuilderImpl = (SelectBuilderImpl) obj;
                this.f51985a.d();
                Object e9 = this.f51985a.a().e(null);
                if (e9 == null) {
                    e8 = this.f51985a.f51805c;
                } else {
                    e8 = SelectKt.e();
                }
                a.a(SelectBuilderImpl.f51976j, selectBuilderImpl, this, e8);
                return e9;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Select.kt */
    /* loaded from: classes5.dex */
    public final class SelectOnCancelling extends JobCancellingNode {
        public SelectOnCancelling() {
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        public void V(Throwable th) {
            if (SelectBuilderImpl.this.n()) {
                SelectBuilderImpl.this.u(W().I());
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            V(th);
            return Unit.f50853a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectBuilderImpl(Continuation<? super R> continuation) {
        Object obj;
        this.f51978i = continuation;
        obj = SelectKt.f51989c;
        this._result = obj;
        this._parentHandle = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y() {
        DisposableHandle Z = Z();
        if (Z != null) {
            Z.dispose();
        }
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) K(); !Intrinsics.a(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.L()) {
            if (lockFreeLinkedListNode instanceof DisposeNode) {
                ((DisposeNode) lockFreeLinkedListNode).f51984i.dispose();
            }
        }
    }

    private final DisposableHandle Z() {
        return (DisposableHandle) this._parentHandle;
    }

    private final void c0() {
        Job job = (Job) getContext().g(Job.f51296d);
        if (job == null) {
            return;
        }
        DisposableHandle d8 = Job.DefaultImpls.d(job, true, false, new SelectOnCancelling(), 2, null);
        d0(d8);
        if (g()) {
            d8.dispose();
        }
    }

    private final void d0(DisposableHandle disposableHandle) {
        this._parentHandle = disposableHandle;
    }

    public final Object a0() {
        Object obj;
        Object obj2;
        Object obj3;
        Object d8;
        Object d9;
        if (!g()) {
            c0();
        }
        Object obj4 = this._result;
        obj = SelectKt.f51989c;
        if (obj4 == obj) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51977k;
            obj3 = SelectKt.f51989c;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            if (a.a(atomicReferenceFieldUpdater, this, obj3, d8)) {
                d9 = IntrinsicsKt__IntrinsicsKt.d();
                return d9;
            }
            obj4 = this._result;
        }
        obj2 = SelectKt.f51990d;
        if (obj4 != obj2) {
            if (!(obj4 instanceof CompletedExceptionally)) {
                return obj4;
            }
            throw ((CompletedExceptionally) obj4).f51234a;
        }
        throw new IllegalStateException("Already resumed");
    }

    public final void b0(Throwable th) {
        if (n()) {
            Result.Companion companion = Result.f50818g;
            resumeWith(Result.b(ResultKt.a(th)));
        } else if (!(th instanceof CancellationException)) {
            Object a02 = a0();
            if (!(a02 instanceof CompletedExceptionally) || ((CompletedExceptionally) a02).f51234a != th) {
                CoroutineExceptionHandlerKt.a(getContext(), th);
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean g() {
        while (true) {
            Object obj = this._state;
            if (obj == SelectKt.e()) {
                return false;
            }
            if (obj instanceof OpDescriptor) {
                ((OpDescriptor) obj).c(this);
            } else {
                return true;
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<R> continuation = this.f51978i;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f51978i.getContext();
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void h(long j8, final Function1<? super Continuation<? super R>, ? extends Object> function1) {
        if (j8 <= 0) {
            if (n()) {
                UndispatchedKt.b(function1, q());
                return;
            }
            return;
        }
        k(DelayKt.b(getContext()).Y(j8, new Runnable() { // from class: kotlinx.coroutines.selects.SelectBuilderImpl$onTimeout$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                if (SelectBuilderImpl.this.n()) {
                    CancellableKt.c(function1, SelectBuilderImpl.this.q());
                }
            }
        }, getContext()));
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void k(DisposableHandle disposableHandle) {
        DisposeNode disposeNode = new DisposeNode(disposableHandle);
        if (!g()) {
            D(disposeNode);
            if (!g()) {
                return;
            }
        }
        disposableHandle.dispose();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
        Y();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
        return kotlinx.coroutines.CancellableContinuationImplKt.f51224a;
     */
    @Override // kotlinx.coroutines.selects.SelectInstance
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object m(kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp r4) {
        /*
            r3 = this;
        L0:
            java.lang.Object r0 = r3._state
            java.lang.Object r1 = kotlinx.coroutines.selects.SelectKt.e()
            r2 = 0
            if (r0 != r1) goto L36
            if (r4 != 0) goto L18
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.selects.SelectBuilderImpl.f51976j
            java.lang.Object r1 = kotlinx.coroutines.selects.SelectKt.e()
            boolean r0 = androidx.concurrent.futures.a.a(r0, r3, r1, r2)
            if (r0 != 0) goto L30
            goto L0
        L18:
            kotlinx.coroutines.selects.SelectBuilderImpl$PairSelectOp r0 = new kotlinx.coroutines.selects.SelectBuilderImpl$PairSelectOp
            r0.<init>(r4)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.selects.SelectBuilderImpl.f51976j
            java.lang.Object r2 = kotlinx.coroutines.selects.SelectKt.e()
            boolean r1 = androidx.concurrent.futures.a.a(r1, r3, r2, r0)
            if (r1 == 0) goto L0
            java.lang.Object r4 = r0.c(r3)
            if (r4 == 0) goto L30
            return r4
        L30:
            r3.Y()
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.CancellableContinuationImplKt.f51224a
            return r4
        L36:
            boolean r1 = r0 instanceof kotlinx.coroutines.internal.OpDescriptor
            if (r1 == 0) goto L6a
            if (r4 == 0) goto L64
            kotlinx.coroutines.internal.AtomicOp r1 = r4.a()
            boolean r2 = r1 instanceof kotlinx.coroutines.selects.SelectBuilderImpl.AtomicSelectOp
            if (r2 == 0) goto L58
            r2 = r1
            kotlinx.coroutines.selects.SelectBuilderImpl$AtomicSelectOp r2 = (kotlinx.coroutines.selects.SelectBuilderImpl.AtomicSelectOp) r2
            kotlinx.coroutines.selects.SelectBuilderImpl<?> r2 = r2.f51981b
            if (r2 == r3) goto L4c
            goto L58
        L4c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot use matching select clauses on the same object"
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            throw r4
        L58:
            r2 = r0
            kotlinx.coroutines.internal.OpDescriptor r2 = (kotlinx.coroutines.internal.OpDescriptor) r2
            boolean r1 = r1.b(r2)
            if (r1 == 0) goto L64
            java.lang.Object r4 = kotlinx.coroutines.internal.AtomicKt.f51775b
            return r4
        L64:
            kotlinx.coroutines.internal.OpDescriptor r0 = (kotlinx.coroutines.internal.OpDescriptor) r0
            r0.c(r3)
            goto L0
        L6a:
            if (r4 != 0) goto L6d
            return r2
        L6d:
            kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc r4 = r4.f51805c
            if (r0 != r4) goto L74
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.CancellableContinuationImplKt.f51224a
            return r4
        L74:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectBuilderImpl.m(kotlinx.coroutines.internal.LockFreeLinkedListNode$PrepareOp):java.lang.Object");
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean n() {
        Object m8 = m(null);
        if (m8 == CancellableContinuationImplKt.f51224a) {
            return true;
        }
        if (m8 == null) {
            return false;
        }
        throw new IllegalStateException(("Unexpected trySelectIdempotent result " + m8).toString());
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public Continuation<R> q() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        Object obj2;
        Object obj3;
        Object d8;
        Object d9;
        Object obj4;
        while (true) {
            Object obj5 = this._result;
            obj2 = SelectKt.f51989c;
            if (obj5 == obj2) {
                Object d10 = CompletionStateKt.d(obj, null, 1, null);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51977k;
                obj3 = SelectKt.f51989c;
                if (a.a(atomicReferenceFieldUpdater, this, obj3, d10)) {
                    return;
                }
            } else {
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                if (obj5 == d8) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f51977k;
                    d9 = IntrinsicsKt__IntrinsicsKt.d();
                    obj4 = SelectKt.f51990d;
                    if (a.a(atomicReferenceFieldUpdater2, this, d9, obj4)) {
                        if (Result.g(obj)) {
                            Continuation<R> continuation = this.f51978i;
                            Throwable e8 = Result.e(obj);
                            Intrinsics.c(e8);
                            continuation.resumeWith(Result.b(ResultKt.a(e8)));
                            return;
                        }
                        this.f51978i.resumeWith(obj);
                        return;
                    }
                } else {
                    throw new IllegalStateException("Already resumed");
                }
            }
        }
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return "SelectInstance(state=" + this._state + ", result=" + this._result + ')';
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void u(Throwable th) {
        Object obj;
        Object obj2;
        Object d8;
        Object d9;
        Object obj3;
        Continuation c8;
        while (true) {
            Object obj4 = this._result;
            obj = SelectKt.f51989c;
            if (obj4 == obj) {
                CompletedExceptionally completedExceptionally = new CompletedExceptionally(th, false, 2, null);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51977k;
                obj2 = SelectKt.f51989c;
                if (a.a(atomicReferenceFieldUpdater, this, obj2, completedExceptionally)) {
                    return;
                }
            } else {
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                if (obj4 == d8) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f51977k;
                    d9 = IntrinsicsKt__IntrinsicsKt.d();
                    obj3 = SelectKt.f51990d;
                    if (a.a(atomicReferenceFieldUpdater2, this, d9, obj3)) {
                        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(this.f51978i);
                        Result.Companion companion = Result.f50818g;
                        c8.resumeWith(Result.b(ResultKt.a(th)));
                        return;
                    }
                } else {
                    throw new IllegalStateException("Already resumed");
                }
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public Object v(AtomicDesc atomicDesc) {
        return new AtomicSelectOp(this, atomicDesc).c(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void x(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause1.n(this, function2);
    }
}
