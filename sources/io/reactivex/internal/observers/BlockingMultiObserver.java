package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes5.dex */
public final class BlockingMultiObserver<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {

    /* renamed from: f  reason: collision with root package name */
    T f47669f;

    /* renamed from: g  reason: collision with root package name */
    Throwable f47670g;

    /* renamed from: h  reason: collision with root package name */
    Disposable f47671h;

    /* renamed from: i  reason: collision with root package name */
    volatile boolean f47672i;

    public BlockingMultiObserver() {
        super(1);
    }

    public T a() {
        if (getCount() != 0) {
            try {
                BlockingHelper.b();
                await();
            } catch (InterruptedException e8) {
                b();
                throw ExceptionHelper.e(e8);
            }
        }
        Throwable th = this.f47670g;
        if (th == null) {
            return this.f47669f;
        }
        throw ExceptionHelper.e(th);
    }

    void b() {
        this.f47672i = true;
        Disposable disposable = this.f47671h;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        countDown();
    }

    @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onError(Throwable th) {
        this.f47670g = th;
        countDown();
    }

    @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onSubscribe(Disposable disposable) {
        this.f47671h = disposable;
        if (this.f47672i) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
    public void onSuccess(T t7) {
        this.f47669f = t7;
        countDown();
    }
}
