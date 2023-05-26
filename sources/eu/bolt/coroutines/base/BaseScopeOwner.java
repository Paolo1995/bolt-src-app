package eu.bolt.coroutines.base;

import eu.bolt.coroutines.extensions.FlowExtensionsKt;
import eu.bolt.coroutines.extensions.ScopeExtKt;
import eu.bolt.logger.StaticLogger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;

/* compiled from: BaseScopeOwner.kt */
/* loaded from: classes5.dex */
public abstract class BaseScopeOwner {

    /* renamed from: a  reason: collision with root package name */
    private final String f40335a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f40336b;

    public BaseScopeOwner() {
        Lazy b8;
        String simpleName = getClass().getSimpleName();
        Intrinsics.e(simpleName, "javaClass.simpleName");
        this.f40335a = simpleName;
        b8 = LazyKt__LazyJVMKt.b(new Function0<CoroutineScope>() { // from class: eu.bolt.coroutines.base.BaseScopeOwner$scope$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final CoroutineScope invoke() {
                return BaseScopeKt.b(BaseScopeOwner.this.D(), null, null, null, null, 30, null);
            }
        });
        this.f40336b = b8;
    }

    private final CoroutineScope C() {
        return (CoroutineScope) this.f40336b.getValue();
    }

    public static /* synthetic */ Job F(BaseScopeOwner baseScopeOwner, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 1) != 0) {
                coroutineContext = EmptyCoroutineContext.f50912f;
            }
            if ((i8 & 2) != 0) {
                coroutineStart = CoroutineStart.DEFAULT;
            }
            return baseScopeOwner.E(coroutineContext, coroutineStart, function2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launch");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Job H(BaseScopeOwner baseScopeOwner, Flow flow, Function2 function2, Function2 function22, Function1 function1, Function1 function12, boolean z7, int i8, Object obj) {
        Function2 function23;
        BaseScopeOwner$observe$2 baseScopeOwner$observe$2;
        BaseScopeOwner$observe$3 baseScopeOwner$observe$3;
        BaseScopeOwner$observe$4 baseScopeOwner$observe$4;
        boolean z8;
        if (obj == null) {
            if ((i8 & 1) != 0) {
                function23 = new BaseScopeOwner$observe$1(null);
            } else {
                function23 = function2;
            }
            if ((i8 & 2) != 0) {
                baseScopeOwner$observe$2 = new BaseScopeOwner$observe$2(null);
            } else {
                baseScopeOwner$observe$2 = function22;
            }
            if ((i8 & 4) != 0) {
                baseScopeOwner$observe$3 = new BaseScopeOwner$observe$3(null);
            } else {
                baseScopeOwner$observe$3 = function1;
            }
            if ((i8 & 8) != 0) {
                baseScopeOwner$observe$4 = new Function1<Throwable, Unit>() { // from class: eu.bolt.coroutines.base.BaseScopeOwner$observe$4
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
                baseScopeOwner$observe$4 = function12;
            }
            if ((i8 & 16) != 0) {
                z8 = true;
            } else {
                z8 = z7;
            }
            return baseScopeOwner.G(flow, function23, baseScopeOwner$observe$2, baseScopeOwner$observe$3, baseScopeOwner$observe$4, z8);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: observe");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B(String cause) {
        Intrinsics.f(cause, "cause");
        ScopeExtKt.a(C(), cause);
    }

    public String D() {
        return this.f40335a;
    }

    protected final Job E(CoroutineContext context, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.f(context, "context");
        Intrinsics.f(start, "start");
        Intrinsics.f(block, "block");
        return BuildersKt.c(C(), context, start, block);
    }

    protected final <T> Job G(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> onNext, Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> onError, Function1<? super Continuation<? super Unit>, ? extends Object> onComplete, Function1<? super Throwable, Unit> onNextError, boolean z7) {
        Intrinsics.f(flow, "<this>");
        Intrinsics.f(onNext, "onNext");
        Intrinsics.f(onError, "onError");
        Intrinsics.f(onComplete, "onComplete");
        Intrinsics.f(onNextError, "onNextError");
        return FlowExtensionsKt.d(flow, C(), onNext, onError, onComplete, onNextError, z7);
    }
}
