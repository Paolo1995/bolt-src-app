package ee.mtakso.driver.ui.screens.order.v2.order;

import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.service.modules.distance.OrderWithDistance;
import ee.mtakso.driver.service.modules.distance.OrderWithOptionalDistance;
import ee.mtakso.driver.service.modules.distance.OrderWithOptionalDistanceKt;
import ee.mtakso.driver.service.modules.distance.UpcomingStopDistanceService;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PaidStopsStateInteractor.kt */
/* loaded from: classes3.dex */
public final class PaidStopsStateInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final UpcomingStopDistanceService f32309a;

    /* renamed from: b  reason: collision with root package name */
    private final Features f32310b;

    @Inject
    public PaidStopsStateInteractor(UpcomingStopDistanceService distanceService, Features features) {
        Intrinsics.f(distanceService, "distanceService");
        Intrinsics.f(features, "features");
        this.f32309a = distanceService;
        this.f32310b = features;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Boolean) tmp0.invoke(obj);
    }

    public final Observable<Boolean> d() {
        Observable<OrderWithOptionalDistance> c8 = this.f32309a.c();
        final PaidStopsStateInteractor$call$1 paidStopsStateInteractor$call$1 = new Function1<OrderWithOptionalDistance, Optional<OrderWithDistance>>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.PaidStopsStateInteractor$call$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<OrderWithDistance> invoke(OrderWithOptionalDistance it) {
                Intrinsics.f(it, "it");
                return OrderWithOptionalDistanceKt.a(it);
            }
        };
        Observable<R> map = c8.map(new Function() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.r
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional e8;
                e8 = PaidStopsStateInteractor.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(map, "distanceService.observeR…t.toOrderWithDistance() }");
        Observable h8 = ObservableExtKt.h(map);
        final Function1<OrderWithDistance, Boolean> function1 = new Function1<OrderWithDistance, Boolean>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.PaidStopsStateInteractor$call$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
                if (r7.b(ee.mtakso.driver.features.Feature.Type.PAID_STOPS) != false) goto L9;
             */
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Boolean invoke(ee.mtakso.driver.service.modules.distance.OrderWithDistance r7) {
                /*
                    r6 = this;
                    java.lang.String r0 = "it"
                    kotlin.jvm.internal.Intrinsics.f(r7, r0)
                    double r0 = r7.a()
                    r2 = 1
                    r3 = 4647503709213818880(0x407f400000000000, double:500.0)
                    int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                    if (r5 >= 0) goto L3c
                    ee.mtakso.driver.service.order.details.ActiveOrderDetails r0 = r7.b()
                    java.util.List r0 = ee.mtakso.driver.service.order.details.ActiveOrderDetailsKt.a(r0)
                    int r0 = r0.size()
                    if (r0 <= r2) goto L3c
                    ee.mtakso.driver.service.order.details.ActiveOrderDetails r7 = r7.b()
                    ee.mtakso.driver.network.client.OrderState r7 = r7.b()
                    ee.mtakso.driver.network.client.OrderState r0 = ee.mtakso.driver.network.client.OrderState.ORDER_STATE_DRIVING_WITH_CLIENT
                    if (r7 != r0) goto L3c
                    ee.mtakso.driver.ui.screens.order.v2.order.PaidStopsStateInteractor r7 = ee.mtakso.driver.ui.screens.order.v2.order.PaidStopsStateInteractor.this
                    ee.mtakso.driver.features.Features r7 = ee.mtakso.driver.ui.screens.order.v2.order.PaidStopsStateInteractor.c(r7)
                    ee.mtakso.driver.features.Feature$Type r0 = ee.mtakso.driver.features.Feature.Type.PAID_STOPS
                    boolean r7 = r7.b(r0)
                    if (r7 == 0) goto L3c
                    goto L3d
                L3c:
                    r2 = 0
                L3d:
                    java.lang.Boolean r7 = java.lang.Boolean.valueOf(r2)
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.order.v2.order.PaidStopsStateInteractor$call$2.invoke(ee.mtakso.driver.service.modules.distance.OrderWithDistance):java.lang.Boolean");
            }
        };
        Observable<Boolean> map2 = h8.map(new Function() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.s
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean f8;
                f8 = PaidStopsStateInteractor.f(Function1.this, obj);
                return f8;
            }
        });
        Intrinsics.e(map2, "fun call(): Observable<B….Type.PAID_STOPS) }\n    }");
        return map2;
    }
}
