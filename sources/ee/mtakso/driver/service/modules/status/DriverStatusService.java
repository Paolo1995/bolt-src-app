package ee.mtakso.driver.service.modules.status;

import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.BaseObservableServiceImpl;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.Subject;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverStatusService.kt */
/* loaded from: classes3.dex */
public final class DriverStatusService extends BaseObservableServiceImpl<Integer> {

    /* renamed from: c  reason: collision with root package name */
    private final PollerSource f25246c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverManager f25247d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public DriverStatusService(PollerSource poller, DriverManager driverManager) {
        super(null, 1, null);
        Intrinsics.f(poller, "poller");
        Intrinsics.f(driverManager, "driverManager");
        this.f25246c = poller;
        this.f25247d = driverManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<PollingSigned<PollingResult>> e8 = this.f25246c.e();
        final Function1<PollingSigned<PollingResult>, Unit> function1 = new Function1<PollingSigned<PollingResult>, Unit>() { // from class: ee.mtakso.driver.service.modules.status.DriverStatusService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PollingSigned<PollingResult> pollingSigned) {
                DriverManager driverManager;
                Subject f8;
                DriverStatus c8 = pollingSigned.a().c();
                driverManager = DriverStatusService.this.f25247d;
                driverManager.u(c8);
                f8 = DriverStatusService.this.f();
                f8.onNext(Integer.valueOf(pollingSigned.b()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PollingSigned<PollingResult> pollingSigned) {
                b(pollingSigned);
                return Unit.f50853a;
            }
        };
        Disposable subscribe = e8.subscribe(new Consumer() { // from class: ee.mtakso.driver.service.modules.status.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverStatusService.j(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …rint)\n            }\n    }");
        return subscribe;
    }
}
