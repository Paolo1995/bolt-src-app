package com.hivemq.client.rx;

import com.hivemq.client.internal.rx.operators.FlowableWithSingleMap;
import com.hivemq.client.internal.rx.operators.FlowableWithSingleMapError;
import com.hivemq.client.internal.rx.operators.FlowableWithSingleObserveOn;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.rx.FlowableWithSingle;
import com.hivemq.client.rx.reactivestreams.WithSingleSubscriber;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/* loaded from: classes3.dex */
public abstract class FlowableWithSingle<F, S> extends Flowable<F> {
    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.Object j0(io.reactivex.functions.Consumer r0, java.lang.Object r1) throws java.lang.Exception {
        /*
            r0.accept(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hivemq.client.rx.FlowableWithSingle.j0(io.reactivex.functions.Consumer, java.lang.Object):java.lang.Object");
    }

    public final FlowableWithSingle<F, S> i0(final Consumer<? super S> consumer) {
        Checks.j(consumer, "Single consumer");
        return FlowableWithSingleMap.r0(this, new Function() { // from class: k1.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FlowableWithSingle.j0(Consumer.this, obj);
            }
        });
    }

    public final <FM, SM> FlowableWithSingle<FM, SM> k0(Function<? super F, ? extends FM> function, Function<? super S, ? extends SM> function2) {
        Checks.j(function, "Flowable mapper");
        Checks.j(function2, "Single mapper");
        return FlowableWithSingleMap.q0(this, function, function2);
    }

    public final FlowableWithSingle<F, S> l0(Function<? super Throwable, ? extends Throwable> function) {
        Checks.j(function, "Mapper");
        return new FlowableWithSingleMapError(this, function);
    }

    public final FlowableWithSingle<F, S> m0(Scheduler scheduler, boolean z7) {
        return n0(scheduler, z7, Flowable.b());
    }

    public final FlowableWithSingle<F, S> n0(Scheduler scheduler, boolean z7, int i8) {
        Checks.j(scheduler, "Scheduler");
        return new FlowableWithSingleObserveOn(this, scheduler, z7, i8);
    }

    public final void o0(FlowableWithSingleSubscriber<? super F, ? super S> flowableWithSingleSubscriber) {
        Checks.j(flowableWithSingleSubscriber, "Subscriber");
        p0(flowableWithSingleSubscriber);
    }

    protected abstract void p0(WithSingleSubscriber<? super F, ? super S> withSingleSubscriber);
}
