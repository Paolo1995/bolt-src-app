package io.reactivex.internal.observers;

import androidx.camera.view.e;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class FutureObserver<T> extends CountDownLatch implements Observer<T>, Future<T>, Disposable {

    /* renamed from: f  reason: collision with root package name */
    T f47689f;

    /* renamed from: g  reason: collision with root package name */
    Throwable f47690g;

    /* renamed from: h  reason: collision with root package name */
    final AtomicReference<Disposable> f47691h;

    public FutureObserver() {
        super(1);
        this.f47691h = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z7) {
        Disposable disposable;
        DisposableHelper disposableHelper;
        do {
            disposable = this.f47691h.get();
            if (disposable == this || disposable == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!e.a(this.f47691h, disposable, disposableHelper));
        if (disposable != null) {
            disposable.dispose();
        }
        countDown();
        return true;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            BlockingHelper.b();
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.f47690g;
            if (th == null) {
                return this.f47689f;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.c(this.f47691h.get());
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        if (getCount() == 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Disposable disposable;
        if (this.f47689f == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            disposable = this.f47691h.get();
            if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                return;
            }
        } while (!e.a(this.f47691h, disposable, this));
        countDown();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        Disposable disposable;
        if (this.f47690g == null) {
            this.f47690g = th;
            do {
                disposable = this.f47691h.get();
                if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                    RxJavaPlugins.s(th);
                    return;
                }
            } while (!e.a(this.f47691h, disposable, this));
            countDown();
            return;
        }
        RxJavaPlugins.s(th);
    }

    @Override // io.reactivex.Observer
    public void onNext(T t7) {
        if (this.f47689f != null) {
            this.f47691h.get().dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.f47689f = t7;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        DisposableHelper.j(this.f47691h, disposable);
    }

    @Override // java.util.concurrent.Future
    public T get(long j8, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.b();
            if (!await(j8, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.d(j8, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f47690g;
            if (th == null) {
                return this.f47689f;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
