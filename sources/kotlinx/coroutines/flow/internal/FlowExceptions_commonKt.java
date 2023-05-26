package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: FlowExceptions.common.kt */
/* loaded from: classes5.dex */
public final class FlowExceptions_commonKt {
    public static final void a(AbortFlowException abortFlowException, FlowCollector<?> flowCollector) {
        if (abortFlowException.f51661f == flowCollector) {
            return;
        }
        throw abortFlowException;
    }
}
