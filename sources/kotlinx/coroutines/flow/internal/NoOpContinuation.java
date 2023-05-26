package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* compiled from: SafeCollector.kt */
/* loaded from: classes5.dex */
final class NoOpContinuation implements Continuation<Object> {

    /* renamed from: f  reason: collision with root package name */
    public static final NoOpContinuation f51746f = new NoOpContinuation();

    /* renamed from: g  reason: collision with root package name */
    private static final CoroutineContext f51747g = EmptyCoroutineContext.f50912f;

    private NoOpContinuation() {
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return f51747g;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
    }
}
