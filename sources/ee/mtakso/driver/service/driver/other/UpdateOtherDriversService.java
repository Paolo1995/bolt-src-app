package ee.mtakso.driver.service.driver.other;

import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.modules.surge.SurgeManager;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdateOtherDriversService.kt */
/* loaded from: classes3.dex */
public final class UpdateOtherDriversService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final OtherDriversManager f24344b;

    /* renamed from: c  reason: collision with root package name */
    private final SurgeManager f24345c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverFeatures f24346d;

    @Inject
    public UpdateOtherDriversService(OtherDriversManager manager, SurgeManager surgeManager, DriverFeatures driverFeatures) {
        Intrinsics.f(manager, "manager");
        Intrinsics.f(surgeManager, "surgeManager");
        Intrinsics.f(driverFeatures, "driverFeatures");
        this.f24344b = manager;
        this.f24345c = surgeManager;
        this.f24346d = driverFeatures;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<Long> interval = Observable.interval(5000L, 90000L, TimeUnit.MILLISECONDS);
        final Function1<Long, Boolean> function1 = new Function1<Long, Boolean>() { // from class: ee.mtakso.driver.service.driver.other.UpdateOtherDriversService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(Long it) {
                DriverFeatures driverFeatures;
                boolean z7;
                SurgeManager surgeManager;
                Intrinsics.f(it, "it");
                driverFeatures = UpdateOtherDriversService.this.f24346d;
                if (driverFeatures.K()) {
                    surgeManager = UpdateOtherDriversService.this.f24345c;
                    if (surgeManager.c()) {
                        z7 = false;
                        return Boolean.valueOf(z7);
                    }
                }
                z7 = true;
                return Boolean.valueOf(z7);
            }
        };
        Observable<Long> filter = interval.filter(new Predicate() { // from class: ee.mtakso.driver.service.driver.other.c
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean l8;
                l8 = UpdateOtherDriversService.l(Function1.this, obj);
                return l8;
            }
        });
        final Function1<Long, Unit> function12 = new Function1<Long, Unit>() { // from class: ee.mtakso.driver.service.driver.other.UpdateOtherDriversService$doStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Long l8) {
                OtherDriversManager otherDriversManager;
                otherDriversManager = UpdateOtherDriversService.this.f24344b;
                otherDriversManager.e();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                b(l8);
                return Unit.f50853a;
            }
        };
        Consumer<? super Long> consumer = new Consumer() { // from class: ee.mtakso.driver.service.driver.other.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateOtherDriversService.m(Function1.this, obj);
            }
        };
        final UpdateOtherDriversService$doStart$3 updateOtherDriversService$doStart$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.driver.other.UpdateOtherDriversService$doStart$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to schedule other drivers update");
            }
        };
        Disposable subscribe = filter.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.driver.other.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateOtherDriversService.n(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …te\")\n            })\n    }");
        return subscribe;
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl, ee.mtakso.driver.service.BaseService
    public boolean start() {
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.c(g8, "Starting other drivers updates", null, 2, null);
        }
        return super.start();
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl, ee.mtakso.driver.service.BaseService
    public void stop() {
        super.stop();
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.c(g8, "Stopping other drivers updates", null, 2, null);
        }
    }
}
