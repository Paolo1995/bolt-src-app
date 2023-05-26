package kotlinx.coroutines.intrinsics;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

/* compiled from: Cancellable.kt */
/* loaded from: classes5.dex */
public final class CancellableKt {
    private static final void a(Continuation<?> continuation, Throwable th) {
        Result.Companion companion = Result.f50818g;
        continuation.resumeWith(Result.b(ResultKt.a(th)));
        throw th;
    }

    public static final void b(Continuation<? super Unit> continuation, Continuation<?> continuation2) {
        Continuation c8;
        try {
            c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
            Result.Companion companion = Result.f50818g;
            DispatchedContinuationKt.c(c8, Result.b(Unit.f50853a), null, 2, null);
        } catch (Throwable th) {
            a(continuation2, th);
        }
    }

    public static final <T> void c(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Continuation a8;
        Continuation c8;
        try {
            a8 = IntrinsicsKt__IntrinsicsJvmKt.a(function1, continuation);
            c8 = IntrinsicsKt__IntrinsicsJvmKt.c(a8);
            Result.Companion companion = Result.f50818g;
            DispatchedContinuationKt.c(c8, Result.b(Unit.f50853a), null, 2, null);
        } catch (Throwable th) {
            a(continuation, th);
        }
    }

    public static final <R, T> void d(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r7, Continuation<? super T> continuation, Function1<? super Throwable, Unit> function1) {
        Continuation b8;
        Continuation c8;
        try {
            b8 = IntrinsicsKt__IntrinsicsJvmKt.b(function2, r7, continuation);
            c8 = IntrinsicsKt__IntrinsicsJvmKt.c(b8);
            Result.Companion companion = Result.f50818g;
            DispatchedContinuationKt.b(c8, Result.b(Unit.f50853a), function1);
        } catch (Throwable th) {
            a(continuation, th);
        }
    }

    public static /* synthetic */ void e(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i8, Object obj2) {
        if ((i8 & 4) != 0) {
            function1 = null;
        }
        d(function2, obj, continuation, function1);
    }
}
