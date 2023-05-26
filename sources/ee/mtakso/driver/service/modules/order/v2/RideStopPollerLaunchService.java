package ee.mtakso.driver.service.modules.order.v2;

import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetailsKt;
import ee.mtakso.driver.service.order.details.OrdersCache;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RideStopPollerLaunchService.kt */
/* loaded from: classes3.dex */
public final class RideStopPollerLaunchService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final OrdersCache f25008b;

    /* renamed from: c  reason: collision with root package name */
    private final StopDetailsService f25009c;

    @Inject
    public RideStopPollerLaunchService(OrdersCache ordersCache, StopDetailsService stopDetailsService) {
        Intrinsics.f(ordersCache, "ordersCache");
        Intrinsics.f(stopDetailsService, "stopDetailsService");
        this.f25008b = ordersCache;
        this.f25009c = stopDetailsService;
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

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<List<OrderDetails>> a8 = this.f25008b.a();
        final Function1<List<? extends OrderDetails>, Unit> function1 = new Function1<List<? extends OrderDetails>, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.RideStopPollerLaunchService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<? extends OrderDetails> it) {
                Object obj;
                StopDetailsService stopDetailsService;
                StopDetailsService stopDetailsService2;
                StopDetailsService stopDetailsService3;
                Intrinsics.e(it, "it");
                Iterator<T> it2 = it.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        obj = it2.next();
                        if (OrderDetailsKt.a((OrderDetails) obj, OrderState.ORDER_STATE_WAITING_ON_STOP)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                OrderDetails orderDetails = (OrderDetails) obj;
                stopDetailsService = RideStopPollerLaunchService.this.f25009c;
                boolean isRunning = stopDetailsService.isRunning();
                if (orderDetails != null && !isRunning) {
                    stopDetailsService3 = RideStopPollerLaunchService.this.f25009c;
                    stopDetailsService3.a();
                }
                if (orderDetails == null && isRunning) {
                    stopDetailsService2 = RideStopPollerLaunchService.this.f25009c;
                    stopDetailsService2.b();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends OrderDetails> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        Consumer<? super List<OrderDetails>> consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.x0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RideStopPollerLaunchService.i(Function1.this, obj);
            }
        };
        final RideStopPollerLaunchService$doStart$2 rideStopPollerLaunchService$doStart$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.RideStopPollerLaunchService$doStart$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to observe orders for RideStopPollerLaunchService");
            }
        };
        Disposable subscribe = a8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.y0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RideStopPollerLaunchService.j(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …rLaunchService\") })\n    }");
        return subscribe;
    }
}
