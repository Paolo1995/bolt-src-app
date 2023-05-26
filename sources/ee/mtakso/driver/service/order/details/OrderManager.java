package ee.mtakso.driver.service.order.details;

import androidx.fragment.app.FragmentTransaction;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.driver.OrderSummary;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.network.client.order.DriverOrderClient;
import ee.mtakso.driver.network.client.order.Order;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.network.client.order.OrderCompletionReason;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.utils.RetryWithDelaySingle;
import ee.mtakso.driver.utils.SingleExtKt;
import ee.mtakso.driver.utils.coroutines.DispatcherProvider;
import ee.mtakso.driver.utils.coroutines.ScopeProvider;
import eu.bolt.driver.core.util.AssertUtils;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* compiled from: OrderManager.kt */
/* loaded from: classes3.dex */
public final class OrderManager {

    /* renamed from: a  reason: collision with root package name */
    private final DispatcherProvider f25431a;

    /* renamed from: b  reason: collision with root package name */
    private final OrderClient f25432b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverOrderClient f25433c;

    /* renamed from: d  reason: collision with root package name */
    private final OrdersCache f25434d;

    /* renamed from: e  reason: collision with root package name */
    private final TrueTimeProvider f25435e;

    /* renamed from: f  reason: collision with root package name */
    private final OrderTryAgainManager f25436f;

    /* renamed from: g  reason: collision with root package name */
    private final CoroutineScope f25437g;

    /* renamed from: h  reason: collision with root package name */
    private final ConcurrentHashMap<OrderHandle, Job> f25438h;

    /* renamed from: i  reason: collision with root package name */
    private PollingResult f25439i;

    /* compiled from: OrderManager.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25440a;

        static {
            int[] iArr = new int[OrderState.values().length];
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_DID_NOT_RESPOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OrderState.ORDER_STATE_ARRIVED_TO_DESTINATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVING_WITH_CLIENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[OrderState.ORDER_STATE_WAITING_ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_ACCEPTED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_REJECTED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[OrderState.ORDER_STATE_CLIENT_CANCELLED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[OrderState.ORDER_STATE_PAYMENT_BOOKING_FAILED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[OrderState.ORDER_STATE_CLIENT_DID_NOT_SHOW.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[OrderState.ORDER_STATE_FINISHED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[OrderState.ORDER_STATE_UNKNOWN.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            f25440a = iArr;
        }
    }

    @Inject
    public OrderManager(ScopeProvider scopeProvider, DispatcherProvider dispatcherProvider, OrderClient apiClient, DriverOrderClient driverOrderClient, OrdersCache cache, TrueTimeProvider trueTimeProvider, OrderTryAgainManager orderTryAgainManager) {
        Intrinsics.f(scopeProvider, "scopeProvider");
        Intrinsics.f(dispatcherProvider, "dispatcherProvider");
        Intrinsics.f(apiClient, "apiClient");
        Intrinsics.f(driverOrderClient, "driverOrderClient");
        Intrinsics.f(cache, "cache");
        Intrinsics.f(trueTimeProvider, "trueTimeProvider");
        Intrinsics.f(orderTryAgainManager, "orderTryAgainManager");
        this.f25431a = dispatcherProvider;
        this.f25432b = apiClient;
        this.f25433c = driverOrderClient;
        this.f25434d = cache;
        this.f25435e = trueTimeProvider;
        this.f25436f = orderTryAgainManager;
        this.f25437g = scopeProvider.a(dispatcherProvider.a());
        this.f25438h = new ConcurrentHashMap<>();
    }

    private final OrderDetails i(OrderSummary orderSummary, Order order, OrderDetails orderDetails) {
        OrderDetailsBuilder orderDetailsBuilder = new OrderDetailsBuilder(orderSummary, order);
        if (orderDetails != null && (orderDetails instanceof ActiveOrderDetails)) {
            ActiveOrderDetails activeOrderDetails = (ActiveOrderDetails) orderDetails;
            boolean z7 = true;
            boolean z8 = !Intrinsics.a(order.j(), activeOrderDetails.i().j());
            orderDetailsBuilder.d(z8);
            orderDetailsBuilder.c((z8 || !activeOrderDetails.p()) ? false : false);
            if (order.E() == OrderState.ORDER_STATE_WAITING_ON_STOP) {
                orderDetailsBuilder.g(activeOrderDetails.m());
                orderDetailsBuilder.e(activeOrderDetails.j());
            }
        }
        orderDetailsBuilder.b(order.h());
        int i8 = WhenMappings.f25440a[orderSummary.f().ordinal()];
        if (i8 != 2) {
            if (i8 != 4) {
                if (i8 != 6) {
                    if (i8 == 7) {
                        orderDetailsBuilder.h(orderSummary.d());
                    }
                } else {
                    orderDetailsBuilder.f(order.A());
                }
            } else {
                orderDetailsBuilder.i(orderSummary.e());
            }
        } else {
            orderDetailsBuilder.h(orderSummary.d());
        }
        orderDetailsBuilder.j(order.I() - this.f25435e.a());
        return orderDetailsBuilder.a();
    }

    private final void k(OrderSummary orderSummary) {
        Job d8;
        OrderHandle b8 = orderSummary.b();
        Kalev.k("Starting new Job");
        d8 = BuildersKt__Builders_commonKt.d(this.f25437g, null, null, new OrderManager$fetchActiveOrder$fetchJob$1(orderSummary, this, b8, null), 3, null);
        AssertUtils.e(AssertUtils.f41299a, d8.isActive(), null, 2, null);
        Kalev.k("Started new Job " + d8);
        this.f25438h.put(b8, d8);
    }

    private final void l(OrderSummary orderSummary) {
        ActiveOrderDetails activeOrderDetails;
        OrderDetails e8 = this.f25434d.e(orderSummary.b());
        if (e8 instanceof ActiveOrderDetails) {
            activeOrderDetails = (ActiveOrderDetails) e8;
        } else {
            activeOrderDetails = null;
        }
        if (activeOrderDetails != null) {
            this.f25434d.b(new FinishedOrderDetails(orderSummary, activeOrderDetails.i().q()));
        }
    }

    private final void m(OrderSummary orderSummary) {
        OrderHandle b8 = orderSummary.b();
        Job job = this.f25438h.get(b8);
        boolean z7 = true;
        if (!((job == null || !job.isActive()) ? false : false)) {
            switch (WhenMappings.f25440a[orderSummary.f().ordinal()]) {
                case 1:
                    n(orderSummary);
                    return;
                case 2:
                    k(orderSummary);
                    return;
                case 3:
                    k(orderSummary);
                    return;
                case 4:
                    k(orderSummary);
                    return;
                case 5:
                    k(orderSummary);
                    return;
                case 6:
                    k(orderSummary);
                    return;
                case 7:
                    k(orderSummary);
                    return;
                case 8:
                    n(orderSummary);
                    return;
                case 9:
                    n(orderSummary);
                    return;
                case 10:
                    n(orderSummary);
                    return;
                case 11:
                    n(orderSummary);
                    return;
                case 12:
                    l(orderSummary);
                    return;
                case 13:
                    k(orderSummary);
                    return;
                default:
                    return;
            }
        }
        Kalev.h("Order " + b8 + " already fetching");
    }

    private final Disposable n(final OrderSummary orderSummary) {
        Single<OrderCompletionReason> F = this.f25432b.z(orderSummary.b()).F(new RetryWithDelaySingle(5, 2000L));
        Intrinsics.e(F, "apiClient.getOrderComple…WithDelaySingle(5, 2000))");
        Single d8 = SingleExtKt.d(F);
        final Function1<OrderCompletionReason, Unit> function1 = new Function1<OrderCompletionReason, Unit>() { // from class: ee.mtakso.driver.service.order.details.OrderManager$fetchPastOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(OrderCompletionReason it) {
                OrderManager orderManager = OrderManager.this;
                OrderSummary orderSummary2 = orderSummary;
                Intrinsics.e(it, "it");
                orderManager.s(orderSummary2, it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OrderCompletionReason orderCompletionReason) {
                b(orderCompletionReason);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.order.details.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderManager.o(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.order.details.OrderManager$fetchPastOrder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                OrderManager orderManager = OrderManager.this;
                Intrinsics.e(it, "it");
                orderManager.r(it, orderSummary);
            }
        };
        Disposable I = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.order.details.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderManager.p(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "private fun fetchPastOrd…t, orderSummary) })\n    }");
        return I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(OrderSummary orderSummary, Order order) {
        List<OrderSummary> j8;
        Object obj;
        this.f25438h.remove(orderSummary.b());
        PollingResult pollingResult = this.f25439i;
        if (pollingResult != null && (j8 = pollingResult.j()) != null) {
            Iterator<T> it = j8.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.a(((OrderSummary) obj).b(), orderSummary.b())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (((OrderSummary) obj) != null) {
                OrdersCache ordersCache = this.f25434d;
                ordersCache.b(i(orderSummary, order, ordersCache.e(orderSummary.b())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(Throwable th, OrderSummary orderSummary) {
        Kalev.e(th, "Tried to fetch order but failed. Order " + orderSummary);
        this.f25434d.h(orderSummary.b());
        this.f25438h.remove(orderSummary.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(OrderSummary orderSummary, OrderCompletionReason orderCompletionReason) {
        List<OrderSummary> j8;
        Object obj;
        this.f25438h.remove(orderSummary.b());
        PollingResult pollingResult = this.f25439i;
        if (pollingResult != null && (j8 = pollingResult.j()) != null) {
            Iterator<T> it = j8.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.a(((OrderSummary) obj).b(), orderSummary.b())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (((OrderSummary) obj) != null) {
                this.f25434d.b(new PastOrderDetails(orderSummary, orderCompletionReason));
            }
        }
    }

    private final boolean u(OrderSummary orderSummary, OrderDetails orderDetails) {
        if (orderDetails == null || orderSummary.h() != orderDetails.d() || orderSummary.f() != orderDetails.b()) {
            return true;
        }
        return false;
    }

    private final void v(OrderSummary orderSummary) {
        ActiveOrderDetails activeOrderDetails;
        ActiveOrderDetails e8;
        ActiveOrderDetails e9;
        ActiveOrderDetails e10;
        OrderDetails e11 = this.f25434d.e(orderSummary.b());
        if (e11 instanceof ActiveOrderDetails) {
            activeOrderDetails = (ActiveOrderDetails) e11;
        } else {
            activeOrderDetails = null;
        }
        ActiveOrderDetails activeOrderDetails2 = activeOrderDetails;
        if (activeOrderDetails2 != null) {
            OrdersCache ordersCache = this.f25434d;
            e10 = activeOrderDetails2.e((r36 & 1) != 0 ? activeOrderDetails2.a() : null, (r36 & 2) != 0 ? activeOrderDetails2.d() : 0, (r36 & 4) != 0 ? activeOrderDetails2.b() : null, (r36 & 8) != 0 ? activeOrderDetails2.c() : null, (r36 & 16) != 0 ? activeOrderDetails2.f25399e : null, (r36 & 32) != 0 ? activeOrderDetails2.f25400f : 0L, (r36 & 64) != 0 ? activeOrderDetails2.f25401g : false, (r36 & 128) != 0 ? activeOrderDetails2.f25402h : false, (r36 & Spliterator.NONNULL) != 0 ? activeOrderDetails2.f25403i : null, (r36 & 512) != 0 ? activeOrderDetails2.f25404j : 0L, (r36 & Spliterator.IMMUTABLE) != 0 ? activeOrderDetails2.f25405k : null, (r36 & 2048) != 0 ? activeOrderDetails2.f25406l : null, (r36 & 4096) != 0 ? activeOrderDetails2.f25407m : null, (r36 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? activeOrderDetails2.f25408n : null, (r36 & 16384) != 0 ? activeOrderDetails2.f25409o : orderSummary.c(), (r36 & 32768) != 0 ? activeOrderDetails2.f25410p : orderSummary.a());
            ordersCache.b(e10);
        }
        ActiveOrderDetails d8 = this.f25434d.d(OrderState.ORDER_STATE_DRIVER_ACCEPTED);
        if (d8 != null && Intrinsics.a(d8.a(), orderSummary.b())) {
            OrdersCache ordersCache2 = this.f25434d;
            e9 = d8.e((r36 & 1) != 0 ? d8.a() : null, (r36 & 2) != 0 ? d8.d() : 0, (r36 & 4) != 0 ? d8.b() : null, (r36 & 8) != 0 ? d8.c() : null, (r36 & 16) != 0 ? d8.f25399e : null, (r36 & 32) != 0 ? d8.f25400f : 0L, (r36 & 64) != 0 ? d8.f25401g : false, (r36 & 128) != 0 ? d8.f25402h : false, (r36 & Spliterator.NONNULL) != 0 ? d8.f25403i : orderSummary.d(), (r36 & 512) != 0 ? d8.f25404j : 0L, (r36 & Spliterator.IMMUTABLE) != 0 ? d8.f25405k : null, (r36 & 2048) != 0 ? d8.f25406l : null, (r36 & 4096) != 0 ? d8.f25407m : null, (r36 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? d8.f25408n : null, (r36 & 16384) != 0 ? d8.f25409o : null, (r36 & 32768) != 0 ? d8.f25410p : orderSummary.a());
            ordersCache2.b(e9);
        }
        ActiveOrderDetails d9 = this.f25434d.d(OrderState.ORDER_STATE_DRIVING_WITH_CLIENT);
        if (d9 != null && Intrinsics.a(d9.a(), orderSummary.b())) {
            OrdersCache ordersCache3 = this.f25434d;
            e8 = d9.e((r36 & 1) != 0 ? d9.a() : null, (r36 & 2) != 0 ? d9.d() : 0, (r36 & 4) != 0 ? d9.b() : null, (r36 & 8) != 0 ? d9.c() : null, (r36 & 16) != 0 ? d9.f25399e : null, (r36 & 32) != 0 ? d9.f25400f : 0L, (r36 & 64) != 0 ? d9.f25401g : false, (r36 & 128) != 0 ? d9.f25402h : false, (r36 & Spliterator.NONNULL) != 0 ? d9.f25403i : null, (r36 & 512) != 0 ? d9.f25404j : 0L, (r36 & Spliterator.IMMUTABLE) != 0 ? d9.f25405k : orderSummary.e(), (r36 & 2048) != 0 ? d9.f25406l : null, (r36 & 4096) != 0 ? d9.f25407m : null, (r36 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? d9.f25408n : null, (r36 & 16384) != 0 ? d9.f25409o : null, (r36 & 32768) != 0 ? d9.f25410p : orderSummary.a());
            ordersCache3.b(e8);
        }
    }

    private final void w(OrderSummary orderSummary) {
        if (u(orderSummary, this.f25434d.e(orderSummary.b()))) {
            m(orderSummary);
        } else {
            v(orderSummary);
        }
    }

    public final void j() {
        CoroutineScopeKt.d(this.f25437g, null, 1, null);
    }

    public final void t() {
        OrderSummary orderSummary;
        List<OrderSummary> j8;
        Object obj;
        for (Map.Entry<OrderHandle, Job> entry : this.f25438h.entrySet()) {
            OrderHandle key = entry.getKey();
            Job value = entry.getValue();
            PollingResult pollingResult = this.f25439i;
            if (pollingResult != null && (j8 = pollingResult.j()) != null) {
                Iterator<T> it = j8.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.a(((OrderSummary) obj).b(), key)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                orderSummary = (OrderSummary) obj;
            } else {
                orderSummary = null;
            }
            if (orderSummary != null) {
                Job.DefaultImpls.a(value, null, 1, null);
                this.f25438h.remove(key);
                m(orderSummary);
            }
        }
    }

    public final void x(PollingResult pollingResult) {
        OrderSummary orderSummary;
        Object obj;
        Intrinsics.f(pollingResult, "pollingResult");
        Kalev.b("Processing polling result: " + pollingResult);
        this.f25439i = pollingResult;
        Iterator<Map.Entry<OrderHandle, Job>> it = this.f25438h.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<OrderHandle, Job> next = it.next();
            List<OrderSummary> j8 = pollingResult.j();
            if (j8 != null) {
                Iterator<T> it2 = j8.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        obj = it2.next();
                        if (Intrinsics.a(((OrderSummary) obj).b(), next.getKey())) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                orderSummary = (OrderSummary) obj;
            } else {
                orderSummary = null;
            }
            if (orderSummary == null) {
                Kalev.k("Cancelling Job Job " + next.getValue());
                Job.DefaultImpls.a(next.getValue(), null, 1, null);
                it.remove();
            }
        }
        List<OrderSummary> j9 = pollingResult.j();
        if (j9 != null) {
            for (OrderSummary orderSummary2 : j9) {
                w(orderSummary2);
            }
        }
    }
}
