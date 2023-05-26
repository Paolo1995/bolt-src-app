package ee.mtakso.driver.service.modules.polling;

import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.driver.OrderSummary;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.modules.order.v2.OrderTracker;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PollingLoggerService.kt */
/* loaded from: classes3.dex */
public final class PollingLoggerService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final PollerSource f25130b;

    /* renamed from: c  reason: collision with root package name */
    private final OrderTracker f25131c;

    /* renamed from: d  reason: collision with root package name */
    private List<OrderSummary> f25132d;

    @Inject
    public PollingLoggerService(PollerSource poller, OrderTracker orderTracker) {
        Intrinsics.f(poller, "poller");
        Intrinsics.f(orderTracker, "orderTracker");
        this.f25130b = poller;
        this.f25131c = orderTracker;
    }

    private final OrderSummary h(List<OrderSummary> list, OrderState orderState) {
        boolean z7;
        OrderSummary orderSummary;
        boolean z8;
        OrderSummary orderSummary2;
        Object obj;
        boolean z9;
        Object obj2;
        boolean z10;
        if (list != null && !list.isEmpty()) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            return null;
        }
        List<OrderSummary> list2 = this.f25132d;
        if (list2 != null) {
            Iterator<T> it = list2.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj2 = it.next();
                    if (((OrderSummary) obj2).f() == orderState) {
                        z10 = true;
                        continue;
                    } else {
                        z10 = false;
                        continue;
                    }
                    if (z10) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            orderSummary = (OrderSummary) obj2;
        } else {
            orderSummary = null;
        }
        if (orderSummary != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (list != null) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj = it2.next();
                    if (((OrderSummary) obj).f() == orderState) {
                        z9 = true;
                        continue;
                    } else {
                        z9 = false;
                        continue;
                    }
                    if (z9) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            orderSummary2 = (OrderSummary) obj;
        } else {
            orderSummary2 = null;
        }
        if (z8 || orderSummary2 == null) {
            return null;
        }
        return orderSummary2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(PollingSigned<PollingResult> pollingSigned) {
        OrderSummary h8 = h(pollingSigned.a().j(), OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION);
        if (h8 != null) {
            this.f25131c.x(h8);
        }
        if (h(pollingSigned.a().j(), OrderState.ORDER_STATE_DRIVER_DID_NOT_RESPOND) != null) {
            this.f25131c.q();
        }
        this.f25132d = pollingSigned.a().j();
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<PollingSigned<PollingResult>> e8 = this.f25130b.e();
        final Function1<PollingSigned<PollingResult>, Unit> function1 = new Function1<PollingSigned<PollingResult>, Unit>() { // from class: ee.mtakso.driver.service.modules.polling.PollingLoggerService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PollingSigned<PollingResult> pollingResult) {
                PollingLoggerService pollingLoggerService = PollingLoggerService.this;
                Intrinsics.e(pollingResult, "pollingResult");
                pollingLoggerService.j(pollingResult);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PollingSigned<PollingResult> pollingSigned) {
                b(pollingSigned);
                return Unit.f50853a;
            }
        };
        Disposable subscribe = e8.subscribe(new Consumer() { // from class: ee.mtakso.driver.service.modules.polling.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PollingLoggerService.i(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …lt(pollingResult) }\n    }");
        return subscribe;
    }
}
