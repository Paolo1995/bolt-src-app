package io.reactivex.internal.operators.mixed;

import androidx.camera.view.e;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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
public final class ObservableSwitchMapSingle<T, R> extends Observable<R> {

    /* renamed from: f  reason: collision with root package name */
    final Observable<T> f48214f;

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends SingleSource<? extends R>> f48215g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f48216h;

    /* loaded from: classes5.dex */
    static final class SwitchMapSingleMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: n  reason: collision with root package name */
        static final SwitchMapSingleObserver<Object> f48217n = new SwitchMapSingleObserver<>(null);

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f48218f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends SingleSource<? extends R>> f48219g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f48220h;

        /* renamed from: i  reason: collision with root package name */
        final AtomicThrowable f48221i = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        final AtomicReference<SwitchMapSingleObserver<R>> f48222j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        Disposable f48223k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f48224l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f48225m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {

            /* renamed from: f  reason: collision with root package name */
            final SwitchMapSingleMainObserver<?, R> f48226f;

            /* renamed from: g  reason: collision with root package name */
            volatile R f48227g;

            SwitchMapSingleObserver(SwitchMapSingleMainObserver<?, R> switchMapSingleMainObserver) {
                this.f48226f = switchMapSingleMainObserver;
            }

            void a() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f48226f.c(this, th);
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.j(this, disposable);
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
            public void onSuccess(R r7) {
                this.f48227g = r7;
                this.f48226f.b();
            }
        }

        SwitchMapSingleMainObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z7) {
            this.f48218f = observer;
            this.f48219g = function;
            this.f48220h = z7;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            SwitchMapSingleObserver<Object> switchMapSingleObserver = f48217n;
            SwitchMapSingleObserver<Object> switchMapSingleObserver2 = (SwitchMapSingleObserver) this.f48222j.getAndSet(switchMapSingleObserver);
            if (switchMapSingleObserver2 != null && switchMapSingleObserver2 != switchMapSingleObserver) {
                switchMapSingleObserver2.a();
            }
        }

        void b() {
            boolean z7;
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super R> observer = this.f48218f;
            AtomicThrowable atomicThrowable = this.f48221i;
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.f48222j;
            int i8 = 1;
            while (!this.f48225m) {
                if (atomicThrowable.get() != null && !this.f48220h) {
                    observer.onError(atomicThrowable.b());
                    return;
                }
                boolean z8 = this.f48224l;
                SwitchMapSingleObserver<R> switchMapSingleObserver = atomicReference.get();
                if (switchMapSingleObserver == null) {
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
                } else if (!z7 && switchMapSingleObserver.f48227g != null) {
                    e.a(atomicReference, switchMapSingleObserver, null);
                    observer.onNext((R) switchMapSingleObserver.f48227g);
                } else {
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                }
            }
        }

        void c(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th) {
            if (e.a(this.f48222j, switchMapSingleObserver, null) && this.f48221i.a(th)) {
                if (!this.f48220h) {
                    this.f48223k.dispose();
                    a();
                }
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48225m = true;
            this.f48223k.dispose();
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48225m;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48224l = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48221i.a(th)) {
                if (!this.f48220h) {
                    a();
                }
                this.f48224l = true;
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            SwitchMapSingleObserver<R> switchMapSingleObserver;
            SwitchMapSingleObserver<R> switchMapSingleObserver2 = this.f48222j.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.a();
            }
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.e(this.f48219g.apply(t7), "The mapper returned a null SingleSource");
                SwitchMapSingleObserver switchMapSingleObserver3 = new SwitchMapSingleObserver(this);
                do {
                    switchMapSingleObserver = this.f48222j.get();
                    if (switchMapSingleObserver == f48217n) {
                        return;
                    }
                } while (!e.a(this.f48222j, switchMapSingleObserver, switchMapSingleObserver3));
                singleSource.a(switchMapSingleObserver3);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48223k.dispose();
                this.f48222j.getAndSet(f48217n);
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48223k, disposable)) {
                this.f48223k = disposable;
                this.f48218f.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapSingle(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z7) {
        this.f48214f = observable;
        this.f48215g = function;
        this.f48216h = z7;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.c(this.f48214f, this.f48215g, observer)) {
            this.f48214f.subscribe(new SwitchMapSingleMainObserver(observer, this.f48215g, this.f48216h));
        }
    }
}
