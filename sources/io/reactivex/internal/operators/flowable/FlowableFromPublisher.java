package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public final class FlowableFromPublisher<T> extends Flowable<T> {

    /* renamed from: g  reason: collision with root package name */
    final Publisher<? extends T> f47995g;

    public FlowableFromPublisher(Publisher<? extends T> publisher) {
        this.f47995g = publisher;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        this.f47995g.a(subscriber);
    }
}
