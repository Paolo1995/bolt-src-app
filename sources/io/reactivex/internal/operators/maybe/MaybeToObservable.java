package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;

/* loaded from: classes5.dex */
public final class MaybeToObservable<T> extends Observable<T> {

    /* renamed from: f  reason: collision with root package name */
    final MaybeSource<T> f48129f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements MaybeObserver<T> {

        /* renamed from: h  reason: collision with root package name */
        Disposable f48130h;

        MaybeToObservableObserver(Observer<? super T> observer) {
            super(observer);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            super.dispose();
            this.f48130h.dispose();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            b();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            d(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48130h, disposable)) {
                this.f48130h = disposable;
                this.f47679f.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            c(t7);
        }
    }

    public MaybeToObservable(MaybeSource<T> maybeSource) {
        this.f48129f = maybeSource;
    }

    public static <T> MaybeObserver<T> c(Observer<? super T> observer) {
        return new MaybeToObservableObserver(observer);
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f48129f.a(c(observer));
    }
}
