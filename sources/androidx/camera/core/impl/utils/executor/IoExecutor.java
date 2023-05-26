package androidx.camera.core.impl.utils.executor;

import androidx.annotation.NonNull;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
final class IoExecutor implements Executor {

    /* renamed from: g  reason: collision with root package name */
    private static volatile Executor f3837g;

    /* renamed from: f  reason: collision with root package name */
    private final ExecutorService f3838f = Executors.newFixedThreadPool(2, new ThreadFactory() { // from class: androidx.camera.core.impl.utils.executor.IoExecutor.1

        /* renamed from: f  reason: collision with root package name */
        private final AtomicInteger f3839f = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format(Locale.US, "CameraX-camerax_io_%d", Integer.valueOf(this.f3839f.getAndIncrement())));
            return thread;
        }
    });

    IoExecutor() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor a() {
        if (f3837g != null) {
            return f3837g;
        }
        synchronized (IoExecutor.class) {
            if (f3837g == null) {
                f3837g = new IoExecutor();
            }
        }
        return f3837g;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f3838f.execute(runnable);
    }
}
