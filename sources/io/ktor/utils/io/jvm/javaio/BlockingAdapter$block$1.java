package io.ktor.utils.io.jvm.javaio;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Blocking.kt */
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.BlockingAdapter$block$1", f = "Blocking.kt", l = {186}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class BlockingAdapter$block$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f47481g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ BlockingAdapter f47482h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockingAdapter$block$1(BlockingAdapter blockingAdapter, Continuation<? super BlockingAdapter$block$1> continuation) {
        super(1, continuation);
        this.f47482h = blockingAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new BlockingAdapter$block$1(this.f47482h, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: h */
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((BlockingAdapter$block$1) create(continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f47481g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            BlockingAdapter blockingAdapter = this.f47482h;
            this.f47481g = 1;
            if (blockingAdapter.h(this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
