package ee.mtakso.driver.service.modules.status;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.status.GoOnlineStepResult;
import ee.mtakso.driver.service.restriction.EnvironmentDataProvider;
import ee.mtakso.driver.utils.flow.Flow;
import ee.mtakso.driver.utils.flow.FlowStep;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoOnlineFlow.kt */
/* loaded from: classes3.dex */
public final class GoOnlineFlow extends Flow<GoOnlineStepResult> {

    /* renamed from: d  reason: collision with root package name */
    private final GeoLocationManager f25253d;

    /* renamed from: e  reason: collision with root package name */
    private final DriverClient f25254e;

    /* renamed from: f  reason: collision with root package name */
    private final DriverProvider f25255f;

    /* renamed from: g  reason: collision with root package name */
    private final EnvironmentDataProvider f25256g;

    /* renamed from: h  reason: collision with root package name */
    private double f25257h;

    /* renamed from: i  reason: collision with root package name */
    private Long f25258i;

    /* renamed from: j  reason: collision with root package name */
    private OrderHandle f25259j;

    @Inject
    public GoOnlineFlow(GeoLocationManager locationManager, DriverClient driverClient, DriverProvider driverProvider, EnvironmentDataProvider environmentDataProvider) {
        Intrinsics.f(locationManager, "locationManager");
        Intrinsics.f(driverClient, "driverClient");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(environmentDataProvider, "environmentDataProvider");
        this.f25253d = locationManager;
        this.f25254e = driverClient;
        this.f25255f = driverProvider;
        this.f25256g = environmentDataProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final GoOnlineLocationStep u() {
        return new GoOnlineLocationStep(this.f25253d);
    }

    private final GoOnlineStartWorkingStep v(double d8, Long l8, OrderHandle orderHandle) {
        return new GoOnlineStartWorkingStep(this.f25254e, d8, l8, orderHandle, this.f25255f.q().x(), this.f25256g);
    }

    private final FlowStep<GoOnlineStepResult> w(GoOnlineStepResult.LocationCheck locationCheck) {
        if (GoOnlineStepResultKt.b(locationCheck)) {
            return v(this.f25257h, this.f25258i, this.f25259j);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.utils.flow.Flow
    /* renamed from: t */
    public GoOnlineStepResult e(Throwable throwable) {
        Intrinsics.f(throwable, "throwable");
        return new GoOnlineStepResult.Error(throwable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.utils.flow.Flow
    /* renamed from: x */
    public FlowStep<GoOnlineStepResult> m(GoOnlineStepResult result) {
        Intrinsics.f(result, "result");
        if (result instanceof GoOnlineStepResult.LocationCheck) {
            return w((GoOnlineStepResult.LocationCheck) result);
        }
        if ((result instanceof GoOnlineStepResult.StartWorking) || (result instanceof GoOnlineStepResult.Error)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Observable<GoOnlineStepResult> y(double d8, Long l8, OrderHandle orderHandle) {
        FlowStep v7;
        this.f25257h = d8;
        this.f25258i = l8;
        this.f25259j = orderHandle;
        if (this.f25255f.q().G()) {
            v7 = u();
        } else {
            v7 = v(d8, l8, orderHandle);
        }
        Observable<GoOnlineStepResult> n8 = n(v7);
        final Function1<GoOnlineStepResult, Unit> function1 = new Function1<GoOnlineStepResult, Unit>() { // from class: ee.mtakso.driver.service.modules.status.GoOnlineFlow$start$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(GoOnlineStepResult goOnlineStepResult) {
                BehaviorSubject l9;
                l9 = GoOnlineFlow.this.l();
                l9.onNext(goOnlineStepResult);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GoOnlineStepResult goOnlineStepResult) {
                b(goOnlineStepResult);
                return Unit.f50853a;
            }
        };
        Observable<GoOnlineStepResult> doOnNext = n8.doOnNext(new Consumer() { // from class: ee.mtakso.driver.service.modules.status.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GoOnlineFlow.z(Function1.this, obj);
            }
        });
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.status.GoOnlineFlow$start$2
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
            public final void invoke2(Throwable th) {
                BehaviorSubject l9;
                l9 = GoOnlineFlow.this.l();
                l9.onError(th);
            }
        };
        Observable<GoOnlineStepResult> doOnError = doOnNext.doOnError(new Consumer() { // from class: ee.mtakso.driver.service.modules.status.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GoOnlineFlow.A(Function1.this, obj);
            }
        });
        Intrinsics.e(doOnError, "fun start(maxClientDista…bject.onError(it) }\n    }");
        return doOnError;
    }
}
