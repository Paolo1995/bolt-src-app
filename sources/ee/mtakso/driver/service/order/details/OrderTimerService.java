package ee.mtakso.driver.service.order.details;

import androidx.fragment.app.FragmentTransaction;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import j$.util.Spliterator;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderTimerService.kt */
/* loaded from: classes3.dex */
public final class OrderTimerService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final OrdersCache f25464b;

    @Inject
    public OrderTimerService(OrdersCache orderCache) {
        Intrinsics.f(orderCache, "orderCache");
        this.f25464b = orderCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        ActiveOrderDetails e8;
        Long l8;
        ActiveOrderDetails e9;
        Long l9;
        ActiveOrderDetails e10;
        ActiveOrderDetails e11;
        ActiveOrderDetails d8 = this.f25464b.d(OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT);
        if (d8 != null) {
            OrdersCache ordersCache = this.f25464b;
            e11 = d8.e((r36 & 1) != 0 ? d8.a() : null, (r36 & 2) != 0 ? d8.d() : 0, (r36 & 4) != 0 ? d8.b() : null, (r36 & 8) != 0 ? d8.c() : null, (r36 & 16) != 0 ? d8.f25399e : null, (r36 & 32) != 0 ? d8.f25400f : 0L, (r36 & 64) != 0 ? d8.f25401g : false, (r36 & 128) != 0 ? d8.f25402h : false, (r36 & Spliterator.NONNULL) != 0 ? d8.f25403i : null, (r36 & 512) != 0 ? d8.f25404j : d8.l() + 1, (r36 & Spliterator.IMMUTABLE) != 0 ? d8.f25405k : null, (r36 & 2048) != 0 ? d8.f25406l : null, (r36 & 4096) != 0 ? d8.f25407m : null, (r36 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? d8.f25408n : null, (r36 & 16384) != 0 ? d8.f25409o : null, (r36 & 32768) != 0 ? d8.f25410p : null);
            ordersCache.b(e11);
        }
        ActiveOrderDetails d9 = this.f25464b.d(OrderState.ORDER_STATE_DRIVER_ACCEPTED);
        Long l10 = null;
        if (d9 != null) {
            OrdersCache ordersCache2 = this.f25464b;
            Long n8 = d9.n();
            if (n8 != null) {
                l9 = Long.valueOf(n8.longValue() - 1);
            } else {
                l9 = null;
            }
            e10 = d9.e((r36 & 1) != 0 ? d9.a() : null, (r36 & 2) != 0 ? d9.d() : 0, (r36 & 4) != 0 ? d9.b() : null, (r36 & 8) != 0 ? d9.c() : null, (r36 & 16) != 0 ? d9.f25399e : null, (r36 & 32) != 0 ? d9.f25400f : 0L, (r36 & 64) != 0 ? d9.f25401g : false, (r36 & 128) != 0 ? d9.f25402h : false, (r36 & Spliterator.NONNULL) != 0 ? d9.f25403i : l9, (r36 & 512) != 0 ? d9.f25404j : 0L, (r36 & Spliterator.IMMUTABLE) != 0 ? d9.f25405k : null, (r36 & 2048) != 0 ? d9.f25406l : null, (r36 & 4096) != 0 ? d9.f25407m : null, (r36 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? d9.f25408n : null, (r36 & 16384) != 0 ? d9.f25409o : null, (r36 & 32768) != 0 ? d9.f25410p : null);
            ordersCache2.b(e10);
        }
        ActiveOrderDetails d10 = this.f25464b.d(OrderState.ORDER_STATE_DRIVING_WITH_CLIENT);
        if (d10 != null) {
            OrdersCache ordersCache3 = this.f25464b;
            Long o8 = d10.o();
            if (o8 != null) {
                l8 = Long.valueOf(o8.longValue() - 1);
            } else {
                l8 = null;
            }
            e9 = d10.e((r36 & 1) != 0 ? d10.a() : null, (r36 & 2) != 0 ? d10.d() : 0, (r36 & 4) != 0 ? d10.b() : null, (r36 & 8) != 0 ? d10.c() : null, (r36 & 16) != 0 ? d10.f25399e : null, (r36 & 32) != 0 ? d10.f25400f : 0L, (r36 & 64) != 0 ? d10.f25401g : false, (r36 & 128) != 0 ? d10.f25402h : false, (r36 & Spliterator.NONNULL) != 0 ? d10.f25403i : null, (r36 & 512) != 0 ? d10.f25404j : 0L, (r36 & Spliterator.IMMUTABLE) != 0 ? d10.f25405k : l8, (r36 & 2048) != 0 ? d10.f25406l : null, (r36 & 4096) != 0 ? d10.f25407m : null, (r36 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? d10.f25408n : null, (r36 & 16384) != 0 ? d10.f25409o : null, (r36 & 32768) != 0 ? d10.f25410p : null);
            ordersCache3.b(e9);
        }
        ActiveOrderDetails d11 = this.f25464b.d(OrderState.ORDER_STATE_WAITING_ON_STOP);
        if (d11 != null) {
            OrdersCache ordersCache4 = this.f25464b;
            Long m8 = d11.m();
            if (m8 != null) {
                l10 = Long.valueOf(m8.longValue() + 1);
            }
            e8 = d11.e((r36 & 1) != 0 ? d11.a() : null, (r36 & 2) != 0 ? d11.d() : 0, (r36 & 4) != 0 ? d11.b() : null, (r36 & 8) != 0 ? d11.c() : null, (r36 & 16) != 0 ? d11.f25399e : null, (r36 & 32) != 0 ? d11.f25400f : 0L, (r36 & 64) != 0 ? d11.f25401g : false, (r36 & 128) != 0 ? d11.f25402h : false, (r36 & Spliterator.NONNULL) != 0 ? d11.f25403i : null, (r36 & 512) != 0 ? d11.f25404j : 0L, (r36 & Spliterator.IMMUTABLE) != 0 ? d11.f25405k : null, (r36 & 2048) != 0 ? d11.f25406l : l10, (r36 & 4096) != 0 ? d11.f25407m : null, (r36 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? d11.f25408n : null, (r36 & 16384) != 0 ? d11.f25409o : null, (r36 & 32768) != 0 ? d11.f25410p : null);
            ordersCache4.b(e8);
        }
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<Long> interval = Observable.interval(0L, 1L, TimeUnit.SECONDS);
        Intrinsics.e(interval, "interval(0, 1, SECONDS)");
        Observable f8 = ObservableExtKt.f(interval);
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: ee.mtakso.driver.service.order.details.OrderTimerService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Long l8) {
                OrderTimerService.this.k();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                b(l8);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.order.details.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderTimerService.i(Function1.this, obj);
            }
        };
        final OrderTimerService$doStart$2 orderTimerService$doStart$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.order.details.OrderTimerService$doStart$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable error) {
                Intrinsics.e(error, "error");
                Kalev.e(error, "order time updater faced an exception");
            }
        };
        Disposable subscribe = f8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.order.details.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderTimerService.j(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …d an exception\") })\n    }");
        return subscribe;
    }
}
