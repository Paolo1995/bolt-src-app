package kotlinx.coroutines;

import kotlin.coroutines.Continuation;

/* compiled from: Deferred.kt */
/* loaded from: classes5.dex */
public interface Deferred<T> extends Job {
    Object N(Continuation<? super T> continuation);

    T q();
}
