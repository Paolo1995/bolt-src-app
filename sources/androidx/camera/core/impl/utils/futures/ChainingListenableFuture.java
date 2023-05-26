package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ChainingListenableFuture<I, O> extends FutureChain<O> implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    private AsyncFunction<? super I, ? extends O> f3855h;

    /* renamed from: i  reason: collision with root package name */
    private final BlockingQueue<Boolean> f3856i = new LinkedBlockingQueue(1);

    /* renamed from: j  reason: collision with root package name */
    private final CountDownLatch f3857j = new CountDownLatch(1);

    /* renamed from: k  reason: collision with root package name */
    private ListenableFuture<? extends I> f3858k;

    /* renamed from: l  reason: collision with root package name */
    volatile ListenableFuture<? extends O> f3859l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChainingListenableFuture(@NonNull AsyncFunction<? super I, ? extends O> asyncFunction, @NonNull ListenableFuture<? extends I> listenableFuture) {
        this.f3855h = (AsyncFunction) Preconditions.g(asyncFunction);
        this.f3858k = (ListenableFuture) Preconditions.g(listenableFuture);
    }

    private void g(Future<?> future, boolean z7) {
        if (future != null) {
            future.cancel(z7);
        }
    }

    private <E> void h(@NonNull BlockingQueue<E> blockingQueue, @NonNull E e8) {
        boolean z7 = false;
        while (true) {
            try {
                blockingQueue.put(e8);
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
    }

    private <E> E i(@NonNull BlockingQueue<E> blockingQueue) {
        E take;
        boolean z7 = false;
        while (true) {
            try {
                take = blockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
        return take;
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    public boolean cancel(boolean z7) {
        if (super.cancel(z7)) {
            h(this.f3856i, Boolean.valueOf(z7));
            g(this.f3858k, z7);
            g(this.f3859l, z7);
            return true;
        }
        return false;
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    public O get() throws InterruptedException, ExecutionException {
        if (!isDone()) {
            ListenableFuture<? extends I> listenableFuture = this.f3858k;
            if (listenableFuture != null) {
                listenableFuture.get();
            }
            this.f3857j.await();
            ListenableFuture<? extends O> listenableFuture2 = this.f3859l;
            if (listenableFuture2 != null) {
                listenableFuture2.get();
            }
        }
        return (O) super.get();
    }

    @Override // java.lang.Runnable
    public void run() {
        final ListenableFuture<? extends O> apply;
        try {
        } catch (Exception e8) {
            c(e8);
        }
        try {
            try {
                try {
                    apply = this.f3855h.apply(Futures.e(this.f3858k));
                    this.f3859l = apply;
                } catch (Error e9) {
                    c(e9);
                } catch (UndeclaredThrowableException e10) {
                    c(e10.getCause());
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e11) {
                c(e11.getCause());
            }
            if (isCancelled()) {
                apply.cancel(((Boolean) i(this.f3856i)).booleanValue());
                this.f3859l = null;
                this.f3855h = null;
                this.f3858k = null;
                this.f3857j.countDown();
                return;
            }
            apply.f(new Runnable() { // from class: androidx.camera.core.impl.utils.futures.ChainingListenableFuture.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            ChainingListenableFuture.this.b(Futures.e(apply));
                        } catch (CancellationException unused2) {
                            ChainingListenableFuture.this.cancel(false);
                            ChainingListenableFuture.this.f3859l = null;
                            return;
                        } catch (ExecutionException e12) {
                            ChainingListenableFuture.this.c(e12.getCause());
                        }
                        ChainingListenableFuture.this.f3859l = null;
                    } catch (Throwable th) {
                        ChainingListenableFuture.this.f3859l = null;
                        throw th;
                    }
                }
            }, CameraXExecutors.a());
            this.f3855h = null;
            this.f3858k = null;
            this.f3857j.countDown();
        } catch (Throwable th) {
            this.f3855h = null;
            this.f3858k = null;
            this.f3857j.countDown();
            throw th;
        }
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    public O get(long j8, @NonNull TimeUnit timeUnit) throws TimeoutException, ExecutionException, InterruptedException {
        if (!isDone()) {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (timeUnit != timeUnit2) {
                j8 = timeUnit2.convert(j8, timeUnit);
                timeUnit = timeUnit2;
            }
            ListenableFuture<? extends I> listenableFuture = this.f3858k;
            if (listenableFuture != null) {
                long nanoTime = System.nanoTime();
                listenableFuture.get(j8, timeUnit);
                j8 -= Math.max(0L, System.nanoTime() - nanoTime);
            }
            long nanoTime2 = System.nanoTime();
            if (this.f3857j.await(j8, timeUnit)) {
                j8 -= Math.max(0L, System.nanoTime() - nanoTime2);
                ListenableFuture<? extends O> listenableFuture2 = this.f3859l;
                if (listenableFuture2 != null) {
                    listenableFuture2.get(j8, timeUnit);
                }
            } else {
                throw new TimeoutException();
            }
        }
        return (O) super.get(j8, timeUnit);
    }
}
