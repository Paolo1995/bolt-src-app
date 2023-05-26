package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BeforeResumeCancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes5.dex */
public abstract class AbstractChannel<E> extends AbstractSendChannel<E> implements Channel<E> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes5.dex */
    public static final class Itr<E> implements ChannelIterator<E> {

        /* renamed from: a  reason: collision with root package name */
        public final AbstractChannel<E> f51363a;

        /* renamed from: b  reason: collision with root package name */
        private Object f51364b = AbstractChannelKt.f51384d;

        public Itr(AbstractChannel<E> abstractChannel) {
            this.f51363a = abstractChannel;
        }

        private final boolean b(Object obj) {
            if (obj instanceof Closed) {
                Closed closed = (Closed) obj;
                if (closed.f51414i == null) {
                    return false;
                }
                throw StackTraceRecoveryKt.a(closed.c0());
            }
            return true;
        }

        private final Object c(Continuation<? super Boolean> continuation) {
            Continuation c8;
            Object d8;
            Function1<Throwable, Unit> function1;
            c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
            CancellableContinuationImpl b8 = CancellableContinuationKt.b(c8);
            ReceiveHasNext receiveHasNext = new ReceiveHasNext(this, b8);
            while (true) {
                if (this.f51363a.L(receiveHasNext)) {
                    this.f51363a.a0(b8, receiveHasNext);
                    break;
                }
                Object W = this.f51363a.W();
                d(W);
                if (W instanceof Closed) {
                    Closed closed = (Closed) W;
                    if (closed.f51414i == null) {
                        Result.Companion companion = Result.f50818g;
                        b8.resumeWith(Result.b(Boxing.a(false)));
                    } else {
                        Result.Companion companion2 = Result.f50818g;
                        b8.resumeWith(Result.b(ResultKt.a(closed.c0())));
                    }
                } else if (W != AbstractChannelKt.f51384d) {
                    Boolean a8 = Boxing.a(true);
                    Function1<E, Unit> function12 = this.f51363a.f51388f;
                    if (function12 != null) {
                        function1 = OnUndeliveredElementKt.a(function12, W, b8.getContext());
                    } else {
                        function1 = null;
                    }
                    b8.r(a8, function1);
                }
            }
            Object v7 = b8.v();
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            if (v7 == d8) {
                DebugProbesKt.c(continuation);
            }
            return v7;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object a(Continuation<? super Boolean> continuation) {
            Object obj = this.f51364b;
            Symbol symbol = AbstractChannelKt.f51384d;
            if (obj != symbol) {
                return Boxing.a(b(obj));
            }
            Object W = this.f51363a.W();
            this.f51364b = W;
            if (W != symbol) {
                return Boxing.a(b(W));
            }
            return c(continuation);
        }

        public final void d(Object obj) {
            this.f51364b = obj;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            E e8 = (E) this.f51364b;
            if (!(e8 instanceof Closed)) {
                Symbol symbol = AbstractChannelKt.f51384d;
                if (e8 != symbol) {
                    this.f51364b = symbol;
                    return e8;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            throw StackTraceRecoveryKt.a(((Closed) e8).c0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes5.dex */
    public static class ReceiveElement<E> extends Receive<E> {

        /* renamed from: i  reason: collision with root package name */
        public final CancellableContinuation<Object> f51365i;

        /* renamed from: j  reason: collision with root package name */
        public final int f51366j;

        public ReceiveElement(CancellableContinuation<Object> cancellableContinuation, int i8) {
            this.f51365i = cancellableContinuation;
            this.f51366j = i8;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void X(Closed<?> closed) {
            if (this.f51366j == 1) {
                this.f51365i.resumeWith(Result.b(ChannelResult.b(ChannelResult.f51406b.a(closed.f51414i))));
                return;
            }
            CancellableContinuation<Object> cancellableContinuation = this.f51365i;
            Result.Companion companion = Result.f50818g;
            cancellableContinuation.resumeWith(Result.b(ResultKt.a(closed.c0())));
        }

        public final Object Y(E e8) {
            if (this.f51366j == 1) {
                return ChannelResult.b(ChannelResult.f51406b.c(e8));
            }
            return e8;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void j(E e8) {
            this.f51365i.G(CancellableContinuationImplKt.f51224a);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveElement@" + DebugStringsKt.b(this) + "[receiveMode=" + this.f51366j + ']';
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol w(E e8, LockFreeLinkedListNode.PrepareOp prepareOp) {
            LockFreeLinkedListNode.AbstractAtomicDesc abstractAtomicDesc;
            CancellableContinuation<Object> cancellableContinuation = this.f51365i;
            Object Y = Y(e8);
            if (prepareOp != null) {
                abstractAtomicDesc = prepareOp.f51805c;
            } else {
                abstractAtomicDesc = null;
            }
            if (cancellableContinuation.B(Y, abstractAtomicDesc, W(e8)) == null) {
                return null;
            }
            if (prepareOp != null) {
                prepareOp.d();
            }
            return CancellableContinuationImplKt.f51224a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes5.dex */
    public static final class ReceiveElementWithUndeliveredHandler<E> extends ReceiveElement<E> {

        /* renamed from: k  reason: collision with root package name */
        public final Function1<E, Unit> f51367k;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveElementWithUndeliveredHandler(CancellableContinuation<Object> cancellableContinuation, int i8, Function1<? super E, Unit> function1) {
            super(cancellableContinuation, i8);
            this.f51367k = function1;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, Unit> W(E e8) {
            return OnUndeliveredElementKt.a(this.f51367k, e8, this.f51365i.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes5.dex */
    public static class ReceiveHasNext<E> extends Receive<E> {

        /* renamed from: i  reason: collision with root package name */
        public final Itr<E> f51368i;

        /* renamed from: j  reason: collision with root package name */
        public final CancellableContinuation<Boolean> f51369j;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveHasNext(Itr<E> itr, CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f51368i = itr;
            this.f51369j = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, Unit> W(E e8) {
            Function1<E, Unit> function1 = this.f51368i.f51363a.f51388f;
            if (function1 != null) {
                return OnUndeliveredElementKt.a(function1, e8, this.f51369j.getContext());
            }
            return null;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void X(Closed<?> closed) {
            Object p8;
            if (closed.f51414i == null) {
                p8 = CancellableContinuation.DefaultImpls.a(this.f51369j, Boolean.FALSE, null, 2, null);
            } else {
                p8 = this.f51369j.p(closed.c0());
            }
            if (p8 != null) {
                this.f51368i.d(closed);
                this.f51369j.G(p8);
            }
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void j(E e8) {
            this.f51368i.d(e8);
            this.f51369j.G(CancellableContinuationImplKt.f51224a);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveHasNext@" + DebugStringsKt.b(this);
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol w(E e8, LockFreeLinkedListNode.PrepareOp prepareOp) {
            LockFreeLinkedListNode.AbstractAtomicDesc abstractAtomicDesc;
            CancellableContinuation<Boolean> cancellableContinuation = this.f51369j;
            Boolean bool = Boolean.TRUE;
            if (prepareOp != null) {
                abstractAtomicDesc = prepareOp.f51805c;
            } else {
                abstractAtomicDesc = null;
            }
            if (cancellableContinuation.B(bool, abstractAtomicDesc, W(e8)) == null) {
                return null;
            }
            if (prepareOp != null) {
                prepareOp.d();
            }
            return CancellableContinuationImplKt.f51224a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes5.dex */
    public static final class ReceiveSelect<R, E> extends Receive<E> implements DisposableHandle {

        /* renamed from: i  reason: collision with root package name */
        public final AbstractChannel<E> f51370i;

        /* renamed from: j  reason: collision with root package name */
        public final SelectInstance<R> f51371j;

        /* renamed from: k  reason: collision with root package name */
        public final Function2<Object, Continuation<? super R>, Object> f51372k;

        /* renamed from: l  reason: collision with root package name */
        public final int f51373l;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveSelect(AbstractChannel<E> abstractChannel, SelectInstance<? super R> selectInstance, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i8) {
            this.f51370i = abstractChannel;
            this.f51371j = selectInstance;
            this.f51372k = function2;
            this.f51373l = i8;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, Unit> W(E e8) {
            Function1<E, Unit> function1 = this.f51370i.f51388f;
            if (function1 != null) {
                return OnUndeliveredElementKt.a(function1, e8, this.f51371j.q().getContext());
            }
            return null;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void X(Closed<?> closed) {
            if (!this.f51371j.n()) {
                return;
            }
            int i8 = this.f51373l;
            if (i8 != 0) {
                if (i8 == 1) {
                    CancellableKt.e(this.f51372k, ChannelResult.b(ChannelResult.f51406b.a(closed.f51414i)), this.f51371j.q(), null, 4, null);
                    return;
                }
                return;
            }
            this.f51371j.u(closed.c0());
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if (Q()) {
                this.f51370i.U();
            }
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void j(E e8) {
            Object obj;
            Function2<Object, Continuation<? super R>, Object> function2 = this.f51372k;
            if (this.f51373l == 1) {
                obj = ChannelResult.b(ChannelResult.f51406b.c(e8));
            } else {
                obj = e8;
            }
            CancellableKt.d(function2, obj, this.f51371j.q(), W(e8));
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveSelect@" + DebugStringsKt.b(this) + '[' + this.f51371j + ",receiveMode=" + this.f51373l + ']';
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol w(E e8, LockFreeLinkedListNode.PrepareOp prepareOp) {
            return (Symbol) this.f51371j.m(prepareOp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes5.dex */
    public final class RemoveReceiveOnCancel extends BeforeResumeCancelHandler {

        /* renamed from: f  reason: collision with root package name */
        private final Receive<?> f51374f;

        public RemoveReceiveOnCancel(Receive<?> receive) {
            this.f51374f = receive;
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        public void b(Throwable th) {
            if (this.f51374f.Q()) {
                AbstractChannel.this.U();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            b(th);
            return Unit.f50853a;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.f51374f + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes5.dex */
    public static final class TryPollDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<Send> {
        public TryPollDesc(LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object e(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (!(lockFreeLinkedListNode instanceof Closed)) {
                if (!(lockFreeLinkedListNode instanceof Send)) {
                    return AbstractChannelKt.f51384d;
                }
                return null;
            }
            return lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object j(LockFreeLinkedListNode.PrepareOp prepareOp) {
            Symbol Y = ((Send) prepareOp.f51803a).Y(prepareOp);
            if (Y == null) {
                return LockFreeLinkedList_commonKt.f51809a;
            }
            Object obj = AtomicKt.f51775b;
            if (Y == obj) {
                return obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void k(LockFreeLinkedListNode lockFreeLinkedListNode) {
            ((Send) lockFreeLinkedListNode).Z();
        }
    }

    public AbstractChannel(Function1<? super E, Unit> function1) {
        super(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L(Receive<? super E> receive) {
        boolean M = M(receive);
        if (M) {
            V();
        }
        return M;
    }

    private final <R> boolean N(SelectInstance<? super R> selectInstance, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i8) {
        ReceiveSelect receiveSelect = new ReceiveSelect(this, selectInstance, function2, i8);
        boolean L = L(receiveSelect);
        if (L) {
            selectInstance.k(receiveSelect);
        }
        return L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.channels.AbstractChannel$ReceiveElement] */
    private final <R> Object Y(int i8, Continuation<? super R> continuation) {
        Continuation c8;
        ReceiveElementWithUndeliveredHandler receiveElementWithUndeliveredHandler;
        Object d8;
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        CancellableContinuationImpl b8 = CancellableContinuationKt.b(c8);
        if (this.f51388f == null) {
            receiveElementWithUndeliveredHandler = new ReceiveElement(b8, i8);
        } else {
            receiveElementWithUndeliveredHandler = new ReceiveElementWithUndeliveredHandler(b8, i8, this.f51388f);
        }
        while (true) {
            if (L(receiveElementWithUndeliveredHandler)) {
                a0(b8, receiveElementWithUndeliveredHandler);
                break;
            }
            Object W = W();
            if (W instanceof Closed) {
                receiveElementWithUndeliveredHandler.X((Closed) W);
                break;
            } else if (W != AbstractChannelKt.f51384d) {
                b8.r(receiveElementWithUndeliveredHandler.Y(W), receiveElementWithUndeliveredHandler.W(W));
                break;
            }
        }
        Object v7 = b8.v();
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (v7 == d8) {
            DebugProbesKt.c(continuation);
        }
        return v7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void Z(SelectInstance<? super R> selectInstance, int i8, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.g()) {
            if (R()) {
                if (N(selectInstance, function2, i8)) {
                    return;
                }
            } else {
                Object X = X(selectInstance);
                if (X == SelectKt.d()) {
                    return;
                }
                if (X != AbstractChannelKt.f51384d && X != AtomicKt.f51775b) {
                    b0(function2, selectInstance, i8, X);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(CancellableContinuation<?> cancellableContinuation, Receive<?> receive) {
        cancellableContinuation.o(new RemoveReceiveOnCancel(receive));
    }

    private final <R> void b0(Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, SelectInstance<? super R> selectInstance, int i8, Object obj) {
        Object c8;
        boolean z7 = obj instanceof Closed;
        if (z7) {
            if (i8 != 0) {
                if (i8 != 1 || !selectInstance.n()) {
                    return;
                }
                UndispatchedKt.c(function2, ChannelResult.b(ChannelResult.f51406b.a(((Closed) obj).f51414i)), selectInstance.q());
                return;
            }
            throw StackTraceRecoveryKt.a(((Closed) obj).c0());
        } else if (i8 == 1) {
            ChannelResult.Companion companion = ChannelResult.f51406b;
            if (z7) {
                c8 = companion.a(((Closed) obj).f51414i);
            } else {
                c8 = companion.c(obj);
            }
            UndispatchedKt.c(function2, ChannelResult.b(c8), selectInstance.q());
        } else {
            UndispatchedKt.c(function2, obj, selectInstance.q());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object A(kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1) r0
            int r1 = r0.f51380h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51380h = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f51378f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f51380h
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L5b
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            java.lang.Object r5 = r4.W()
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.AbstractChannelKt.f51384d
            if (r5 == r2) goto L52
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.Closed
            if (r0 == 0) goto L4b
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.f51406b
            kotlinx.coroutines.channels.Closed r5 = (kotlinx.coroutines.channels.Closed) r5
            java.lang.Throwable r5 = r5.f51414i
            java.lang.Object r5 = r0.a(r5)
            goto L51
        L4b:
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.f51406b
            java.lang.Object r5 = r0.c(r5)
        L51:
            return r5
        L52:
            r0.f51380h = r3
            java.lang.Object r5 = r4.Y(r3, r0)
            if (r5 != r1) goto L5b
            return r1
        L5b:
            kotlinx.coroutines.channels.ChannelResult r5 = (kotlinx.coroutines.channels.ChannelResult) r5
            java.lang.Object r5 = r5.l()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.A(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public ReceiveOrClosed<E> C() {
        ReceiveOrClosed<E> C = super.C();
        if (C != null && !(C instanceof Closed)) {
            U();
        }
        return C;
    }

    public final boolean J(Throwable th) {
        boolean b8 = b(th);
        S(b8);
        return b8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TryPollDesc<E> K() {
        return new TryPollDesc<>(j());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean M(final Receive<? super E> receive) {
        int U;
        LockFreeLinkedListNode M;
        if (O()) {
            LockFreeLinkedListNode j8 = j();
            do {
                M = j8.M();
                if (!(!(M instanceof Send))) {
                    return false;
                }
            } while (!M.E(receive, j8));
        } else {
            LockFreeLinkedListNode j9 = j();
            LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(receive) { // from class: kotlinx.coroutines.channels.AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1
                @Override // kotlinx.coroutines.internal.AtomicOp
                /* renamed from: k */
                public Object i(LockFreeLinkedListNode lockFreeLinkedListNode) {
                    if (this.P()) {
                        return null;
                    }
                    return LockFreeLinkedListKt.a();
                }
            };
            do {
                LockFreeLinkedListNode M2 = j9.M();
                if (!(!(M2 instanceof Send))) {
                    return false;
                }
                U = M2.U(receive, j9, condAddOp);
                if (U != 1) {
                }
            } while (U != 2);
            return false;
        }
        return true;
    }

    protected abstract boolean O();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean P();

    public boolean Q() {
        if (h() != null && P()) {
            return true;
        }
        return false;
    }

    protected final boolean R() {
        if (!(j().L() instanceof Send) && P()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S(boolean z7) {
        Closed<?> i8 = i();
        if (i8 != null) {
            Object b8 = InlineList.b(null, 1, null);
            while (true) {
                LockFreeLinkedListNode M = i8.M();
                if (M instanceof LockFreeLinkedListHead) {
                    T(b8, i8);
                    return;
                } else if (!M.Q()) {
                    M.N();
                } else {
                    b8 = InlineList.c(b8, (Send) M);
                }
            }
        } else {
            throw new IllegalStateException("Cannot happen".toString());
        }
    }

    protected void T(Object obj, Closed<?> closed) {
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                ((Send) obj).X(closed);
                return;
            }
            ArrayList arrayList = (ArrayList) obj;
            int size = arrayList.size();
            while (true) {
                size--;
                if (-1 < size) {
                    ((Send) arrayList.get(size)).X(closed);
                } else {
                    return;
                }
            }
        }
    }

    protected void U() {
    }

    protected void V() {
    }

    protected Object W() {
        while (true) {
            Send F = F();
            if (F == null) {
                return AbstractChannelKt.f51384d;
            }
            if (F.Y(null) != null) {
                F.V();
                return F.W();
            }
            F.Z();
        }
    }

    protected Object X(SelectInstance<?> selectInstance) {
        TryPollDesc<E> K = K();
        Object v7 = selectInstance.v(K);
        if (v7 != null) {
            return v7;
        }
        K.o().V();
        return K.o().W();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void e(CancellationException cancellationException) {
        if (Q()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new CancellationException(DebugStringsKt.a(this) + " was cancelled");
        }
        J(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator<E> iterator() {
        return new Itr(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1<E> v() {
        return new SelectClause1<E>(this) { // from class: kotlinx.coroutines.channels.AbstractChannel$onReceive$1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ AbstractChannel<E> f51376f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f51376f = this;
            }

            @Override // kotlinx.coroutines.selects.SelectClause1
            public <R> void n(SelectInstance<? super R> selectInstance, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
                this.f51376f.Z(selectInstance, 0, function2);
            }
        };
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1<ChannelResult<E>> x() {
        return (SelectClause1<ChannelResult<? extends E>>) new SelectClause1<ChannelResult<? extends E>>(this) { // from class: kotlinx.coroutines.channels.AbstractChannel$onReceiveCatching$1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ AbstractChannel<E> f51377f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f51377f = this;
            }

            @Override // kotlinx.coroutines.selects.SelectClause1
            public <R> void n(SelectInstance<? super R> selectInstance, Function2<? super ChannelResult<? extends E>, ? super Continuation<? super R>, ? extends Object> function2) {
                this.f51377f.Z(selectInstance, 1, function2);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object z() {
        Object W = W();
        if (W == AbstractChannelKt.f51384d) {
            return ChannelResult.f51406b.b();
        }
        if (W instanceof Closed) {
            return ChannelResult.f51406b.a(((Closed) W).f51414i);
        }
        return ChannelResult.f51406b.c(W);
    }
}
