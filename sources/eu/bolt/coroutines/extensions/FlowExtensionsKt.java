package eu.bolt.coroutines.extensions;

import eu.bolt.logger.StaticLogger;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: FlowExtensions.kt */
/* loaded from: classes5.dex */
public final class FlowExtensionsKt {
    private static final CoroutineStart b(boolean z7) {
        if (z7) {
            return CoroutineStart.UNDISPATCHED;
        }
        return CoroutineStart.DEFAULT;
    }

    public static final <T> Object c(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function22, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Function1<? super Throwable, Unit> function12, Continuation<? super Unit> continuation) {
        Object d8;
        Object g8 = FlowKt.g(g(flow, function2, function22, function1, function12), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (g8 == d8) {
            return g8;
        }
        return Unit.f50853a;
    }

    public static final <T> Job d(Flow<? extends T> flow, CoroutineScope scope, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> onNext, Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> onError, Function1<? super Continuation<? super Unit>, ? extends Object> onComplete, Function1<? super Throwable, Unit> onNextError, boolean z7) {
        Job d8;
        Intrinsics.f(flow, "<this>");
        Intrinsics.f(scope, "scope");
        Intrinsics.f(onNext, "onNext");
        Intrinsics.f(onError, "onError");
        Intrinsics.f(onComplete, "onComplete");
        Intrinsics.f(onNextError, "onNextError");
        d8 = BuildersKt__Builders_commonKt.d(scope, null, b(z7), new FlowExtensionsKt$observe$5(flow, onNext, onError, onComplete, onNextError, null), 1, null);
        return d8;
    }

    public static /* synthetic */ Object e(Flow flow, Function2 function2, Function2 function22, Function1 function1, Function1 function12, Continuation continuation, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            function2 = new FlowExtensionsKt$observe$7(null);
        }
        Function2 function23 = function2;
        if ((i8 & 2) != 0) {
            function22 = new FlowExtensionsKt$observe$8(null);
        }
        Function2 function24 = function22;
        if ((i8 & 4) != 0) {
            function1 = new FlowExtensionsKt$observe$9(null);
        }
        Function1 function13 = function1;
        if ((i8 & 8) != 0) {
            function12 = new Function1<Throwable, Unit>() { // from class: eu.bolt.coroutines.extensions.FlowExtensionsKt$observe$10
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.f(it, "it");
                    StaticLogger.f41686a.h(it);
                }
            };
        }
        return c(flow, function23, function24, function13, function12, continuation);
    }

    public static /* synthetic */ Job f(Flow flow, CoroutineScope coroutineScope, Function2 function2, Function2 function22, Function1 function1, Function1 function12, boolean z7, int i8, Object obj) {
        Function2 function23;
        Function2 function24;
        Function1 function13;
        Function1 function14;
        boolean z8;
        if ((i8 & 2) != 0) {
            function23 = new FlowExtensionsKt$observe$1(null);
        } else {
            function23 = function2;
        }
        if ((i8 & 4) != 0) {
            function24 = new FlowExtensionsKt$observe$2(null);
        } else {
            function24 = function22;
        }
        if ((i8 & 8) != 0) {
            function13 = new FlowExtensionsKt$observe$3(null);
        } else {
            function13 = function1;
        }
        if ((i8 & 16) != 0) {
            function14 = new Function1<Throwable, Unit>() { // from class: eu.bolt.coroutines.extensions.FlowExtensionsKt$observe$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.f(it, "it");
                    StaticLogger.f41686a.h(it);
                }
            };
        } else {
            function14 = function12;
        }
        if ((i8 & 32) != 0) {
            z8 = false;
        } else {
            z8 = z7;
        }
        return d(flow, coroutineScope, function23, function24, function13, function14, z8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Flow<T> g(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function22, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Function1<? super Throwable, Unit> function12) {
        return FlowKt.e(FlowKt.E(FlowKt.F(flow, new FlowExtensionsKt$observeTransform$5(function2, function12, null)), new FlowExtensionsKt$observeTransform$6(function1, null)), new FlowExtensionsKt$observeTransform$7(function22, null));
    }

    public static final <T> Flow<T> h(Flow<? extends T> flow, Function1<? super T, Boolean> predicate) {
        Intrinsics.f(flow, "<this>");
        Intrinsics.f(predicate, "predicate");
        return FlowKt.J(flow, new FlowExtensionsKt$takeUntil$1(predicate, null));
    }
}
