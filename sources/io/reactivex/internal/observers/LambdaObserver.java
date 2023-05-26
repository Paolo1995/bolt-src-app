package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class LambdaObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

    /* renamed from: f  reason: collision with root package name */
    final Consumer<? super T> f47697f;

    /* renamed from: g  reason: collision with root package name */
    final Consumer<? super Throwable> f47698g;

    /* renamed from: h  reason: collision with root package name */
    final Action f47699h;

    /* renamed from: i  reason: collision with root package name */
    final Consumer<? super Disposable> f47700i;

    public LambdaObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        this.f47697f = consumer;
        this.f47698g = consumer2;
        this.f47699h = action;
        this.f47700i = consumer3;
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

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.f47699h.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.f47698g.accept(th);
                return;
            } catch (Throwable th2) {
                Exceptions.b(th2);
                RxJavaPlugins.s(new CompositeException(th, th2));
                return;
            }
        }
        RxJavaPlugins.s(th);
    }

    @Override // io.reactivex.Observer
    public void onNext(T t7) {
        if (!isDisposed()) {
            try {
                this.f47697f.accept(t7);
            } catch (Throwable th) {
                Exceptions.b(th);
                get().dispose();
                onError(th);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.j(this, disposable)) {
            try {
                this.f47700i.accept(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                disposable.dispose();
                onError(th);
            }
        }
    }
}
