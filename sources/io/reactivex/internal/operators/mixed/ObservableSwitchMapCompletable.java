package io.reactivex.internal.operators.mixed;

import androidx.camera.view.e;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableSwitchMapCompletable<T> extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final Observable<T> f48188f;

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends CompletableSource> f48189g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f48190h;

    /* loaded from: classes5.dex */
    static final class SwitchMapCompletableObserver<T> implements Observer<T>, Disposable {

        /* renamed from: m  reason: collision with root package name */
        static final SwitchMapInnerObserver f48191m = new SwitchMapInnerObserver(null);

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f48192f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends CompletableSource> f48193g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f48194h;

        /* renamed from: i  reason: collision with root package name */
        final AtomicThrowable f48195i = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        final AtomicReference<SwitchMapInnerObserver> f48196j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f48197k;

        /* renamed from: l  reason: collision with root package name */
        Disposable f48198l;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {

            /* renamed from: f  reason: collision with root package name */
            final SwitchMapCompletableObserver<?> f48199f;

            SwitchMapInnerObserver(SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.f48199f = switchMapCompletableObserver;
            }

            void a() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.f48199f.b(this);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f48199f.c(this, th);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.j(this, disposable);
            }
        }

        SwitchMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z7) {
            this.f48192f = completableObserver;
            this.f48193g = function;
            this.f48194h = z7;
        }

        void a() {
            AtomicReference<SwitchMapInnerObserver> atomicReference = this.f48196j;
            SwitchMapInnerObserver switchMapInnerObserver = f48191m;
            SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
            if (andSet != null && andSet != switchMapInnerObserver) {
                andSet.a();
            }
        }

        void b(SwitchMapInnerObserver switchMapInnerObserver) {
            if (e.a(this.f48196j, switchMapInnerObserver, null) && this.f48197k) {
                Throwable b8 = this.f48195i.b();
                if (b8 == null) {
                    this.f48192f.onComplete();
                } else {
                    this.f48192f.onError(b8);
                }
            }
        }

        void c(SwitchMapInnerObserver switchMapInnerObserver, Throwable th) {
            if (e.a(this.f48196j, switchMapInnerObserver, null) && this.f48195i.a(th)) {
                if (this.f48194h) {
                    if (this.f48197k) {
                        this.f48192f.onError(this.f48195i.b());
                        return;
                    }
                    return;
                }
                dispose();
                Throwable b8 = this.f48195i.b();
                if (b8 != ExceptionHelper.f49808a) {
                    this.f48192f.onError(b8);
                    return;
                }
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48198l.dispose();
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.f48196j.get() == f48191m) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48197k = true;
            if (this.f48196j.get() == null) {
                Throwable b8 = this.f48195i.b();
                if (b8 == null) {
                    this.f48192f.onComplete();
                } else {
                    this.f48192f.onError(b8);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48195i.a(th)) {
                if (this.f48194h) {
                    onComplete();
                    return;
                }
                a();
                Throwable b8 = this.f48195i.b();
                if (b8 != ExceptionHelper.f49808a) {
                    this.f48192f.onError(b8);
                    return;
                }
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.e(this.f48193g.apply(t7), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.f48196j.get();
                    if (switchMapInnerObserver == f48191m) {
                        return;
                    }
                } while (!e.a(this.f48196j, switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.a();
                }
                completableSource.a(switchMapInnerObserver2);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48198l.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48198l, disposable)) {
                this.f48198l = disposable;
                this.f48192f.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, boolean z7) {
        this.f48188f = observable;
        this.f48189g = function;
        this.f48190h = z7;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        if (!ScalarXMapZHelper.a(this.f48188f, this.f48189g, completableObserver)) {
            this.f48188f.subscribe(new SwitchMapCompletableObserver(completableObserver, this.f48189g, this.f48190h));
        }
    }
}
