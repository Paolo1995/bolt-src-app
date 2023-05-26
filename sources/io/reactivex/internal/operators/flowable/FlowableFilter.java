package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public final class FlowableFilter<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: h  reason: collision with root package name */
    final Predicate<? super T> f47896h;

    /* loaded from: classes5.dex */
    static final class FilterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {

        /* renamed from: k  reason: collision with root package name */
        final Predicate<? super T> f47897k;

        FilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate) {
            super(conditionalSubscriber);
            this.f47897k = predicate;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            return i(i8);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean h(T t7) {
            if (this.f49762i) {
                return false;
            }
            if (this.f49763j != 0) {
                return this.f49759f.h(null);
            }
            try {
                if (!this.f47897k.test(t7) || !this.f49759f.h(t7)) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                g(th);
                return true;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            if (!h(t7)) {
                this.f49760g.f(1L);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            QueueSubscription<T> queueSubscription = this.f49761h;
            Predicate<? super T> predicate = this.f47897k;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.f49763j == 2) {
                    queueSubscription.f(1L);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class FilterSubscriber<T> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {

        /* renamed from: k  reason: collision with root package name */
        final Predicate<? super T> f47898k;

        FilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.f47898k = predicate;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            return i(i8);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean h(T t7) {
            if (this.f49767i) {
                return false;
            }
            if (this.f49768j != 0) {
                this.f49764f.onNext(null);
                return true;
            }
            try {
                boolean test = this.f47898k.test(t7);
                if (test) {
                    this.f49764f.onNext(t7);
                }
                return test;
            } catch (Throwable th) {
                g(th);
                return true;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            if (!h(t7)) {
                this.f49765g.f(1L);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            QueueSubscription<T> queueSubscription = this.f49766h;
            Predicate<? super T> predicate = this.f47898k;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.f49768j == 2) {
                    queueSubscription.f(1L);
                }
            }
        }
    }

    public FlowableFilter(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f47896h = predicate;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f47792g.Y(new FilterConditionalSubscriber((ConditionalSubscriber) subscriber, this.f47896h));
        } else {
            this.f47792g.Y(new FilterSubscriber(subscriber, this.f47896h));
        }
    }
}
