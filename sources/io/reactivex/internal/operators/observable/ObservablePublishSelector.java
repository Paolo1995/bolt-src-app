package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservablePublishSelector<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super Observable<T>, ? extends ObservableSource<R>> f48941g;

    /* loaded from: classes5.dex */
    static final class SourceObserver<T, R> implements Observer<T> {

        /* renamed from: f  reason: collision with root package name */
        final PublishSubject<T> f48942f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<Disposable> f48943g;

        SourceObserver(PublishSubject<T> publishSubject, AtomicReference<Disposable> atomicReference) {
            this.f48942f = publishSubject;
            this.f48943g = atomicReference;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48942f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48942f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48942f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this.f48943g, disposable);
        }
    }

    /* loaded from: classes5.dex */
    static final class TargetObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f48944f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f48945g;

        TargetObserver(Observer<? super R> observer) {
            this.f48944f = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48945g.dispose();
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48945g.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.a(this);
            this.f48944f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.a(this);
            this.f48944f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(R r7) {
            this.f48944f.onNext(r7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48945g, disposable)) {
                this.f48945g = disposable;
                this.f48944f.onSubscribe(this);
            }
        }
    }

    public ObservablePublishSelector(ObservableSource<T> observableSource, Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        super(observableSource);
        this.f48941g = function;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        PublishSubject e8 = PublishSubject.e();
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f48941g.apply(e8), "The selector returned a null ObservableSource");
            TargetObserver targetObserver = new TargetObserver(observer);
            observableSource.subscribe(targetObserver);
            this.f48232f.subscribe(new SourceObserver(e8, targetObserver));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
        }
    }
}
