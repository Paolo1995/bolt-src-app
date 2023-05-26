package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;

/* compiled from: CompletableDeferred.kt */
/* loaded from: classes5.dex */
final class CompletableDeferredImpl<T> extends JobSupport implements CompletableDeferred<T>, SelectClause1<T> {
    public CompletableDeferredImpl(Job job) {
        super(true);
        w0(job);
    }

    @Override // kotlinx.coroutines.Deferred
    public Object N(Continuation<? super T> continuation) {
        Object P = P(continuation);
        IntrinsicsKt__IntrinsicsKt.d();
        return P;
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public boolean a(Throwable th) {
        return E0(new CompletedExceptionally(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public boolean d0(T t7) {
        return E0(t7);
    }

    @Override // kotlinx.coroutines.selects.SelectClause1
    public <R> void n(SelectInstance<? super R> selectInstance, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Q0(selectInstance, function2);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean o0() {
        return true;
    }

    @Override // kotlinx.coroutines.Deferred
    public T q() {
        return (T) j0();
    }
}
