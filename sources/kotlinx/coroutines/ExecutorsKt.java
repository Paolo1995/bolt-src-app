package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: Executors.kt */
/* loaded from: classes5.dex */
public final class ExecutorsKt {
    public static final CoroutineDispatcher a(Executor executor) {
        DispatcherExecutor dispatcherExecutor;
        CoroutineDispatcher coroutineDispatcher;
        if (executor instanceof DispatcherExecutor) {
            dispatcherExecutor = (DispatcherExecutor) executor;
        } else {
            dispatcherExecutor = null;
        }
        if (dispatcherExecutor == null || (coroutineDispatcher = dispatcherExecutor.f51261f) == null) {
            return new ExecutorCoroutineDispatcherImpl(executor);
        }
        return coroutineDispatcher;
    }

    public static final ExecutorCoroutineDispatcher b(ExecutorService executorService) {
        return new ExecutorCoroutineDispatcherImpl(executorService);
    }
}
