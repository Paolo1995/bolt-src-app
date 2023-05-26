package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: CancellableContinuation.kt */
/* loaded from: classes5.dex */
public interface CancellableContinuation<T> extends Continuation<T> {

    /* compiled from: CancellableContinuation.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object a(CancellableContinuation cancellableContinuation, Object obj, Object obj2, int i8, Object obj3) {
            if (obj3 == null) {
                if ((i8 & 2) != 0) {
                    obj2 = null;
                }
                return cancellableContinuation.i(obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
        }
    }

    Object B(T t7, Object obj, Function1<? super Throwable, Unit> function1);

    void C(CoroutineDispatcher coroutineDispatcher, T t7);

    void G(Object obj);

    boolean c();

    Object i(T t7, Object obj);

    boolean isActive();

    boolean isCancelled();

    void o(Function1<? super Throwable, Unit> function1);

    Object p(Throwable th);

    void r(T t7, Function1<? super Throwable, Unit> function1);
}
