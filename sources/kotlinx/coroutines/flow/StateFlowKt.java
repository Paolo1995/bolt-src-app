package kotlinx.coroutines.flow;

import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: StateFlow.kt */
/* loaded from: classes5.dex */
public final class StateFlowKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Symbol f51650a = new Symbol("NONE");

    /* renamed from: b  reason: collision with root package name */
    private static final Symbol f51651b = new Symbol("PENDING");

    public static final <T> MutableStateFlow<T> a(T t7) {
        if (t7 == null) {
            t7 = (T) NullSurrogateKt.f51749a;
        }
        return new StateFlowImpl(t7);
    }
}
