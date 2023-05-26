package ee.mtakso.driver.service.order.details;

import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderUpdaterService.kt */
/* loaded from: classes3.dex */
public final class OrderUpdaterService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final PollerSource f25473b;

    /* renamed from: c  reason: collision with root package name */
    private final OrderManager f25474c;

    @Inject
    public OrderUpdaterService(PollerSource poller, OrderManager orderManager) {
        Intrinsics.f(poller, "poller");
        Intrinsics.f(orderManager, "orderManager");
        this.f25473b = poller;
        this.f25474c = orderManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<PollingSigned<PollingResult>> e8 = this.f25473b.e();
        final Function1<PollingSigned<PollingResult>, Unit> function1 = new Function1<PollingSigned<PollingResult>, Unit>() { // from class: ee.mtakso.driver.service.order.details.OrderUpdaterService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PollingSigned<PollingResult> pollingSigned) {
                OrderManager orderManager;
                orderManager = OrderUpdaterService.this.f25474c;
                orderManager.x(pollingSigned.a());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PollingSigned<PollingResult> pollingSigned) {
                b(pollingSigned);
                return Unit.f50853a;
            }
        };
        Disposable subscribe = e8.subscribe(new Consumer() { // from class: ee.mtakso.driver.service.order.details.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderUpdaterService.h(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …IfNeeded(it.data) }\n    }");
        return subscribe;
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl, ee.mtakso.driver.service.BaseService
    public void stop() {
        super.stop();
        this.f25474c.j();
    }
}
