package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: SharedFlow.kt */
/* loaded from: classes5.dex */
public interface MutableSharedFlow<T> extends SharedFlow<T>, FlowCollector<T> {
    @Override // kotlinx.coroutines.flow.FlowCollector
    Object b(T t7, Continuation<? super Unit> continuation);

    boolean d(T t7);

    StateFlow<Integer> e();
}
