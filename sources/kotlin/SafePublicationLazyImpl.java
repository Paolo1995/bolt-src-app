package kotlin;

import androidx.concurrent.futures.a;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyJVM.kt */
/* loaded from: classes5.dex */
final class SafePublicationLazyImpl<T> implements Lazy<T>, Serializable {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f50821i = new Companion(null);

    /* renamed from: j  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> f50822j = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "g");

    /* renamed from: f  reason: collision with root package name */
    private volatile Function0<? extends T> f50823f;

    /* renamed from: g  reason: collision with root package name */
    private volatile Object f50824g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f50825h;

    /* compiled from: LazyJVM.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SafePublicationLazyImpl(Function0<? extends T> initializer) {
        Intrinsics.f(initializer, "initializer");
        this.f50823f = initializer;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.f50847a;
        this.f50824g = uninitialized_value;
        this.f50825h = uninitialized_value;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t7 = (T) this.f50824g;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.f50847a;
        if (t7 != uninitialized_value) {
            return t7;
        }
        Function0<? extends T> function0 = this.f50823f;
        if (function0 != null) {
            T invoke = function0.invoke();
            if (a.a(f50822j, this, uninitialized_value, invoke)) {
                this.f50823f = null;
                return invoke;
            }
        }
        return (T) this.f50824g;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this.f50824g != UNINITIALIZED_VALUE.f50847a) {
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
