package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: g  reason: collision with root package name */
    final int f48290g;

    /* renamed from: h  reason: collision with root package name */
    final int f48291h;

    /* renamed from: i  reason: collision with root package name */
    final Callable<U> f48292i;

    /* loaded from: classes5.dex */
    static final class BufferExactObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super U> f48293f;

        /* renamed from: g  reason: collision with root package name */
        final int f48294g;

        /* renamed from: h  reason: collision with root package name */
        final Callable<U> f48295h;

        /* renamed from: i  reason: collision with root package name */
        U f48296i;

        /* renamed from: j  reason: collision with root package name */
        int f48297j;

        /* renamed from: k  reason: collision with root package name */
        Disposable f48298k;

        BufferExactObserver(Observer<? super U> observer, int i8, Callable<U> callable) {
            this.f48293f = observer;
            this.f48294g = i8;
            this.f48295h = callable;
        }

        boolean a() {
            try {
                this.f48296i = (U) ObjectHelper.e(this.f48295h.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48296i = null;
                Disposable disposable = this.f48298k;
                if (disposable == null) {
                    EmptyDisposable.h(th, this.f48293f);
                    return false;
                }
                disposable.dispose();
                this.f48293f.onError(th);
                return false;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48298k.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48298k.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u7 = this.f48296i;
            if (u7 != null) {
                this.f48296i = null;
                if (!u7.isEmpty()) {
                    this.f48293f.onNext(u7);
                }
                this.f48293f.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48296i = null;
            this.f48293f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            U u7 = this.f48296i;
            if (u7 != null) {
                u7.add(t7);
                int i8 = this.f48297j + 1;
                this.f48297j = i8;
                if (i8 >= this.f48294g) {
                    this.f48293f.onNext(u7);
                    this.f48297j = 0;
                    a();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48298k, disposable)) {
                this.f48298k = disposable;
                this.f48293f.onSubscribe(this);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super U> f48299f;

        /* renamed from: g  reason: collision with root package name */
        final int f48300g;

        /* renamed from: h  reason: collision with root package name */
        final int f48301h;

        /* renamed from: i  reason: collision with root package name */
        final Callable<U> f48302i;

        /* renamed from: j  reason: collision with root package name */
        Disposable f48303j;

        /* renamed from: k  reason: collision with root package name */
        final ArrayDeque<U> f48304k = new ArrayDeque<>();

        /* renamed from: l  reason: collision with root package name */
        long f48305l;

        BufferSkipObserver(Observer<? super U> observer, int i8, int i9, Callable<U> callable) {
            this.f48299f = observer;
            this.f48300g = i8;
            this.f48301h = i9;
            this.f48302i = callable;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48303j.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48303j.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            while (!this.f48304k.isEmpty()) {
                this.f48299f.onNext(this.f48304k.poll());
            }
            this.f48299f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48304k.clear();
            this.f48299f.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            long j8 = this.f48305l;
            this.f48305l = 1 + j8;
            if (j8 % this.f48301h == 0) {
                try {
                    this.f48304k.offer((Collection) ObjectHelper.e(this.f48302i.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th) {
                    this.f48304k.clear();
                    this.f48303j.dispose();
                    this.f48299f.onError(th);
                    return;
                }
            }
            Iterator<U> it = this.f48304k.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t7);
                if (this.f48300g <= next.size()) {
                    it.remove();
                    this.f48299f.onNext(next);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48303j, disposable)) {
                this.f48303j = disposable;
                this.f48299f.onSubscribe(this);
            }
        }
    }

    public ObservableBuffer(ObservableSource<T> observableSource, int i8, int i9, Callable<U> callable) {
        super(observableSource);
        this.f48290g = i8;
        this.f48291h = i9;
        this.f48292i = callable;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        int i8 = this.f48291h;
        int i9 = this.f48290g;
        if (i8 == i9) {
            BufferExactObserver bufferExactObserver = new BufferExactObserver(observer, i9, this.f48292i);
            if (bufferExactObserver.a()) {
                this.f48232f.subscribe(bufferExactObserver);
                return;
            }
            return;
        }
        this.f48232f.subscribe(new BufferSkipObserver(observer, this.f48290g, this.f48291h, this.f48292i));
    }
}
