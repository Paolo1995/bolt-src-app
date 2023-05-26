package ee.mtakso.driver.service.order.details;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderStateKt;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrdersCache.kt */
@Singleton
/* loaded from: classes3.dex */
public final class OrdersCache implements OrderProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Map<OrderHandle, OrderDetails> f25478a = new LinkedHashMap();

    /* renamed from: b  reason: collision with root package name */
    private final PublishSubject<List<OrderDetails>> f25479b;

    @Inject
    public OrdersCache() {
        PublishSubject<List<OrderDetails>> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<List<OrderDetails>>()");
        this.f25479b = e8;
    }

    @Override // ee.mtakso.driver.service.order.details.OrderProvider
    public Observable<List<OrderDetails>> a() {
        List<OrderDetails> H0;
        PublishSubject<List<OrderDetails>> publishSubject = this.f25479b;
        H0 = CollectionsKt___CollectionsKt.H0(this.f25478a.values());
        Observable<List<OrderDetails>> observeOn = publishSubject.startWith((PublishSubject<List<OrderDetails>>) H0).observeOn(Schedulers.a());
        Intrinsics.e(observeOn, "ordersBus.startWith(orde…Schedulers.computation())");
        return observeOn;
    }

    public final void b(OrderDetails order) {
        List<OrderDetails> H0;
        Intrinsics.f(order, "order");
        synchronized (this.f25478a) {
            this.f25478a.put(order.a(), order);
            PublishSubject<List<OrderDetails>> publishSubject = this.f25479b;
            H0 = CollectionsKt___CollectionsKt.H0(this.f25478a.values());
            publishSubject.onNext(H0);
            Unit unit = Unit.f50853a;
        }
    }

    public final void c() {
        List<OrderDetails> H0;
        synchronized (this.f25478a) {
            this.f25478a.clear();
            PublishSubject<List<OrderDetails>> publishSubject = this.f25479b;
            H0 = CollectionsKt___CollectionsKt.H0(this.f25478a.values());
            publishSubject.onNext(H0);
            Unit unit = Unit.f50853a;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
        if (r2 == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
        r4 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final ee.mtakso.driver.service.order.details.ActiveOrderDetails d(ee.mtakso.driver.network.client.OrderState r8) {
        /*
            r7 = this;
            java.lang.String r0 = "orderState"
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            java.util.Map<ee.mtakso.driver.network.client.OrderHandle, ee.mtakso.driver.service.order.details.OrderDetails> r0 = r7.f25478a
            monitor-enter(r0)
            java.util.Map<ee.mtakso.driver.network.client.OrderHandle, ee.mtakso.driver.service.order.details.OrderDetails> r1 = r7.f25478a     // Catch: java.lang.Throwable -> L3a
            java.util.Collection r1 = r1.values()     // Catch: java.lang.Throwable -> L3a
            r2 = 0
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L3a
            r3 = 0
            r4 = r3
        L15:
            boolean r5 = r1.hasNext()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L2e
            java.lang.Object r5 = r1.next()     // Catch: java.lang.Throwable -> L3a
            r6 = r5
            ee.mtakso.driver.service.order.details.OrderDetails r6 = (ee.mtakso.driver.service.order.details.OrderDetails) r6     // Catch: java.lang.Throwable -> L3a
            boolean r6 = ee.mtakso.driver.service.order.details.OrderDetailsKt.a(r6, r8)     // Catch: java.lang.Throwable -> L3a
            if (r6 == 0) goto L15
            if (r2 == 0) goto L2b
            goto L30
        L2b:
            r2 = 1
            r4 = r5
            goto L15
        L2e:
            if (r2 != 0) goto L31
        L30:
            r4 = r3
        L31:
            boolean r8 = r4 instanceof ee.mtakso.driver.service.order.details.ActiveOrderDetails     // Catch: java.lang.Throwable -> L3a
            if (r8 == 0) goto L38
            r3 = r4
            ee.mtakso.driver.service.order.details.ActiveOrderDetails r3 = (ee.mtakso.driver.service.order.details.ActiveOrderDetails) r3     // Catch: java.lang.Throwable -> L3a
        L38:
            monitor-exit(r0)
            return r3
        L3a:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.order.details.OrdersCache.d(ee.mtakso.driver.network.client.OrderState):ee.mtakso.driver.service.order.details.ActiveOrderDetails");
    }

    public final OrderDetails e(OrderHandle orderHandle) {
        OrderDetails orderDetails;
        Intrinsics.f(orderHandle, "orderHandle");
        synchronized (this.f25478a) {
            orderDetails = this.f25478a.get(orderHandle);
        }
        return orderDetails;
    }

    @Override // ee.mtakso.driver.service.order.details.OrderProvider
    public List<OrderDetails> f() {
        List<OrderDetails> H0;
        synchronized (this.f25478a) {
            H0 = CollectionsKt___CollectionsKt.H0(this.f25478a.values());
        }
        return H0;
    }

    public final List<OrderHandle> g() {
        int v7;
        List<OrderDetails> f8 = f();
        ArrayList<OrderDetails> arrayList = new ArrayList();
        for (Object obj : f8) {
            if (!OrderStateKt.b(((OrderDetails) obj).b())) {
                arrayList.add(obj);
            }
        }
        v7 = CollectionsKt__IterablesKt.v(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(v7);
        for (OrderDetails orderDetails : arrayList) {
            arrayList2.add(orderDetails.a());
        }
        return arrayList2;
    }

    public final void h(OrderHandle orderHandle) {
        List<OrderDetails> H0;
        Intrinsics.f(orderHandle, "orderHandle");
        synchronized (this.f25478a) {
            this.f25478a.remove(orderHandle);
            PublishSubject<List<OrderDetails>> publishSubject = this.f25479b;
            H0 = CollectionsKt___CollectionsKt.H0(this.f25478a.values());
            publishSubject.onNext(H0);
            Unit unit = Unit.f50853a;
        }
    }
}
