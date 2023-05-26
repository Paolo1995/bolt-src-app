package ee.mtakso.driver.service.modules.distance;

import ee.mtakso.driver.network.client.order.OrderKt;
import ee.mtakso.driver.service.BaseObservableServiceImpl;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.android.maps.core.GeoUtils;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.Subject;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpcomingStopDistanceService.kt */
/* loaded from: classes3.dex */
public final class UpcomingStopDistanceService extends BaseObservableServiceImpl<OrderWithOptionalDistance> {

    /* renamed from: c  reason: collision with root package name */
    private final GeoLocationManager f24599c;

    /* renamed from: d  reason: collision with root package name */
    private final OrderProvider f24600d;

    /* JADX WARN: Illegal instructions before constructor call */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UpcomingStopDistanceService(ee.mtakso.driver.service.geo.GeoLocationManager r3, ee.mtakso.driver.service.order.details.OrderProvider r4) {
        /*
            r2 = this;
            java.lang.String r0 = "locationManager"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "orderProvider"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            io.reactivex.subjects.BehaviorSubject r0 = io.reactivex.subjects.BehaviorSubject.e()
            java.lang.String r1 = "create()"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r2.<init>(r0)
            r2.f24599c = r3
            r2.f24600d = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.modules.distance.UpcomingStopDistanceService.<init>(ee.mtakso.driver.service.geo.GeoLocationManager, ee.mtakso.driver.service.order.details.OrderProvider):void");
    }

    private final OrderWithOptionalDistance j(GeoLocation geoLocation, ActiveOrderDetails activeOrderDetails) {
        GeoCoordinate b8 = OrderKt.b(activeOrderDetails.i());
        if (b8 == null) {
            return new OrderWithOptionalDistance(activeOrderDetails, null, 2, null);
        }
        return new OrderWithOptionalDistance(activeOrderDetails, Double.valueOf(GeoUtils.f36938a.f(geoLocation.e(), b8)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OrderWithOptionalDistance k(UpcomingStopDistanceService this$0, GeoLocation location, ActiveOrderDetails order) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(location, "location");
        Intrinsics.f(order, "order");
        return this$0.j(location, order);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Observable<GeoLocation> m() {
        return this.f24599c.u(1L);
    }

    private final Observable<ActiveOrderDetails> n() {
        return ObservableExtKt.k(this.f24600d.a(), new Function1<List<? extends OrderDetails>, ActiveOrderDetails>() { // from class: ee.mtakso.driver.service.modules.distance.UpcomingStopDistanceService$observeOrder$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ActiveOrderDetails invoke(List<? extends OrderDetails> it) {
                Intrinsics.f(it, "it");
                return OrderProviderUtils.j(it);
            }
        });
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable combineLatest = Observable.combineLatest(m(), n(), new BiFunction() { // from class: ee.mtakso.driver.service.modules.distance.a
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                OrderWithOptionalDistance k8;
                k8 = UpcomingStopDistanceService.k(UpcomingStopDistanceService.this, (GeoLocation) obj, (ActiveOrderDetails) obj2);
                return k8;
            }
        });
        final Function1<OrderWithOptionalDistance, Unit> function1 = new Function1<OrderWithOptionalDistance, Unit>() { // from class: ee.mtakso.driver.service.modules.distance.UpcomingStopDistanceService$doStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(OrderWithOptionalDistance orderWithOptionalDistance) {
                Subject f8;
                f8 = UpcomingStopDistanceService.this.f();
                f8.onNext(orderWithOptionalDistance);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OrderWithOptionalDistance orderWithOptionalDistance) {
                b(orderWithOptionalDistance);
                return Unit.f50853a;
            }
        };
        Disposable subscribe = combineLatest.subscribe(new Consumer() { // from class: ee.mtakso.driver.service.modules.distance.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpcomingStopDistanceService.l(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …rderWithDistance) }\n    }");
        return subscribe;
    }
}
