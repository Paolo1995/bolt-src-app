package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableDoFinally<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Action f48566g;

    /* loaded from: classes5.dex */
    static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48567f;

        /* renamed from: g  reason: collision with root package name */
        final Action f48568g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f48569h;

        /* renamed from: i  reason: collision with root package name */
        QueueDisposable<T> f48570i;

        /* renamed from: j  reason: collision with root package name */
        boolean f48571j;

        DoFinallyObserver(Observer<? super T> observer, Action action) {
            this.f48567f = observer;
            this.f48568g = action;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            QueueDisposable<T> queueDisposable = this.f48570i;
            boolean z7 = false;
            if (queueDisposable == null || (i8 & 4) != 0) {
                return 0;
            }
            int a8 = queueDisposable.a(i8);
            if (a8 != 0) {
                if (a8 == 1) {
                    z7 = true;
                }
                this.f48571j = z7;
            }
            return a8;
        }

        void b() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f48568g.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f48570i.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48569h.dispose();
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48569h.isDisposed();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f48570i.isEmpty();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48567f.onComplete();
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48567f.onError(th);
            b();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48567f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48569h, disposable)) {
                this.f48569h = disposable;
                if (disposable instanceof QueueDisposable) {
                    this.f48570i = (QueueDisposable) disposable;
                }
                this.f48567f.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T poll = this.f48570i.poll();
            if (poll == null && this.f48571j) {
                b();
            }
            return poll;
        }
    }

    public ObservableDoFinally(ObservableSource<T> observableSource, Action action) {
        super(observableSource);
        this.f48566g = action;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new DoFinallyObserver(observer, this.f48566g));
    }
}
