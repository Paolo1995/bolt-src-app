package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* loaded from: classes5.dex */
public final class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends U> f48852g;

    /* loaded from: classes5.dex */
    static final class MapObserver<T, U> extends BasicFuseableObserver<T, U> {

        /* renamed from: k  reason: collision with root package name */
        final Function<? super T, ? extends U> f48853k;

        MapObserver(Observer<? super U> observer, Function<? super T, ? extends U> function) {
            super(observer);
            this.f48853k = function;
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
                this.f47660f.onNext(null);
                return;
            }
            try {
                this.f47660f.onNext(ObjectHelper.e(this.f48853k.apply(t7), "The mapper function returned a null value."));
            } catch (Throwable th) {
                d(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public U poll() throws Exception {
            T poll = this.f47662h.poll();
            if (poll != null) {
                return (U) ObjectHelper.e(this.f48853k.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    public ObservableMap(ObservableSource<T> observableSource, Function<? super T, ? extends U> function) {
        super(observableSource);
        this.f48852g = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        this.f48232f.subscribe(new MapObserver(observer, this.f48852g));
    }
}
