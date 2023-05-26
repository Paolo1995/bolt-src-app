package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: Zip.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", l = {33, 33}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class FlowKt__ZipKt$combine$1$1<R> extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f51608g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f51609h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f51610i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> f51611j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$1$1(Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super FlowKt__ZipKt$combine$1$1> continuation) {
        super(3, continuation);
        this.f51611j = function3;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(FlowCollector<? super R> flowCollector, Object[] objArr, Continuation<? super Unit> continuation) {
        FlowKt__ZipKt$combine$1$1 flowKt__ZipKt$combine$1$1 = new FlowKt__ZipKt$combine$1$1(this.f51611j, continuation);
        flowKt__ZipKt$combine$1$1.f51609h = flowCollector;
        flowKt__ZipKt$combine$1$1.f51610i = objArr;
        return flowKt__ZipKt$combine$1$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        FlowCollector flowCollector;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f51608g;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    ResultKt.b(obj);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowCollector) this.f51609h;
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            flowCollector = (FlowCollector) this.f51609h;
            Object[] objArr = (Object[]) this.f51610i;
            Function3<T1, T2, Continuation<? super R>, Object> function3 = this.f51611j;
            Object obj2 = objArr[0];
            Object obj3 = objArr[1];
            this.f51609h = flowCollector;
            this.f51608g = 1;
            obj = function3.l(obj2, obj3, this);
            if (obj == d8) {
                return d8;
            }
        }
        this.f51609h = null;
        this.f51608g = 2;
        if (flowCollector.b(obj, this) == d8) {
            return d8;
        }
        return Unit.f50853a;
    }
}
