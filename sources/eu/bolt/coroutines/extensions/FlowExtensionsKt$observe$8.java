package eu.bolt.coroutines.extensions;

import eu.bolt.logger.StaticLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlowExtensions.kt */
@DebugMetadata(c = "eu.bolt.coroutines.extensions.FlowExtensionsKt$observe$8", f = "FlowExtensions.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class FlowExtensionsKt$observe$8 extends SuspendLambda implements Function2<Throwable, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f40363g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f40364h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowExtensionsKt$observe$8(Continuation<? super FlowExtensionsKt$observe$8> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowExtensionsKt$observe$8 flowExtensionsKt$observe$8 = new FlowExtensionsKt$observe$8(continuation);
        flowExtensionsKt$observe$8.f40364h = obj;
        return flowExtensionsKt$observe$8;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(Throwable th, Continuation<? super Unit> continuation) {
        return ((FlowExtensionsKt$observe$8) create(th, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f40363g == 0) {
            ResultKt.b(obj);
            StaticLogger.f41686a.h((Throwable) this.f40364h);
            return Unit.f50853a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
