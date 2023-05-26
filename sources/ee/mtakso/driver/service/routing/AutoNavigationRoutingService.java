package ee.mtakso.driver.service.routing;

import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AutoNavigationRoutingService.kt */
/* loaded from: classes3.dex */
public final class AutoNavigationRoutingService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final OrderProvider f25884b;

    /* renamed from: c  reason: collision with root package name */
    private final AutoNavigationManager f25885c;

    @Inject
    public AutoNavigationRoutingService(OrderProvider orderProvider, AutoNavigationManager autoNavigationManager) {
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(autoNavigationManager, "autoNavigationManager");
        this.f25884b = orderProvider;
        this.f25885c = autoNavigationManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<List<OrderDetails>> a8 = this.f25884b.a();
        final AutoNavigationRoutingService$doStart$1 autoNavigationRoutingService$doStart$1 = new Function1<List<? extends OrderDetails>, List<? extends ActiveOrderDetails>>() { // from class: ee.mtakso.driver.service.routing.AutoNavigationRoutingService$doStart$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<ActiveOrderDetails> invoke(List<? extends OrderDetails> orders) {
                List<ActiveOrderDetails> L;
                Intrinsics.f(orders, "orders");
                L = CollectionsKt___CollectionsJvmKt.L(orders, ActiveOrderDetails.class);
                return L;
            }
        };
        Observable<R> map = a8.map(new Function() { // from class: ee.mtakso.driver.service.routing.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List j8;
                j8 = AutoNavigationRoutingService.j(Function1.this, obj);
                return j8;
            }
        });
        final Function1<List<? extends ActiveOrderDetails>, Unit> function1 = new Function1<List<? extends ActiveOrderDetails>, Unit>() { // from class: ee.mtakso.driver.service.routing.AutoNavigationRoutingService$doStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<ActiveOrderDetails> it) {
                AutoNavigationManager autoNavigationManager;
                autoNavigationManager = AutoNavigationRoutingService.this.f25885c;
                Intrinsics.e(it, "it");
                autoNavigationManager.d(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ActiveOrderDetails> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.routing.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AutoNavigationRoutingService.k(Function1.this, obj);
            }
        };
        final AutoNavigationRoutingService$doStart$3 autoNavigationRoutingService$doStart$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.routing.AutoNavigationRoutingService$doStart$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        Disposable subscribe = map.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.routing.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AutoNavigationRoutingService.l(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …IfNeeded(it) }, {})\n    }");
        return subscribe;
    }
}
