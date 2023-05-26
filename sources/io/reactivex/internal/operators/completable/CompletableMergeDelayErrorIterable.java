package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class CompletableMergeDelayErrorIterable extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final Iterable<? extends CompletableSource> f47753f;

    public CompletableMergeDelayErrorIterable(Iterable<? extends CompletableSource> iterable) {
        this.f47753f = iterable;
    }

    @Override // io.reactivex.Completable
    public void H(final CompletableObserver completableObserver) {
        final CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        try {
            Iterator it = (Iterator) ObjectHelper.e(this.f47753f.iterator(), "The source iterator returned is null");
            final AtomicInteger atomicInteger = new AtomicInteger(1);
            final AtomicThrowable atomicThrowable = new AtomicThrowable();
            while (!compositeDisposable.isDisposed()) {
                try {
                    if (it.hasNext()) {
                        if (compositeDisposable.isDisposed()) {
                            return;
                        }
                        try {
                            CompletableSource completableSource = (CompletableSource) ObjectHelper.e(it.next(), "The iterator returned a null CompletableSource");
                            if (compositeDisposable.isDisposed()) {
                                return;
                            }
                            atomicInteger.getAndIncrement();
                            completableSource.a(new CompletableObserver(completableObserver, compositeDisposable, atomicThrowable, atomicInteger) { // from class: io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray$MergeInnerCompletableObserver

                                /* renamed from: f  reason: collision with root package name */
                                final CompletableObserver f47749f;

                                /* renamed from: g  reason: collision with root package name */
                                final CompositeDisposable f47750g;

                                /* renamed from: h  reason: collision with root package name */
                                final AtomicThrowable f47751h;

                                /* renamed from: i  reason: collision with root package name */
                                final AtomicInteger f47752i;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    this.f47749f = completableObserver;
                                    this.f47750g = compositeDisposable;
                                    this.f47751h = atomicThrowable;
                                    this.f47752i = atomicInteger;
                                }

                                void a() {
                                    if (this.f47752i.decrementAndGet() == 0) {
                                        Throwable b8 = this.f47751h.b();
                                        if (b8 == null) {
                                            this.f47749f.onComplete();
                                        } else {
                                            this.f47749f.onError(b8);
                                        }
                                    }
                                }

                                @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
                                public void onComplete() {
                                    a();
                                }

                                @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
                                public void onError(Throwable th) {
                                    if (this.f47751h.a(th)) {
                                        a();
                                    } else {
                                        RxJavaPlugins.s(th);
                                    }
                                }

                                @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
                                public void onSubscribe(Disposable disposable) {
                                    this.f47750g.b(disposable);
                                }
                            });
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            atomicThrowable.a(th);
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    atomicThrowable.a(th2);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    Throwable b8 = atomicThrowable.b();
                    if (b8 == null) {
                        completableObserver.onComplete();
                        return;
                    } else {
                        completableObserver.onError(b8);
                        return;
                    }
                }
                return;
            }
        } catch (Throwable th3) {
            Exceptions.b(th3);
            completableObserver.onError(th3);
        }
    }
}
