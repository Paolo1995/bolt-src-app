package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;

/* compiled from: SharedFlow.kt */
/* loaded from: classes5.dex */
public interface SharedFlow<T> extends Flow<T> {
    @Override // kotlinx.coroutines.flow.Flow
    Object a(FlowCollector<? super T> flowCollector, Continuation<?> continuation);
}
