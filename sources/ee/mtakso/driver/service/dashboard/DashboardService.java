package ee.mtakso.driver.service.dashboard;

import ee.mtakso.driver.network.client.dashboard.DashboardClient;
import ee.mtakso.driver.network.client.dashboard.DriverHomeScreenResponse;
import ee.mtakso.driver.service.ObservableService;
import ee.mtakso.driver.service.modules.polling.PollingRetryStrategy;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import ee.mtakso.driver.utils.polling.DynamicPoller;
import ee.mtakso.driver.utils.polling.RepeatStrategy;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DashboardService.kt */
/* loaded from: classes3.dex */
public final class DashboardService implements ObservableService<DriverHomeScreenResponse> {

    /* renamed from: a  reason: collision with root package name */
    private final DashboardClient f24267a;

    /* renamed from: b  reason: collision with root package name */
    private int f24268b;

    /* renamed from: c  reason: collision with root package name */
    private Disposable f24269c;

    /* renamed from: d  reason: collision with root package name */
    private final DynamicPoller<DriverHomeScreenResponse> f24270d;

    @Inject
    public DashboardService(PollingRetryStrategy retryStrategy, DashboardClient dashboardClient) {
        Intrinsics.f(retryStrategy, "retryStrategy");
        Intrinsics.f(dashboardClient, "dashboardClient");
        this.f24267a = dashboardClient;
        Callable callable = new Callable() { // from class: ee.mtakso.driver.service.dashboard.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                DriverHomeScreenResponse h8;
                h8 = DashboardService.h(DashboardService.this);
                return h8;
            }
        };
        RepeatStrategy<DriverHomeScreenResponse> repeatStrategy = new RepeatStrategy<DriverHomeScreenResponse>() { // from class: ee.mtakso.driver.service.dashboard.DashboardService$poller$2
            @Override // ee.mtakso.driver.utils.polling.RepeatStrategy
            /* renamed from: b */
            public long a(DriverHomeScreenResponse item) {
                Intrinsics.f(item, "item");
                Long c8 = item.c();
                if (c8 != null) {
                    return c8.longValue();
                }
                return -1L;
            }
        };
        PublishSubject e8 = PublishSubject.e();
        Intrinsics.e(e8, "create()");
        this.f24270d = new DynamicPoller<>(callable, repeatStrategy, retryStrategy, e8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverHomeScreenResponse h(DashboardService this$0) {
        Intrinsics.f(this$0, "this$0");
        return (DriverHomeScreenResponse) SingleExtKt.d(this$0.f24267a.e()).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.ObservableService
    public Observable<DriverHomeScreenResponse> c() {
        return this.f24270d.h();
    }

    public final void g() {
        this.f24270d.n();
        this.f24270d.l();
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        int i8 = this.f24268b;
        this.f24268b = i8 + 1;
        if (i8 > 0) {
            g();
            return this.f24270d.g();
        }
        if (DisposableExtKt.b(this.f24269c)) {
            Observable<Throwable> i9 = this.f24270d.i();
            final DashboardService$start$1 dashboardService$start$1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.dashboard.DashboardService$start$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.e(it, "it");
                    Kalev.e(it, "Failed to update dashboard");
                }
            };
            this.f24269c = i9.subscribe(new Consumer() { // from class: ee.mtakso.driver.service.dashboard.b
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    DashboardService.i(Function1.this, obj);
                }
            });
        }
        if (!this.f24270d.g()) {
            this.f24270d.l();
        }
        return this.f24270d.g();
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        int i8 = this.f24268b - 1;
        this.f24268b = i8;
        if (i8 > 0) {
            return;
        }
        Disposable disposable = this.f24269c;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        this.f24270d.n();
    }
}
