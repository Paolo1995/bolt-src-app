package ee.mtakso.driver.ui.screens.order.v2.order;

import android.content.Context;
import ee.mtakso.driver.R;
import ee.mtakso.driver.features.Feature;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.navigation.NavigationAppTypeFactory;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.driver.DriverOrderB2bState;
import ee.mtakso.driver.network.client.order.Order;
import ee.mtakso.driver.network.client.order.OrderKt;
import ee.mtakso.driver.network.client.order.PaymentType;
import ee.mtakso.driver.network.client.order.StopType;
import ee.mtakso.driver.network.client.order.UpcomingStop;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.b2b.B2bManager;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.modules.distance.OrderWithOptionalDistance;
import ee.mtakso.driver.service.modules.distance.UpcomingStopDistanceService;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.ActiveOrderDetailsKt;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetailsKt;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderData;
import eu.bolt.driver.core.time.AnchoredTimeSource;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: OrderStateDataInteractor.kt */
/* loaded from: classes3.dex */
public final class OrderStateDataInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final Context f32282a;

    /* renamed from: b  reason: collision with root package name */
    private final OrderProvider f32283b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverProvider f32284c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverDestinationsManager f32285d;

    /* renamed from: e  reason: collision with root package name */
    private final DriverFeatures f32286e;

    /* renamed from: f  reason: collision with root package name */
    private final Features f32287f;

    /* renamed from: g  reason: collision with root package name */
    private final B2bManager f32288g;

    /* renamed from: h  reason: collision with root package name */
    private final UpcomingStopDistanceService f32289h;

    /* renamed from: i  reason: collision with root package name */
    private final AnchoredTimeSource f32290i;

    /* renamed from: j  reason: collision with root package name */
    private final NavigationAppTypeFactory f32291j;

    /* compiled from: OrderStateDataInteractor.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32292a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f32293b;

        static {
            int[] iArr = new int[OrderState.values().length];
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_ACCEPTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OrderState.ORDER_STATE_WAITING_ON_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVING_WITH_CLIENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f32292a = iArr;
            int[] iArr2 = new int[DriverOrderB2bState.values().length];
            try {
                iArr2[DriverOrderB2bState.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[DriverOrderB2bState.INACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[DriverOrderB2bState.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            f32293b = iArr2;
        }
    }

    @Inject
    public OrderStateDataInteractor(Context context, OrderProvider orderProvider, DriverProvider driverProvider, DriverDestinationsManager destinationsManager, DriverFeatures driverFeatures, Features features, B2bManager b2bManager, UpcomingStopDistanceService distanceService, AnchoredTimeSource trueTimeProvider, NavigationAppTypeFactory navigationAppTypeFactory) {
        Intrinsics.f(context, "context");
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(destinationsManager, "destinationsManager");
        Intrinsics.f(driverFeatures, "driverFeatures");
        Intrinsics.f(features, "features");
        Intrinsics.f(b2bManager, "b2bManager");
        Intrinsics.f(distanceService, "distanceService");
        Intrinsics.f(trueTimeProvider, "trueTimeProvider");
        Intrinsics.f(navigationAppTypeFactory, "navigationAppTypeFactory");
        this.f32282a = context;
        this.f32283b = orderProvider;
        this.f32284c = driverProvider;
        this.f32285d = destinationsManager;
        this.f32286e = driverFeatures;
        this.f32287f = features;
        this.f32288g = b2bManager;
        this.f32289h = distanceService;
        this.f32290i = trueTimeProvider;
        this.f32291j = navigationAppTypeFactory;
    }

    private final List<UpcomingStop> h(ActiveOrderDetails activeOrderDetails) {
        boolean z7;
        List<UpcomingStop> H = activeOrderDetails.i().H();
        ArrayList arrayList = new ArrayList();
        for (Object obj : H) {
            if (((UpcomingStop) obj).f() == StopType.ARRIVAL) {
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

    private final BackToBackState i() {
        Boolean f8 = this.f32288g.f();
        if (Intrinsics.a(f8, Boolean.TRUE)) {
            return BackToBackState.ENABLED;
        }
        if (Intrinsics.a(f8, Boolean.FALSE)) {
            return BackToBackState.DISABLED;
        }
        if (f8 == null) {
            return BackToBackState.UNAVAILABLE;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final RideStep j(ActiveOrderDetails activeOrderDetails) {
        if (ActiveOrderDetailsKt.a(activeOrderDetails).size() == 1) {
            return RideStep.GOING_TO_FINAL_STOP;
        }
        return RideStep.GOING_TO_INTERMEDIATE_STOP;
    }

    private final OrderCommonData k(ActiveOrderDetails activeOrderDetails) {
        int i8;
        BackToBackState backToBackState;
        OrderHandle a8 = activeOrderDetails.a();
        Long c8 = activeOrderDetails.c();
        OrderState E = activeOrderDetails.i().E();
        GeoCoordinate b8 = OrderKt.b(activeOrderDetails.i());
        GeoCoordinate a9 = OrderKt.a(activeOrderDetails.i());
        String j8 = activeOrderDetails.i().j();
        boolean p8 = activeOrderDetails.p();
        DriverOrderB2bState g8 = activeOrderDetails.g();
        if (g8 == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f32293b[g8.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    backToBackState = BackToBackState.UNAVAILABLE;
                } else {
                    backToBackState = BackToBackState.UNAVAILABLE;
                }
            } else {
                backToBackState = BackToBackState.DISABLED;
            }
        } else {
            backToBackState = BackToBackState.ENABLED;
        }
        return new OrderCommonData(a8, c8, E, b8, a9, j8, p8, backToBackState, activeOrderDetails.i().F());
    }

    private final String l() {
        String a8;
        String name;
        if (this.f32286e.r()) {
            NavigationOption a9 = this.f32284c.v().I().a();
            if (a9 == null || (name = a9.getName()) == null) {
                String string = this.f32282a.getString(R.string.active_ride_set_default_navigation);
                Intrinsics.e(string, "context.getString(R.stri…e_set_default_navigation)");
                return string;
            }
            return name;
        }
        Navigator.Type a10 = this.f32284c.t().r().a();
        if (a10 == Navigator.Type.NO_NAVIGATION_SELECTED) {
            a8 = this.f32282a.getString(R.string.active_ride_set_default_navigation);
        } else {
            a8 = this.f32291j.c(a10).a(this.f32282a);
        }
        Intrinsics.e(a8, "if (navigationType == Na…veName(context)\n        }");
        return a8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OrderData m(List<? extends OrderDetails> list, double d8) {
        String str;
        String str2;
        boolean y7;
        boolean y8;
        long j8;
        boolean y9;
        boolean y10;
        ActiveOrderDetails q8 = q(list);
        if (q8 != null) {
            ActiveOrderDetails r7 = r(list);
            int i8 = WhenMappings.f32292a[q8.i().E().ordinal()];
            boolean z7 = true;
            String str3 = null;
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 == 4) {
                            Long o8 = q8.o();
                            String d9 = OrderKt.d(q8.i());
                            if (d9 != null) {
                                y10 = StringsKt__StringsJVMKt.y(d9);
                                if (!y10) {
                                    str3 = d9;
                                }
                            }
                            String str4 = str3;
                            RideStep j9 = j(q8);
                            PaymentType r8 = q8.i().r();
                            if (r8 != null) {
                                return new OrderData.DrivingWithClientData(o8, str4, j9, r8, OrderKt.g(q8.i()), n(q8, r7), k(q8));
                            }
                            throw new IllegalStateException("State should have payment type");
                        }
                        throw new IllegalStateException("Illegal order state: " + q8.i().E());
                    }
                    Long m8 = q8.m();
                    if (m8 != null) {
                        j8 = m8.longValue();
                    } else {
                        j8 = 0;
                    }
                    long j10 = j8;
                    String j11 = q8.j();
                    if (j11 == null) {
                        j11 = "";
                    }
                    String str5 = j11;
                    String d10 = OrderKt.d(q8.i());
                    if (d10 != null) {
                        y9 = StringsKt__StringsJVMKt.y(d10);
                        if (!y9) {
                            str3 = d10;
                        }
                    }
                    String str6 = str3;
                    PaymentType r9 = q8.i().r();
                    if (r9 == null) {
                        r9 = PaymentType.UNKNOWN;
                    }
                    return new OrderData.WaitingOnStopData(j10, str5, str6, r9, n(q8, r7), k(q8));
                }
                String e8 = q8.i().e();
                String f8 = OrderKt.f(q8.i());
                String g8 = q8.i().g();
                String d11 = OrderKt.d(q8.i());
                if (d11 != null) {
                    y8 = StringsKt__StringsJVMKt.y(d11);
                    if (!y8) {
                        str3 = d11;
                    }
                }
                return new OrderData.WaitingForClientData(e8, f8, g8, str3, p(q8), q8.i().d(), o(q8), k(q8));
            }
            String y11 = y(q8.i(), d8);
            Long n8 = q8.n();
            String d12 = OrderKt.d(q8.i());
            if (d12 != null) {
                y7 = StringsKt__StringsJVMKt.y(d12);
                if (y7) {
                    d12 = null;
                }
                str = d12;
            } else {
                str = null;
            }
            String e9 = q8.i().e();
            String f9 = OrderKt.f(q8.i());
            String g9 = q8.i().g();
            String d13 = q8.i().d();
            if (d13 != null) {
                if (y11 != null) {
                    z7 = false;
                }
                if (z7) {
                    str2 = d13;
                    return new OrderData.GoingToPickupData(n8, str, e9, f9, g9, y11, str2, o(q8), k(q8));
                }
            }
            str2 = null;
            return new OrderData.GoingToPickupData(n8, str, e9, f9, g9, y11, str2, o(q8), k(q8));
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final OrderMenuData n(ActiveOrderDetails activeOrderDetails, ActiveOrderDetails activeOrderDetails2) {
        boolean z7;
        boolean z8;
        String str;
        List<UpcomingStop> h8;
        Object W;
        String e8 = activeOrderDetails.i().e();
        String l8 = l();
        List<UpcomingStop> h9 = h(activeOrderDetails);
        if (this.f32287f.b(Feature.Type.CALCULATE_CURRENT_PRICE) && activeOrderDetails.i().t()) {
            z7 = true;
        } else {
            z7 = false;
        }
        boolean J = this.f32284c.m().J();
        boolean m8 = this.f32284c.m().m();
        boolean E = this.f32285d.E();
        if (ActiveOrderDetailsKt.a(activeOrderDetails).size() > 1) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (activeOrderDetails2 != null && (h8 = h(activeOrderDetails2)) != null) {
            W = CollectionsKt___CollectionsKt.W(h8);
            UpcomingStop upcomingStop = (UpcomingStop) W;
            if (upcomingStop != null) {
                str = upcomingStop.a();
                return new OrderMenuData(e8, l8, h9, false, z7, J, m8, E, z8, str, i(), this.f32286e.L(), activeOrderDetails.i().x(), activeOrderDetails.i().n(), activeOrderDetails.i().o(), activeOrderDetails.i().m(), null);
            }
        }
        str = null;
        return new OrderMenuData(e8, l8, h9, false, z7, J, m8, E, z8, str, i(), this.f32286e.L(), activeOrderDetails.i().x(), activeOrderDetails.i().n(), activeOrderDetails.i().o(), activeOrderDetails.i().m(), null);
    }

    private final OrderMenuData o(ActiveOrderDetails activeOrderDetails) {
        List k8;
        String e8 = activeOrderDetails.i().e();
        String l8 = l();
        k8 = CollectionsKt__CollectionsKt.k();
        return new OrderMenuData(e8, l8, k8, true, false, this.f32284c.m().J(), this.f32284c.m().m(), false, false, null, i(), this.f32286e.L(), activeOrderDetails.i().x(), activeOrderDetails.i().n(), activeOrderDetails.i().o(), activeOrderDetails.i().m(), activeOrderDetails.i().v());
    }

    private final OrderData.WaitingForClientData.WaitingTime p(ActiveOrderDetails activeOrderDetails) {
        long l8;
        Long s7 = activeOrderDetails.i().s();
        long b8 = this.f32290i.b();
        Integer k8 = activeOrderDetails.i().k();
        if (s7 != null && s7.longValue() > b8) {
            return OrderData.WaitingForClientData.WaitingTime.PickUp.b(OrderData.WaitingForClientData.WaitingTime.PickUp.c(s7.longValue() - b8));
        }
        if (k8 != null && activeOrderDetails.l() > k8.intValue()) {
            return OrderData.WaitingForClientData.WaitingTime.Paid.b(OrderData.WaitingForClientData.WaitingTime.Paid.c(Math.abs(activeOrderDetails.l() - k8.intValue())));
        }
        if (k8 != null) {
            l8 = Math.abs(activeOrderDetails.l() - k8.intValue());
        } else {
            l8 = activeOrderDetails.l();
        }
        return OrderData.WaitingForClientData.WaitingTime.Free.b(OrderData.WaitingForClientData.WaitingTime.Free.c(l8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActiveOrderDetails q(List<? extends OrderDetails> list) {
        int v7;
        Object obj;
        boolean z7;
        ArrayList<OrderDetails> arrayList = new ArrayList();
        for (Object obj2 : list) {
            OrderDetails orderDetails = (OrderDetails) obj2;
            if (!OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_DRIVER_ACCEPTED) && !OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT) && !OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_DRIVING_WITH_CLIENT) && !OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_WAITING_ON_STOP)) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (z7) {
                arrayList.add(obj2);
            }
        }
        v7 = CollectionsKt__IterablesKt.v(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(v7);
        for (OrderDetails orderDetails2 : arrayList) {
            Intrinsics.d(orderDetails2, "null cannot be cast to non-null type ee.mtakso.driver.service.order.details.ActiveOrderDetails");
            arrayList2.add((ActiveOrderDetails) orderDetails2);
        }
        Iterator it = arrayList2.iterator();
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

    private final ActiveOrderDetails r(List<? extends OrderDetails> list) {
        Object obj;
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (OrderDetailsKt.a((OrderDetails) obj, OrderState.ORDER_STATE_DRIVER_ACCEPTED)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (!(obj instanceof ActiveOrderDetails)) {
            return null;
        }
        return (ActiveOrderDetails) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Double) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.s(obj, obj2)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair v(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Pair) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OrderData x(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (OrderData) tmp0.invoke(obj);
    }

    private final String y(Order order, double d8) {
        if (d8 < 200.0d) {
            return order.C();
        }
        return null;
    }

    public Observable<OrderData> s() {
        Observable<List<OrderDetails>> a8 = this.f32283b.a();
        Observable<OrderWithOptionalDistance> c8 = this.f32289h.c();
        final OrderStateDataInteractor$observeScreenData$1 orderStateDataInteractor$observeScreenData$1 = new Function1<OrderWithOptionalDistance, Double>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.OrderStateDataInteractor$observeScreenData$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Double invoke(OrderWithOptionalDistance it) {
                double d8;
                Intrinsics.f(it, "it");
                Double a9 = it.a();
                if (a9 != null) {
                    d8 = a9.doubleValue();
                } else {
                    d8 = Double.MAX_VALUE;
                }
                return Double.valueOf(d8);
            }
        };
        Observable<R> map = c8.map(new Function() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.m
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Double t7;
                t7 = OrderStateDataInteractor.t(Function1.this, obj);
                return t7;
            }
        });
        final OrderStateDataInteractor$observeScreenData$2 orderStateDataInteractor$observeScreenData$2 = new Function2<Double, Double, Boolean>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.OrderStateDataInteractor$observeScreenData$2
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final Boolean s(Double oldDst, Double newDst) {
                boolean z7;
                Intrinsics.f(oldDst, "oldDst");
                Intrinsics.f(newDst, "newDst");
                if (Math.abs(oldDst.doubleValue() - newDst.doubleValue()) < 10.0d) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable distinctUntilChanged = map.distinctUntilChanged(new BiPredicate() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.n
            @Override // io.reactivex.functions.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                boolean u7;
                u7 = OrderStateDataInteractor.u(Function2.this, obj, obj2);
                return u7;
            }
        });
        final OrderStateDataInteractor$observeScreenData$3 orderStateDataInteractor$observeScreenData$3 = new Function2<List<? extends OrderDetails>, Double, Pair<? extends List<? extends OrderDetails>, ? extends Double>>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.OrderStateDataInteractor$observeScreenData$3
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final Pair<List<OrderDetails>, Double> s(List<? extends OrderDetails> orders, Double distance) {
                Intrinsics.f(orders, "orders");
                Intrinsics.f(distance, "distance");
                return new Pair<>(orders, distance);
            }
        };
        Observable combineLatest = Observable.combineLatest(a8, distinctUntilChanged, new BiFunction() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.o
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Pair v7;
                v7 = OrderStateDataInteractor.v(Function2.this, obj, obj2);
                return v7;
            }
        });
        final Function1<Pair<? extends List<? extends OrderDetails>, ? extends Double>, Boolean> function1 = new Function1<Pair<? extends List<? extends OrderDetails>, ? extends Double>, Boolean>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.OrderStateDataInteractor$observeScreenData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(Pair<? extends List<? extends OrderDetails>, Double> orderWithDistance) {
                ActiveOrderDetails q8;
                boolean z7;
                Intrinsics.f(orderWithDistance, "orderWithDistance");
                OrderStateDataInteractor orderStateDataInteractor = OrderStateDataInteractor.this;
                List<? extends OrderDetails> d8 = orderWithDistance.d();
                Intrinsics.e(d8, "orderWithDistance.first");
                q8 = orderStateDataInteractor.q(d8);
                if (q8 != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable filter = combineLatest.filter(new Predicate() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.p
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean w7;
                w7 = OrderStateDataInteractor.w(Function1.this, obj);
                return w7;
            }
        });
        final Function1<Pair<? extends List<? extends OrderDetails>, ? extends Double>, OrderData> function12 = new Function1<Pair<? extends List<? extends OrderDetails>, ? extends Double>, OrderData>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.OrderStateDataInteractor$observeScreenData$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final OrderData invoke(Pair<? extends List<? extends OrderDetails>, Double> orderWithDistance) {
                OrderData m8;
                Intrinsics.f(orderWithDistance, "orderWithDistance");
                OrderStateDataInteractor orderStateDataInteractor = OrderStateDataInteractor.this;
                List<? extends OrderDetails> d8 = orderWithDistance.d();
                Intrinsics.e(d8, "orderWithDistance.first");
                Double e8 = orderWithDistance.e();
                Intrinsics.e(e8, "orderWithDistance.second");
                m8 = orderStateDataInteractor.m(d8, e8.doubleValue());
                return m8;
            }
        };
        Observable<OrderData> map2 = filter.map(new Function() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.q
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                OrderData x7;
                x7 = OrderStateDataInteractor.x(Function1.this, obj);
                return x7;
            }
        });
        Intrinsics.e(map2, "override fun observeScre…    )\n            }\n    }");
        return map2;
    }
}
