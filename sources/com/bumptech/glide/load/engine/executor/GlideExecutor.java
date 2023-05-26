package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class GlideExecutor implements ExecutorService {

    /* renamed from: g  reason: collision with root package name */
    private static final long f10267g = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: h  reason: collision with root package name */
    private static volatile int f10268h;

    /* renamed from: f  reason: collision with root package name */
    private final ExecutorService f10269f;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f10270a;

        /* renamed from: b  reason: collision with root package name */
        private int f10271b;

        /* renamed from: c  reason: collision with root package name */
        private int f10272c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private UncaughtThrowableStrategy f10273d = UncaughtThrowableStrategy.f10284d;

        /* renamed from: e  reason: collision with root package name */
        private String f10274e;

        /* renamed from: f  reason: collision with root package name */
        private long f10275f;

        Builder(boolean z7) {
            this.f10270a = z7;
        }

        public GlideExecutor a() {
            if (!TextUtils.isEmpty(this.f10274e)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f10271b, this.f10272c, this.f10275f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(this.f10274e, this.f10273d, this.f10270a));
                if (this.f10275f != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new GlideExecutor(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f10274e);
        }

        public Builder b(String str) {
            this.f10274e = str;
            return this;
        }

        public Builder c(int i8) {
            this.f10271b = i8;
            this.f10272c = i8;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class DefaultThreadFactory implements ThreadFactory {

        /* renamed from: f  reason: collision with root package name */
        private final String f10276f;

        /* renamed from: g  reason: collision with root package name */
        final UncaughtThrowableStrategy f10277g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f10278h;

        /* renamed from: i  reason: collision with root package name */
        private int f10279i;

        DefaultThreadFactory(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z7) {
            this.f10276f = str;
            this.f10277g = uncaughtThrowableStrategy;
            this.f10278h = z7;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-" + this.f10276f + "-thread-" + this.f10279i) { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.DefaultThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(9);
                    if (DefaultThreadFactory.this.f10278h) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th) {
                        DefaultThreadFactory.this.f10277g.a(th);
                    }
                }
            };
            this.f10279i = this.f10279i + 1;
            return thread;
        }
    }

    /* loaded from: classes.dex */
    public interface UncaughtThrowableStrategy {

        /* renamed from: a  reason: collision with root package name */
        public static final UncaughtThrowableStrategy f10281a = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.1
            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
            public void a(Throwable th) {
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final UncaughtThrowableStrategy f10282b;

        /* renamed from: c  reason: collision with root package name */
        public static final UncaughtThrowableStrategy f10283c;

        /* renamed from: d  reason: collision with root package name */
        public static final UncaughtThrowableStrategy f10284d;

        static {
            UncaughtThrowableStrategy uncaughtThrowableStrategy = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.2
                @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
                public void a(Throwable th) {
                    if (th != null && Log.isLoggable("GlideExecutor", 6)) {
                        Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                    }
                }
            };
            f10282b = uncaughtThrowableStrategy;
            f10283c = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.3
                @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
                public void a(Throwable th) {
                    if (th == null) {
                        return;
                    }
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            };
            f10284d = uncaughtThrowableStrategy;
        }

        void a(Throwable th);
    }

    GlideExecutor(ExecutorService executorService) {
        this.f10269f = executorService;
    }

    public static int a() {
        if (f10268h == 0) {
            f10268h = Math.min(4, RuntimeCompat.a());
        }
        return f10268h;
    }

    public static Builder b() {
        int i8;
        if (a() >= 4) {
            i8 = 2;
        } else {
            i8 = 1;
        }
        return new Builder(true).c(i8).b("animation");
    }

    public static GlideExecutor c() {
        return b().a();
    }

    public static Builder d() {
        return new Builder(true).c(1).b("disk-cache");
    }

    public static GlideExecutor e() {
        return d().a();
    }

    public static Builder f() {
        return new Builder(false).c(a()).b("source");
    }

    public static GlideExecutor g() {
        return f().a();
    }

    public static GlideExecutor h() {
        return new GlideExecutor(new ThreadPoolExecutor(0, (int) Api.BaseClientBuilder.API_PRIORITY_OTHER, f10267g, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory("source-unlimited", UncaughtThrowableStrategy.f10284d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j8, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f10269f.awaitTermination(j8, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f10269f.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f10269f.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.f10269f.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f10269f.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f10269f.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f10269f.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f10269f.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f10269f.submit(runnable);
    }

    public String toString() {
        return this.f10269f.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j8, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f10269f.invokeAll(collection, j8, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j8, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.f10269f.invokeAny(collection, j8, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t7) {
        return this.f10269f.submit(runnable, t7);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f10269f.submit(callable);
    }
}
