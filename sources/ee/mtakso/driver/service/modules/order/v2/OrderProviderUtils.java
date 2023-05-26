package ee.mtakso.driver.service.modules.order.v2;

import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.OrderStateKt;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetailsKt;
import ee.mtakso.driver.service.order.details.OrderProvider;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderProvider.kt */
/* loaded from: classes3.dex */
public final class OrderProviderUtils {
    public static final ActiveOrderDetails i(List<? extends OrderDetails> list) {
        int v7;
        Object obj;
        boolean z7;
        Intrinsics.f(list, "list");
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (true ^ OrderStateKt.b(((OrderDetails) obj2).b())) {
                arrayList.add(obj2);
            }
        }
        if (arrayList.size() == 1 && OrderDetailsKt.a((OrderDetails) arrayList.get(0), OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION)) {
            Object obj3 = arrayList.get(0);
            Intrinsics.d(obj3, "null cannot be cast to non-null type ee.mtakso.driver.service.order.details.ActiveOrderDetails");
            return (ActiveOrderDetails) obj3;
        }
        ArrayList<OrderDetails> arrayList2 = new ArrayList();
        for (Object obj4 : list) {
            OrderDetails orderDetails = (OrderDetails) obj4;
            if (!OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_DRIVER_ACCEPTED) && !OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT) && !OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_DRIVING_WITH_CLIENT) && !OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_ARRIVED_TO_DESTINATION) && !OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_WAITING_ON_STOP)) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (z7) {
                arrayList2.add(obj4);
            }
        }
        v7 = CollectionsKt__IterablesKt.v(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(v7);
        for (OrderDetails orderDetails2 : arrayList2) {
            Intrinsics.d(orderDetails2, "null cannot be cast to non-null type ee.mtakso.driver.service.order.details.ActiveOrderDetails");
            arrayList3.add((ActiveOrderDetails) orderDetails2);
        }
        Iterator it = arrayList3.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (!it.hasNext()) {
                obj = next;
            } else {
                int priority = ((ActiveOrderDetails) next).b().getPriority();
                do {
                    Object next2 = it.next();
                    int priority2 = ((ActiveOrderDetails) next2).b().getPriority();
                    if (priority > priority2) {
                        next = next2;
                        priority = priority2;
                    }
                } while (it.hasNext());
                obj = next;
            }
        }
        return (ActiveOrderDetails) obj;
    }

    public static final ActiveOrderDetails j(List<? extends OrderDetails> list) {
        int v7;
        Object obj;
        boolean z7;
        Intrinsics.f(list, "list");
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (true ^ OrderStateKt.b(((OrderDetails) obj2).b())) {
                arrayList.add(obj2);
            }
        }
        if (arrayList.size() == 1 && OrderDetailsKt.a((OrderDetails) arrayList.get(0), OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION)) {
            Object obj3 = arrayList.get(0);
            Intrinsics.d(obj3, "null cannot be cast to non-null type ee.mtakso.driver.service.order.details.ActiveOrderDetails");
            return (ActiveOrderDetails) obj3;
        }
        ArrayList<OrderDetails> arrayList2 = new ArrayList();
        for (Object obj4 : list) {
            OrderDetails orderDetails = (OrderDetails) obj4;
            if (!OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_DRIVER_ACCEPTED) && !OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT) && !OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_DRIVING_WITH_CLIENT) && !OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_WAITING_ON_STOP)) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (z7) {
                arrayList2.add(obj4);
            }
        }
        v7 = CollectionsKt__IterablesKt.v(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(v7);
        for (OrderDetails orderDetails2 : arrayList2) {
            Intrinsics.d(orderDetails2, "null cannot be cast to non-null type ee.mtakso.driver.service.order.details.ActiveOrderDetails");
            arrayList3.add((ActiveOrderDetails) orderDetails2);
        }
        Iterator it = arrayList3.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (!it.hasNext()) {
                obj = next;
            } else {
                int priority = ((ActiveOrderDetails) next).b().getPriority();
                do {
                    Object next2 = it.next();
                    int priority2 = ((ActiveOrderDetails) next2).b().getPriority();
                    if (priority > priority2) {
                        next = next2;
                        priority = priority2;
                    }
                } while (it.hasNext());
                obj = next;
            }
        }
        return (ActiveOrderDetails) obj;
    }

    public static final Observable<OrderDetails> k(OrderProvider orderProvider, final Function1<? super OrderDetails, Boolean> predicate) {
        Intrinsics.f(orderProvider, "<this>");
        Intrinsics.f(predicate, "predicate");
        Observable<List<OrderDetails>> a8 = orderProvider.a();
        final OrderProviderUtils$observeOrder$1 orderProviderUtils$observeOrder$1 = new Function1<List<? extends OrderDetails>, Iterable<? extends OrderDetails>>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils$observeOrder$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Iterable<OrderDetails> invoke(List<? extends OrderDetails> it) {
                Intrinsics.f(it, "it");
                return it;
            }
        };
        Observable<OrderDetails> filter = a8.flatMapIterable(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.m
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Iterable l8;
                l8 = OrderProviderUtils.l(Function1.this, obj);
                return l8;
            }
        }).filter(new Predicate() { // from class: ee.mtakso.driver.service.modules.order.v2.n
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean m8;
                m8 = OrderProviderUtils.m(Function1.this, obj);
                return m8;
            }
        });
        Intrinsics.e(filter, "observeOrders().flatMapI… { it }.filter(predicate)");
        return filter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Iterable) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public static final Observable<OrderDetails> n(OrderProvider orderProvider, final OrderState... states) {
        Intrinsics.f(orderProvider, "<this>");
        Intrinsics.f(states, "states");
        Observable<OrderDetails> k8 = k(orderProvider, new Function1<OrderDetails, Boolean>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils$observeOrderInState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(OrderDetails order) {
                boolean z7;
                Intrinsics.f(order, "order");
                z7 = ArraysKt___ArraysKt.z(states, order.b());
                return Boolean.valueOf(z7);
            }
        });
        final OrderProviderUtils$observeOrderInState$2 orderProviderUtils$observeOrderInState$2 = new Function1<OrderDetails, OrderDetails>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils$observeOrderInState$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final OrderDetails invoke(OrderDetails it) {
                Intrinsics.f(it, "it");
                return it;
            }
        };
        Observable map = k8.map(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                OrderDetails o8;
                o8 = OrderProviderUtils.o(Function1.this, obj);
                return o8;
            }
        });
        Intrinsics.e(map, "vararg states: OrderStat….orderState) }.map { it }");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OrderDetails o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (OrderDetails) tmp0.invoke(obj);
    }

    public static final Single<ActiveOrderDetails> p(OrderProvider orderProvider, OrderState... states) {
        Intrinsics.f(orderProvider, "<this>");
        Intrinsics.f(states, "states");
        Single<OrderDetails> r7 = r(orderProvider, (OrderState[]) Arrays.copyOf(states, states.length));
        final OrderProviderUtils$obtainActiveOrderInState$1 orderProviderUtils$obtainActiveOrderInState$1 = new Function1<OrderDetails, ActiveOrderDetails>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils$obtainActiveOrderInState$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ActiveOrderDetails invoke(OrderDetails it) {
                Intrinsics.f(it, "it");
                return (ActiveOrderDetails) it;
            }
        };
        Single x7 = r7.x(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.l
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ActiveOrderDetails q8;
                q8 = OrderProviderUtils.q(Function1.this, obj);
                return q8;
            }
        });
        Intrinsics.e(x7, "obtainInState(*states).m…t as ActiveOrderDetails }");
        return x7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActiveOrderDetails q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ActiveOrderDetails) tmp0.invoke(obj);
    }

    public static final Single<OrderDetails> r(OrderProvider orderProvider, final OrderState... states) {
        Intrinsics.f(orderProvider, "<this>");
        Intrinsics.f(states, "states");
        return s(orderProvider, new Function1<OrderDetails, Boolean>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils$obtainInState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(OrderDetails order) {
                boolean z7;
                Intrinsics.f(order, "order");
                z7 = ArraysKt___ArraysKt.z(states, order.b());
                return Boolean.valueOf(z7);
            }
        });
    }

    public static final Single<OrderDetails> s(OrderProvider orderProvider, final Function1<? super OrderDetails, Boolean> predicate) {
        Intrinsics.f(orderProvider, "<this>");
        Intrinsics.f(predicate, "predicate");
        Single<List<OrderDetails>> firstOrError = orderProvider.a().firstOrError();
        final Function1<List<? extends OrderDetails>, OrderDetails> function1 = new Function1<List<? extends OrderDetails>, OrderDetails>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils$obtainOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final OrderDetails invoke(List<? extends OrderDetails> orders) {
                Intrinsics.f(orders, "orders");
                Function1<OrderDetails, Boolean> function12 = predicate;
                OrderDetails orderDetails = null;
                boolean z7 = false;
                for (Object obj : orders) {
                    if (((Boolean) function12.invoke(obj)).booleanValue()) {
                        if (!z7) {
                            z7 = true;
                            orderDetails = obj;
                        } else {
                            throw new IllegalArgumentException("Collection contains more than one matching element.");
                        }
                    }
                }
                if (z7) {
                    return orderDetails;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        };
        Single x7 = firstOrError.x(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                OrderDetails t7;
                t7 = OrderProviderUtils.t(Function1.this, obj);
                return t7;
            }
        });
        Intrinsics.e(x7, "predicate: (OrderDetails…rders.single(predicate) }");
        return x7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OrderDetails t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (OrderDetails) tmp0.invoke(obj);
    }

    public static final Single<ActiveOrderDetails> u(OrderProvider orderProvider, OrderState... states) {
        Intrinsics.f(orderProvider, "<this>");
        Intrinsics.f(states, "states");
        Single<OrderDetails> z7 = z(orderProvider, (OrderState[]) Arrays.copyOf(states, states.length));
        final OrderProviderUtils$waitForActiveOrderInState$1 orderProviderUtils$waitForActiveOrderInState$1 = new Function1<OrderDetails, ActiveOrderDetails>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils$waitForActiveOrderInState$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ActiveOrderDetails invoke(OrderDetails it) {
                Intrinsics.f(it, "it");
                return (ActiveOrderDetails) it;
            }
        };
        Single x7 = z7.x(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.j
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ActiveOrderDetails v7;
                v7 = OrderProviderUtils.v(Function1.this, obj);
                return v7;
            }
        });
        Intrinsics.e(x7, "waitForOrderInState(*sta…t as ActiveOrderDetails }");
        return x7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActiveOrderDetails v(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ActiveOrderDetails) tmp0.invoke(obj);
    }

    public static final Single<OrderDetails> w(OrderProvider orderProvider, final Function1<? super OrderDetails, Boolean> predicate) {
        Intrinsics.f(orderProvider, "<this>");
        Intrinsics.f(predicate, "predicate");
        Observable<List<OrderDetails>> a8 = orderProvider.a();
        final OrderProviderUtils$waitForOrder$1 orderProviderUtils$waitForOrder$1 = new Function1<List<? extends OrderDetails>, Iterable<? extends OrderDetails>>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils$waitForOrder$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Iterable<OrderDetails> invoke(List<? extends OrderDetails> it) {
                Intrinsics.f(it, "it");
                return it;
            }
        };
        Single<OrderDetails> firstOrError = a8.flatMapIterable(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Iterable x7;
                x7 = OrderProviderUtils.x(Function1.this, obj);
                return x7;
            }
        }).filter(new Predicate() { // from class: ee.mtakso.driver.service.modules.order.v2.h
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean y7;
                y7 = OrderProviderUtils.y(Function1.this, obj);
                return y7;
            }
        }).firstOrError();
        Intrinsics.e(firstOrError, "observeOrders().flatMapI…predicate).firstOrError()");
        return firstOrError;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable x(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Iterable) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public static final Single<OrderDetails> z(OrderProvider orderProvider, final OrderState... states) {
        Intrinsics.f(orderProvider, "<this>");
        Intrinsics.f(states, "states");
        return w(orderProvider, new Function1<OrderDetails, Boolean>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils$waitForOrderInState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(OrderDetails order) {
                boolean z7;
                Intrinsics.f(order, "order");
                z7 = ArraysKt___ArraysKt.z(states, order.b());
                return Boolean.valueOf(z7);
            }
        });
    }
}
