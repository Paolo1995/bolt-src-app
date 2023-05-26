package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepRecursive.kt */
/* loaded from: classes5.dex */
public final class DeepRecursiveFunction<T, R> {

    /* renamed from: a  reason: collision with root package name */
    private final Function3<DeepRecursiveScope<T, R>, T, Continuation<? super R>, Object> f50798a;

    /* JADX WARN: Multi-variable type inference failed */
    public DeepRecursiveFunction(Function3<? super DeepRecursiveScope<T, R>, ? super T, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.f(block, "block");
        this.f50798a = block;
    }

    public final Function3<DeepRecursiveScope<T, R>, T, Continuation<? super R>, Object> a() {
        return this.f50798a;
    }
}
