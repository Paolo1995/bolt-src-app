package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectInstance;

/* compiled from: JobSupport.kt */
/* loaded from: classes5.dex */
public class JobSupport implements Job, ChildJob, ParentJob {

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f51301f = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    /* loaded from: classes5.dex */
    public static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {

        /* renamed from: n  reason: collision with root package name */
        private final JobSupport f51304n;

        public AwaitContinuation(Continuation<? super T> continuation, JobSupport jobSupport) {
            super(continuation, 1);
            this.f51304n = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        protected String F() {
            return "AwaitContinuation";
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public Throwable u(Job job) {
            Throwable e8;
            Object r02 = this.f51304n.r0();
            if ((r02 instanceof Finishing) && (e8 = ((Finishing) r02).e()) != null) {
                return e8;
            }
            if (r02 instanceof CompletedExceptionally) {
                return ((CompletedExceptionally) r02).f51234a;
            }
            return job.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    /* loaded from: classes5.dex */
    public static final class ChildCompletion extends JobNode {

        /* renamed from: j  reason: collision with root package name */
        private final JobSupport f51305j;

        /* renamed from: k  reason: collision with root package name */
        private final Finishing f51306k;

        /* renamed from: l  reason: collision with root package name */
        private final ChildHandleNode f51307l;

        /* renamed from: m  reason: collision with root package name */
        private final Object f51308m;

        public ChildCompletion(JobSupport jobSupport, Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
            this.f51305j = jobSupport;
            this.f51306k = finishing;
            this.f51307l = childHandleNode;
            this.f51308m = obj;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        public void V(Throwable th) {
            this.f51305j.e0(this.f51306k, this.f51307l, this.f51308m);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            V(th);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    /* loaded from: classes5.dex */
    public static final class Finishing implements Incomplete {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        /* renamed from: f  reason: collision with root package name */
        private final NodeList f51309f;

        public Finishing(NodeList nodeList, boolean z7, Throwable th) {
            this.f51309f = nodeList;
            this._isCompleting = z7 ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        private final Object c() {
            return this._exceptionsHolder;
        }

        private final void k(Object obj) {
            this._exceptionsHolder = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Throwable th) {
            Throwable e8 = e();
            if (e8 == null) {
                l(th);
            } else if (th == e8) {
            } else {
                Object c8 = c();
                if (c8 == null) {
                    k(th);
                } else if (c8 instanceof Throwable) {
                    if (th == c8) {
                        return;
                    }
                    ArrayList<Throwable> b8 = b();
                    b8.add(c8);
                    b8.add(th);
                    k(b8);
                } else if (c8 instanceof ArrayList) {
                    ((ArrayList) c8).add(th);
                } else {
                    throw new IllegalStateException(("State is " + c8).toString());
                }
            }
        }

        @Override // kotlinx.coroutines.Incomplete
        public NodeList d() {
            return this.f51309f;
        }

        public final Throwable e() {
            return (Throwable) this._rootCause;
        }

        public final boolean f() {
            if (e() != null) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
        public final boolean g() {
            return this._isCompleting;
        }

        public final boolean h() {
            Symbol symbol;
            Object c8 = c();
            symbol = JobSupportKt.f51319e;
            if (c8 == symbol) {
                return true;
            }
            return false;
        }

        public final List<Throwable> i(Throwable th) {
            ArrayList<Throwable> arrayList;
            Symbol symbol;
            Object c8 = c();
            if (c8 == null) {
                arrayList = b();
            } else if (c8 instanceof Throwable) {
                ArrayList<Throwable> b8 = b();
                b8.add(c8);
                arrayList = b8;
            } else if (c8 instanceof ArrayList) {
                arrayList = (ArrayList) c8;
            } else {
                throw new IllegalStateException(("State is " + c8).toString());
            }
            Throwable e8 = e();
            if (e8 != null) {
                arrayList.add(0, e8);
            }
            if (th != null && !Intrinsics.a(th, e8)) {
                arrayList.add(th);
            }
            symbol = JobSupportKt.f51319e;
            k(symbol);
            return arrayList;
        }

        @Override // kotlinx.coroutines.Incomplete
        public boolean isActive() {
            if (e() == null) {
                return true;
            }
            return false;
        }

        public final void j(boolean z7) {
            this._isCompleting = z7 ? 1 : 0;
        }

        public final void l(Throwable th) {
            this._rootCause = th;
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + c() + ", list=" + d() + ']';
        }
    }

    public JobSupport(boolean z7) {
        this._state = z7 ? JobSupportKt.f51321g : JobSupportKt.f51320f;
        this._parentHandle = null;
    }

    private final Object A0(Continuation<? super Unit> continuation) {
        Continuation c8;
        Object d8;
        Object d9;
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c8, 1);
        cancellableContinuationImpl.y();
        CancellableContinuationKt.a(cancellableContinuationImpl, X(new ResumeOnCompletion(cancellableContinuationImpl)));
        Object v7 = cancellableContinuationImpl.v();
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (v7 == d8) {
            DebugProbesKt.c(continuation);
        }
        d9 = IntrinsicsKt__IntrinsicsKt.d();
        if (v7 == d9) {
            return v7;
        }
        return Unit.f50853a;
    }

    private final Object B0(Object obj) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Throwable th = null;
        Throwable th2 = null;
        while (true) {
            Object r02 = r0();
            if (r02 instanceof Finishing) {
                synchronized (r02) {
                    if (((Finishing) r02).h()) {
                        symbol2 = JobSupportKt.f51318d;
                        return symbol2;
                    }
                    boolean f8 = ((Finishing) r02).f();
                    if (obj != null || !f8) {
                        if (th2 == null) {
                            th2 = g0(obj);
                        }
                        ((Finishing) r02).a(th2);
                    }
                    Throwable e8 = ((Finishing) r02).e();
                    if (!f8) {
                        th = e8;
                    }
                    if (th != null) {
                        J0(((Finishing) r02).d(), th);
                    }
                    symbol = JobSupportKt.f51315a;
                    return symbol;
                }
            } else if (!(r02 instanceof Incomplete)) {
                symbol3 = JobSupportKt.f51318d;
                return symbol3;
            } else {
                if (th2 == null) {
                    th2 = g0(obj);
                }
                Incomplete incomplete = (Incomplete) r02;
                if (incomplete.isActive()) {
                    if (b1(incomplete, th2)) {
                        symbol4 = JobSupportKt.f51315a;
                        return symbol4;
                    }
                } else {
                    Object c12 = c1(r02, new CompletedExceptionally(th2, false, 2, null));
                    symbol5 = JobSupportKt.f51315a;
                    if (c12 != symbol5) {
                        symbol6 = JobSupportKt.f51317c;
                        if (c12 != symbol6) {
                            return c12;
                        }
                    } else {
                        throw new IllegalStateException(("Cannot happen in " + r02).toString());
                    }
                }
            }
        }
    }

    private final JobNode G0(Function1<? super Throwable, Unit> function1, boolean z7) {
        JobNode jobNode = null;
        if (z7) {
            if (function1 instanceof JobCancellingNode) {
                jobNode = (JobCancellingNode) function1;
            }
            if (jobNode == null) {
                jobNode = new InvokeOnCancelling(function1);
            }
        } else {
            if (function1 instanceof JobNode) {
                jobNode = (JobNode) function1;
            }
            if (jobNode == null) {
                jobNode = new InvokeOnCompletion(function1);
            }
        }
        jobNode.X(this);
        return jobNode;
    }

    private final ChildHandleNode I0(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.P()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.M();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.L();
            if (!lockFreeLinkedListNode.P()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    private final void J0(NodeList nodeList, Throwable th) {
        L0(th);
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) nodeList.K(); !Intrinsics.a(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.L()) {
            if (lockFreeLinkedListNode instanceof JobCancellingNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.V(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        ExceptionsKt__ExceptionsKt.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                        Unit unit = Unit.f50853a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            u0(completionHandlerException);
        }
        V(th);
    }

    private final boolean K(final Object obj, NodeList nodeList, final JobNode jobNode) {
        int U;
        LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(jobNode) { // from class: kotlinx.coroutines.JobSupport$addLastAtomic$$inlined$addLastIf$1
            @Override // kotlinx.coroutines.internal.AtomicOp
            /* renamed from: k */
            public Object i(LockFreeLinkedListNode lockFreeLinkedListNode) {
                boolean z7;
                if (this.r0() == obj) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    return null;
                }
                return LockFreeLinkedListKt.a();
            }
        };
        do {
            U = nodeList.M().U(jobNode, nodeList, condAddOp);
            if (U == 1) {
                return true;
            }
        } while (U != 2);
        return false;
    }

    private final void K0(NodeList nodeList, Throwable th) {
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) nodeList.K(); !Intrinsics.a(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.L()) {
            if (lockFreeLinkedListNode instanceof JobNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.V(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        ExceptionsKt__ExceptionsKt.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                        Unit unit = Unit.f50853a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            u0(completionHandlerException);
        }
    }

    private final void L(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th2 : list) {
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                ExceptionsKt__ExceptionsKt.a(th, th2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.InactiveNodeList] */
    private final void O0(Empty empty) {
        NodeList nodeList = new NodeList();
        if (!empty.isActive()) {
            nodeList = new InactiveNodeList(nodeList);
        }
        androidx.concurrent.futures.a.a(f51301f, this, empty, nodeList);
    }

    private final void P0(JobNode jobNode) {
        jobNode.F(new NodeList());
        androidx.concurrent.futures.a.a(f51301f, this, jobNode, jobNode.L());
    }

    private final Object Q(Continuation<Object> continuation) {
        Continuation c8;
        Object d8;
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        AwaitContinuation awaitContinuation = new AwaitContinuation(c8, this);
        awaitContinuation.y();
        CancellableContinuationKt.a(awaitContinuation, X(new ResumeAwaitOnCompletion(awaitContinuation)));
        Object v7 = awaitContinuation.v();
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (v7 == d8) {
            DebugProbesKt.c(continuation);
        }
        return v7;
    }

    private final Object U(Object obj) {
        Symbol symbol;
        Object c12;
        Symbol symbol2;
        do {
            Object r02 = r0();
            if (!(r02 instanceof Incomplete) || ((r02 instanceof Finishing) && ((Finishing) r02).g())) {
                symbol = JobSupportKt.f51315a;
                return symbol;
            }
            c12 = c1(r02, new CompletedExceptionally(g0(obj), false, 2, null));
            symbol2 = JobSupportKt.f51317c;
        } while (c12 == symbol2);
        return c12;
    }

    private final int U0(Object obj) {
        Empty empty;
        if (obj instanceof Empty) {
            if (((Empty) obj).isActive()) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51301f;
            empty = JobSupportKt.f51321g;
            if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, empty)) {
                return -1;
            }
            N0();
            return 1;
        } else if (!(obj instanceof InactiveNodeList)) {
            return 0;
        } else {
            if (!androidx.concurrent.futures.a.a(f51301f, this, obj, ((InactiveNodeList) obj).d())) {
                return -1;
            }
            N0();
            return 1;
        }
    }

    private final boolean V(Throwable th) {
        if (x0()) {
            return true;
        }
        boolean z7 = th instanceof CancellationException;
        ChildHandle q02 = q0();
        if (q02 != null && q02 != NonDisposableHandle.f51324f) {
            if (q02.e(th) || z7) {
                return true;
            }
            return false;
        }
        return z7;
    }

    private final String V0(Object obj) {
        if (obj instanceof Finishing) {
            Finishing finishing = (Finishing) obj;
            if (finishing.f()) {
                return "Cancelling";
            }
            if (!finishing.g()) {
                return "Active";
            }
            return "Completing";
        } else if (obj instanceof Incomplete) {
            if (((Incomplete) obj).isActive()) {
                return "Active";
            }
            return "New";
        } else if (obj instanceof CompletedExceptionally) {
            return "Cancelled";
        } else {
            return "Completed";
        }
    }

    public static /* synthetic */ CancellationException X0(JobSupport jobSupport, Throwable th, String str, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 1) != 0) {
                str = null;
            }
            return jobSupport.W0(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final boolean a1(Incomplete incomplete, Object obj) {
        if (!androidx.concurrent.futures.a.a(f51301f, this, incomplete, JobSupportKt.g(obj))) {
            return false;
        }
        L0(null);
        M0(obj);
        b0(incomplete, obj);
        return true;
    }

    private final void b0(Incomplete incomplete, Object obj) {
        CompletedExceptionally completedExceptionally;
        ChildHandle q02 = q0();
        if (q02 != null) {
            q02.dispose();
            T0(NonDisposableHandle.f51324f);
        }
        Throwable th = null;
        if (obj instanceof CompletedExceptionally) {
            completedExceptionally = (CompletedExceptionally) obj;
        } else {
            completedExceptionally = null;
        }
        if (completedExceptionally != null) {
            th = completedExceptionally.f51234a;
        }
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).V(th);
                return;
            } catch (Throwable th2) {
                u0(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
                return;
            }
        }
        NodeList d8 = incomplete.d();
        if (d8 != null) {
            K0(d8, th);
        }
    }

    private final boolean b1(Incomplete incomplete, Throwable th) {
        NodeList p02 = p0(incomplete);
        if (p02 == null) {
            return false;
        }
        if (!androidx.concurrent.futures.a.a(f51301f, this, incomplete, new Finishing(p02, false, th))) {
            return false;
        }
        J0(p02, th);
        return true;
    }

    private final Object c1(Object obj, Object obj2) {
        Symbol symbol;
        Symbol symbol2;
        if (!(obj instanceof Incomplete)) {
            symbol2 = JobSupportKt.f51315a;
            return symbol2;
        } else if (((obj instanceof Empty) || (obj instanceof JobNode)) && !(obj instanceof ChildHandleNode) && !(obj2 instanceof CompletedExceptionally)) {
            if (!a1((Incomplete) obj, obj2)) {
                symbol = JobSupportKt.f51317c;
                return symbol;
            }
            return obj2;
        } else {
            return d1((Incomplete) obj, obj2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Throwable, T] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private final Object d1(Incomplete incomplete, Object obj) {
        Finishing finishing;
        CompletedExceptionally completedExceptionally;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        NodeList p02 = p0(incomplete);
        if (p02 == null) {
            symbol3 = JobSupportKt.f51317c;
            return symbol3;
        }
        ?? r22 = 0;
        if (incomplete instanceof Finishing) {
            finishing = (Finishing) incomplete;
        } else {
            finishing = null;
        }
        boolean z7 = false;
        if (finishing == null) {
            finishing = new Finishing(p02, false, null);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (finishing) {
            if (finishing.g()) {
                symbol2 = JobSupportKt.f51315a;
                return symbol2;
            }
            finishing.j(true);
            if (finishing != incomplete && !androidx.concurrent.futures.a.a(f51301f, this, incomplete, finishing)) {
                symbol = JobSupportKt.f51317c;
                return symbol;
            }
            boolean f8 = finishing.f();
            if (obj instanceof CompletedExceptionally) {
                completedExceptionally = (CompletedExceptionally) obj;
            } else {
                completedExceptionally = null;
            }
            if (completedExceptionally != null) {
                finishing.a(completedExceptionally.f51234a);
            }
            Throwable e8 = finishing.e();
            if (!f8) {
                z7 = true;
            }
            if (Boolean.valueOf(z7).booleanValue()) {
                r22 = e8;
            }
            ref$ObjectRef.f51016f = r22;
            Unit unit = Unit.f50853a;
            if (r22 != 0) {
                J0(p02, r22);
            }
            ChildHandleNode i02 = i0(incomplete);
            if (i02 != null && e1(finishing, i02, obj)) {
                return JobSupportKt.f51316b;
            }
            return h0(finishing, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        ChildHandleNode I0 = I0(childHandleNode);
        if (I0 != null && e1(finishing, I0, obj)) {
            return;
        }
        M(h0(finishing, obj));
    }

    private final boolean e1(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        while (Job.DefaultImpls.d(childHandleNode.f51227j, false, false, new ChildCompletion(this, finishing, childHandleNode, obj), 1, null) == NonDisposableHandle.f51324f) {
            childHandleNode = I0(childHandleNode);
            if (childHandleNode == null) {
                return false;
            }
        }
        return true;
    }

    private final Throwable g0(Object obj) {
        boolean z7;
        if (obj == null) {
            z7 = true;
        } else {
            z7 = obj instanceof Throwable;
        }
        if (z7) {
            Throwable th = (Throwable) obj;
            if (th == null) {
                return new JobCancellationException(W(), null, this);
            }
            return th;
        } else if (obj != null) {
            return ((ParentJob) obj).f0();
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        }
    }

    private final Object h0(Finishing finishing, Object obj) {
        CompletedExceptionally completedExceptionally;
        Throwable th;
        boolean f8;
        Throwable m02;
        if (obj instanceof CompletedExceptionally) {
            completedExceptionally = (CompletedExceptionally) obj;
        } else {
            completedExceptionally = null;
        }
        if (completedExceptionally != null) {
            th = completedExceptionally.f51234a;
        } else {
            th = null;
        }
        synchronized (finishing) {
            f8 = finishing.f();
            List<Throwable> i8 = finishing.i(th);
            m02 = m0(finishing, i8);
            if (m02 != null) {
                L(m02, i8);
            }
        }
        boolean z7 = false;
        if (m02 != null && m02 != th) {
            obj = new CompletedExceptionally(m02, false, 2, null);
        }
        if (m02 != null) {
            if ((V(m02) || t0(m02)) ? true : true) {
                if (obj != null) {
                    ((CompletedExceptionally) obj).b();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
            }
        }
        if (!f8) {
            L0(m02);
        }
        M0(obj);
        androidx.concurrent.futures.a.a(f51301f, this, finishing, JobSupportKt.g(obj));
        b0(finishing, obj);
        return obj;
    }

    private final ChildHandleNode i0(Incomplete incomplete) {
        ChildHandleNode childHandleNode;
        if (incomplete instanceof ChildHandleNode) {
            childHandleNode = (ChildHandleNode) incomplete;
        } else {
            childHandleNode = null;
        }
        if (childHandleNode == null) {
            NodeList d8 = incomplete.d();
            if (d8 == null) {
                return null;
            }
            return I0(d8);
        }
        return childHandleNode;
    }

    private final Throwable l0(Object obj) {
        CompletedExceptionally completedExceptionally;
        if (obj instanceof CompletedExceptionally) {
            completedExceptionally = (CompletedExceptionally) obj;
        } else {
            completedExceptionally = null;
        }
        if (completedExceptionally == null) {
            return null;
        }
        return completedExceptionally.f51234a;
    }

    private final Throwable m0(Finishing finishing, List<? extends Throwable> list) {
        Object obj;
        boolean z7;
        Object obj2 = null;
        if (list.isEmpty()) {
            if (!finishing.f()) {
                return null;
            }
            return new JobCancellationException(W(), null, this);
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (!(((Throwable) obj) instanceof CancellationException)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                Throwable th3 = (Throwable) next;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    z7 = true;
                    continue;
                } else {
                    z7 = false;
                    continue;
                }
                if (z7) {
                    obj2 = next;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final NodeList p0(Incomplete incomplete) {
        NodeList d8 = incomplete.d();
        if (d8 == null) {
            if (incomplete instanceof Empty) {
                return new NodeList();
            }
            if (incomplete instanceof JobNode) {
                P0((JobNode) incomplete);
                return null;
            }
            throw new IllegalStateException(("State should have list: " + incomplete).toString());
        }
        return d8;
    }

    private final boolean y0() {
        Object r02;
        do {
            r02 = r0();
            if (!(r02 instanceof Incomplete)) {
                return false;
            }
        } while (U0(r02) < 0);
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle D0(ChildJob childJob) {
        return (ChildHandle) Job.DefaultImpls.d(this, true, false, new ChildHandleNode(childJob), 2, null);
    }

    public final boolean E0(Object obj) {
        Object c12;
        Symbol symbol;
        Symbol symbol2;
        do {
            c12 = c1(r0(), obj);
            symbol = JobSupportKt.f51315a;
            if (c12 == symbol) {
                return false;
            }
            if (c12 != JobSupportKt.f51316b) {
                symbol2 = JobSupportKt.f51317c;
            } else {
                return true;
            }
        } while (c12 == symbol2);
        M(c12);
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle F(boolean z7, boolean z8, Function1<? super Throwable, Unit> function1) {
        CompletedExceptionally completedExceptionally;
        JobNode G0 = G0(function1, z7);
        while (true) {
            Object r02 = r0();
            if (r02 instanceof Empty) {
                Empty empty = (Empty) r02;
                if (empty.isActive()) {
                    if (androidx.concurrent.futures.a.a(f51301f, this, r02, G0)) {
                        return G0;
                    }
                } else {
                    O0(empty);
                }
            } else {
                Throwable th = null;
                if (r02 instanceof Incomplete) {
                    NodeList d8 = ((Incomplete) r02).d();
                    if (d8 == null) {
                        if (r02 != null) {
                            P0((JobNode) r02);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        }
                    } else {
                        DisposableHandle disposableHandle = NonDisposableHandle.f51324f;
                        if (z7 && (r02 instanceof Finishing)) {
                            synchronized (r02) {
                                th = ((Finishing) r02).e();
                                if (th == null || ((function1 instanceof ChildHandleNode) && !((Finishing) r02).g())) {
                                    if (K(r02, d8, G0)) {
                                        if (th == null) {
                                            return G0;
                                        }
                                        disposableHandle = G0;
                                    }
                                }
                                Unit unit = Unit.f50853a;
                            }
                        }
                        if (th != null) {
                            if (z8) {
                                function1.invoke(th);
                            }
                            return disposableHandle;
                        } else if (K(r02, d8, G0)) {
                            return G0;
                        }
                    }
                } else {
                    if (z8) {
                        if (r02 instanceof CompletedExceptionally) {
                            completedExceptionally = (CompletedExceptionally) r02;
                        } else {
                            completedExceptionally = null;
                        }
                        if (completedExceptionally != null) {
                            th = completedExceptionally.f51234a;
                        }
                        function1.invoke(th);
                    }
                    return NonDisposableHandle.f51324f;
                }
            }
        }
    }

    public final Object F0(Object obj) {
        Object c12;
        Symbol symbol;
        Symbol symbol2;
        do {
            c12 = c1(r0(), obj);
            symbol = JobSupportKt.f51315a;
            if (c12 != symbol) {
                symbol2 = JobSupportKt.f51317c;
            } else {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, l0(obj));
            }
        } while (c12 == symbol2);
        return c12;
    }

    public String H0() {
        return DebugStringsKt.a(this);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException I() {
        Object r02 = r0();
        if (r02 instanceof Finishing) {
            Throwable e8 = ((Finishing) r02).e();
            if (e8 != null) {
                CancellationException W0 = W0(e8, DebugStringsKt.a(this) + " is cancelling");
                if (W0 != null) {
                    return W0;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (!(r02 instanceof Incomplete)) {
            if (r02 instanceof CompletedExceptionally) {
                return X0(this, ((CompletedExceptionally) r02).f51234a, null, 1, null);
            }
            return new JobCancellationException(DebugStringsKt.a(this) + " has completed normally", null, this);
        } else {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
    }

    protected void L0(Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(Object obj) {
    }

    protected void M0(Object obj) {
    }

    protected void N0() {
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void O(ParentJob parentJob) {
        S(parentJob);
    }

    public final Object P(Continuation<Object> continuation) {
        Object r02;
        do {
            r02 = r0();
            if (!(r02 instanceof Incomplete)) {
                if (!(r02 instanceof CompletedExceptionally)) {
                    return JobSupportKt.h(r02);
                }
                throw ((CompletedExceptionally) r02).f51234a;
            }
        } while (U0(r02) < 0);
        return Q(continuation);
    }

    public final <T, R> void Q0(SelectInstance<? super R> selectInstance, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object r02;
        do {
            r02 = r0();
            if (selectInstance.g()) {
                return;
            }
            if (!(r02 instanceof Incomplete)) {
                if (selectInstance.n()) {
                    if (r02 instanceof CompletedExceptionally) {
                        selectInstance.u(((CompletedExceptionally) r02).f51234a);
                        return;
                    } else {
                        UndispatchedKt.c(function2, JobSupportKt.h(r02), selectInstance.q());
                        return;
                    }
                }
                return;
            }
        } while (U0(r02) != 0);
        selectInstance.k(X(new SelectAwaitOnCompletion(selectInstance, function2)));
    }

    public final boolean R(Throwable th) {
        return S(th);
    }

    public final void R0(JobNode jobNode) {
        Object r02;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Empty empty;
        do {
            r02 = r0();
            if (r02 instanceof JobNode) {
                if (r02 != jobNode) {
                    return;
                }
                atomicReferenceFieldUpdater = f51301f;
                empty = JobSupportKt.f51321g;
            } else if ((r02 instanceof Incomplete) && ((Incomplete) r02).d() != null) {
                jobNode.Q();
                return;
            } else {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, r02, empty));
    }

    public final boolean S(Object obj) {
        Object obj2;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        obj2 = JobSupportKt.f51315a;
        if (!o0() || (obj2 = U(obj)) != JobSupportKt.f51316b) {
            symbol = JobSupportKt.f51315a;
            if (obj2 == symbol) {
                obj2 = B0(obj);
            }
            symbol2 = JobSupportKt.f51315a;
            if (obj2 != symbol2 && obj2 != JobSupportKt.f51316b) {
                symbol3 = JobSupportKt.f51318d;
                if (obj2 == symbol3) {
                    return false;
                }
                M(obj2);
                return true;
            }
            return true;
        }
        return true;
    }

    public final <T, R> void S0(SelectInstance<? super R> selectInstance, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object r02 = r0();
        if (r02 instanceof CompletedExceptionally) {
            selectInstance.u(((CompletedExceptionally) r02).f51234a);
        } else {
            CancellableKt.e(function2, JobSupportKt.h(r02), selectInstance.q(), null, 4, null);
        }
    }

    public void T(Throwable th) {
        S(th);
    }

    public final void T0(ChildHandle childHandle) {
        this._parentHandle = childHandle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String W() {
        return "Job was cancelled";
    }

    protected final CancellationException W0(Throwable th, String str) {
        CancellationException cancellationException;
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        } else {
            cancellationException = null;
        }
        if (cancellationException == null) {
            if (str == null) {
                str = W();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle X(Function1<? super Throwable, Unit> function1) {
        return F(false, true, function1);
    }

    public final String Z0() {
        return H0() + '{' + V0(r0()) + '}';
    }

    public boolean a0(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        if (S(th) && n0()) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean c() {
        return !(r0() instanceof Incomplete);
    }

    @Override // kotlinx.coroutines.Job
    public void e(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(W(), null, this);
        }
        T(cancellationException);
    }

    @Override // kotlinx.coroutines.ParentJob
    public CancellationException f0() {
        Throwable th;
        Object r02 = r0();
        CancellationException cancellationException = null;
        if (r02 instanceof Finishing) {
            th = ((Finishing) r02).e();
        } else if (r02 instanceof CompletedExceptionally) {
            th = ((CompletedExceptionally) r02).f51234a;
        } else if (!(r02 instanceof Incomplete)) {
            th = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + r02).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = th;
        }
        if (cancellationException == null) {
            return new JobCancellationException("Parent job is " + V0(r02), th, this);
        }
        return cancellationException;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E g(CoroutineContext.Key<E> key) {
        return (E) Job.DefaultImpls.c(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return Job.f51296d;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext h(CoroutineContext.Key<?> key) {
        return Job.DefaultImpls.e(this, key);
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object r02 = r0();
        if ((r02 instanceof Incomplete) && ((Incomplete) r02).isActive()) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object r02 = r0();
        if (!(r02 instanceof CompletedExceptionally) && (!(r02 instanceof Finishing) || !((Finishing) r02).f())) {
            return false;
        }
        return true;
    }

    public final Object j0() {
        Object r02 = r0();
        if (!(r02 instanceof Incomplete)) {
            if (!(r02 instanceof CompletedExceptionally)) {
                return JobSupportKt.h(r02);
            }
            throw ((CompletedExceptionally) r02).f51234a;
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R l(R r7, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) Job.DefaultImpls.b(this, r7, function2);
    }

    public boolean n0() {
        return true;
    }

    public boolean o0() {
        return false;
    }

    public final ChildHandle q0() {
        return (ChildHandle) this._parentHandle;
    }

    public final Object r0() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).c(this);
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext s0(CoroutineContext coroutineContext) {
        return Job.DefaultImpls.f(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int U0;
        do {
            U0 = U0(r0());
            if (U0 == 0) {
                return false;
            }
        } while (U0 != 1);
        return true;
    }

    protected boolean t0(Throwable th) {
        return false;
    }

    public String toString() {
        return Z0() + '@' + DebugStringsKt.b(this);
    }

    @Override // kotlinx.coroutines.Job
    public final Object v0(Continuation<? super Unit> continuation) {
        Object d8;
        if (!y0()) {
            JobKt.i(continuation.getContext());
            return Unit.f50853a;
        }
        Object A0 = A0(continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (A0 == d8) {
            return A0;
        }
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void w0(Job job) {
        if (job == null) {
            T0(NonDisposableHandle.f51324f);
            return;
        }
        job.start();
        ChildHandle D0 = job.D0(this);
        T0(D0);
        if (c()) {
            D0.dispose();
            T0(NonDisposableHandle.f51324f);
        }
    }

    protected boolean x0() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public final Sequence<Job> y() {
        return SequencesKt.b(new JobSupport$children$1(this, null));
    }

    public void u0(Throwable th) {
        throw th;
    }
}
