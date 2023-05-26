package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* compiled from: Builders.common.kt */
/* loaded from: classes5.dex */
public final class DispatchedCoroutine<T> extends ScopeCoroutine<T> {

    /* renamed from: i  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f51259i = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, "_decision");
    private volatile /* synthetic */ int _decision;

    public DispatchedCoroutine(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
        this._decision = 0;
    }

    private final boolean m1() {
        do {
            int i8 = this._decision;
            if (i8 != 0) {
                if (i8 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f51259i.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean n1() {
        do {
            int i8 = this._decision;
            if (i8 != 0) {
                if (i8 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f51259i.compareAndSet(this, 0, 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.JobSupport
    public void M(Object obj) {
        f1(obj);
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.AbstractCoroutine
    protected void f1(Object obj) {
        Continuation c8;
        if (m1()) {
            return;
        }
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(this.f51830h);
        DispatchedContinuationKt.c(c8, CompletionStateKt.a(obj, this.f51830h), null, 2, null);
    }

    public final Object l1() {
        Object d8;
        if (n1()) {
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return d8;
        }
        Object h8 = JobSupportKt.h(r0());
        if (!(h8 instanceof CompletedExceptionally)) {
            return h8;
        }
        throw ((CompletedExceptionally) h8).f51234a;
    }
}
