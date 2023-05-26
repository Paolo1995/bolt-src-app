package io.ktor.util.pipeline;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StackTraceRecover.kt */
/* loaded from: classes5.dex */
public final class StackTraceRecoverKt {
    public static final Throwable a(Throwable exception, Continuation<?> continuation) {
        Intrinsics.f(exception, "exception");
        Intrinsics.f(continuation, "continuation");
        try {
            return StackTraceRecoverJvmKt.a(exception, exception.getCause());
        } catch (Throwable unused) {
            return exception;
        }
    }
}
