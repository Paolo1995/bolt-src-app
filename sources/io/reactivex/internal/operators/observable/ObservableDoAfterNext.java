package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* loaded from: classes5.dex */
public final class ObservableDoAfterNext<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Consumer<? super T> f48564g;

    /* loaded from: classes5.dex */
    static final class DoAfterObserver<T> extends BasicFuseableObserver<T, T> {

        /* renamed from: k  reason: collision with root package name */
        final Consumer<? super T> f48565k;

        DoAfterObserver(Observer<? super T> observer, Consumer<? super T> consumer) {
            super(observer);
            this.f48565k = consumer;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            return e(i8);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f47660f.onNext(t7);
            if (this.f47664j == 0) {
                try {
                    this.f48565k.accept(t7);
                } catch (Throwable th) {
                    d(th);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T poll = this.f47662h.poll();
            if (poll != null) {
                this.f48565k.accept(poll);
            }
            return poll;
        }
    }

    public ObservableDoAfterNext(ObservableSource<T> observableSource, Consumer<? super T> consumer) {
        super(observableSource);
        this.f48564g = consumer;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new DoAfterObserver(observer, this.f48564g));
    }
}
