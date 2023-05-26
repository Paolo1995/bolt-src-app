package ee.mtakso.driver.service.modules.order.v2;

import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PollingAnalyticsService.kt */
/* loaded from: classes3.dex */
public final class PollingAnalyticsService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final PollerSource f25002b;

    /* renamed from: c  reason: collision with root package name */
    private final OrderTracker f25003c;

    @Inject
    public PollingAnalyticsService(PollerSource poller, OrderTracker orderTracker) {
        Intrinsics.f(poller, "poller");
        Intrinsics.f(orderTracker, "orderTracker");
        this.f25002b = poller;
        this.f25003c = orderTracker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PollingResult i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (PollingResult) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<PollingSigned<PollingResult>> e8 = this.f25002b.e();
        final PollingAnalyticsService$doStart$1 pollingAnalyticsService$doStart$1 = new Function1<PollingSigned<PollingResult>, PollingResult>() { // from class: ee.mtakso.driver.service.modules.order.v2.PollingAnalyticsService$doStart$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final PollingResult invoke(PollingSigned<PollingResult> it) {
                Intrinsics.f(it, "it");
                return it.a();
            }
        };
        Observable<R> map = e8.map(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.v0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PollingResult i8;
                i8 = PollingAnalyticsService.i(Function1.this, obj);
                return i8;
            }
        });
        final Function1<PollingResult, Unit> function1 = new Function1<PollingResult, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.PollingAnalyticsService$doStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PollingResult pollingResult) {
                OrderTracker orderTracker;
                orderTracker = PollingAnalyticsService.this.f25003c;
                Intrinsics.e(pollingResult, "pollingResult");
                orderTracker.a(pollingResult);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PollingResult pollingResult) {
                b(pollingResult);
                return Unit.f50853a;
            }
        };
        Disposable subscribe = map.subscribe(new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.w0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PollingAnalyticsService.j(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …sult)\n            }\n    }");
        return subscribe;
    }
}
