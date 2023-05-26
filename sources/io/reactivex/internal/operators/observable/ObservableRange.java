package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* loaded from: classes5.dex */
public final class ObservableRange extends Observable<Integer> {

    /* renamed from: f  reason: collision with root package name */
    private final int f48946f;

    /* renamed from: g  reason: collision with root package name */
    private final long f48947g;

    /* loaded from: classes5.dex */
    static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super Integer> f48948f;

        /* renamed from: g  reason: collision with root package name */
        final long f48949g;

        /* renamed from: h  reason: collision with root package name */
        long f48950h;

        /* renamed from: i  reason: collision with root package name */
        boolean f48951i;

        RangeDisposable(Observer<? super Integer> observer, long j8, long j9) {
            this.f48948f = observer;
            this.f48950h = j8;
            this.f48949g = j9;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            if ((i8 & 1) != 0) {
                this.f48951i = true;
                return 1;
            }
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        /* renamed from: b */
        public Integer poll() throws Exception {
            long j8 = this.f48950h;
            if (j8 != this.f48949g) {
                this.f48950h = 1 + j8;
                return Integer.valueOf((int) j8);
            }
            lazySet(1);
            return null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f48950h = this.f48949g;
            lazySet(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            set(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != 0) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            if (this.f48950h == this.f48949g) {
                return true;
            }
            return false;
        }

        void run() {
            if (this.f48951i) {
                return;
            }
            Observer<? super Integer> observer = this.f48948f;
            long j8 = this.f48949g;
            for (long j9 = this.f48950h; j9 != j8 && get() == 0; j9++) {
                observer.onNext(Integer.valueOf((int) j9));
            }
            if (get() == 0) {
                lazySet(1);
                observer.onComplete();
            }
        }
    }

    public ObservableRange(int i8, int i9) {
        this.f48946f = i8;
        this.f48947g = i8 + i9;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Integer> observer) {
        RangeDisposable rangeDisposable = new RangeDisposable(observer, this.f48946f, this.f48947g);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
