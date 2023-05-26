package com.hivemq.client.internal.rx.operators;

import com.hivemq.client.internal.rx.WithSingleConditionalSubscriber;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.rx.FlowableWithSingle;
import com.hivemq.client.rx.FlowableWithSingleSubscriber;
import com.hivemq.client.rx.reactivestreams.WithSingleSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public class FlowableWithSingleMap<F, S, FM, SM> extends FlowableWithSingleOperator<F, S, FM, SM> {

    /* renamed from: h  reason: collision with root package name */
    private final Function<? super F, ? extends FM> f18653h;

    /* renamed from: i  reason: collision with root package name */
    private final Function<? super S, ? extends SM> f18654i;

    /* loaded from: classes3.dex */
    private static class MapSubscriber<F, S, FM, SM, T extends Subscriber<? super FM>> implements FlowableWithSingleSubscriber<F, S>, Subscription {

        /* renamed from: f  reason: collision with root package name */
        final T f18655f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super F, ? extends FM> f18656g;

        /* renamed from: h  reason: collision with root package name */
        private final Function<? super S, ? extends SM> f18657h;

        /* renamed from: i  reason: collision with root package name */
        private Subscription f18658i;

        /* loaded from: classes3.dex */
        private static class Conditional<F, S, FM, SM, T extends ConditionalSubscriber<? super FM>> extends MapSubscriber<F, S, FM, SM, T> implements WithSingleConditionalSubscriber<F, S> {
            Conditional(T t7, Function<? super F, ? extends FM> function, Function<? super S, ? extends SM> function2) {
                super(t7, function, function2);
            }

            @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
            public boolean h(F f8) {
                Function<? super F, ? extends FM> function = this.f18656g;
                if (function == null) {
                    return ((ConditionalSubscriber) this.f18655f).h(f8);
                }
                try {
                    return ((ConditionalSubscriber) this.f18655f).h(Checks.j(function.apply(f8), "Mapped value"));
                } catch (Throwable th) {
                    a(th);
                    return false;
                }
            }
        }

        MapSubscriber(T t7, Function<? super F, ? extends FM> function, Function<? super S, ? extends SM> function2) {
            this.f18655f = t7;
            this.f18656g = function;
            this.f18657h = function2;
        }

        void a(Throwable th) {
            Exceptions.b(th);
            this.f18658i.cancel();
            onError(th);
        }

        void b(SM sm) {
        }

        @Override // org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            this.f18658i = subscription;
            this.f18655f.c(this);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f18658i.cancel();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.hivemq.client.rx.reactivestreams.WithSingleSubscriber
        public void e(S s7) {
            try {
                b(Checks.j(this.f18657h.apply(s7), "Mapped single value"));
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            this.f18658i.f(j8);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f18655f.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f18655f.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(F f8) {
            Function<? super F, ? extends FM> function = this.f18656g;
            if (function == null) {
                this.f18655f.onNext(f8);
                return;
            }
            try {
                this.f18655f.onNext(Checks.j(function.apply(f8), "Mapped value"));
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class WithSingleMapSubscriber<F, S, FM, SM> extends MapSubscriber<F, S, FM, SM, WithSingleSubscriber<? super FM, ? super SM>> {

        /* loaded from: classes3.dex */
        private static class Conditional<F, S, FM, SM> extends MapSubscriber.Conditional<F, S, FM, SM, WithSingleConditionalSubscriber<? super FM, ? super SM>> {
            Conditional(WithSingleConditionalSubscriber<? super FM, ? super SM> withSingleConditionalSubscriber, Function<? super F, ? extends FM> function, Function<? super S, ? extends SM> function2) {
                super(withSingleConditionalSubscriber, function, function2);
            }

            @Override // com.hivemq.client.internal.rx.operators.FlowableWithSingleMap.MapSubscriber
            void b(SM sm) {
                ((WithSingleConditionalSubscriber) this.f18655f).e(sm);
            }
        }

        WithSingleMapSubscriber(WithSingleSubscriber<? super FM, ? super SM> withSingleSubscriber, Function<? super F, ? extends FM> function, Function<? super S, ? extends SM> function2) {
            super(withSingleSubscriber, function, function2);
        }

        @Override // com.hivemq.client.internal.rx.operators.FlowableWithSingleMap.MapSubscriber
        void b(SM sm) {
            ((WithSingleSubscriber) this.f18655f).e(sm);
        }
    }

    private FlowableWithSingleMap(FlowableWithSingle<F, S> flowableWithSingle, Function<? super F, ? extends FM> function, Function<? super S, ? extends SM> function2) {
        super(flowableWithSingle);
        this.f18653h = function;
        this.f18654i = function2;
    }

    public static <F, S, FM, SM> FlowableWithSingleMap<F, S, FM, SM> q0(FlowableWithSingle<F, S> flowableWithSingle, Function<? super F, ? extends FM> function, Function<? super S, ? extends SM> function2) {
        return new FlowableWithSingleMap<>(flowableWithSingle, function, function2);
    }

    public static <F, S, SM> FlowableWithSingleMap<F, S, F, SM> r0(FlowableWithSingle<F, S> flowableWithSingle, Function<? super S, ? extends SM> function) {
        return new FlowableWithSingleMap<>(flowableWithSingle, null, function);
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super FM> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f18666g.o0(new MapSubscriber.Conditional((ConditionalSubscriber) subscriber, this.f18653h, this.f18654i));
        } else {
            this.f18666g.o0(new MapSubscriber(subscriber, this.f18653h, this.f18654i));
        }
    }

    @Override // com.hivemq.client.rx.FlowableWithSingle
    protected void p0(WithSingleSubscriber<? super FM, ? super SM> withSingleSubscriber) {
        if (withSingleSubscriber instanceof WithSingleConditionalSubscriber) {
            this.f18666g.o0(new WithSingleMapSubscriber.Conditional((WithSingleConditionalSubscriber) withSingleSubscriber, this.f18653h, this.f18654i));
        } else {
            this.f18666g.o0(new WithSingleMapSubscriber(withSingleSubscriber, this.f18653h, this.f18654i));
        }
    }
}
