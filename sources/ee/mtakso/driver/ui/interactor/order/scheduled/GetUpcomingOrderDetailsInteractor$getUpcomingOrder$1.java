package ee.mtakso.driver.ui.interactor.order.scheduled;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.service.order.ScheduledOrderProvider;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Predicate;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GetUpcomingOrderDetailsInteractor.kt */
/* loaded from: classes3.dex */
public final class GetUpcomingOrderDetailsInteractor$getUpcomingOrder$1 extends Lambda implements Function1<Observable<Object>, ObservableSource<?>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ GetUpcomingOrderDetailsInteractor f26764f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ OrderHandle f26765g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetUpcomingOrderDetailsInteractor$getUpcomingOrder$1(GetUpcomingOrderDetailsInteractor getUpcomingOrderDetailsInteractor, OrderHandle orderHandle) {
        super(1);
        this.f26764f = getUpcomingOrderDetailsInteractor;
        this.f26765g = orderHandle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final ObservableSource<?> invoke(Observable<Object> it) {
        ScheduledOrderProvider scheduledOrderProvider;
        Intrinsics.f(it, "it");
        scheduledOrderProvider = this.f26764f.f26763b;
        Observable<OrderHandle> b8 = scheduledOrderProvider.b();
        final OrderHandle orderHandle = this.f26765g;
        final Function1<OrderHandle, Boolean> function1 = new Function1<OrderHandle, Boolean>() { // from class: ee.mtakso.driver.ui.interactor.order.scheduled.GetUpcomingOrderDetailsInteractor$getUpcomingOrder$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(OrderHandle it2) {
                Intrinsics.f(it2, "it");
                return Boolean.valueOf(Intrinsics.a(it2, OrderHandle.this));
            }
        };
        return b8.filter(new Predicate() { // from class: ee.mtakso.driver.ui.interactor.order.scheduled.a
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean d8;
                d8 = GetUpcomingOrderDetailsInteractor$getUpcomingOrder$1.d(Function1.this, obj);
                return d8;
            }
        });
    }
}
