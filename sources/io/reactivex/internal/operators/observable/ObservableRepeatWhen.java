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
public final class ObservableRepeatWhen<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super Observable<Object>, ? extends ObservableSource<?>> f49000g;

    /* loaded from: classes5.dex */
    static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49001f;

        /* renamed from: i  reason: collision with root package name */
        final Subject<Object> f49004i;

        /* renamed from: l  reason: collision with root package name */
        final ObservableSource<T> f49007l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f49008m;

        /* renamed from: g  reason: collision with root package name */
        final AtomicInteger f49002g = new AtomicInteger();

        /* renamed from: h  reason: collision with root package name */
        final AtomicThrowable f49003h = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        final RepeatWhenObserver<T>.InnerRepeatObserver f49005j = new InnerRepeatObserver();

        /* renamed from: k  reason: collision with root package name */
        final AtomicReference<Disposable> f49006k = new AtomicReference<>();

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

        RepeatWhenObserver(Observer<? super T> observer, Subject<Object> subject, ObservableSource<T> observableSource) {
            this.f49001f = observer;
            this.f49004i = subject;
            this.f49007l = observableSource;
        }

        void a() {
            DisposableHelper.a(this.f49006k);
            HalfSerializer.a(this.f49001f, this, this.f49003h);
        }

        void b(Throwable th) {
            DisposableHelper.a(this.f49006k);
            HalfSerializer.c(this.f49001f, th, this, this.f49003h);
        }

        void c() {
            d();
        }

        void d() {
            if (this.f49002g.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.f49008m) {
                        this.f49008m = true;
                        this.f49007l.subscribe(this);
                    }
                    if (this.f49002g.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f49006k);
            DisposableHelper.a(this.f49005j);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(this.f49006k.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.e(this.f49006k, null);
            this.f49008m = false;
            this.f49004i.onNext(0);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.a(this.f49005j);
            HalfSerializer.c(this.f49001f, th, this, this.f49003h);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            HalfSerializer.e(this.f49001f, t7, this, this.f49003h);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this.f49006k, disposable);
        }
    }

    public ObservableRepeatWhen(ObservableSource<T> observableSource, Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        this.f49000g = function;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        Subject<T> c8 = PublishSubject.e().c();
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f49000g.apply(c8), "The handler returned a null ObservableSource");
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, c8, this.f48232f);
            observer.onSubscribe(repeatWhenObserver);
            observableSource.subscribe(repeatWhenObserver.f49005j);
            repeatWhenObserver.d();
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
        }
    }
}
