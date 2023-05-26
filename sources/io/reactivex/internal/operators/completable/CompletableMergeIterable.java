package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class CompletableMergeIterable extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final Iterable<? extends CompletableSource> f47754f;

    /* loaded from: classes5.dex */
    static final class MergeCompletableObserver extends AtomicBoolean implements CompletableObserver {

        /* renamed from: f  reason: collision with root package name */
        final CompositeDisposable f47755f;

        /* renamed from: g  reason: collision with root package name */
        final CompletableObserver f47756g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicInteger f47757h;

        MergeCompletableObserver(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicInteger atomicInteger) {
            this.f47756g = completableObserver;
            this.f47755f = compositeDisposable;
            this.f47757h = atomicInteger;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.f47757h.decrementAndGet() == 0 && compareAndSet(false, true)) {
                this.f47756g.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f47755f.dispose();
            if (compareAndSet(false, true)) {
                this.f47756g.onError(th);
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.f47755f.b(disposable);
        }
    }

    public CompletableMergeIterable(Iterable<? extends CompletableSource> iterable) {
        this.f47754f = iterable;
    }

    @Override // io.reactivex.Completable
    public void H(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        try {
            Iterator it = (Iterator) ObjectHelper.e(this.f47754f.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            MergeCompletableObserver mergeCompletableObserver = new MergeCompletableObserver(completableObserver, compositeDisposable, atomicInteger);
            while (!compositeDisposable.isDisposed()) {
                try {
                    if (!it.hasNext()) {
                        mergeCompletableObserver.onComplete();
                        return;
                    } else if (compositeDisposable.isDisposed()) {
                        return;
                    } else {
                        try {
                            CompletableSource completableSource = (CompletableSource) ObjectHelper.e(it.next(), "The iterator returned a null CompletableSource");
                            if (compositeDisposable.isDisposed()) {
                                return;
                            }
                            atomicInteger.getAndIncrement();
                            completableSource.a(mergeCompletableObserver);
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            compositeDisposable.dispose();
                            mergeCompletableObserver.onError(th);
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    compositeDisposable.dispose();
                    mergeCompletableObserver.onError(th2);
                    return;
                }
            }
        } catch (Throwable th3) {
            Exceptions.b(th3);
            completableObserver.onError(th3);
        }
    }
}
