package io.reactivex.internal.operators.flowable;

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
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableFlatMapCompletable<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: h  reason: collision with root package name */
    final Function<? super T, ? extends CompletableSource> f47930h;

    /* renamed from: i  reason: collision with root package name */
    final int f47931i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f47932j;

    /* loaded from: classes5.dex */
    static final class FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {

        /* renamed from: f  reason: collision with root package name */
        final Subscriber<? super T> f47933f;

        /* renamed from: h  reason: collision with root package name */
        final Function<? super T, ? extends CompletableSource> f47935h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f47936i;

        /* renamed from: k  reason: collision with root package name */
        final int f47938k;

        /* renamed from: l  reason: collision with root package name */
        Subscription f47939l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f47940m;

        /* renamed from: g  reason: collision with root package name */
        final AtomicThrowable f47934g = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        final CompositeDisposable f47937j = new CompositeDisposable();

        /* loaded from: classes5.dex */
        final class InnerConsumer extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            InnerConsumer() {
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
                FlatMapCompletableMainSubscriber.this.b(this);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                FlatMapCompletableMainSubscriber.this.d(this, th);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.j(this, disposable);
            }
        }

        FlatMapCompletableMainSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends CompletableSource> function, boolean z7, int i8) {
            this.f47933f = subscriber;
            this.f47935h = function;
            this.f47936i = z7;
            this.f47938k = i8;
            lazySet(1);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            return i8 & 2;
        }

        void b(FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer) {
            this.f47937j.c(innerConsumer);
            onComplete();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f47939l, subscription)) {
                this.f47939l = subscription;
                this.f47933f.c(this);
                int i8 = this.f47938k;
                if (i8 == Integer.MAX_VALUE) {
                    subscription.f(Long.MAX_VALUE);
                } else {
                    subscription.f(i8);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f47940m = true;
            this.f47939l.cancel();
            this.f47937j.dispose();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
        }

        void d(FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer, Throwable th) {
            this.f47937j.c(innerConsumer);
            onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable b8 = this.f47934g.b();
                if (b8 != null) {
                    this.f47933f.onError(b8);
                } else {
                    this.f47933f.onComplete();
                }
            } else if (this.f47938k != Integer.MAX_VALUE) {
                this.f47939l.f(1L);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f47934g.a(th)) {
                if (this.f47936i) {
                    if (decrementAndGet() == 0) {
                        this.f47933f.onError(this.f47934g.b());
                        return;
                    } else if (this.f47938k != Integer.MAX_VALUE) {
                        this.f47939l.f(1L);
                        return;
                    } else {
                        return;
                    }
                }
                cancel();
                if (getAndSet(0) > 0) {
                    this.f47933f.onError(this.f47934g.b());
                    return;
                }
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.e(this.f47935h.apply(t7), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerConsumer innerConsumer = new InnerConsumer();
                if (!this.f47940m && this.f47937j.b(innerConsumer)) {
                    completableSource.a(innerConsumer);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f47939l.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            return null;
        }
    }

    public FlowableFlatMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z7, int i8) {
        super(flowable);
        this.f47930h = function;
        this.f47932j = z7;
        this.f47931i = i8;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        this.f47792g.Y(new FlatMapCompletableMainSubscriber(subscriber, this.f47930h, this.f47932j, this.f47931i));
    }
}
