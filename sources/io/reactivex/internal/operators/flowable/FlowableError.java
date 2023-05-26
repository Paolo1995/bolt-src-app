package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public final class FlowableError<T> extends Flowable<T> {

    /* renamed from: g  reason: collision with root package name */
    final Callable<? extends Throwable> f47895g;

    public FlowableError(Callable<? extends Throwable> callable) {
        this.f47895g = callable;
    }

    @Override // io.reactivex.Flowable
    public void Z(Subscriber<? super T> subscriber) {
        try {
            th = (Throwable) ObjectHelper.e(this.f47895g.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.b(th);
        }
        EmptySubscription.e(th, subscriber);
    }
}
