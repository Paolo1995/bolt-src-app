package ee.mtakso.driver.service;

import android.content.Context;
import android.os.Build;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.platform.core.PlatformType;
import ee.mtakso.driver.service.AwakeService;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.utils.AppForegroundState;
import ee.mtakso.driver.utils.BackgroundManager;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AwakeServiceLauncher.kt */
/* loaded from: classes3.dex */
public final class AwakeServiceLauncher extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final Context f23387b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverStatusProvider f23388c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverProvider f23389d;

    /* renamed from: e  reason: collision with root package name */
    private final BackgroundManager f23390e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f23391f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f23392g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f23393h;

    @Inject
    public AwakeServiceLauncher(Context context, DriverStatusProvider driverStatusProvider, DriverProvider driverProvider, BackgroundManager backgroundManager, PlatformManager platformManager) {
        boolean z7;
        boolean z8;
        Intrinsics.f(context, "context");
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(backgroundManager, "backgroundManager");
        Intrinsics.f(platformManager, "platformManager");
        this.f23387b = context;
        this.f23388c = driverStatusProvider;
        this.f23389d = driverProvider;
        this.f23390e = backgroundManager;
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 29) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f23391f = z7;
        if (i8 >= 30) {
            z8 = true;
        } else {
            z8 = false;
        }
        this.f23392g = z8;
        this.f23393h = platformManager.getType() == PlatformType.HMS;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l(DriverStatus driverStatus) {
        if (driverStatus == DriverStatus.ACTIVE_ORDER || driverStatus == DriverStatus.WAITING_ORDER) {
            return true;
        }
        if (driverStatus == DriverStatus.UNDEFINED && this.f23389d.d() != null && this.f23390e.d() == AppForegroundState.BACKGROUND) {
            if (this.f23392g) {
                return true;
            }
            if (this.f23393h && this.f23391f) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<DriverStatus> distinctUntilChanged = this.f23388c.g().distinctUntilChanged();
        final Function1<DriverStatus, Unit> function1 = new Function1<DriverStatus, Unit>() { // from class: ee.mtakso.driver.service.AwakeServiceLauncher$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverStatus it) {
                boolean l8;
                Context context;
                AwakeServiceLauncher awakeServiceLauncher = AwakeServiceLauncher.this;
                Intrinsics.e(it, "it");
                l8 = awakeServiceLauncher.l(it);
                if (l8) {
                    AwakeService.Companion companion = AwakeService.f23369p;
                    context = AwakeServiceLauncher.this.f23387b;
                    companion.b(context);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverStatus driverStatus) {
                b(driverStatus);
                return Unit.f50853a;
            }
        };
        Consumer<? super DriverStatus> consumer = new Consumer() { // from class: ee.mtakso.driver.service.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AwakeServiceLauncher.j(Function1.this, obj);
            }
        };
        final AwakeServiceLauncher$doStart$2 awakeServiceLauncher$doStart$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.AwakeServiceLauncher$doStart$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "AwakeServiceLauncher");
            }
        };
        Disposable subscribe = distinctUntilChanged.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AwakeServiceLauncher.k(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …er\")\n            })\n    }");
        return subscribe;
    }
}
