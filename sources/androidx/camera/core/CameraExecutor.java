package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraFactory;
import androidx.core.util.Preconditions;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
class CameraExecutor implements Executor {

    /* renamed from: h  reason: collision with root package name */
    private static final ThreadFactory f3047h = new ThreadFactory() { // from class: androidx.camera.core.CameraExecutor.1

        /* renamed from: f  reason: collision with root package name */
        private final AtomicInteger f3050f = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format(Locale.US, "CameraX-core_camera_%d", Integer.valueOf(this.f3050f.getAndIncrement())));
            return thread;
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final Object f3048f = new Object();
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private ThreadPoolExecutor f3049g = b();

    private static ThreadPoolExecutor b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), f3047h);
        threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() { // from class: androidx.camera.core.c
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                Logger.c("CameraExecutor", "A rejected execution occurred in CameraExecutor!");
            }
        });
        return threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@NonNull CameraFactory cameraFactory) {
        ThreadPoolExecutor threadPoolExecutor;
        Preconditions.g(cameraFactory);
        synchronized (this.f3048f) {
            if (this.f3049g.isShutdown()) {
                this.f3049g = b();
            }
            threadPoolExecutor = this.f3049g;
        }
        int max = Math.max(1, cameraFactory.b().size());
        threadPoolExecutor.setMaximumPoolSize(max);
        threadPoolExecutor.setCorePoolSize(max);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        Preconditions.g(runnable);
        synchronized (this.f3048f) {
            this.f3049g.execute(runnable);
        }
    }
}
