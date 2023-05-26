package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: ThreadContextElement.kt */
/* loaded from: classes5.dex */
public interface CopyableThreadContextElement<S> extends ThreadContextElement<S> {
    CopyableThreadContextElement<S> Z();

    CoroutineContext w(CoroutineContext.Element element);
}
