package kotlin;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepRecursive.kt */
/* loaded from: classes5.dex */
public final class DeepRecursiveScopeImpl<T, R> extends DeepRecursiveScope<T, R> implements Continuation<R> {

    /* renamed from: f  reason: collision with root package name */
    private Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> f50800f;

    /* renamed from: g  reason: collision with root package name */
    private Object f50801g;

    /* renamed from: h  reason: collision with root package name */
    private Continuation<Object> f50802h;

    /* renamed from: i  reason: collision with root package name */
    private Object f50803i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DeepRecursiveScopeImpl(Function3<? super DeepRecursiveScope<T, R>, ? super T, ? super Continuation<? super R>, ? extends Object> block, T t7) {
        super(null);
        Object obj;
        Intrinsics.f(block, "block");
        this.f50800f = block;
        this.f50801g = t7;
        Intrinsics.d(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f50802h = this;
        obj = DeepRecursiveKt.f50799a;
        this.f50803i = obj;
    }

    @Override // kotlin.DeepRecursiveScope
    public Object a(T t7, Continuation<? super R> continuation) {
        Object d8;
        Object d9;
        Intrinsics.d(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f50802h = continuation;
        this.f50801g = t7;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        d9 = IntrinsicsKt__IntrinsicsKt.d();
        if (d8 == d9) {
            DebugProbesKt.c(continuation);
        }
        return d8;
    }

    public final R b() {
        Object obj;
        Object obj2;
        Object d8;
        while (true) {
            R r7 = (R) this.f50803i;
            Continuation<Object> continuation = this.f50802h;
            if (continuation != null) {
                obj = DeepRecursiveKt.f50799a;
                if (!Result.d(obj, r7)) {
                    obj2 = DeepRecursiveKt.f50799a;
                    this.f50803i = obj2;
                    continuation.resumeWith(r7);
                } else {
                    try {
                        Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function3 = this.f50800f;
                        Object obj3 = this.f50801g;
                        Intrinsics.d(function3, "null cannot be cast to non-null type kotlin.Function3<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.startCoroutineUninterceptedOrReturn, P of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.startCoroutineUninterceptedOrReturn, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.startCoroutineUninterceptedOrReturn>, kotlin.Any?>");
                        Object l8 = ((Function3) TypeIntrinsics.e(function3, 3)).l(this, obj3, continuation);
                        d8 = IntrinsicsKt__IntrinsicsKt.d();
                        if (l8 != d8) {
                            continuation.resumeWith(Result.b(l8));
                        }
                    } catch (Throwable th) {
                        Result.Companion companion = Result.f50818g;
                        continuation.resumeWith(Result.b(ResultKt.a(th)));
                    }
                }
            } else {
                ResultKt.b(r7);
                return r7;
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f50912f;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        this.f50802h = null;
        this.f50803i = obj;
    }
}
