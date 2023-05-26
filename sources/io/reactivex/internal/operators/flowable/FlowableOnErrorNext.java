package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableOnErrorNext<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: h  reason: collision with root package name */
    final Function<? super Throwable, ? extends Publisher<? extends T>> f48050h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f48051i;

    /* loaded from: classes5.dex */
    static final class OnErrorNextSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {

        /* renamed from: n  reason: collision with root package name */
        final Subscriber<? super T> f48052n;

        /* renamed from: o  reason: collision with root package name */
        final Function<? super Throwable, ? extends Publisher<? extends T>> f48053o;

        /* renamed from: p  reason: collision with root package name */
        final boolean f48054p;

        /* renamed from: q  reason: collision with root package name */
        boolean f48055q;

        /* renamed from: r  reason: collision with root package name */
        boolean f48056r;

        /* renamed from: s  reason: collision with root package name */
        long f48057s;

        OnErrorNextSubscriber(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends Publisher<? extends T>> function, boolean z7) {
            super(false);
            this.f48052n = subscriber;
            this.f48053o = function;
            this.f48054p = z7;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            i(subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f48056r) {
                return;
            }
            this.f48056r = true;
            this.f48055q = true;
            this.f48052n.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f48055q) {
                if (this.f48056r) {
                    RxJavaPlugins.s(th);
                    return;
                } else {
                    this.f48052n.onError(th);
                    return;
                }
            }
            this.f48055q = true;
            if (this.f48054p && !(th instanceof Exception)) {
                this.f48052n.onError(th);
                return;
            }
            try {
                Publisher publisher = (Publisher) ObjectHelper.e(this.f48053o.apply(th), "The nextSupplier returned a null Publisher");
                long j8 = this.f48057s;
                if (j8 != 0) {
                    g(j8);
                }
                publisher.a(this);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f48052n.onError(new CompositeException(th, th2));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            if (this.f48056r) {
                return;
            }
            if (!this.f48055q) {
                this.f48057s++;
            }
            this.f48052n.onNext(t7);
        }
    }

    public FlowableOnErrorNext(Flowable<T> flowable, Function<? super Throwable, ? extends Publisher<? extends T>> function, boolean z7) {
        super(flowable);
        this.f48050h = function;
        this.f48051i = z7;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        OnErrorNextSubscriber onErrorNextSubscriber = new OnErrorNextSubscriber(subscriber, this.f48050h, this.f48051i);
        subscriber.c(onErrorNextSubscriber);
        this.f47792g.Y(onErrorNextSubscriber);
    }
}
