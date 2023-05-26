package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public final class FlowableFromCallable<T> extends Flowable<T> implements Callable<T> {

    /* renamed from: g  reason: collision with root package name */
    final Callable<? extends T> f47991g;

    public FlowableFromCallable(Callable<? extends T> callable) {
        this.f47991g = callable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Flowable
    public void Z(Subscriber<? super T> subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.c(deferredScalarSubscription);
        try {
            deferredScalarSubscription.b(ObjectHelper.e(this.f47991g.call(), "The callable returned a null value"));
        } catch (Throwable th) {
            Exceptions.b(th);
            if (deferredScalarSubscription.d()) {
                RxJavaPlugins.s(th);
            } else {
                subscriber.onError(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) ObjectHelper.e(this.f47991g.call(), "The callable returned a null value");
    }
}
