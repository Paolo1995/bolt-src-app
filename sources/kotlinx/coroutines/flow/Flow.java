package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: Flow.kt */
/* loaded from: classes5.dex */
public interface Flow<T> {
    Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation);
}
