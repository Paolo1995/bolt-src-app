package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Lazy.kt */
/* loaded from: classes5.dex */
public final class UnsafeLazyImpl<T> implements Lazy<T>, Serializable {

    /* renamed from: f  reason: collision with root package name */
    private Function0<? extends T> f50854f;

    /* renamed from: g  reason: collision with root package name */
    private Object f50855g;

    public UnsafeLazyImpl(Function0<? extends T> initializer) {
        Intrinsics.f(initializer, "initializer");
        this.f50854f = initializer;
        this.f50855g = UNINITIALIZED_VALUE.f50847a;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        if (this.f50855g == UNINITIALIZED_VALUE.f50847a) {
            Function0<? extends T> function0 = this.f50854f;
            Intrinsics.c(function0);
            this.f50855g = function0.invoke();
            this.f50854f = null;
        }
        return (T) this.f50855g;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this.f50855g != UNINITIALIZED_VALUE.f50847a) {
            return true;
        }
        return false;
    }

    public String toString() {
        if (isInitialized()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
