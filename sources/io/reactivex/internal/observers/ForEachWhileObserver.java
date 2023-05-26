package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ForEachWhileObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

    /* renamed from: f  reason: collision with root package name */
    final Predicate<? super T> f47685f;

    /* renamed from: g  reason: collision with root package name */
    final Consumer<? super Throwable> f47686g;

    /* renamed from: h  reason: collision with root package name */
    final Action f47687h;

    /* renamed from: i  reason: collision with root package name */
    boolean f47688i;

    public ForEachWhileObserver(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        this.f47685f = predicate;
        this.f47686g = consumer;
        this.f47687h = action;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.a(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.c(get());
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f47688i) {
            return;
        }
        this.f47688i = true;
        try {
            this.f47687h.run();
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.f47688i) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f47688i = true;
        try {
            this.f47686g.accept(th);
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.s(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t7) {
        if (this.f47688i) {
            return;
        }
        try {
            if (!this.f47685f.test(t7)) {
                dispose();
                onComplete();
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        DisposableHelper.j(this, disposable);
    }
}
