package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

/* compiled from: ThreadContext.kt */
/* loaded from: classes5.dex */
public final class ThreadContextKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f51837a = new Symbol("NO_THREAD_ELEMENTS");

    /* renamed from: b  reason: collision with root package name */
    private static final Function2<Object, CoroutineContext.Element, Object> f51838b = new Function2<Object, CoroutineContext.Element, Object>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$countAll$1
        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final Object s(Object obj, CoroutineContext.Element element) {
            Integer num;
            int i8;
            if (element instanceof ThreadContextElement) {
                if (obj instanceof Integer) {
                    num = (Integer) obj;
                } else {
                    num = null;
                }
                if (num != null) {
                    i8 = num.intValue();
                } else {
                    i8 = 1;
                }
                if (i8 != 0) {
                    return Integer.valueOf(i8 + 1);
                }
                return element;
            }
            return obj;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> f51839c = new Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$findOne$1
        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final ThreadContextElement<?> s(ThreadContextElement<?> threadContextElement, CoroutineContext.Element element) {
            if (threadContextElement != null) {
                return threadContextElement;
            }
            if (element instanceof ThreadContextElement) {
                return (ThreadContextElement) element;
            }
            return null;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final Function2<ThreadState, CoroutineContext.Element, ThreadState> f51840d = new Function2<ThreadState, CoroutineContext.Element, ThreadState>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$updateState$1
        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final ThreadState s(ThreadState threadState, CoroutineContext.Element element) {
            if (element instanceof ThreadContextElement) {
                ThreadContextElement<?> threadContextElement = (ThreadContextElement) element;
                threadState.a(threadContextElement, threadContextElement.C0(threadState.f51845a));
            }
            return threadState;
        }
    };

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj == f51837a) {
            return;
        }
        if (obj instanceof ThreadState) {
            ((ThreadState) obj).b(coroutineContext);
            return;
        }
        Object l8 = coroutineContext.l(null, f51839c);
        if (l8 != null) {
            ((ThreadContextElement) l8).c0(coroutineContext, obj);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }

    public static final Object b(CoroutineContext coroutineContext) {
        Object l8 = coroutineContext.l(0, f51838b);
        Intrinsics.c(l8);
        return l8;
    }

    public static final Object c(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return f51837a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.l(new ThreadState(coroutineContext, ((Number) obj).intValue()), f51840d);
        }
        return ((ThreadContextElement) obj).C0(coroutineContext);
    }
}
