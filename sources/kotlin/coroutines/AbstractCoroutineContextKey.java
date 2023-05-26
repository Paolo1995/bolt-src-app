package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes5.dex */
public abstract class AbstractCoroutineContextKey<B extends CoroutineContext.Element, E extends B> implements CoroutineContext.Key<E> {

    /* renamed from: f  reason: collision with root package name */
    private final Function1<CoroutineContext.Element, E> f50904f;

    /* renamed from: g  reason: collision with root package name */
    private final CoroutineContext.Key<?> f50905g;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.functions.Function1<? super kotlin.coroutines.CoroutineContext$Element, ? extends E extends B>, java.lang.Object, kotlin.jvm.functions.Function1<kotlin.coroutines.CoroutineContext$Element, E extends B>] */
    public AbstractCoroutineContextKey(CoroutineContext.Key<B> baseKey, Function1<? super CoroutineContext.Element, ? extends E> safeCast) {
        Intrinsics.f(baseKey, "baseKey");
        Intrinsics.f(safeCast, "safeCast");
        this.f50904f = safeCast;
        this.f50905g = baseKey instanceof AbstractCoroutineContextKey ? (CoroutineContext.Key<B>) ((AbstractCoroutineContextKey) baseKey).f50905g : baseKey;
    }

    public final boolean a(CoroutineContext.Key<?> key) {
        Intrinsics.f(key, "key");
        if (key != this && this.f50905g != key) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$Element;)TE; */
    public final CoroutineContext.Element b(CoroutineContext.Element element) {
        Intrinsics.f(element, "element");
        return (CoroutineContext.Element) this.f50904f.invoke(element);
    }
}
