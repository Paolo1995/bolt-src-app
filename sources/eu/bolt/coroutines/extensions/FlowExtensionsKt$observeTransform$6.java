package eu.bolt.coroutines.extensions;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FlowExtensions.kt */
@DebugMetadata(c = "eu.bolt.coroutines.extensions.FlowExtensionsKt$observeTransform$6", f = "FlowExtensions.kt", l = {94}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class FlowExtensionsKt$observeTransform$6<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f40370g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f40371h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> f40372i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtensionsKt$observeTransform$6(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super FlowExtensionsKt$observeTransform$6> continuation) {
        super(3, continuation);
        this.f40372i = function1;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(FlowCollector<? super T> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        FlowExtensionsKt$observeTransform$6 flowExtensionsKt$observeTransform$6 = new FlowExtensionsKt$observeTransform$6(this.f40372i, continuation);
        flowExtensionsKt$observeTransform$6.f40371h = th;
        return flowExtensionsKt$observeTransform$6.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f40370g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            if (((Throwable) this.f40371h) == null) {
                Function1<Continuation<? super Unit>, Object> function1 = this.f40372i;
                this.f40370g = 1;
                if (function1.invoke(this) == d8) {
                    return d8;
                }
            }
        }
        return Unit.f50853a;
    }
}
