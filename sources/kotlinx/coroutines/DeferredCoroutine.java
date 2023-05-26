package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.common.kt */
/* loaded from: classes5.dex */
public class DeferredCoroutine<T> extends AbstractCoroutine<T> implements Deferred<T>, SelectClause1<T> {
    public DeferredCoroutine(CoroutineContext coroutineContext, boolean z7) {
        super(coroutineContext, true, z7);
    }

    static /* synthetic */ Object k1(DeferredCoroutine deferredCoroutine, Continuation continuation) {
        Object P = deferredCoroutine.P(continuation);
        IntrinsicsKt__IntrinsicsKt.d();
        return P;
    }

    @Override // kotlinx.coroutines.Deferred
    public Object N(Continuation<? super T> continuation) {
        return k1(this, continuation);
    }

    @Override // kotlinx.coroutines.selects.SelectClause1
    public <R> void n(SelectInstance<? super R> selectInstance, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Q0(selectInstance, function2);
    }

    @Override // kotlinx.coroutines.Deferred
    public T q() {
        return (T) j0();
    }
}
