package ee.mtakso.driver.service.restriction;

import ee.mtakso.driver.network.client.driver.DriverMightBeBlocked;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverBlockService.kt */
/* loaded from: classes3.dex */
public final class DriverBlockService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final DriverStatusProvider f25814b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverRestrictionManager f25815c;

    @Inject
    public DriverBlockService(DriverStatusProvider driverStatusProvider, DriverRestrictionManager driverRestrictionManager) {
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        Intrinsics.f(driverRestrictionManager, "driverRestrictionManager");
        this.f25814b = driverStatusProvider;
        this.f25815c = driverRestrictionManager;
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
        Observable h8 = ObservableExtKt.h(this.f25814b.h());
        final Function1<DriverMightBeBlocked, Unit> function1 = new Function1<DriverMightBeBlocked, Unit>() { // from class: ee.mtakso.driver.service.restriction.DriverBlockService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverMightBeBlocked it) {
                DriverRestrictionManager driverRestrictionManager;
                driverRestrictionManager = DriverBlockService.this.f25815c;
                Intrinsics.e(it, "it");
                driverRestrictionManager.c(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverMightBeBlocked driverMightBeBlocked) {
                b(driverMightBeBlocked);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.restriction.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverBlockService.i(Function1.this, obj);
            }
        };
        final DriverBlockService$doStart$2 driverBlockService$doStart$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.restriction.DriverBlockService$doStart$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "DriverRestrictionService");
            }
        };
        Disposable subscribe = h8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.restriction.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverBlockService.j(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …trictionService\")})\n    }");
        return subscribe;
    }
}
