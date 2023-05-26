package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

/* loaded from: classes5.dex */
public final class ObservableFromIterable<T> extends Observable<T> {

    /* renamed from: f  reason: collision with root package name */
    final Iterable<? extends T> f48701f;

    /* loaded from: classes5.dex */
    static final class FromIterableDisposable<T> extends BasicQueueDisposable<T> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48702f;

        /* renamed from: g  reason: collision with root package name */
        final Iterator<? extends T> f48703g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f48704h;

        /* renamed from: i  reason: collision with root package name */
        boolean f48705i;

        /* renamed from: j  reason: collision with root package name */
        boolean f48706j;

        /* renamed from: k  reason: collision with root package name */
        boolean f48707k;

        FromIterableDisposable(Observer<? super T> observer, Iterator<? extends T> it) {
            this.f48702f = observer;
            this.f48703g = it;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            if ((i8 & 1) != 0) {
                this.f48705i = true;
                return 1;
            }
            return 0;
        }

        void b() {
            while (!isDisposed()) {
                try {
                    this.f48702f.onNext(ObjectHelper.e(this.f48703g.next(), "The iterator returned a null value"));
                    if (isDisposed()) {
                        return;
                    }
                    try {
                        if (!this.f48703g.hasNext()) {
                            if (!isDisposed()) {
                                this.f48702f.onComplete();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f48702f.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.f48702f.onError(th2);
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f48706j = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48704h = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48704h;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f48706j;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() {
            if (this.f48706j) {
                return null;
            }
            if (this.f48707k) {
                if (!this.f48703g.hasNext()) {
                    this.f48706j = true;
                    return null;
                }
            } else {
                this.f48707k = true;
            }
            return (T) ObjectHelper.e(this.f48703g.next(), "The iterator returned a null value");
        }
    }

    public ObservableFromIterable(Iterable<? extends T> iterable) {
        this.f48701f = iterable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            Iterator<? extends T> it = this.f48701f.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.e(observer);
                    return;
                }
                FromIterableDisposable fromIterableDisposable = new FromIterableDisposable(observer, it);
                observer.onSubscribe(fromIterableDisposable);
                if (!fromIterableDisposable.f48705i) {
                    fromIterableDisposable.b();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.h(th, observer);
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            EmptyDisposable.h(th2, observer);
        }
    }
}
