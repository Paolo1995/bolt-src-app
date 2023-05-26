package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableRetryWhen<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super Observable<Throwable>, ? extends ObservableSource<?>> f49059g;

    /* loaded from: classes5.dex */
    static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49060f;

        /* renamed from: i  reason: collision with root package name */
        final Subject<Throwable> f49063i;

        /* renamed from: l  reason: collision with root package name */
        final ObservableSource<T> f49066l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f49067m;

        /* renamed from: g  reason: collision with root package name */
        final AtomicInteger f49061g = new AtomicInteger();

        /* renamed from: h  reason: collision with root package name */
        final AtomicThrowable f49062h = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        final RepeatWhenObserver<T>.InnerRepeatObserver f49064j = new InnerRepeatObserver();

        /* renamed from: k  reason: collision with root package name */
        final AtomicReference<Disposable> f49065k = new AtomicReference<>();

        /* loaded from: classes5.dex */
        final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
            InnerRepeatObserver() {
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                RepeatWhenObserver.this.a();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                RepeatWhenObserver.this.b(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(Object obj) {
                RepeatWhenObserver.this.c();
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.j(this, disposable);
            }
        }

        RepeatWhenObserver(Observer<? super T> observer, Subject<Throwable> subject, ObservableSource<T> observableSource) {
            this.f49060f = observer;
            this.f49063i = subject;
            this.f49066l = observableSource;
        }

        void a() {
            DisposableHelper.a(this.f49065k);
            HalfSerializer.a(this.f49060f, this, this.f49062h);
        }

        void b(Throwable th) {
            DisposableHelper.a(this.f49065k);
            HalfSerializer.c(this.f49060f, th, this, this.f49062h);
        }

        void c() {
            d();
        }

        void d() {
            if (this.f49061g.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.f49067m) {
                        this.f49067m = true;
                        this.f49066l.subscribe(this);
                    }
                    if (this.f49061g.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f49065k);
            DisposableHelper.a(this.f49064j);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(this.f49065k.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.a(this.f49064j);
            HalfSerializer.a(this.f49060f, this, this.f49062h);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.e(this.f49065k, null);
            this.f49067m = false;
            this.f49063i.onNext(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            HalfSerializer.e(this.f49060f, t7, this, this.f49062h);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.e(this.f49065k, disposable);
        }
    }

    public ObservableRetryWhen(ObservableSource<T> observableSource, Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        this.f49059g = function;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        Subject<T> c8 = PublishSubject.e().c();
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f49059g.apply(c8), "The handler returned a null ObservableSource");
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, c8, this.f48232f);
            observer.onSubscribe(repeatWhenObserver);
            observableSource.subscribe(repeatWhenObserver.f49064j);
            repeatWhenObserver.d();
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
        }
    }
}
