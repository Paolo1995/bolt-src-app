package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class CompletablePeek extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final CompletableSource f47767f;

    /* renamed from: g  reason: collision with root package name */
    final Consumer<? super Disposable> f47768g;

    /* renamed from: h  reason: collision with root package name */
    final Consumer<? super Throwable> f47769h;

    /* renamed from: i  reason: collision with root package name */
    final Action f47770i;

    /* renamed from: j  reason: collision with root package name */
    final Action f47771j;

    /* renamed from: k  reason: collision with root package name */
    final Action f47772k;

    /* renamed from: l  reason: collision with root package name */
    final Action f47773l;

    /* loaded from: classes5.dex */
    final class CompletableObserverImplementation implements CompletableObserver, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f47774f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f47775g;

        CompletableObserverImplementation(CompletableObserver completableObserver) {
            this.f47774f = completableObserver;
        }

        void a() {
            try {
                CompletablePeek.this.f47772k.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            try {
                CompletablePeek.this.f47773l.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
            this.f47775g.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f47775g.isDisposed();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.f47775g == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                CompletablePeek.this.f47770i.run();
                CompletablePeek.this.f47771j.run();
                this.f47774f.onComplete();
                a();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f47774f.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            if (this.f47775g == DisposableHelper.DISPOSED) {
                RxJavaPlugins.s(th);
                return;
            }
            try {
                CompletablePeek.this.f47769h.accept(th);
                CompletablePeek.this.f47771j.run();
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f47774f.onError(th);
            a();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            try {
                CompletablePeek.this.f47768g.accept(disposable);
                if (DisposableHelper.l(this.f47775g, disposable)) {
                    this.f47775g = disposable;
                    this.f47774f.onSubscribe(this);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                disposable.dispose();
                this.f47775g = DisposableHelper.DISPOSED;
                EmptyDisposable.f(th, this.f47774f);
            }
        }
    }

    public CompletablePeek(CompletableSource completableSource, Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        this.f47767f = completableSource;
        this.f47768g = consumer;
        this.f47769h = consumer2;
        this.f47770i = action;
        this.f47771j = action2;
        this.f47772k = action3;
        this.f47773l = action4;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        this.f47767f.a(new CompletableObserverImplementation(completableObserver));
    }
}
