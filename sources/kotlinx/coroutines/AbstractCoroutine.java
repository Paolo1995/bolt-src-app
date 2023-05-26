package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* compiled from: AbstractCoroutine.kt */
/* loaded from: classes5.dex */
public abstract class AbstractCoroutine<T> extends JobSupport implements Continuation<T>, CoroutineScope {

    /* renamed from: g  reason: collision with root package name */
    private final CoroutineContext f51205g;

    public AbstractCoroutine(CoroutineContext coroutineContext, boolean z7, boolean z8) {
        super(z8);
        if (z7) {
            w0((Job) coroutineContext.g(Job.f51296d));
        }
        this.f51205g = coroutineContext.s0(this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public String H0() {
        String b8 = CoroutineContextKt.b(this.f51205g);
        if (b8 == null) {
            return super.H0();
        }
        return '\"' + b8 + "\":" + super.H0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport
    protected final void M0(Object obj) {
        if (obj instanceof CompletedExceptionally) {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            h1(completedExceptionally.f51234a, completedExceptionally.a());
            return;
        }
        i1(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public String W() {
        return DebugStringsKt.a(this) + " was cancelled";
    }

    protected void f1(Object obj) {
        M(obj);
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f51205g;
    }

    protected void h1(Throwable th, boolean z7) {
    }

    protected void i1(T t7) {
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return this.f51205g;
    }

    public final <R> void j1(CoroutineStart coroutineStart, R r7, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        coroutineStart.c(function2, r7, this);
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object F0 = F0(CompletionStateKt.d(obj, null, 1, null));
        if (F0 == JobSupportKt.f51316b) {
            return;
        }
        f1(F0);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void u0(Throwable th) {
        CoroutineExceptionHandlerKt.a(this.f51205g, th);
    }
}
