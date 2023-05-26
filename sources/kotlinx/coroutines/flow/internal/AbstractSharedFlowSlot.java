package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: AbstractSharedFlow.kt */
/* loaded from: classes5.dex */
public abstract class AbstractSharedFlowSlot<F> {
    public abstract boolean a(F f8);

    public abstract Continuation<Unit>[] b(F f8);
}
