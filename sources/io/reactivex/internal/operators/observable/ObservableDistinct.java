package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class ObservableDistinct<T, K> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, K> f48554g;

    /* renamed from: h  reason: collision with root package name */
    final Callable<? extends Collection<? super K>> f48555h;

    /* loaded from: classes5.dex */
    static final class DistinctObserver<T, K> extends BasicFuseableObserver<T, T> {

        /* renamed from: k  reason: collision with root package name */
        final Collection<? super K> f48556k;

        /* renamed from: l  reason: collision with root package name */
        final Function<? super T, K> f48557l;

        DistinctObserver(Observer<? super T> observer, Function<? super T, K> function, Collection<? super K> collection) {
            super(observer);
            this.f48557l = function;
            this.f48556k = collection;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            return e(i8);
        }

        @Override // io.reactivex.internal.observers.BasicFuseableObserver, io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f48556k.clear();
            super.clear();
        }

        @Override // io.reactivex.internal.observers.BasicFuseableObserver, io.reactivex.Observer
        public void onComplete() {
            if (!this.f47663i) {
                this.f47663i = true;
                this.f48556k.clear();
                this.f47660f.onComplete();
            }
        }

        @Override // io.reactivex.internal.observers.BasicFuseableObserver, io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f47663i) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f47663i = true;
            this.f48556k.clear();
            this.f47660f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f47663i) {
                return;
            }
            if (this.f47664j == 0) {
                try {
                    if (this.f48556k.add(ObjectHelper.e(this.f48557l.apply(t7), "The keySelector returned a null key"))) {
                        this.f47660f.onNext(t7);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    d(th);
                    return;
                }
            }
            this.f47660f.onNext(null);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T poll;
            do {
                poll = this.f47662h.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.f48556k.add((Object) ObjectHelper.e(this.f48557l.apply(poll), "The keySelector returned a null key")));
            return poll;
        }
    }

    public ObservableDistinct(ObservableSource<T> observableSource, Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        super(observableSource);
        this.f48554g = function;
        this.f48555h = callable;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        try {
            this.f48232f.subscribe(new DistinctObserver(observer, this.f48554g, (Collection) ObjectHelper.e(this.f48555h.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
        }
    }
}
