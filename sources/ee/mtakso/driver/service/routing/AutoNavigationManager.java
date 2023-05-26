package ee.mtakso.driver.service.routing;

import android.app.Activity;
import ee.mtakso.driver.navigation.NavigationManager;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.order.Order;
import ee.mtakso.driver.network.client.order.OrderKt;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetailsKt;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption;
import ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity;
import ee.mtakso.driver.utils.BackgroundManager;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import eu.bolt.kalev.Kalev;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AutoNavigationManager.kt */
/* loaded from: classes3.dex */
public final class AutoNavigationManager {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f25872a;

    /* renamed from: b  reason: collision with root package name */
    private final NavigationManager f25873b;

    /* renamed from: c  reason: collision with root package name */
    private final BackgroundManager f25874c;

    /* renamed from: d  reason: collision with root package name */
    private final RoutingManager f25875d;

    /* renamed from: e  reason: collision with root package name */
    private final OrderAnalytics f25876e;

    /* renamed from: f  reason: collision with root package name */
    private List<ActiveOrderDetails> f25877f;

    /* compiled from: AutoNavigationManager.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25878a;

        static {
            int[] iArr = new int[OrderState.values().length];
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_ACCEPTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVING_WITH_CLIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OrderState.ORDER_STATE_WAITING_ON_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f25878a = iArr;
        }
    }

    @Inject
    public AutoNavigationManager(DriverProvider driverProvider, NavigationManager navigationManager, BackgroundManager backgroundManager, RoutingManager routingManager, OrderAnalytics orderAnalytics) {
        List<ActiveOrderDetails> k8;
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(navigationManager, "navigationManager");
        Intrinsics.f(backgroundManager, "backgroundManager");
        Intrinsics.f(routingManager, "routingManager");
        Intrinsics.f(orderAnalytics, "orderAnalytics");
        this.f25872a = driverProvider;
        this.f25873b = navigationManager;
        this.f25874c = backgroundManager;
        this.f25875d = routingManager;
        this.f25876e = orderAnalytics;
        k8 = CollectionsKt__CollectionsKt.k();
        this.f25877f = k8;
    }

    private final ActiveOrderDetails a(List<ActiveOrderDetails> list, List<ActiveOrderDetails> list2) {
        if (!this.f25872a.t().f().a()) {
            return null;
        }
        ActiveOrderDetails c8 = c(OrderProviderUtils.i(list), OrderProviderUtils.i(list2));
        if (c8 == null) {
            return b(list, list2);
        }
        return c8;
    }

    private final ActiveOrderDetails b(List<ActiveOrderDetails> list, List<ActiveOrderDetails> list2) {
        Object obj;
        Object obj2;
        Object obj3;
        Iterator<T> it = list.iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                if (OrderDetailsKt.a((ActiveOrderDetails) obj2, OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION)) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        ActiveOrderDetails activeOrderDetails = (ActiveOrderDetails) obj2;
        Iterator<T> it2 = list2.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj3 = it2.next();
                if (OrderDetailsKt.a((ActiveOrderDetails) obj3, OrderState.ORDER_STATE_DRIVER_ACCEPTED)) {
                    break;
                }
            } else {
                obj3 = null;
                break;
            }
        }
        ActiveOrderDetails activeOrderDetails2 = (ActiveOrderDetails) obj3;
        if (activeOrderDetails != null && activeOrderDetails2 != null) {
            Kalev.b("B2B acceptance detected");
            Iterator<T> it3 = list2.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next = it3.next();
                if (!OrderDetailsKt.a((ActiveOrderDetails) next, OrderState.ORDER_STATE_DRIVER_ACCEPTED)) {
                    obj = next;
                    break;
                }
            }
            return (ActiveOrderDetails) obj;
        } else if (list.size() != 2 || list2.size() != 1) {
            return null;
        } else {
            int i8 = WhenMappings.f25878a[list2.get(0).b().ordinal()];
            if (i8 != 1) {
                if (i8 != 2 && i8 != 3) {
                    Kalev.b("Order finish detected with b2b");
                    return list2.get(0);
                }
                Kalev.b("Missed b2b order detected");
                return list2.get(0);
            }
            Kalev.b("Order finish detected with b2b");
            return list2.get(0);
        }
    }

    private final ActiveOrderDetails c(ActiveOrderDetails activeOrderDetails, ActiveOrderDetails activeOrderDetails2) {
        GeoCoordinate geoCoordinate;
        boolean z7;
        boolean z8;
        Order i8;
        if (activeOrderDetails == null) {
            return null;
        }
        if (activeOrderDetails2 != null && (i8 = activeOrderDetails2.i()) != null) {
            geoCoordinate = OrderKt.b(i8);
        } else {
            geoCoordinate = null;
        }
        if (geoCoordinate == null || !Intrinsics.a(activeOrderDetails.a(), activeOrderDetails2.a())) {
            return null;
        }
        OrderState orderState = OrderState.ORDER_STATE_DRIVER_ACCEPTED;
        boolean z9 = false;
        if (!OrderDetailsKt.a(activeOrderDetails2, orderState) && !OrderDetailsKt.a(activeOrderDetails2, OrderState.ORDER_STATE_DRIVING_WITH_CLIENT)) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (!z7) {
            return null;
        }
        if (OrderDetailsKt.a(activeOrderDetails, OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION) && OrderDetailsKt.a(activeOrderDetails2, orderState)) {
            Kalev.b("Order acceptance detected");
            return activeOrderDetails2;
        } else if (OrderDetailsKt.a(activeOrderDetails, OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT) && OrderDetailsKt.a(activeOrderDetails2, OrderState.ORDER_STATE_DRIVING_WITH_CLIENT)) {
            Kalev.b("Start of ride detected");
            return activeOrderDetails2;
        } else {
            if (!activeOrderDetails.p() && activeOrderDetails.q()) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (activeOrderDetails2.p() && !activeOrderDetails2.q()) {
                z9 = true;
            }
            if (z8 && z9 && this.f25874c.e()) {
                Kalev.b("Driver have read message");
                return activeOrderDetails2;
            } else if (Intrinsics.a(OrderKt.b(activeOrderDetails.i()), OrderKt.b(activeOrderDetails2.i())) || !Intrinsics.a(activeOrderDetails.a(), activeOrderDetails2.a())) {
                return null;
            } else {
                Kalev.b("Destination change detected");
                return activeOrderDetails2;
            }
        }
    }

    public final void d(List<ActiveOrderDetails> orders) {
        String str;
        Object obj;
        Class<? extends Activity> cls;
        Intrinsics.f(orders, "orders");
        Iterator<T> it = orders.iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                if (OrderDetailsKt.a((ActiveOrderDetails) obj, OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            this.f25877f = orders;
            return;
        }
        RoutingState f8 = this.f25875d.f();
        if (f8 != null) {
            cls = f8.a();
        } else {
            cls = null;
        }
        if (Intrinsics.a(cls, ActiveRideActivity.class)) {
            ActiveOrderDetails a8 = a(this.f25877f, orders);
            if (a8 != null) {
                if (this.f25872a.q().r()) {
                    NavigationOption a9 = this.f25872a.v().I().a();
                    if (a9 != null) {
                        str = a9.getName();
                    }
                } else {
                    str = this.f25872a.t().r().a().e();
                }
                this.f25876e.d4(a8.b(), str, String.valueOf(a8.a().b()), this.f25872a.m().C(), true);
                GeoCoordinate a10 = OrderKt.a(a8.i());
                if (a10 == null) {
                    a10 = OrderKt.b(a8.i());
                }
                if (a10 != null) {
                    this.f25873b.a(a10);
                }
            }
            this.f25877f = orders;
        }
    }
}
