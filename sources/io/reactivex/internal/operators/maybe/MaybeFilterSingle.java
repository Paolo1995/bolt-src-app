package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes5.dex */
public final class MaybeFilterSingle<T> extends Maybe<T> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<T> f48113f;

    /* renamed from: g  reason: collision with root package name */
    final Predicate<? super T> f48114g;

    /* loaded from: classes5.dex */
    static final class FilterMaybeObserver<T> implements SingleObserver<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final MaybeObserver<? super T> f48115f;

        /* renamed from: g  reason: collision with root package name */
        final Predicate<? super T> f48116g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f48117h;

        FilterMaybeObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super T> predicate) {
            this.f48115f = maybeObserver;
            this.f48116g = predicate;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable disposable = this.f48117h;
            this.f48117h = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48117h.isDisposed();
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f48115f.onError(th);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48117h, disposable)) {
                this.f48117h = disposable;
                this.f48115f.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            try {
                if (this.f48116g.test(t7)) {
                    this.f48115f.onSuccess(t7);
                } else {
                    this.f48115f.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48115f.onError(th);
            }
        }
    }

    public MaybeFilterSingle(SingleSource<T> singleSource, Predicate<? super T> predicate) {
        this.f48113f = singleSource;
        this.f48114g = predicate;
    }

    @Override // io.reactivex.Maybe
    protected void i(MaybeObserver<? super T> maybeObserver) {
        this.f48113f.a(new FilterMaybeObserver(maybeObserver, this.f48114g));
    }
}
