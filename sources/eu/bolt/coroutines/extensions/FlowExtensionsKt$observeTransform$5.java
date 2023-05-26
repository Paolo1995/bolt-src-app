package eu.bolt.coroutines.extensions;

import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FlowExtensions.kt */
@DebugMetadata(c = "eu.bolt.coroutines.extensions.FlowExtensionsKt$observeTransform$5", f = "FlowExtensions.kt", l = {83}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class FlowExtensionsKt$observeTransform$5<T> extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f40366g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f40367h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> f40368i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Function1<Throwable, Unit> f40369j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtensionsKt$observeTransform$5(Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Function1<? super Throwable, Unit> function1, Continuation<? super FlowExtensionsKt$observeTransform$5> continuation) {
        super(2, continuation);
        this.f40368i = function2;
        this.f40369j = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowExtensionsKt$observeTransform$5 flowExtensionsKt$observeTransform$5 = new FlowExtensionsKt$observeTransform$5(this.f40368i, this.f40369j, continuation);
        flowExtensionsKt$observeTransform$5.f40367h = obj;
        return flowExtensionsKt$observeTransform$5;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(T t7, Continuation<? super Unit> continuation) {
        return ((FlowExtensionsKt$observeTransform$5) create(t7, continuation)).invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f40366g;
        try {
            if (i8 != 0) {
                if (i8 == 1) {
                    ResultKt.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.b(obj);
                Object obj2 = this.f40367h;
                this.f40366g = 1;
                if (this.f40368i.s(obj2, this) == d8) {
                    return d8;
                }
            }
        } catch (Exception e8) {
            if (!(e8 instanceof CancellationException)) {
                this.f40369j.invoke(e8);
            } else {
                throw e8;
            }
        }
        return Unit.f50853a;
    }
}
