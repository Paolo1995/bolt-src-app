package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Delay.kt */
/* loaded from: classes5.dex */
public interface Delay {

    /* compiled from: Delay.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static DisposableHandle a(Delay delay, long j8, Runnable runnable, CoroutineContext coroutineContext) {
            return DefaultExecutorKt.a().Y(j8, runnable, coroutineContext);
        }
    }

    DisposableHandle Y(long j8, Runnable runnable, CoroutineContext coroutineContext);

    void j(long j8, CancellableContinuation<? super Unit> cancellableContinuation);
}
