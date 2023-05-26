package kotlinx.coroutines.channels;

import androidx.concurrent.futures.a;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes5.dex */
public abstract class AbstractSendChannel<E> implements SendChannel<E> {

    /* renamed from: h  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f51387h = AtomicReferenceFieldUpdater.newUpdater(AbstractSendChannel.class, Object.class, "onCloseHandler");

    /* renamed from: f  reason: collision with root package name */
    protected final Function1<E, Unit> f51388f;

    /* renamed from: g  reason: collision with root package name */
    private final LockFreeLinkedListHead f51389g = new LockFreeLinkedListHead();
    private volatile /* synthetic */ Object onCloseHandler = null;

    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes5.dex */
    public static final class SendBuffered<E> extends Send {

        /* renamed from: i  reason: collision with root package name */
        public final E f51391i;

        public SendBuffered(E e8) {
            this.f51391i = e8;
        }

        @Override // kotlinx.coroutines.channels.Send
        public void V() {
        }

        @Override // kotlinx.coroutines.channels.Send
        public Object W() {
            return this.f51391i;
        }

        @Override // kotlinx.coroutines.channels.Send
        public void X(Closed<?> closed) {
        }

        @Override // kotlinx.coroutines.channels.Send
        public Symbol Y(LockFreeLinkedListNode.PrepareOp prepareOp) {
            Symbol symbol = CancellableContinuationImplKt.f51224a;
            if (prepareOp != null) {
                prepareOp.d();
            }
            return symbol;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "SendBuffered@" + DebugStringsKt.b(this) + '(' + this.f51391i + ')';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractSendChannel(Function1<? super E, Unit> function1) {
        this.f51388f = function1;
    }

    private final Object B(E e8, Continuation<? super Unit> continuation) {
        Continuation c8;
        Object d8;
        Object d9;
        Send sendElementWithUndeliveredHandler;
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        CancellableContinuationImpl b8 = CancellableContinuationKt.b(c8);
        while (true) {
            if (r()) {
                if (this.f51388f == null) {
                    sendElementWithUndeliveredHandler = new SendElement(e8, b8);
                } else {
                    sendElementWithUndeliveredHandler = new SendElementWithUndeliveredHandler(e8, b8, this.f51388f);
                }
                Object f8 = f(sendElementWithUndeliveredHandler);
                if (f8 == null) {
                    CancellableContinuationKt.c(b8, sendElementWithUndeliveredHandler);
                    break;
                } else if (f8 instanceof Closed) {
                    n(b8, e8, (Closed) f8);
                    break;
                } else if (f8 != AbstractChannelKt.f51385e && !(f8 instanceof Receive)) {
                    throw new IllegalStateException(("enqueueSend returned " + f8).toString());
                }
            }
            Object t7 = t(e8);
            if (t7 == AbstractChannelKt.f51382b) {
                Result.Companion companion = Result.f50818g;
                b8.resumeWith(Result.b(Unit.f50853a));
                break;
            } else if (t7 != AbstractChannelKt.f51383c) {
                if (t7 instanceof Closed) {
                    n(b8, e8, (Closed) t7);
                } else {
                    throw new IllegalStateException(("offerInternal returned " + t7).toString());
                }
            }
        }
        Object v7 = b8.v();
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

    private final int d() {
        LockFreeLinkedListHead lockFreeLinkedListHead = this.f51389g;
        int i8 = 0;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListHead.K(); !Intrinsics.a(lockFreeLinkedListNode, lockFreeLinkedListHead); lockFreeLinkedListNode = lockFreeLinkedListNode.L()) {
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                i8++;
            }
        }
        return i8;
    }

    private final String k() {
        String str;
        LockFreeLinkedListNode L = this.f51389g.L();
        if (L == this.f51389g) {
            return "EmptyQueue";
        }
        if (L instanceof Closed) {
            str = L.toString();
        } else if (L instanceof Receive) {
            str = "ReceiveQueued";
        } else if (L instanceof Send) {
            str = "SendQueued";
        } else {
            str = "UNEXPECTED:" + L;
        }
        LockFreeLinkedListNode M = this.f51389g.M();
        if (M != L) {
            String str2 = str + ",queueSize=" + d();
            if (M instanceof Closed) {
                return str2 + ",closedForSend=" + M;
            }
            return str2;
        }
        return str;
    }

    private final void l(Closed<?> closed) {
        Receive receive;
        Object b8 = InlineList.b(null, 1, null);
        while (true) {
            LockFreeLinkedListNode M = closed.M();
            if (M instanceof Receive) {
                receive = (Receive) M;
            } else {
                receive = null;
            }
            if (receive == null) {
                break;
            } else if (!receive.Q()) {
                receive.N();
            } else {
                b8 = InlineList.c(b8, receive);
            }
        }
        if (b8 != null) {
            if (!(b8 instanceof ArrayList)) {
                ((Receive) b8).X(closed);
            } else {
                ArrayList arrayList = (ArrayList) b8;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    ((Receive) arrayList.get(size)).X(closed);
                }
            }
        }
        w(closed);
    }

    private final Throwable m(Closed<?> closed) {
        l(closed);
        return closed.d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Continuation<?> continuation, E e8, Closed<?> closed) {
        UndeliveredElementException d8;
        l(closed);
        Throwable d02 = closed.d0();
        Function1<E, Unit> function1 = this.f51388f;
        if (function1 != null && (d8 = OnUndeliveredElementKt.d(function1, e8, null, 2, null)) != null) {
            ExceptionsKt__ExceptionsKt.a(d8, d02);
            Result.Companion companion = Result.f50818g;
            continuation.resumeWith(Result.b(ResultKt.a(d8)));
            return;
        }
        Result.Companion companion2 = Result.f50818g;
        continuation.resumeWith(Result.b(ResultKt.a(d02)));
    }

    private final void o(Throwable th) {
        Symbol symbol;
        Object obj = this.onCloseHandler;
        if (obj != null && obj != (symbol = AbstractChannelKt.f51386f) && a.a(f51387h, this, obj, symbol)) {
            ((Function1) TypeIntrinsics.e(obj, 1)).invoke(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean r() {
        if (!(this.f51389g.L() instanceof ReceiveOrClosed) && q()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ReceiveOrClosed<E> C() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListNode S;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.f51389g;
        while (true) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListHead.K();
            if (lockFreeLinkedListNode != lockFreeLinkedListHead && (lockFreeLinkedListNode instanceof ReceiveOrClosed)) {
                if (((((ReceiveOrClosed) lockFreeLinkedListNode) instanceof Closed) && !lockFreeLinkedListNode.P()) || (S = lockFreeLinkedListNode.S()) == null) {
                    break;
                }
                S.O();
            }
        }
        lockFreeLinkedListNode = null;
        return (ReceiveOrClosed) lockFreeLinkedListNode;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object D(E e8, Continuation<? super Unit> continuation) {
        Object d8;
        if (t(e8) == AbstractChannelKt.f51382b) {
            return Unit.f50853a;
        }
        Object B = B(e8, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (B == d8) {
            return B;
        }
        return Unit.f50853a;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean E() {
        if (i() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Send F() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListNode S;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.f51389g;
        while (true) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListHead.K();
            if (lockFreeLinkedListNode != lockFreeLinkedListHead && (lockFreeLinkedListNode instanceof Send)) {
                if (((((Send) lockFreeLinkedListNode) instanceof Closed) && !lockFreeLinkedListNode.P()) || (S = lockFreeLinkedListNode.S()) == null) {
                    break;
                }
                S.O();
            }
        }
        lockFreeLinkedListNode = null;
        return (Send) lockFreeLinkedListNode;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean b(Throwable th) {
        boolean z7;
        Closed<?> closed = new Closed<>(th);
        LockFreeLinkedListNode lockFreeLinkedListNode = this.f51389g;
        while (true) {
            LockFreeLinkedListNode M = lockFreeLinkedListNode.M();
            z7 = true;
            if (!(!(M instanceof Closed))) {
                z7 = false;
                break;
            } else if (M.E(closed, lockFreeLinkedListNode)) {
                break;
            }
        }
        if (!z7) {
            closed = (Closed) this.f51389g.M();
        }
        l(closed);
        if (z7) {
            o(th);
        }
        return z7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object f(final Send send) {
        boolean z7;
        LockFreeLinkedListNode M;
        if (p()) {
            LockFreeLinkedListNode lockFreeLinkedListNode = this.f51389g;
            do {
                M = lockFreeLinkedListNode.M();
                if (M instanceof ReceiveOrClosed) {
                    return M;
                }
            } while (!M.E(send, lockFreeLinkedListNode));
            return null;
        }
        LockFreeLinkedListNode lockFreeLinkedListNode2 = this.f51389g;
        LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(send) { // from class: kotlinx.coroutines.channels.AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1
            @Override // kotlinx.coroutines.internal.AtomicOp
            /* renamed from: k */
            public Object i(LockFreeLinkedListNode lockFreeLinkedListNode3) {
                if (this.q()) {
                    return null;
                }
                return LockFreeLinkedListKt.a();
            }
        };
        while (true) {
            LockFreeLinkedListNode M2 = lockFreeLinkedListNode2.M();
            if (M2 instanceof ReceiveOrClosed) {
                return M2;
            }
            int U = M2.U(send, lockFreeLinkedListNode2, condAddOp);
            z7 = true;
            if (U != 1) {
                if (U == 2) {
                    z7 = false;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z7) {
            return AbstractChannelKt.f51385e;
        }
        return null;
    }

    protected String g() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Closed<?> h() {
        Closed<?> closed;
        LockFreeLinkedListNode L = this.f51389g.L();
        if (L instanceof Closed) {
            closed = (Closed) L;
        } else {
            closed = null;
        }
        if (closed == null) {
            return null;
        }
        l(closed);
        return closed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Closed<?> i() {
        Closed<?> closed;
        LockFreeLinkedListNode M = this.f51389g.M();
        if (M instanceof Closed) {
            closed = (Closed) M;
        } else {
            closed = null;
        }
        if (closed == null) {
            return null;
        }
        l(closed);
        return closed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LockFreeLinkedListHead j() {
        return this.f51389g;
    }

    protected abstract boolean p();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean q();

    @Override // kotlinx.coroutines.channels.SendChannel
    public void s(Function1<? super Throwable, Unit> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51387h;
        if (!a.a(atomicReferenceFieldUpdater, this, null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj == AbstractChannelKt.f51386f) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        Closed<?> i8 = i();
        if (i8 != null && a.a(atomicReferenceFieldUpdater, this, function1, AbstractChannelKt.f51386f)) {
            function1.invoke(i8.f51414i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object t(E e8) {
        ReceiveOrClosed<E> C;
        do {
            C = C();
            if (C == null) {
                return AbstractChannelKt.f51383c;
            }
        } while (C.w(e8, null) == null);
        C.j(e8);
        return C.b();
    }

    public String toString() {
        return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this) + '{' + k() + '}' + g();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object u(E e8) {
        Object t7 = t(e8);
        if (t7 == AbstractChannelKt.f51382b) {
            return ChannelResult.f51406b.c(Unit.f50853a);
        }
        if (t7 == AbstractChannelKt.f51383c) {
            Closed<?> i8 = i();
            if (i8 == null) {
                return ChannelResult.f51406b.b();
            }
            return ChannelResult.f51406b.a(m(i8));
        } else if (t7 instanceof Closed) {
            return ChannelResult.f51406b.a(m((Closed) t7));
        } else {
            throw new IllegalStateException(("trySend returned " + t7).toString());
        }
    }

    protected void w(LockFreeLinkedListNode lockFreeLinkedListNode) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ReceiveOrClosed<?> y(E e8) {
        LockFreeLinkedListNode M;
        LockFreeLinkedListNode lockFreeLinkedListNode = this.f51389g;
        SendBuffered sendBuffered = new SendBuffered(e8);
        do {
            M = lockFreeLinkedListNode.M();
            if (M instanceof ReceiveOrClosed) {
                return (ReceiveOrClosed) M;
            }
        } while (!M.E(sendBuffered, lockFreeLinkedListNode));
        return null;
    }
}
