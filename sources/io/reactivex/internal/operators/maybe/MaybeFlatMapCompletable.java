package io.reactivex.internal.operators.maybe;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class MaybeFlatMapCompletable<T> extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final MaybeSource<T> f48118f;

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends CompletableSource> f48119g;

    /* loaded from: classes5.dex */
    static final class FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, CompletableObserver, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f48120f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends CompletableSource> f48121g;

        FlatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function) {
            this.f48120f = completableObserver;
            this.f48121g = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f48120f.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f48120f.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.e(this, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.e(this.f48121g.apply(t7), "The mapper returned a null CompletableSource");
                if (!isDisposed()) {
                    completableSource.a(this);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                onError(th);
            }
        }
    }

    public MaybeFlatMapCompletable(MaybeSource<T> maybeSource, Function<? super T, ? extends CompletableSource> function) {
        this.f48118f = maybeSource;
        this.f48119g = function;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        FlatMapCompletableObserver flatMapCompletableObserver = new FlatMapCompletableObserver(completableObserver, this.f48119g);
        completableObserver.onSubscribe(flatMapCompletableObserver);
        this.f48118f.a(flatMapCompletableObserver);
    }
}
