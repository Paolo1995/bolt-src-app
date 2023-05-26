package ee.mtakso.driver.service.b2b;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.driver.OrderSummary;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.b2b.B2bService;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: B2bService.kt */
/* loaded from: classes3.dex */
public final class B2bService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final PollerSource f23941b;

    /* renamed from: c  reason: collision with root package name */
    private final B2bManager f23942c;

    /* renamed from: d  reason: collision with root package name */
    private final List<OrderState> f23943d;

    @Inject
    public B2bService(PollerSource poller, B2bManager manager) {
        List<OrderState> n8;
        Intrinsics.f(poller, "poller");
        Intrinsics.f(manager, "manager");
        this.f23941b = poller;
        this.f23942c = manager;
        n8 = CollectionsKt__CollectionsKt.n(OrderState.ORDER_STATE_DRIVING_WITH_CLIENT, OrderState.ORDER_STATE_WAITING_ON_STOP, OrderState.ORDER_STATE_ARRIVED_TO_DESTINATION);
        this.f23943d = n8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(Boolean bool) {
        this.f23942c.h(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(List<OrderSummary> list) {
        OrderHandle orderHandle;
        Object obj;
        Object obj2;
        OrderHandle orderHandle2;
        boolean z7;
        if (list != null && list.size() > 1) {
            Iterator<T> it = list.iterator();
            while (true) {
                orderHandle = null;
                if (it.hasNext()) {
                    obj = it.next();
                    if (this.f23943d.contains(((OrderSummary) obj).f())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            OrderSummary orderSummary = (OrderSummary) obj;
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj2 = it2.next();
                    if (((OrderSummary) obj2).f() == OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION) {
                        z7 = true;
                        continue;
                    } else {
                        z7 = false;
                        continue;
                    }
                    if (z7) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            OrderSummary orderSummary2 = (OrderSummary) obj2;
            if (orderSummary != null) {
                orderHandle2 = orderSummary.b();
            } else {
                orderHandle2 = null;
            }
            if (orderSummary2 != null) {
                orderHandle = orderSummary2.b();
            }
            if (orderHandle2 != null && orderHandle != null) {
                this.f23942c.g(orderHandle2, orderHandle);
            }
        }
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<PollingSigned<PollingResult>> e8 = this.f23941b.e();
        final Function1<PollingSigned<PollingResult>, Unit> function1 = new Function1<PollingSigned<PollingResult>, Unit>() { // from class: ee.mtakso.driver.service.b2b.B2bService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PollingSigned<PollingResult> pollingSigned) {
                B2bService.this.j(pollingSigned.a().k());
                B2bService.this.k(pollingSigned.a().j());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PollingSigned<PollingResult> pollingSigned) {
                b(pollingSigned);
                return Unit.f50853a;
            }
        };
        Disposable subscribe = e8.subscribe(new Consumer() { // from class: d2.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                B2bService.i(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …ries)\n            }\n    }");
        return subscribe;
    }
}
