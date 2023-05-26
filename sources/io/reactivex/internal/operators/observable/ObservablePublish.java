package io.reactivex.internal.operators.observable;

import androidx.camera.view.e;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservablePublish<T> extends ConnectableObservable<T> implements ObservablePublishClassic<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48921f;

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<PublishObserver<T>> f48922g;

    /* renamed from: h  reason: collision with root package name */
    final ObservableSource<T> f48923h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class InnerDisposable<T> extends AtomicReference<Object> implements Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48924f;

        InnerDisposable(Observer<? super T> observer) {
            this.f48924f = observer;
        }

        void a(PublishObserver<T> publishObserver) {
            if (!compareAndSet(null, publishObserver)) {
                publishObserver.b(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet != null && andSet != this) {
                ((PublishObserver) andSet).b(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == this) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class PublishObserver<T> implements Observer<T>, Disposable {

        /* renamed from: j  reason: collision with root package name */
        static final InnerDisposable[] f48925j = new InnerDisposable[0];

        /* renamed from: k  reason: collision with root package name */
        static final InnerDisposable[] f48926k = new InnerDisposable[0];

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<PublishObserver<T>> f48927f;

        /* renamed from: i  reason: collision with root package name */
        final AtomicReference<Disposable> f48930i = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<InnerDisposable<T>[]> f48928g = new AtomicReference<>(f48925j);

        /* renamed from: h  reason: collision with root package name */
        final AtomicBoolean f48929h = new AtomicBoolean();

        PublishObserver(AtomicReference<PublishObserver<T>> atomicReference) {
            this.f48927f = atomicReference;
        }

        boolean a(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.f48928g.get();
                if (innerDisposableArr == f48926k) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!e.a(this.f48928g, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        void b(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.f48928g.get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i8 = -1;
                int i9 = 0;
                while (true) {
                    if (i9 >= length) {
                        break;
                    } else if (innerDisposableArr[i9].equals(innerDisposable)) {
                        i8 = i9;
                        break;
                    } else {
                        i9++;
                    }
                }
                if (i8 < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = f48925j;
                } else {
                    InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i8);
                    System.arraycopy(innerDisposableArr, i8 + 1, innerDisposableArr3, i8, (length - i8) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!e.a(this.f48928g, innerDisposableArr, innerDisposableArr2));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            AtomicReference<InnerDisposable<T>[]> atomicReference = this.f48928g;
            InnerDisposable<T>[] innerDisposableArr = f48926k;
            if (atomicReference.getAndSet(innerDisposableArr) != innerDisposableArr) {
                e.a(this.f48927f, this, null);
                DisposableHelper.a(this.f48930i);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.f48928g.get() == f48926k) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            e.a(this.f48927f, this, null);
            for (InnerDisposable<T> innerDisposable : this.f48928g.getAndSet(f48926k)) {
                innerDisposable.f48924f.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            e.a(this.f48927f, this, null);
            InnerDisposable<T>[] andSet = this.f48928g.getAndSet(f48926k);
            if (andSet.length != 0) {
                for (InnerDisposable<T> innerDisposable : andSet) {
                    innerDisposable.f48924f.onError(th);
                }
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            for (InnerDisposable<T> innerDisposable : this.f48928g.get()) {
                innerDisposable.f48924f.onNext(t7);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this.f48930i, disposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class PublishSource<T> implements ObservableSource<T> {

        /* renamed from: f  reason: collision with root package name */
        private final AtomicReference<PublishObserver<T>> f48931f;

        PublishSource(AtomicReference<PublishObserver<T>> atomicReference) {
            this.f48931f = atomicReference;
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> observer) {
            InnerDisposable innerDisposable = new InnerDisposable(observer);
            observer.onSubscribe(innerDisposable);
            while (true) {
                PublishObserver<T> publishObserver = this.f48931f.get();
                if (publishObserver == null || publishObserver.isDisposed()) {
                    PublishObserver<T> publishObserver2 = new PublishObserver<>(this.f48931f);
                    if (e.a(this.f48931f, publishObserver, publishObserver2)) {
                        publishObserver = publishObserver2;
                    } else {
                        continue;
                    }
                }
                if (publishObserver.a(innerDisposable)) {
                    innerDisposable.a(publishObserver);
                    return;
                }
            }
        }
    }

    private ObservablePublish(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<PublishObserver<T>> atomicReference) {
        this.f48923h = observableSource;
        this.f48921f = observableSource2;
        this.f48922g = atomicReference;
    }

    public static <T> ConnectableObservable<T> f(ObservableSource<T> observableSource) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.p(new ObservablePublish(new PublishSource(atomicReference), observableSource, atomicReference));
    }

    @Override // io.reactivex.internal.operators.observable.ObservablePublishClassic
    public ObservableSource<T> a() {
        return this.f48921f;
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void c(Consumer<? super Disposable> consumer) {
        PublishObserver<T> publishObserver;
        while (true) {
            publishObserver = this.f48922g.get();
            if (publishObserver != null && !publishObserver.isDisposed()) {
                break;
            }
            PublishObserver<T> publishObserver2 = new PublishObserver<>(this.f48922g);
            if (e.a(this.f48922g, publishObserver, publishObserver2)) {
                publishObserver = publishObserver2;
                break;
            }
        }
        boolean z7 = true;
        z7 = (publishObserver.f48929h.get() || !publishObserver.f48929h.compareAndSet(false, true)) ? false : false;
        try {
            consumer.accept(publishObserver);
            if (z7) {
                this.f48921f.subscribe(publishObserver);
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            throw ExceptionHelper.e(th);
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f48923h.subscribe(observer);
    }
}
