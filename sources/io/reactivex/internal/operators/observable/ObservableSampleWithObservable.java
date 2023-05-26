package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableSampleWithObservable<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final ObservableSource<?> f49080g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f49081h;

    /* loaded from: classes5.dex */
    static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {

        /* renamed from: j  reason: collision with root package name */
        final AtomicInteger f49082j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f49083k;

        SampleMainEmitLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
            this.f49082j = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void b() {
            this.f49083k = true;
            if (this.f49082j.getAndIncrement() == 0) {
                c();
                this.f49084f.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void e() {
            if (this.f49082j.getAndIncrement() == 0) {
                do {
                    boolean z7 = this.f49083k;
                    c();
                    if (z7) {
                        this.f49084f.onComplete();
                        return;
                    }
                } while (this.f49082j.decrementAndGet() != 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        SampleMainNoLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void b() {
            this.f49084f.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void e() {
            c();
        }
    }

    /* loaded from: classes5.dex */
    static abstract class SampleMainObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49084f;

        /* renamed from: g  reason: collision with root package name */
        final ObservableSource<?> f49085g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicReference<Disposable> f49086h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        Disposable f49087i;

        SampleMainObserver(Observer<? super T> observer, ObservableSource<?> observableSource) {
            this.f49084f = observer;
            this.f49085g = observableSource;
        }

        public void a() {
            this.f49087i.dispose();
            b();
        }

        abstract void b();

        void c() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.f49084f.onNext(andSet);
            }
        }

        public void d(Throwable th) {
            this.f49087i.dispose();
            this.f49084f.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f49086h);
            this.f49087i.dispose();
        }

        abstract void e();

        boolean f(Disposable disposable) {
            return DisposableHelper.j(this.f49086h, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.f49086h.get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.a(this.f49086h);
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.a(this.f49086h);
            this.f49084f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            lazySet(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49087i, disposable)) {
                this.f49087i = disposable;
                this.f49084f.onSubscribe(this);
                if (this.f49086h.get() == null) {
                    this.f49085g.subscribe(new SamplerObserver(this));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class SamplerObserver<T> implements Observer<Object> {

        /* renamed from: f  reason: collision with root package name */
        final SampleMainObserver<T> f49088f;

        SamplerObserver(SampleMainObserver<T> sampleMainObserver) {
            this.f49088f = sampleMainObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49088f.a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49088f.d(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            this.f49088f.e();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f49088f.f(disposable);
        }
    }

    public ObservableSampleWithObservable(ObservableSource<T> observableSource, ObservableSource<?> observableSource2, boolean z7) {
        super(observableSource);
        this.f49080g = observableSource2;
        this.f49081h = z7;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.f49081h) {
            this.f48232f.subscribe(new SampleMainEmitLast(serializedObserver, this.f49080g));
        } else {
            this.f48232f.subscribe(new SampleMainNoLast(serializedObserver, this.f49080g));
        }
    }
}
