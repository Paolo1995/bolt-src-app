package ee.mtakso.driver.ui.interactor.order;

import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetailsKt;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncomingOrderInteractor.kt */
/* loaded from: classes3.dex */
public final class IncomingOrderInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final OrderProvider f26699a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverDestinationsManager f26700b;

    /* renamed from: c  reason: collision with root package name */
    private final GeoLocationManager f26701c;

    @Inject
    public IncomingOrderInteractor(OrderProvider orderProvider, DriverDestinationsManager destinationManager, GeoLocationManager locationManager) {
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(destinationManager, "destinationManager");
        Intrinsics.f(locationManager, "locationManager");
        this.f26699a = orderProvider;
        this.f26700b = destinationManager;
        this.f26701c = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Optional<IncomingOrderDetails> g(List<? extends OrderDetails> list) {
        Object obj;
        Object obj2;
        ActiveOrderDetails activeOrderDetails;
        boolean z7;
        int i8;
        boolean z8;
        Iterator<T> it = list.iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                if (OrderDetailsKt.a((OrderDetails) obj2, OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION)) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        if (obj2 instanceof ActiveOrderDetails) {
            activeOrderDetails = (ActiveOrderDetails) obj2;
        } else {
            activeOrderDetails = null;
        }
        if (activeOrderDetails == null) {
            Optional<IncomingOrderDetails> a8 = Optional.a();
            Intrinsics.e(a8, "empty()");
            return a8;
        }
        Iterator<T> it2 = list.iterator();
        while (true) {
            z7 = false;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            OrderDetails orderDetails = (OrderDetails) next;
            if (!OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_DRIVING_WITH_CLIENT) && !OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_WAITING_ON_STOP)) {
                z8 = false;
                continue;
            } else {
                z8 = true;
                continue;
            }
            if (z8) {
                obj = next;
                break;
            }
        }
        if (obj != null) {
            z7 = true;
        }
        Long n8 = activeOrderDetails.n();
        if (n8 != null) {
            i8 = (int) TimeUnit.SECONDS.toMinutes(n8.longValue());
        } else {
            i8 = 1;
        }
        Optional<IncomingOrderDetails> f8 = Optional.f(new IncomingOrderDetails(activeOrderDetails.a(), activeOrderDetails.i(), z7, Math.max(1, i8)));
        Intrinsics.e(f8, "of(IncomingOrderDetails(…der, isB2B, max(1, eta)))");
        return f8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h() {
        return this.f26700b.E();
    }

    private final Observable<Optional<GeoLocation>> i() {
        Observable<GeoLocation> u7 = this.f26701c.u(5L);
        final IncomingOrderInteractor$observeDriverLocation$1 incomingOrderInteractor$observeDriverLocation$1 = new Function1<GeoLocation, Optional<GeoLocation>>() { // from class: ee.mtakso.driver.ui.interactor.order.IncomingOrderInteractor$observeDriverLocation$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<GeoLocation> invoke(GeoLocation it) {
                Intrinsics.f(it, "it");
                return Optional.f(it);
            }
        };
        Observable<Optional<GeoLocation>> startWith = u7.map(new Function() { // from class: ee.mtakso.driver.ui.interactor.order.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional j8;
                j8 = IncomingOrderInteractor.j(Function1.this, obj);
                return j8;
            }
        }).startWith((Observable<R>) Optional.a());
        Intrinsics.e(startWith, "locationManager.observeL…artWith(Optional.empty())");
        return startWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IncomingOrderData l(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (IncomingOrderData) tmp0.s(obj, obj2);
    }

    private final Observable<Optional<IncomingOrderDetails>> m() {
        Observable<List<OrderDetails>> a8 = this.f26699a.a();
        final Function1<List<? extends OrderDetails>, Optional<IncomingOrderDetails>> function1 = new Function1<List<? extends OrderDetails>, Optional<IncomingOrderDetails>>() { // from class: ee.mtakso.driver.ui.interactor.order.IncomingOrderInteractor$observeOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<IncomingOrderDetails> invoke(List<? extends OrderDetails> it) {
                Optional<IncomingOrderDetails> g8;
                Intrinsics.f(it, "it");
                g8 = IncomingOrderInteractor.this.g(it);
                return g8;
            }
        };
        Observable<R> map = a8.map(new Function() { // from class: ee.mtakso.driver.ui.interactor.order.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional n8;
                n8 = IncomingOrderInteractor.n(Function1.this, obj);
                return n8;
            }
        });
        final IncomingOrderInteractor$observeOrder$2 incomingOrderInteractor$observeOrder$2 = new Function1<Optional<IncomingOrderDetails>, Boolean>() { // from class: ee.mtakso.driver.ui.interactor.order.IncomingOrderInteractor$observeOrder$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(Optional<IncomingOrderDetails> it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(!it.d());
            }
        };
        Observable<Optional<IncomingOrderDetails>> startWith = map.filter(new Predicate() { // from class: ee.mtakso.driver.ui.interactor.order.d
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean o8;
                o8 = IncomingOrderInteractor.o(Function1.this, obj);
                return o8;
            }
        }).firstOrError().R().startWith((Observable) Optional.a());
        Intrinsics.e(startWith, "private fun observeOrder…h(Optional.empty())\n    }");
        return startWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public final Observable<IncomingOrderData> k() {
        Observable<Optional<GeoLocation>> i8 = i();
        Observable<Optional<IncomingOrderDetails>> m8 = m();
        final Function2<Optional<GeoLocation>, Optional<IncomingOrderDetails>, IncomingOrderData> function2 = new Function2<Optional<GeoLocation>, Optional<IncomingOrderDetails>, IncomingOrderData>() { // from class: ee.mtakso.driver.ui.interactor.order.IncomingOrderInteractor$observeIncomingOrderData$observable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final IncomingOrderData s(Optional<GeoLocation> location, Optional<IncomingOrderDetails> order) {
                boolean h8;
                Intrinsics.f(location, "location");
                Intrinsics.f(order, "order");
                h8 = IncomingOrderInteractor.this.h();
                return new IncomingOrderData(location, order, h8);
            }
        };
        Observable combineLatest = Observable.combineLatest(i8, m8, new BiFunction() { // from class: ee.mtakso.driver.ui.interactor.order.a
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                IncomingOrderData l8;
                l8 = IncomingOrderInteractor.l(Function2.this, obj, obj2);
                return l8;
            }
        });
        Intrinsics.e(combineLatest, "fun observeIncomingOrder…ulers.mainThread())\n    }");
        Observable<IncomingOrderData> observeOn = combineLatest.observeOn(AndroidSchedulers.a());
        Intrinsics.e(observeOn, "observable\n            .…dSchedulers.mainThread())");
        return observeOn;
    }
}
