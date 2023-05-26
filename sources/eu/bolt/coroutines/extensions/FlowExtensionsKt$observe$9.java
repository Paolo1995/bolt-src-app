package eu.bolt.coroutines.extensions;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlowExtensions.kt */
@DebugMetadata(c = "eu.bolt.coroutines.extensions.FlowExtensionsKt$observe$9", f = "FlowExtensions.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class FlowExtensionsKt$observe$9 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f40365g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowExtensionsKt$observe$9(Continuation<? super FlowExtensionsKt$observe$9> continuation) {
        super(1, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new FlowExtensionsKt$observe$9(continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: h */
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((FlowExtensionsKt$observe$9) create(continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f40365g == 0) {
            ResultKt.b(obj);
            return Unit.f50853a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
