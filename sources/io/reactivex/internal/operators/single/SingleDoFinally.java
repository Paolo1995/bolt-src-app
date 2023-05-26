package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class SingleDoFinally<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<T> f49544f;

    /* renamed from: g  reason: collision with root package name */
    final Action f49545g;

    /* loaded from: classes5.dex */
    static final class DoFinallyObserver<T> extends AtomicInteger implements SingleObserver<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super T> f49546f;

        /* renamed from: g  reason: collision with root package name */
        final Action f49547g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f49548h;

        DoFinallyObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.f49546f = singleObserver;
            this.f49547g = action;
        }

        void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f49547g.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49548h.dispose();
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49548h.isDisposed();
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f49546f.onError(th);
            a();
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49548h, disposable)) {
                this.f49548h = disposable;
                this.f49546f.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            this.f49546f.onSuccess(t7);
            a();
        }
    }

    public SingleDoFinally(SingleSource<T> singleSource, Action action) {
        this.f49544f = singleSource;
        this.f49545g = action;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        this.f49544f.a(new DoFinallyObserver(singleObserver, this.f49545g));
    }
}
