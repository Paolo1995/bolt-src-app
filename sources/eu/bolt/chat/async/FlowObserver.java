package eu.bolt.chat.async;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: FlowObserver.kt */
/* loaded from: classes5.dex */
public final class FlowObserver<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Flow<T> f37852a;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowObserver(Flow<? extends T> flow) {
        Intrinsics.f(flow, "flow");
        this.f37852a = flow;
    }
}
