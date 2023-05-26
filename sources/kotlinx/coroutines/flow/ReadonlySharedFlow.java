package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Share.kt */
/* loaded from: classes5.dex */
public final class ReadonlySharedFlow<T> implements SharedFlow<T>, Flow {

    /* renamed from: f  reason: collision with root package name */
    private final Job f51613f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ SharedFlow<T> f51614g;

    /* JADX WARN: Multi-variable type inference failed */
    public ReadonlySharedFlow(SharedFlow<? extends T> sharedFlow, Job job) {
        this.f51613f = job;
        this.f51614g = sharedFlow;
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        return this.f51614g.a(flowCollector, continuation);
    }
}
