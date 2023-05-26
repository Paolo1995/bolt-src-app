package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class BlockingObservableLatest<T> implements Iterable<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48240f;

    /* loaded from: classes5.dex */
    static final class BlockingObservableLatestIterator<T> extends DisposableObserver<Notification<T>> implements Iterator<T>, j$.util.Iterator {

        /* renamed from: g  reason: collision with root package name */
        Notification<T> f48241g;

        /* renamed from: h  reason: collision with root package name */
        final Semaphore f48242h = new Semaphore(0);

        /* renamed from: i  reason: collision with root package name */
        final AtomicReference<Notification<T>> f48243i = new AtomicReference<>();

        BlockingObservableLatestIterator() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: c */
        public void onNext(Notification<T> notification) {
            boolean z7;
            if (this.f48243i.getAndSet(notification) == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                this.f48242h.release();
            }
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            Notification<T> notification = this.f48241g;
            if (notification != null && notification.g()) {
                throw ExceptionHelper.e(this.f48241g.d());
            }
            if (this.f48241g == null) {
                try {
                    BlockingHelper.b();
                    this.f48242h.acquire();
                    Notification<T> andSet = this.f48243i.getAndSet(null);
                    this.f48241g = andSet;
                    if (andSet.g()) {
                        throw ExceptionHelper.e(andSet.d());
                    }
                } catch (InterruptedException e8) {
                    dispose();
                    this.f48241g = Notification.b(e8);
                    throw ExceptionHelper.e(e8);
                }
            }
            return this.f48241g.h();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public T next() {
            if (hasNext()) {
                T e8 = this.f48241g.e();
                this.f48241g = null;
                return e8;
            }
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            RxJavaPlugins.s(th);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public BlockingObservableLatest(ObservableSource<T> observableSource) {
        this.f48240f = observableSource;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        BlockingObservableLatestIterator blockingObservableLatestIterator = new BlockingObservableLatestIterator();
        Observable.wrap(this.f48240f).materialize().subscribe(blockingObservableLatestIterator);
        return blockingObservableLatestIterator;
    }
}
