package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.LimitedDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

/* compiled from: CoroutineDispatcher.kt */
/* loaded from: classes5.dex */
public abstract class CoroutineDispatcher extends AbstractCoroutineContextElement implements ContinuationInterceptor {

    /* renamed from: g  reason: collision with root package name */
    public static final Key f51241g = new Key(null);

    /* compiled from: CoroutineDispatcher.kt */
    /* loaded from: classes5.dex */
    public static final class Key extends AbstractCoroutineContextKey<ContinuationInterceptor, CoroutineDispatcher> {
        private Key() {
            super(ContinuationInterceptor.f50909b, new Function1<CoroutineContext.Element, CoroutineDispatcher>() { // from class: kotlinx.coroutines.CoroutineDispatcher.Key.1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final CoroutineDispatcher invoke(CoroutineContext.Element element) {
                    if (element instanceof CoroutineDispatcher) {
                        return (CoroutineDispatcher) element;
                    }
                    return null;
                }
            });
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.f50909b);
    }

    public abstract void G0(CoroutineContext coroutineContext, Runnable runnable);

    public void I0(CoroutineContext coroutineContext, Runnable runnable) {
        G0(coroutineContext, runnable);
    }

    public boolean K0(CoroutineContext coroutineContext) {
        return true;
    }

    public CoroutineDispatcher P0(int i8) {
        LimitedDispatcherKt.a(i8);
        return new LimitedDispatcher(this, i8);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E g(CoroutineContext.Key<E> key) {
        return (E) ContinuationInterceptor.DefaultImpls.a(this, key);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext h(CoroutineContext.Key<?> key) {
        return ContinuationInterceptor.DefaultImpls.b(this, key);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final void m(Continuation<?> continuation) {
        ((DispatchedContinuation) continuation).q();
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final <T> Continuation<T> t(Continuation<? super T> continuation) {
        return new DispatchedContinuation(this, continuation);
    }

    public String toString() {
        return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this);
    }
}
