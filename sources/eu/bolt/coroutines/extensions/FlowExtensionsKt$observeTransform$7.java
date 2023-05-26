package eu.bolt.coroutines.extensions;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FlowExtensions.kt */
@DebugMetadata(c = "eu.bolt.coroutines.extensions.FlowExtensionsKt$observeTransform$7", f = "FlowExtensions.kt", l = {97}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class FlowExtensionsKt$observeTransform$7<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f40373g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f40374h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Function2<Throwable, Continuation<? super Unit>, Object> f40375i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtensionsKt$observeTransform$7(Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super FlowExtensionsKt$observeTransform$7> continuation) {
        super(3, continuation);
        this.f40375i = function2;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(FlowCollector<? super T> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        FlowExtensionsKt$observeTransform$7 flowExtensionsKt$observeTransform$7 = new FlowExtensionsKt$observeTransform$7(this.f40375i, continuation);
        flowExtensionsKt$observeTransform$7.f40374h = th;
        return flowExtensionsKt$observeTransform$7.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f40373g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            Function2<Throwable, Continuation<? super Unit>, Object> function2 = this.f40375i;
            this.f40373g = 1;
            if (function2.s((Throwable) this.f40374h, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
