package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DefaultObserver;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
public final class BlockingObservableMostRecent<T> implements Iterable<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48244f;

    /* renamed from: g  reason: collision with root package name */
    final T f48245g;

    /* loaded from: classes5.dex */
    static final class MostRecentObserver<T> extends DefaultObserver<T> {

        /* renamed from: g  reason: collision with root package name */
        volatile Object f48246g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public final class Iterator implements java.util.Iterator<T>, j$.util.Iterator {

            /* renamed from: f  reason: collision with root package name */
            private Object f48247f;

            Iterator() {
            }

            @Override // j$.util.Iterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            @Override // java.util.Iterator
            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public boolean hasNext() {
                Object obj = MostRecentObserver.this.f48246g;
                this.f48247f = obj;
                return !NotificationLite.m(obj);
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public T next() {
                try {
                    if (this.f48247f == null) {
                        this.f48247f = MostRecentObserver.this.f48246g;
                    }
                    if (!NotificationLite.m(this.f48247f)) {
                        if (!NotificationLite.p(this.f48247f)) {
                            return (T) NotificationLite.l(this.f48247f);
                        }
                        throw ExceptionHelper.e(NotificationLite.k(this.f48247f));
                    }
                    throw new NoSuchElementException();
                } finally {
                    this.f48247f = null;
                }
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        MostRecentObserver(T t7) {
            this.f48246g = NotificationLite.q(t7);
        }

        public MostRecentObserver<T>.Iterator b() {
            return new Iterator();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48246g = NotificationLite.f();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48246g = NotificationLite.j(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48246g = NotificationLite.q(t7);
        }
    }

    public BlockingObservableMostRecent(ObservableSource<T> observableSource, T t7) {
        this.f48244f = observableSource;
        this.f48245g = t7;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        MostRecentObserver mostRecentObserver = new MostRecentObserver(this.f48245g);
        this.f48244f.subscribe(mostRecentObserver);
        return mostRecentObserver.b();
    }
}
