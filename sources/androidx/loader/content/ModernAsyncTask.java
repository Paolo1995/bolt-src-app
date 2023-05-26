package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
abstract class ModernAsyncTask<Params, Progress, Result> {

    /* renamed from: k  reason: collision with root package name */
    private static final ThreadFactory f6836k;

    /* renamed from: l  reason: collision with root package name */
    private static final BlockingQueue<Runnable> f6837l;

    /* renamed from: m  reason: collision with root package name */
    public static final Executor f6838m;

    /* renamed from: n  reason: collision with root package name */
    private static InternalHandler f6839n;

    /* renamed from: o  reason: collision with root package name */
    private static volatile Executor f6840o;

    /* renamed from: f  reason: collision with root package name */
    private final WorkerRunnable<Params, Result> f6841f;

    /* renamed from: g  reason: collision with root package name */
    private final FutureTask<Result> f6842g;

    /* renamed from: h  reason: collision with root package name */
    private volatile Status f6843h = Status.PENDING;

    /* renamed from: i  reason: collision with root package name */
    final AtomicBoolean f6844i = new AtomicBoolean();

    /* renamed from: j  reason: collision with root package name */
    final AtomicBoolean f6845j = new AtomicBoolean();

    /* renamed from: androidx.loader.content.ModernAsyncTask$4  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6849a;

        static {
            int[] iArr = new int[Status.values().length];
            f6849a = iArr;
            try {
                iArr[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6849a[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AsyncTaskResult<Data> {

        /* renamed from: a  reason: collision with root package name */
        final ModernAsyncTask f6850a;

        /* renamed from: b  reason: collision with root package name */
        final Data[] f6851b;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f6850a = modernAsyncTask;
            this.f6851b = dataArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class InternalHandler extends Handler {
        InternalHandler() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            int i8 = message.what;
            if (i8 != 1) {
                if (i8 == 2) {
                    asyncTaskResult.f6850a.k(asyncTaskResult.f6851b);
                    return;
                }
                return;
            }
            asyncTaskResult.f6850a.d(asyncTaskResult.f6851b[0]);
        }
    }

    /* loaded from: classes.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* loaded from: classes.dex */
    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {

        /* renamed from: f  reason: collision with root package name */
        Params[] f6856f;

        WorkerRunnable() {
        }
    }

    static {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: androidx.loader.content.ModernAsyncTask.1

            /* renamed from: f  reason: collision with root package name */
            private final AtomicInteger f6846f = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ModernAsyncTask #" + this.f6846f.getAndIncrement());
            }
        };
        f6836k = threadFactory;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f6837l = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
        f6838m = threadPoolExecutor;
        f6840o = threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModernAsyncTask() {
        WorkerRunnable<Params, Result> workerRunnable = new WorkerRunnable<Params, Result>() { // from class: androidx.loader.content.ModernAsyncTask.2
            @Override // java.util.concurrent.Callable
            public Result call() throws Exception {
                ModernAsyncTask.this.f6845j.set(true);
                Result result = null;
                try {
                    Process.setThreadPriority(10);
                    result = (Result) ModernAsyncTask.this.b(this.f6856f);
                    Binder.flushPendingCommands();
                    return result;
                } finally {
                }
            }
        };
        this.f6841f = workerRunnable;
        this.f6842g = new FutureTask<Result>(workerRunnable) { // from class: androidx.loader.content.ModernAsyncTask.3
            @Override // java.util.concurrent.FutureTask
            protected void done() {
                try {
                    ModernAsyncTask.this.m(get());
                } catch (InterruptedException e8) {
                    Log.w("AsyncTask", e8);
                } catch (CancellationException unused) {
                    ModernAsyncTask.this.m(null);
                } catch (ExecutionException e9) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", e9.getCause());
                } catch (Throwable th) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", th);
                }
            }
        };
    }

    private static Handler e() {
        InternalHandler internalHandler;
        synchronized (ModernAsyncTask.class) {
            if (f6839n == null) {
                f6839n = new InternalHandler();
            }
            internalHandler = f6839n;
        }
        return internalHandler;
    }

    public final boolean a(boolean z7) {
        this.f6844i.set(true);
        return this.f6842g.cancel(z7);
    }

    protected abstract Result b(Params... paramsArr);

    public final ModernAsyncTask<Params, Progress, Result> c(Executor executor, Params... paramsArr) {
        if (this.f6843h != Status.PENDING) {
            int i8 = AnonymousClass4.f6849a[this.f6843h.ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    throw new IllegalStateException("We should never reach this state");
                }
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        this.f6843h = Status.RUNNING;
        j();
        this.f6841f.f6856f = paramsArr;
        executor.execute(this.f6842g);
        return this;
    }

    void d(Result result) {
        if (f()) {
            h(result);
        } else {
            i(result);
        }
        this.f6843h = Status.FINISHED;
    }

    public final boolean f() {
        return this.f6844i.get();
    }

    protected void g() {
    }

    protected void h(Result result) {
        g();
    }

    protected void i(Result result) {
    }

    protected void j() {
    }

    protected void k(Progress... progressArr) {
    }

    Result l(Result result) {
        e().obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    void m(Result result) {
        if (!this.f6845j.get()) {
            l(result);
        }
    }
}
