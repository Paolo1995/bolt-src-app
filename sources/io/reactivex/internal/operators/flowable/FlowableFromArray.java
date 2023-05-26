package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public final class FlowableFromArray<T> extends Flowable<T> {

    /* renamed from: g  reason: collision with root package name */
    final T[] f47985g;

    /* loaded from: classes5.dex */
    static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {

        /* renamed from: i  reason: collision with root package name */
        final ConditionalSubscriber<? super T> f47986i;

        ArrayConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, T[] tArr) {
            super(tArr);
            this.f47986i = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void b() {
            T[] tArr = this.f47988f;
            int length = tArr.length;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f47986i;
            for (int i8 = this.f47989g; i8 != length; i8++) {
                if (this.f47990h) {
                    return;
                }
                T t7 = tArr[i8];
                if (t7 == null) {
                    conditionalSubscriber.onError(new NullPointerException("The element at index " + i8 + " is null"));
                    return;
                }
                conditionalSubscriber.h(t7);
            }
            if (this.f47990h) {
                return;
            }
            conditionalSubscriber.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void c(long j8) {
            T[] tArr = this.f47988f;
            int length = tArr.length;
            int i8 = this.f47989g;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f47986i;
            do {
                long j9 = 0;
                while (true) {
                    if (j9 != j8 && i8 != length) {
                        if (this.f47990h) {
                            return;
                        }
                        T t7 = tArr[i8];
                        if (t7 == null) {
                            conditionalSubscriber.onError(new NullPointerException("The element at index " + i8 + " is null"));
                            return;
                        }
                        if (conditionalSubscriber.h(t7)) {
                            j9++;
                        }
                        i8++;
                    } else if (i8 == length) {
                        if (!this.f47990h) {
                            conditionalSubscriber.onComplete();
                            return;
                        }
                        return;
                    } else {
                        j8 = get();
                        if (j9 == j8) {
                            this.f47989g = i8;
                            j8 = addAndGet(-j9);
                        }
                    }
                }
            } while (j8 != 0);
        }
    }

    /* loaded from: classes5.dex */
    static final class ArraySubscription<T> extends BaseArraySubscription<T> {

        /* renamed from: i  reason: collision with root package name */
        final Subscriber<? super T> f47987i;

        ArraySubscription(Subscriber<? super T> subscriber, T[] tArr) {
            super(tArr);
            this.f47987i = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void b() {
            T[] tArr = this.f47988f;
            int length = tArr.length;
            Subscriber<? super T> subscriber = this.f47987i;
            for (int i8 = this.f47989g; i8 != length; i8++) {
                if (this.f47990h) {
                    return;
                }
                T t7 = tArr[i8];
                if (t7 == null) {
                    subscriber.onError(new NullPointerException("The element at index " + i8 + " is null"));
                    return;
                }
                subscriber.onNext(t7);
            }
            if (this.f47990h) {
                return;
            }
            subscriber.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void c(long j8) {
            T[] tArr = this.f47988f;
            int length = tArr.length;
            int i8 = this.f47989g;
            Subscriber<? super T> subscriber = this.f47987i;
            do {
                long j9 = 0;
                while (true) {
                    if (j9 != j8 && i8 != length) {
                        if (this.f47990h) {
                            return;
                        }
                        T t7 = tArr[i8];
                        if (t7 == null) {
                            subscriber.onError(new NullPointerException("The element at index " + i8 + " is null"));
                            return;
                        }
                        subscriber.onNext(t7);
                        j9++;
                        i8++;
                    } else if (i8 == length) {
                        if (!this.f47990h) {
                            subscriber.onComplete();
                            return;
                        }
                        return;
                    } else {
                        j8 = get();
                        if (j9 == j8) {
                            this.f47989g = i8;
                            j8 = addAndGet(-j9);
                        }
                    }
                }
            } while (j8 != 0);
        }
    }

    /* loaded from: classes5.dex */
    static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {

        /* renamed from: f  reason: collision with root package name */
        final T[] f47988f;

        /* renamed from: g  reason: collision with root package name */
        int f47989g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f47990h;

        BaseArraySubscription(T[] tArr) {
            this.f47988f = tArr;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int a(int i8) {
            return i8 & 1;
        }

        abstract void b();

        abstract void c(long j8);

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.f47990h = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.f47989g = this.f47988f.length;
        }

        @Override // org.reactivestreams.Subscription
        public final void f(long j8) {
            if (SubscriptionHelper.m(j8) && BackpressureHelper.a(this, j8) == 0) {
                if (j8 == Long.MAX_VALUE) {
                    b();
                } else {
                    c(j8);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            if (this.f47989g == this.f47988f.length) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() {
            int i8 = this.f47989g;
            T[] tArr = this.f47988f;
            if (i8 == tArr.length) {
                return null;
            }
            this.f47989g = i8 + 1;
            return (T) ObjectHelper.e(tArr[i8], "array element is null");
        }
    }

    public FlowableFromArray(T[] tArr) {
        this.f47985g = tArr;
    }

    @Override // io.reactivex.Flowable
    public void Z(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.c(new ArrayConditionalSubscription((ConditionalSubscriber) subscriber, this.f47985g));
        } else {
            subscriber.c(new ArraySubscription(subscriber, this.f47985g));
        }
    }
}
