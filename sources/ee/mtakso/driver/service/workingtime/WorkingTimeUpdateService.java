package ee.mtakso.driver.service.workingtime;

import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkingTimeUpdateService.kt */
/* loaded from: classes3.dex */
public final class WorkingTimeUpdateService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final DriverStatusProvider f26205b;

    /* renamed from: c  reason: collision with root package name */
    private final WorkingTimeManager f26206c;

    @Inject
    public WorkingTimeUpdateService(DriverStatusProvider driverStatusProvider, WorkingTimeManager workingTimeManager) {
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        Intrinsics.f(workingTimeManager, "workingTimeManager");
        this.f26205b = driverStatusProvider;
        this.f26206c = workingTimeManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<DriverStatus> g8 = this.f26205b.g();
        final WorkingTimeUpdateService$doStart$1 workingTimeUpdateService$doStart$1 = new Function1<DriverStatus, Boolean>() { // from class: ee.mtakso.driver.service.workingtime.WorkingTimeUpdateService$doStart$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(DriverStatus it) {
                boolean z7;
                Intrinsics.f(it, "it");
                if (it != DriverStatus.WAITING_ORDER && it != DriverStatus.INACTIVE) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<DriverStatus> throttleFirst = g8.filter(new Predicate() { // from class: ee.mtakso.driver.service.workingtime.c
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean j8;
                j8 = WorkingTimeUpdateService.j(Function1.this, obj);
                return j8;
            }
        }).throttleFirst(60L, TimeUnit.SECONDS);
        final Function1<DriverStatus, Unit> function1 = new Function1<DriverStatus, Unit>() { // from class: ee.mtakso.driver.service.workingtime.WorkingTimeUpdateService$doStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverStatus driverStatus) {
                WorkingTimeManager workingTimeManager;
                workingTimeManager = WorkingTimeUpdateService.this.f26206c;
                workingTimeManager.h();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverStatus driverStatus) {
                b(driverStatus);
                return Unit.f50853a;
            }
        };
        Consumer<? super DriverStatus> consumer = new Consumer() { // from class: ee.mtakso.driver.service.workingtime.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkingTimeUpdateService.k(Function1.this, obj);
            }
        };
        final WorkingTimeUpdateService$doStart$3 workingTimeUpdateService$doStart$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.workingtime.WorkingTimeUpdateService$doStart$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "WorkingTimeService - error");
            }
        };
        Disposable subscribe = throttleFirst.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.workingtime.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkingTimeUpdateService.l(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …or\")\n            })\n    }");
        return subscribe;
    }
}
