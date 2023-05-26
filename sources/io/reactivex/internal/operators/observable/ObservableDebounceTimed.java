package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableDebounceTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final long f48509g;

    /* renamed from: h  reason: collision with root package name */
    final TimeUnit f48510h;

    /* renamed from: i  reason: collision with root package name */
    final Scheduler f48511i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final T f48512f;

        /* renamed from: g  reason: collision with root package name */
        final long f48513g;

        /* renamed from: h  reason: collision with root package name */
        final DebounceTimedObserver<T> f48514h;

        /* renamed from: i  reason: collision with root package name */
        final AtomicBoolean f48515i = new AtomicBoolean();

        DebounceEmitter(T t7, long j8, DebounceTimedObserver<T> debounceTimedObserver) {
            this.f48512f = t7;
            this.f48513g = j8;
            this.f48514h = debounceTimedObserver;
        }

        public void a(Disposable disposable) {
            DisposableHelper.e(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f48515i.compareAndSet(false, true)) {
                this.f48514h.a(this.f48513g, this.f48512f, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class DebounceTimedObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48516f;

        /* renamed from: g  reason: collision with root package name */
        final long f48517g;

        /* renamed from: h  reason: collision with root package name */
        final TimeUnit f48518h;

        /* renamed from: i  reason: collision with root package name */
        final Scheduler.Worker f48519i;

        /* renamed from: j  reason: collision with root package name */
        Disposable f48520j;

        /* renamed from: k  reason: collision with root package name */
        Disposable f48521k;

        /* renamed from: l  reason: collision with root package name */
        volatile long f48522l;

        /* renamed from: m  reason: collision with root package name */
        boolean f48523m;

        DebounceTimedObserver(Observer<? super T> observer, long j8, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f48516f = observer;
            this.f48517g = j8;
            this.f48518h = timeUnit;
            this.f48519i = worker;
        }

        void a(long j8, T t7, DebounceEmitter<T> debounceEmitter) {
            if (j8 == this.f48522l) {
                this.f48516f.onNext(t7);
                debounceEmitter.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48520j.dispose();
            this.f48519i.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48519i.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f48523m) {
                return;
            }
            this.f48523m = true;
            Disposable disposable = this.f48521k;
            if (disposable != null) {
                disposable.dispose();
            }
            DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
            if (debounceEmitter != null) {
                debounceEmitter.run();
            }
            this.f48516f.onComplete();
            this.f48519i.dispose();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48523m) {
                RxJavaPlugins.s(th);
                return;
            }
            Disposable disposable = this.f48521k;
            if (disposable != null) {
                disposable.dispose();
            }
            this.f48523m = true;
            this.f48516f.onError(th);
            this.f48519i.dispose();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48523m) {
                return;
            }
            long j8 = this.f48522l + 1;
            this.f48522l = j8;
            Disposable disposable = this.f48521k;
            if (disposable != null) {
                disposable.dispose();
            }
            DebounceEmitter debounceEmitter = new DebounceEmitter(t7, j8, this);
            this.f48521k = debounceEmitter;
            debounceEmitter.a(this.f48519i.c(debounceEmitter, this.f48517g, this.f48518h));
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48520j, disposable)) {
                this.f48520j = disposable;
                this.f48516f.onSubscribe(this);
            }
        }
    }

    public ObservableDebounceTimed(ObservableSource<T> observableSource, long j8, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f48509g = j8;
        this.f48510h = timeUnit;
        this.f48511i = scheduler;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new DebounceTimedObserver(new SerializedObserver(observer), this.f48509g, this.f48510h, this.f48511i.b()));
    }
}
