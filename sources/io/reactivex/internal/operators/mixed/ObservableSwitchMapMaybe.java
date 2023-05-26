package io.reactivex.internal.operators.mixed;

import androidx.camera.view.e;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableSwitchMapMaybe<T, R> extends Observable<R> {

    /* renamed from: f  reason: collision with root package name */
    final Observable<T> f48200f;

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends MaybeSource<? extends R>> f48201g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f48202h;

    /* loaded from: classes5.dex */
    static final class SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: n  reason: collision with root package name */
        static final SwitchMapMaybeObserver<Object> f48203n = new SwitchMapMaybeObserver<>(null);

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f48204f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends MaybeSource<? extends R>> f48205g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f48206h;

        /* renamed from: i  reason: collision with root package name */
        final AtomicThrowable f48207i = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        final AtomicReference<SwitchMapMaybeObserver<R>> f48208j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        Disposable f48209k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f48210l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f48211m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {

            /* renamed from: f  reason: collision with root package name */
            final SwitchMapMaybeMainObserver<?, R> f48212f;

            /* renamed from: g  reason: collision with root package name */
            volatile R f48213g;

            SwitchMapMaybeObserver(SwitchMapMaybeMainObserver<?, R> switchMapMaybeMainObserver) {
                this.f48212f = switchMapMaybeMainObserver;
            }

            void a() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.f48212f.c(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f48212f.d(this, th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.j(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r7) {
                this.f48213g = r7;
                this.f48212f.b();
            }
        }

        SwitchMapMaybeMainObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z7) {
            this.f48204f = observer;
            this.f48205g = function;
            this.f48206h = z7;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = f48203n;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver2 = (SwitchMapMaybeObserver) this.f48208j.getAndSet(switchMapMaybeObserver);
            if (switchMapMaybeObserver2 != null && switchMapMaybeObserver2 != switchMapMaybeObserver) {
                switchMapMaybeObserver2.a();
            }
        }

        void b() {
            boolean z7;
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super R> observer = this.f48204f;
            AtomicThrowable atomicThrowable = this.f48207i;
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.f48208j;
            int i8 = 1;
            while (!this.f48211m) {
                if (atomicThrowable.get() != null && !this.f48206h) {
                    observer.onError(atomicThrowable.b());
                    return;
                }
                boolean z8 = this.f48210l;
                SwitchMapMaybeObserver<R> switchMapMaybeObserver = atomicReference.get();
                if (switchMapMaybeObserver == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z8 && z7) {
                    Throwable b8 = atomicThrowable.b();
                    if (b8 != null) {
                        observer.onError(b8);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                } else if (!z7 && switchMapMaybeObserver.f48213g != null) {
                    e.a(atomicReference, switchMapMaybeObserver, null);
                    observer.onNext((R) switchMapMaybeObserver.f48213g);
                } else {
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                }
            }
        }

        void c(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (e.a(this.f48208j, switchMapMaybeObserver, null)) {
                b();
            }
        }

        void d(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th) {
            if (e.a(this.f48208j, switchMapMaybeObserver, null) && this.f48207i.a(th)) {
                if (!this.f48206h) {
                    this.f48209k.dispose();
                    a();
                }
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48211m = true;
            this.f48209k.dispose();
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48211m;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48210l = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48207i.a(th)) {
                if (!this.f48206h) {
                    a();
                }
                this.f48210l = true;
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            SwitchMapMaybeObserver<R> switchMapMaybeObserver;
            SwitchMapMaybeObserver<R> switchMapMaybeObserver2 = this.f48208j.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.a();
            }
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.e(this.f48205g.apply(t7), "The mapper returned a null MaybeSource");
                SwitchMapMaybeObserver switchMapMaybeObserver3 = new SwitchMapMaybeObserver(this);
                do {
                    switchMapMaybeObserver = this.f48208j.get();
                    if (switchMapMaybeObserver == f48203n) {
                        return;
                    }
                } while (!e.a(this.f48208j, switchMapMaybeObserver, switchMapMaybeObserver3));
                maybeSource.a(switchMapMaybeObserver3);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48209k.dispose();
                this.f48208j.getAndSet(f48203n);
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48209k, disposable)) {
                this.f48209k = disposable;
                this.f48204f.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapMaybe(Observable<T> observable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z7) {
        this.f48200f = observable;
        this.f48201g = function;
        this.f48202h = z7;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.b(this.f48200f, this.f48201g, observer)) {
            this.f48200f.subscribe(new SwitchMapMaybeMainObserver(observer, this.f48201g, this.f48202h));
        }
    }
}
