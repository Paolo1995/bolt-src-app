package ee.mtakso.driver.service.driver;

import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverStateService.kt */
/* loaded from: classes3.dex */
public final class DriverStateService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final DriverStatusProvider f24325b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverManager f24326c;

    @Inject
    public DriverStateService(DriverStatusProvider driverStatusProvider, DriverManager driverManager) {
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        Intrinsics.f(driverManager, "driverManager");
        this.f24325b = driverStatusProvider;
        this.f24326c = driverManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<DriverStatus> distinctUntilChanged = this.f24325b.g().distinctUntilChanged();
        final Function1<DriverStatus, Unit> function1 = new Function1<DriverStatus, Unit>() { // from class: ee.mtakso.driver.service.driver.DriverStateService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverStatus it) {
                DriverManager driverManager;
                driverManager = DriverStateService.this.f24326c;
                Intrinsics.e(it, "it");
                driverManager.v(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverStatus driverStatus) {
                b(driverStatus);
                return Unit.f50853a;
            }
        };
        Consumer<? super DriverStatus> consumer = new Consumer() { // from class: ee.mtakso.driver.service.driver.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverStateService.i(Function1.this, obj);
            }
        };
        final DriverStateService$doStart$2 driverStateService$doStart$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.driver.DriverStateService$doStart$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Driver status error");
            }
        };
        Disposable subscribe = distinctUntilChanged.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.driver.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverStateService.j(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …or\")\n            })\n    }");
        return subscribe;
    }
}
