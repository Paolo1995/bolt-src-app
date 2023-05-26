package eu.bolt.coroutines.flows;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SafeEmissionFlow.kt */
@DebugMetadata(c = "eu.bolt.coroutines.flows.SafeEmissionFlow$publish$1", f = "SafeEmissionFlow.kt", l = {54}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class SafeEmissionFlow$publish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f40385g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ SafeEmissionFlow<T> f40386h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ T f40387i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeEmissionFlow$publish$1(SafeEmissionFlow<T> safeEmissionFlow, T t7, Continuation<? super SafeEmissionFlow$publish$1> continuation) {
        super(2, continuation);
        this.f40386h = safeEmissionFlow;
        this.f40387i = t7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SafeEmissionFlow$publish$1(this.f40386h, this.f40387i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SafeEmissionFlow$publish$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f40385g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            MutableSharedFlow c8 = this.f40386h.c();
            T t7 = this.f40387i;
            this.f40385g = 1;
            if (c8.b(t7, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
