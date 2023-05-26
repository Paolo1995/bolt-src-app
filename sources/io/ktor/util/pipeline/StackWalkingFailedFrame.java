package io.ktor.util.pipeline;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* compiled from: StackWalkingFailedFrame.kt */
/* loaded from: classes5.dex */
public final class StackWalkingFailedFrame implements CoroutineStackFrame, Continuation<?> {

    /* renamed from: f  reason: collision with root package name */
    public static final StackWalkingFailedFrame f47135f = new StackWalkingFailedFrame();

    private StackWalkingFailedFrame() {
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f50912f;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        StackWalkingFailed.f47134a.a();
    }
}
