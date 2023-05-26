package ee.mtakso.driver.service.modules.status;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.driver.DriverMightBeBlocked;
import ee.mtakso.driver.service.modules.status.GoOnlineStepResult;
import ee.mtakso.driver.service.restriction.EnvironmentDataProvider;
import ee.mtakso.driver.utils.flow.FlowStep;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoOnlineStartWorkingStep.kt */
/* loaded from: classes3.dex */
public final class GoOnlineStartWorkingStep implements FlowStep<GoOnlineStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final DriverClient f25272a;

    /* renamed from: b  reason: collision with root package name */
    private final double f25273b;

    /* renamed from: c  reason: collision with root package name */
    private final Long f25274c;

    /* renamed from: d  reason: collision with root package name */
    private final OrderHandle f25275d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f25276e;

    /* renamed from: f  reason: collision with root package name */
    private final EnvironmentDataProvider f25277f;

    public GoOnlineStartWorkingStep(DriverClient driverClient, double d8, Long l8, OrderHandle orderHandle, boolean z7, EnvironmentDataProvider environmentDataProvider) {
        Intrinsics.f(driverClient, "driverClient");
        Intrinsics.f(environmentDataProvider, "environmentDataProvider");
        this.f25272a = driverClient;
        this.f25273b = d8;
        this.f25274c = l8;
        this.f25275d = orderHandle;
        this.f25276e = z7;
        this.f25277f = environmentDataProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    private final Observable<String> f() {
        Observable<String> observeOn = Observable.fromCallable(new Callable() { // from class: ee.mtakso.driver.service.modules.status.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String g8;
                g8 = GoOnlineStartWorkingStep.g(GoOnlineStartWorkingStep.this);
                return g8;
            }
        }).observeOn(Schedulers.c());
        Intrinsics.e(observeOn, "fromCallable { environme…bserveOn(Schedulers.io())");
        return observeOn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g(GoOnlineStartWorkingStep this$0) {
        Intrinsics.f(this$0, "this$0");
        return this$0.f25277f.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<GoOnlineStepResult> h(String str) {
        Single<DriverMightBeBlocked> z7 = this.f25272a.z(this.f25273b, this.f25274c, this.f25275d, str);
        final GoOnlineStartWorkingStep$observeStartWorking$1 goOnlineStartWorkingStep$observeStartWorking$1 = new Function1<DriverMightBeBlocked, GoOnlineStepResult>() { // from class: ee.mtakso.driver.service.modules.status.GoOnlineStartWorkingStep$observeStartWorking$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final GoOnlineStepResult invoke(DriverMightBeBlocked it) {
                Intrinsics.f(it, "it");
                return new GoOnlineStepResult.StartWorking(it);
            }
        };
        Observable<GoOnlineStepResult> R = z7.x(new Function() { // from class: ee.mtakso.driver.service.modules.status.q
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                GoOnlineStepResult j8;
                j8 = GoOnlineStartWorkingStep.j(Function1.this, obj);
                return j8;
            }
        }).R();
        Intrinsics.e(R, "driverClient\n           …          .toObservable()");
        return R;
    }

    static /* synthetic */ Observable i(GoOnlineStartWorkingStep goOnlineStartWorkingStep, String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = "";
        }
        return goOnlineStartWorkingStep.h(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GoOnlineStepResult j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (GoOnlineStepResult) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<GoOnlineStepResult> call() {
        if (this.f25276e) {
            Observable<String> f8 = f();
            final Function1<String, ObservableSource<? extends GoOnlineStepResult>> function1 = new Function1<String, ObservableSource<? extends GoOnlineStepResult>>() { // from class: ee.mtakso.driver.service.modules.status.GoOnlineStartWorkingStep$call$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final ObservableSource<? extends GoOnlineStepResult> invoke(String environmentData) {
                    Observable h8;
                    Intrinsics.f(environmentData, "environmentData");
                    h8 = GoOnlineStartWorkingStep.this.h(environmentData);
                    return h8;
                }
            };
            Observable flatMap = f8.flatMap(new Function() { // from class: ee.mtakso.driver.service.modules.status.o
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource e8;
                    e8 = GoOnlineStartWorkingStep.e(Function1.this, obj);
                    return e8;
                }
            });
            Intrinsics.e(flatMap, "override fun call(): Obs…serveStartWorking()\n    }");
            return flatMap;
        }
        return i(this, null, 1, null);
    }
}
