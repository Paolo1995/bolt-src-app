package ee.mtakso.driver.service.order.routing;

import android.app.Activity;
import com.google.android.gms.common.api.Api;
import ee.mtakso.driver.network.client.OrderHandleKt;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.driver.OrderSummary;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.home.v3.HomeFragment;
import ee.mtakso.driver.ui.screens.launch.LauncherActivity;
import ee.mtakso.driver.ui.screens.login.v2.LoginActivity;
import ee.mtakso.driver.ui.screens.order.finish.RideFinishActivity;
import ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderActivity;
import ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity;
import ee.mtakso.driver.ui.screens.signup.SignUpActivity;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderRoutingService.kt */
/* loaded from: classes3.dex */
public final class OrderRoutingService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final PollerSource f25501b;

    /* renamed from: c  reason: collision with root package name */
    private final RoutingManager f25502c;

    /* renamed from: d  reason: collision with root package name */
    private final IntentProvider f25503d;

    /* renamed from: e  reason: collision with root package name */
    private final IncomingOrderRoutingCoordinator f25504e;

    /* compiled from: OrderRoutingService.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25505a;

        static {
            int[] iArr = new int[OrderState.values().length];
            try {
                iArr[OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_ACCEPTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVING_WITH_CLIENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[OrderState.ORDER_STATE_WAITING_ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[OrderState.ORDER_STATE_ARRIVED_TO_DESTINATION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_DID_NOT_RESPOND.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_REJECTED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[OrderState.ORDER_STATE_FINISHED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[OrderState.ORDER_STATE_CLIENT_CANCELLED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[OrderState.ORDER_STATE_CLIENT_DID_NOT_SHOW.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[OrderState.ORDER_STATE_PAYMENT_BOOKING_FAILED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[OrderState.ORDER_STATE_UNKNOWN.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            f25505a = iArr;
        }
    }

    @Inject
    public OrderRoutingService(PollerSource poller, RoutingManager routingManager, IntentProvider intentProvider, IncomingOrderRoutingCoordinator incomingOrderRoutingCoordinator) {
        Intrinsics.f(poller, "poller");
        Intrinsics.f(routingManager, "routingManager");
        Intrinsics.f(intentProvider, "intentProvider");
        Intrinsics.f(incomingOrderRoutingCoordinator, "incomingOrderRoutingCoordinator");
        this.f25501b = poller;
        this.f25502c = routingManager;
        this.f25503d = intentProvider;
        this.f25504e = incomingOrderRoutingCoordinator;
    }

    private final RoutingCommand i(OrderSummary orderSummary) {
        Class<? extends Activity> cls;
        boolean a8;
        boolean a9;
        boolean a10;
        boolean a11;
        if (orderSummary == null) {
            RoutingState f8 = this.f25502c.f();
            if (f8 != null) {
                cls = f8.a();
            } else {
                cls = null;
            }
            boolean z7 = true;
            if (Intrinsics.a(cls, IncomingOrderActivity.class)) {
                a8 = true;
            } else {
                a8 = Intrinsics.a(cls, ActiveRideActivity.class);
            }
            if (a8) {
                a9 = true;
            } else {
                a9 = Intrinsics.a(cls, RideFinishActivity.class);
            }
            if (a9) {
                a10 = true;
            } else {
                a10 = Intrinsics.a(cls, LauncherActivity.class);
            }
            if (a10) {
                a11 = true;
            } else {
                a11 = Intrinsics.a(cls, LoginActivity.class);
            }
            if (!a11) {
                z7 = Intrinsics.a(cls, SignUpActivity.class);
            }
            if (!z7) {
                return null;
            }
            return new RoutingCommand.ActivityClass(new RoutingState(SimpleActivity.class, null, 2, null), SimpleActivity.class, SimpleActivity.Companion.d(SimpleActivity.f27004l, HomeFragment.class, null, false, 6, null), 536870912);
        }
        switch (WhenMappings.f25505a[orderSummary.f().ordinal()]) {
            case 1:
                return this.f25503d.a(orderSummary.b());
            case 2:
            case 3:
            case 4:
            case 5:
                return new RoutingCommand.ActivityClassBackground(new RoutingState(ActiveRideActivity.class, null, 2, null), ActiveRideActivity.class, OrderHandleKt.d(orderSummary.b()), 0, 8, null);
            case 6:
                return new RoutingCommand.ActivityClassBackground(new RoutingState(RideFinishActivity.class, null, 2, null), RideFinishActivity.class, OrderHandleKt.d(orderSummary.b()), 0, 8, null);
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return new RoutingCommand.ActivityClassBackground(new RoutingState(SimpleActivity.class, null, 2, null), SimpleActivity.class, OrderHandleKt.e(orderSummary.b(), SimpleActivity.Companion.d(SimpleActivity.f27004l, HomeFragment.class, null, false, 6, null)), 536870912);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final OrderSummary l(List<OrderSummary> list) {
        Object obj = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            obj = it.next();
            if (it.hasNext()) {
                int priority = ((OrderSummary) obj).f().getPriority();
                do {
                    Object next = it.next();
                    int priority2 = ((OrderSummary) next).f().getPriority();
                    if (priority > priority2) {
                        obj = next;
                        priority = priority2;
                    }
                } while (it.hasNext());
            }
        }
        return (OrderSummary) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(PollingResult pollingResult) {
        OrderState orderState;
        OrderSummary l8 = l(pollingResult.j());
        if (l8 != null) {
            orderState = l8.f();
        } else {
            orderState = null;
        }
        if (orderState != OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION) {
            this.f25504e.a();
        }
        RoutingCommand i8 = i(l8);
        if (i8 != null) {
            RoutingManager.d(this.f25502c, i8, false, 2, null);
        }
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<PollingSigned<PollingResult>> e8 = this.f25501b.e();
        final Function1<PollingSigned<PollingResult>, Unit> function1 = new Function1<PollingSigned<PollingResult>, Unit>() { // from class: ee.mtakso.driver.service.order.routing.OrderRoutingService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PollingSigned<PollingResult> pollingSigned) {
                OrderRoutingService.this.m(pollingSigned.a());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PollingSigned<PollingResult> pollingSigned) {
                b(pollingSigned);
                return Unit.f50853a;
            }
        };
        Consumer<? super PollingSigned<PollingResult>> consumer = new Consumer() { // from class: ee.mtakso.driver.service.order.routing.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderRoutingService.j(Function1.this, obj);
            }
        };
        final OrderRoutingService$doStart$2 orderRoutingService$doStart$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.order.routing.OrderRoutingService$doStart$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Order routing error");
            }
        };
        Disposable subscribe = e8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.order.routing.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderRoutingService.k(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …or\")\n            })\n    }");
        return subscribe;
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl, ee.mtakso.driver.service.BaseService
    public boolean start() {
        boolean start = super.start();
        if (start) {
            this.f25502c.g(Api.BaseClientBuilder.API_PRIORITY_OTHER, this.f25504e);
        }
        return start;
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl, ee.mtakso.driver.service.BaseService
    public void stop() {
        this.f25502c.h(Api.BaseClientBuilder.API_PRIORITY_OTHER, this.f25504e);
        super.stop();
    }
}
