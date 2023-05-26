package ee.mtakso.driver.ui.interactor.order.scheduled;

import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.network.client.order.ScheduledRideRequests;
import ee.mtakso.driver.service.order.ScheduledOrderProvider;
import ee.mtakso.driver.ui.interactor.order.scheduled.GetScheduledOrdersInteractor;
import ee.mtakso.driver.utils.ObservableExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetScheduledOrdersInteractor.kt */
/* loaded from: classes3.dex */
public final class GetScheduledOrdersInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final OrderClient f26757a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledOrderProvider f26758b;

    @Inject
    public GetScheduledOrdersInteractor(OrderClient orderClient, ScheduledOrderProvider scheduledOrderProvider) {
        Intrinsics.f(orderClient, "orderClient");
        Intrinsics.f(scheduledOrderProvider, "scheduledOrderProvider");
        this.f26757a = orderClient;
        this.f26758b = scheduledOrderProvider;
    }

    public static /* synthetic */ Observable d(GetScheduledOrdersInteractor getScheduledOrdersInteractor, String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = null;
        }
        return getScheduledOrdersInteractor.c(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    public final Observable<ScheduledRideRequests> c(String str) {
        Observable<ScheduledRideRequests> R = this.f26757a.C(str).R();
        Intrinsics.e(R, "orderClient.getScheduled…          .toObservable()");
        Observable g8 = ObservableExtKt.g(R);
        final Function1<Observable<Object>, ObservableSource<?>> function1 = new Function1<Observable<Object>, ObservableSource<?>>() { // from class: ee.mtakso.driver.ui.interactor.order.scheduled.GetScheduledOrdersInteractor$getScheduledOrders$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<?> invoke(Observable<Object> completed) {
                ScheduledOrderProvider scheduledOrderProvider;
                Intrinsics.f(completed, "completed");
                Observable<Object> delay = completed.delay(30L, TimeUnit.SECONDS);
                scheduledOrderProvider = GetScheduledOrdersInteractor.this.f26758b;
                return Observable.merge(delay, scheduledOrderProvider.b());
            }
        };
        Observable<ScheduledRideRequests> repeatWhen = g8.repeatWhen(new Function() { // from class: t2.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource e8;
                e8 = GetScheduledOrdersInteractor.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(repeatWhen, "fun getScheduledOrders(g…    )\n            }\n    }");
        return repeatWhen;
    }
}
