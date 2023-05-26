package eu.bolt.chat.util;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CoroutineRunner.kt */
@DebugMetadata(c = "eu.bolt.chat.util.StableCoroutineRunner$launch$1", f = "CoroutineRunner.kt", l = {27}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class StableCoroutineRunner$launch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f39704g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ Function2<CoroutineRunner, Continuation<? super Unit>, Object> f39705h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ StableCoroutineRunner f39706i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StableCoroutineRunner$launch$1(Function2<? super CoroutineRunner, ? super Continuation<? super Unit>, ? extends Object> function2, StableCoroutineRunner stableCoroutineRunner, Continuation<? super StableCoroutineRunner$launch$1> continuation) {
        super(2, continuation);
        this.f39705h = function2;
        this.f39706i = stableCoroutineRunner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StableCoroutineRunner$launch$1(this.f39705h, this.f39706i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StableCoroutineRunner$launch$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f39704g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            Function2<CoroutineRunner, Continuation<? super Unit>, Object> function2 = this.f39705h;
            StableCoroutineRunner stableCoroutineRunner = this.f39706i;
            this.f39704g = 1;
            if (function2.s(stableCoroutineRunner, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
