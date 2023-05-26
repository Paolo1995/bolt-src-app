package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

/* loaded from: classes5.dex */
public final class MaybeMap<T, R> extends AbstractMaybeWithUpstream<T, R> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends R> f48123g;

    /* loaded from: classes5.dex */
    static final class MapMaybeObserver<T, R> implements MaybeObserver<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final MaybeObserver<? super R> f48124f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends R> f48125g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f48126h;

        MapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends R> function) {
            this.f48124f = maybeObserver;
            this.f48125g = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable disposable = this.f48126h;
            this.f48126h = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48126h.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f48124f.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f48124f.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48126h, disposable)) {
                this.f48126h = disposable;
                this.f48124f.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            try {
                this.f48124f.onSuccess(ObjectHelper.e(this.f48125g.apply(t7), "The mapper returned a null item"));
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48124f.onError(th);
            }
        }
    }

    public MaybeMap(MaybeSource<T> maybeSource, Function<? super T, ? extends R> function) {
        super(maybeSource);
        this.f48123g = function;
    }

    @Override // io.reactivex.Maybe
    protected void i(MaybeObserver<? super R> maybeObserver) {
        this.f48109f.a(new MapMaybeObserver(maybeObserver, this.f48123g));
    }
}
