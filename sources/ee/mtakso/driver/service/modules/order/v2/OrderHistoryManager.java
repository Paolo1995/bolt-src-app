package ee.mtakso.driver.service.modules.order.v2;

import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.order.PreviousOrder;
import ee.mtakso.driver.network.client.order.PreviousOrders;
import ee.mtakso.driver.network.client.order.RideHistoryClient;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderHistoryManager.kt */
/* loaded from: classes3.dex */
public final class OrderHistoryManager {

    /* renamed from: a  reason: collision with root package name */
    private final RideHistoryClient f24908a;

    @Inject
    public OrderHistoryManager(RideHistoryClient apiClient) {
        Intrinsics.f(apiClient, "apiClient");
        this.f24908a = apiClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Integer) tmp0.invoke(obj);
    }

    public final Single<List<PreviousOrder>> c() {
        Single<PreviousOrders> a8 = this.f24908a.a();
        final OrderHistoryManager$fetchOrderHistory$1 orderHistoryManager$fetchOrderHistory$1 = new Function1<PreviousOrders, List<? extends PreviousOrder>>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderHistoryManager$fetchOrderHistory$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<PreviousOrder> invoke(PreviousOrders it) {
                Intrinsics.f(it, "it");
                return it.a();
            }
        };
        Single x7 = a8.x(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List d8;
                d8 = OrderHistoryManager.d(Function1.this, obj);
                return d8;
            }
        });
        Intrinsics.e(x7, "apiClient\n            .g…map { it.previousOrders }");
        return x7;
    }

    public final Single<Integer> e() {
        Single<List<PreviousOrder>> c8 = c();
        final OrderHistoryManager$fetchSuccessfulOrdersCount$1 orderHistoryManager$fetchSuccessfulOrdersCount$1 = new Function1<List<? extends PreviousOrder>, Integer>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderHistoryManager$fetchSuccessfulOrdersCount$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Integer invoke(List<PreviousOrder> it) {
                boolean z7;
                Intrinsics.f(it, "it");
                ArrayList arrayList = new ArrayList();
                for (Object obj : it) {
                    if (((PreviousOrder) obj).g() == OrderState.ORDER_STATE_FINISHED) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z7) {
                        arrayList.add(obj);
                    }
                }
                return Integer.valueOf(arrayList.size());
            }
        };
        Single<Integer> D = c8.x(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Integer f8;
                f8 = OrderHistoryManager.f(Function1.this, obj);
                return f8;
            }
        }).D(0);
        Intrinsics.e(D, "fetchOrderHistory()\n    …    .onErrorReturnItem(0)");
        return D;
    }
}
