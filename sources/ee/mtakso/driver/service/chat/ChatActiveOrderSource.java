package ee.mtakso.driver.service.chat;

import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import eu.bolt.chat.chatcore.entity.OrderHandleEntity;
import eu.bolt.driver.chat.ActiveOrdersSource;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatActiveOrderSource.kt */
/* loaded from: classes3.dex */
public final class ChatActiveOrderSource implements ActiveOrdersSource {

    /* renamed from: a  reason: collision with root package name */
    private final OrderProvider f23989a;

    @Inject
    public ChatActiveOrderSource(OrderProvider orderProvider) {
        Intrinsics.f(orderProvider, "orderProvider");
        this.f23989a = orderProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    @Override // eu.bolt.driver.chat.ActiveOrdersSource
    public Observable<List<OrderHandleEntity>> a() {
        Observable<List<OrderDetails>> a8 = this.f23989a.a();
        final ChatActiveOrderSource$observeActiveOrders$1 chatActiveOrderSource$observeActiveOrders$1 = new Function1<List<? extends OrderDetails>, List<? extends OrderHandleEntity>>() { // from class: ee.mtakso.driver.service.chat.ChatActiveOrderSource$observeActiveOrders$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<OrderHandleEntity> invoke(List<? extends OrderDetails> orders) {
                int v7;
                List n8;
                Intrinsics.f(orders, "orders");
                ArrayList<OrderDetails> arrayList = new ArrayList();
                for (Object obj : orders) {
                    n8 = CollectionsKt__CollectionsKt.n(OrderState.ORDER_STATE_DRIVER_ACCEPTED, OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT, OrderState.ORDER_STATE_ARRIVED_TO_DESTINATION, OrderState.ORDER_STATE_DRIVING_WITH_CLIENT, OrderState.ORDER_STATE_WAITING_ON_STOP);
                    if (n8.contains(((OrderDetails) obj).b())) {
                        arrayList.add(obj);
                    }
                }
                v7 = CollectionsKt__IterablesKt.v(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(v7);
                for (OrderDetails orderDetails : arrayList) {
                    arrayList2.add(new OrderHandleEntity(orderDetails.a().b(), orderDetails.a().c(), Long.valueOf(orderDetails.a().a())));
                }
                return arrayList2;
            }
        };
        Observable map = a8.map(new Function() { // from class: ee.mtakso.driver.service.chat.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List c8;
                c8 = ChatActiveOrderSource.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(map, "orderProvider.observeOrd…          }\n            }");
        return map;
    }
}
