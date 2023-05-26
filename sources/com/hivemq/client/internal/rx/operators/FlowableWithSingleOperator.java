package com.hivemq.client.internal.rx.operators;

import com.hivemq.client.rx.FlowableWithSingle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class FlowableWithSingleOperator<FU, SU, F, S> extends FlowableWithSingle<F, S> {

    /* renamed from: g  reason: collision with root package name */
    final FlowableWithSingle<FU, SU> f18666g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowableWithSingleOperator(FlowableWithSingle<FU, SU> flowableWithSingle) {
        this.f18666g = flowableWithSingle;
    }
}
