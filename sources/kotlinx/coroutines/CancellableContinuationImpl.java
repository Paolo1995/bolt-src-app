package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes5.dex */
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame {

    /* renamed from: l  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f51219l = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decision");

    /* renamed from: m  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f51220m = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;

    /* renamed from: i  reason: collision with root package name */
    private final Continuation<T> f51221i;

    /* renamed from: j  reason: collision with root package name */
    private final CoroutineContext f51222j;

    /* renamed from: k  reason: collision with root package name */
    private DisposableHandle f51223k;

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(Continuation<? super T> continuation, int i8) {
        super(i8);
        this.f51221i = continuation;
        this.f51222j = continuation.getContext();
        this._decision = 0;
        this._state = Active.f51207f;
    }

    private final boolean A() {
        if (DispatchedTaskKt.c(this.f51260h) && ((DispatchedContinuation) this.f51221i).m()) {
            return true;
        }
        return false;
    }

    private final CancelHandler D(Function1<? super Throwable, Unit> function1) {
        if (function1 instanceof CancelHandler) {
            return (CancelHandler) function1;
        }
        return new InvokeOnCancel(function1);
    }

    private final void E(Function1<? super Throwable, Unit> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    private final void I() {
        DispatchedContinuation dispatchedContinuation;
        Throwable s7;
        Continuation<T> continuation = this.f51221i;
        if (continuation instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) continuation;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation != null && (s7 = dispatchedContinuation.s(this)) != null) {
            q();
            m(s7);
        }
    }

    private final void K(Object obj, int i8, Function1<? super Throwable, Unit> function1) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
            } else {
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    if (cancelledContinuation.c()) {
                        if (function1 != null) {
                            l(function1, cancelledContinuation.f51234a);
                            return;
                        }
                        return;
                    }
                }
                h(obj);
                throw new KotlinNothingValueException();
            }
        } while (!androidx.concurrent.futures.a.a(f51220m, this, obj2, M((NotCompleted) obj2, obj, i8, function1, null)));
        s();
        t(i8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void L(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i8, Function1 function1, int i9, Object obj2) {
        if (obj2 == null) {
            if ((i9 & 4) != 0) {
                function1 = null;
            }
            cancellableContinuationImpl.K(obj, i8, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object M(NotCompleted notCompleted, Object obj, int i8, Function1<? super Throwable, Unit> function1, Object obj2) {
        CancelHandler cancelHandler;
        if (!(obj instanceof CompletedExceptionally)) {
            if (DispatchedTaskKt.b(i8) || obj2 != null) {
                if (function1 != null || (((notCompleted instanceof CancelHandler) && !(notCompleted instanceof BeforeResumeCancelHandler)) || obj2 != null)) {
                    if (notCompleted instanceof CancelHandler) {
                        cancelHandler = (CancelHandler) notCompleted;
                    } else {
                        cancelHandler = null;
                    }
                    return new CompletedContinuation(obj, cancelHandler, function1, obj2, null, 16, null);
                }
                return obj;
            }
            return obj;
        }
        return obj;
    }

    private final boolean N() {
        do {
            int i8 = this._decision;
            if (i8 != 0) {
                if (i8 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f51219l.compareAndSet(this, 0, 2));
        return true;
    }

    private final Symbol O(Object obj, Object obj2, Function1<? super Throwable, Unit> function1) {
        Object obj3;
        do {
            obj3 = this._state;
            if (obj3 instanceof NotCompleted) {
            } else if (!(obj3 instanceof CompletedContinuation) || obj2 == null || ((CompletedContinuation) obj3).f51231d != obj2) {
                return null;
            } else {
                return CancellableContinuationImplKt.f51224a;
            }
        } while (!androidx.concurrent.futures.a.a(f51220m, this, obj3, M((NotCompleted) obj3, obj, this.f51260h, function1, obj2)));
        s();
        return CancellableContinuationImplKt.f51224a;
    }

    private final boolean P() {
        do {
            int i8 = this._decision;
            if (i8 != 0) {
                if (i8 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f51219l.compareAndSet(this, 0, 1));
        return true;
    }

    private final Void h(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void j(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            CoroutineExceptionHandlerKt.a(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final boolean n(Throwable th) {
        if (!A()) {
            return false;
        }
        return ((DispatchedContinuation) this.f51221i).n(th);
    }

    private final void s() {
        if (!A()) {
            q();
        }
    }

    private final void t(int i8) {
        if (N()) {
            return;
        }
        DispatchedTaskKt.a(this, i8);
    }

    private final String x() {
        Object w7 = w();
        if (w7 instanceof NotCompleted) {
            return "Active";
        }
        if (w7 instanceof CancelledContinuation) {
            return "Cancelled";
        }
        return "Completed";
    }

    private final DisposableHandle z() {
        Job job = (Job) getContext().g(Job.f51296d);
        if (job == null) {
            return null;
        }
        DisposableHandle d8 = Job.DefaultImpls.d(job, true, false, new ChildContinuation(this), 2, null);
        this.f51223k = d8;
        return d8;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object B(T t7, Object obj, Function1<? super Throwable, Unit> function1) {
        return O(t7, obj, function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void C(CoroutineDispatcher coroutineDispatcher, T t7) {
        DispatchedContinuation dispatchedContinuation;
        int i8;
        Continuation<T> continuation = this.f51221i;
        CoroutineDispatcher coroutineDispatcher2 = null;
        if (continuation instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) continuation;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.f51783i;
        }
        if (coroutineDispatcher2 == coroutineDispatcher) {
            i8 = 4;
        } else {
            i8 = this.f51260h;
        }
        L(this, t7, i8, null, 4, null);
    }

    protected String F() {
        return "CancellableContinuation";
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void G(Object obj) {
        t(this.f51260h);
    }

    public final void H(Throwable th) {
        if (n(th)) {
            return;
        }
        m(th);
        s();
    }

    public final boolean J() {
        Object obj = this._state;
        if ((obj instanceof CompletedContinuation) && ((CompletedContinuation) obj).f51231d != null) {
            q();
            return false;
        }
        this._decision = 0;
        this._state = Active.f51207f;
        return true;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void a(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (!(obj2 instanceof NotCompleted)) {
                if (obj2 instanceof CompletedExceptionally) {
                    return;
                }
                if (obj2 instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj2;
                    if (!completedContinuation.c()) {
                        if (androidx.concurrent.futures.a.a(f51220m, this, obj2, CompletedContinuation.b(completedContinuation, null, null, null, null, th, 15, null))) {
                            completedContinuation.d(this, th);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (androidx.concurrent.futures.a.a(f51220m, this, obj2, new CompletedContinuation(obj2, null, null, null, th, 14, null))) {
                    return;
                }
            } else {
                throw new IllegalStateException("Not completed".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation<T> b() {
        return this.f51221i;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean c() {
        return !(w() instanceof NotCompleted);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Throwable d(Object obj) {
        Throwable d8 = super.d(obj);
        if (d8 == null) {
            return null;
        }
        return d8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T e(Object obj) {
        if (obj instanceof CompletedContinuation) {
            return (T) ((CompletedContinuation) obj).f51228a;
        }
        return obj;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object g() {
        return w();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f51221i;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f51222j;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object i(T t7, Object obj) {
        return O(t7, obj, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isActive() {
        return w() instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCancelled() {
        return w() instanceof CancelledContinuation;
    }

    public final void k(CancelHandler cancelHandler, Throwable th) {
        try {
            cancelHandler.b(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            CoroutineExceptionHandlerKt.a(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void l(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            CoroutineExceptionHandlerKt.a(context, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public boolean m(Throwable th) {
        Object obj;
        boolean z7;
        CancelHandler cancelHandler;
        do {
            obj = this._state;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            z7 = obj instanceof CancelHandler;
        } while (!androidx.concurrent.futures.a.a(f51220m, this, obj, new CancelledContinuation(this, th, z7)));
        if (z7) {
            cancelHandler = (CancelHandler) obj;
        } else {
            cancelHandler = null;
        }
        if (cancelHandler != null) {
            k(cancelHandler, th);
        }
        s();
        t(this.f51260h);
        return true;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void o(Function1<? super Throwable, Unit> function1) {
        CancelHandler D = D(function1);
        while (true) {
            Object obj = this._state;
            if (obj instanceof Active) {
                if (androidx.concurrent.futures.a.a(f51220m, this, obj, D)) {
                    return;
                }
            } else if (obj instanceof CancelHandler) {
                E(function1, obj);
            } else {
                boolean z7 = obj instanceof CompletedExceptionally;
                if (z7) {
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                    if (!completedExceptionally.b()) {
                        E(function1, obj);
                    }
                    if (obj instanceof CancelledContinuation) {
                        Throwable th = null;
                        if (!z7) {
                            completedExceptionally = null;
                        }
                        if (completedExceptionally != null) {
                            th = completedExceptionally.f51234a;
                        }
                        j(function1, th);
                        return;
                    }
                    return;
                } else if (obj instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                    if (completedContinuation.f51229b != null) {
                        E(function1, obj);
                    }
                    if (D instanceof BeforeResumeCancelHandler) {
                        return;
                    }
                    if (completedContinuation.c()) {
                        j(function1, completedContinuation.f51232e);
                        return;
                    }
                    if (androidx.concurrent.futures.a.a(f51220m, this, obj, CompletedContinuation.b(completedContinuation, null, D, null, null, null, 29, null))) {
                        return;
                    }
                } else if (D instanceof BeforeResumeCancelHandler) {
                    return;
                } else {
                    if (androidx.concurrent.futures.a.a(f51220m, this, obj, new CompletedContinuation(obj, D, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object p(Throwable th) {
        return O(new CompletedExceptionally(th, false, 2, null), null, null);
    }

    public final void q() {
        DisposableHandle disposableHandle = this.f51223k;
        if (disposableHandle == null) {
            return;
        }
        disposableHandle.dispose();
        this.f51223k = NonDisposableHandle.f51324f;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void r(T t7, Function1<? super Throwable, Unit> function1) {
        K(t7, this.f51260h, function1);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        L(this, CompletionStateKt.c(obj, this), this.f51260h, null, 4, null);
    }

    public String toString() {
        return F() + '(' + DebugStringsKt.c(this.f51221i) + "){" + x() + "}@" + DebugStringsKt.b(this);
    }

    public Throwable u(Job job) {
        return job.I();
    }

    public final Object v() {
        Job job;
        Object d8;
        boolean A = A();
        if (P()) {
            if (this.f51223k == null) {
                z();
            }
            if (A) {
                I();
            }
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return d8;
        }
        if (A) {
            I();
        }
        Object w7 = w();
        if (!(w7 instanceof CompletedExceptionally)) {
            if (DispatchedTaskKt.b(this.f51260h) && (job = (Job) getContext().g(Job.f51296d)) != null && !job.isActive()) {
                CancellationException I = job.I();
                a(w7, I);
                throw I;
            }
            return e(w7);
        }
        throw ((CompletedExceptionally) w7).f51234a;
    }

    public final Object w() {
        return this._state;
    }

    public void y() {
        DisposableHandle z7 = z();
        if (z7 != null && c()) {
            z7.dispose();
            this.f51223k = NonDisposableHandle.f51324f;
        }
    }
}
