package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;

/* loaded from: classes5.dex */
public final class ObservableFromArray<T> extends Observable<T> {

    /* renamed from: f  reason: collision with root package name */
    final T[] f48691f;

    /* loaded from: classes5.dex */
    static final class FromArrayDisposable<T> extends BasicQueueDisposable<T> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48692f;

        /* renamed from: g  reason: collision with root package name */
        final T[] f48693g;

        /* renamed from: h  reason: collision with root package name */
        int f48694h;

        /* renamed from: i  reason: collision with root package name */
        boolean f48695i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f48696j;

        FromArrayDisposable(Observer<? super T> observer, T[] tArr) {
            this.f48692f = observer;
            this.f48693g = tArr;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            if ((i8 & 1) != 0) {
                this.f48695i = true;
                return 1;
            }
            return 0;
        }

        void b() {
            T[] tArr = this.f48693g;
            int length = tArr.length;
            for (int i8 = 0; i8 < length && !isDisposed(); i8++) {
                T t7 = tArr[i8];
                if (t7 == null) {
                    Observer<? super T> observer = this.f48692f;
                    observer.onError(new NullPointerException("The element at index " + i8 + " is null"));
                    return;
                }
                this.f48692f.onNext(t7);
            }
            if (!isDisposed()) {
                this.f48692f.onComplete();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f48694h = this.f48693g.length;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48696j = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48696j;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            if (this.f48694h == this.f48693g.length) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() {
            int i8 = this.f48694h;
            T[] tArr = this.f48693g;
            if (i8 != tArr.length) {
                this.f48694h = i8 + 1;
                return (T) ObjectHelper.e(tArr[i8], "The array element is null");
            }
            return null;
        }
    }

    public ObservableFromArray(T[] tArr) {
        this.f48691f = tArr;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        FromArrayDisposable fromArrayDisposable = new FromArrayDisposable(observer, this.f48691f);
        observer.onSubscribe(fromArrayDisposable);
        if (fromArrayDisposable.f48695i) {
            return;
        }
        fromArrayDisposable.b();
    }
}
