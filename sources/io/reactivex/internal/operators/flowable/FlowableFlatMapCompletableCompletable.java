package io.reactivex.internal.operators.flowable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableFlatMapCompletableCompletable<T> extends Completable implements FuseToFlowable<T> {

    /* renamed from: f  reason: collision with root package name */
    final Flowable<T> f47942f;

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends CompletableSource> f47943g;

    /* renamed from: h  reason: collision with root package name */
    final int f47944h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f47945i;

    /* loaded from: classes5.dex */
    static final class FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f47946f;

        /* renamed from: h  reason: collision with root package name */
        final Function<? super T, ? extends CompletableSource> f47948h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f47949i;

        /* renamed from: k  reason: collision with root package name */
        final int f47951k;

        /* renamed from: l  reason: collision with root package name */
        Subscription f47952l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f47953m;

        /* renamed from: g  reason: collision with root package name */
        final AtomicThrowable f47947g = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        final CompositeDisposable f47950j = new CompositeDisposable();

        /* loaded from: classes5.dex */
        final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            InnerObserver() {
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.c(get());
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                FlatMapCompletableMainSubscriber.this.a(this);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                FlatMapCompletableMainSubscriber.this.b(this, th);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.j(this, disposable);
            }
        }

        FlatMapCompletableMainSubscriber(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z7, int i8) {
            this.f47946f = completableObserver;
            this.f47948h = function;
            this.f47949i = z7;
            this.f47951k = i8;
            lazySet(1);
        }

        void a(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver) {
            this.f47950j.c(innerObserver);
            onComplete();
        }

        void b(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver, Throwable th) {
            this.f47950j.c(innerObserver);
            onError(th);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f47952l, subscription)) {
                this.f47952l = subscription;
                this.f47946f.onSubscribe(this);
                int i8 = this.f47951k;
                if (i8 == Integer.MAX_VALUE) {
                    subscription.f(Long.MAX_VALUE);
                } else {
                    subscription.f(i8);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f47953m = true;
            this.f47952l.cancel();
            this.f47950j.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f47950j.isDisposed();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable b8 = this.f47947g.b();
                if (b8 != null) {
                    this.f47946f.onError(b8);
                } else {
                    this.f47946f.onComplete();
                }
            } else if (this.f47951k != Integer.MAX_VALUE) {
                this.f47952l.f(1L);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f47947g.a(th)) {
                if (this.f47949i) {
                    if (decrementAndGet() == 0) {
                        this.f47946f.onError(this.f47947g.b());
                        return;
                    } else if (this.f47951k != Integer.MAX_VALUE) {
                        this.f47952l.f(1L);
                        return;
                    } else {
                        return;
                    }
                }
                dispose();
                if (getAndSet(0) > 0) {
                    this.f47946f.onError(this.f47947g.b());
                    return;
                }
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.e(this.f47948h.apply(t7), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f47953m && this.f47950j.b(innerObserver)) {
                    completableSource.a(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f47952l.cancel();
                onError(th);
            }
        }
    }

    public FlowableFlatMapCompletableCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z7, int i8) {
        this.f47942f = flowable;
        this.f47943g = function;
        this.f47945i = z7;
        this.f47944h = i8;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        this.f47942f.Y(new FlatMapCompletableMainSubscriber(completableObserver, this.f47943g, this.f47945i, this.f47944h));
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<T> c() {
        return RxJavaPlugins.l(new FlowableFlatMapCompletable(this.f47942f, this.f47943g, this.f47945i, this.f47944h));
    }
}
