package kotlin;

import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepRecursive.kt */
/* loaded from: classes5.dex */
public final class DeepRecursiveKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f50799a;

    static {
        Object d8;
        Result.Companion companion = Result.f50818g;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        f50799a = Result.b(d8);
    }

    public static final <T, R> R b(DeepRecursiveFunction<T, R> deepRecursiveFunction, T t7) {
        Intrinsics.f(deepRecursiveFunction, "<this>");
        return (R) new DeepRecursiveScopeImpl(deepRecursiveFunction.a(), t7).b();
    }
}
