package kotlinx.coroutines.intrinsics;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: Undispatched.kt */
/* loaded from: classes5.dex */
public final class UndispatchedKt {
    public static final <R, T> void a(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r7, Continuation<? super T> continuation) {
        Object d8;
        Continuation a8 = DebugProbesKt.a(continuation);
        try {
            CoroutineContext context = continuation.getContext();
            Object c8 = ThreadContextKt.c(context, null);
            Object s7 = ((Function2) TypeIntrinsics.e(function2, 2)).s(r7, a8);
            ThreadContextKt.a(context, c8);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            if (s7 != d8) {
                a8.resumeWith(Result.b(s7));
            }
        } catch (Throwable th) {
            Result.Companion companion = Result.f50818g;
            a8.resumeWith(Result.b(ResultKt.a(th)));
        }
    }

    public static final <T> void b(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Object d8;
        Continuation a8 = DebugProbesKt.a(continuation);
        try {
            Object invoke = ((Function1) TypeIntrinsics.e(function1, 1)).invoke(a8);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            if (invoke != d8) {
                a8.resumeWith(Result.b(invoke));
            }
        } catch (Throwable th) {
            Result.Companion companion = Result.f50818g;
            a8.resumeWith(Result.b(ResultKt.a(th)));
        }
    }

    public static final <R, T> void c(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r7, Continuation<? super T> continuation) {
        Object d8;
        Continuation a8 = DebugProbesKt.a(continuation);
        try {
            Object s7 = ((Function2) TypeIntrinsics.e(function2, 2)).s(r7, a8);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            if (s7 != d8) {
                a8.resumeWith(Result.b(s7));
            }
        } catch (Throwable th) {
            Result.Companion companion = Result.f50818g;
            a8.resumeWith(Result.b(ResultKt.a(th)));
        }
    }

    public static final <T, R> Object d(ScopeCoroutine<? super T> scopeCoroutine, R r7, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object completedExceptionally;
        Object d8;
        Object d9;
        Object d10;
        try {
            completedExceptionally = ((Function2) TypeIntrinsics.e(function2, 2)).s(r7, scopeCoroutine);
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false, 2, null);
        }
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (completedExceptionally == d8) {
            d10 = IntrinsicsKt__IntrinsicsKt.d();
            return d10;
        }
        Object F0 = scopeCoroutine.F0(completedExceptionally);
        if (F0 == JobSupportKt.f51316b) {
            d9 = IntrinsicsKt__IntrinsicsKt.d();
            return d9;
        } else if (!(F0 instanceof CompletedExceptionally)) {
            return JobSupportKt.h(F0);
        } else {
            throw ((CompletedExceptionally) F0).f51234a;
        }
    }

    public static final <T, R> Object e(ScopeCoroutine<? super T> scopeCoroutine, R r7, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object completedExceptionally;
        Object d8;
        Object d9;
        Object d10;
        boolean z7 = false;
        try {
            completedExceptionally = ((Function2) TypeIntrinsics.e(function2, 2)).s(r7, scopeCoroutine);
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false, 2, null);
        }
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (completedExceptionally == d8) {
            d10 = IntrinsicsKt__IntrinsicsKt.d();
            return d10;
        }
        Object F0 = scopeCoroutine.F0(completedExceptionally);
        if (F0 == JobSupportKt.f51316b) {
            d9 = IntrinsicsKt__IntrinsicsKt.d();
            return d9;
        }
        if (F0 instanceof CompletedExceptionally) {
            Throwable th2 = ((CompletedExceptionally) F0).f51234a;
            if (!(((th2 instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th2).f51338f == scopeCoroutine) ? true : true)) {
                if (completedExceptionally instanceof CompletedExceptionally) {
                    throw ((CompletedExceptionally) completedExceptionally).f51234a;
                }
            } else {
                throw th2;
            }
        } else {
            completedExceptionally = JobSupportKt.h(F0);
        }
        return completedExceptionally;
    }
}
