package io.ktor.client.engine;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Utils.kt */
/* loaded from: classes5.dex */
public final class KtorCallContextElement implements CoroutineContext.Element {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f46135g = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final CoroutineContext f46136f;

    /* compiled from: Utils.kt */
    /* loaded from: classes5.dex */
    public static final class Companion implements CoroutineContext.Key<KtorCallContextElement> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KtorCallContextElement(CoroutineContext callContext) {
        Intrinsics.f(callContext, "callContext");
        this.f46136f = callContext;
    }

    public final CoroutineContext b() {
        return this.f46136f;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E g(CoroutineContext.Key<E> key) {
        return (E) CoroutineContext.Element.DefaultImpls.b(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<?> getKey() {
        return f46135g;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext h(CoroutineContext.Key<?> key) {
        return CoroutineContext.Element.DefaultImpls.c(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R l(R r7, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) CoroutineContext.Element.DefaultImpls.a(this, r7, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext s0(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.d(this, coroutineContext);
    }
}
