package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class AbstractFlowableWithUpstream<T, R> extends Flowable<R> {

    /* renamed from: g  reason: collision with root package name */
    protected final Flowable<T> f47792g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractFlowableWithUpstream(Flowable<T> flowable) {
        this.f47792g = (Flowable) ObjectHelper.e(flowable, "source is null");
    }
}
