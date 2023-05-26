package ee.mtakso.driver.network.client.order;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DriverOrderClient.kt */
@DebugMetadata(c = "ee.mtakso.driver.network.client.order.DriverOrderClient$disableNewOrder$1", f = "DriverOrderClient.kt", l = {25}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DriverOrderClient$disableNewOrder$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f22334g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DriverOrderClient f22335h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ long f22336i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DriverOrderClient$disableNewOrder$1(DriverOrderClient driverOrderClient, long j8, Continuation<? super DriverOrderClient$disableNewOrder$1> continuation) {
        super(2, continuation);
        this.f22335h = driverOrderClient;
        this.f22336i = j8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DriverOrderClient$disableNewOrder$1(this.f22335h, this.f22336i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DriverOrderClient$disableNewOrder$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        DriverOrderApi driverOrderApi;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f22334g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            driverOrderApi = this.f22335h.f22333b;
            DisableNewOrderRequest disableNewOrderRequest = new DisableNewOrderRequest(this.f22336i);
            this.f22334g = 1;
            if (driverOrderApi.b(disableNewOrderRequest, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
