package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Share.kt */
/* loaded from: classes5.dex */
public final class ReadonlyStateFlow<T> implements StateFlow<T>, Flow {

    /* renamed from: f  reason: collision with root package name */
    private final Job f51615f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ StateFlow<T> f51616g;

    /* JADX WARN: Multi-variable type inference failed */
    public ReadonlyStateFlow(StateFlow<? extends T> stateFlow, Job job) {
        this.f51615f = job;
        this.f51616g = stateFlow;
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        return this.f51616g.a(flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        return this.f51616g.getValue();
    }
}
