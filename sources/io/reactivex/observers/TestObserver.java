package io.reactivex.observers;

import androidx.camera.view.e;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements Observer<T>, MaybeObserver<T>, SingleObserver<T>, CompletableObserver {

    /* renamed from: n  reason: collision with root package name */
    private final Observer<? super T> f49842n;

    /* renamed from: o  reason: collision with root package name */
    private final AtomicReference<Disposable> f49843o;

    /* renamed from: p  reason: collision with root package name */
    private QueueDisposable<T> f49844p;

    /* loaded from: classes5.dex */
    enum EmptyObserver implements Observer<Object> {
        INSTANCE;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    public TestObserver() {
        this(EmptyObserver.INSTANCE);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.a(this.f49843o);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.c(this.f49843o.get());
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (!this.f49828k) {
            this.f49828k = true;
            if (this.f49843o.get() == null) {
                this.f49825h.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f49827j = Thread.currentThread();
            this.f49826i++;
            this.f49842n.onComplete();
        } finally {
            this.f49823f.countDown();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (!this.f49828k) {
            this.f49828k = true;
            if (this.f49843o.get() == null) {
                this.f49825h.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f49827j = Thread.currentThread();
            if (th == null) {
                this.f49825h.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f49825h.add(th);
            }
            this.f49842n.onError(th);
        } finally {
            this.f49823f.countDown();
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t7) {
        if (!this.f49828k) {
            this.f49828k = true;
            if (this.f49843o.get() == null) {
                this.f49825h.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f49827j = Thread.currentThread();
        if (this.f49830m != 2) {
            this.f49824g.add(t7);
            if (t7 == null) {
                this.f49825h.add(new NullPointerException("onNext received a null value"));
            }
            this.f49842n.onNext(t7);
            return;
        }
        while (true) {
            try {
                T poll = this.f49844p.poll();
                if (poll != null) {
                    this.f49824g.add(poll);
                } else {
                    return;
                }
            } catch (Throwable th) {
                this.f49825h.add(th);
                this.f49844p.dispose();
                return;
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        this.f49827j = Thread.currentThread();
        if (disposable == null) {
            this.f49825h.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!e.a(this.f49843o, null, disposable)) {
            disposable.dispose();
            if (this.f49843o.get() != DisposableHelper.DISPOSED) {
                this.f49825h.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + disposable));
            }
        } else {
            int i8 = this.f49829l;
            if (i8 != 0 && (disposable instanceof QueueDisposable)) {
                QueueDisposable<T> queueDisposable = (QueueDisposable) disposable;
                this.f49844p = queueDisposable;
                int a8 = queueDisposable.a(i8);
                this.f49830m = a8;
                if (a8 == 1) {
                    this.f49828k = true;
                    this.f49827j = Thread.currentThread();
                    while (true) {
                        try {
                            T poll = this.f49844p.poll();
                            if (poll != null) {
                                this.f49824g.add(poll);
                            } else {
                                this.f49826i++;
                                this.f49843o.lazySet(DisposableHelper.DISPOSED);
                                return;
                            }
                        } catch (Throwable th) {
                            this.f49825h.add(th);
                            return;
                        }
                    }
                }
            }
            this.f49842n.onSubscribe(disposable);
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T t7) {
        onNext(t7);
        onComplete();
    }

    public TestObserver(Observer<? super T> observer) {
        this.f49843o = new AtomicReference<>();
        this.f49842n = observer;
    }
}
