package eu.bolt.coroutines.extensions;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlowExtensions.kt */
@DebugMetadata(c = "eu.bolt.coroutines.extensions.FlowExtensionsKt$observe$5", f = "FlowExtensions.kt", l = {58}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class FlowExtensionsKt$observe$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f40356g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ Flow<T> f40357h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> f40358i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Function2<Throwable, Continuation<? super Unit>, Object> f40359j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> f40360k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ Function1<Throwable, Unit> f40361l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtensionsKt$observe$5(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function22, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Function1<? super Throwable, Unit> function12, Continuation<? super FlowExtensionsKt$observe$5> continuation) {
        super(2, continuation);
        this.f40357h = flow;
        this.f40358i = function2;
        this.f40359j = function22;
        this.f40360k = function1;
        this.f40361l = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FlowExtensionsKt$observe$5(this.f40357h, this.f40358i, this.f40359j, this.f40360k, this.f40361l, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FlowExtensionsKt$observe$5) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Flow g8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f40356g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            g8 = FlowExtensionsKt.g(this.f40357h, this.f40358i, this.f40359j, this.f40360k, this.f40361l);
            this.f40356g = 1;
            if (FlowKt.g(g8, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
