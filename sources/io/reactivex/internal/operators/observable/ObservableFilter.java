package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* loaded from: classes5.dex */
public final class ObservableFilter<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Predicate<? super T> f48613g;

    /* loaded from: classes5.dex */
    static final class FilterObserver<T> extends BasicFuseableObserver<T, T> {

        /* renamed from: k  reason: collision with root package name */
        final Predicate<? super T> f48614k;

        FilterObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            super(observer);
            this.f48614k = predicate;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            return e(i8);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f47664j == 0) {
                try {
                    if (this.f48614k.test(t7)) {
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
            } while (!this.f48614k.test(poll));
            return poll;
        }
    }

    public ObservableFilter(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f48613g = predicate;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new FilterObserver(observer, this.f48613g));
    }
}
