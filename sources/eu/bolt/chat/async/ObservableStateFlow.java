package eu.bolt.chat.async;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: ObservableStateFlow.kt */
/* loaded from: classes5.dex */
public final class ObservableStateFlow<T> implements StateFlow<T> {

    /* renamed from: f  reason: collision with root package name */
    private final StateFlow<T> f37855f;

    /* renamed from: g  reason: collision with root package name */
    private final FlowObserver<T> f37856g;

    /* JADX WARN: Multi-variable type inference failed */
    public ObservableStateFlow(StateFlow<? extends T> origin) {
        Intrinsics.f(origin, "origin");
        this.f37855f = origin;
        this.f37856g = new FlowObserver<>(origin);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        return this.f37855f.a(flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        return this.f37855f.getValue();
    }
}
