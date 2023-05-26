package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;

/* compiled from: Interruptible.kt */
/* loaded from: classes5.dex */
public final class InterruptibleKt {
    public static final <T> Object b(CoroutineContext coroutineContext, Function0<? extends T> function0, Continuation<? super T> continuation) {
        return BuildersKt.g(coroutineContext, new InterruptibleKt$runInterruptible$2(function0, null), continuation);
    }

    public static /* synthetic */ Object c(CoroutineContext coroutineContext, Function0 function0, Continuation continuation, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f50912f;
        }
        return b(coroutineContext, function0, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T d(CoroutineContext coroutineContext, Function0<? extends T> function0) {
        try {
            ThreadState threadState = new ThreadState(JobKt.k(coroutineContext));
            threadState.e();
            T invoke = function0.invoke();
            threadState.b();
            return invoke;
        } catch (InterruptedException e8) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e8);
        }
    }
}
