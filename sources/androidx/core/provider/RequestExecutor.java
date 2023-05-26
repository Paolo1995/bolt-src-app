package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
class RequestExecutor {

    /* loaded from: classes.dex */
    private static class DefaultThreadFactory implements ThreadFactory {

        /* renamed from: f  reason: collision with root package name */
        private String f5855f;

        /* renamed from: g  reason: collision with root package name */
        private int f5856g;

        /* loaded from: classes.dex */
        private static class ProcessPriorityThread extends Thread {

            /* renamed from: f  reason: collision with root package name */
            private final int f5857f;

            ProcessPriorityThread(Runnable runnable, String str, int i8) {
                super(runnable, str);
                this.f5857f = i8;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f5857f);
                super.run();
            }
        }

        DefaultThreadFactory(@NonNull String str, int i8) {
            this.f5855f = str;
            this.f5856g = i8;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new ProcessPriorityThread(runnable, this.f5855f, this.f5856g);
        }
    }

    /* loaded from: classes.dex */
    private static class ReplyRunnable<T> implements Runnable {
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        private Callable<T> f5858f;
        @NonNull

        /* renamed from: g  reason: collision with root package name */
        private Consumer<T> f5859g;
        @NonNull

        /* renamed from: h  reason: collision with root package name */
        private Handler f5860h;

        ReplyRunnable(@NonNull Handler handler, @NonNull Callable<T> callable, @NonNull Consumer<T> consumer) {
            this.f5858f = callable;
            this.f5859g = consumer;
            this.f5860h = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            final T t7;
            try {
                t7 = this.f5858f.call();
            } catch (Exception unused) {
                t7 = null;
            }
            final Consumer<T> consumer = this.f5859g;
            this.f5860h.post(new Runnable() { // from class: androidx.core.provider.RequestExecutor.ReplyRunnable.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    consumer.accept(t7);
                }
            });
        }
    }

    private RequestExecutor() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadPoolExecutor a(@NonNull String str, int i8, int i9) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i9, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(str, i8));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void b(@NonNull Executor executor, @NonNull Callable<T> callable, @NonNull Consumer<T> consumer) {
        executor.execute(new ReplyRunnable(CalleeHandler.a(), callable, consumer));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T c(@NonNull ExecutorService executorService, @NonNull Callable<T> callable, int i8) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i8, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e8) {
            throw e8;
        } catch (ExecutionException e9) {
            throw new RuntimeException(e9);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
