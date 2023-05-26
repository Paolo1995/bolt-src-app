package io.reactivex.processors;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public abstract class FlowableProcessor<T> extends Flowable<T> implements Subscriber, FlowableSubscriber<T> {
    public final FlowableProcessor<T> h0() {
        if (this instanceof SerializedProcessor) {
            return this;
        }
        return new SerializedProcessor(this);
    }
}
