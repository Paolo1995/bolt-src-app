package ee.mtakso.driver.service.order;

import ee.mtakso.driver.network.client.OrderHandle;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrderProvider.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrderProvider {

    /* renamed from: a  reason: collision with root package name */
    private final PublishSubject<OrderHandle> f25390a;

    @Inject
    public ScheduledOrderProvider() {
        PublishSubject<OrderHandle> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<OrderHandle>()");
        this.f25390a = e8;
    }

    public final void a(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        this.f25390a.onNext(orderHandle);
    }

    public final Observable<OrderHandle> b() {
        return this.f25390a;
    }
}
