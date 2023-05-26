package io.reactivex.internal.operators.mixed;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class SingleFlatMapObservable<T, R> extends Observable<R> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<T> f48228f;

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends ObservableSource<? extends R>> f48229g;

    /* loaded from: classes5.dex */
    static final class FlatMapObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, SingleObserver<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f48230f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<? extends R>> f48231g;

        FlatMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.f48230f = observer;
            this.f48231g = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48230f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48230f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(R r7) {
            this.f48230f.onNext(r7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.e(this, disposable);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            try {
                ((ObservableSource) ObjectHelper.e(this.f48231g.apply(t7), "The mapper returned a null Publisher")).subscribe(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48230f.onError(th);
            }
        }
    }

    public SingleFlatMapObservable(SingleSource<T> singleSource, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        this.f48228f = singleSource;
        this.f48229g = function;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        FlatMapObserver flatMapObserver = new FlatMapObserver(observer, this.f48229g);
        observer.onSubscribe(flatMapObserver);
        this.f48228f.a(flatMapObserver);
    }
}
