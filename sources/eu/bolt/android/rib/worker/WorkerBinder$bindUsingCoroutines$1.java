package eu.bolt.android.rib.worker;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: WorkerBinder.kt */
@DebugMetadata(c = "eu.bolt.android.rib.worker.WorkerBinder$bindUsingCoroutines$1", f = "WorkerBinder.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class WorkerBinder$bindUsingCoroutines$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f37366g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ boolean f37367h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Worker f37368i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerBinder$bindUsingCoroutines$1(Worker worker, Continuation<? super WorkerBinder$bindUsingCoroutines$1> continuation) {
        super(2, continuation);
        this.f37368i = worker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WorkerBinder$bindUsingCoroutines$1 workerBinder$bindUsingCoroutines$1 = new WorkerBinder$bindUsingCoroutines$1(this.f37368i, continuation);
        workerBinder$bindUsingCoroutines$1.f37367h = ((Boolean) obj).booleanValue();
        return workerBinder$bindUsingCoroutines$1;
    }

    public final Object h(boolean z7, Continuation<? super Unit> continuation) {
        return ((WorkerBinder$bindUsingCoroutines$1) create(Boolean.valueOf(z7), continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f37366g == 0) {
            ResultKt.b(obj);
            if (this.f37367h) {
                this.f37368i.onStart();
            } else {
                this.f37368i.onStop();
            }
            return Unit.f50853a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object s(Boolean bool, Continuation<? super Unit> continuation) {
        return h(bool.booleanValue(), continuation);
    }
}
