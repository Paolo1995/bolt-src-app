package io.ktor.util.pipeline;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugPipelineContext.kt */
/* loaded from: classes5.dex */
public final class DebugPipelineContext<TSubject, TContext> extends PipelineContext<TSubject, TContext> {

    /* renamed from: g  reason: collision with root package name */
    private final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> f47109g;

    /* renamed from: h  reason: collision with root package name */
    private final CoroutineContext f47110h;

    /* renamed from: i  reason: collision with root package name */
    private TSubject f47111i;

    /* renamed from: j  reason: collision with root package name */
    private int f47112j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DebugPipelineContext(TContext context, List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> interceptors, TSubject subject, CoroutineContext coroutineContext) {
        super(context);
        Intrinsics.f(context, "context");
        Intrinsics.f(interceptors, "interceptors");
        Intrinsics.f(subject, "subject");
        Intrinsics.f(coroutineContext, "coroutineContext");
        this.f47109g = interceptors;
        this.f47110h = coroutineContext;
        this.f47111i = subject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(kotlin.coroutines.Continuation<? super TSubject> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1 r0 = (io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1) r0
            int r1 = r0.f47116i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47116i = r1
            goto L18
        L13:
            io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1 r0 = new io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f47114g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47116i
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r2 = r0.f47113f
            io.ktor.util.pipeline.DebugPipelineContext r2 = (io.ktor.util.pipeline.DebugPipelineContext) r2
            kotlin.ResultKt.b(r7)
            goto L39
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            kotlin.ResultKt.b(r7)
            r2 = r6
        L39:
            int r7 = r2.f47112j
            r4 = -1
            if (r7 != r4) goto L3f
            goto L4a
        L3f:
            java.util.List<kotlin.jvm.functions.Function3<io.ktor.util.pipeline.PipelineContext<TSubject, TContext>, TSubject, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object>> r4 = r2.f47109g
            int r5 = r4.size()
            if (r7 < r5) goto L4f
            r2.b()
        L4a:
            java.lang.Object r7 = r2.e()
            return r7
        L4f:
            java.lang.Object r4 = r4.get(r7)
            kotlin.jvm.functions.Function3 r4 = (kotlin.jvm.functions.Function3) r4
            int r7 = r7 + 1
            r2.f47112j = r7
            java.lang.Object r7 = r2.e()
            r0.f47113f = r2
            r0.f47116i = r3
            java.lang.Object r7 = r4.l(r2, r7, r0)
            if (r7 != r1) goto L39
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.pipeline.DebugPipelineContext.i(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object a(TSubject tsubject, Continuation<? super TSubject> continuation) {
        this.f47112j = 0;
        k(tsubject);
        return f(continuation);
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public void b() {
        this.f47112j = -1;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public TSubject e() {
        return this.f47111i;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object f(Continuation<? super TSubject> continuation) {
        int i8 = this.f47112j;
        if (i8 < 0) {
            return e();
        }
        if (i8 >= this.f47109g.size()) {
            b();
            return e();
        }
        return i(continuation);
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object g(TSubject tsubject, Continuation<? super TSubject> continuation) {
        k(tsubject);
        return f(continuation);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return this.f47110h;
    }

    public void k(TSubject tsubject) {
        Intrinsics.f(tsubject, "<set-?>");
        this.f47111i = tsubject;
    }
}
