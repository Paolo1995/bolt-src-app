package ee.mtakso.driver.service.order.details;

import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.OrderStateKt;
import ee.mtakso.driver.service.BaseServiceImpl;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.LogEntry;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CacheCleanupService.kt */
/* loaded from: classes3.dex */
public final class CacheCleanupService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final OrdersCache f25411b;

    @Inject
    public CacheCleanupService(OrdersCache ordersCache) {
        Intrinsics.f(ordersCache, "ordersCache");
        this.f25411b = ordersCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.s(obj, obj2)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void k(List<? extends OrderDetails> list) {
        LogEntry f8 = Kalev.f41674e.f();
        int i8 = 0;
        for (Object obj : list) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            f8.n(String.valueOf(i8), ((OrderDetails) obj).toString());
            i8 = i9;
        }
        f8.l("Order cache change");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(List<? extends OrderDetails> list) {
        k(list);
        for (OrderDetails orderDetails : list) {
            if (m(orderDetails, list)) {
                this.f25411b.h(orderDetails.a());
            }
        }
    }

    private final boolean m(OrderDetails orderDetails, List<? extends OrderDetails> list) {
        Object obj;
        Object obj2;
        if (OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_DRIVER_REJECTED)) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                if (!OrderStateKt.b(((OrderDetails) obj2).b())) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        if (obj2 != null && OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_DRIVER_DID_NOT_RESPOND)) {
            return true;
        }
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (!OrderStateKt.b(((OrderDetails) next).b())) {
                obj = next;
                break;
            }
        }
        if (obj != null && OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_CLIENT_CANCELLED)) {
            return true;
        }
        return false;
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<List<OrderDetails>> a8 = this.f25411b.a();
        final CacheCleanupService$doStart$1 cacheCleanupService$doStart$1 = new Function2<List<? extends OrderDetails>, List<? extends OrderDetails>, Boolean>() { // from class: ee.mtakso.driver.service.order.details.CacheCleanupService$doStart$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final Boolean s(List<? extends OrderDetails> old, List<? extends OrderDetails> list) {
                int v7;
                int v8;
                Intrinsics.f(old, "old");
                Intrinsics.f(list, "new");
                v7 = CollectionsKt__IterablesKt.v(old, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (OrderDetails orderDetails : old) {
                    arrayList.add(orderDetails.b());
                }
                v8 = CollectionsKt__IterablesKt.v(list, 10);
                ArrayList arrayList2 = new ArrayList(v8);
                for (OrderDetails orderDetails2 : list) {
                    arrayList2.add(orderDetails2.b());
                }
                return Boolean.valueOf(Intrinsics.a(arrayList, arrayList2));
            }
        };
        Observable<List<OrderDetails>> distinctUntilChanged = a8.distinctUntilChanged(new BiPredicate() { // from class: ee.mtakso.driver.service.order.details.a
            @Override // io.reactivex.functions.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                boolean i8;
                i8 = CacheCleanupService.i(Function2.this, obj, obj2);
                return i8;
            }
        });
        final Function1<List<? extends OrderDetails>, Unit> function1 = new Function1<List<? extends OrderDetails>, Unit>() { // from class: ee.mtakso.driver.service.order.details.CacheCleanupService$doStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<? extends OrderDetails> it) {
                CacheCleanupService cacheCleanupService = CacheCleanupService.this;
                Intrinsics.e(it, "it");
                cacheCleanupService.l(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends OrderDetails> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        Disposable subscribe = distinctUntilChanged.subscribe(new Consumer() { // from class: ee.mtakso.driver.service.order.details.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CacheCleanupService.j(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …nCacheChanged(it) }\n    }");
        return subscribe;
    }
}
