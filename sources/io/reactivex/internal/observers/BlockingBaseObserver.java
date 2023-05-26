package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes5.dex */
public abstract class BlockingBaseObserver<T> extends CountDownLatch implements Observer<T>, Disposable {

    /* renamed from: f  reason: collision with root package name */
    T f47665f;

    /* renamed from: g  reason: collision with root package name */
    Throwable f47666g;

    /* renamed from: h  reason: collision with root package name */
    Disposable f47667h;

    /* renamed from: i  reason: collision with root package name */
    volatile boolean f47668i;

    public BlockingBaseObserver() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                BlockingHelper.b();
                await();
            } catch (InterruptedException e8) {
                dispose();
                throw ExceptionHelper.e(e8);
            }
        }
        Throwable th = this.f47666g;
        if (th == null) {
            return this.f47665f;
        }
        throw ExceptionHelper.e(th);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f47668i = true;
        Disposable disposable = this.f47667h;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f47668i;
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        this.f47667h = disposable;
        if (this.f47668i) {
            disposable.dispose();
        }
    }
}
