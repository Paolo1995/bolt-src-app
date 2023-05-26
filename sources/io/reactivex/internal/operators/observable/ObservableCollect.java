package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class ObservableCollect<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: g  reason: collision with root package name */
    final Callable<? extends U> f48396g;

    /* renamed from: h  reason: collision with root package name */
    final BiConsumer<? super U, ? super T> f48397h;

    /* loaded from: classes5.dex */
    static final class CollectObserver<T, U> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super U> f48398f;

        /* renamed from: g  reason: collision with root package name */
        final BiConsumer<? super U, ? super T> f48399g;

        /* renamed from: h  reason: collision with root package name */
        final U f48400h;

        /* renamed from: i  reason: collision with root package name */
        Disposable f48401i;

        /* renamed from: j  reason: collision with root package name */
        boolean f48402j;

        CollectObserver(Observer<? super U> observer, U u7, BiConsumer<? super U, ? super T> biConsumer) {
            this.f48398f = observer;
            this.f48399g = biConsumer;
            this.f48400h = u7;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48401i.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48401i.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f48402j) {
                return;
            }
            this.f48402j = true;
            this.f48398f.onNext((U) this.f48400h);
            this.f48398f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48402j) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48402j = true;
            this.f48398f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48402j) {
                return;
            }
            try {
                this.f48399g.accept((U) this.f48400h, t7);
            } catch (Throwable th) {
                this.f48401i.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48401i, disposable)) {
                this.f48401i = disposable;
                this.f48398f.onSubscribe(this);
            }
        }
    }

    public ObservableCollect(ObservableSource<T> observableSource, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        super(observableSource);
        this.f48396g = callable;
        this.f48397h = biConsumer;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        try {
            this.f48232f.subscribe(new CollectObserver(observer, ObjectHelper.e(this.f48396g.call(), "The initialSupplier returned a null value"), this.f48397h));
        } catch (Throwable th) {
            EmptyDisposable.h(th, observer);
        }
    }
}
