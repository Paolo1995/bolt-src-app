package ee.mtakso.driver.ui.interactor.order.scheduled;

import ee.mtakso.driver.network.client.order.AcceptedScheduledRides;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.service.order.ScheduledOrderProvider;
import ee.mtakso.driver.ui.interactor.order.scheduled.GetAcceptedOrdersInteractor;
import ee.mtakso.driver.utils.ObservableExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetAcceptedOrdersInteractor.kt */
/* loaded from: classes3.dex */
public final class GetAcceptedOrdersInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final OrderClient f26752a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledOrderProvider f26753b;

    @Inject
    public GetAcceptedOrdersInteractor(OrderClient orderClient, ScheduledOrderProvider scheduledOrderProvider) {
        Intrinsics.f(orderClient, "orderClient");
        Intrinsics.f(scheduledOrderProvider, "scheduledOrderProvider");
        this.f26752a = orderClient;
        this.f26753b = scheduledOrderProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    public final Observable<AcceptedScheduledRides> c() {
        Observable<AcceptedScheduledRides> R = this.f26752a.r().R();
        Intrinsics.e(R, "orderClient.getAcceptedS…          .toObservable()");
        Observable g8 = ObservableExtKt.g(R);
        final Function1<Observable<Object>, ObservableSource<?>> function1 = new Function1<Observable<Object>, ObservableSource<?>>() { // from class: ee.mtakso.driver.ui.interactor.order.scheduled.GetAcceptedOrdersInteractor$getScheduledOrders$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<?> invoke(Observable<Object> it) {
                ScheduledOrderProvider scheduledOrderProvider;
                Intrinsics.f(it, "it");
                scheduledOrderProvider = GetAcceptedOrdersInteractor.this.f26753b;
                return scheduledOrderProvider.b();
            }
        };
        Observable<AcceptedScheduledRides> repeatWhen = g8.repeatWhen(new Function() { // from class: t2.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource d8;
                d8 = GetAcceptedOrdersInteractor.d(Function1.this, obj);
                return d8;
            }
        });
        Intrinsics.e(repeatWhen, "fun getScheduledOrders()…ted()\n            }\n    }");
        return repeatWhen;
    }
}
