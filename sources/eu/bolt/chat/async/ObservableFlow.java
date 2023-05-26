package eu.bolt.chat.async;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: ObservableFlow.kt */
/* loaded from: classes5.dex */
public final class ObservableFlow<T> implements Flow<T> {

    /* renamed from: f  reason: collision with root package name */
    private final Flow<T> f37853f;

    /* renamed from: g  reason: collision with root package name */
    private final FlowObserver<T> f37854g;

    /* JADX WARN: Multi-variable type inference failed */
    public ObservableFlow(Flow<? extends T> origin) {
        Intrinsics.f(origin, "origin");
        this.f37853f = origin;
        this.f37854g = new FlowObserver<>(origin);
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return this.f37853f.a(flowCollector, continuation);
    }
}
