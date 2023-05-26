package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: FlowExceptions.kt */
/* loaded from: classes5.dex */
public final class AbortFlowException extends CancellationException {

    /* renamed from: f  reason: collision with root package name */
    public final transient FlowCollector<?> f51661f;

    public AbortFlowException(FlowCollector<?> flowCollector) {
        super("Flow was aborted, no more elements needed");
        this.f51661f = flowCollector;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
