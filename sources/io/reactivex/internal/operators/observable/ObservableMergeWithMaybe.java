package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableMergeWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final MaybeSource<? extends T> f48872g;

    /* loaded from: classes5.dex */
    static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48873f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<Disposable> f48874g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        final OtherObserver<T> f48875h = new OtherObserver<>(this);

        /* renamed from: i  reason: collision with root package name */
        final AtomicThrowable f48876i = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        volatile SimplePlainQueue<T> f48877j;

        /* renamed from: k  reason: collision with root package name */
        T f48878k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f48879l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f48880m;

        /* renamed from: n  reason: collision with root package name */
        volatile int f48881n;

        /* loaded from: classes5.dex */
        static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {

            /* renamed from: f  reason: collision with root package name */
            final MergeWithObserver<T> f48882f;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f48882f = mergeWithObserver;
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.f48882f.d();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f48882f.e(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.j(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(T t7) {
                this.f48882f.f(t7);
            }
        }

        MergeWithObserver(Observer<? super T> observer) {
            this.f48873f = observer;
        }

        void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        void b() {
            T t7;
            boolean z7;
            Observer<? super T> observer = this.f48873f;
            int i8 = 1;
            while (!this.f48879l) {
                if (this.f48876i.get() != null) {
                    this.f48878k = null;
                    this.f48877j = null;
                    observer.onError(this.f48876i.b());
                    return;
                }
                int i9 = this.f48881n;
                if (i9 == 1) {
                    this.f48878k = null;
                    this.f48881n = 2;
                    observer.onNext((T) this.f48878k);
                    i9 = 2;
                }
                boolean z8 = this.f48880m;
                SimplePlainQueue<T> simplePlainQueue = this.f48877j;
                if (simplePlainQueue != null) {
                    t7 = simplePlainQueue.poll();
                } else {
                    t7 = (Object) null;
                }
                if (t7 == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z8 && z7 && i9 == 2) {
                    this.f48877j = null;
                    observer.onComplete();
                    return;
                } else if (z7) {
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                } else {
                    observer.onNext(t7);
                }
            }
            this.f48878k = null;
            this.f48877j = null;
        }

        SimplePlainQueue<T> c() {
            SimplePlainQueue<T> simplePlainQueue = this.f48877j;
            if (simplePlainQueue == null) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
                this.f48877j = spscLinkedArrayQueue;
                return spscLinkedArrayQueue;
            }
            return simplePlainQueue;
        }

        void d() {
            this.f48881n = 2;
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48879l = true;
            DisposableHelper.a(this.f48874g);
            DisposableHelper.a(this.f48875h);
            if (getAndIncrement() == 0) {
                this.f48877j = null;
                this.f48878k = null;
            }
        }

        void e(Throwable th) {
            if (this.f48876i.a(th)) {
                DisposableHelper.a(this.f48874g);
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        void f(T t7) {
            if (compareAndSet(0, 1)) {
                this.f48873f.onNext(t7);
                this.f48881n = 2;
            } else {
                this.f48878k = t7;
                this.f48881n = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(this.f48874g.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48880m = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48876i.a(th)) {
                DisposableHelper.a(this.f48875h);
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (compareAndSet(0, 1)) {
                this.f48873f.onNext(t7);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                c().offer(t7);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this.f48874g, disposable);
        }
    }

    public ObservableMergeWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.f48872g = maybeSource;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.f48232f.subscribe(mergeWithObserver);
        this.f48872g.a(mergeWithObserver.f48875h);
    }
}
