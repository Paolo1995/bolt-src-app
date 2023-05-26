package ee.mtakso.driver.service.modules.driverdestinations;

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

/* compiled from: DriverDestinationsService.kt */
/* loaded from: classes3.dex */
public final class DriverDestinationsService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final PollerSource f24653b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverDestinationsManager f24654c;

    @Inject
    public DriverDestinationsService(PollerSource poller, DriverDestinationsManager driverDestinationsManager) {
        Intrinsics.f(poller, "poller");
        Intrinsics.f(driverDestinationsManager, "driverDestinationsManager");
        this.f24653b = poller;
        this.f24654c = driverDestinationsManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(PollingResult pollingResult) {
        this.f24654c.N(pollingResult.b());
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<PollingSigned<PollingResult>> e8 = this.f24653b.e();
        final Function1<PollingSigned<PollingResult>, Unit> function1 = new Function1<PollingSigned<PollingResult>, Unit>() { // from class: ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PollingSigned<PollingResult> pollingSigned) {
                DriverDestinationsService.this.i(pollingSigned.a());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PollingSigned<PollingResult> pollingSigned) {
                b(pollingSigned);
                return Unit.f50853a;
            }
        };
        Disposable subscribe = e8.subscribe(new Consumer() { // from class: ee.mtakso.driver.service.modules.driverdestinations.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverDestinationsService.h(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …ngResult(it.data) }\n    }");
        return subscribe;
    }
}
