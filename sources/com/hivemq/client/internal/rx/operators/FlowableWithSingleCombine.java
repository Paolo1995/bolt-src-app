package com.hivemq.client.internal.rx.operators;

import com.hivemq.client.internal.rx.WithSingleConditionalSubscriber;
import com.hivemq.client.rx.FlowableWithSingle;
import com.hivemq.client.rx.FlowableWithSingleSubscriber;
import com.hivemq.client.rx.reactivestreams.WithSingleSubscriber;
import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
class FlowableWithSingleCombine<F, S> extends Flowable<Object> {

    /* renamed from: g  reason: collision with root package name */
    private final FlowableWithSingle<F, S> f18643g;

    /* loaded from: classes3.dex */
    private static class CombineSubscriber<F, S> implements FlowableWithSingleSubscriber<F, S>, Subscription {

        /* renamed from: k  reason: collision with root package name */
        private static final Object f18644k = new Object();

        /* renamed from: f  reason: collision with root package name */
        private final Subscriber<? super Object> f18645f;

        /* renamed from: g  reason: collision with root package name */
        private Subscription f18646g;

        /* renamed from: h  reason: collision with root package name */
        private final AtomicLong f18647h = new AtomicLong();

        /* renamed from: i  reason: collision with root package name */
        private Object f18648i;

        /* renamed from: j  reason: collision with root package name */
        private Object f18649j;

        CombineSubscriber(Subscriber<? super Object> subscriber) {
            this.f18645f = subscriber;
        }

        private void a(Object obj) {
            if (this.f18647h.get() == 0) {
                synchronized (this) {
                    if (this.f18647h.get() == 0) {
                        this.f18648i = obj;
                        return;
                    }
                }
            }
            BackpressureHelper.c(this.f18647h, 1L);
            this.f18645f.onNext(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            this.f18646g = subscription;
            this.f18645f.c(this);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f18646g.cancel();
        }

        @Override // com.hivemq.client.rx.reactivestreams.WithSingleSubscriber
        public void e(S s7) {
            a(new SingleElement(s7));
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            if (j8 > 0) {
                if (BackpressureHelper.a(this.f18647h, j8) == 0) {
                    synchronized (this) {
                        Object obj = this.f18648i;
                        if (obj != null) {
                            this.f18648i = null;
                            BackpressureHelper.c(this.f18647h, 1L);
                            this.f18645f.onNext(obj);
                            j8--;
                            Object obj2 = this.f18649j;
                            if (obj2 != null) {
                                this.f18649j = null;
                                if (obj2 instanceof Throwable) {
                                    this.f18645f.onError((Throwable) obj2);
                                } else {
                                    this.f18645f.onComplete();
                                }
                                return;
                            }
                        }
                        if (j8 > 0) {
                            this.f18646g.f(j8);
                        }
                        return;
                    }
                }
                this.f18646g.f(j8);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            synchronized (this) {
                if (this.f18648i != null) {
                    this.f18649j = f18644k;
                } else {
                    this.f18645f.onComplete();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            synchronized (this) {
                if (this.f18648i != null) {
                    this.f18649j = th;
                } else {
                    this.f18645f.onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(F f8) {
            a(f8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class SingleElement {

        /* renamed from: a  reason: collision with root package name */
        final Object f18650a;

        SingleElement(Object obj) {
            this.f18650a = obj;
        }
    }

    /* loaded from: classes3.dex */
    private static abstract class SplitSubscriber<F, S, T extends WithSingleSubscriber<? super F, ? super S>> implements ConditionalSubscriber<Object>, Subscription {

        /* renamed from: f  reason: collision with root package name */
        final T f18651f;

        /* renamed from: g  reason: collision with root package name */
        private Subscription f18652g;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static class Conditional<F, S> extends SplitSubscriber<F, S, WithSingleConditionalSubscriber<? super F, ? super S>> {
            Conditional(WithSingleConditionalSubscriber<? super F, ? super S> withSingleConditionalSubscriber) {
                super(withSingleConditionalSubscriber);
            }

            @Override // com.hivemq.client.internal.rx.operators.FlowableWithSingleCombine.SplitSubscriber
            boolean a(F f8) {
                return ((WithSingleConditionalSubscriber) this.f18651f).h(f8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static class Default<F, S> extends SplitSubscriber<F, S, WithSingleSubscriber<? super F, ? super S>> {
            Default(WithSingleSubscriber<? super F, ? super S> withSingleSubscriber) {
                super(withSingleSubscriber);
            }

            @Override // com.hivemq.client.internal.rx.operators.FlowableWithSingleCombine.SplitSubscriber
            boolean a(F f8) {
                this.f18651f.onNext(f8);
                return true;
            }
        }

        SplitSubscriber(T t7) {
            this.f18651f = t7;
        }

        abstract boolean a(F f8);

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            this.f18652g = subscription;
            this.f18651f.c(this);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f18652g.cancel();
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            this.f18652g.f(j8);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean h(Object obj) {
            if (obj instanceof SingleElement) {
                this.f18651f.e(((SingleElement) obj).f18650a);
                return false;
            }
            return a(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f18651f.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f18651f.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            if (!h(obj)) {
                this.f18652g.f(1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowableWithSingleCombine(FlowableWithSingle<F, S> flowableWithSingle) {
        this.f18643g = flowableWithSingle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <F, S> void h0(Flowable<Object> flowable, WithSingleSubscriber<? super F, ? super S> withSingleSubscriber) {
        if (withSingleSubscriber instanceof WithSingleConditionalSubscriber) {
            flowable.Y(new SplitSubscriber.Conditional((WithSingleConditionalSubscriber) withSingleSubscriber));
        } else {
            flowable.Y(new SplitSubscriber.Default(withSingleSubscriber));
        }
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super Object> subscriber) {
        this.f18643g.o0(new CombineSubscriber(subscriber));
    }
}
