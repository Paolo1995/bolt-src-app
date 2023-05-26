package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes5.dex */
public final class CoroutineContextKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    private static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, final boolean z7) {
        boolean c8 = c(coroutineContext);
        boolean c9 = c(coroutineContext2);
        if (!c8 && !c9) {
            return coroutineContext.s0(coroutineContext2);
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f51016f = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f50912f;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.l(emptyCoroutineContext, new Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$folded$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Type inference failed for: r2v2, types: [T, kotlin.coroutines.CoroutineContext] */
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final CoroutineContext s(CoroutineContext coroutineContext4, CoroutineContext.Element element) {
                if (!(element instanceof CopyableThreadContextElement)) {
                    return coroutineContext4.s0(element);
                }
                CoroutineContext.Element g8 = ref$ObjectRef.f51016f.g(element.getKey());
                if (g8 == null) {
                    CopyableThreadContextElement copyableThreadContextElement = (CopyableThreadContextElement) element;
                    if (z7) {
                        copyableThreadContextElement = copyableThreadContextElement.Z();
                    }
                    return coroutineContext4.s0(copyableThreadContextElement);
                }
                Ref$ObjectRef<CoroutineContext> ref$ObjectRef2 = ref$ObjectRef;
                ref$ObjectRef2.f51016f = ref$ObjectRef2.f51016f.h(element.getKey());
                return coroutineContext4.s0(((CopyableThreadContextElement) element).w(g8));
            }
        });
        if (c9) {
            ref$ObjectRef.f51016f = ((CoroutineContext) ref$ObjectRef.f51016f).l(emptyCoroutineContext, new Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$1
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final CoroutineContext s(CoroutineContext coroutineContext4, CoroutineContext.Element element) {
                    if (element instanceof CopyableThreadContextElement) {
                        return coroutineContext4.s0(((CopyableThreadContextElement) element).Z());
                    }
                    return coroutineContext4.s0(element);
                }
            });
        }
        return coroutineContext3.s0((CoroutineContext) ref$ObjectRef.f51016f);
    }

    public static final String b(CoroutineContext coroutineContext) {
        return null;
    }

    private static final boolean c(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.l(Boolean.FALSE, new Function2<Boolean, CoroutineContext.Element, Boolean>() { // from class: kotlinx.coroutines.CoroutineContextKt$hasCopyableElements$1
            public final Boolean b(boolean z7, CoroutineContext.Element element) {
                boolean z8;
                if (!z7 && !(element instanceof CopyableThreadContextElement)) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                return Boolean.valueOf(z8);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean s(Boolean bool, CoroutineContext.Element element) {
                return b(bool.booleanValue(), element);
            }
        })).booleanValue();
    }

    public static final CoroutineContext d(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        if (!c(coroutineContext2)) {
            return coroutineContext.s0(coroutineContext2);
        }
        return a(coroutineContext, coroutineContext2, false);
    }

    public static final CoroutineContext e(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext a8 = a(coroutineScope.j(), coroutineContext, true);
        if (a8 != Dispatchers.a() && a8.g(ContinuationInterceptor.f50909b) == null) {
            return a8.s0(Dispatchers.a());
        }
        return a8;
    }

    public static final UndispatchedCoroutine<?> f(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof DispatchedCoroutine) && (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null) {
            if (coroutineStackFrame instanceof UndispatchedCoroutine) {
                return (UndispatchedCoroutine) coroutineStackFrame;
            }
        }
        return null;
    }

    public static final UndispatchedCoroutine<?> g(Continuation<?> continuation, CoroutineContext coroutineContext, Object obj) {
        boolean z7;
        if (!(continuation instanceof CoroutineStackFrame)) {
            return null;
        }
        if (coroutineContext.g(UndispatchedMarker.f51347f) != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            return null;
        }
        UndispatchedCoroutine<?> f8 = f((CoroutineStackFrame) continuation);
        if (f8 != null) {
            f8.m1(coroutineContext, obj);
        }
        return f8;
    }
}
