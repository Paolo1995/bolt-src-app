package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContinuationInterceptor.kt */
/* loaded from: classes5.dex */
public interface ContinuationInterceptor extends CoroutineContext.Element {

    /* renamed from: b  reason: collision with root package name */
    public static final Key f50909b = Key.f50910f;

    /* compiled from: ContinuationInterceptor.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static <E extends CoroutineContext.Element> E a(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<E> key) {
            Intrinsics.f(key, "key");
            if (key instanceof AbstractCoroutineContextKey) {
                AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
                if (!abstractCoroutineContextKey.a(continuationInterceptor.getKey())) {
                    return null;
                }
                E e8 = (E) abstractCoroutineContextKey.b(continuationInterceptor);
                if (!(e8 instanceof CoroutineContext.Element)) {
                    return null;
                }
                return e8;
            } else if (ContinuationInterceptor.f50909b != key) {
                return null;
            } else {
                Intrinsics.d(continuationInterceptor, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return continuationInterceptor;
            }
        }

        public static CoroutineContext b(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<?> key) {
            Intrinsics.f(key, "key");
            if (key instanceof AbstractCoroutineContextKey) {
                AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
                if (abstractCoroutineContextKey.a(continuationInterceptor.getKey()) && abstractCoroutineContextKey.b(continuationInterceptor) != null) {
                    return EmptyCoroutineContext.f50912f;
                }
                return continuationInterceptor;
            } else if (ContinuationInterceptor.f50909b == key) {
                return EmptyCoroutineContext.f50912f;
            } else {
                return continuationInterceptor;
            }
        }
    }

    /* compiled from: ContinuationInterceptor.kt */
    /* loaded from: classes5.dex */
    public static final class Key implements CoroutineContext.Key<ContinuationInterceptor> {

        /* renamed from: f  reason: collision with root package name */
        static final /* synthetic */ Key f50910f = new Key();

        private Key() {
        }
    }

    void m(Continuation<?> continuation);

    <T> Continuation<T> t(Continuation<? super T> continuation);
}
