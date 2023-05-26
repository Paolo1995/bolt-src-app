package ee.mtakso.driver.ui.screens.order.v2.order;

import ee.mtakso.driver.service.modules.distance.OrderWithDistance;
import ee.mtakso.driver.service.modules.distance.OrderWithOptionalDistance;
import ee.mtakso.driver.service.modules.distance.OrderWithOptionalDistanceKt;
import ee.mtakso.driver.service.modules.distance.UpcomingStopDistanceService;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Observable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderDistanceInteractor.kt */
/* loaded from: classes3.dex */
public final class OrderDistanceInteractor {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f32259b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final UpcomingStopDistanceService f32260a;

    /* compiled from: OrderDistanceInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public OrderDistanceInteractor(UpcomingStopDistanceService distanceService) {
        Intrinsics.f(distanceService, "distanceService");
        this.f32260a = distanceService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Double) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.s(obj, obj2)).booleanValue();
    }

    public Observable<Double> d() {
        Observable<OrderWithOptionalDistance> c8 = this.f32260a.c();
        final OrderDistanceInteractor$observeScreenData$1 orderDistanceInteractor$observeScreenData$1 = new Function1<OrderWithOptionalDistance, Optional<OrderWithDistance>>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.OrderDistanceInteractor$observeScreenData$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<OrderWithDistance> invoke(OrderWithOptionalDistance it) {
                Intrinsics.f(it, "it");
                return OrderWithOptionalDistanceKt.a(it);
            }
        };
        Observable<R> map = c8.map(new Function() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.j
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional e8;
                e8 = OrderDistanceInteractor.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(map, "distanceService.observeR…t.toOrderWithDistance() }");
        Observable h8 = ObservableExtKt.h(map);
        final OrderDistanceInteractor$observeScreenData$2 orderDistanceInteractor$observeScreenData$2 = new Function1<OrderWithDistance, Double>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.OrderDistanceInteractor$observeScreenData$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Double invoke(OrderWithDistance it) {
                Intrinsics.f(it, "it");
                return Double.valueOf(it.a());
            }
        };
        Observable map2 = h8.map(new Function() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Double f8;
                f8 = OrderDistanceInteractor.f(Function1.this, obj);
                return f8;
            }
        });
        final OrderDistanceInteractor$observeScreenData$3 orderDistanceInteractor$observeScreenData$3 = new Function2<Double, Double, Boolean>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.OrderDistanceInteractor$observeScreenData$3
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
        Observable<Double> distinctUntilChanged = map2.distinctUntilChanged(new BiPredicate() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.l
            @Override // io.reactivex.functions.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                boolean g8;
                g8 = OrderDistanceInteractor.g(Function2.this, obj, obj2);
                return g8;
            }
        });
        Intrinsics.e(distinctUntilChanged, "distanceService.observeR…STANCE_CHANGE_THRESHOLD }");
        return distinctUntilChanged;
    }
}
