package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {

    /* renamed from: f  reason: collision with root package name */
    final Observer<? super T> f47681f;

    /* renamed from: g  reason: collision with root package name */
    final Consumer<? super Disposable> f47682g;

    /* renamed from: h  reason: collision with root package name */
    final Action f47683h;

    /* renamed from: i  reason: collision with root package name */
    Disposable f47684i;

    public DisposableLambdaObserver(Observer<? super T> observer, Consumer<? super Disposable> consumer, Action action) {
        this.f47681f = observer;
        this.f47682g = consumer;
        this.f47683h = action;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Disposable disposable = this.f47684i;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f47684i = disposableHelper;
            try {
                this.f47683h.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
            disposable.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f47684i.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Disposable disposable = this.f47684i;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f47684i = disposableHelper;
            this.f47681f.onComplete();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        Disposable disposable = this.f47684i;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f47684i = disposableHelper;
            this.f47681f.onError(th);
            return;
        }
        RxJavaPlugins.s(th);
    }

    @Override // io.reactivex.Observer
    public void onNext(T t7) {
        this.f47681f.onNext(t7);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        try {
            this.f47682g.accept(disposable);
            if (DisposableHelper.l(this.f47684i, disposable)) {
                this.f47684i = disposable;
                this.f47681f.onSubscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            disposable.dispose();
            this.f47684i = DisposableHelper.DISPOSED;
            EmptyDisposable.h(th, this.f47681f);
        }
    }
}
