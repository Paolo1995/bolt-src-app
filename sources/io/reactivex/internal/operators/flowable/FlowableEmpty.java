package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public final class FlowableEmpty extends Flowable<Object> implements ScalarCallable<Object> {

    /* renamed from: g  reason: collision with root package name */
    public static final Flowable<Object> f47894g = new FlowableEmpty();

    private FlowableEmpty() {
    }

    @Override // io.reactivex.Flowable
    public void Z(Subscriber<? super Object> subscriber) {
        EmptySubscription.c(subscriber);
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public Object call() {
        return null;
    }
}
