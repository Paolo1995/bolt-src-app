package ee.mtakso.driver.service.routing;

import android.content.Context;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.order.UpcomingStop;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.utils.BackgroundManager;
import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderAppRoutingService.kt */
/* loaded from: classes3.dex */
public final class OrderAppRoutingService extends BaseServiceImpl {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f25891e = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private final BackgroundManager f25892b;

    /* renamed from: c  reason: collision with root package name */
    private final OrderProvider f25893c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f25894d;

    /* compiled from: OrderAppRoutingService.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public OrderAppRoutingService(BackgroundManager backgroundManager, OrderProvider orderProvider, Context context) {
        Intrinsics.f(backgroundManager, "backgroundManager");
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(context, "context");
        this.f25892b = backgroundManager;
        this.f25893c = orderProvider;
        this.f25894d = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.s(obj, obj2)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n(List<UpcomingStop> list, List<UpcomingStop> list2) {
        boolean P;
        if (list.size() - list2.size() > 2) {
            return true;
        }
        P = CollectionsKt___CollectionsKt.P(list, (UpcomingStop) CollectionsKt___CollectionsKt.Y(list2));
        if (!P) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(OrderState orderState) {
        if (this.f25892b.f() && orderState != OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION) {
            this.f25892b.j(true);
            Context context = this.f25894d;
            context.startActivity(AppRoutingManager.f25869b.a(context));
        }
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable k8 = ObservableExtKt.k(this.f25893c.a(), new Function1<List<? extends OrderDetails>, ActiveOrderDetails>() { // from class: ee.mtakso.driver.service.routing.OrderAppRoutingService$doStart$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ActiveOrderDetails invoke(List<? extends OrderDetails> it) {
                Intrinsics.f(it, "it");
                return OrderProviderUtils.j(it);
            }
        });
        final Function2<ActiveOrderDetails, ActiveOrderDetails, Boolean> function2 = new Function2<ActiveOrderDetails, ActiveOrderDetails, Boolean>() { // from class: ee.mtakso.driver.service.routing.OrderAppRoutingService$doStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final Boolean s(ActiveOrderDetails old, ActiveOrderDetails activeOrderDetails) {
                boolean n8;
                Intrinsics.f(old, "old");
                Intrinsics.f(activeOrderDetails, "new");
                if (old.b() == activeOrderDetails.b()) {
                    n8 = OrderAppRoutingService.this.n(old.i().H(), activeOrderDetails.i().H());
                    if (n8) {
                        return Boolean.FALSE;
                    }
                }
                if (activeOrderDetails.q()) {
                    return Boolean.FALSE;
                }
                return Boolean.TRUE;
            }
        };
        Observable skip = k8.distinctUntilChanged(new BiPredicate() { // from class: ee.mtakso.driver.service.routing.d
            @Override // io.reactivex.functions.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                boolean k9;
                k9 = OrderAppRoutingService.k(Function2.this, obj, obj2);
                return k9;
            }
        }).skip(1L);
        final Function1<ActiveOrderDetails, Unit> function1 = new Function1<ActiveOrderDetails, Unit>() { // from class: ee.mtakso.driver.service.routing.OrderAppRoutingService$doStart$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ActiveOrderDetails activeOrderDetails) {
                OrderAppRoutingService.this.o(activeOrderDetails.b());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActiveOrderDetails activeOrderDetails) {
                b(activeOrderDetails);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.routing.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderAppRoutingService.l(Function1.this, obj);
            }
        };
        final OrderAppRoutingService$doStart$4 orderAppRoutingService$doStart$4 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.routing.OrderAppRoutingService$doStart$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Exception on OrderAppRoutingService!");
            }
        };
        Disposable subscribe = skip.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.routing.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderAppRoutingService.m(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …outingService!\") })\n    }");
        return subscribe;
    }
}
