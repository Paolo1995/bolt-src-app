package kotlinx.coroutines;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ThreadPoolDispatcher.kt */
/* loaded from: classes5.dex */
public final class ThreadPoolDispatcherKt {
    public static final ExecutorCoroutineDispatcher b(final int i8, final String str) {
        boolean z7 = true;
        if (i8 < 1) {
            z7 = false;
        }
        if (z7) {
            final AtomicInteger atomicInteger = new AtomicInteger();
            return ExecutorsKt.b(Executors.newScheduledThreadPool(i8, new ThreadFactory() { // from class: kotlinx.coroutines.a
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread c8;
                    c8 = ThreadPoolDispatcherKt.c(i8, str, atomicInteger, runnable);
                    return c8;
                }
            }));
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i8 + " specified").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread c(int i8, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i8 != 1) {
            str = str + '-' + atomicInteger.incrementAndGet();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }

    public static final ExecutorCoroutineDispatcher d(String str) {
        return b(1, str);
    }
}
