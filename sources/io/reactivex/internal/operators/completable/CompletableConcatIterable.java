package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class CompletableConcatIterable extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final Iterable<? extends CompletableSource> f47717f;

    /* loaded from: classes5.dex */
    static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f47718f;

        /* renamed from: g  reason: collision with root package name */
        final Iterator<? extends CompletableSource> f47719g;

        /* renamed from: h  reason: collision with root package name */
        final SequentialDisposable f47720h = new SequentialDisposable();

        ConcatInnerObserver(CompletableObserver completableObserver, Iterator<? extends CompletableSource> it) {
            this.f47718f = completableObserver;
            this.f47719g = it;
        }

        void a() {
            if (this.f47720h.isDisposed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends CompletableSource> it = this.f47719g;
            while (!this.f47720h.isDisposed()) {
                try {
                    if (!it.hasNext()) {
                        this.f47718f.onComplete();
                        return;
                    }
                    try {
                        ((CompletableSource) ObjectHelper.e(it.next(), "The CompletableSource returned is null")).a(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f47718f.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.f47718f.onError(th2);
                    return;
                }
            }
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f47718f.onError(th);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.f47720h.a(disposable);
        }
    }

    public CompletableConcatIterable(Iterable<? extends CompletableSource> iterable) {
        this.f47717f = iterable;
    }

    @Override // io.reactivex.Completable
    public void H(CompletableObserver completableObserver) {
        try {
            ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver, (Iterator) ObjectHelper.e(this.f47717f.iterator(), "The iterator returned is null"));
            completableObserver.onSubscribe(concatInnerObserver.f47720h);
            concatInnerObserver.a();
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.f(th, completableObserver);
        }
    }
}
