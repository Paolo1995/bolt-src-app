package io.reactivex.internal.operators.observable;

import androidx.camera.view.e;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservablePublishAlt<T> extends ConnectableObservable<T> implements ResettableConnectable {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48932f;

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<PublishConnection<T>> f48933g = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class InnerDisposable<T> extends AtomicReference<PublishConnection<T>> implements Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48934f;

        InnerDisposable(Observer<? super T> observer, PublishConnection<T> publishConnection) {
            this.f48934f = observer;
            lazySet(publishConnection);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            PublishConnection<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == null) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    static final class PublishConnection<T> extends AtomicReference<InnerDisposable<T>[]> implements Observer<T>, Disposable {

        /* renamed from: j  reason: collision with root package name */
        static final InnerDisposable[] f48935j = new InnerDisposable[0];

        /* renamed from: k  reason: collision with root package name */
        static final InnerDisposable[] f48936k = new InnerDisposable[0];

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<PublishConnection<T>> f48938g;

        /* renamed from: i  reason: collision with root package name */
        Throwable f48940i;

        /* renamed from: f  reason: collision with root package name */
        final AtomicBoolean f48937f = new AtomicBoolean();

        /* renamed from: h  reason: collision with root package name */
        final AtomicReference<Disposable> f48939h = new AtomicReference<>();

        PublishConnection(AtomicReference<PublishConnection<T>> atomicReference) {
            this.f48938g = atomicReference;
            lazySet(f48935j);
        }

        public boolean a(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = get();
                if (innerDisposableArr == f48936k) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }

        public void b(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i8 = -1;
                int i9 = 0;
                while (true) {
                    if (i9 >= length) {
                        break;
                    } else if (innerDisposableArr[i9] == innerDisposable) {
                        i8 = i9;
                        break;
                    } else {
                        i9++;
                    }
                }
                if (i8 < 0) {
                    return;
                }
                innerDisposableArr2 = f48935j;
                if (length != 1) {
                    innerDisposableArr2 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, i8);
                    System.arraycopy(innerDisposableArr, i8 + 1, innerDisposableArr2, i8, (length - i8) - 1);
                }
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            getAndSet(f48936k);
            e.a(this.f48938g, this, null);
            DisposableHelper.a(this.f48939h);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == f48936k) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48939h.lazySet(DisposableHelper.DISPOSED);
            for (InnerDisposable<T> innerDisposable : getAndSet(f48936k)) {
                innerDisposable.f48934f.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48940i = th;
            this.f48939h.lazySet(DisposableHelper.DISPOSED);
            for (InnerDisposable<T> innerDisposable : getAndSet(f48936k)) {
                innerDisposable.f48934f.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            for (InnerDisposable<T> innerDisposable : get()) {
                innerDisposable.f48934f.onNext(t7);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this.f48939h, disposable);
        }
    }

    public ObservablePublishAlt(ObservableSource<T> observableSource) {
        this.f48932f = observableSource;
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public void b(Disposable disposable) {
        e.a(this.f48933g, (PublishConnection) disposable, null);
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void c(Consumer<? super Disposable> consumer) {
        PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.f48933g.get();
            if (publishConnection != null && !publishConnection.isDisposed()) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(this.f48933g);
            if (e.a(this.f48933g, publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        boolean z7 = true;
        z7 = (publishConnection.f48937f.get() || !publishConnection.f48937f.compareAndSet(false, true)) ? false : false;
        try {
            consumer.accept(publishConnection);
            if (z7) {
                this.f48932f.subscribe(publishConnection);
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            throw ExceptionHelper.e(th);
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.f48933g.get();
            if (publishConnection != null) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(this.f48933g);
            if (e.a(this.f48933g, publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        InnerDisposable<T> innerDisposable = new InnerDisposable<>(observer, publishConnection);
        observer.onSubscribe(innerDisposable);
        if (publishConnection.a(innerDisposable)) {
            if (innerDisposable.isDisposed()) {
                publishConnection.b(innerDisposable);
                return;
            }
            return;
        }
        Throwable th = publishConnection.f48940i;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }
}
