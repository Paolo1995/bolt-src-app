package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements Disposable {

    /* renamed from: h  reason: collision with root package name */
    protected static final FutureTask<Void> f49657h;

    /* renamed from: i  reason: collision with root package name */
    protected static final FutureTask<Void> f49658i;

    /* renamed from: f  reason: collision with root package name */
    protected final Runnable f49659f;

    /* renamed from: g  reason: collision with root package name */
    protected Thread f49660g;

    static {
        Runnable runnable = Functions.f47617b;
        f49657h = new FutureTask<>(runnable, null);
        f49658i = new FutureTask<>(runnable, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractDirectTask(Runnable runnable) {
        this.f49659f = runnable;
    }

    public final void a(Future<?> future) {
        Future<?> future2;
        boolean z7;
        do {
            future2 = get();
            if (future2 != f49657h) {
                if (future2 == f49658i) {
                    if (this.f49660g != Thread.currentThread()) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    future.cancel(z7);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        FutureTask<Void> futureTask;
        boolean z7;
        Future<?> future = get();
        if (future != f49657h && future != (futureTask = f49658i) && compareAndSet(future, futureTask) && future != null) {
            if (this.f49660g != Thread.currentThread()) {
                z7 = true;
            } else {
                z7 = false;
            }
            future.cancel(z7);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        Future<?> future = get();
        if (future != f49657h && future != f49658i) {
            return false;
        }
        return true;
    }
}
