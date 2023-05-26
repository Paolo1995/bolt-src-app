package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final long f48585g;

    /* renamed from: h  reason: collision with root package name */
    final T f48586h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f48587i;

    /* loaded from: classes5.dex */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48588f;

        /* renamed from: g  reason: collision with root package name */
        final long f48589g;

        /* renamed from: h  reason: collision with root package name */
        final T f48590h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f48591i;

        /* renamed from: j  reason: collision with root package name */
        Disposable f48592j;

        /* renamed from: k  reason: collision with root package name */
        long f48593k;

        /* renamed from: l  reason: collision with root package name */
        boolean f48594l;

        ElementAtObserver(Observer<? super T> observer, long j8, T t7, boolean z7) {
            this.f48588f = observer;
            this.f48589g = j8;
            this.f48590h = t7;
            this.f48591i = z7;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48592j.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48592j.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.f48594l) {
                this.f48594l = true;
                T t7 = this.f48590h;
                if (t7 == null && this.f48591i) {
                    this.f48588f.onError(new NoSuchElementException());
                    return;
                }
                if (t7 != null) {
                    this.f48588f.onNext(t7);
                }
                this.f48588f.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48594l) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48594l = true;
            this.f48588f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48594l) {
                return;
            }
            long j8 = this.f48593k;
            if (j8 == this.f48589g) {
                this.f48594l = true;
                this.f48592j.dispose();
                this.f48588f.onNext(t7);
                this.f48588f.onComplete();
                return;
            }
            this.f48593k = j8 + 1;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48592j, disposable)) {
                this.f48592j = disposable;
                this.f48588f.onSubscribe(this);
            }
        }
    }

    public ObservableElementAt(ObservableSource<T> observableSource, long j8, T t7, boolean z7) {
        super(observableSource);
        this.f48585g = j8;
        this.f48586h = t7;
        this.f48587i = z7;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new ElementAtObserver(observer, this.f48585g, this.f48586h, this.f48587i));
    }
}
