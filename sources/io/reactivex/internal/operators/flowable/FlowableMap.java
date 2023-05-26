package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public final class FlowableMap<T, U> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: h  reason: collision with root package name */
    final Function<? super T, ? extends U> f47999h;

    /* loaded from: classes5.dex */
    static final class MapConditionalSubscriber<T, U> extends BasicFuseableConditionalSubscriber<T, U> {

        /* renamed from: k  reason: collision with root package name */
        final Function<? super T, ? extends U> f48000k;

        MapConditionalSubscriber(ConditionalSubscriber<? super U> conditionalSubscriber, Function<? super T, ? extends U> function) {
            super(conditionalSubscriber);
            this.f48000k = function;
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
            try {
                return this.f49759f.h(ObjectHelper.e(this.f48000k.apply(t7), "The mapper function returned a null value."));
            } catch (Throwable th) {
                g(th);
                return true;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            if (this.f49762i) {
                return;
            }
            if (this.f49763j != 0) {
                this.f49759f.onNext(null);
                return;
            }
            try {
                this.f49759f.onNext(ObjectHelper.e(this.f48000k.apply(t7), "The mapper function returned a null value."));
            } catch (Throwable th) {
                g(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public U poll() throws Exception {
            T poll = this.f49761h.poll();
            if (poll != null) {
                return (U) ObjectHelper.e(this.f48000k.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    static final class MapSubscriber<T, U> extends BasicFuseableSubscriber<T, U> {

        /* renamed from: k  reason: collision with root package name */
        final Function<? super T, ? extends U> f48001k;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MapSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends U> function) {
            super(subscriber);
            this.f48001k = function;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            return i(i8);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            if (this.f49767i) {
                return;
            }
            if (this.f49768j != 0) {
                this.f49764f.onNext(null);
                return;
            }
            try {
                this.f49764f.onNext(ObjectHelper.e(this.f48001k.apply(t7), "The mapper function returned a null value."));
            } catch (Throwable th) {
                g(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public U poll() throws Exception {
            T poll = this.f49766h.poll();
            if (poll != null) {
                return (U) ObjectHelper.e(this.f48001k.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    public FlowableMap(Flowable<T> flowable, Function<? super T, ? extends U> function) {
        super(flowable);
        this.f47999h = function;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super U> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f47792g.Y(new MapConditionalSubscriber((ConditionalSubscriber) subscriber, this.f47999h));
        } else {
            this.f47792g.Y(new MapSubscriber(subscriber, this.f47999h));
        }
    }
}
