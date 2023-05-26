package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R, T] */
/* compiled from: Merge.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", l = {214, 214}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class FlowKt__MergeKt$mapLatest$1<R, T> extends SuspendLambda implements Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f51571g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f51572h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f51573i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Function2<T, Continuation<? super R>, Object> f51574j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__MergeKt$mapLatest$1(Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super FlowKt__MergeKt$mapLatest$1> continuation) {
        super(3, continuation);
        this.f51574j = function2;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(FlowCollector<? super R> flowCollector, T t7, Continuation<? super Unit> continuation) {
        FlowKt__MergeKt$mapLatest$1 flowKt__MergeKt$mapLatest$1 = new FlowKt__MergeKt$mapLatest$1(this.f51574j, continuation);
        flowKt__MergeKt$mapLatest$1.f51572h = flowCollector;
        flowKt__MergeKt$mapLatest$1.f51573i = t7;
        return flowKt__MergeKt$mapLatest$1.invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        FlowCollector flowCollector;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f51571g;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    ResultKt.b(obj);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            flowCollector = (FlowCollector) this.f51572h;
        } else {
            ResultKt.b(obj);
            FlowCollector flowCollector2 = (FlowCollector) this.f51572h;
            Object obj2 = this.f51573i;
            this.f51572h = flowCollector2;
            this.f51571g = 1;
            obj = this.f51574j.s(obj2, this);
            flowCollector = flowCollector2;
            if (obj == d8) {
                return d8;
            }
        }
        this.f51572h = null;
        this.f51571g = 2;
        if (flowCollector.b(obj, this) == d8) {
            return d8;
        }
        return Unit.f50853a;
    }
}
