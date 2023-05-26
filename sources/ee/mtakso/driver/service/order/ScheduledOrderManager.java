package ee.mtakso.driver.service.order;

import ee.mtakso.driver.model.CancellationReason;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.order.AcceptScheduledRideResponse;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.network.client.order.RejectOrderResponse;
import ee.mtakso.driver.network.client.order.RejectReasonInfo;
import ee.mtakso.driver.network.client.order.RejectResponseType;
import ee.mtakso.driver.network.client.order.modal.ModalWithList;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.home.v3.HomeFragment;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrderManager.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrderManager {

    /* renamed from: a  reason: collision with root package name */
    private final OrderClient f25377a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledOrderProvider f25378b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverManager f25379c;

    /* renamed from: d  reason: collision with root package name */
    private final RoutingManager f25380d;

    @Inject
    public ScheduledOrderManager(OrderClient orderClient, ScheduledOrderProvider scheduledOrderProvider, DriverManager driverManager, RoutingManager routingManager) {
        Intrinsics.f(orderClient, "orderClient");
        Intrinsics.f(scheduledOrderProvider, "scheduledOrderProvider");
        Intrinsics.f(driverManager, "driverManager");
        Intrinsics.f(routingManager, "routingManager");
        this.f25377a = orderClient;
        this.f25378b = scheduledOrderProvider;
        this.f25379c = driverManager;
        this.f25380d = routingManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModalWithList f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ModalWithList) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final Single<ModalWithList> d(final OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        Single<AcceptScheduledRideResponse> i8 = this.f25377a.i(orderHandle);
        final Function1<AcceptScheduledRideResponse, Unit> function1 = new Function1<AcceptScheduledRideResponse, Unit>() { // from class: ee.mtakso.driver.service.order.ScheduledOrderManager$acceptOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(AcceptScheduledRideResponse acceptScheduledRideResponse) {
                ScheduledOrderProvider scheduledOrderProvider;
                scheduledOrderProvider = ScheduledOrderManager.this.f25378b;
                scheduledOrderProvider.a(orderHandle);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AcceptScheduledRideResponse acceptScheduledRideResponse) {
                b(acceptScheduledRideResponse);
                return Unit.f50853a;
            }
        };
        Single<AcceptScheduledRideResponse> o8 = i8.o(new Consumer() { // from class: ee.mtakso.driver.service.order.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ScheduledOrderManager.e(Function1.this, obj);
            }
        });
        final ScheduledOrderManager$acceptOrder$2 scheduledOrderManager$acceptOrder$2 = new Function1<AcceptScheduledRideResponse, ModalWithList>() { // from class: ee.mtakso.driver.service.order.ScheduledOrderManager$acceptOrder$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ModalWithList invoke(AcceptScheduledRideResponse it) {
                Intrinsics.f(it, "it");
                return it.a();
            }
        };
        Single x7 = o8.x(new Function() { // from class: ee.mtakso.driver.service.order.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ModalWithList f8;
                f8 = ScheduledOrderManager.f(Function1.this, obj);
                return f8;
            }
        });
        Intrinsics.e(x7, "fun acceptOrder(orderHan…  .map { it.modal }\n    }");
        return x7;
    }

    public final Single<RejectOrderResponse> h(final OrderHandle orderHandle, CancellationReason cancellationReason) {
        RejectReasonInfo rejectReasonInfo;
        Intrinsics.f(orderHandle, "orderHandle");
        OrderClient orderClient = this.f25377a;
        if (cancellationReason != null) {
            rejectReasonInfo = new RejectReasonInfo(cancellationReason.a(), cancellationReason.b());
        } else {
            rejectReasonInfo = null;
        }
        Single<RejectOrderResponse> H = orderClient.H(orderHandle, rejectReasonInfo);
        final Function1<RejectOrderResponse, Unit> function1 = new Function1<RejectOrderResponse, Unit>() { // from class: ee.mtakso.driver.service.order.ScheduledOrderManager$cancelOrder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(RejectOrderResponse rejectOrderResponse) {
                ScheduledOrderProvider scheduledOrderProvider;
                if (rejectOrderResponse.c() == RejectResponseType.SUCCESS) {
                    scheduledOrderProvider = ScheduledOrderManager.this.f25378b;
                    scheduledOrderProvider.a(orderHandle);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RejectOrderResponse rejectOrderResponse) {
                b(rejectOrderResponse);
                return Unit.f50853a;
            }
        };
        Single<RejectOrderResponse> o8 = H.o(new Consumer() { // from class: ee.mtakso.driver.service.order.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ScheduledOrderManager.i(Function1.this, obj);
            }
        });
        Intrinsics.e(o8, "fun cancelOrder(\n       …    }\n            }\n    }");
        return o8;
    }

    public final void j(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        this.f25379c.n(orderHandle);
        RoutingManager.d(this.f25380d, SimpleActivity.Companion.f(SimpleActivity.f27004l, HomeFragment.class, null, false, 0, 14, null), false, 2, null);
    }
}
