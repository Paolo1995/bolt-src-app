package io.reactivex.internal.operators.observable;

import androidx.camera.view.e;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableDebounce<T, U> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends ObservableSource<U>> f48497g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class DebounceObserver<T, U> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48498f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<U>> f48499g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f48500h;

        /* renamed from: i  reason: collision with root package name */
        final AtomicReference<Disposable> f48501i = new AtomicReference<>();

        /* renamed from: j  reason: collision with root package name */
        volatile long f48502j;

        /* renamed from: k  reason: collision with root package name */
        boolean f48503k;

        /* loaded from: classes5.dex */
        static final class DebounceInnerObserver<T, U> extends DisposableObserver<U> {

            /* renamed from: g  reason: collision with root package name */
            final DebounceObserver<T, U> f48504g;

            /* renamed from: h  reason: collision with root package name */
            final long f48505h;

            /* renamed from: i  reason: collision with root package name */
            final T f48506i;

            /* renamed from: j  reason: collision with root package name */
            boolean f48507j;

            /* renamed from: k  reason: collision with root package name */
            final AtomicBoolean f48508k = new AtomicBoolean();

            DebounceInnerObserver(DebounceObserver<T, U> debounceObserver, long j8, T t7) {
                this.f48504g = debounceObserver;
                this.f48505h = j8;
                this.f48506i = t7;
            }

            void c() {
                if (this.f48508k.compareAndSet(false, true)) {
                    this.f48504g.a(this.f48505h, this.f48506i);
                }
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                if (this.f48507j) {
                    return;
                }
                this.f48507j = true;
                c();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                if (this.f48507j) {
                    RxJavaPlugins.s(th);
                    return;
                }
                this.f48507j = true;
                this.f48504g.onError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(U u7) {
                if (this.f48507j) {
                    return;
                }
                this.f48507j = true;
                dispose();
                c();
            }
        }

        DebounceObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<U>> function) {
            this.f48498f = observer;
            this.f48499g = function;
        }

        void a(long j8, T t7) {
            if (j8 == this.f48502j) {
                this.f48498f.onNext(t7);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48500h.dispose();
            DisposableHelper.a(this.f48501i);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48500h.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f48503k) {
                return;
            }
            this.f48503k = true;
            Disposable disposable = this.f48501i.get();
            if (disposable != DisposableHelper.DISPOSED) {
                DebounceInnerObserver debounceInnerObserver = (DebounceInnerObserver) disposable;
                if (debounceInnerObserver != null) {
                    debounceInnerObserver.c();
                }
                DisposableHelper.a(this.f48501i);
                this.f48498f.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.a(this.f48501i);
            this.f48498f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48503k) {
                return;
            }
            long j8 = this.f48502j + 1;
            this.f48502j = j8;
            Disposable disposable = this.f48501i.get();
            if (disposable != null) {
                disposable.dispose();
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f48499g.apply(t7), "The ObservableSource supplied is null");
                DebounceInnerObserver debounceInnerObserver = new DebounceInnerObserver(this, j8, t7);
                if (e.a(this.f48501i, disposable, debounceInnerObserver)) {
                    observableSource.subscribe(debounceInnerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                dispose();
                this.f48498f.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48500h, disposable)) {
                this.f48500h = disposable;
                this.f48498f.onSubscribe(this);
            }
        }
    }

    public ObservableDebounce(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<U>> function) {
        super(observableSource);
        this.f48497g = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new DebounceObserver(new SerializedObserver(observer), this.f48497g));
    }
}
