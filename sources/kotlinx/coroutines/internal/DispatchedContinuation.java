package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ThreadLocalEventLoop;

/* compiled from: DispatchedContinuation.kt */
/* loaded from: classes5.dex */
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {

    /* renamed from: m  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f51782m = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation;

    /* renamed from: i  reason: collision with root package name */
    public final CoroutineDispatcher f51783i;

    /* renamed from: j  reason: collision with root package name */
    public final Continuation<T> f51784j;

    /* renamed from: k  reason: collision with root package name */
    public Object f51785k;

    /* renamed from: l  reason: collision with root package name */
    public final Object f51786l;

    /* JADX WARN: Multi-variable type inference failed */
    public DispatchedContinuation(CoroutineDispatcher coroutineDispatcher, Continuation<? super T> continuation) {
        super(-1);
        this.f51783i = coroutineDispatcher;
        this.f51784j = continuation;
        this.f51785k = DispatchedContinuationKt.a();
        this.f51786l = ThreadContextKt.b(getContext());
        this._reusableCancellableContinuation = null;
    }

    private final CancellableContinuationImpl<?> l() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof CancellableContinuationImpl) {
            return (CancellableContinuationImpl) obj;
        }
        return null;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void a(Object obj, Throwable th) {
        if (obj instanceof CompletedWithCancellation) {
            ((CompletedWithCancellation) obj).f51236b.invoke(th);
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Continuation<T> b() {
        return this;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object g() {
        Object obj = this.f51785k;
        this.f51785k = DispatchedContinuationKt.a();
        return obj;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f51784j;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f51784j.getContext();
    }

    public final void h() {
        do {
        } while (this._reusableCancellableContinuation == DispatchedContinuationKt.f51788b);
    }

    public final CancellableContinuationImpl<T> j() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = DispatchedContinuationKt.f51788b;
                return null;
            } else if (obj instanceof CancellableContinuationImpl) {
                if (a.a(f51782m, this, obj, DispatchedContinuationKt.f51788b)) {
                    return (CancellableContinuationImpl) obj;
                }
            } else if (obj != DispatchedContinuationKt.f51788b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void k(CoroutineContext coroutineContext, T t7) {
        this.f51785k = t7;
        this.f51260h = 1;
        this.f51783i.I0(coroutineContext, this);
    }

    public final boolean m() {
        if (this._reusableCancellableContinuation != null) {
            return true;
        }
        return false;
    }

    public final boolean n(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            Symbol symbol = DispatchedContinuationKt.f51788b;
            if (Intrinsics.a(obj, symbol)) {
                if (a.a(f51782m, this, symbol, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (a.a(f51782m, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void q() {
        h();
        CancellableContinuationImpl<?> l8 = l();
        if (l8 != null) {
            l8.q();
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        CoroutineContext context = this.f51784j.getContext();
        Object d8 = CompletionStateKt.d(obj, null, 1, null);
        if (this.f51783i.K0(context)) {
            this.f51785k = d8;
            this.f51260h = 0;
            this.f51783i.G0(context, this);
            return;
        }
        EventLoop b8 = ThreadLocalEventLoop.f51332a.b();
        if (b8.f1()) {
            this.f51785k = d8;
            this.f51260h = 0;
            b8.W0(this);
            return;
        }
        b8.b1(true);
        try {
            CoroutineContext context2 = getContext();
            Object c8 = ThreadContextKt.c(context2, this.f51786l);
            this.f51784j.resumeWith(obj);
            Unit unit = Unit.f50853a;
            ThreadContextKt.a(context2, c8);
            do {
            } while (b8.m1());
        } finally {
            try {
            } finally {
            }
        }
    }

    public final Throwable s(CancellableContinuation<?> cancellableContinuation) {
        Symbol symbol;
        do {
            Object obj = this._reusableCancellableContinuation;
            symbol = DispatchedContinuationKt.f51788b;
            if (obj != symbol) {
                if (obj instanceof Throwable) {
                    if (a.a(f51782m, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!a.a(f51782m, this, symbol, cancellableContinuation));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f51783i + ", " + DebugStringsKt.c(this.f51784j) + ']';
    }
}
