package com.hivemq.client.internal.rx.operators;

import com.hivemq.client.internal.rx.WithSingleConditionalSubscriber;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.rx.FlowableWithSingle;
import com.hivemq.client.rx.FlowableWithSingleSubscriber;
import com.hivemq.client.rx.reactivestreams.WithSingleSubscriber;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public class FlowableWithSingleMapError<F, S> extends FlowableWithSingleOperator<F, S, F, S> {

    /* renamed from: h  reason: collision with root package name */
    private final Function<? super Throwable, ? extends Throwable> f18659h;

    /* loaded from: classes3.dex */
    private static class MapErrorSubscriber<F, T extends Subscriber<? super F>> implements FlowableSubscriber<F>, Subscription {

        /* renamed from: f  reason: collision with root package name */
        final T f18660f;

        /* renamed from: g  reason: collision with root package name */
        private final Function<? super Throwable, ? extends Throwable> f18661g;

        /* renamed from: h  reason: collision with root package name */
        private Subscription f18662h;

        /* loaded from: classes3.dex */
        private static class Conditional<F, T extends ConditionalSubscriber<? super F>> extends MapErrorSubscriber<F, T> implements ConditionalSubscriber<F> {
            Conditional(T t7, Function<? super Throwable, ? extends Throwable> function) {
                super(t7, function);
            }

            @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
            public boolean h(F f8) {
                return ((ConditionalSubscriber) this.f18660f).h(f8);
            }
        }

        MapErrorSubscriber(T t7, Function<? super Throwable, ? extends Throwable> function) {
            this.f18660f = t7;
            this.f18661g = function;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            this.f18662h = subscription;
            this.f18660f.c(this);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f18662h.cancel();
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            this.f18662h.f(j8);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f18660f.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Throwable compositeException;
            try {
                compositeException = (Throwable) Checks.j(this.f18661g.apply(th), "Mapped exception");
            } catch (Throwable th2) {
                Exceptions.b(th2);
                compositeException = new CompositeException(th, th2);
            }
            this.f18660f.onError(compositeException);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(F f8) {
            this.f18660f.onNext(f8);
        }
    }

    /* loaded from: classes3.dex */
    private static class WithSingleMapErrorSubscriber<F, S> extends MapErrorSubscriber<F, WithSingleSubscriber<? super F, ? super S>> implements FlowableWithSingleSubscriber<F, S> {

        /* loaded from: classes3.dex */
        private static class Conditional<F, S> extends MapErrorSubscriber.Conditional<F, WithSingleConditionalSubscriber<? super F, ? super S>> implements WithSingleConditionalSubscriber<F, S> {
            Conditional(WithSingleConditionalSubscriber<? super F, ? super S> withSingleConditionalSubscriber, Function<? super Throwable, ? extends Throwable> function) {
                super(withSingleConditionalSubscriber, function);
            }

            @Override // com.hivemq.client.rx.reactivestreams.WithSingleSubscriber
            public void e(S s7) {
                ((WithSingleConditionalSubscriber) this.f18660f).e(s7);
            }
        }

        WithSingleMapErrorSubscriber(WithSingleSubscriber<? super F, ? super S> withSingleSubscriber, Function<? super Throwable, ? extends Throwable> function) {
            super(withSingleSubscriber, function);
        }

        @Override // com.hivemq.client.rx.reactivestreams.WithSingleSubscriber
        public void e(S s7) {
            ((WithSingleSubscriber) this.f18660f).e(s7);
        }
    }

    public FlowableWithSingleMapError(FlowableWithSingle<F, S> flowableWithSingle, Function<? super Throwable, ? extends Throwable> function) {
        super(flowableWithSingle);
        this.f18659h = function;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super F> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f18666g.Y(new MapErrorSubscriber.Conditional((ConditionalSubscriber) subscriber, this.f18659h));
        } else {
            this.f18666g.Y(new MapErrorSubscriber(subscriber, this.f18659h));
        }
    }

    @Override // com.hivemq.client.rx.FlowableWithSingle
    protected void p0(WithSingleSubscriber<? super F, ? super S> withSingleSubscriber) {
        if (withSingleSubscriber instanceof WithSingleConditionalSubscriber) {
            this.f18666g.o0(new WithSingleMapErrorSubscriber.Conditional((WithSingleConditionalSubscriber) withSingleSubscriber, this.f18659h));
        } else {
            this.f18666g.o0(new WithSingleMapErrorSubscriber(withSingleSubscriber, this.f18659h));
        }
    }
}
