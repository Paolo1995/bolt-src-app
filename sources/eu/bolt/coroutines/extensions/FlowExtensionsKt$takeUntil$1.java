package eu.bolt.coroutines.extensions;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FlowExtensions.kt */
@DebugMetadata(c = "eu.bolt.coroutines.extensions.FlowExtensionsKt$takeUntil$1", f = "FlowExtensions.kt", l = {220}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class FlowExtensionsKt$takeUntil$1<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, T, Continuation<? super Boolean>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f40376g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f40377h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f40378i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Function1<T, Boolean> f40379j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtensionsKt$takeUntil$1(Function1<? super T, Boolean> function1, Continuation<? super FlowExtensionsKt$takeUntil$1> continuation) {
        super(3, continuation);
        this.f40379j = function1;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(FlowCollector<? super T> flowCollector, T t7, Continuation<? super Boolean> continuation) {
        FlowExtensionsKt$takeUntil$1 flowExtensionsKt$takeUntil$1 = new FlowExtensionsKt$takeUntil$1(this.f40379j, continuation);
        flowExtensionsKt$takeUntil$1.f40377h = flowCollector;
        flowExtensionsKt$takeUntil$1.f40378i = t7;
        return flowExtensionsKt$takeUntil$1.invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Object obj2;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f40376g;
        if (i8 != 0) {
            if (i8 == 1) {
                obj2 = this.f40377h;
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            Object obj3 = this.f40378i;
            this.f40377h = obj3;
            this.f40376g = 1;
            if (((FlowCollector) this.f40377h).b(obj3, this) == d8) {
                return d8;
            }
            obj2 = obj3;
        }
        return Boxing.a(!((Boolean) this.f40379j.invoke(obj2)).booleanValue());
    }
}
