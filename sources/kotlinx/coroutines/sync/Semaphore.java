package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: Semaphore.kt */
/* loaded from: classes5.dex */
public interface Semaphore {
    Object a(Continuation<? super Unit> continuation);

    void release();
}
