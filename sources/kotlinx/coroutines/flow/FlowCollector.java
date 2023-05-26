package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: FlowCollector.kt */
/* loaded from: classes5.dex */
public interface FlowCollector<T> {
    Object b(T t7, Continuation<? super Unit> continuation);
}
