package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes5.dex */
public final class BlockingObservableIterable<T> implements Iterable<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<? extends T> f48233f;

    /* renamed from: g  reason: collision with root package name */
    final int f48234g;

    /* loaded from: classes5.dex */
    static final class BlockingObservableIterator<T> extends AtomicReference<Disposable> implements Observer<T>, Iterator<T>, Disposable, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        final SpscLinkedArrayQueue<T> f48235f;

        /* renamed from: g  reason: collision with root package name */
        final Lock f48236g;

        /* renamed from: h  reason: collision with root package name */
        final Condition f48237h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f48238i;

        /* renamed from: j  reason: collision with root package name */
        volatile Throwable f48239j;

        BlockingObservableIterator(int i8) {
            this.f48235f = new SpscLinkedArrayQueue<>(i8);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.f48236g = reentrantLock;
            this.f48237h = reentrantLock.newCondition();
        }

        void b() {
            this.f48236g.lock();
            try {
                this.f48237h.signalAll();
            } finally {
                this.f48236g.unlock();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
            b();
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
            while (!isDisposed()) {
                boolean z7 = this.f48238i;
                boolean isEmpty = this.f48235f.isEmpty();
                if (z7) {
                    Throwable th = this.f48239j;
                    if (th == null) {
                        if (isEmpty) {
                            return false;
                        }
                    } else {
                        throw ExceptionHelper.e(th);
                    }
                }
                if (isEmpty) {
                    try {
                        BlockingHelper.b();
                        this.f48236g.lock();
                        while (!this.f48238i && this.f48235f.isEmpty() && !isDisposed()) {
                            this.f48237h.await();
                        }
                        this.f48236g.unlock();
                    } catch (InterruptedException e8) {
                        DisposableHelper.a(this);
                        b();
                        throw ExceptionHelper.e(e8);
                    }
                } else {
                    return true;
                }
            }
            Throwable th2 = this.f48239j;
            if (th2 == null) {
                return false;
            }
            throw ExceptionHelper.e(th2);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public T next() {
            if (hasNext()) {
                return this.f48235f.poll();
            }
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48238i = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48239j = th;
            this.f48238i = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48235f.offer(t7);
            b();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this, disposable);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    public BlockingObservableIterable(ObservableSource<? extends T> observableSource, int i8) {
        this.f48233f = observableSource;
        this.f48234g = i8;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        BlockingObservableIterator blockingObservableIterator = new BlockingObservableIterator(this.f48234g);
        this.f48233f.subscribe(blockingObservableIterator);
        return blockingObservableIterator;
    }
}
