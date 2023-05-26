package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* compiled from: Builders.common.kt */
/* loaded from: classes5.dex */
public final /* synthetic */ class BuildersKt__Builders_commonKt {
    public static final <T> Deferred<T> a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        DeferredCoroutine deferredCoroutine;
        CoroutineContext e8 = CoroutineContextKt.e(coroutineScope, coroutineContext);
        if (coroutineStart.e()) {
            deferredCoroutine = new LazyDeferredCoroutine(e8, function2);
        } else {
            deferredCoroutine = new DeferredCoroutine(e8, true);
        }
        ((AbstractCoroutine) deferredCoroutine).j1(coroutineStart, deferredCoroutine, function2);
        return deferredCoroutine;
    }

    public static /* synthetic */ Deferred b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f50912f;
        }
        if ((i8 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.a(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final Job c(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        AbstractCoroutine standaloneCoroutine;
        CoroutineContext e8 = CoroutineContextKt.e(coroutineScope, coroutineContext);
        if (coroutineStart.e()) {
            standaloneCoroutine = new LazyStandaloneCoroutine(e8, function2);
        } else {
            standaloneCoroutine = new StandaloneCoroutine(e8, true);
        }
        standaloneCoroutine.j1(coroutineStart, standaloneCoroutine, function2);
        return standaloneCoroutine;
    }

    public static /* synthetic */ Job d(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f50912f;
        }
        if ((i8 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.c(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final <T> Object e(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        Object l12;
        Object d8;
        CoroutineContext context = continuation.getContext();
        CoroutineContext d9 = CoroutineContextKt.d(context, coroutineContext);
        JobKt.i(d9);
        if (d9 == context) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(d9, continuation);
            l12 = UndispatchedKt.d(scopeCoroutine, scopeCoroutine, function2);
        } else {
            ContinuationInterceptor.Key key = ContinuationInterceptor.f50909b;
            if (Intrinsics.a(d9.g(key), context.g(key))) {
                UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(d9, continuation);
                Object c8 = ThreadContextKt.c(d9, null);
                try {
                    Object d10 = UndispatchedKt.d(undispatchedCoroutine, undispatchedCoroutine, function2);
                    ThreadContextKt.a(d9, c8);
                    l12 = d10;
                } catch (Throwable th) {
                    ThreadContextKt.a(d9, c8);
                    throw th;
                }
            } else {
                DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(d9, continuation);
                CancellableKt.e(function2, dispatchedCoroutine, dispatchedCoroutine, null, 4, null);
                l12 = dispatchedCoroutine.l1();
            }
        }
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (l12 == d8) {
            DebugProbesKt.c(continuation);
        }
        return l12;
    }
}
