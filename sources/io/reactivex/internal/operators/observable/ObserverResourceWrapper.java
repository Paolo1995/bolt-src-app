package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

    /* renamed from: f  reason: collision with root package name */
    final Observer<? super T> f49523f;

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<Disposable> f49524g = new AtomicReference<>();

    public ObserverResourceWrapper(Observer<? super T> observer) {
        this.f49523f = observer;
    }

    public void a(Disposable disposable) {
        DisposableHelper.h(this, disposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.a(this.f49524g);
        DisposableHelper.a(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.f49524g.get() == DisposableHelper.DISPOSED) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        dispose();
        this.f49523f.onComplete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        dispose();
        this.f49523f.onError(th);
    }

    @Override // io.reactivex.Observer
    public void onNext(T t7) {
        this.f49523f.onNext(t7);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.j(this.f49524g, disposable)) {
            this.f49523f.onSubscribe(this);
        }
    }
}
