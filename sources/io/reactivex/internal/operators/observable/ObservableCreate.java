package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableCreate<T> extends Observable<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableOnSubscribe<T> f48495f;

    /* loaded from: classes5.dex */
    static final class CreateEmitter<T> extends AtomicReference<Disposable> implements ObservableEmitter<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48496f;

        CreateEmitter(Observer<? super T> observer) {
            this.f48496f = observer;
        }

        @Override // io.reactivex.ObservableEmitter
        public boolean a(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (!isDisposed()) {
                try {
                    this.f48496f.onError(th);
                    dispose();
                    return true;
                } catch (Throwable th2) {
                    dispose();
                    throw th2;
                }
            }
            return false;
        }

        @Override // io.reactivex.ObservableEmitter
        public void b(Cancellable cancellable) {
            c(new CancellableDisposable(cancellable));
        }

        @Override // io.reactivex.ObservableEmitter
        public void c(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.ObservableEmitter, io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (!isDisposed()) {
                try {
                    this.f48496f.onComplete();
                } finally {
                    dispose();
                }
            }
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th) {
            if (!a(th)) {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t7) {
            if (t7 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (!isDisposed()) {
                this.f48496f.onNext(t7);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", CreateEmitter.class.getSimpleName(), super.toString());
        }
    }

    public ObservableCreate(ObservableOnSubscribe<T> observableOnSubscribe) {
        this.f48495f = observableOnSubscribe;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        CreateEmitter createEmitter = new CreateEmitter(observer);
        observer.onSubscribe(createEmitter);
        try {
            this.f48495f.a(createEmitter);
        } catch (Throwable th) {
            Exceptions.b(th);
            createEmitter.onError(th);
        }
    }
}
