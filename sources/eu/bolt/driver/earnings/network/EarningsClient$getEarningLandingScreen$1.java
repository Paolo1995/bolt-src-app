package eu.bolt.driver.earnings.network;

import eu.bolt.driver.core.network.response.BasicServerResponseKt;
import eu.bolt.driver.core.network.response.ServerResponse;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EarningsClient.kt */
@DebugMetadata(c = "eu.bolt.driver.earnings.network.EarningsClient$getEarningLandingScreen$1", f = "EarningsClient.kt", l = {14}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class EarningsClient$getEarningLandingScreen$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super EarningLandingScreen>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f41486g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ EarningsClient f41487h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarningsClient$getEarningLandingScreen$1(EarningsClient earningsClient, Continuation<? super EarningsClient$getEarningLandingScreen$1> continuation) {
        super(2, continuation);
        this.f41487h = earningsClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EarningsClient$getEarningLandingScreen$1(this.f41487h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super EarningLandingScreen> continuation) {
        return ((EarningsClient$getEarningLandingScreen$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        EarningsApi earningsApi;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f41486g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            earningsApi = this.f41487h.f41479a;
            this.f41486g = 1;
            obj = earningsApi.b(this);
            if (obj == d8) {
                return d8;
            }
        }
        return BasicServerResponseKt.a((ServerResponse) obj);
    }
}
