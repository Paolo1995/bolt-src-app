package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: CompletionState.kt */
/* loaded from: classes5.dex */
public final class CompletionStateKt {
    public static final <T> Object a(Object obj, Continuation<? super T> continuation) {
        if (obj instanceof CompletedExceptionally) {
            Result.Companion companion = Result.f50818g;
            return Result.b(ResultKt.a(((CompletedExceptionally) obj).f51234a));
        }
        return Result.b(obj);
    }

    public static final <T> Object b(Object obj, Function1<? super Throwable, Unit> function1) {
        Throwable e8 = Result.e(obj);
        if (e8 == null) {
            if (function1 != null) {
                return new CompletedWithCancellation(obj, function1);
            }
            return obj;
        }
        return new CompletedExceptionally(e8, false, 2, null);
    }

    public static final <T> Object c(Object obj, CancellableContinuation<?> cancellableContinuation) {
        Throwable e8 = Result.e(obj);
        if (e8 != null) {
            return new CompletedExceptionally(e8, false, 2, null);
        }
        return obj;
    }

    public static /* synthetic */ Object d(Object obj, Function1 function1, int i8, Object obj2) {
        if ((i8 & 1) != 0) {
            function1 = null;
        }
        return b(obj, function1);
    }
}
