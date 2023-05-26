package androidx.camera.core.impl.utils.executor;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
final class HighPriorityExecutor implements Executor {

    /* renamed from: g  reason: collision with root package name */
    private static volatile Executor f3834g;

    /* renamed from: f  reason: collision with root package name */
    private final ExecutorService f3835f = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: androidx.camera.core.impl.utils.executor.HighPriorityExecutor.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(10);
            thread.setName("CameraX-camerax_high_priority");
            return thread;
        }
    });

    HighPriorityExecutor() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor a() {
        if (f3834g != null) {
            return f3834g;
        }
        synchronized (HighPriorityExecutor.class) {
            if (f3834g == null) {
                f3834g = new HighPriorityExecutor();
            }
        }
        return f3834g;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f3835f.execute(runnable);
    }
}
