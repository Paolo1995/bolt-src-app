package com.hivemq.client.internal.rx.operators;

import com.hivemq.client.rx.FlowableWithSingle;
import com.hivemq.client.rx.reactivestreams.WithSingleSubscriber;
import io.reactivex.Scheduler;
import org.reactivestreams.Subscriber;

/* loaded from: classes3.dex */
public class FlowableWithSingleObserveOn<F, S> extends FlowableWithSingleOperator<F, S, F, S> {

    /* renamed from: h  reason: collision with root package name */
    private final Scheduler f18663h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f18664i;

    /* renamed from: j  reason: collision with root package name */
    private final int f18665j;

    public FlowableWithSingleObserveOn(FlowableWithSingle<F, S> flowableWithSingle, Scheduler scheduler, boolean z7, int i8) {
        super(flowableWithSingle);
        this.f18663h = scheduler;
        this.f18664i = z7;
        this.f18665j = i8;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super F> subscriber) {
        this.f18666g.N(this.f18663h, this.f18664i, this.f18665j).a(subscriber);
    }

    @Override // com.hivemq.client.rx.FlowableWithSingle
    protected void p0(WithSingleSubscriber<? super F, ? super S> withSingleSubscriber) {
        FlowableWithSingleCombine.h0(new FlowableWithSingleCombine(this.f18666g).N(this.f18663h, this.f18664i, this.f18665j), withSingleSubscriber);
    }
}
