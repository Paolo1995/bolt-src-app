package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableMergeWithSingle<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final SingleSource<? extends T> f48883g;

    /* loaded from: classes5.dex */
    static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48884f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<Disposable> f48885g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        final OtherObserver<T> f48886h = new OtherObserver<>(this);

        /* renamed from: i  reason: collision with root package name */
        final AtomicThrowable f48887i = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        volatile SimplePlainQueue<T> f48888j;

        /* renamed from: k  reason: collision with root package name */
        T f48889k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f48890l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f48891m;

        /* renamed from: n  reason: collision with root package name */
        volatile int f48892n;

        /* loaded from: classes5.dex */
        static final class OtherObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {

            /* renamed from: f  reason: collision with root package name */
            final MergeWithObserver<T> f48893f;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f48893f = mergeWithObserver;
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f48893f.d(th);
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.j(this, disposable);
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
            public void onSuccess(T t7) {
                this.f48893f.e(t7);
            }
        }

        MergeWithObserver(Observer<? super T> observer) {
            this.f48884f = observer;
        }

        void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        void b() {
            T t7;
            boolean z7;
            Observer<? super T> observer = this.f48884f;
            int i8 = 1;
            while (!this.f48890l) {
                if (this.f48887i.get() != null) {
                    this.f48889k = null;
                    this.f48888j = null;
                    observer.onError(this.f48887i.b());
                    return;
                }
                int i9 = this.f48892n;
                if (i9 == 1) {
                    this.f48889k = null;
                    this.f48892n = 2;
                    observer.onNext((T) this.f48889k);
                    i9 = 2;
                }
                boolean z8 = this.f48891m;
                SimplePlainQueue<T> simplePlainQueue = this.f48888j;
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
                    this.f48888j = null;
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
            this.f48889k = null;
            this.f48888j = null;
        }

        SimplePlainQueue<T> c() {
            SimplePlainQueue<T> simplePlainQueue = this.f48888j;
            if (simplePlainQueue == null) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
                this.f48888j = spscLinkedArrayQueue;
                return spscLinkedArrayQueue;
            }
            return simplePlainQueue;
        }

        void d(Throwable th) {
            if (this.f48887i.a(th)) {
                DisposableHelper.a(this.f48885g);
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48890l = true;
            DisposableHelper.a(this.f48885g);
            DisposableHelper.a(this.f48886h);
            if (getAndIncrement() == 0) {
                this.f48888j = null;
                this.f48889k = null;
            }
        }

        void e(T t7) {
            if (compareAndSet(0, 1)) {
                this.f48884f.onNext(t7);
                this.f48892n = 2;
            } else {
                this.f48889k = t7;
                this.f48892n = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(this.f48885g.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48891m = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48887i.a(th)) {
                DisposableHelper.a(this.f48886h);
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (compareAndSet(0, 1)) {
                this.f48884f.onNext(t7);
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
            DisposableHelper.j(this.f48885g, disposable);
        }
    }

    public ObservableMergeWithSingle(Observable<T> observable, SingleSource<? extends T> singleSource) {
        super(observable);
        this.f48883g = singleSource;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.f48232f.subscribe(mergeWithObserver);
        this.f48883g.a(mergeWithObserver.f48886h);
    }
}
