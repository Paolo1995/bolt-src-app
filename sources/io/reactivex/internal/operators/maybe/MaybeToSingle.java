package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
public final class MaybeToSingle<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final MaybeSource<T> f48131f;

    /* renamed from: g  reason: collision with root package name */
    final T f48132g;

    /* loaded from: classes5.dex */
    static final class ToSingleMaybeSubscriber<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super T> f48133f;

        /* renamed from: g  reason: collision with root package name */
        final T f48134g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f48135h;

        ToSingleMaybeSubscriber(SingleObserver<? super T> singleObserver, T t7) {
            this.f48133f = singleObserver;
            this.f48134g = t7;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48135h.dispose();
            this.f48135h = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48135h.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f48135h = DisposableHelper.DISPOSED;
            T t7 = this.f48134g;
            if (t7 != null) {
                this.f48133f.onSuccess(t7);
            } else {
                this.f48133f.onError(new NoSuchElementException("The MaybeSource is empty"));
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f48135h = DisposableHelper.DISPOSED;
            this.f48133f.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48135h, disposable)) {
                this.f48135h = disposable;
                this.f48133f.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            this.f48135h = DisposableHelper.DISPOSED;
            this.f48133f.onSuccess(t7);
        }
    }

    public MaybeToSingle(MaybeSource<T> maybeSource, T t7) {
        this.f48131f = maybeSource;
        this.f48132g = t7;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        this.f48131f.a(new ToSingleMaybeSubscriber(singleObserver, this.f48132g));
    }
}
