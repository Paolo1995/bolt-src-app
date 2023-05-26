package eu.bolt.coroutines.extensions;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlowExtensions.kt */
@DebugMetadata(c = "eu.bolt.coroutines.extensions.FlowExtensionsKt$observe$7", f = "FlowExtensions.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class FlowExtensionsKt$observe$7 extends SuspendLambda implements Function2 {

    /* renamed from: g  reason: collision with root package name */
    int f40362g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowExtensionsKt$observe$7(Continuation<? super FlowExtensionsKt$observe$7> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FlowExtensionsKt$observe$7(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(Object obj, Continuation continuation) {
        return ((FlowExtensionsKt$observe$7) create(obj, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f40362g == 0) {
            ResultKt.b(obj);
            return Unit.f50853a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
