package io.ktor.util.pipeline;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DebugPipelineContext.kt */
@DebugMetadata(c = "io.ktor.util.pipeline.DebugPipelineContext", f = "DebugPipelineContext.kt", l = {80}, m = "proceedLoop")
/* loaded from: classes5.dex */
public final class DebugPipelineContext$proceedLoop$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47113f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f47114g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DebugPipelineContext<TSubject, TContext> f47115h;

    /* renamed from: i  reason: collision with root package name */
    int f47116i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugPipelineContext$proceedLoop$1(DebugPipelineContext<TSubject, TContext> debugPipelineContext, Continuation<? super DebugPipelineContext$proceedLoop$1> continuation) {
        super(continuation);
        this.f47115h = debugPipelineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object i8;
        this.f47114g = obj;
        this.f47116i |= Integer.MIN_VALUE;
        i8 = this.f47115h.i(this);
        return i8;
    }
}
