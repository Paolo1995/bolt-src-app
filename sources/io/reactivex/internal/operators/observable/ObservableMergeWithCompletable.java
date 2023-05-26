package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableMergeWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final CompletableSource f48864g;

    /* loaded from: classes5.dex */
    static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48865f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<Disposable> f48866g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        final OtherObserver f48867h = new OtherObserver(this);

        /* renamed from: i  reason: collision with root package name */
        final AtomicThrowable f48868i = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f48869j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f48870k;

        /* loaded from: classes5.dex */
        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {

            /* renamed from: f  reason: collision with root package name */
            final MergeWithObserver<?> f48871f;

            OtherObserver(MergeWithObserver<?> mergeWithObserver) {
                this.f48871f = mergeWithObserver;
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.f48871f.a();
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f48871f.b(th);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.j(this, disposable);
            }
        }

        MergeWithObserver(Observer<? super T> observer) {
            this.f48865f = observer;
        }

        void a() {
            this.f48870k = true;
            if (this.f48869j) {
                HalfSerializer.a(this.f48865f, this, this.f48868i);
            }
        }

        void b(Throwable th) {
            DisposableHelper.a(this.f48866g);
            HalfSerializer.c(this.f48865f, th, this, this.f48868i);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f48866g);
            DisposableHelper.a(this.f48867h);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(this.f48866g.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48869j = true;
            if (this.f48870k) {
                HalfSerializer.a(this.f48865f, this, this.f48868i);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.a(this.f48867h);
            HalfSerializer.c(this.f48865f, th, this, this.f48868i);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            HalfSerializer.e(this.f48865f, t7, this, this.f48868i);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this.f48866g, disposable);
        }
    }

    public ObservableMergeWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.f48864g = completableSource;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.f48232f.subscribe(mergeWithObserver);
        this.f48864g.a(mergeWithObserver.f48867h);
    }
}
