package kotlin.coroutines;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Continuation.kt */
/* loaded from: classes5.dex */
public final class ContinuationKt {
    public static final <R, T> void a(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r7, Continuation<? super T> completion) {
        Continuation b8;
        Continuation c8;
        Intrinsics.f(function2, "<this>");
        Intrinsics.f(completion, "completion");
        b8 = IntrinsicsKt__IntrinsicsJvmKt.b(function2, r7, completion);
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(b8);
        Result.Companion companion = Result.f50818g;
        c8.resumeWith(Result.b(Unit.f50853a));
    }
}
