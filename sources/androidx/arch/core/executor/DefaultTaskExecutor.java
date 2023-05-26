package androidx.arch.core.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class DefaultTaskExecutor extends TaskExecutor {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2302a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f2303b = Executors.newFixedThreadPool(4, new ThreadFactory() { // from class: androidx.arch.core.executor.DefaultTaskExecutor.1

        /* renamed from: f  reason: collision with root package name */
        private final AtomicInteger f2305f = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f2305f.getAndIncrement())));
            return thread;
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private volatile Handler f2304c;

    private static Handler d(@NonNull Looper looper) {
        Handler createAsync;
        if (Build.VERSION.SDK_INT >= 28) {
            createAsync = Handler.createAsync(looper);
            return createAsync;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void a(Runnable runnable) {
        this.f2303b.execute(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean b() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void c(Runnable runnable) {
        if (this.f2304c == null) {
            synchronized (this.f2302a) {
                if (this.f2304c == null) {
                    this.f2304c = d(Looper.getMainLooper());
                }
            }
        }
        this.f2304c.post(runnable);
    }
}
