package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.internal.observers.SubscriberCompletableObserver;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public final class CompletableToFlowable<T> extends Flowable<T> {

    /* renamed from: g  reason: collision with root package name */
    final CompletableSource f47791g;

    public CompletableToFlowable(CompletableSource completableSource) {
        this.f47791g = completableSource;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        this.f47791g.a(new SubscriberCompletableObserver(subscriber));
    }
}
