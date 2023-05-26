package io.ktor.util.pipeline;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PipelineContext.kt */
/* loaded from: classes5.dex */
public abstract class PipelineContext<TSubject, TContext> implements CoroutineScope {

    /* renamed from: f  reason: collision with root package name */
    private final TContext f47129f;

    public PipelineContext(TContext context) {
        Intrinsics.f(context, "context");
        this.f47129f = context;
    }

    public abstract Object a(TSubject tsubject, Continuation<? super TSubject> continuation);

    public abstract void b();

    public final TContext c() {
        return this.f47129f;
    }

    public abstract TSubject e();

    public abstract Object f(Continuation<? super TSubject> continuation);

    public abstract Object g(TSubject tsubject, Continuation<? super TSubject> continuation);
}
