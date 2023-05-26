package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public final class FlowableDistinctUntilChanged<T, K> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: h  reason: collision with root package name */
    final Function<? super T, K> f47854h;

    /* renamed from: i  reason: collision with root package name */
    final BiPredicate<? super K, ? super K> f47855i;

    /* loaded from: classes5.dex */
    static final class DistinctUntilChangedConditionalSubscriber<T, K> extends BasicFuseableConditionalSubscriber<T, T> {

        /* renamed from: k  reason: collision with root package name */
        final Function<? super T, K> f47856k;

        /* renamed from: l  reason: collision with root package name */
        final BiPredicate<? super K, ? super K> f47857l;

        /* renamed from: m  reason: collision with root package name */
        K f47858m;

        /* renamed from: n  reason: collision with root package name */
        boolean f47859n;

        DistinctUntilChangedConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(conditionalSubscriber);
            this.f47856k = function;
            this.f47857l = biPredicate;
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
                return this.f49759f.h(t7);
            }
            try {
                K apply = this.f47856k.apply(t7);
                if (this.f47859n) {
                    boolean test = this.f47857l.test((K) this.f47858m, apply);
                    this.f47858m = apply;
                    if (test) {
                        return false;
                    }
                } else {
                    this.f47859n = true;
                    this.f47858m = apply;
                }
                this.f49759f.onNext(t7);
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
            while (true) {
                T poll = this.f49761h.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f47856k.apply(poll);
                if (!this.f47859n) {
                    this.f47859n = true;
                    this.f47858m = apply;
                    return poll;
                } else if (!this.f47857l.test((K) this.f47858m, apply)) {
                    this.f47858m = apply;
                    return poll;
                } else {
                    this.f47858m = apply;
                    if (this.f49763j != 1) {
                        this.f49760g.f(1L);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class DistinctUntilChangedSubscriber<T, K> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {

        /* renamed from: k  reason: collision with root package name */
        final Function<? super T, K> f47860k;

        /* renamed from: l  reason: collision with root package name */
        final BiPredicate<? super K, ? super K> f47861l;

        /* renamed from: m  reason: collision with root package name */
        K f47862m;

        /* renamed from: n  reason: collision with root package name */
        boolean f47863n;

        DistinctUntilChangedSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(subscriber);
            this.f47860k = function;
            this.f47861l = biPredicate;
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
                this.f49764f.onNext(t7);
                return true;
            }
            try {
                K apply = this.f47860k.apply(t7);
                if (this.f47863n) {
                    boolean test = this.f47861l.test((K) this.f47862m, apply);
                    this.f47862m = apply;
                    if (test) {
                        return false;
                    }
                } else {
                    this.f47863n = true;
                    this.f47862m = apply;
                }
                this.f49764f.onNext(t7);
                return true;
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
            while (true) {
                T poll = this.f49766h.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f47860k.apply(poll);
                if (!this.f47863n) {
                    this.f47863n = true;
                    this.f47862m = apply;
                    return poll;
                } else if (!this.f47861l.test((K) this.f47862m, apply)) {
                    this.f47862m = apply;
                    return poll;
                } else {
                    this.f47862m = apply;
                    if (this.f49768j != 1) {
                        this.f49765g.f(1L);
                    }
                }
            }
        }
    }

    public FlowableDistinctUntilChanged(Flowable<T> flowable, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(flowable);
        this.f47854h = function;
        this.f47855i = biPredicate;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f47792g.Y(new DistinctUntilChangedConditionalSubscriber((ConditionalSubscriber) subscriber, this.f47854h, this.f47855i));
        } else {
            this.f47792g.Y(new DistinctUntilChangedSubscriber(subscriber, this.f47854h, this.f47855i));
        }
    }
}
