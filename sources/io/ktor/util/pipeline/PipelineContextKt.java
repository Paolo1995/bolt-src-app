package io.ktor.util.pipeline;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PipelineContext.kt */
/* loaded from: classes5.dex */
public final class PipelineContextKt {
    public static final <TSubject, TContext> PipelineContext<TSubject, TContext> a(TContext context, List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> interceptors, TSubject subject, CoroutineContext coroutineContext, boolean z7) {
        Intrinsics.f(context, "context");
        Intrinsics.f(interceptors, "interceptors");
        Intrinsics.f(subject, "subject");
        Intrinsics.f(coroutineContext, "coroutineContext");
        if (z7) {
            return new DebugPipelineContext(context, interceptors, subject, coroutineContext);
        }
        return new SuspendFunctionGun(subject, context, interceptors);
    }
}
