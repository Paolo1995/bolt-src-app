package eu.bolt.coroutines.base;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseScopeOwner.kt */
@DebugMetadata(c = "eu.bolt.coroutines.base.BaseScopeOwner$observe$3", f = "BaseScopeOwner.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class BaseScopeOwner$observe$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f40340g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseScopeOwner$observe$3(Continuation<? super BaseScopeOwner$observe$3> continuation) {
        super(1, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new BaseScopeOwner$observe$3(continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: h */
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((BaseScopeOwner$observe$3) create(continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f40340g == 0) {
            ResultKt.b(obj);
            return Unit.f50853a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
