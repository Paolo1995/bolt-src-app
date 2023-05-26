package kotlinx.coroutines.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.Job;

/* compiled from: Scopes.kt */
/* loaded from: classes5.dex */
public class ScopeCoroutine<T> extends AbstractCoroutine<T> implements CoroutineStackFrame {

    /* renamed from: h  reason: collision with root package name */
    public final Continuation<T> f51830h;

    /* JADX WARN: Multi-variable type inference failed */
    public ScopeCoroutine(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, true, true);
        this.f51830h = continuation;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public void M(Object obj) {
        Continuation c8;
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(this.f51830h);
        DispatchedContinuationKt.c(c8, CompletionStateKt.a(obj, this.f51830h), null, 2, null);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void f1(Object obj) {
        Continuation<T> continuation = this.f51830h;
        continuation.resumeWith(CompletionStateKt.a(obj, continuation));
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f51830h;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    public final Job k1() {
        ChildHandle q02 = q0();
        if (q02 != null) {
            return q02.getParent();
        }
        return null;
    }

    @Override // kotlinx.coroutines.JobSupport
    protected final boolean x0() {
        return true;
    }
}
