package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes5.dex */
final class StackFrameContinuation<T> implements Continuation<T>, CoroutineStackFrame {

    /* renamed from: f  reason: collision with root package name */
    private final Continuation<T> f51762f;

    /* renamed from: g  reason: collision with root package name */
    private final CoroutineContext f51763g;

    /* JADX WARN: Multi-variable type inference failed */
    public StackFrameContinuation(Continuation<? super T> continuation, CoroutineContext coroutineContext) {
        this.f51762f = continuation;
        this.f51763g = coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f51762f;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f51763g;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        this.f51762f.resumeWith(obj);
    }
}
