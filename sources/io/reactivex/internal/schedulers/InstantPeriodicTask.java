package io.reactivex.internal.schedulers;

import androidx.camera.view.e;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class InstantPeriodicTask implements Callable<Void>, Disposable {

    /* renamed from: k  reason: collision with root package name */
    static final FutureTask<Void> f49696k = new FutureTask<>(Functions.f47617b, null);

    /* renamed from: f  reason: collision with root package name */
    final Runnable f49697f;

    /* renamed from: i  reason: collision with root package name */
    final ExecutorService f49700i;

    /* renamed from: j  reason: collision with root package name */
    Thread f49701j;

    /* renamed from: h  reason: collision with root package name */
    final AtomicReference<Future<?>> f49699h = new AtomicReference<>();

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<Future<?>> f49698g = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstantPeriodicTask(Runnable runnable, ExecutorService executorService) {
        this.f49697f = runnable;
        this.f49700i = executorService;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public Void call() throws Exception {
        this.f49701j = Thread.currentThread();
        try {
            this.f49697f.run();
            c(this.f49700i.submit(this));
            this.f49701j = null;
        } catch (Throwable th) {
            this.f49701j = null;
            RxJavaPlugins.s(th);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Future<?> future) {
        Future<?> future2;
        boolean z7;
        do {
            future2 = this.f49699h.get();
            if (future2 == f49696k) {
                if (this.f49701j != Thread.currentThread()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                future.cancel(z7);
                return;
            }
        } while (!e.a(this.f49699h, future2, future));
    }

    void c(Future<?> future) {
        Future<?> future2;
        boolean z7;
        do {
            future2 = this.f49698g.get();
            if (future2 == f49696k) {
                if (this.f49701j != Thread.currentThread()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                future.cancel(z7);
                return;
            }
        } while (!e.a(this.f49698g, future2, future));
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        boolean z7;
        AtomicReference<Future<?>> atomicReference = this.f49699h;
        FutureTask<Void> futureTask = f49696k;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        boolean z8 = true;
        if (andSet != null && andSet != futureTask) {
            if (this.f49701j != Thread.currentThread()) {
                z7 = true;
            } else {
                z7 = false;
            }
            andSet.cancel(z7);
        }
        Future<?> andSet2 = this.f49698g.getAndSet(futureTask);
        if (andSet2 != null && andSet2 != futureTask) {
            if (this.f49701j == Thread.currentThread()) {
                z8 = false;
            }
            andSet2.cancel(z8);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.f49699h.get() == f49696k) {
            return true;
        }
        return false;
    }
}
