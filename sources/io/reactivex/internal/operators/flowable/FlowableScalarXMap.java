package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public final class FlowableScalarXMap {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ScalarXMapFlowable<T, R> extends Flowable<R> {

        /* renamed from: g  reason: collision with root package name */
        final T f48068g;

        /* renamed from: h  reason: collision with root package name */
        final Function<? super T, ? extends Publisher<? extends R>> f48069h;

        ScalarXMapFlowable(T t7, Function<? super T, ? extends Publisher<? extends R>> function) {
            this.f48068g = t7;
            this.f48069h = function;
        }

        @Override // io.reactivex.Flowable
        public void Z(Subscriber<? super R> subscriber) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.e(this.f48069h.apply((T) this.f48068g), "The mapper returned a null Publisher");
                if (publisher instanceof Callable) {
                    try {
                        Object call = ((Callable) publisher).call();
                        if (call == null) {
                            EmptySubscription.c(subscriber);
                            return;
                        } else {
                            subscriber.c(new ScalarSubscription(subscriber, call));
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        EmptySubscription.e(th, subscriber);
                        return;
                    }
                }
                publisher.a(subscriber);
            } catch (Throwable th2) {
                EmptySubscription.e(th2, subscriber);
            }
        }
    }

    private FlowableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Flowable<U> a(T t7, Function<? super T, ? extends Publisher<? extends U>> function) {
        return RxJavaPlugins.l(new ScalarXMapFlowable(t7, function));
    }

    public static <T, R> boolean b(Publisher<T> publisher, Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
        if (publisher instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) publisher).call();
                if (obj == 0) {
                    EmptySubscription.c(subscriber);
                    return true;
                }
                try {
                    Publisher publisher2 = (Publisher) ObjectHelper.e(function.apply(obj), "The mapper returned a null Publisher");
                    if (publisher2 instanceof Callable) {
                        try {
                            Object call = ((Callable) publisher2).call();
                            if (call == null) {
                                EmptySubscription.c(subscriber);
                                return true;
                            }
                            subscriber.c(new ScalarSubscription(subscriber, call));
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            EmptySubscription.e(th, subscriber);
                            return true;
                        }
                    } else {
                        publisher2.a(subscriber);
                    }
                    return true;
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    EmptySubscription.e(th2, subscriber);
                    return true;
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                EmptySubscription.e(th3, subscriber);
                return true;
            }
        }
        return false;
    }
}
