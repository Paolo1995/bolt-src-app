package ee.mtakso.driver.service.modules.fifo;

import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.DriverStatusKt;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoQueueService.kt */
/* loaded from: classes3.dex */
public final class FifoQueueService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final PollerSource f24748b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverStatusProvider f24749c;

    /* renamed from: d  reason: collision with root package name */
    private final FifoQueueManager f24750d;

    @Inject
    public FifoQueueService(PollerSource poller, DriverStatusProvider driverStatusProvider, FifoQueueManager manager) {
        Intrinsics.f(poller, "poller");
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        Intrinsics.f(manager, "manager");
        this.f24748b = poller;
        this.f24749c = driverStatusProvider;
        this.f24750d = manager;
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

    private final Observable<FifoQueuePollingState> l() {
        Observable<DriverStatus> g8 = this.f24749c.g();
        Observable<PollingSigned<PollingResult>> e8 = this.f24748b.e();
        final FifoQueueService$observePolling$1 fifoQueueService$observePolling$1 = new Function2<DriverStatus, PollingSigned<PollingResult>, FifoQueuePollingState>() { // from class: ee.mtakso.driver.service.modules.fifo.FifoQueueService$observePolling$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final FifoQueuePollingState s(DriverStatus driverStatus, PollingSigned<PollingResult> pollingState) {
                Intrinsics.f(driverStatus, "driverStatus");
                Intrinsics.f(pollingState, "pollingState");
                if (DriverStatusKt.b(driverStatus)) {
                    return new FifoQueuePollingState(pollingState.a().f(), pollingState.a().e());
                }
                return new FifoQueuePollingState(null, null);
            }
        };
        Observable combineLatest = Observable.combineLatest(g8, e8, new BiFunction() { // from class: ee.mtakso.driver.service.modules.fifo.k
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                FifoQueuePollingState m8;
                m8 = FifoQueueService.m(Function2.this, obj, obj2);
                return m8;
            }
        });
        Intrinsics.e(combineLatest, "combineLatest(\n         …          }\n            }");
        Observable<FifoQueuePollingState> distinctUntilChanged = ObservableExtKt.g(combineLatest).distinctUntilChanged();
        Intrinsics.e(distinctUntilChanged, "combineLatest(\n         …  .distinctUntilChanged()");
        return distinctUntilChanged;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FifoQueuePollingState m(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (FifoQueuePollingState) tmp0.s(obj, obj2);
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<FifoQueuePollingState> l8 = l();
        final Function1<FifoQueuePollingState, Unit> function1 = new Function1<FifoQueuePollingState, Unit>() { // from class: ee.mtakso.driver.service.modules.fifo.FifoQueueService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(FifoQueuePollingState it) {
                FifoQueueManager fifoQueueManager;
                fifoQueueManager = FifoQueueService.this.f24750d;
                Intrinsics.e(it, "it");
                fifoQueueManager.A(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FifoQueuePollingState fifoQueuePollingState) {
                b(fifoQueuePollingState);
                return Unit.f50853a;
            }
        };
        Consumer<? super FifoQueuePollingState> consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.fifo.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FifoQueueService.j(Function1.this, obj);
            }
        };
        final FifoQueueService$doStart$2 fifoQueueService$doStart$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.fifo.FifoQueueService$doStart$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable error) {
                Intrinsics.e(error, "error");
                Kalev.e(error, "FIFO queue service finished with error!!!");
            }
        };
        Disposable subscribe = l8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.fifo.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FifoQueueService.k(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …!\") }\n            )\n    }");
        return subscribe;
    }
}
