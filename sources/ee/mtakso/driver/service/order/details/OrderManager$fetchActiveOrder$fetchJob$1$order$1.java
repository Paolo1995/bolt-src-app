package ee.mtakso.driver.service.order.details;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.order.DriverOrderClient;
import ee.mtakso.driver.network.client.order.Order;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: OrderManager.kt */
@DebugMetadata(c = "ee.mtakso.driver.service.order.details.OrderManager$fetchActiveOrder$fetchJob$1$order$1", f = "OrderManager.kt", l = {146}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class OrderManager$fetchActiveOrder$fetchJob$1$order$1 extends SuspendLambda implements Function1<Continuation<? super Order>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f25450g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ OrderManager f25451h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ OrderHandle f25452i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderManager$fetchActiveOrder$fetchJob$1$order$1(OrderManager orderManager, OrderHandle orderHandle, Continuation<? super OrderManager$fetchActiveOrder$fetchJob$1$order$1> continuation) {
        super(1, continuation);
        this.f25451h = orderManager;
        this.f25452i = orderHandle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new OrderManager$fetchActiveOrder$fetchJob$1$order$1(this.f25451h, this.f25452i, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: h */
    public final Object invoke(Continuation<? super Order> continuation) {
        return ((OrderManager$fetchActiveOrder$fetchJob$1$order$1) create(continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        DriverOrderClient driverOrderClient;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f25450g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            driverOrderClient = this.f25451h.f25433c;
            OrderHandle orderHandle = this.f25452i;
            this.f25450g = 1;
            obj = driverOrderClient.c(orderHandle, this);
            if (obj == d8) {
                return d8;
            }
        }
        return obj;
    }
}
