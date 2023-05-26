package kotlin.coroutines;

import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes5.dex */
public interface CoroutineContext {

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext context) {
            Intrinsics.f(context, "context");
            if (context != EmptyCoroutineContext.f50912f) {
                return (CoroutineContext) context.l(coroutineContext, new Function2<CoroutineContext, Element, CoroutineContext>() { // from class: kotlin.coroutines.CoroutineContext$plus$1
                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: b */
                    public final CoroutineContext s(CoroutineContext acc, CoroutineContext.Element element) {
                        CombinedContext combinedContext;
                        Intrinsics.f(acc, "acc");
                        Intrinsics.f(element, "element");
                        CoroutineContext h8 = acc.h(element.getKey());
                        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f50912f;
                        if (h8 != emptyCoroutineContext) {
                            ContinuationInterceptor.Key key = ContinuationInterceptor.f50909b;
                            ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) h8.g(key);
                            if (continuationInterceptor == null) {
                                combinedContext = new CombinedContext(h8, element);
                            } else {
                                CoroutineContext h9 = h8.h(key);
                                if (h9 == emptyCoroutineContext) {
                                    return new CombinedContext(element, continuationInterceptor);
                                }
                                combinedContext = new CombinedContext(new CombinedContext(h9, element), continuationInterceptor);
                            }
                            return combinedContext;
                        }
                        return element;
                    }
                });
            }
            return coroutineContext;
        }
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes5.dex */
    public interface Element extends CoroutineContext {

        /* compiled from: CoroutineContext.kt */
        /* loaded from: classes5.dex */
        public static final class DefaultImpls {
            public static <R> R a(Element element, R r7, Function2<? super R, ? super Element, ? extends R> operation) {
                Intrinsics.f(operation, "operation");
                return operation.s(r7, element);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends Element> E b(Element element, Key<E> key) {
                Intrinsics.f(key, "key");
                if (Intrinsics.a(element.getKey(), key)) {
                    Intrinsics.d(element, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                    return element;
                }
                return null;
            }

            public static CoroutineContext c(Element element, Key<?> key) {
                Intrinsics.f(key, "key");
                if (Intrinsics.a(element.getKey(), key)) {
                    return EmptyCoroutineContext.f50912f;
                }
                return element;
            }

            public static CoroutineContext d(Element element, CoroutineContext context) {
                Intrinsics.f(context, "context");
                return DefaultImpls.a(element, context);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <E extends Element> E g(Key<E> key);

        Key<?> getKey();

        @Override // kotlin.coroutines.CoroutineContext
        CoroutineContext h(Key<?> key);

        @Override // kotlin.coroutines.CoroutineContext
        <R> R l(R r7, Function2<? super R, ? super Element, ? extends R> function2);
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes5.dex */
    public interface Key<E extends Element> {
    }

    <E extends Element> E g(Key<E> key);

    CoroutineContext h(Key<?> key);

    <R> R l(R r7, Function2<? super R, ? super Element, ? extends R> function2);

    CoroutineContext s0(CoroutineContext coroutineContext);
}
