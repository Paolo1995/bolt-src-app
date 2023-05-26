package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class ObservableGenerate<T, S> extends Observable<T> {

    /* renamed from: f  reason: collision with root package name */
    final Callable<S> f48712f;

    /* renamed from: g  reason: collision with root package name */
    final BiFunction<S, Emitter<T>, S> f48713g;

    /* renamed from: h  reason: collision with root package name */
    final Consumer<? super S> f48714h;

    /* loaded from: classes5.dex */
    static final class GeneratorDisposable<T, S> implements Emitter<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48715f;

        /* renamed from: g  reason: collision with root package name */
        final BiFunction<S, ? super Emitter<T>, S> f48716g;

        /* renamed from: h  reason: collision with root package name */
        final Consumer<? super S> f48717h;

        /* renamed from: i  reason: collision with root package name */
        S f48718i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f48719j;

        /* renamed from: k  reason: collision with root package name */
        boolean f48720k;

        /* renamed from: l  reason: collision with root package name */
        boolean f48721l;

        GeneratorDisposable(Observer<? super T> observer, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s7) {
            this.f48715f = observer;
            this.f48716g = biFunction;
            this.f48717h = consumer;
            this.f48718i = s7;
        }

        private void d(S s7) {
            try {
                this.f48717h.accept(s7);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48719j = true;
        }

        public void e() {
            S s7 = this.f48718i;
            if (this.f48719j) {
                this.f48718i = null;
                d(s7);
                return;
            }
            BiFunction<S, ? super Emitter<T>, S> biFunction = this.f48716g;
            while (!this.f48719j) {
                this.f48721l = false;
                try {
                    s7 = biFunction.apply(s7, this);
                    if (this.f48720k) {
                        this.f48719j = true;
                        this.f48718i = null;
                        d(s7);
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f48718i = null;
                    this.f48719j = true;
                    onError(th);
                    d(s7);
                    return;
                }
            }
            this.f48718i = null;
            d(s7);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48719j;
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th) {
            if (this.f48720k) {
                RxJavaPlugins.s(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f48720k = true;
            this.f48715f.onError(th);
        }
    }

    public ObservableGenerate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.f48712f = callable;
        this.f48713g = biFunction;
        this.f48714h = consumer;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            GeneratorDisposable generatorDisposable = new GeneratorDisposable(observer, this.f48713g, this.f48714h, this.f48712f.call());
            observer.onSubscribe(generatorDisposable);
            generatorDisposable.e();
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
        }
    }
}
