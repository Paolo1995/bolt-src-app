package io.ktor.util.pipeline;

import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SuspendFunctionGun.kt */
/* loaded from: classes5.dex */
public final class SuspendFunctionGun<TSubject, TContext> extends PipelineContext<TSubject, TContext> {

    /* renamed from: g  reason: collision with root package name */
    private final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> f47136g;

    /* renamed from: h  reason: collision with root package name */
    private final Continuation<Unit> f47137h;

    /* renamed from: i  reason: collision with root package name */
    private TSubject f47138i;

    /* renamed from: j  reason: collision with root package name */
    private final Continuation<TSubject>[] f47139j;

    /* renamed from: k  reason: collision with root package name */
    private int f47140k;

    /* renamed from: l  reason: collision with root package name */
    private int f47141l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SuspendFunctionGun(TSubject initial, TContext context, List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> blocks) {
        super(context);
        Intrinsics.f(initial, "initial");
        Intrinsics.f(context, "context");
        Intrinsics.f(blocks, "blocks");
        this.f47136g = blocks;
        this.f47137h = new SuspendFunctionGun$continuation$1(this);
        this.f47138i = initial;
        this.f47139j = new Continuation[blocks.size()];
        this.f47140k = -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(Continuation<? super TSubject> continuation) {
        int i8 = this.f47140k + 1;
        this.f47140k = i8;
        this.f47139j[i8] = continuation;
    }

    private final void n() {
        int i8 = this.f47140k;
        if (i8 >= 0) {
            Continuation<TSubject>[] continuationArr = this.f47139j;
            this.f47140k = i8 - 1;
            continuationArr[i8] = null;
            return;
        }
        throw new IllegalStateException("No more continuations to resume");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o(boolean z7) {
        Object l8;
        Object d8;
        do {
            int i8 = this.f47141l;
            if (i8 == this.f47136g.size()) {
                if (!z7) {
                    Result.Companion companion = Result.f50818g;
                    p(Result.b(e()));
                    return false;
                }
                return true;
            }
            this.f47141l = i8 + 1;
            try {
                l8 = this.f47136g.get(i8).l(this, e(), this.f47137h);
                d8 = IntrinsicsKt__IntrinsicsKt.d();
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f50818g;
                p(Result.b(ResultKt.a(th)));
                return false;
            }
        } while (l8 != d8);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(Object obj) {
        int i8 = this.f47140k;
        if (i8 >= 0) {
            Continuation<TSubject> continuation = this.f47139j[i8];
            Intrinsics.c(continuation);
            Continuation<TSubject>[] continuationArr = this.f47139j;
            int i9 = this.f47140k;
            this.f47140k = i9 - 1;
            continuationArr[i9] = null;
            if (!Result.g(obj)) {
                continuation.resumeWith(obj);
                return;
            }
            Throwable e8 = Result.e(obj);
            Intrinsics.c(e8);
            continuation.resumeWith(Result.b(ResultKt.a(StackTraceRecoverKt.a(e8, continuation))));
            return;
        }
        throw new IllegalStateException("No more continuations to resume".toString());
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object a(TSubject tsubject, Continuation<? super TSubject> continuation) {
        this.f47141l = 0;
        if (this.f47136g.size() == 0) {
            return tsubject;
        }
        q(tsubject);
        if (this.f47140k < 0) {
            return f(continuation);
        }
        throw new IllegalStateException("Already started");
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public void b() {
        this.f47141l = this.f47136g.size();
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public TSubject e() {
        return this.f47138i;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object f(Continuation<? super TSubject> continuation) {
        Object d8;
        Object d9;
        if (this.f47141l == this.f47136g.size()) {
            d8 = e();
        } else {
            m(continuation);
            if (o(true)) {
                n();
                d8 = e();
            } else {
                d8 = IntrinsicsKt__IntrinsicsKt.d();
            }
        }
        d9 = IntrinsicsKt__IntrinsicsKt.d();
        if (d8 == d9) {
            DebugProbesKt.c(continuation);
        }
        return d8;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object g(TSubject tsubject, Continuation<? super TSubject> continuation) {
        q(tsubject);
        return f(continuation);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return this.f47137h.getContext();
    }

    public void q(TSubject tsubject) {
        Intrinsics.f(tsubject, "<set-?>");
        this.f47138i = tsubject;
    }
}
