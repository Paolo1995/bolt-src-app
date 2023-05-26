package kotlin.coroutines;

import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes5.dex */
public final class EmptyCoroutineContext implements CoroutineContext, Serializable {

    /* renamed from: f  reason: collision with root package name */
    public static final EmptyCoroutineContext f50912f = new EmptyCoroutineContext();

    private EmptyCoroutineContext() {
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E g(CoroutineContext.Key<E> key) {
        Intrinsics.f(key, "key");
        return null;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext h(CoroutineContext.Key<?> key) {
        Intrinsics.f(key, "key");
        return this;
    }

    public int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R l(R r7, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        Intrinsics.f(operation, "operation");
        return r7;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext s0(CoroutineContext context) {
        Intrinsics.f(context, "context");
        return context;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
