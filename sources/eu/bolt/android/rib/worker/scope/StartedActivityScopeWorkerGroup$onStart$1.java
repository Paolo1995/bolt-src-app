package eu.bolt.android.rib.worker.scope;

import eu.bolt.android.rib.lifecycle.ActivityLifecycleEvent;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: StartedActivityScopeWorkerGroup.kt */
@DebugMetadata(c = "eu.bolt.android.rib.worker.scope.StartedActivityScopeWorkerGroup$onStart$1", f = "StartedActivityScopeWorkerGroup.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class StartedActivityScopeWorkerGroup$onStart$1 extends SuspendLambda implements Function2<ActivityLifecycleEvent, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f37394g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ StartedActivityScopeWorkerGroup f37395h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedActivityScopeWorkerGroup$onStart$1(StartedActivityScopeWorkerGroup startedActivityScopeWorkerGroup, Continuation<? super StartedActivityScopeWorkerGroup$onStart$1> continuation) {
        super(2, continuation);
        this.f37395h = startedActivityScopeWorkerGroup;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StartedActivityScopeWorkerGroup$onStart$1(this.f37395h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(ActivityLifecycleEvent activityLifecycleEvent, Continuation<? super Unit> continuation) {
        return ((StartedActivityScopeWorkerGroup$onStart$1) create(activityLifecycleEvent, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f37394g == 0) {
            ResultKt.b(obj);
            this.f37395h.d();
            return Unit.f50853a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
