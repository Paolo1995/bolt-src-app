package ee.mtakso.driver.ui.interactor.driver;

import ee.mtakso.driver.network.client.settings.DriverDestination;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.WorkDistanceDelegate;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.modules.fifo.FifoQueueManager;
import ee.mtakso.driver.service.modules.fifo.FifoQueueState;
import ee.mtakso.driver.ui.interactor.driver.WorkRadius;
import ee.mtakso.driver.utils.Optional;
import eu.bolt.driver.core.network.client.driver.DriverAppConfig;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkRadiusInteractor.kt */
/* loaded from: classes3.dex */
public final class WorkRadiusInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f26521a;

    /* renamed from: b  reason: collision with root package name */
    private final WorkDistanceDelegate f26522b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverDestinationsManager f26523c;

    /* renamed from: d  reason: collision with root package name */
    private final FifoQueueManager f26524d;

    @Inject
    public WorkRadiusInteractor(DriverProvider driverProvider, WorkDistanceDelegate workDistanceDelegate, DriverDestinationsManager destinationsManager, FifoQueueManager fifoQueueManager) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(workDistanceDelegate, "workDistanceDelegate");
        Intrinsics.f(destinationsManager, "destinationsManager");
        Intrinsics.f(fifoQueueManager, "fifoQueueManager");
        this.f26521a = driverProvider;
        this.f26522b = workDistanceDelegate;
        this.f26523c = destinationsManager;
        this.f26524d = fifoQueueManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WorkRadius d(Function3 tmp0, Object obj, Object obj2, Object obj3) {
        Intrinsics.f(tmp0, "$tmp0");
        return (WorkRadius) tmp0.l(obj, obj2, obj3);
    }

    public final Observable<WorkRadius> c() {
        Observable<DriverAppConfig.MaxClientDistance> u7 = this.f26522b.u();
        Observable<Optional<DriverDestination>> F = this.f26523c.F();
        Observable<FifoQueueState> q8 = this.f26524d.q();
        final Function3<DriverAppConfig.MaxClientDistance, Optional<DriverDestination>, FifoQueueState, WorkRadius> function3 = new Function3<DriverAppConfig.MaxClientDistance, Optional<DriverDestination>, FifoQueueState, WorkRadius>() { // from class: ee.mtakso.driver.ui.interactor.driver.WorkRadiusInteractor$observeWorkRadius$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            /* renamed from: b */
            public final WorkRadius l(DriverAppConfig.MaxClientDistance radius, Optional<DriverDestination> destination, FifoQueueState fifoState) {
                DriverProvider driverProvider;
                Intrinsics.f(radius, "radius");
                Intrinsics.f(destination, "destination");
                Intrinsics.f(fifoState, "fifoState");
                driverProvider = WorkRadiusInteractor.this.f26521a;
                if (!driverProvider.n().R()) {
                    return WorkRadius.Disabled.f26519a;
                }
                if (fifoState instanceof FifoQueueState.InQueue) {
                    return WorkRadius.Disabled.f26519a;
                }
                if (destination.c() != null) {
                    return WorkRadius.Disabled.f26519a;
                }
                return new WorkRadius.Enabled(radius.b());
            }
        };
        Observable<WorkRadius> combineLatest = Observable.combineLatest(u7, F, q8, new io.reactivex.functions.Function3() { // from class: ee.mtakso.driver.ui.interactor.driver.m
            @Override // io.reactivex.functions.Function3
            public final Object a(Object obj, Object obj2, Object obj3) {
                WorkRadius d8;
                d8 = WorkRadiusInteractor.d(Function3.this, obj, obj2, obj3);
                return d8;
            }
        });
        Intrinsics.e(combineLatest, "fun observeWorkRadius():…    }\n            }\n    }");
        return combineLatest;
    }
}
