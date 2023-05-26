package kotlinx.coroutines;

import java.util.concurrent.Future;

/* compiled from: Future.kt */
/* loaded from: classes5.dex */
final /* synthetic */ class JobKt__FutureKt {
    public static final void a(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        cancellableContinuation.o(new CancelFutureOnCancel(future));
    }
}
