package com.hivemq.client.rx;

import com.hivemq.client.rx.reactivestreams.WithSingleSubscriber;
import io.reactivex.FlowableSubscriber;

/* loaded from: classes3.dex */
public interface FlowableWithSingleSubscriber<F, S> extends WithSingleSubscriber<F, S>, FlowableSubscriber<F> {
}
