package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* loaded from: classes5.dex */
public final class ObservableRangeLong extends Observable<Long> {

    /* renamed from: f  reason: collision with root package name */
    private final long f48952f;

    /* renamed from: g  reason: collision with root package name */
    private final long f48953g;

    /* loaded from: classes5.dex */
    static final class RangeDisposable extends BasicIntQueueDisposable<Long> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super Long> f48954f;

        /* renamed from: g  reason: collision with root package name */
        final long f48955g;

        /* renamed from: h  reason: collision with root package name */
        long f48956h;

        /* renamed from: i  reason: collision with root package name */
        boolean f48957i;

        RangeDisposable(Observer<? super Long> observer, long j8, long j9) {
            this.f48954f = observer;
            this.f48956h = j8;
            this.f48955g = j9;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            if ((i8 & 1) != 0) {
                this.f48957i = true;
                return 1;
            }
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        /* renamed from: b */
        public Long poll() throws Exception {
            long j8 = this.f48956h;
            if (j8 != this.f48955g) {
                this.f48956h = 1 + j8;
                return Long.valueOf(j8);
            }
            lazySet(1);
            return null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f48956h = this.f48955g;
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
            if (this.f48956h == this.f48955g) {
                return true;
            }
            return false;
        }

        void run() {
            if (this.f48957i) {
                return;
            }
            Observer<? super Long> observer = this.f48954f;
            long j8 = this.f48955g;
            for (long j9 = this.f48956h; j9 != j8 && get() == 0; j9++) {
                observer.onNext(Long.valueOf(j9));
            }
            if (get() == 0) {
                lazySet(1);
                observer.onComplete();
            }
        }
    }

    public ObservableRangeLong(long j8, long j9) {
        this.f48952f = j8;
        this.f48953g = j9;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Long> observer) {
        long j8 = this.f48952f;
        RangeDisposable rangeDisposable = new RangeDisposable(observer, j8, j8 + this.f48953g);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
