package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableElementAt<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: h  reason: collision with root package name */
    final long f47876h;

    /* renamed from: i  reason: collision with root package name */
    final T f47877i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f47878j;

    /* loaded from: classes5.dex */
    static final class ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {

        /* renamed from: h  reason: collision with root package name */
        final long f47879h;

        /* renamed from: i  reason: collision with root package name */
        final T f47880i;

        /* renamed from: j  reason: collision with root package name */
        final boolean f47881j;

        /* renamed from: k  reason: collision with root package name */
        Subscription f47882k;

        /* renamed from: l  reason: collision with root package name */
        long f47883l;

        /* renamed from: m  reason: collision with root package name */
        boolean f47884m;

        ElementAtSubscriber(Subscriber<? super T> subscriber, long j8, T t7, boolean z7) {
            super(subscriber);
            this.f47879h = j8;
            this.f47880i = t7;
            this.f47881j = z7;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f47882k, subscription)) {
                this.f47882k = subscription;
                this.f49779f.c(this);
                subscription.f(Long.MAX_VALUE);
            }
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f47882k.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.f47884m) {
                this.f47884m = true;
                T t7 = this.f47880i;
                if (t7 == null) {
                    if (this.f47881j) {
                        this.f49779f.onError(new NoSuchElementException());
                        return;
                    } else {
                        this.f49779f.onComplete();
                        return;
                    }
                }
                b(t7);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f47884m) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f47884m = true;
            this.f49779f.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            if (this.f47884m) {
                return;
            }
            long j8 = this.f47883l;
            if (j8 == this.f47879h) {
                this.f47884m = true;
                this.f47882k.cancel();
                b(t7);
                return;
            }
            this.f47883l = j8 + 1;
        }
    }

    public FlowableElementAt(Flowable<T> flowable, long j8, T t7, boolean z7) {
        super(flowable);
        this.f47876h = j8;
        this.f47877i = t7;
        this.f47878j = z7;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        this.f47792g.Y(new ElementAtSubscriber(subscriber, this.f47876h, this.f47877i, this.f47878j));
    }
}
