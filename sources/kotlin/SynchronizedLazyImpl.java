package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyJVM.kt */
/* loaded from: classes5.dex */
final class SynchronizedLazyImpl<T> implements Lazy<T>, Serializable {

    /* renamed from: f  reason: collision with root package name */
    private Function0<? extends T> f50826f;

    /* renamed from: g  reason: collision with root package name */
    private volatile Object f50827g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f50828h;

    public SynchronizedLazyImpl(Function0<? extends T> initializer, Object obj) {
        Intrinsics.f(initializer, "initializer");
        this.f50826f = initializer;
        this.f50827g = UNINITIALIZED_VALUE.f50847a;
        this.f50828h = obj == null ? this : obj;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t7;
        T t8 = (T) this.f50827g;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.f50847a;
        if (t8 != uninitialized_value) {
            return t8;
        }
        synchronized (this.f50828h) {
            t7 = (T) this.f50827g;
            if (t7 == uninitialized_value) {
                Function0<? extends T> function0 = this.f50826f;
                Intrinsics.c(function0);
                t7 = function0.invoke();
                this.f50827g = t7;
                this.f50826f = null;
            }
        }
        return t7;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this.f50827g != UNINITIALIZED_VALUE.f50847a) {
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

    public /* synthetic */ SynchronizedLazyImpl(Function0 function0, Object obj, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i8 & 2) != 0 ? null : obj);
    }
}
