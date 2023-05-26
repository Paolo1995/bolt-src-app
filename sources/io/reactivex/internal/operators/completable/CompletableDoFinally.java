package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class CompletableDoFinally extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final CompletableSource f47735f;

    /* renamed from: g  reason: collision with root package name */
    final Action f47736g;

    /* loaded from: classes5.dex */
    static final class DoFinallyObserver extends AtomicInteger implements CompletableObserver, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f47737f;

        /* renamed from: g  reason: collision with root package name */
        final Action f47738g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f47739h;

        DoFinallyObserver(CompletableObserver completableObserver, Action action) {
            this.f47737f = completableObserver;
            this.f47738g = action;
        }

        void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f47738g.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f47739h.dispose();
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f47739h.isDisposed();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.f47737f.onComplete();
            a();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f47737f.onError(th);
            a();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f47739h, disposable)) {
                this.f47739h = disposable;
                this.f47737f.onSubscribe(this);
            }
        }
    }

    public CompletableDoFinally(CompletableSource completableSource, Action action) {
        this.f47735f = completableSource;
        this.f47736g = action;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        this.f47735f.a(new DoFinallyObserver(completableObserver, this.f47736g));
    }
}
