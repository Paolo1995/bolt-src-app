package ee.mtakso.driver.service.workingtime;

import ee.mtakso.driver.network.client.work_time.DriverWorkTimeApi;
import ee.mtakso.driver.network.client.work_time.WorkingTimeInfo;
import ee.mtakso.driver.network.response.ServerResponse;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.RetryWithDelaySingle;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.driver.core.network.client.driver.DriverFeaturesConfig;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkingTimeManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class WorkingTimeManager {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f26196a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverWorkTimeApi f26197b;

    /* renamed from: c  reason: collision with root package name */
    private final PublishSubject<Optional<WorkingTimeInfo>> f26198c;

    /* renamed from: d  reason: collision with root package name */
    private Optional<WorkingTimeInfo> f26199d;

    /* renamed from: e  reason: collision with root package name */
    private Disposable f26200e;

    @Inject
    public WorkingTimeManager(DriverProvider driverProvider, DriverWorkTimeApi driverWorkTimeApi) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(driverWorkTimeApi, "driverWorkTimeApi");
        this.f26196a = driverProvider;
        this.f26197b = driverWorkTimeApi;
        PublishSubject<Optional<WorkingTimeInfo>> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<Optional<WorkingTimeInfo>>()");
        this.f26198c = e8;
        this.f26199d = Optional.a();
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

    public final Optional<WorkingTimeInfo> e() {
        return this.f26199d;
    }

    public final Observable<WorkingTimeInfo> f() {
        return ObservableExtKt.h(g());
    }

    public final Observable<Optional<WorkingTimeInfo>> g() {
        Observable<Optional<WorkingTimeInfo>> startWith = this.f26198c.startWith((PublishSubject<Optional<WorkingTimeInfo>>) this.f26199d);
        Intrinsics.e(startWith, "subject.startWith(workingTimeInfo)");
        return startWith;
    }

    public final void h() {
        if (!DisposableExtKt.b(this.f26200e)) {
            FastLog g8 = Kalev.f41674e.g();
            if (g8 != null) {
                FastLog.DefaultImpls.c(g8, "Working time info is fetching. Skipped update", null, 2, null);
            }
        } else if (this.f26196a.m().M() == DriverFeaturesConfig.WorkingTimeMode.DISABLED) {
        } else {
            Single<ServerResponse<WorkingTimeInfo>> F = this.f26197b.a().F(new RetryWithDelaySingle(3, 5000L));
            Intrinsics.e(F, "driverWorkTimeApi.getWor…WithDelaySingle(3, 5000))");
            Single d8 = SingleExtKt.d(F);
            final Function1<ServerResponse<WorkingTimeInfo>, Unit> function1 = new Function1<ServerResponse<WorkingTimeInfo>, Unit>() { // from class: ee.mtakso.driver.service.workingtime.WorkingTimeManager$updateWorkingTime$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(ServerResponse<WorkingTimeInfo> serverResponse) {
                    PublishSubject publishSubject;
                    FastLog g9 = Kalev.f41674e.g();
                    if (g9 != null) {
                        FastLog.DefaultImpls.a(g9, "Driver Fatigue - workingTimeInfo: " + serverResponse + ".data", null, 2, null);
                    }
                    WorkingTimeManager.this.f26199d = Optional.f(serverResponse.d());
                    publishSubject = WorkingTimeManager.this.f26198c;
                    publishSubject.onNext(WorkingTimeManager.this.e());
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ServerResponse<WorkingTimeInfo> serverResponse) {
                    b(serverResponse);
                    return Unit.f50853a;
                }
            };
            Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.workingtime.a
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    WorkingTimeManager.i(Function1.this, obj);
                }
            };
            final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.workingtime.WorkingTimeManager$updateWorkingTime$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable error) {
                    PublishSubject publishSubject;
                    publishSubject = WorkingTimeManager.this.f26198c;
                    publishSubject.onNext(Optional.a());
                    Intrinsics.e(error, "error");
                    Kalev.e(error, "Driver Fatigue - driverSettings: failed to fetch");
                }
            };
            this.f26200e = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.workingtime.b
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    WorkingTimeManager.j(Function1.this, obj);
                }
            });
        }
    }
}
