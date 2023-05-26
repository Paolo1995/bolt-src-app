package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* loaded from: classes5.dex */
public final class ObservableDistinctUntilChanged<T, K> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, K> f48558g;

    /* renamed from: h  reason: collision with root package name */
    final BiPredicate<? super K, ? super K> f48559h;

    /* loaded from: classes5.dex */
    static final class DistinctUntilChangedObserver<T, K> extends BasicFuseableObserver<T, T> {

        /* renamed from: k  reason: collision with root package name */
        final Function<? super T, K> f48560k;

        /* renamed from: l  reason: collision with root package name */
        final BiPredicate<? super K, ? super K> f48561l;

        /* renamed from: m  reason: collision with root package name */
        K f48562m;

        /* renamed from: n  reason: collision with root package name */
        boolean f48563n;

        DistinctUntilChangedObserver(Observer<? super T> observer, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(observer);
            this.f48560k = function;
            this.f48561l = biPredicate;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            return e(i8);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f47663i) {
                return;
            }
            if (this.f47664j != 0) {
                this.f47660f.onNext(t7);
                return;
            }
            try {
                K apply = this.f48560k.apply(t7);
                if (this.f48563n) {
                    boolean test = this.f48561l.test((K) this.f48562m, apply);
                    this.f48562m = apply;
                    if (test) {
                        return;
                    }
                } else {
                    this.f48563n = true;
                    this.f48562m = apply;
                }
                this.f47660f.onNext(t7);
            } catch (Throwable th) {
                d(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            while (true) {
                T poll = this.f47662h.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f48560k.apply(poll);
                if (!this.f48563n) {
                    this.f48563n = true;
                    this.f48562m = apply;
                    return poll;
                } else if (!this.f48561l.test((K) this.f48562m, apply)) {
                    this.f48562m = apply;
                    return poll;
                } else {
                    this.f48562m = apply;
                }
            }
        }
    }

    public ObservableDistinctUntilChanged(ObservableSource<T> observableSource, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(observableSource);
        this.f48558g = function;
        this.f48559h = biPredicate;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new DistinctUntilChangedObserver(observer, this.f48558g, this.f48559h));
    }
}
