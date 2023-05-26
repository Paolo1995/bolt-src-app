package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableRepeatWhen<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: h  reason: collision with root package name */
    final Function<? super Flowable<Object>, ? extends Publisher<?>> f48058h;

    /* loaded from: classes5.dex */
    static final class RepeatWhenSubscriber<T> extends WhenSourceSubscriber<T, Object> {
        RepeatWhenSubscriber(Subscriber<? super T> subscriber, FlowableProcessor<Object> flowableProcessor, Subscription subscription) {
            super(subscriber, flowableProcessor, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            j(0);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f48065p.cancel();
            this.f48063n.onError(th);
        }
    }

    /* loaded from: classes5.dex */
    static final class WhenReceiver<T, U> extends AtomicInteger implements FlowableSubscriber<Object>, Subscription {

        /* renamed from: f  reason: collision with root package name */
        final Publisher<T> f48059f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<Subscription> f48060g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        final AtomicLong f48061h = new AtomicLong();

        /* renamed from: i  reason: collision with root package name */
        WhenSourceSubscriber<T, U> f48062i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public WhenReceiver(Publisher<T> publisher) {
            this.f48059f = publisher;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            SubscriptionHelper.e(this.f48060g, this.f48061h, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.a(this.f48060g);
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            SubscriptionHelper.c(this.f48060g, this.f48061h, j8);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f48062i.cancel();
            this.f48062i.f48063n.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f48062i.cancel();
            this.f48062i.f48063n.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            if (getAndIncrement() == 0) {
                while (this.f48060g.get() != SubscriptionHelper.CANCELLED) {
                    this.f48059f.a(this.f48062i);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements FlowableSubscriber<T> {

        /* renamed from: n  reason: collision with root package name */
        protected final Subscriber<? super T> f48063n;

        /* renamed from: o  reason: collision with root package name */
        protected final FlowableProcessor<U> f48064o;

        /* renamed from: p  reason: collision with root package name */
        protected final Subscription f48065p;

        /* renamed from: q  reason: collision with root package name */
        private long f48066q;

        /* JADX INFO: Access modifiers changed from: package-private */
        public WhenSourceSubscriber(Subscriber<? super T> subscriber, FlowableProcessor<U> flowableProcessor, Subscription subscription) {
            super(false);
            this.f48063n = subscriber;
            this.f48064o = flowableProcessor;
            this.f48065p = subscription;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void c(Subscription subscription) {
            i(subscription);
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public final void cancel() {
            super.cancel();
            this.f48065p.cancel();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void j(U u7) {
            i(EmptySubscription.INSTANCE);
            long j8 = this.f48066q;
            if (j8 != 0) {
                this.f48066q = 0L;
                g(j8);
            }
            this.f48065p.f(1L);
            this.f48064o.onNext(u7);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t7) {
            this.f48066q++;
            this.f48063n.onNext(t7);
        }
    }

    public FlowableRepeatWhen(Flowable<T> flowable, Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        super(flowable);
        this.f48058h = function;
    }

    @Override // io.reactivex.Flowable
    public void Z(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        FlowableProcessor<T> h02 = UnicastProcessor.j0(8).h0();
        try {
            Publisher publisher = (Publisher) ObjectHelper.e(this.f48058h.apply(h02), "handler returned a null Publisher");
            WhenReceiver whenReceiver = new WhenReceiver(this.f47792g);
            RepeatWhenSubscriber repeatWhenSubscriber = new RepeatWhenSubscriber(serializedSubscriber, h02, whenReceiver);
            whenReceiver.f48062i = repeatWhenSubscriber;
            subscriber.c(repeatWhenSubscriber);
            publisher.a(whenReceiver);
            whenReceiver.onNext(0);
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.e(th, subscriber);
        }
    }
}
