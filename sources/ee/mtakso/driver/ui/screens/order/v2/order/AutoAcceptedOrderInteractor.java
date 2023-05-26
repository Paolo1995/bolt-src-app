package ee.mtakso.driver.ui.screens.order.v2.order;

import ee.mtakso.driver.network.client.OrderStateKt;
import ee.mtakso.driver.network.client.settings.AutoOrderAcceptance;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AutoAcceptedOrderInteractor.kt */
/* loaded from: classes3.dex */
public final class AutoAcceptedOrderInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final OrderProvider f32170a;

    @Inject
    public AutoAcceptedOrderInteractor(OrderProvider orderProvider) {
        Intrinsics.f(orderProvider, "orderProvider");
        this.f32170a = orderProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    public Observable<List<Long>> d() {
        Observable<List<OrderDetails>> a8 = this.f32170a.a();
        final AutoAcceptedOrderInteractor$observeScreenData$1 autoAcceptedOrderInteractor$observeScreenData$1 = new Function1<List<? extends OrderDetails>, List<? extends OrderDetails>>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.AutoAcceptedOrderInteractor$observeScreenData$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<OrderDetails> invoke(List<? extends OrderDetails> it) {
                Intrinsics.f(it, "it");
                ArrayList arrayList = new ArrayList();
                for (Object obj : it) {
                    if (!OrderStateKt.b(((OrderDetails) obj).b())) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        };
        Observable<R> map = a8.map(new Function() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List e8;
                e8 = AutoAcceptedOrderInteractor.e(Function1.this, obj);
                return e8;
            }
        });
        final AutoAcceptedOrderInteractor$observeScreenData$2 autoAcceptedOrderInteractor$observeScreenData$2 = new Function1<List<? extends OrderDetails>, List<? extends OrderDetails>>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.AutoAcceptedOrderInteractor$observeScreenData$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<OrderDetails> invoke(List<? extends OrderDetails> it) {
                ActiveOrderDetails activeOrderDetails;
                boolean z7;
                Intrinsics.f(it, "it");
                ArrayList arrayList = new ArrayList();
                for (Object obj : it) {
                    OrderDetails orderDetails = (OrderDetails) obj;
                    AutoOrderAcceptance autoOrderAcceptance = null;
                    if (orderDetails instanceof ActiveOrderDetails) {
                        activeOrderDetails = (ActiveOrderDetails) orderDetails;
                    } else {
                        activeOrderDetails = null;
                    }
                    if (activeOrderDetails != null) {
                        autoOrderAcceptance = activeOrderDetails.h();
                    }
                    if (autoOrderAcceptance == AutoOrderAcceptance.AUTO) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z7) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        };
        Observable map2 = map.map(new Function() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List f8;
                f8 = AutoAcceptedOrderInteractor.f(Function1.this, obj);
                return f8;
            }
        });
        final AutoAcceptedOrderInteractor$observeScreenData$3 autoAcceptedOrderInteractor$observeScreenData$3 = new Function1<List<? extends OrderDetails>, List<? extends Long>>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.AutoAcceptedOrderInteractor$observeScreenData$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<Long> invoke(List<? extends OrderDetails> it) {
                int v7;
                Intrinsics.f(it, "it");
                v7 = CollectionsKt__IterablesKt.v(it, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (OrderDetails orderDetails : it) {
                    arrayList.add(Long.valueOf(orderDetails.a().b()));
                }
                return arrayList;
            }
        };
        Observable<List<Long>> map3 = map2.map(new Function() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List g8;
                g8 = AutoAcceptedOrderInteractor.g(Function1.this, obj);
                return g8;
            }
        });
        Intrinsics.e(map3, "orderProvider.observeOrd…ls.orderHandle.orderId} }");
        return map3;
    }
}
