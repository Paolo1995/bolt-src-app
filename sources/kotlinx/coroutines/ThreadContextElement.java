package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: ThreadContextElement.kt */
/* loaded from: classes5.dex */
public interface ThreadContextElement<S> extends CoroutineContext.Element {
    S C0(CoroutineContext coroutineContext);

    void c0(CoroutineContext coroutineContext, S s7);
}
