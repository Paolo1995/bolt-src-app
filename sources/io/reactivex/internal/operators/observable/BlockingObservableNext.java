package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class BlockingObservableNext<T> implements Iterable<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48249f;

    /* loaded from: classes5.dex */
    static final class NextIterator<T> implements Iterator<T>, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        private final NextObserver<T> f48250f;

        /* renamed from: g  reason: collision with root package name */
        private final ObservableSource<T> f48251g;

        /* renamed from: h  reason: collision with root package name */
        private T f48252h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f48253i = true;

        /* renamed from: j  reason: collision with root package name */
        private boolean f48254j = true;

        /* renamed from: k  reason: collision with root package name */
        private Throwable f48255k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f48256l;

        NextIterator(ObservableSource<T> observableSource, NextObserver<T> nextObserver) {
            this.f48251g = observableSource;
            this.f48250f = nextObserver;
        }

        private boolean b() {
            if (!this.f48256l) {
                this.f48256l = true;
                this.f48250f.d();
                new ObservableMaterialize(this.f48251g).subscribe(this.f48250f);
            }
            try {
                Notification<T> e8 = this.f48250f.e();
                if (e8.h()) {
                    this.f48254j = false;
                    this.f48252h = e8.e();
                    return true;
                }
                this.f48253i = false;
                if (e8.f()) {
                    return false;
                }
                Throwable d8 = e8.d();
                this.f48255k = d8;
                throw ExceptionHelper.e(d8);
            } catch (InterruptedException e9) {
                this.f48250f.dispose();
                this.f48255k = e9;
                throw ExceptionHelper.e(e9);
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
            Throwable th = this.f48255k;
            if (th == null) {
                if (!this.f48253i) {
                    return false;
                }
                if (this.f48254j && !b()) {
                    return false;
                }
                return true;
            }
            throw ExceptionHelper.e(th);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public T next() {
            Throwable th = this.f48255k;
            if (th == null) {
                if (hasNext()) {
                    this.f48254j = true;
                    return this.f48252h;
                }
                throw new NoSuchElementException("No more elements");
            }
            throw ExceptionHelper.e(th);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class NextObserver<T> extends DisposableObserver<Notification<T>> {

        /* renamed from: g  reason: collision with root package name */
        private final BlockingQueue<Notification<T>> f48257g = new ArrayBlockingQueue(1);

        /* renamed from: h  reason: collision with root package name */
        final AtomicInteger f48258h = new AtomicInteger();

        NextObserver() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: c */
        public void onNext(Notification<T> notification) {
            if (this.f48258h.getAndSet(0) == 1 || !notification.h()) {
                while (!this.f48257g.offer(notification)) {
                    Notification<T> poll = this.f48257g.poll();
                    if (poll != null && !poll.h()) {
                        notification = poll;
                    }
                }
            }
        }

        void d() {
            this.f48258h.set(1);
        }

        public Notification<T> e() throws InterruptedException {
            d();
            BlockingHelper.b();
            return this.f48257g.take();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            RxJavaPlugins.s(th);
        }
    }

    public BlockingObservableNext(ObservableSource<T> observableSource) {
        this.f48249f = observableSource;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        return new NextIterator(this.f48249f, new NextObserver());
    }
}
