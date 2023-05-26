package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public enum FlowableInternalHelper$RequestMax implements Consumer<Subscription> {
    INSTANCE;

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Subscription subscription) throws Exception {
        subscription.f(Long.MAX_VALUE);
    }
}
