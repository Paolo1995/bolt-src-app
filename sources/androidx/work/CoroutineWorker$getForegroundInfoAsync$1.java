package androidx.work;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CoroutineWorker.kt */
@DebugMetadata(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", l = {134}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class CoroutineWorker$getForegroundInfoAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f8261g;

    /* renamed from: h  reason: collision with root package name */
    int f8262h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ JobListenableFuture<ForegroundInfo> f8263i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ CoroutineWorker f8264j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker$getForegroundInfoAsync$1(JobListenableFuture<ForegroundInfo> jobListenableFuture, CoroutineWorker coroutineWorker, Continuation<? super CoroutineWorker$getForegroundInfoAsync$1> continuation) {
        super(2, continuation);
        this.f8263i = jobListenableFuture;
        this.f8264j = coroutineWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoroutineWorker$getForegroundInfoAsync$1(this.f8263i, this.f8264j, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutineWorker$getForegroundInfoAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        JobListenableFuture jobListenableFuture;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f8262h;
        if (i8 != 0) {
            if (i8 == 1) {
                jobListenableFuture = (JobListenableFuture) this.f8261g;
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            JobListenableFuture jobListenableFuture2 = this.f8263i;
            CoroutineWorker coroutineWorker = this.f8264j;
            this.f8261g = jobListenableFuture2;
            this.f8262h = 1;
            Object t7 = coroutineWorker.t(this);
            if (t7 == d8) {
                return d8;
            }
            jobListenableFuture = jobListenableFuture2;
            obj = t7;
        }
        jobListenableFuture.b(obj);
        return Unit.f50853a;
    }
}
