package ee.mtakso.driver.ui.screens.order.v2.order;

import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.order.OrderKt;
import ee.mtakso.driver.network.client.order.PaymentType;
import ee.mtakso.driver.network.client.order.UpcomingStop;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.distance.OrderWithDistance;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.ActiveOrderDetailsKt;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.android.maps.core.GeoUtils;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheetStateInteractor.kt */
/* loaded from: classes3.dex */
public final class BottomSheetStateInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final OrderProvider f32182a;

    /* renamed from: b  reason: collision with root package name */
    private final GeoLocationManager f32183b;

    /* renamed from: c  reason: collision with root package name */
    private OrderState f32184c;

    /* compiled from: BottomSheetStateInteractor.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32185a;

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
                iArr[OrderState.ORDER_STATE_DRIVING_WITH_CLIENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OrderState.ORDER_STATE_WAITING_ON_STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f32185a = iArr;
        }
    }

    @Inject
    public BottomSheetStateInteractor(OrderProvider orderProvider, GeoLocationManager locationManager) {
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(locationManager, "locationManager");
        this.f32182a = orderProvider;
        this.f32183b = locationManager;
    }

    private final BottomWidgetStates d(OrderWithDistance orderWithDistance, boolean z7) {
        double d8;
        BottomBarState bottomBarState;
        SwipeButtonState swipeButtonState;
        long j8;
        int size = ActiveOrderDetailsKt.a(orderWithDistance.b()).size();
        if (size != 0 && size != 1) {
            d8 = 500.0d;
        } else {
            d8 = 200.0d;
        }
        if (orderWithDistance.a() < d8) {
            bottomBarState = BottomBarState.EXPANDED;
        } else {
            bottomBarState = BottomBarState.COLLAPSED;
        }
        BottomBarState bottomBarState2 = bottomBarState;
        int size2 = ActiveOrderDetailsKt.a(orderWithDistance.b()).size();
        if (size2 != 0) {
            if (size2 != 1) {
                if (orderWithDistance.a() < d8) {
                    swipeButtonState = SwipeButtonState.DRIVING_TO_WAITING_POINT;
                } else {
                    swipeButtonState = SwipeButtonState.DISCLAIMER;
                }
            } else {
                swipeButtonState = SwipeButtonState.DRIVING_TO_FINAL_POINT;
            }
        } else {
            swipeButtonState = SwipeButtonState.DRIVING_TO_FINAL_POINT;
        }
        SwipeButtonState swipeButtonState2 = swipeButtonState;
        PaymentType r7 = orderWithDistance.b().i().r();
        UpcomingStop upcomingStop = (UpcomingStop) CollectionsKt___CollectionsKt.Y(ActiveOrderDetailsKt.a(orderWithDistance.b()));
        if (upcomingStop != null) {
            j8 = upcomingStop.b();
        } else {
            j8 = -1;
        }
        return new BottomWidgetStates(z7, bottomBarState2, swipeButtonState2, null, r7, j8);
    }

    private final BottomWidgetStates e(OrderWithDistance orderWithDistance, boolean z7) {
        long j8;
        BottomBarState bottomBarState = BottomBarState.EXPANDED;
        SwipeButtonState swipeButtonState = SwipeButtonState.STAYING_AT_WAITING_POINT;
        PaymentType r7 = orderWithDistance.b().i().r();
        UpcomingStop upcomingStop = (UpcomingStop) CollectionsKt___CollectionsKt.Y(ActiveOrderDetailsKt.a(orderWithDistance.b()));
        if (upcomingStop != null) {
            j8 = upcomingStop.b();
        } else {
            j8 = -1;
        }
        return new BottomWidgetStates(z7, bottomBarState, swipeButtonState, null, r7, j8);
    }

    private final BottomWidgetStates f(OrderWithDistance orderWithDistance, boolean z7) {
        BottomBarState bottomBarState;
        long j8;
        if (orderWithDistance.a() < 200.0d) {
            bottomBarState = BottomBarState.EXPANDED;
        } else {
            bottomBarState = BottomBarState.COLLAPSED;
        }
        BottomBarState bottomBarState2 = bottomBarState;
        SwipeButtonState swipeButtonState = SwipeButtonState.DRIVING_TO_PICKUP;
        UpcomingStop upcomingStop = (UpcomingStop) CollectionsKt___CollectionsKt.Y(ActiveOrderDetailsKt.a(orderWithDistance.b()));
        if (upcomingStop != null) {
            j8 = upcomingStop.b();
        } else {
            j8 = -1;
        }
        return new BottomWidgetStates(z7, bottomBarState2, swipeButtonState, null, null, j8);
    }

    private final Observable<ActiveOrderDetails> g() {
        return ObservableExtKt.k(this.f32182a.a(), new Function1<List<? extends OrderDetails>, ActiveOrderDetails>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.BottomSheetStateInteractor$observeActiveOrder$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ActiveOrderDetails invoke(List<? extends OrderDetails> orders) {
                Intrinsics.f(orders, "orders");
                return OrderProviderUtils.j(orders);
            }
        });
    }

    private final Observable<GeoLocation> h() {
        return this.f32183b.u(1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OrderWithDistance j(GeoLocation location, ActiveOrderDetails order) {
        Intrinsics.f(location, "location");
        Intrinsics.f(order, "order");
        GeoCoordinate b8 = OrderKt.b(order.i());
        if (b8 == null) {
            return new OrderWithDistance(order, Double.MAX_VALUE);
        }
        return new OrderWithDistance(order, GeoUtils.f36938a.f(location.e(), b8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BottomWidgetStates k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (BottomWidgetStates) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BottomWidgetStates l(OrderWithDistance orderWithDistance) {
        boolean z7;
        BottomWidgetStates f8;
        if (orderWithDistance.b().i().E() != this.f32184c) {
            z7 = true;
        } else {
            z7 = false;
        }
        int i8 = WhenMappings.f32185a[orderWithDistance.b().i().E().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        OrderState E = orderWithDistance.b().i().E();
                        Kalev.d("Unexpected order state: " + E);
                        f8 = new BottomWidgetStates(z7, BottomBarState.COLLAPSED, SwipeButtonState.DRIVING_TO_PICKUP, null, null, -1L);
                    } else {
                        f8 = e(orderWithDistance, z7);
                    }
                } else {
                    f8 = d(orderWithDistance, z7);
                }
            } else {
                f8 = new BottomWidgetStates(z7, BottomBarState.EXPANDED, SwipeButtonState.WAITING_FOR_CLIENT, null, null, -1L);
            }
        } else {
            f8 = f(orderWithDistance, z7);
        }
        this.f32184c = orderWithDistance.b().i().E();
        return f8;
    }

    public Observable<BottomWidgetStates> i() {
        Observable combineLatest = Observable.combineLatest(h(), g(), new BiFunction() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.d
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                OrderWithDistance j8;
                j8 = BottomSheetStateInteractor.j((GeoLocation) obj, (ActiveOrderDetails) obj2);
                return j8;
            }
        });
        final Function1<OrderWithDistance, BottomWidgetStates> function1 = new Function1<OrderWithDistance, BottomWidgetStates>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.BottomSheetStateInteractor$observeScreenData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final BottomWidgetStates invoke(OrderWithDistance it) {
                BottomWidgetStates l8;
                Intrinsics.f(it, "it");
                l8 = BottomSheetStateInteractor.this.l(it);
                return l8;
            }
        };
        Observable<BottomWidgetStates> distinctUntilChanged = combineLatest.map(new Function() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                BottomWidgetStates k8;
                k8 = BottomSheetStateInteractor.k(Function1.this, obj);
                return k8;
            }
        }).distinctUntilChanged();
        Intrinsics.e(distinctUntilChanged, "override fun observeScre…tinctUntilChanged()\n    }");
        return distinctUntilChanged;
    }
}
