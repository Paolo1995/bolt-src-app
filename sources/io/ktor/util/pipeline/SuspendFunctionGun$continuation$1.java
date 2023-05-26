package io.ktor.util.pipeline;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SuspendFunctionGun.kt */
/* loaded from: classes5.dex */
public final class SuspendFunctionGun$continuation$1 implements Continuation<Unit>, CoroutineStackFrame {

    /* renamed from: f  reason: collision with root package name */
    private int f47142f = Integer.MIN_VALUE;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ SuspendFunctionGun<TSubject, TContext> f47143g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SuspendFunctionGun$continuation$1(SuspendFunctionGun<TSubject, TContext> suspendFunctionGun) {
        this.f47143g = suspendFunctionGun;
    }

    private final Continuation<?> a() {
        Continuation<?>[] continuationArr;
        int i8;
        if (this.f47142f == Integer.MIN_VALUE) {
            i8 = ((SuspendFunctionGun) this.f47143g).f47140k;
            this.f47142f = i8;
        }
        if (this.f47142f >= 0) {
            try {
                continuationArr = ((SuspendFunctionGun) this.f47143g).f47139j;
                int i9 = this.f47142f;
                Continuation<?> continuation = continuationArr[i9];
                if (continuation == null) {
                    return StackWalkingFailedFrame.f47135f;
                }
                this.f47142f = i9 - 1;
                return continuation;
            } catch (Throwable unused) {
                return StackWalkingFailedFrame.f47135f;
            }
        }
        this.f47142f = Integer.MIN_VALUE;
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<?> a8 = a();
        if (a8 instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) a8;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        Continuation[] continuationArr;
        int i8;
        CoroutineContext context;
        continuationArr = ((SuspendFunctionGun) this.f47143g).f47139j;
        i8 = ((SuspendFunctionGun) this.f47143g).f47140k;
        Continuation continuation = continuationArr[i8];
        if (continuation != null && (context = continuation.getContext()) != null) {
            return context;
        }
        throw new IllegalStateException("Not started".toString());
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        if (!Result.g(obj)) {
            this.f47143g.o(false);
            return;
        }
        SuspendFunctionGun<TSubject, TContext> suspendFunctionGun = this.f47143g;
        Throwable e8 = Result.e(obj);
        Intrinsics.c(e8);
        suspendFunctionGun.p(Result.b(ResultKt.a(e8)));
    }
}
