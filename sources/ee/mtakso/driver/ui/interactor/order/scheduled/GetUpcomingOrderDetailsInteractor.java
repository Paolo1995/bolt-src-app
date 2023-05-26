package ee.mtakso.driver.ui.interactor.order.scheduled;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.network.client.order.ScheduledRideDetails;
import ee.mtakso.driver.service.order.ScheduledOrderProvider;
import ee.mtakso.driver.ui.interactor.order.scheduled.GetUpcomingOrderDetailsInteractor;
import ee.mtakso.driver.utils.ObservableExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetUpcomingOrderDetailsInteractor.kt */
/* loaded from: classes3.dex */
public final class GetUpcomingOrderDetailsInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final OrderClient f26762a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledOrderProvider f26763b;

    @Inject
    public GetUpcomingOrderDetailsInteractor(OrderClient orderClient, ScheduledOrderProvider scheduledOrderProvider) {
        Intrinsics.f(orderClient, "orderClient");
        Intrinsics.f(scheduledOrderProvider, "scheduledOrderProvider");
        this.f26762a = orderClient;
        this.f26763b = scheduledOrderProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    public final Observable<ScheduledRideDetails> c(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        Observable<ScheduledRideDetails> R = this.f26762a.E(orderHandle).R();
        Intrinsics.e(R, "orderClient.getUpcomingR…          .toObservable()");
        Observable g8 = ObservableExtKt.g(R);
        final GetUpcomingOrderDetailsInteractor$getUpcomingOrder$1 getUpcomingOrderDetailsInteractor$getUpcomingOrder$1 = new GetUpcomingOrderDetailsInteractor$getUpcomingOrder$1(this, orderHandle);
        Observable<ScheduledRideDetails> repeatWhen = g8.repeatWhen(new Function() { // from class: t2.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource d8;
                d8 = GetUpcomingOrderDetailsInteractor.d(Function1.this, obj);
                return d8;
            }
        });
        Intrinsics.e(repeatWhen, "fun getUpcomingOrder(ord…dle }\n            }\n    }");
        return repeatWhen;
    }
}
