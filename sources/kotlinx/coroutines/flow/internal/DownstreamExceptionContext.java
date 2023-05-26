package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* compiled from: SafeCollector.kt */
/* loaded from: classes5.dex */
public final class DownstreamExceptionContext implements CoroutineContext {

    /* renamed from: f  reason: collision with root package name */
    public final Throwable f51739f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ CoroutineContext f51740g;

    public DownstreamExceptionContext(Throwable th, CoroutineContext coroutineContext) {
        this.f51739f = th;
        this.f51740g = coroutineContext;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E g(CoroutineContext.Key<E> key) {
        return (E) this.f51740g.g(key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext h(CoroutineContext.Key<?> key) {
        return this.f51740g.h(key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R l(R r7, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) this.f51740g.l(r7, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext s0(CoroutineContext coroutineContext) {
        return this.f51740g.s0(coroutineContext);
    }
}
